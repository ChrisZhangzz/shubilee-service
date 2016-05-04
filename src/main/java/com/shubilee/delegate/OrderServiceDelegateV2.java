package com.shubilee.delegate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shubilee.bean.ComputerGoodResult;
import com.shubilee.bean.ComputerResult;
import com.shubilee.bean.ErrorGoodsInfo;
import com.shubilee.common.BusinessComputing;
import com.shubilee.common.DateUtil;
import com.shubilee.common.DistrictCheck;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.entity.Activity;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.BonusVendor;
import com.shubilee.entity.Cart;
import com.shubilee.entity.DeliveryDetail;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.PurchaseInfo;
import com.shubilee.entity.ShopDistrictZipcode;
import com.shubilee.entity.TaxLookup;
import com.shubilee.entity.Token;
import com.shubilee.entity.TrackDetail;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.Users;
import com.shubilee.entity.Vendors;
import com.shubilee.entity.YmZipcode;
import com.shubilee.redis.entity.YmZipcodeRedis;
import com.shubilee.service.ActivityGiftService;
import com.shubilee.service.ActivityLookupService;
import com.shubilee.service.ActivityService;
import com.shubilee.service.BonusLookupService;
import com.shubilee.service.BonusTypeService;
import com.shubilee.service.CartRedisService;
import com.shubilee.service.CompositeQueryService;
import com.shubilee.service.GoodsCatService;
import com.shubilee.service.GoodsRedisService;
import com.shubilee.service.GoodsService;
import com.shubilee.service.OrderGenerateRedisService;
import com.shubilee.service.OrderGoodsService;
import com.shubilee.service.OrderInfoService;
import com.shubilee.service.ShippingService;
import com.shubilee.service.TaxLookupService;
import com.shubilee.service.UserService;
import com.shubilee.service.VendorsService;

@Service
public class OrderServiceDelegateV2 {

	@Autowired
	private CartRedisService cartRedisService;
	@Autowired
	private CartServiceDelegateV2 cartRedisServiceDelegate;
	@Autowired
	private OrderGenerateRedisService orderGenerateRedisService;
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsServiceDelegate goodsSeviceDelegate;
	@Autowired
	private ActivityGiftService activityGiftService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActivityLookupService activityLookupService;
	@Autowired
	private CompositeQueryService compositeQueryService;
	@Autowired
	private GoodsCatService goodsCatService;
	@Autowired
	private TransactionDelegate transactionDelegate;
	@Autowired
	private BonusLookupService bonusLookupService;
	@Autowired
	private ShippingService shippingService;
	@Autowired
	private UserService userService;
	@Autowired
	private TaxLookupService taxLookupService;
	@Autowired
	private VendorsService vendorsService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private OrderGoodsService orderGoodsService;
	@Autowired
	private UspsServiceDelegate uspsServiceDelegate;
	@Autowired
	private UpsServiceDelegate upsServiceDelegate;
	@Autowired
	private BonusTypeService bonusTypeService;
	@Autowired
	private GoodsRedisService goodsRedisService;
	/**
     * 提交订单
     * @param token
     * @throws Exception
     * @author James
     */
	public Map<String, Object> submitOrder(String token,String amount,String ip,String user_agent,int source_flag,Integer lang) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		//支付方式初始
		int type = 1;
		//成功状态标识初始
		int status = 1;
		 //1.提取用户信息
		 Users users= userService.selectUserInfoByUid(uid);
		//2.查询购物车信息
		 List<Cart> lstCart = cartRedisService.selectCartsForRedis(tokenIn);
			//1.1、如果购物车为空，直接发送返回值，不进行后续操作
			if(lstCart.size()==0){
				throw new YamiException(YamiConstant.ERRORCODE_ER1202,ErrorCodeEnum.ER1202.getMsg());
			}
		//3、提取临时ORDER信息
		  List<OrderGenerate> lstOrderGenerate= orderGenerateRedisService.selectAllForOrderGenerate(tokenIn);
		  
			  //3.1验证order_generate数据是否正确，并自动补充
			  for(Cart cart:lstCart){
				  boolean vendorOrderFlag = false; 
				  for(OrderGenerate orderGenerate:lstOrderGenerate){
					  if(cart.getVendor_id().intValue()==orderGenerate.getVendorId()){
						  vendorOrderFlag = true;  
					  }
				  }
				  if(!vendorOrderFlag){
					  OrderGenerate orderGenerate= new OrderGenerate();
					  orderGenerate.setPointFlag(0);
					  if(lstOrderGenerate.size()>0){
						  orderGenerate= lstOrderGenerate.get(0);
					  }
					  orderGenerate.setUserId(uid);
					  orderGenerate.setVendorId(cart.getVendor_id().intValue());
					  Vendors vendors = vendorsService.selectByPrimaryKey(cart.getVendor_id().intValue());
					  orderGenerate.setVendors(vendors);
					  orderGenerateRedisService.insert(tokenIn, StringUtil.formateOrederGenerateRedis(orderGenerate));
					  lstOrderGenerate.add(orderGenerate);
				  }
			  }
			  //3.2验证order_generate数据是否正确，并自动删除
//			  for(OrderGenerate orderGenerate:lstOrderGenerate){
			  for(int i=0;i<lstOrderGenerate.size();i++){ 
				  OrderGenerate orderGenerate = lstOrderGenerate.get(i);
				  boolean vendorOrderFlag = false; 
				  for(Cart cart:lstCart){
					  if(cart.getVendor_id().intValue()==orderGenerate.getVendorId()){
						  vendorOrderFlag = true;  
					  }
				  }
				  if(!vendorOrderFlag){
					  orderGenerateRedisService.delete(tokenIn, orderGenerate.getVendorId());
					  lstOrderGenerate.remove(i);
				  }
			  }
			  //3.3验证ORDER设置数据是否正确
			  UserAddress userAddress = new UserAddress();
			  for(OrderGenerate orderGenerate:lstOrderGenerate){
					//3.3.1配货方式判断
					if(orderGenerate.getShippingId()==null){
						throw new YamiException(YamiConstant.ERRORCODE_ER1108,ErrorCodeEnum.ER1108.getMsg());
					}
					
					
					if(orderGenerate.getVendorId().intValue()!=orderGenerate.getShipping().getVendorId()){
						throw new YamiException(YamiConstant.ERRORCODE_ER1108,ErrorCodeEnum.ER1108.getMsg());
					}
						
					//3.3.2收货地址判断
					if(orderGenerate.getShippingAdd()==null){
						throw new YamiException(YamiConstant.ERRORCODE_ER1106,ErrorCodeEnum.ER1106.getMsg());
					}else{
						userAddress = orderGenerate.getUserAddress();
						if(null!=userAddress){
							//收货地址中文校验
							if(StringUtil.isContainChinese(userAddress.getConsignee())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1630,ErrorCodeEnum.ER1630.getMsg());	
							}
							if(StringUtil.isContainChinese(userAddress.getConsignee_firstname())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1630,ErrorCodeEnum.ER1630.getMsg());	
							}
							if(StringUtil.isContainChinese(userAddress.getConsignee_lastname())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1630,ErrorCodeEnum.ER1630.getMsg());	
							}
							if(StringUtil.isContainChinese(userAddress.getAddress())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1631,ErrorCodeEnum.ER1631.getMsg());	
							}
							if(StringUtil.isContainChinese(userAddress.getAddress2())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1632,ErrorCodeEnum.ER1632.getMsg());	
							}
							if(StringUtil.isContainChinese(userAddress.getCountry())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1633,ErrorCodeEnum.ER1633.getMsg());	
							}
							if(StringUtil.isContainChinese(userAddress.getProvince())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1634,ErrorCodeEnum.ER1634.getMsg());	
							}
							if(StringUtil.isContainChinese(userAddress.getCity())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1635,ErrorCodeEnum.ER1635.getMsg());	
							}
							if(userAddress.getProvince().equals(YamiConstant.PROVINCE_ALASKA)||userAddress.getProvince().equals(YamiConstant.PROVINCE_HAWAII)){
								//校验该发货商是否支持阿拉斯加、夏威夷发货
								if(orderGenerate.getVendors().getAhFlag().intValue()==1){
									//校验是否选择正确配货方式
									if(orderGenerate.getShipping().getAhFlag()!=1){
										throw new YamiException(YamiConstant.ERRORCODE_ER1110,ErrorCodeEnum.ER1110.getMsg());
									}
								}else{
									throw new YamiException(YamiConstant.ERRORCODE_ER1111,ErrorCodeEnum.ER1111.getMsg());
								}
							}
							if(null==userAddress.getConsignee_firstname()||userAddress.getConsignee_firstname().trim().equals("")){
								throw new YamiException(YamiConstant.ERRORCODE_ER1627,ErrorCodeEnum.ER1627.getMsg());	
							}
							if(null==userAddress.getConsignee_lastname()||userAddress.getConsignee_lastname().trim().equals("")){
								throw new YamiException(YamiConstant.ERRORCODE_ER1626,ErrorCodeEnum.ER1626.getMsg());	
							}		
							if(null==userAddress.getAddress()||userAddress.getAddress().trim().equals("")){
								throw new YamiException(YamiConstant.ERRORCODE_ER1628,ErrorCodeEnum.ER1628.getMsg());	
							}
							if(null==userAddress.getCity()||userAddress.getCity().trim().equals("")){
								throw new YamiException(YamiConstant.ERRORCODE_ER1629,ErrorCodeEnum.ER1629.getMsg());	
							}
							if(null==userAddress.getZipcode()||!StringUtil.checkZipcode(userAddress.getZipcode())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1620,ErrorCodeEnum.ER1620.getMsg());	
							}else{
								if(!DistrictCheck.shippingDistrictCheck(userAddress.getZipcode(), orderGenerate.getShipping().getLstShippingDistrictZipcode())){
									throw new YamiException(YamiConstant.ERRORCODE_ER1643,ErrorCodeEnum.ER1643.getMsg(),orderGenerate.getVendors().getVendorName());		
								}
							}
							
							
							
							
							if(null==userAddress.getTel()){
								throw new YamiException(YamiConstant.ERRORCODE_ER1621,ErrorCodeEnum.ER1621.getMsg());	
							}
							if(null==userAddress.getEmail()||!StringUtil.checkEmail(userAddress.getEmail())){
								throw new YamiException(YamiConstant.ERRORCODE_ER1622,ErrorCodeEnum.ER1622.getMsg());	
							}
							if(StringUtil.filterChinese(userAddress.getConsignee_firstname()).length()!=0||StringUtil.filterChinese(userAddress.getConsignee_lastname()).length()!=0){
								throw new YamiException(YamiConstant.ERRORCODE_ER1624,ErrorCodeEnum.ER1624.getMsg());				
							}
							if(StringUtil.filterChinese(userAddress.getAddress()).length()!=0||StringUtil.filterChinese(userAddress.getAddress2()).length()!=0){
								throw new YamiException(YamiConstant.ERRORCODE_ER1625,ErrorCodeEnum.ER1625.getMsg());				
							}

						}else{
							throw new YamiException(YamiConstant.ERRORCODE_ER1106,ErrorCodeEnum.ER1106.getMsg());
						}
						
					}
					//3.3.3收货地址判断
					if(orderGenerate.getProfileId()==null){
						throw new YamiException(YamiConstant.ERRORCODE_ER1107,ErrorCodeEnum.ER1107.getMsg());
					}else{
						
						
						//3.3.3.1  PAYPAL支付方式
						if(orderGenerate.getProfileId().equals("0")){
							type = 2;
						}
						//3.3.3.2  银行卡支付方式
						else{
							type = 1;
							if(orderGenerate.getUserProfile()==null){
								throw new YamiException(YamiConstant.ERRORCODE_ER1107,ErrorCodeEnum.ER1107.getMsg());
							}
							if(orderGenerate.getUserProfile().getAddress()==null){
								throw new YamiException(YamiConstant.ERRORCODE_ER1109,ErrorCodeEnum.ER1109.getMsg());
							}else{
								//账单地址中文校验
								if(StringUtil.isContainChinese(orderGenerate.getUserProfile().getAddress().getConsignee())){
									throw new YamiException(YamiConstant.ERRORCODE_ER1636,ErrorCodeEnum.ER1636.getMsg());	
								}
								if(StringUtil.isContainChinese(orderGenerate.getUserProfile().getAddress().getConsignee_firstname())){
									throw new YamiException(YamiConstant.ERRORCODE_ER1636,ErrorCodeEnum.ER1636.getMsg());	
								}
								if(StringUtil.isContainChinese(orderGenerate.getUserProfile().getAddress().getAddress())){
									throw new YamiException(YamiConstant.ERRORCODE_ER1636,ErrorCodeEnum.ER1636.getMsg());	
								}
								if(StringUtil.isContainChinese(orderGenerate.getUserProfile().getAddress().getAddress())){
									throw new YamiException(YamiConstant.ERRORCODE_ER1637,ErrorCodeEnum.ER1637.getMsg());	
								}
								if(StringUtil.isContainChinese(orderGenerate.getUserProfile().getAddress().getAddress2())){
									throw new YamiException(YamiConstant.ERRORCODE_ER1638,ErrorCodeEnum.ER1638.getMsg());	
								}
								if(StringUtil.isContainChinese(orderGenerate.getUserProfile().getAddress().getCountry())){
									throw new YamiException(YamiConstant.ERRORCODE_ER1639,ErrorCodeEnum.ER1639.getMsg());	
								}
								if(StringUtil.isContainChinese(orderGenerate.getUserProfile().getAddress().getProvince())){
									throw new YamiException(YamiConstant.ERRORCODE_ER1640,ErrorCodeEnum.ER1640.getMsg());	
								}
								if(StringUtil.isContainChinese(orderGenerate.getUserProfile().getAddress().getCity())){
									throw new YamiException(YamiConstant.ERRORCODE_ER1641,ErrorCodeEnum.ER1641.getMsg());	
								}
								
								
							}
						}
					}
			  }
 
		//4、赠品处理
			//4.1、提取赠品活动信息
			  List<Activity> lstActivity =  activityService.selectActivity(Long.parseLong(DateUtil.getNowLong().toString()));
			//4.2、赠品信息处理
			    //3.2.1获取可以获得的赠品信息
				List<Map<String,Object>> lstMapTemp =  BusinessComputing.calculate_giftsV2(lstActivity,lstCart);
				//3.2.2处理数据库购物车中赠品数据，并同时更新缓存信息
				lstCart = cartRedisServiceDelegate.compare_gifts(tokenIn,lstMapTemp,lstCart);
		//5、折扣处理
			//5.1、提取折扣活动信息
				BonusType bonusType = null;
				if(null!=lstOrderGenerate.get(0).getBonusId()){
					bonusType =bonusTypeService.selectBonusType(lstOrderGenerate.get(0).getBonusId());
				}
		//6.验证价格、库存、上架、删除、限购
				int noGiftNum=0;
				ErrorGoodsInfo errorGoodsInfo = new ErrorGoodsInfo();
				List<ErrorGoodsInfo> lstErrorGoods = new ArrayList<ErrorGoodsInfo>();
				//6.1验证各商品、整合存在错误商品集合
				for(int i=0;i<lstCart.size();i++){
					Cart cart = lstCart.get(i);
					//只验证非赠品
					if(cart.getIs_gift()==0){
						
						//区域限购判断
						if(cart.getIsDistrict().intValue()==1){
							if(null!=userAddress){
								if(null!=userAddress.getZipcode()){
									List<ShopDistrictZipcode> lstShopZipcodeLimit = goodsSeviceDelegate.getGoodsZipLimit(cart.getGoods_id());
									if(!DistrictCheck.goodsDistrictCheck(userAddress.getZipcode(), lstShopZipcodeLimit)){
										errorGoodsInfo.setGoods_id(cart.getGoods_id());
										errorGoodsInfo.setGoods_name(cart.getGoods_name());
										errorGoodsInfo.setGoods_ename(cart.getGoods_ename());
										errorGoodsInfo.setError_message(ErrorCodeEnum.ER1117.getCMsg());
										errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1117.getEMsg());
										lstErrorGoods.add(errorGoodsInfo);
									}
								}
							}
						}
						
						
						
						//6.1.1、库存是否满足
						else if(cart.getGoods_number_stock()<cart.getGoods_number()){
							errorGoodsInfo.setGoods_id(cart.getGoods_id());
							errorGoodsInfo.setGoods_name(cart.getGoods_name());
							errorGoodsInfo.setGoods_ename(cart.getGoods_ename());
							errorGoodsInfo.setError_message(ErrorCodeEnum.ER1103.getCMsg());
							errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1103.getEMsg());
							lstErrorGoods.add(errorGoodsInfo);
						}

						//6.1.2.是否下架
						else if(!cart.getIsOnSale()){
							errorGoodsInfo.setGoods_id(cart.getGoods_id());
							errorGoodsInfo.setGoods_name(cart.getGoods_name());
							errorGoodsInfo.setGoods_ename(cart.getGoods_ename());
							errorGoodsInfo.setError_message(ErrorCodeEnum.ER1101.getCMsg());
							errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1101.getEMsg());
							lstErrorGoods.add(errorGoodsInfo);
						}
						//6.1.3.是否已删除
						else if(cart.getIsDelete()){
							errorGoodsInfo.setGoods_id(cart.getGoods_id());
							errorGoodsInfo.setGoods_name(cart.getGoods_name());
							errorGoodsInfo.setGoods_ename(cart.getGoods_ename());
							errorGoodsInfo.setError_message(ErrorCodeEnum.ER1101.getCMsg());
							errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1101.getEMsg());
							lstErrorGoods.add(errorGoodsInfo);
						}
						//6.1.4限购判断
						else if(cart.getIsLimited()){
							if(cart.getLimitedQuantity()>cart.getLimitedNumber()){
							    if(cart.getGoods_number()>cart.getLimitedNumber()){
							    	errorGoodsInfo.setGoods_id(cart.getGoods_id());
									errorGoodsInfo.setGoods_name(cart.getGoods_name());
									errorGoodsInfo.setGoods_ename(cart.getGoods_ename());
									errorGoodsInfo.setError_message(ErrorCodeEnum.ER1112.getCMsg());
									errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1112.getEMsg());
									lstErrorGoods.add(errorGoodsInfo);	
							    }
							}
							else{
								 if(cart.getGoods_number()>cart.getLimitedQuantity()){
									 errorGoodsInfo.setGoods_id(cart.getGoods_id());
									 errorGoodsInfo.setGoods_name(cart.getGoods_name());
									 errorGoodsInfo.setGoods_ename(cart.getGoods_ename());
									 errorGoodsInfo.setError_message(ErrorCodeEnum.ER1112.getCMsg());
									 errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1112.getEMsg());
									 lstErrorGoods.add(errorGoodsInfo);	
								 }
							}
						}
						//6.1.5验证商品单价是否与购物车一致
						if(StringUtil.checkPrice(cart)){
							if(!(cart.getGoods_price().compareTo(cart.getPromote_price_stock())==0)){
								cart.setGoods_price(cart.getPromote_price_stock());
								lstCart.set(i, cart);
								cartRedisService.update(tokenIn, StringUtil.formateCartRedis(cart));
							}
						}else{
							if(!(cart.getGoods_price().compareTo(cart.getShop_price_stock())==0)){
								cart.setGoods_price(cart.getShop_price_stock());
								lstCart.set(i, cart);
								cartRedisService.update(tokenIn, StringUtil.formateCartRedis(cart));					
							}
						}
						noGiftNum++;
					}
				}
				//6.5验证商品单价是否与购物车一致
				if(lstErrorGoods.size()>0){
					throw new YamiException(YamiConstant.ERRORCODE_ER1202,ErrorCodeEnum.ER1202.getMsg(),lstErrorGoods);
				}
				//6.6.购物车不能为空或，不能全部为赠品
				if(noGiftNum==0){
					throw new YamiException(YamiConstant.ERRORCODE_ER1202,ErrorCodeEnum.ER1202.getMsg());
				}
				//7、税率信息
				TaxLookup taxLookup = taxLookupService.selectTax(userAddress.getProvince(), userAddress.getZipcode());
			    //8、金额验证
				Map<String,Object> mapCheckOut = cartRedisServiceDelegate.integrateResult(token, lstOrderGenerate, lstCart, bonusType, taxLookup,users, 2);
				Double amountDB =Double.parseDouble(((Map<String,Object>)mapCheckOut.get("total")).get("amount").toString());

				
				
				List<ComputerGoodResult> lstComputerGoodResult = new  ArrayList<ComputerGoodResult>();
				if(null!=bonusType){
					 List<Vendors> lstBonusVendors = new ArrayList<Vendors>();
					  for(BonusVendor bonusVendor :bonusType.getLstBonusVendor()){
						  if(null!=bonusVendor.getVendorId()){
							  Vendors vendors = new Vendors();
							  vendors.setVendorId(bonusVendor.getVendorId());
							  lstBonusVendors.add(vendors);
						  }
					  }
					ComputerResult computerResult = BusinessComputing.countPromoPrice(bonusType, lstCart, lstBonusVendors);
					lstComputerGoodResult  = BusinessComputing.countTax(uid, lstCart, userAddress, taxLookup, computerResult.getComputerGoodResult()).getComputerGoodResult();
					for(ComputerGoodResult computerGoodResult:lstComputerGoodResult){
						//transactionDelegate.transactionUpdateDealPriceAndTax(uid, computerGoodResult.getGoods_id(), computerGoodResult.getTax(), computerGoodResult.getDeal_price());
						for(int i=0;i<lstCart.size();i++){
							Cart cart = lstCart.get(i);
							if(cart.getGoods_id().intValue()==computerGoodResult.getGoods_id().intValue()){
								cart.setDeal_price( computerGoodResult.getDeal_price());
								cart.setTax(computerGoodResult.getTax());
								lstCart.set(i, cart);
							}
						}
					}
				}else{
					ComputerResult computerResult = BusinessComputing.countPromoPrice(null, lstCart, null);
					lstComputerGoodResult  = BusinessComputing.countTax(uid, lstCart, userAddress, taxLookup,  computerResult.getComputerGoodResult()).getComputerGoodResult();
					for(ComputerGoodResult computerGoodResult:lstComputerGoodResult){
						//transactionDelegate.transactionUpdateDealPriceAndTax(uid, computerGoodResult.getGoods_id(), computerGoodResult.getTax(), computerGoodResult.getDeal_price());
						for(int i=0;i<lstCart.size();i++){
							Cart cart = lstCart.get(i);
							if(cart.getGoods_id().intValue()==computerGoodResult.getGoods_id().intValue()){
								cart.setDeal_price( computerGoodResult.getDeal_price());
								cart.setTax(computerGoodResult.getTax());
								lstCart.set(i, cart);
							}
						}
					}
				}
				//6.1重新提取购物车信息
			    int purchase_id = transactionDelegate.transactionOrderV2(uid, lstCart, lstOrderGenerate,mapCheckOut,bonusType,ip,user_agent,source_flag,lang); 
			result.put("status", status);
			result.put("type", type);
			result.put("amount", amountDB);
			result.put("purchase_id",purchase_id);
			
		return result;
	}
	
	/**
     * 提交订单版本2.0
     * @param token
     * @throws Exception
     * @author James
     */
	public Map<String, Object> finishOrder(String token,String purchase_id,String secret) throws Exception {

		if(!StringUtil.EncoderByMd5ForFinishOrder(YamiConstant.KEY_FINISHORDER_CHECK, purchase_id).equals(secret)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1113,ErrorCodeEnum.ER1113.getMsg());
		}
		
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int user_Id = Integer.parseInt(tokenIn.getData());
		int order_status = 0;
		int shipping_status = 0;
		int pay_status = 0;	
			//获取总订单信息(从WRITE数据库读入)
			PurchaseInfo purchaseInfo = transactionDelegate.transactionSelectOrderByPurchaseId(purchase_id);
			BigDecimal amount = new BigDecimal(0.00);
			
			List<Map<String,Object>> lstOrder = new ArrayList<Map<String,Object>>();
			Map<String,Object> mapOrder = new HashMap<String,Object>();
			Map<String,Object> mapItems = new HashMap<String,Object>();
			Map<Integer,Integer> mapGoodsStock = new HashMap<Integer,Integer>();
			Long point = new Long(0);
			for(OrderInfo orderInfo:purchaseInfo.getLstOrderInfo()){
				order_status = orderInfo.getOrderStatus();
				shipping_status = orderInfo.getShippingStatus();
				pay_status = orderInfo.getPayStatus();	
				mapOrder = new HashMap<String,Object>();
				mapOrder.put("order_id", orderInfo.getOrder_id());
				mapOrder.put("order_sn", orderInfo.getOrderSn());
				//状态发货中
				mapOrder.put("status", 1);
				mapOrder.put("amount", orderInfo.getOrderAmount());
				Vendors vendor = vendorsService.selectByPrimaryKey(orderInfo.getVendorId());
				Map<String,Object> mapVendor = new HashMap<String,Object>();
				mapVendor.put("vendor_id", vendor.getVendorId());
				mapVendor.put("vendor_name", vendor.getVendorName());
				mapVendor.put("vendor_ename", vendor.getVendorEname());
				mapOrder.put("vendor", mapVendor);
				List<OrderGoods> lstGoods = orderInfo.getLstOrderGoods();
				//判断各商品库存是否满足
				for(OrderGoods orderGoodsTemp:lstGoods){
//						if(orderGoodsTemp.getGoodsNumber()>orderGoodsTemp.getGoodsNumberOnscoke()){
//							mapGoodsStock.put(orderGoodsTemp.getGoodsId(), 0);
//						}else{
//							mapGoodsStock.put(orderGoodsTemp.getGoodsId(), orderGoodsTemp.getGoodsNumber().intValue());
//						}
						mapGoodsStock.put(orderGoodsTemp.getGoodsId(), orderGoodsTemp.getGoodsNumber().intValue());
				}
				//需要扣除积分
				point= point + orderInfo.getIntegral();

				
				
				mapItems = new HashMap<String,Object>();
				int count = 0;
				int points_get = 0;
				List<String> lstImage = new ArrayList<String>();
				for(OrderGoods orderGoods:lstGoods){
					points_get = points_get + orderGoods.getGiveIntegral().multiply(BigDecimal.valueOf(Long.parseLong(orderGoods.getGoodsNumber().toString()))).intValue();
					count = count + orderGoods.getGoodsNumber();
					lstImage.add(YamiConstant.IMAGE_URL+orderGoods.getGoodsThumb());
				}
				mapOrder.put("points_get", points_get);
				mapItems.put("count", count);
				
				mapItems.put("images", lstImage);
				mapOrder.put("items", mapItems);
				
				amount = amount.add(orderInfo.getOrderAmount());
				lstOrder.add(mapOrder);
			}
			Map<String,Object> mapPurchase = new HashMap<String,Object>();
			mapPurchase.put("purchase_id", purchase_id);
			mapPurchase.put("amount",  amount);
			mapPurchase.put("currency", "$");
			mapPurchase.put("orders",  lstOrder);
			result.put("purchase",  mapPurchase);

			
		
			//更改订单状态,删除购物信息,删除临时ORDER信息
			if(order_status==1&&shipping_status==0&&pay_status==0){
				transactionDelegate.transactionFinishOrderV2(tokenIn, purchaseInfo,mapGoodsStock,point);
			}
		return result;
	}
	
	/**
     * 查询订单物流信息
     * @param token
     * @throws Exception
     * @author James
     */
	public Map<String, Object> getOrderTracking(String token, int order_id) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();
		OrderInfo orderInfo = orderInfoService.selectInvoiceNoByOrderId(order_id);
		if(orderInfo==null)
		{
			throw new YamiException(YamiConstant.ERRORCODE_ER1452,
					ErrorCodeEnum.ER1452.getMsg());
		}		
		String trackingNo = orderInfo.getInvoiceNo();
		Integer payTime = orderInfo.getPayTime();
		String ShippingMethod = orderInfo.getShippingMethod();
		if(null!= ShippingMethod && ShippingMethod.startsWith("GES")){
			result.put("tracking_number", trackingNo);
			TrackDetail[] activitys = new TrackDetail[1];
			TrackDetail activity = new TrackDetail();
			DeliveryDetail uspsDeliveryDetail = new DeliveryDetail();
			activity.setStatus("In Transit");
			activity.setTime(DateUtil.formateUTC2Time(payTime));
			activity.setDate(DateUtil.formateUTC(payTime));
			activitys[0]=activity;
			DateUtil.formateUTC(payTime);
			result.put("delivery", uspsDeliveryDetail);
			result.put("track", activitys);
		}else{
		if(trackingNo==null || trackingNo.equals(YamiConstant.STRING_EMPTY))
		{
			throw new YamiException(YamiConstant.ERRORCODE_ER1453,
					ErrorCodeEnum.ER1453.getMsg());
		}
		trackingNo = trackingNo.trim();
		if (trackingNo.startsWith("9")) {
			result = uspsServiceDelegate.uspsTrackingService(trackingNo);
		} else {
			result = upsServiceDelegate.upsTrackingService(trackingNo);
		}
		}
		result.put("token", token);
		return result;

	}
}
