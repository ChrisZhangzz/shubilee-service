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
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityGift;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.BonusVendor;
import com.shubilee.entity.Cart;
import com.shubilee.entity.DeliveryDetail;
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.PurchaseInfo;
import com.shubilee.entity.TaxLookup;
import com.shubilee.entity.Token;
import com.shubilee.entity.TrackDetail;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.Users;
import com.shubilee.entity.Vendors;
import com.shubilee.service.ActivityGiftService;
import com.shubilee.service.ActivityLookupService;
import com.shubilee.service.ActivityService;
import com.shubilee.service.BonusLookupService;
import com.shubilee.service.BonusTypeService;
import com.shubilee.service.CartService;
import com.shubilee.service.CompositeQueryService;
import com.shubilee.service.GoodsCatService;
import com.shubilee.service.GoodsService;
import com.shubilee.service.OrderGenerateService;
import com.shubilee.service.OrderGoodsService;
import com.shubilee.service.OrderInfoService;
import com.shubilee.service.ShippingService;
import com.shubilee.service.TaxLookupService;
import com.shubilee.service.UserService;
import com.shubilee.service.VendorsService;

@Service
public class OrderServiceDelegate {

	@Autowired
	private CartService cartService;
	@Autowired
	private GoodsService goodsService;
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
	private OrderGenerateService orderGenerateService;
	@Autowired
	private CartServiceDelegateV1 cartServiceDelegateV1;
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
	/**
     * 提交订单
     * @param token
     * @throws Exception
     * @author James
     */
	public Map<String, Object> submitOrder(String token,String amount,String ip,String user_agent,int source_flag) throws Exception {
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int user_Id = Integer.parseInt(tokenIn.getData());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("token", token);
		int type = 1;
		int status = 1;
		//1、检查订单基础设置信息
		List<OrderGenerate> lstOrderGenerate = orderGenerateService.selectOrderGenerateByUserId(user_Id);
		OrderGenerate orderGenerateTempForStepNext = new OrderGenerate();
		for(OrderGenerate orderGenerate:lstOrderGenerate){
			//判断order_generate数据是否正确
			List<Cart> lstCartTemp = cartService.selectCartsByUseridAndVendorId(user_Id, orderGenerate.getVendorId());
			if(lstCartTemp.size()==0){
				transactionDelegate.transactionDelOrderGenerateByUIdAndVendorId(user_Id,  orderGenerate.getVendorId());
			}else{
				orderGenerateTempForStepNext = orderGenerate;	
			}
			//配货方式判断
			if(orderGenerate.getShippingId()==null){
				throw new YamiException(YamiConstant.ERRORCODE_ER1108,ErrorCodeEnum.ER1108.getMsg());
			}
			//收货地址判断
			if(orderGenerate.getShippingAdd()==null){

				throw new YamiException(YamiConstant.ERRORCODE_ER1106,ErrorCodeEnum.ER1106.getMsg());
			}else{
				UserAddress userAddress = userService.getAddressBookByAddId(orderGenerate.getShippingAdd());
				if(null!=userAddress){
					if(userAddress.getProvince().equals(YamiConstant.PROVINCE_ALASKA)||userAddress.getProvince().equals(YamiConstant.PROVINCE_HAWAII)){
						if(orderGenerate.getShippingId()!=YamiConstant.SHIPPING_ID_ALASKAHAWAII){
							throw new YamiException(YamiConstant.ERRORCODE_ER1110,ErrorCodeEnum.ER1110.getMsg());	
						}
						
					}else{
						if(orderGenerate.getShippingId()==YamiConstant.SHIPPING_ID_ALASKAHAWAII){
							throw new YamiException(YamiConstant.ERRORCODE_ER1114,ErrorCodeEnum.ER1114.getMsg());	
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
			//支付方式判断
			if(orderGenerate.getProfileId()==null){
				throw new YamiException(YamiConstant.ERRORCODE_ER1107,ErrorCodeEnum.ER1107.getMsg());
			}else{
				if(orderGenerate.getProfileId().equals("0")){
					type = 2;
				}
				else{
					type = 1;
				}
				
			}
			
			
			
			
			
		}
		lstOrderGenerate = orderGenerateService.selectOrderGenerateByUserId(user_Id);
		
		//2、提取购物车信息
		List<Cart> lstCart = cartService.selectCartsByUserid(user_Id);
		
		
		//3.赠品业务处理
			//3.1计算购物车对应应获得的赠品信息
			List<Goods> lstGift = statActivity(lstCart);
			//3.2更新购物车原有购物车中的赠品数据
			transactionDelegate.transactionUpdateCartAct(tokenIn,lstGift);
		//4、库存、上架、删除验证
			//4.1重新提取购物车信息
			//lstCart = cartService.selectCartsByUserid(user_Id);
			List<Goods> lstGoods = new ArrayList<Goods>();
			int noGiftNum=0;
			ErrorGoodsInfo errorGoodsInfo = new ErrorGoodsInfo();
			List<ErrorGoodsInfo> lstErrorGoods = new ArrayList<ErrorGoodsInfo>();
			for(Cart goodsOfCart:lstCart){
				Goods goods = goodsService.selectByPrimaryKey(goodsOfCart.getGoods_id());
//				errorGoodsInfo = new ErrorGoodsInfo();
				//只验证非赠品
				if(goodsOfCart.getIs_gift()==0){
					//4.1.库存是否满足
					if(goods.getGoodsNumber()<goodsOfCart.getGoods_number()){
//												String errorMessage[] = new String[2];
//												errorMessage[0] = goods.getGoodsEname() + ":" + ErrorCodeEnum.ER1103.getEMsg();
//												errorMessage[1] = goods.getGoodsName() + ":" + ErrorCodeEnum.ER1103.getCMsg();
//												throw new YamiException(YamiConstant.ERRORCODE_ER1103,errorMessage);
						errorGoodsInfo.setGoods_id(goods.getGoodsId());
						errorGoodsInfo.setGoods_name(goods.getGoodsName());
						errorGoodsInfo.setGoods_ename(goods.getGoodsEname());
						errorGoodsInfo.setError_message(ErrorCodeEnum.ER1103.getCMsg());
						errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1103.getEMsg());
						lstErrorGoods.add(errorGoodsInfo);
					}

					//4.2.是否下架
					else if(!goods.getIsOnSale()){
//						String errorMessage[] = new String[2];
//						errorMessage[0] = goods.getGoodsEname() + ":" + ErrorCodeEnum.ER1101.getEMsg();
//						errorMessage[1] = goods.getGoodsName() + ":" + ErrorCodeEnum.ER1101.getCMsg();
//						throw new YamiException(YamiConstant.ERRORCODE_ER1101,errorMessage);
						errorGoodsInfo.setGoods_id(goods.getGoodsId());
						errorGoodsInfo.setGoods_name(goods.getGoodsName());
						errorGoodsInfo.setGoods_ename(goods.getGoodsEname());
						errorGoodsInfo.setError_message(ErrorCodeEnum.ER1101.getCMsg());
						errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1101.getEMsg());
						lstErrorGoods.add(errorGoodsInfo);
					}
					//4.3.是否已删除
					else if(goods.getIsDelete()){
//												String errorMessage[] = new String[2];
//												errorMessage[0] = goods.getGoodsEname() + ":" + ErrorCodeEnum.ER1101.getEMsg();
//												errorMessage[1] = goods.getGoodsName() + ":" + ErrorCodeEnum.ER1101.getCMsg();
//												throw new YamiException(YamiConstant.ERRORCODE_ER1101,errorMessage);
						errorGoodsInfo.setGoods_id(goods.getGoodsId());
						errorGoodsInfo.setGoods_name(goods.getGoodsName());
						errorGoodsInfo.setGoods_ename(goods.getGoodsEname());
						errorGoodsInfo.setError_message(ErrorCodeEnum.ER1101.getCMsg());
						errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1101.getEMsg());
						lstErrorGoods.add(errorGoodsInfo);
					}
					//4.5限购判断
					else if(goods.getIsLimited()){
						if(goods.getLimitedQuantity()>goods.getLimitedNumber()){
						    if(goodsOfCart.getGoods_number()>goods.getLimitedNumber()){
//								String errorMessage[] = new String[2];
//								errorMessage[0] = goods.getGoodsEname() + ":" + ErrorCodeEnum.ER1112.getEMsg();
//								errorMessage[1] = goods.getGoodsName() + ":" + ErrorCodeEnum.ER1112.getCMsg();
//								throw new YamiException(YamiConstant.ERRORCODE_ER1101,errorMessage);
								errorGoodsInfo.setGoods_id(goods.getGoodsId());
								errorGoodsInfo.setGoods_name(goods.getGoodsName());
								errorGoodsInfo.setGoods_ename(goods.getGoodsEname());
								errorGoodsInfo.setError_message(ErrorCodeEnum.ER1112.getCMsg());
								errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1112.getEMsg());
								lstErrorGoods.add(errorGoodsInfo);	
						    }
						}
						else{
							 if(goodsOfCart.getGoods_number()>goods.getLimitedQuantity()){
//									String errorMessage[] = new String[2];
//									errorMessage[0] = goods.getGoodsEname() + ":" + ErrorCodeEnum.ER1112.getEMsg();
//									errorMessage[1] = goods.getGoodsName() + ":" + ErrorCodeEnum.ER1112.getCMsg();
//									throw new YamiException(YamiConstant.ERRORCODE_ER1101,errorMessage);
									errorGoodsInfo.setGoods_id(goods.getGoodsId());
									errorGoodsInfo.setGoods_name(goods.getGoodsName());
									errorGoodsInfo.setGoods_ename(goods.getGoodsEname());
									errorGoodsInfo.setError_message(ErrorCodeEnum.ER1112.getCMsg());
									errorGoodsInfo.setError_emessage(ErrorCodeEnum.ER1112.getEMsg());
									lstErrorGoods.add(errorGoodsInfo);	
							 }
						}
					}
					
					//4.4验证商品单价是否与购物车一致
					
					if(StringUtil.checkPrice(goods)){
						if(!(goodsOfCart.getGoods_price().compareTo(goods.getPromotePrice())==0)){
							transactionDelegate.transactionUpdateGoodPriceOfCart(goodsOfCart.getRec_id(),goods.getPromotePrice());
						}
					}else{
						if(!(goodsOfCart.getGoods_price().compareTo(goods.getShopPrice())==0)){
							transactionDelegate.transactionUpdateGoodPriceOfCart(goodsOfCart.getRec_id(),goods.getShopPrice());						
						}
					}
					noGiftNum++;
				}
				lstGoods.add(goods);
			}
			
			if(lstErrorGoods.size()>0){
				throw new YamiException(YamiConstant.ERRORCODE_ER1202,ErrorCodeEnum.ER1202.getMsg(),lstErrorGoods);
			}
			//4.4.购物车不能为空或，不能全部为赠品
			if(noGiftNum==0){
				throw new YamiException(YamiConstant.ERRORCODE_ER1202,ErrorCodeEnum.ER1202.getMsg());
			}
			
			//4.1重新提取购物车信息
			lstCart = cartService.selectCartsByUserid(user_Id);
		    //5、处理订单数据
		    Map<String,Object> mapViewCart = cartServiceDelegateV1.viewCart(token, 0);	
		    //6、金额验证
			Map<String,Object> mapCheckOut = cartServiceDelegateV1.checkout(token,0);
			Double amountDB =Double.parseDouble(((Map<String,Object>)mapCheckOut.get("total")).get("amount").toString());
		    
			//判断是否使用了折扣码，提取折扣码对应活动信息
			Map<Integer,Vendors> mapVendorBonus = new HashMap<Integer,Vendors>();
			List<BonusLookup> lstBonusLookup = new ArrayList<BonusLookup>();
			List<Vendors> lstVendorBonus = new ArrayList<Vendors>();
			BonusType bonusType=null;
			if(null!=orderGenerateTempForStepNext.getBonusId()){
				bonusType = compositeQueryService.selectBonusByBonusId(orderGenerateTempForStepNext.getBonusId());
				lstBonusLookup = bonusLookupService.selectBonusLookupByTypeId(bonusType.getTypeId());
				bonusType.setLstBonusLookup(lstBonusLookup);
				lstVendorBonus = bonusLookupService.selectVendorByBonusTypeId(bonusType.getTypeId());
				for(Vendors vendors:lstVendorBonus){
					mapVendorBonus.put(vendors.getVendorId(), vendors);
				}
			}
			UserAddress address = userService.getAddressBookByAddId(orderGenerateTempForStepNext.getShippingAdd());
			TaxLookup taxLookup = taxLookupService.selectTax(address.getProvince(), address.getZipcode());
			List<ComputerGoodResult> lstComputerGoodResult = new  ArrayList<ComputerGoodResult>();
			if(null!=bonusType){
				ComputerResult computerResult = BusinessComputing.countPromoPrice(bonusType, lstCart, lstVendorBonus);
				lstComputerGoodResult  = BusinessComputing.countTax(user_Id, lstCart, address, taxLookup, computerResult.getComputerGoodResult()).getComputerGoodResult();
				for(ComputerGoodResult computerGoodResult:lstComputerGoodResult){
					transactionDelegate.transactionUpdateDealPriceAndTax(user_Id, computerGoodResult.getGoods_id(), computerGoodResult.getTax(), computerGoodResult.getDeal_price());
				}
			}else{
				ComputerResult computerResult = BusinessComputing.countPromoPrice(null, lstCart, lstVendorBonus);
				lstComputerGoodResult  = BusinessComputing.countTax(user_Id, lstCart, address, taxLookup,  computerResult.getComputerGoodResult()).getComputerGoodResult();
				for(ComputerGoodResult computerGoodResult:lstComputerGoodResult){
					transactionDelegate.transactionUpdateDealPriceAndTax(user_Id, computerGoodResult.getGoods_id(), computerGoodResult.getTax(), computerGoodResult.getDeal_price());
				}
			}
			//6.1重新提取购物车信息
			lstCart = cartService.selectCartsByUserid(user_Id);
		    int purchase_id = transactionDelegate.transactionOrder(user_Id, lstCart, lstGoods, lstOrderGenerate, (Map<String,Object>)mapCheckOut.get("total"), mapViewCart,ip,user_agent,source_flag); 
		result.put("status", status);
		result.put("type", type);
		result.put("amount", amountDB);
		result.put("purchase_id",purchase_id);
		
		return result;
	}
	
	
	
	
	
	
	
	/**
     * 提交订单
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
			//获取总订单信息
			PurchaseInfo purchaseInfo = orderInfoService.selectOrderByPurchaseId(Integer.parseInt(purchase_id));
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
						if(orderGoodsTemp.getGoodsNumber()>orderGoodsTemp.getGoodsNumberOnscoke()){
							mapGoodsStock.put(orderGoodsTemp.getGoodsId(), 0);
						}else{
							mapGoodsStock.put(orderGoodsTemp.getGoodsId(), orderGoodsTemp.getGoodsNumber().intValue());
						}
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
				transactionDelegate.transactionFinishOrder(user_Id, purchaseInfo.getPurchaseId().toString(),mapGoodsStock,point);
			}
		return result;
	}
	
	
	
	/**
     * 统计购物车中应存在赠品数据
     * @param token
     * @throws Exception
     * @author chris
     */
	public List<Goods> statActivity(List<Cart> lstCart) throws Exception {
		List<Goods> result = new ArrayList<Goods>();
		//获取当前系统赠品活动信息
		//获取活动信息
		List<Activity>  lstActivityTemp =  activityService.selectActivityByTime(Long.parseLong(DateUtil.getNowLong().toString()));
		BigDecimal priceTemp = new BigDecimal(0.00);
		int numTemp=0;
		
		for(Activity activity:lstActivityTemp){
			List<ActivityGift> lstGift = activityGiftService.selectActivityGiftByActId(activity.getAct_id());
			//1促销条件：金额
			if(activity.getCal_type()==0){
				//1.1促销类型：非全场
				if(activity.getAct_type()!=0){
					List<Goods> lstGoodsAct = new ArrayList<Goods>();
					//1.1.1获取参加活动的商品信息3单品
					if(activity.getAct_type()==3){
						lstGoodsAct = compositeQueryService.selectGoodsByActIdOfType3(activity.getAct_id());
					}
					//1.1.2获取参加活动的商品信息2品牌
					else if (activity.getAct_type()==2){
						lstGoodsAct = compositeQueryService.selectGoodsByActIdOfType2(activity.getAct_id());
					}
					//1.1.3获取参加活动的商品信息1分类型
					else if (activity.getAct_type()==1){
						lstGoodsAct = compositeQueryService.selectGoodsByActIdOfType1(activity.getAct_id());
					}
					for(Goods goods:lstGoodsAct){
						for(Cart cart:lstCart){
							if(cart.getIs_gift()==0){
								//判断购物车中商品是否参加活动
								if(cart.getGoods_id()==goods.getGoodsId()){
									//计算符合活动要求的商品金额*数量，并加入总计值
									priceTemp= priceTemp.add(cart.getGoods_price().subtract(BigDecimal.valueOf(cart.getGoods_number())));
								}
							}
						}
					}
					//总计值大于活动设定最小订单额度
					if(priceTemp.compareTo(activity.getLine())>=0){
						for(ActivityGift activityGift:lstGift){
							Goods goods = new Goods();
							goods.setGoodsId(activityGift.getGoodsId());
							goods.setGoodsNumber(activityGift.getGoodsNumber().intValue());
							result.add(goods);
						}
					}
				}
				//1.2促销类型：0全场
				else if(activity.getAct_type()==0){
						for(Cart cart:lstCart){
							if(cart.getIs_gift()==0){
									//计算符合活动要求的商品金额*数量，并加入总计值
									priceTemp= priceTemp.add(cart.getGoods_price().subtract(BigDecimal.valueOf(cart.getGoods_number())));
							}
						}
						//总计值大于活动设定最小订单额度
						if(priceTemp.compareTo(activity.getLine())>=0){
							for(ActivityGift activityGift:lstGift){
								Goods goods = new Goods();
								goods.setGoodsId(activityGift.getGoodsId());
								goods.setGoodsNumber(activityGift.getGoodsNumber().intValue());
								result.add(goods);
							}
						}
				}
			}
			//2促销条件：数量
			else{

				//2.1促销类型：非全场
				if(activity.getAct_type()!=0){
					List<Goods> lstGoodsAct = new ArrayList<Goods>();
					//2.1.1获取参加活动的商品信息3单品
					if(activity.getAct_type()==3){
						lstGoodsAct = compositeQueryService.selectGoodsByActIdOfType3(activity.getAct_id());
					}
					//2.1.2获取参加活动的商品信息2品牌
					else if (activity.getAct_type()==2){
						lstGoodsAct = compositeQueryService.selectGoodsByActIdOfType2(activity.getAct_id());
					}
					//2.1.3获取参加活动的商品信息1分类型
					else if (activity.getAct_type()==1){
						lstGoodsAct = compositeQueryService.selectGoodsByActIdOfType1(activity.getAct_id());
					}
					for(Goods goods:lstGoodsAct){
						for(Cart cart:lstCart){
							if(cart.getIs_gift()==0){
								//判断购物车中商品是否参加活动
								if(cart.getGoods_id()==goods.getGoodsId()){
									//计算符合活动要求的商品金额*数量，并加入总计值
									numTemp= numTemp+cart.getGoods_number();
								}
							}
						}
					}
					//数量总数值大于活动设定最小订单额度
					if(numTemp>activity.getNum()){
						//活动设定1：叠加
						if(activity.getOverlap()==1){
							int OverlapTimes = numTemp/activity.getNum();
							for(ActivityGift activityGift:lstGift){
								Goods goods = new Goods();
								goods.setGoodsId(activityGift.getGoodsId());
								int giftTotalNum = 0;
								for(int i=0;i<OverlapTimes;i++){
									giftTotalNum = giftTotalNum+activityGift.getGoodsNumber();
								}
								goods.setGoodsNumber(giftTotalNum);
								result.add(goods);
							}
						}
						//活动设定0：不叠加
						else if(activity.getOverlap()==0){
							for(ActivityGift activityGift:lstGift){
								Goods goods = new Goods();
								goods.setGoodsId(activityGift.getGoodsId());
								goods.setGoodsNumber(activityGift.getGoodsNumber().intValue());
								result.add(goods);
							}	
						}
					}
				}
				//2.2促销类型：0全场
				else if(activity.getAct_type()==0){
						for(Cart cart:lstCart){
							if(cart.getIs_gift()==0){
								//计算符合活动要求的商品金额*数量，并加入总计值
								numTemp= numTemp+cart.getGoods_number();
							}
						}
						//数量总数值大于活动设定最小订单额度
						if(numTemp>activity.getNum()){
							//活动设定1：叠加
							if(activity.getOverlap()==1){
								int OverlapTimes = numTemp/activity.getNum();
								for(ActivityGift activityGift:lstGift){
									Goods goods = new Goods();
									goods.setGoodsId(activityGift.getGoodsId());
									int giftTotalNum = 0;
									for(int i=0;i<OverlapTimes;i++){
										giftTotalNum = giftTotalNum+activityGift.getGoodsNumber();
									}
									goods.setGoodsNumber(giftTotalNum);
									result.add(goods);
								}
							}
							//活动设定0：不叠加
							else if(activity.getOverlap()==0){
								for(ActivityGift activityGift:lstGift){
									Goods goods = new Goods();
									goods.setGoodsId(activityGift.getGoodsId());
									goods.setGoodsNumber(activityGift.getGoodsNumber().intValue());
									result.add(goods);
								}	
							}
						}
				}
			
			}

		}
		return result;
	}

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
