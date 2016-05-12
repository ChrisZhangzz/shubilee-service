package com.shubilee.delegate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shubilee.bean.ComputerGoodResult;
import com.shubilee.bean.ComputerResult;
import com.shubilee.common.BusinessComputing;
import com.shubilee.common.DateUtil;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityGift;
import com.shubilee.entity.ActivityLookup;
import com.shubilee.entity.Address;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.BonusVendor;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Error;
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.Profile;
import com.shubilee.entity.Shipping;
import com.shubilee.entity.TaxLookup;
import com.shubilee.entity.Token;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserProfile;
import com.shubilee.entity.Users;
import com.shubilee.entity.Vendors;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.service.ActivityGiftService;
import com.shubilee.service.ActivityLookupService;
import com.shubilee.service.ActivityService;
import com.shubilee.service.BonusLookupService;
import com.shubilee.service.BonusTypeService;
import com.shubilee.service.CartRedisService;
import com.shubilee.service.CartService;
import com.shubilee.service.CompositeQueryService;
import com.shubilee.service.GoodsCatService;
import com.shubilee.service.GoodsService;
import com.shubilee.service.OrderGenerateRedisService;
import com.shubilee.service.OrderGenerateService;
import com.shubilee.service.OrderInfoService;
import com.shubilee.service.ShippingService;
import com.shubilee.service.TaxLookupService;
import com.shubilee.service.UserService;
import com.shubilee.service.VendorsService;

@Service
public class CartServiceDelegateV1 {

//	@Autowired
//	private CartService cartService;
	@Autowired
	private CartRedisService cartRedisService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ActivityGiftService activityGiftService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private BonusTypeService bonusTypeService;
	@Autowired
	private ActivityLookupService activityLookupService;
	@Autowired
	private CompositeQueryService compositeQueryService;
	@Autowired
	private GoodsCatService goodsCatService;
//	@Autowired
//	private OrderGenerateService orderGenerateService;
	@Autowired
	private OrderGenerateRedisService orderGenerateRedisService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private TransactionDelegate transactionDelegate1;
	@Autowired
	CartServiceDelegateV2 cartRedisServiceDelegate;
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
	//是否启用库存管理  false:不启用  true:启用
	private static boolean use_storage = true;
	
	/*
	   获取购物车信息
	@param String token
	@return Map<String,Object> 购物车相关信息（含赠品）
	*/
	public Map<String,Object> viewCart(String token,int is_estimate)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> tempMap;
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		List<Cart> lstCartTemp = new ArrayList<Cart>();
		List<Map<String,Object>> lstTemp = new ArrayList<Map<String,Object>>();
		 List<Map<String,Object>> lstVendors = new ArrayList<Map<String,Object>>();
		//未登陆浏览购物车处理
		lstCartTemp = cartRedisService.selectCartsForRedis(tokenIn);
		for(Cart cart:lstCartTemp){
			Vendors vendors = new Vendors();
			vendors.setVendorId(cart.getVendor_id());
			vendors.setVendorName(cart.getVendor_name());
			vendors.setVendorEname(cart.getVendor_ename());
			tempMap = new HashMap<String,Object>();
			tempMap.put("vendors", vendors);
			tempMap.put("rec_id", cart.getRec_id());
			tempMap.put("gid", cart.getGoods_id());
			tempMap.put("name", cart.getGoods_name());
			tempMap.put("ename", cart.getGoods_ename());
			tempMap.put("price", cart.getGoods_price());
			tempMap.put("number", cart.getGoods_number());
			BigDecimal goodsNum = new BigDecimal(new BigInteger(cart.getGoods_number().toString()));
			tempMap.put("subtotal", cart.getGoods_price().multiply(goodsNum));
			tempMap.put("currency", "$");
			tempMap.put("is_gift", cart.getIs_gift());
			tempMap.put("image", YamiConstant.IMAGE_URL+cart.getGoods_thumb());
			
			//自动修改购物车商品数量
			//限购判断
			if(cart.getIsLimited()){
				if(cart.getLimitedQuantity()>cart.getLimitedNumber()){
				    if(cart.getGoods_number()>cart.getLimitedNumber()){
				    	cartRedisServiceDelegate.quantityChange(token,cart.getVendor_id(),cart.getGoods_id(),cart.getLimitedNumber());
				    	 tempMap.put("number", cart.getLimitedNumber());
						 tempMap.put("is_change", 1);
				    }
				}
				else{
					 if(cart.getGoods_number()>cart.getLimitedQuantity()){
						 cartRedisServiceDelegate.quantityChange(token,cart.getVendor_id(),cart.getGoods_id(),cart.getLimitedQuantity());
				    	 tempMap.put("number", cart.getLimitedQuantity());
						 tempMap.put("is_change", 1);
					 }
				}
			}
			//库存判断
			else if(cart.getGoods_number_stock()<cart.getGoods_number()){
								 //quantityChange(token,cart.getVendor_id(),cart.getGoods_id(),String.valueOf(cart.getGoods_number_stock()));
				cartRedisServiceDelegate.quantityChange(token,cart.getVendor_id(),cart.getGoods_id(),0);
			}
			//下架、删除判断
			else if (!cart.getIsOnSale()||cart.getIsDelete()||cart.getGoods_number().intValue()<=0){
				cartRedisServiceDelegate.quantityChange(token,cart.getVendor_id(),cart.getGoods_id(),0);
			}
			else{
				 tempMap.put("is_change", 0);
			}
			//只在结算页面判断商品价格是否更新,返回页面最新数据，但未更新数据库购物车表（为性能考虑）
			if(is_estimate==0){
				//商品价格判断
				Goods goodsTemp = new Goods();
				goodsTemp.setPromoteCountdown(cart.getPromote_countdown_stock());
				goodsTemp.setIsPromote(cart.getIs_promote_stock());
				goodsTemp.setPromoteStartDate(cart.getPromote_start_date_stock());
				goodsTemp.setPromoteEndDate(cart.getPromote_end_date_stock());
				goodsTemp.setPromoteWeekly(cart.getPromote_weekly_stock());
				if(StringUtil.checkPrice(goodsTemp)){
					if(!(cart.getGoods_price().compareTo(cart.getPromote_price_stock())==0)){
						tempMap.put("price", cart.getPromote_price_stock());
						tempMap.put("is_change", 1);
					}
				}else{
					if(!(cart.getGoods_price().compareTo(cart.getShop_price_stock())==0)){
						tempMap.put("price", cart.getShop_price_stock());
						tempMap.put("is_change", 1);					
					}
				}
			}
			
			
			
			
			
			
			
			
			//购物车自动清理处理
			if((!cart.getIsOnSale())||cart.getIsDelete()){
				tempMap.put("is_oos", 1);  
			}else{
				tempMap.put("is_oos", 0); 
				
			}
			
			tempMap.put("is_limited", cart.getIsLimited()?1:0); 
			tempMap.put("limited_number", cart.getLimitedNumber()); 
			tempMap.put("limited_quantity",  cart.getLimitedQuantity()); 
			
			BigDecimal goodsNumEnd = new BigDecimal(String.valueOf(tempMap.get("number")));
			BigDecimal priceEnd = new BigDecimal(String.valueOf(tempMap.get("price")));
			tempMap.put("subtotal", priceEnd.multiply(goodsNumEnd));
			
			
			
			if (!(!cart.getIsOnSale()||cart.getIsDelete()||cart.getGoods_number().intValue()<=0||cart.getGoods_number_stock()<cart.getGoods_number())){
			  lstTemp.add(tempMap);
			}
		}
		//重新提取购物车
		lstCartTemp = cartRedisService.selectCartsForRedis(tokenIn);
		//赠品处理流程	
		//获取系统当前所有活动信息	
		List<Activity> lstActivity = activity_info();
		//获取可以获得的赠品信息
		List<Map<String,Object>> lstMapTemp =  calculate_gifts(lstActivity,lstCartTemp);
        //补充赠品信息到购物车信息
		lstTemp = compare_gifts(tokenIn,lstMapTemp,lstTemp);
		//赠品处理流程
		result.put("token", token);
//		if(is_estimate==0){
//			if(lstTemp.size()==0){
//				throw new YamiException(YamiConstant.ERRORCODE_ER1203,ErrorCodeEnum.ER1203.getMsg());
//			}
//		}
		//多供货商处理
		lstVendors = compare_Vendors(token,lstTemp,is_estimate);

		result.put("vendorCart", lstVendors);
		return result;
	}
	
	
	/*
	 订单结算
	 @param token		
	 @param is_estimate	true:返回不包含积分、红包、运费、TAX的订单费用  false:包含包含积分、红包、运费、TAX的订单费用
	 
	 @return Boolean	 
	*/
	public Map<String,Object> checkout(String token,int is_estimate)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> total = new HashMap<String,Object>();
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		OrderGenerate orderGenerate;
		List<Cart> lstCartTemp;
		//商品价格合计
		BigDecimal subtotal = new BigDecimal(0.00);
		//折扣合计
		BigDecimal discount = new BigDecimal(0.00);
		//折扣码
		String bonus_sn="";
		BonusType bonusType=null;
		//运费合计
		BigDecimal shipping = new BigDecimal(0.00);
		Integer shippingAdd=null;
		//积分合计
		BigDecimal points = new BigDecimal(0.00);
		//扣税合计
		BigDecimal tax = new BigDecimal(0.00);
		//订单合计
		BigDecimal amount = new BigDecimal(0.00);
		//是否使用积分抵扣标识
		int pointFlag = 0;
		//可以使用的积分
		int pointDisplay=0;
		
       //返回预估价
		if(is_estimate==1){
			//未登陆处理
			if(tokenIn.getIsLogin()==0){
				String tempId = tokenIn.getData();
				//获取逻辑运算所需要数据 start
				lstCartTemp = cartRedisService.selectCartsForRedis(tokenIn);
				List<OrderGenerate> lstOrderGenerateTemp = orderGenerateRedisService.selectAllForOrderGenerate(tokenIn);
				Map<Integer,OrderGenerate> mapOrderGenerateTemp = new HashMap<Integer,OrderGenerate>();
				OrderGenerate orderGenerateTempForStepNext = new OrderGenerate();
				for(OrderGenerate orderGenerateTemp1:lstOrderGenerateTemp){
					mapOrderGenerateTemp.put(orderGenerateTemp1.getVendorId(), orderGenerateTemp1);
					orderGenerateTempForStepNext = orderGenerateTemp1;
				}
				
				//判断是否使用了折扣码，提取折扣码对应活动信息
				List<Vendors> lstVendorBonus = new ArrayList<Vendors>();
				Map<Integer,Vendors> mapVendorBonus = new HashMap<Integer,Vendors>();
				List<BonusLookup> lstBonusLookup = new ArrayList<BonusLookup>();
				if(null!=orderGenerateTempForStepNext.getBonusId()){
					bonusType = bonusTypeService.selectBonusType(orderGenerateTempForStepNext.getBonusId());
					if(null!=bonusType){
						lstBonusLookup = bonusLookupService.selectBonusLookupByTypeId(bonusType.getTypeId());
						bonusType.setLstBonusLookup(lstBonusLookup);
						lstVendorBonus = bonusLookupService.selectVendorByBonusTypeId(bonusType.getTypeId());
						for(Vendors vendors:lstVendorBonus){
							mapVendorBonus.put(vendors.getVendorId(), vendors);
						}
					}
					 else{
						 cartRedisServiceDelegate.cancelCode(token);
					  }
				}
				//获取逻辑运算所需要数据 end
				//商品价格合计
				subtotal = BusinessComputing.accountOrder(lstCartTemp);
				
				orderGenerate = new OrderGenerate();
				orderGenerate.setTempId(tokenIn.getData());
				orderGenerate.setPointFlag(pointFlag);
				OrderGenerate orderGenerateTemp;
				for(Cart cart:lstCartTemp){
					orderGenerateTemp = mapOrderGenerateTemp.get(cart.getVendor_id());
					if(null==orderGenerateTemp){
						orderGenerate.setBonusId(orderGenerateTempForStepNext.getBonusId());
						orderGenerate.setShippingAdd(orderGenerateTempForStepNext.getShippingAdd());
						orderGenerate.setProfileId(orderGenerateTempForStepNext.getProfileId());
						orderGenerate.setVendorId(cart.getVendor_id());
						//transactionDelegate.transactionAddOrderGenerateSelective(orderGenerate);
						orderGenerateRedisService.insert(tokenIn, StringUtil.formateOrederGenerateRedis(orderGenerate));
						mapOrderGenerateTemp.put(cart.getVendor_id(), orderGenerate);
					}
					else{
						orderGenerate = orderGenerateTemp;
					}
					
				}
				//不放入循环中，总单只使用一次折扣码
				ComputerResult computerResult = new ComputerResult();
				if(null!=bonusType){
					bonus_sn = bonusType.getUserBonus().getBonusSn();
					computerResult = BusinessComputing.countPromoPrice(bonusType,lstCartTemp,lstVendorBonus);
					discount = computerResult.getComputerPrice().setScale(2,BigDecimal.ROUND_HALF_UP);
				}
				amount = subtotal.subtract(discount);
			}
			//已登陆处理
			else{
				int uid = Integer.parseInt(tokenIn.getData());
				//获取逻辑运算所需要数据 start
				lstCartTemp = cartRedisService.selectCartsForRedis(tokenIn);
				UserAddress userAddressdefault = userService.getAddressDefaultByUid(uid);
				String lastPayName = orderInfoService.selectLastPayName(uid);
				
				List<OrderGenerate> lstOrderGenerateTemp = orderGenerateRedisService.selectAllForOrderGenerate(tokenIn);
				
				Map<Integer,Vendors> mapVendorBonus = new HashMap<Integer,Vendors>();
				List<BonusLookup> lstBonusLookup = new ArrayList<BonusLookup>();
				Map<Integer,OrderGenerate> mapOrderGenerateTemp = new HashMap<Integer,OrderGenerate>();
				OrderGenerate orderGenerateTempForStepNext = new OrderGenerate();
				for(OrderGenerate orderGenerateTemp1:lstOrderGenerateTemp){
					mapOrderGenerateTemp.put(orderGenerateTemp1.getVendorId(), orderGenerateTemp1);
					orderGenerateTempForStepNext = orderGenerateTemp1;
				}
				//判断是否使用了折扣码，提取折扣码对应活动信息
				List<Vendors> lstVendorBonus = new ArrayList<Vendors>();
				if(null!=orderGenerateTempForStepNext.getBonusId()){
					bonusType = bonusTypeService.selectBonusType(orderGenerateTempForStepNext.getBonusId());
					if(null!=bonusType){
						lstBonusLookup = bonusLookupService.selectBonusLookupByTypeId(bonusType.getTypeId());
						bonusType.setLstBonusLookup(lstBonusLookup);
						lstVendorBonus = bonusLookupService.selectVendorByBonusTypeId(bonusType.getTypeId());
						for(Vendors vendors:lstVendorBonus){
							mapVendorBonus.put(vendors.getVendorId(), vendors);
						}
					}
					 else{
						 cartRedisServiceDelegate.cancelCode(token);
					  }
				}
				//获取逻辑运算所需要数据 end
				//商品价格合计
				subtotal = BusinessComputing.accountOrder(lstCartTemp);
				orderGenerate = new OrderGenerate();
				orderGenerate.setUserId(Integer.parseInt(tokenIn.getData()));
				orderGenerate.setPointFlag(pointFlag);
				//默认收货地址
				
				if(userAddressdefault!=null){
					orderGenerate.setShippingAdd(userAddressdefault.getAddress_id());
				}
				//默认支付方式
				
				if(null!=lastPayName){
					if(lastPayName.equals("paypal")){
						orderGenerate.setProfileId("0");
					}else{
						UserProfile userProfileDefault = userService.selectProfileDefaultByUid(Integer.parseInt(tokenIn.getData()));
						if(userProfileDefault!=null){
							orderGenerate.setProfileId(userProfileDefault.getProfile_id());
						}
					}
				}
				
				
				
				


				OrderGenerate orderGenerateTemp;
				for(Cart cart:lstCartTemp){
					orderGenerateTemp = mapOrderGenerateTemp.get(cart.getVendor_id());
					
					if(null==orderGenerateTemp){
						List<Shipping> lstShippingTemp = shippingService.selectShippingListByVendorId(cart.getVendor_id());
						orderGenerate.setShippingId( Integer.parseInt(lstShippingTemp.get(0).getShippingId().toString()));
						orderGenerate.setVendorId(cart.getVendor_id());
						//transactionDelegate.transactionAddOrderGenerateSelective(orderGenerate);
						orderGenerateRedisService.update(tokenIn, StringUtil.formateOrederGenerateRedis(orderGenerate));
						mapOrderGenerateTemp.put(cart.getVendor_id(), orderGenerate);
					}
					else{
						orderGenerate = orderGenerateTemp;
					}
					
				}
				//不放入循环中，总单只使用一次折扣码
				ComputerResult computerResult = new ComputerResult();
				if(null!=bonusType){
					bonus_sn = bonusType.getUserBonus().getBonusSn();
					computerResult = BusinessComputing.countPromoPrice(bonusType,lstCartTemp,lstVendorBonus);
					discount = computerResult.getComputerPrice().setScale(2,BigDecimal.ROUND_HALF_UP);
			    	amount = subtotal.subtract(discount);
				}
				amount = subtotal.subtract(discount);
			}
		}
		//返回全部订单费用
		else{
			//未登陆处理
			if(tokenIn.getIsLogin()==0){
				 throw new YamiException(YamiConstant.ERRORCODE_ER1004,ErrorCodeEnum.ER1004.getMsg());
			}
			//已登陆处理
			else{
				int uid = Integer.parseInt(tokenIn.getData());
				
				//获取逻辑运算所需要数据 start
				Users user = userService.selectUsersByID(uid);
				lstCartTemp = cartRedisService.selectCartsForRedis(tokenIn);
				List<OrderGenerate> lstOrderGenerateTemp = orderGenerateRedisService.selectAllForOrderGenerate(tokenIn);
				
				Map<Integer,Vendors> mapVendorBonus = new HashMap<Integer,Vendors>();
				List<BonusLookup> lstBonusLookup = new ArrayList<BonusLookup>();
				Map<Integer,OrderGenerate> mapOrderGenerateTemp = new HashMap<Integer,OrderGenerate>();
				OrderGenerate orderGenerateTempForStepNext = new OrderGenerate();
				for(OrderGenerate orderGenerateTemp1:lstOrderGenerateTemp){
					mapOrderGenerateTemp.put(orderGenerateTemp1.getVendorId(), orderGenerateTemp1);
					orderGenerateTempForStepNext = orderGenerateTemp1;
				}
				//判断是否使用了折扣码，提取折扣码对应活动信息
				List<Vendors> lstVendorBonus = new ArrayList<Vendors>();
				if(null!=orderGenerateTempForStepNext.getBonusId()){
					bonusType = bonusTypeService.selectBonusType(orderGenerateTempForStepNext.getBonusId());
					if(null!=bonusType){
						lstBonusLookup = bonusLookupService.selectBonusLookupByTypeId(bonusType.getTypeId());
						bonusType.setLstBonusLookup(lstBonusLookup);
						lstVendorBonus = bonusLookupService.selectVendorByBonusTypeId(bonusType.getTypeId());
						for(Vendors vendors:lstVendorBonus){
							mapVendorBonus.put(vendors.getVendorId(), vendors);
						}
					}
					 else{
						 cartRedisServiceDelegate.cancelCode(token);
					  }
				}
				List<Shipping> lstShippingInfoTemp = shippingService.selectShippingList();
				Map<Integer,Shipping> mapShippingTemp = new HashMap<Integer,Shipping>();
				Map<Integer,Shipping> mapShippingFreeTemp = new HashMap<Integer,Shipping>();
				for(Shipping shippingTemp:lstShippingInfoTemp){
					mapShippingTemp.put(shippingTemp.getShippingId().intValue(), shippingTemp);
					if(shippingTemp.getIsPrimary()==1){
						mapShippingFreeTemp.put(shippingTemp.getVendorId(), shippingTemp);
					}
				}
				UserAddress address = null;
				TaxLookup taxLookup = null;
				if(null!=orderGenerateTempForStepNext.getShippingAdd()){
					address = userService.getAddressBookByAddId(orderGenerateTempForStepNext.getShippingAdd());
					if(null!=address){
						taxLookup = taxLookupService.selectTax(address.getProvince(), address.getZipcode());
					}
				}
				//获取逻辑运算所需要数据 end
				
				//1、商品价格合计
				subtotal = BusinessComputing.accountOrder(lstCartTemp);
				amount = subtotal;
				Map<String,Object> mapShipping = new HashMap<String,Object>();
				OrderGenerate orderGenerateTemp;
				for(Cart cart:lstCartTemp){
					orderGenerateTemp = mapOrderGenerateTemp.get(cart.getVendor_id());
					shippingAdd = orderGenerateTemp.getShippingAdd();
					pointFlag = orderGenerateTemp.getPointFlag();
					//将各供货商的对应配货方式存储，后续同一处理运费问题
					if(orderGenerateTemp.getShippingId()!=null){
						mapShipping.put(orderGenerateTemp.getVendorId().toString(), orderGenerateTemp.getShippingId());
					}
				}

		        //2、折扣合计
				BigDecimal yamibuyDiscount = new BigDecimal(0.00);
				ComputerResult computerResult = new ComputerResult();
				Map<String,BigDecimal> mapComputerGoodResult = new HashMap<String,BigDecimal>();
				List<ComputerGoodResult>  computerGoodResult = new ArrayList<ComputerGoodResult>(); 
				if(null!=bonusType){
					Map<String,List<Cart>> mapVendorCart = BusinessComputing.formateCartInfo(lstCartTemp);
			    	bonus_sn = bonusType.getUserBonus().getBonusSn();
			    	for(String vendor_id:mapVendorCart.keySet()){
			    		if(mapVendorBonus.containsKey(Integer.parseInt(vendor_id))||vendor_id.equals(YamiConstant.VENDOR_ID_YAMIBUY)){
			    			computerResult = BusinessComputing.countPromoPrice(bonusType,mapVendorCart.get(vendor_id),lstVendorBonus);
			    			BigDecimal discountTemp = computerResult.getComputerPrice().setScale(2,BigDecimal.ROUND_HALF_UP);
			    			computerGoodResult = computerResult.getComputerGoodResult();
			    			discount = discount.add(discountTemp);
			    			mapComputerGoodResult.put(vendor_id, computerResult.getComputerPrice());
			    			if(vendor_id.equals(YamiConstant.VENDOR_ID_YAMIBUY)){
			    				yamibuyDiscount = discountTemp;
			    			}
			    		}
			    	}

			    	amount = amount.subtract(discount);
			    }
				else{
					Map<String,List<Cart>> mapVendorCart = BusinessComputing.formateCartInfo(lstCartTemp);
			    	for(String vendor_id:mapVendorCart.keySet()){
			    		if(mapVendorBonus.containsKey(Integer.parseInt(vendor_id))||vendor_id.equals(YamiConstant.VENDOR_ID_YAMIBUY)){
			    			computerResult = BusinessComputing.countPromoPrice(null,mapVendorCart.get(vendor_id),lstVendorBonus);
			    			BigDecimal discountTemp = computerResult.getComputerPrice().setScale(2,BigDecimal.ROUND_HALF_UP);
			    			computerGoodResult = computerResult.getComputerGoodResult();
			    			discount = discount.add(discountTemp);
			    			mapComputerGoodResult.put(vendor_id, computerResult.getComputerPrice());
			    			if(vendor_id.equals(YamiConstant.VENDOR_ID_YAMIBUY)){
			    				yamibuyDiscount = discountTemp;
			    			}
			    		}
			    	}

			    	amount = amount.subtract(discount);
				}
				BigDecimal yamibuyOrderAccont = BusinessComputing.accountOrderByVendorId(lstCartTemp,Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)).subtract(yamibuyDiscount);
				//3、积分合计
				//使用积分
				//积分对应可使用金额
				BigDecimal pointPrice =new BigDecimal(0);
				//BigDecimal pointPrice = BigDecimal.valueOf(Long.parseLong(String.valueOf(user.getPay_points()))).divide(new BigDecimal(100.00));
				if(pointFlag==1){
					//如果积分对应金额小于等于订单总价
					if(pointPrice.compareTo(yamibuyOrderAccont)<=0){
						points = pointPrice;
					}
					else{
						points = yamibuyOrderAccont;
					}
					amount = amount.subtract(points);	
					
					pointDisplay = points.multiply(new BigDecimal(100)).intValue();
				}
				else{
					//如果积分对应金额小于等于订单总价
					if(pointPrice.compareTo(yamibuyOrderAccont)<=0){
						//pointDisplay = user.getPay_points();
					}
					else{
						pointDisplay =  yamibuyOrderAccont.multiply(new BigDecimal(100)).intValue();
					}
					
				}
				//4、运费合计:0为免运费方式
				for(String vendor_id:mapShipping.keySet()){
					Shipping shippingInfo = mapShippingTemp.get(Integer.parseInt(mapShipping.get(vendor_id).toString()));  
					
					
					BigDecimal vendorOrderAccont = new BigDecimal(0.00);
					
					//vendorOrderAccont = BusinessComputing.accountOrderByVendorId(lstCartTemp,Integer.parseInt(vendor_id));
					if(mapComputerGoodResult.containsKey(vendor_id)){
						vendorOrderAccont = BusinessComputing.accountOrderByVendorId(lstCartTemp,Integer.parseInt(vendor_id)).subtract(mapComputerGoodResult.get(vendor_id));
					}else{
						vendorOrderAccont = BusinessComputing.accountOrderByVendorId(lstCartTemp,Integer.parseInt(vendor_id));
					}
					
					
					
					
					if(BusinessComputing.getVendorShipping(vendorOrderAccont,mapShippingTemp,shippingInfo.getShippingId())){
						shipping = shipping.add(new BigDecimal(0.00));
					}else{
						shipping = shipping.add(shippingInfo.getShippingFee().setScale(2,BigDecimal.ROUND_HALF_UP));
					}
				}
				amount = amount.add(shipping);
				//5、扣税合计
				if(null!=address){
					
					computerGoodResult = BusinessComputing.countPromoPrice(bonusType, lstCartTemp, lstVendorBonus).getComputerGoodResult();
					computerResult =BusinessComputing.countTax(uid,  lstCartTemp, address, taxLookup,computerGoodResult);
					tax = computerResult.getComputerPrice().setScale(2,BigDecimal.ROUND_HALF_UP);
					amount = amount.add(tax);
				}
			}
		}
		
		total.put("pointFlag", pointFlag);
		total.put("pointDisplay", pointDisplay);
		total.put("subtotal", subtotal);
		total.put("bonus_sn", bonus_sn);
		total.put("discount", discount);
		total.put("shipping", shipping);
		total.put("points", points);
		total.put("tax", tax);
		total.put("amount", amount);
		total.put("currency", "$");
		result.put("token", token);
		result.put("is_estimate", is_estimate);
		result.put("total", total);
		return result;
	}
	/*
	   处理查询购物车放回数据，对同一供货商物品进行归类返回
	  @param Token  
	  @param list 礼品列表
	  @param goods 购物车
	  @return List<Map<String,Object>> 补充赠品后的购物车信息
	 */
	  public List<Map<String,Object>> compare_Vendors(String token,List<Map<String,Object>> listCart,int is_estimate)throws Exception {
		  Gson gson = new Gson(); 
		  Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		  List<Cart> lstCart4Computer = new ArrayList<Cart>();
		//未登陆浏览购物车处理
				lstCart4Computer = cartRedisService.selectCartsForRedis(tokenIn);
		  
		  
		  
		  List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		  Map<String,Object> mapVCart;
		  List<Map<String,Object>> lstCartTemp;
		  Map<String,Object> mapcart;
		  int bloneBons = 0;

		  Map<String,Object>  mapVendorTemp = new HashMap<String,Object>();
		  List<String>  lstVendorId = new ArrayList<String>(); 
		  BonusType bonusType  = new BonusType();
		  Map<String,Object> mapVendor = new HashMap<String,Object>();
		  Map<String,Object> mapBouns = new HashMap<String,Object>();
		  Map<String,Object> mapShipping = new HashMap<String,Object>();
		  
		  for(Map<String,Object> mapTemp:listCart){
			  String vendor_id = ((Vendors)mapTemp.get("vendors")).getVendorId().toString();
			  if(!mapVendorTemp.containsKey(vendor_id)){
				  lstVendorId.add(vendor_id);
				  mapVendorTemp.put(vendor_id, (Vendors)mapTemp.get("vendors")); 
			  }
		  }
		  //逻辑运算数据准备 start
		  List<OrderGenerate> lstOrderGenerateTemp = new ArrayList<OrderGenerate>();
			  lstOrderGenerateTemp= orderGenerateRedisService.selectAllForOrderGenerate(tokenIn);
			Map<Integer,OrderGenerate> mapOrderGenerateTemp = new HashMap<Integer,OrderGenerate>();
			OrderGenerate orderGenerateTempForStepNext = new OrderGenerate();
			for(OrderGenerate orderGenerateTemp1:lstOrderGenerateTemp){
				mapOrderGenerateTemp.put(orderGenerateTemp1.getVendorId(), orderGenerateTemp1);
				orderGenerateTempForStepNext = orderGenerateTemp1;
			}
		  
		  List<Vendors> lstVendorBonus = new ArrayList<Vendors>();
			Map<Integer,Vendors> mapVendorBonus = new HashMap<Integer,Vendors>();
			List<BonusLookup> lstBonusLookup = new ArrayList<BonusLookup>();
			if(null!=orderGenerateTempForStepNext.getBonusId()){
				bonusType = compositeQueryService.selectBonusByBonusId(orderGenerateTempForStepNext.getBonusId());
				if(null!=bonusType){
					lstBonusLookup = bonusLookupService.selectBonusLookupByTypeId(bonusType.getTypeId());
					bonusType.setLstBonusLookup(lstBonusLookup);
					lstVendorBonus = bonusLookupService.selectVendorByBonusTypeId(bonusType.getTypeId());
					
					 List<BonusVendor> lstBonusVendor = new ArrayList<BonusVendor>();
					  for(Vendors vendors:lstVendorBonus){
						  BonusVendor bonusVendor =  new BonusVendor();
						  bonusVendor.setTypeId(bonusType.getTypeId().intValue()); 
						  bonusVendor.setVendorId(vendors.getVendorId());
						  lstBonusVendor.add(bonusVendor);
					  }
					  
					  bonusType.setLstBonusVendor(lstBonusVendor);
					for(Vendors vendors:lstVendorBonus){
						mapVendorBonus.put(vendors.getVendorId(), vendors);
					}
				}else{
					 cartRedisServiceDelegate.cancelCode(token);
				}
			}
			
			List<Shipping> lstShippingInfoTemp = shippingService.selectShippingList();
			Map<Integer,Shipping> mapShippingTemp = new HashMap<Integer,Shipping>();
			Map<Integer,Shipping> mapShippingFreeTemp = new HashMap<Integer,Shipping>();
			for(Shipping shippingTemp:lstShippingInfoTemp){
				mapShippingTemp.put(shippingTemp.getShippingId().intValue(), shippingTemp);
				if(shippingTemp.getIsPrimary()==1){
					mapShippingFreeTemp.put(shippingTemp.getVendorId(), shippingTemp);
				}
			}
			List<Cart> lstCart = new ArrayList<Cart>();
			for(Map<String,Object> mapTemp:listCart){
			Cart cartTemp = new Cart();
			   cartTemp.setGoods_id(Integer.parseInt(mapTemp.get("gid").toString()));
			   cartTemp.setGoods_number(Integer.parseInt(mapTemp.get("number").toString()));
			   cartTemp.setGoods_price(BigDecimal.valueOf(Double.parseDouble(mapTemp.get("price").toString())));
			   cartTemp.setIs_gift(Short.parseShort(mapTemp.get("is_gift").toString()));
			   cartTemp.setVendor_id(Integer.parseInt(((Vendors)mapTemp.get("vendors")).getVendorId().toString()));
			   
			   for(Cart cart4Computer:lstCart4Computer){
				   if(Integer.parseInt(mapTemp.get("gid").toString())==cart4Computer.getGoods_id()){
					   cartTemp.setSubTree(cart4Computer.getSubTree());
					   cartTemp.setBrand_id(cart4Computer.getBrand_id());
				   }
			   }
			   
			   lstCart.add(cartTemp);
			}
			
			
			//逻辑运算数据准备 end
		  for(String vendor_id:lstVendorId){
			  Boolean free_shipping = false;
			  mapVCart = new HashMap<String,Object>();
			  mapVendor = new HashMap<String,Object>();
			  mapVendor.put("vendor_id", vendor_id);
			  mapVendor.put("vendor_name", ((Vendors)mapVendorTemp.get(vendor_id)).getVendorName());
			  mapVendor.put("vendor_ename", ((Vendors)mapVendorTemp.get(vendor_id)).getVendorEname());
			  mapVCart.put("currency", "$");
			  lstCartTemp = new  ArrayList<Map<String,Object>>(); 
			  List<Cart> lstVendorCartTemp = new ArrayList<Cart>();
			  BigDecimal vendorBonusPrice = new BigDecimal(0.00);
			  BigDecimal bonusPrice = new BigDecimal(0.00);
			  BigDecimal vendor_subtotal = new BigDecimal(0.00);
			  for(Map<String,Object> mapTemp:listCart){
				  mapcart = new HashMap<String,Object>();
			   if(vendor_id.equals(((Vendors)mapTemp.get("vendors")).getVendorId().toString())){
				   mapcart.put("gid", mapTemp.get("gid"));
				   mapcart.put("recid", mapTemp.get("rec_id"));
				   mapcart.put("name", mapTemp.get("name"));
				   mapcart.put("ename", mapTemp.get("ename"));
				   mapcart.put("price", mapTemp.get("price"));
				   mapcart.put("number", mapTemp.get("number"));
				   mapcart.put("subtotal", mapTemp.get("subtotal"));
				   mapcart.put("currency", mapTemp.get("currency"));
				   mapcart.put("is_gift", mapTemp.get("is_gift"));
				   mapcart.put("is_oos", mapTemp.get("is_oos"));
				   mapcart.put("is_change", mapTemp.get("is_change"));
				   mapcart.put("image", mapTemp.get("image"));
				   mapcart.put("is_limited", mapTemp.get("is_limited"));
				   mapcart.put("limited_quantity", mapTemp.get("limited_quantity"));
				   //mapcart.put("limited_number", mapTemp.get("limited_number"));
				   lstCartTemp.add(mapcart);  
				   Cart cartTemp = new Cart();
				   cartTemp.setGoods_id(Integer.parseInt(mapTemp.get("gid").toString()));
				   cartTemp.setGoods_number(Integer.parseInt(mapTemp.get("number").toString()));
				   cartTemp.setGoods_price(BigDecimal.valueOf(Double.parseDouble(mapTemp.get("price").toString())));
				   cartTemp.setIs_gift(Short.parseShort(mapTemp.get("is_gift").toString()));
				   cartTemp.setVendor_id(Integer.parseInt(vendor_id));
				   
				   for(Cart cart4Computer:lstCart4Computer){
					   if(Integer.parseInt(mapTemp.get("gid").toString())==cart4Computer.getGoods_id()){
						   cartTemp.setSubTree(cart4Computer.getSubTree());
						   cartTemp.setBrand_id(cart4Computer.getBrand_id());
					   }
				   }
				   
				   lstVendorCartTemp.add(cartTemp);
				   vendor_subtotal =  vendor_subtotal.add(BigDecimal.valueOf(Double.parseDouble(mapTemp.get("subtotal").toString())));
			   }
			  }
			  mapVCart.put("cart", lstCartTemp);
			  //未登陆
			  if(tokenIn.getIsLogin()==0){
				  OrderGenerate orderGenerate = mapOrderGenerateTemp.get(Integer.parseInt(vendor_id));
				  //结算页面处理该数据
				  if(is_estimate==0){
					  throw new YamiException(YamiConstant.ERRORCODE_ER1004,ErrorCodeEnum.ER1004.getMsg());
				  }
				  else{
					  if(orderGenerate!=null){
						  //如果存在折扣活动
						  if(orderGenerate.getBonusId()!=null){
							  ComputerResult computerResult = BusinessComputing.countPromoPrice(bonusType,lstCart,lstVendorBonus); 
							  Vendors vendors = new Vendors();
							  vendors.setVendorId(Integer.parseInt(vendor_id));
							  ComputerResult computerResultVendor = BusinessComputing.countPromoPriceByVendor(bonusType, lstCart, vendors);
							  if(computerResultVendor.getComputerPrice().compareTo(new BigDecimal(0.0))>0){
								  vendor_subtotal.subtract(vendorBonusPrice);
								  mapBouns = new HashMap<String,Object>();
								  mapBouns.put("bonus_id",orderGenerate.getBonusId());  
								  mapBouns.put("bonus_name",bonusType.getTypeDesc()); 
								  mapBouns.put("bonus_ename",bonusType.getTypeEdesc()); 
								  mapBouns.put("discount",computerResultVendor.getComputerPrice().setScale(2,BigDecimal.ROUND_HALF_UP)); 
								  mapBouns.put("currency", "$");
								  mapVCart.put("bonus",mapBouns);   
							  }
							  if(computerResult.getComputerPrice().compareTo(new BigDecimal(0.0))==0){
								  cartRedisServiceDelegate.cancelCode(token);
							  }
						  }
						  mapVendor.put("vendor_subtotal", vendor_subtotal);
						  mapVendor.put("currency", "$");
						  mapVCart.put("vendor",mapVendor);
					  } 
					  else{
						  mapVendor.put("vendor_subtotal", vendor_subtotal);
						  mapVendor.put("currency", "$");
						  mapVCart.put("vendor",mapVendor);
					  }
				  }
			  }
			  
			  //已登陆
			  else{
				  OrderGenerate orderGenerate = mapOrderGenerateTemp.get(Integer.parseInt(vendor_id));
				  //结算页面处理该数据
				  if(is_estimate==0){
					  if(orderGenerate!=null){
					  //如果存在折扣活动
					  if(orderGenerate.getBonusId()!=null){
						  ComputerResult computerResult = BusinessComputing.countPromoPrice(bonusType,lstCart,lstVendorBonus); 
						  Vendors vendors = new Vendors();
						  vendors.setVendorId(Integer.parseInt(vendor_id));
						  ComputerResult computerResultVendor = BusinessComputing.countPromoPriceByVendor(bonusType, lstCart, vendors);
						  if(computerResultVendor.getComputerPrice().compareTo(new BigDecimal(0.0))>0){
							  vendorBonusPrice = computerResultVendor.getComputerPrice();
							  vendor_subtotal.subtract(vendorBonusPrice);
							  mapBouns = new HashMap<String,Object>();
							  mapBouns.put("bonus_id",orderGenerate.getBonusId());  
							  mapBouns.put("bonus_name",bonusType.getTypeDesc()); 
							  mapBouns.put("bonus_ename",bonusType.getTypeEdesc()); 
							  mapBouns.put("discount",computerResultVendor.getComputerPrice().setScale(2,BigDecimal.ROUND_HALF_UP)); 
							  mapBouns.put("currency", "$");
							  mapVCart.put("bonus",mapBouns);   
						  }
						  if(computerResult.getComputerPrice().compareTo(new BigDecimal(0.0))==0){
							  cartRedisServiceDelegate.cancelCode(token);
						  }
					  }
					  mapShipping = new HashMap<String,Object>();
					  mapShipping.put("shipping_id", orderGenerate.getShippingId()==null?0:orderGenerate.getShippingId());
					  free_shipping = BusinessComputing.getVendorShipping(vendor_subtotal.subtract(vendorBonusPrice),mapShippingTemp,orderGenerate.getShippingId());
					  mapShipping.put("free_shipping",free_shipping?1:0);
					  mapVCart.put("shipping",mapShipping);
					  mapVendor.put("vendor_subtotal", vendor_subtotal.setScale(2,BigDecimal.ROUND_HALF_UP));
					  mapVendor.put("currency", "$");
					  mapVCart.put("vendor",mapVendor);
				  }
				 }
				  //购物车页面处理该数据
				  else{
					  if(orderGenerate!=null){
						  //如果存在折扣活动
						  if(orderGenerate.getBonusId()!=null){
							  ComputerResult computerResult = BusinessComputing.countPromoPrice(bonusType,lstCart,lstVendorBonus); 
							  Vendors vendors = new Vendors();
							  vendors.setVendorId(Integer.parseInt(vendor_id));
							  ComputerResult computerResultVendor = BusinessComputing.countPromoPriceByVendor(bonusType, lstCart, vendors);
							  if(computerResultVendor.getComputerPrice().compareTo(new BigDecimal(0.0))>0){
								  vendorBonusPrice = computerResultVendor.getComputerPrice();
								  vendor_subtotal.subtract(vendorBonusPrice);
								  mapBouns = new HashMap<String,Object>();
								  mapBouns.put("bonus_id",orderGenerate.getBonusId());  
								  mapBouns.put("bonus_name",bonusType.getTypeDesc()); 
								  mapBouns.put("bonus_ename",bonusType.getTypeEdesc()); 
								  mapBouns.put("discount",computerResultVendor.getComputerPrice().setScale(2,BigDecimal.ROUND_HALF_UP)); 
								  mapBouns.put("currency", "$");
								  mapVCart.put("bonus",mapBouns);   
							  }
							  if(computerResult.getComputerPrice().compareTo(new BigDecimal(0.0))==0){
								  cartRedisServiceDelegate.cancelCode(token);
							  }
						  }
						  mapVendor.put("vendor_subtotal", vendor_subtotal);
						  mapVendor.put("currency", "$");
						  mapVCart.put("vendor",mapVendor);
					  } 
					  else{
						  mapVendor.put("vendor_subtotal", vendor_subtotal);
						  mapVendor.put("currency", "$");
						  mapVCart.put("vendor",mapVendor);
					  }
				  }  
				  
			  }
			  result.add(mapVCart);  
		  }
		  return result;
	  }
	


	  
	  /*
		 对计算后的礼品列表，做出相应数据库操作，并返回完整购物车信息
		@param Token  
		@param list 礼品列表
		@param goods 购物车
		@return List<Map<String,Object>> 补充赠品后的购物车信息
		*/
		public List<Map<String,Object>> compare_gifts(Token token,List<Map<String,Object>> lstAct,List<Map<String,Object>> listCartIn)  throws Exception{
			  //删除赠品信息
			  cartRedisService.deleteGift(token);
			  
			  List<Map<String,Object>> listCart = new ArrayList<Map<String,Object>>();
		    	 for(Map<String,Object> cart:listCartIn){
		    		 if(cart.get("is_gift").toString().equals("0")){
		    			 listCart.add(cart) ;
		    		 }
		    	 }
		    	 //添加新赠品
		  		Map<String,Object> tempMap;
		 		for(Map<String,Object> actMap:lstAct){
		 			//Goods tempgoods = 	((ActivityGift)actMap.get("activityGift")).getGoods();
		 			Goods tempgoods = goodsService.selectByPrimaryKey(Integer.parseInt(actMap.get("goods_id").toString()));
		 				//需要赠送礼品数量
		 				int giftNumber = Integer.parseInt(actMap.get("gift_number").toString());
		 				 //添加赠品到数据库
		 				 CartRedis cartRedis = new CartRedis();
		 				cartRedis.setGoods_id(tempgoods.getGoodsId());
		 				cartRedis.setGoods_number(Integer.parseInt(String.valueOf(giftNumber)));
		 				cartRedis.setIs_gift(1); 
		 				cartRedis.setVendor_id(Integer.parseInt(tempgoods.getVendorId().toString()));
		 				
		 				 if(giftNumber<=tempgoods.getGoodsNumber()&&tempgoods.getIsOnSale()&&!tempgoods.getIsDelete()){
		 					cartRedisService.insert(token, cartRedis);
		 					
			  				//需要赠送礼品数量
			  				tempMap = new HashMap<String,Object>();
			  				tempMap.put("gid", tempgoods.getGoodsId());
			  				tempMap.put("name", tempgoods.getGoodsName());
			  				tempMap.put("ename", tempgoods.getGoodsEname());
			  				tempMap.put("price", 0);
			  				tempMap.put("number", giftNumber);
			  				tempMap.put("subtotal", 0);
			  				
			  				tempMap.put("currency", "$");
			  				tempMap.put("is_gift", 1);
			  				tempMap.put("is_change", 0);
			  				Vendors vendors = new Vendors();
			  				vendors.setVendorId(Integer.parseInt(tempgoods.getVendorId().toString()));
			  				tempMap.put("vendors", vendors);
			  				//当前库存是否满足
			  				
			  				 
			  				if((!tempgoods.getIsOnSale())||tempgoods.getIsDelete()){
			  					tempMap.put("is_oos", 1);  
			  				}else{
			  					tempMap.put("is_oos", 0); 
			  					
			  				}
			  				 
			  				 
			  				 tempMap.put("image", YamiConstant.IMAGE_URL+tempgoods.getGoodsThumb());
			 				 //添加赠品到返回的数据MAP
			 				 listCart.add(tempMap);
		 				 }
		 		}
			  
			  return listCart;
		}
	 /*
	       获取系统活动信息
	  @return List<Activity> 系统活动及相关赠品信息
	 */
	public List<Activity> activity_info()throws Exception{
		//获取活动信息
		List<Activity>  lstActivityTemp =  activityService.selectActivityByTime(Long.parseLong(DateUtil.getNowLong().toString()));
		Activity activityTemp;
		List<ActivityLookup> lstActivityLookupTemp;
		List<Activity>  lstActivity = new ArrayList<Activity>();
		//获取各活动相关商品信息
		for(int i=0;i<lstActivityTemp.size();i++){
			activityTemp = lstActivityTemp.get(i);
			lstActivityLookupTemp = activityLookupService.selectActivityByActId(activityTemp.getAct_id());
			activityTemp.setLstActivityLookup(lstActivityLookupTemp);
			lstActivity.add(activityTemp);
		}
		return lstActivityTemp;
	}
	  /*
	   对计算后的礼品列表，做出相应数据库操作，并返回完整购物车信息
	  @param List<Activity> 礼品列表
	  @param List<Cart> 购物车
	  @return List<Map<String,Object>> 可以获得的赠品信息
	 */
	  public List<Map<String,Object>> calculate_gifts(List<Activity>  lstActivity,List<Cart> listCart) {
		  int round = 0;
		  List<Goods> lstGoodsActTemp;
		  List<Map<String,Object>> lstMapTemp = new ArrayList<Map<String,Object>>();
		  Map<String,Object> mapTemp;
		  for(int i=0;i<lstActivity.size();i++){
			  //可获得赠品次数
			  int activity_gift = qualify_activity_order(listCart,lstActivity.get(i));
			  //可选择礼品
			  if(lstActivity.get(i).getGift_mode()>0){
				  //lstMapTemp = new ArrayList<Map<String,String>>();
			  
				  for(round=1;round<=activity_gift;round++){
					  if(activity_gift>=1){
					    lstGoodsActTemp= compositeQueryService.selectGoodsByActid(lstActivity.get(i).getAct_id());
					    for(Goods tempGoods1:lstGoodsActTemp){
					    	mapTemp = new HashMap<String,Object>();
					    	mapTemp.put("goods_id", tempGoods1.getGoodsId().toString());
					    	mapTemp.put("goods_number", tempGoods1.getGoodsNumber().toString());
					    	mapTemp.put("act_id", lstActivity.get(i).getAct_id().toString());
					    	mapTemp.put("overlap_num", String.valueOf(activity_gift));
					    	mapTemp.put("gift_number",String.valueOf(tempGoods1.getGoodsNumber()*activity_gift));
					    	mapTemp.put("act_round",String.valueOf(lstActivity.get(i).getAct_id()*1000+round));
					    	lstMapTemp.add(mapTemp);
					    }
					  } 
				  }
				  round++;
			  }
			  //不可选择礼品
			  else{
				  
				  if(activity_gift>=1){
					  lstGoodsActTemp= compositeQueryService.selectGoodsByActid(lstActivity.get(i).getAct_id());
					  //lstMapTemp = new ArrayList<Map<String,String>>();
					  for(Goods tempGoods1:lstGoodsActTemp){
					    	mapTemp = new HashMap<String,Object>();
					    	mapTemp.put("goods_id", tempGoods1.getGoodsId().toString());
					    	mapTemp.put("goods_number", tempGoods1.getGoodsNumber().toString());
					    	mapTemp.put("act_id", lstActivity.get(i).getAct_id().toString());
					    	mapTemp.put("overlap_num", String.valueOf(activity_gift));
					    	mapTemp.put("gift_number",String.valueOf(tempGoods1.getGoodsNumber()*activity_gift));
					    	mapTemp.put("act_round",String.valueOf(lstActivity.get(i).getAct_id()*1000+round));
					    	lstMapTemp.add(mapTemp);
					    }
			  } 	  
		  } 
		  }
		  return lstMapTemp;
	  }

	
	/* 检查可获得礼品次数
	 * @param activity 活动信息 
	 * @param lstCart 购物车信息
	 * @return int
	 */
	public int qualify_activity_order(List<Cart> lstCart, Activity activity){
		int result = 0;
		int tempNumber = 0;
		BigDecimal tempPrice = new BigDecimal(0);
		switch(activity.getAct_type()){
		//全场
		case 0:
			//按个数
			if(activity.getCal_type()==1){
				 for(int i=0;i<lstCart.size();i++){
				     if(lstCart.get(i).getIs_gift()==0){
				    	 tempNumber+=lstCart.get(i).getGoods_number();
				     }
				 }
				 result = gift_overlap(tempNumber,activity.getNum(),activity.getOverlap());
			}
			//按金额
			else{
				for(int i=0;i<lstCart.size();i++){
					BigDecimal goodsNum = new BigDecimal(new BigInteger(lstCart.get(i).getGoods_number().toString()));
					tempPrice = tempPrice.add(lstCart.get(i).getGoods_price().multiply(goodsNum));
				}
				result = gift_overlap(tempPrice,activity.getLine(),activity.getOverlap());
			}
			
		break;
		//分类:该出逻辑判断需再检查	   
		case 1:
			for(int i=0;i<lstCart.size();i++){
				for(int j=0;j<activity.getLstActivityLookup().size();j++){
					//判断当前购物车商品不是赠品并且属于活动赠品范围
					if(lstCart.get(i).getIs_gift()==0 && BusinessComputing.belong_to_cat(lstCart.get(i).getSubTree(),activity.getLstActivityLookup().get(j).getCat_id())){
						tempNumber+=lstCart.get(i).getGoods_number();
						BigDecimal goodsNum = new BigDecimal(new BigInteger(lstCart.get(i).getGoods_number().toString()));
						tempPrice = tempPrice.add(lstCart.get(i).getGoods_price().multiply(goodsNum));
						}
					}
				}
			//按个数
			if(activity.getCal_type()==1){
				result = gift_overlap(tempNumber,activity.getNum(),activity.getOverlap());
			}
			//按金额
			else{
				result = gift_overlap(tempPrice,activity.getLine(),activity.getOverlap());
			}
		break;
		//品牌：该出逻辑判断需再检查		   
		case 2:
			for(int i=0;i<lstCart.size();i++){
				for(int j=0;j<activity.getLstActivityLookup().size();j++){
					//判断当前购物车商品不是赠品并且属于活动赠品范围
					if(lstCart.get(i).getIs_gift()==0 && lstCart.get(i).getBrand_id().intValue()==activity.getLstActivityLookup().get(j).getBrand_id().intValue()){
						tempNumber+=lstCart.get(i).getGoods_number();
						BigDecimal goodsNum = new BigDecimal(new BigInteger(lstCart.get(i).getGoods_number().toString()));
						tempPrice = tempPrice.add(lstCart.get(i).getGoods_price().multiply(goodsNum));
						}
					}
				}
			//按个数
			if(activity.getCal_type()==1){
				result = gift_overlap(tempNumber,activity.getNum(),activity.getOverlap());
			}
			//按金额
			else{
				result = gift_overlap(tempPrice,activity.getLine(),activity.getOverlap());
			}
		break;
		//单品	：该出逻辑判断需再检查		   
		case 3:
			
			for(int i=0;i<lstCart.size();i++){
				for(int j=0;j<activity.getLstActivityLookup().size();j++){
					//判断当前购物车商品不是赠品并且属于活动赠品范围
					if(lstCart.get(i).getIs_gift()==0 && lstCart.get(i).getGoods_id().intValue()==activity.getLstActivityLookup().get(j).getGoods_id().intValue()){
						tempNumber+=lstCart.get(i).getGoods_number();
						BigDecimal goodsNum = new BigDecimal(new BigInteger(lstCart.get(i).getGoods_number().toString()));
						tempPrice = tempPrice.add(lstCart.get(i).getGoods_price().multiply(goodsNum));
						}
					}
				}
			//按个数
			if(activity.getCal_type()==1){
				result = gift_overlap(tempNumber,activity.getNum(),activity.getOverlap());
			}
			//按金额
			else{
				result = gift_overlap(tempPrice,activity.getLine(),activity.getOverlap());
			}
		break;
			   
		default:
		break; 
		}
		return result;
	}
	
	/*
	 计算礼品叠加后的数量
	 @param goodsNum		物品数值
	 @param actNum			活动最低要求
	 @param overlap	                   是否叠加
	 
	 @return count	返回可获得赠品数量 
	*/
	public int gift_overlap(int goodsNum,int actNum,int overlap){
		int result = 0;
		//可叠加
		if(overlap==1){
			if(goodsNum>=actNum){
				result = goodsNum/actNum;
			}else{
				result = 0;
			}
		}
		//不叠加
		else{
			if(goodsNum>=actNum){
				result = 1;
			}else{
				result = 0;
			}
		}
		return result;
	}
	/*
	 计算礼品叠加后的数量
	 @param goodsCount		物品金额
	 @param actNum			活动最低要求
	 @param overlap	                   是否叠加
	 
	 @return count	返回可获得赠品数量 
	*/
	public int gift_overlap(BigDecimal goodsCount,BigDecimal actLine,int overlap){
		int result = 0;
		//可叠加
		if(overlap==1){
			if(goodsCount.compareTo(actLine)==1||goodsCount.compareTo(actLine)==0){
				result =     Integer.parseInt(goodsCount.divide(actLine,0,BigDecimal.ROUND_HALF_DOWN).toString());
			}else{
				result = 0;
			}
		}
		//不叠加
		else{
			if(goodsCount.compareTo(actLine)==1||goodsCount.compareTo(actLine)==0){
				result = 1;
			}else{
				result = 0;
			}
		}
		return result;
	}

	 /*
 	获取邮寄方式总LIST
 	 @param token		
 	 @return List<Shipping> 
 	*/
 	public Map<String,Object>  getShippingList(String token){
 		Map<String,Object> result = new HashMap<String,Object>();
 		Map<String,Object> mapShipping = new HashMap<String,Object>();
 		Map<String,Object> mapVendor = new HashMap<String,Object>();
 		Map<String,Object> mapVendorTemp = new HashMap<String,Object>();
 		List<Map<String,Object>> lstShipping = new ArrayList<Map<String,Object>>();
 		List<Map<String,Object>> lstVendor = new ArrayList<Map<String,Object>>();
 		List<Shipping> lstShippingTemp = shippingService.selectShippingList();
 		for(Shipping shipping:lstShippingTemp){
 			Vendors vendors = vendorsService.selectByPrimaryKey(shipping.getVendorId());
 			mapVendorTemp.put(shipping.getVendorId().toString(), vendors);
 		}
 		BigDecimal freeShippingAmountVendor = new BigDecimal(0.0);
 		for(String key:mapVendorTemp.keySet()){
 			mapVendor = new HashMap<String,Object>();
 			freeShippingAmountVendor = new BigDecimal(0.0);
 			lstShipping = new ArrayList<Map<String,Object>>();
 			Vendors vendors = (Vendors)mapVendorTemp.get(key);
 			for(Shipping shipping:lstShippingTemp){
 				if(key.equals(shipping.getVendorId().toString())){
 					mapShipping = new HashMap<String,Object>();
 					mapShipping.put("shipping_id", shipping.getShippingId());
 					mapShipping.put("shippingName", shipping.getShippingName());
 					mapShipping.put("shippingFee", shipping.getShippingFee());
 					mapShipping.put("shippingDesc", shipping.getShippingDesc());
 					mapShipping.put("freeShippingAmount", shipping.getFreeShippingAmount());
 					mapShipping.put("is_primary", shipping.getIsPrimary());
 					if(shipping.getIsPrimary()==1){
 						freeShippingAmountVendor = shipping.getFreeShippingAmount();
 					}
 					if(shipping.getShippingId().intValue()!=YamiConstant.SHIPPING_ID_GESOO){
 						lstShipping.add(mapShipping);
 					}
 				}
 			}
 			mapVendor.put("vendor_id", key);
 			mapVendor.put("vendor_name", vendors.getVendorName());
 			mapVendor.put("vendor_ename", vendors.getVendorEname());
 			mapVendor.put("freeShippingAmount", freeShippingAmountVendor);
 			mapVendor.put("shipping", lstShipping);
 			lstVendor.add(mapVendor);
 		}
 		result.put("token", token);
 		result.put("vendorShipping", lstVendor);
 		return result;
 	}
 	
 	/*
 	获取邮寄方式LIST
 	 @param token		
 	 @return List<Shipping> 
 	*/
 	public Map<String,Object>  getVendorShipping(String token,int vendor_id){
 		Map<String,Object> result = new HashMap<String,Object>();
 		Map<String,Object> mapShipping = new HashMap<String,Object>();
 		List<Map<String,Object>> lstShipping = new ArrayList<Map<String,Object>>();
 		List<Shipping> lstShippingTemp = shippingService.selectShippingListByVendorId(vendor_id);
 			for(Shipping shipping:lstShippingTemp){
 					mapShipping = new HashMap<String,Object>();
 					mapShipping.put("shipping_id", shipping.getShippingId());
 					mapShipping.put("shippingName", shipping.getShippingName());
 					mapShipping.put("shippingFee", shipping.getShippingFee());
 					mapShipping.put("shippingDesc", shipping.getShippingDesc());
 					mapShipping.put("freeShippingAmount", shipping.getFreeShippingAmount());
 					mapShipping.put("is_primary", shipping.getIsPrimary());
 					if(shipping.getShippingId().intValue()!=YamiConstant.SHIPPING_ID_GESOO){
 						lstShipping.add(mapShipping);
 					}
 			}

 		result.put("token", token);
 		result.put("shipping", lstShipping);
 		return result;
 	}
 	
 	/*
 	获取指定第三方包邮设置数值
 	 @param token		
 	 @return List<Shipping> 
 	*/
 	public Map<String,Object>  getVendorShippingFreeAmount(String token,int vendor_id){
 		Map<String,Object> result = new HashMap<String,Object>();
 		BigDecimal freeAmount = shippingService.selectFreeAmountByVendorId(vendor_id);
 		result.put("token", token);
 		result.put("freeAmount", freeAmount);
 		return result;
 	}
 	

	
}
