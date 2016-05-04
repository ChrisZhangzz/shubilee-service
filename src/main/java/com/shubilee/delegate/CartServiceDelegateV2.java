package com.shubilee.delegate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shubilee.bean.ComputerResult;
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
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.Shipping;
import com.shubilee.entity.TaxLookup;
import com.shubilee.entity.Token;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserProfile;
import com.shubilee.entity.Users;
import com.shubilee.entity.Vendors;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.redis.entity.OrderGenerateRedis;
import com.shubilee.service.ActivityGiftService;
import com.shubilee.service.ActivityLookupService;
import com.shubilee.service.ActivityService;
import com.shubilee.service.BonusLookupService;
import com.shubilee.service.BonusTypeService;
import com.shubilee.service.CartRedisService;
import com.shubilee.service.CompositeQueryService;
import com.shubilee.service.GoodsCatService;
import com.shubilee.service.GoodsService;
import com.shubilee.service.OrderGenerateRedisService;
import com.shubilee.service.OrderInfoService;
import com.shubilee.service.ShippingService;
import com.shubilee.service.TaxLookupService;
import com.shubilee.service.UserService;
import com.shubilee.service.VendorsService;

@Service
public class CartServiceDelegateV2 {
	@Autowired
	private CartRedisService cartRedisService;
	@Autowired
	private OrderGenerateRedisService orderGenerateRedisService;
	@Autowired
	private TransactionDelegate transactionDelegate;
	@Autowired
	private BonusTypeService bonusTypeService;
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
	private Gson gson = new Gson(); 
	/*
	  添加商品到购物车
	@param String token
	@param  gid
	@param String add_number
	@param boolean is_gift
	@return Map<String,Object> 添加后相关商品系信息
	*/
	 public Map<String,Object> addItemToCart(String token,int gid,String add_number,int is_gift)throws Exception{
		 Map<String,Object> result = new HashMap<String,Object>();
		 Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		//获取商品基础信息	 
		Goods goods = goodsService.selectByPrimaryKey(gid); 
		BigDecimal good_price = StringUtil.checkPrice(goods)?goods.getPromotePrice():goods.getShopPrice();
		//赠品检查
		if(goods.getCatId().intValue()==YamiConstant.GIFT_CAT_ID){
			   throw new YamiException(YamiConstant.ERRORCODE_ER1115,ErrorCodeEnum.ER1115.getMsg()); 
		}
		//是否正在销售
	    if(!goods.getIsOnSale()||goods.getIsDelete()){
	    	throw new YamiException(YamiConstant.ERRORCODE_ER1101,ErrorCodeEnum.ER1101.getMsg());
	    }
		//库存检查
		if(goods.getGoodsNumber()==0){
			 throw new YamiException(YamiConstant.ERRORCODE_ER1103,ErrorCodeEnum.ER1103.getMsg());
		 }
		//库存检查
		if(Integer.parseInt(add_number)>goods.getGoodsNumber()){
			 throw new YamiException(YamiConstant.ERRORCODE_ER1103,ErrorCodeEnum.ER1103.getMsg());
		 }
		//限购判断
		 if(goods.getIsLimited()){
			 if(Integer.parseInt(add_number)>goods.getLimitedQuantity()||Integer.parseInt(add_number)>goods.getLimitedNumber()){
				 throw new YamiException(YamiConstant.ERRORCODE_ER1112,ErrorCodeEnum.ER1112.getMsg());
			 }
		 }
		
		Cart cart = new Cart();
		Boolean is_new = true;
		int good_number = Integer.parseInt(add_number);
		//判断redis是否存在该用户购物车信息
		//if(cartRedisService.checkAll(tokenIn)){
			//判断redis是否存在该用户指定商品信息
			//购物车存在该商品，更新数量
			if(cartRedisService.check(tokenIn, gid)){
				is_new=false;
				cart = cartRedisService.selectCartForRedisByGid(tokenIn, gid);
				good_number = cart.getGoods_number()+good_number;
				
				//限购判断
				 if(goods.getIsLimited()){
					 if(good_number>goods.getLimitedQuantity()||good_number>goods.getLimitedNumber()){
						 throw new YamiException(YamiConstant.ERRORCODE_ER1112,ErrorCodeEnum.ER1112.getMsg());
					 }
				 } 
				//库存判断，自动变化为库存大小
				 if(good_number>goods.getGoodsNumber()){
					 //good_number = goods.getGoodsNumber();
					 throw new YamiException(YamiConstant.ERRORCODE_ER1103,ErrorCodeEnum.ER1103.getMsg());
				 }
				cart.setGoods_number(Integer.parseInt(String.valueOf(good_number)));
				cartRedisService.update(tokenIn, StringUtil.formateCartRedis(cart));

			}
		//}
			//购物车不存在该商品，添加新商品信息
			else{
				CartRedis cartRedis = new CartRedis();
				cartRedis.setGoods_id(gid);
				cartRedis.setGoods_number(Integer.parseInt(String.valueOf(good_number)));
				cartRedis.setIs_gift(is_gift);
				cartRedis.setVendor_id(Integer.parseInt(goods.getVendorId().toString()));
				cartRedisService.insert(tokenIn, cartRedis);
			}

		//整理返回数据 
		 result.put("token", token) ;
		 result.put("gid", gid) ;
		 result.put("name", goods.getGoodsName());
		 result.put("ename", goods.getGoodsEname());
		 result.put("add_number", add_number);
		 result.put("goods_number", good_number);
		 result.put("image", YamiConstant.IMAGE_URL+goods.getGoodsThumb());
		 result.put("is_new", is_new);
		 result.put("price", good_price);
		 result.put("currency", "$");
		return result; 
	 }
	/*
	 修改购物车商品信息
	@param String token
	@param int gid
	@param int num
	@return Map<String,Object> 修改后相关商品系信息
	*/
	public Map<String,Object> quantityChange(String token,int vendor_id,int gid,int num) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		 int modifyFlag =0;
		 Gson gson = new Gson();  
		 Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		 Goods goodsTemp = goodsService.selectByPrimaryKey(gid);
		 Cart cartTemp = cartRedisService.selectCartForRedisByGid(tokenIn, gid);
		 if(null!=cartTemp){
		     //1.商品添加数量为0，默认删除购物车中该商品数据
			 if(num==0){
				 //1.1删除购物车中对应商品信息
				 cartRedisService.delete(tokenIn, gid);
				 modifyFlag = 1;
				 //1.2判断购物车是否还存在对应第三方商品,如果不存在，删除对应order_generate数据
				 List<Cart> lstCart = cartRedisService.selectCartsForRedis(tokenIn);
				 Boolean vendorExist = false;
				 for(Cart cart:lstCart){
					if(cart.getVendor_id().intValue()==vendor_id){
						vendorExist = true;
					} 
				 }
				 //1.3购物车中不存在对应第三方商品，删除对应order_generate数据
				 if(!vendorExist){
					 orderGenerateRedisService.delete(tokenIn, vendor_id);
				 }
			 }
			 //2.修改购物车中该商品数量信息
			 else{
				 //2.1限购商品判断
				 if(goodsTemp.getIsLimited()){
					 //2.1.1 每单限购数量小于总限购数量
					 if(goodsTemp.getLimitedQuantity()<goodsTemp.getLimitedNumber()){
						 //2.1.1.1 修改数值大于每单限购数量
						 if(num>goodsTemp.getLimitedQuantity()){
							 
							 cartTemp.setGoods_number(goodsTemp.getLimitedQuantity());
							 cartRedisService.update(tokenIn, StringUtil.formateCartRedis(cartTemp));
							 modifyFlag = 3; 
						 }
						 //2.1.1.2修改数值小于于每单限购数量
						 else{
							 cartTemp.setGoods_number(Integer.parseInt(String.valueOf(num)));
							 cartRedisService.update(tokenIn,  StringUtil.formateCartRedis(cartTemp));
						 }
					 }
					 //2.1.2 每单限购数量大于于总限购数量
					 else if(goodsTemp.getLimitedQuantity()>goodsTemp.getLimitedNumber()){
						 if(num>goodsTemp.getLimitedNumber()){
							 cartTemp.setGoods_number(goodsTemp.getLimitedNumber());
							 cartRedisService.update(tokenIn, StringUtil.formateCartRedis(cartTemp));
							 modifyFlag = 4; 
						 }else{
							 cartTemp.setGoods_number(Integer.parseInt(String.valueOf(num)));
							 cartRedisService.update(tokenIn,  StringUtil.formateCartRedis(cartTemp));
						 } 
					 } 
				 }
				//2.2 非限购商品判断
				 else{
					 //2.2.1 修改数值大于库存数量
					 if(num>goodsTemp.getGoodsNumber()){
						 cartTemp.setGoods_number(goodsTemp.getGoodsNumber());
						 cartRedisService.update(tokenIn,  StringUtil.formateCartRedis(cartTemp));
						 modifyFlag = 2;
					 }
					 //2.2.2修改数值小于等于库存数量
					 else{
						 cartTemp.setGoods_number(Integer.parseInt(String.valueOf(num)));
						 cartRedisService.update(tokenIn,  StringUtil.formateCartRedis(cartTemp));
					 }
				 }
			 }
		 }else{
			 modifyFlag = 1; 
		 }
		 switch(modifyFlag){
			 case 0:
				 result.put("token", token);
				 result.put("status", modifyFlag);
				 result.put("gid", gid);
			 break;
			 case 1:
				 result.put("token", token);
				 result.put("status", modifyFlag);
			 break;
			 case 2:
				 result.put("token", token);
				 result.put("status", modifyFlag);
				 result.put("num", goodsTemp.getGoodsNumber());
			 break;
			 case 3:
				 result.put("token", token);
				 result.put("status", 2);
				 result.put("num", goodsTemp.getLimitedQuantity());
			 break;
			 case 4:
				 result.put("token", token);
				 result.put("status", 2);
				 result.put("num", goodsTemp.getLimitedNumber());
			 break;
		 }
		 return result;

	}
	/*
	 获取购物车商品数量
	@param String token
	@return Map<String,Object> 购物车商品数量
	*/
	public Map<String,Object> getCartGoodsNum(String token) {
		Map<String,Object> result = new HashMap<String, Object>();
		int cart_subtotal_num = 0;
	    Gson gson = new Gson();  
	    Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
	    //判断redis中是否存在该用户购物车信息
	    if(cartRedisService.checkAll(tokenIn)){
		    List<CartRedis> lstCart = cartRedisService.selectAll(tokenIn);
	 		for(CartRedis cart:lstCart){
	 			cart_subtotal_num = cart_subtotal_num+cart.getGoods_number();
	 		}
	    }
 		result.put("cart_subtotal_num", cart_subtotal_num);
 		result.put("token", token);
 		return result;
	}
	
	/*
	 使用折扣码
	 @param token		
	 @param code
	 @return Map<String,Object>	 
	*/
	public Map<String,Object>  promoCode(String token,String code)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		List<Cart> lstCart  = cartRedisService.selectCartsForRedis(tokenIn);
		
		//折扣码是否有效
		Boolean valid = false;
		Boolean validVendor = false;
		//折扣金额
		BigDecimal deduct = new BigDecimal(0.00);
		
		//验证折扣码
		BonusType bonusType =  compositeQueryService.selectBonusByBonusSn(code);
		if(null==bonusType){
			throw new YamiException(YamiConstant.ERRORCODE_ER1105,ErrorCodeEnum.ER1105.getMsg());
		}
		valid =  BusinessComputing.checkPromoCode(bonusType);

		//确定折扣码对应活动，必须楼无车商品有参加
			List<Cart> lstCartTemp = cartRedisService.selectCartsForRedis(tokenIn);

		   //获取活动对应的第三方ID
			List<Vendors> lstVendor = bonusLookupService.selectVendorByBonusTypeId(bonusType.getTypeId());
			for(Cart cart:lstCartTemp){
				if(cart.getVendor_id()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
					validVendor=true;
				}
				else{for(Vendors vendors:lstVendor){
					if(vendors.getVendorId()==cart.getVendor_id()){
						validVendor=true;
					}
				}
			}
			}
			Map<Integer,Vendors> mapVendorBonus = new HashMap<Integer,Vendors>();
			List<Vendors> lstVendorBonus = new ArrayList<Vendors>();

			List<BonusLookup> lstBonusLookup = bonusLookupService.selectBonusLookupByTypeId(bonusType.getTypeId());
			bonusType.setLstBonusLookup(lstBonusLookup);
			lstVendorBonus = bonusLookupService.selectVendorByBonusTypeId(bonusType.getTypeId());
			for(Vendors vendors:lstVendorBonus){
				mapVendorBonus.put(vendors.getVendorId(), vendors);

			}
			bonusType =  bonusTypeService.selectBonusType(bonusType.getUserBonus().getBonusId());
		//整合返回信息
		if(valid&&validVendor){
			ComputerResult computerResult = BusinessComputing.countPromoPrice(bonusType,lstCart,lstVendorBonus);
			deduct = computerResult.getComputerPrice();
			if(deduct.compareTo(new BigDecimal(0))==0){
				throw new YamiException(YamiConstant.ERRORCODE_ER1116,ErrorCodeEnum.ER1116.getMsg());
			}
			
			
			//更新ordergenerate
			addCode(token,bonusType.getUserBonus().getBonusId());
			//计算折扣金额
			
			
			result.put("token", token);
			result.put("valid", valid);
			result.put("code", code);
			result.put("deduct", deduct.setScale(2,BigDecimal.ROUND_HALF_UP));
		}
		else{
			throw new YamiException(YamiConstant.ERRORCODE_ER1105,ErrorCodeEnum.ER1105.getMsg());
			}
		
		return result;
	}

	
	
	/*
	 取消折扣码
	 @param token		
	 @param code
	 @return Map<String,Object>	 
	*/
	public Map<String,Object>  cancelCode(String token)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		List<OrderGenerateRedis> orderGenerateTemp = orderGenerateRedisService.selectAll(tokenIn);
		for(OrderGenerateRedis orderGenerate:orderGenerateTemp){
			orderGenerate.setBonusId(null);
			orderGenerateRedisService.update(tokenIn, orderGenerate);
		}
		result.put("token", token);
		result.put("status", true);
		return result;
	}
	/*
	用户登录时，更新购物车商品信息（已有商品数量合并，新商品新加数据）
	@param String token
	@return Map<String,Object> 购物车商品数量
	*/
	public void updateUserIdByTempid(String tempId, int uid) throws Exception{
	    Token tokenUid = new Token();
	    tokenUid.setData(String.valueOf(uid));
	    Token tokenTempid = new Token();
	    tokenTempid.setData(tempId);
		//1.处理购物车信息（更新TEMP_ID对应购物车并与USER_ID对应购物车进行合并）
		List<CartRedis> lstCartTempId = cartRedisService.selectAll(tokenTempid);
		 for(CartRedis cartTempId:lstCartTempId){
			 //1.1已有商品
			 if(cartRedisService.check(tokenUid, cartTempId.getGoods_id())){
				 CartRedis cartUid =  cartRedisService.select(tokenUid, cartTempId.getGoods_id());
				 cartUid.setGoods_number(Integer.parseInt(String.valueOf(cartTempId.getGoods_number()+cartUid.getGoods_number())));
				 cartRedisService.update(tokenUid, cartUid);
			 }
			 //1.2新商品
			 else{
				 cartRedisService.insert(tokenUid, cartTempId);
			 }
		 }
		 cartRedisService.deleteAll(tokenTempid);
		//2.处理OrderGenerate信息
		 List<CartRedis> lstCartUid = cartRedisService.selectAll(tokenUid); 
		 List<OrderGenerateRedis> lstOrderGenerate =  orderGenerateRedisService.selectAll(tokenUid);
		 //2.1不存在临时ORDER数据
		 if(lstOrderGenerate.size()==0){
			 for(CartRedis cart:lstCartUid){
				 //2.1.1不存在对应vendor临时ORDER数据
				 if(!orderGenerateRedisService.check(tokenUid, cart.getVendor_id())){
					 OrderGenerateRedis orderGenerate = new OrderGenerateRedis();
					//2.1.1.1第三方默认配货方式
					 List<Shipping> lstShippingTemp = shippingService.selectShippingListByVendorId(cart.getVendor_id());
					 orderGenerate.setShippingId(Integer.parseInt(lstShippingTemp.get(0).getShippingId().toString()));
					//2.1.1.2更新默认收货地址
					 UserAddress userAddressdefault = userService.getAddressDefaultByUid(uid);
					 if(userAddressdefault!=null){
						 orderGenerate.setShippingAdd(userAddressdefault.getAddress_id());
					 }
					//2.1.1.3更新默认支付方式
					 UserProfile userProfileDefault = userService.selectProfileDefaultByUid(uid);
					   //默认银行卡支付方式
						if(userProfileDefault!=null){
							orderGenerate.setProfileId(userProfileDefault.getProfile_id());
						}
						//默认paypal支付方式
						else{
							orderGenerate.setProfileId("0");
						} 
					//2.1.1.4默认积分使用
					 orderGenerate.setPointFlag(0);
					//2.1.1.5指定第三方ID
					 orderGenerate.setVendorId(cart.getVendor_id());
					
					 orderGenerateRedisService.insert(tokenUid, orderGenerate);
				 }
			 }
		 }
		 //2.2存在临时ORDER数据
		 else{
			 OrderGenerateRedis orderGenerateExist = lstOrderGenerate.get(0);
			 for(CartRedis cart:lstCartUid){
				 //2.2.1不存在对应vendor临时ORDER数据
				 if(!orderGenerateRedisService.check(tokenUid, cart.getVendor_id())){
					 OrderGenerateRedis orderGenerate = orderGenerateExist;
					//2.2.1.1第三方默认配货方式
					 List<Shipping> lstShippingTemp = shippingService.selectShippingListByVendorId(cart.getVendor_id());
					 orderGenerate.setShippingId(Integer.parseInt(lstShippingTemp.get(0).getShippingId().toString()));
					//2.2.1.2指定第三方ID
					 orderGenerate.setVendorId(cart.getVendor_id());
					 orderGenerateRedisService.insert(tokenUid, orderGenerate);
				 }
			 }
		 }
		//2.3删除临时ID对应的ORDER临时信息
		 orderGenerateRedisService.deleteAll(tokenTempid);
	}
	/*
	   浏览购物车版本2.0
	@param String token
	@return Map<String,Object> 购物车相关信息（含赠品）
	*/
	public Map<String,Object> miniCart(String token)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> mapCart = new HashMap<String,Object>();
		List<Map<String,Object>> lstCartMap = new ArrayList<Map<String,Object>>();
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		//1、提取购物车信息
		List<Cart> lstCart = cartRedisService.selectCartsForRedis(tokenIn);
		BigDecimal priceCount = new BigDecimal(0.0);
		int numCount =0;
		for(Cart cart:lstCart){
			mapCart = new HashMap<String,Object>();
			mapCart.put("gid", cart.getGoods_id());
			mapCart.put("name", cart.getGoods_name());
			mapCart.put("ename", cart.getGoods_ename());
			mapCart.put("number", cart.getGoods_number());
			mapCart.put("price", StringUtil.formatPrice(cart.getGoods_price()));
			mapCart.put("currency", "$");
			mapCart.put("is_oos", cart.getGoods_number_stock().intValue()>0?0:1);
			mapCart.put("is_gift", cart.getIs_gift()==1?1:0);
			mapCart.put("image", YamiConstant.IMAGE_URL+cart.getGoods_thumb());
			BigDecimal itmesSubtotal = new BigDecimal(0.0);
			if(StringUtil.checkPrice(cart)){
				itmesSubtotal = cart.getPromote_price_stock().multiply(new BigDecimal(cart.getGoods_number()));
			}else{
				itmesSubtotal = cart.getShop_price_stock().multiply(new BigDecimal(cart.getGoods_number()));
			}
			mapCart.put("subtotal", itmesSubtotal);
			numCount = numCount+cart.getGoods_number();
			
			if(StringUtil.checkPrice(cart)){
				priceCount = priceCount.add(itmesSubtotal);
			}else{
				priceCount = priceCount.add(itmesSubtotal);
			}
			
			
			lstCartMap.add(mapCart);
		}
		result.put("subtotal", priceCount);
		result.put("numtotal", numCount);
		result.put("cartItems", lstCartMap);
		result.put("token", token);
		
		return result;
	}
	/*
	   浏览购物车版本2.0
	@param String token
	@return Map<String,Object> 购物车相关信息（含赠品）
	*/
	public Map<String,Object> viewCart(String token)throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		List<Object> lstVendorCart = new ArrayList<Object>();
		Map<String,Object> mapAmount = new HashMap<String,Object>();
		//1、提取购物车信息
			List<Cart> lstCart = cartRedisService.selectCartsForRedis(tokenIn);

			//1.3、如果购物车为空，直接发送返回值，不进行后续操作
			if(lstCart.size()==0){
				  mapAmount.put("amount", 0);
				  mapAmount.put("shipping", 0);
				  mapAmount.put("tax", 0);
				  mapAmount.put("pointDisplay", 0);
				  mapAmount.put("points", 0);
				  mapAmount.put("subtotal", 0);
				  mapAmount.put("bonus_sn", "");
				  mapAmount.put("currency", "$");
				  mapAmount.put("discount", 0);
				  mapAmount.put("pointFlag", 0);
				  result.put("total", mapAmount);	
				  result.put("vendorCart", lstVendorCart);	
				  result.put("token", token);	  
				  return result;
			}
		//2、提取临时ORDER信息
			  List<OrderGenerate> lstOrderGenerate= orderGenerateRedisService.selectAllForOrderGenerate(tokenIn);
			  
			  //2.3验证order_generate数据是否正确，并自动补充
			  Map<String,OrderGenerate> mapOrderGenerate = new HashMap<String,OrderGenerate>();
			  OrderGenerate orderGenerateDefalut = null;
			  for(OrderGenerate orderGenerate:lstOrderGenerate){
				  mapOrderGenerate.put(orderGenerate.getVendorId().toString(), orderGenerate);
				  orderGenerateDefalut = orderGenerate;
			  }
			  OrderGenerate orderGenerateTemp = new OrderGenerate();
			  for(Cart cart:lstCart){
				  if(!mapOrderGenerate.containsKey(cart.getVendor_id().toString())){
					  if(null!= orderGenerateDefalut){
						  orderGenerateTemp= new OrderGenerate();
						  orderGenerateTemp.setBonusId(orderGenerateDefalut.getBonusId());
						  orderGenerateTemp.setTempId(orderGenerateDefalut.getTempId());
						  orderGenerateTemp.setUserId(orderGenerateDefalut.getUserId());
						  orderGenerateTemp.setPointFlag(orderGenerateDefalut.getPointFlag());
						  orderGenerateTemp.setProfileId(orderGenerateDefalut.getProfileId());
						  orderGenerateTemp.setUserProfile(orderGenerateDefalut.getUserProfile());
						  orderGenerateTemp.setShippingAdd(orderGenerateDefalut.getShippingAdd());
						  orderGenerateTemp.setUserAddress(orderGenerateDefalut.getUserAddress());
						  
						  List<Shipping> lstShippingVendor =  shippingService.selectShippingListByVendorId(cart.getVendor_id().intValue());
						  Shipping shippingDeault = new Shipping();
						  for(Shipping shipping:lstShippingVendor){
							  if(shipping.getIsPrimary().intValue()==1){
								  shippingDeault =  shipping; 
							  }
						  }
						  orderGenerateTemp.setShippingId(shippingDeault.getShippingId().intValue());
						  orderGenerateTemp.setShipping(shippingDeault);
						  
						  orderGenerateTemp.setVendorId(cart.getVendor_id().intValue());
						  Vendors vendors = vendorsService.selectByPrimaryKey(cart.getVendor_id().intValue());
						  orderGenerateTemp.setVendors(vendors);
					  }else{
						  orderGenerateTemp= new OrderGenerate();
						  if(tokenIn.getIsLogin()==0){
							  orderGenerateTemp.setTempId(tokenIn.getData());  
						  }else{
							  orderGenerateTemp.setUserId(Integer.parseInt(tokenIn.getData()));
						  }
						  orderGenerateTemp.setPointFlag(0);
						  orderGenerateTemp.setVendorId(cart.getVendor_id().intValue());
						  Vendors vendors = vendorsService.selectByPrimaryKey(cart.getVendor_id().intValue());
						  orderGenerateTemp.setVendors(vendors);
						  //默认配送方式
						  List<Shipping> lstShippingVendor =  shippingService.selectShippingListByVendorId(cart.getVendor_id().intValue());
						  Shipping shippingDeault = new Shipping();
						  for(Shipping shipping:lstShippingVendor){
							  if(shipping.getIsPrimary().intValue()==1){
								  shippingDeault =  shipping; 
							  }
						  }
						  orderGenerateTemp.setShippingId(shippingDeault.getShippingId().intValue());
						  orderGenerateTemp.setShipping(shippingDeault);
						  //当前接口存在未登陆访问，故暂时不在这里给出如下默认值，改为结算页面查询时给出
						  //默认支付方式
						  //默认收货地址
						  
					  }
					  orderGenerateRedisService.insert(tokenIn, StringUtil.formateOrederGenerateRedis(orderGenerateTemp));
					  lstOrderGenerate.add(orderGenerateTemp);
					  mapOrderGenerate.put(cart.getVendor_id().toString(), orderGenerateTemp);
				  }
			  }
			  //2.4验证order_generate数据是否正确，并自动删除
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
		//3、赠品处理
			//3.1、提取赠品活动信息
			  List<Activity> lstActivity =  activityService.selectActivity(Long.parseLong(DateUtil.getNowLong().toString()));
			//3.2、赠品信息处理
			    //3.2.1获取可以获得的赠品信息
				List<Map<String,Object>> lstMapTemp =  BusinessComputing.calculate_giftsV2(lstActivity,lstCart);
				//3.2.2处理数据库购物车中赠品数据，并同时更新缓存信息
				lstCart = compare_gifts(tokenIn,lstMapTemp,lstCart);
		//4、折扣处理
			//3.1、提取折扣活动信息
				BonusType bonusType = new BonusType();
				if(null!=lstOrderGenerate.get(0).getBonusId()){
					bonusType =bonusTypeService.selectBonusType(lstOrderGenerate.get(0).getBonusId());
				}
		//5、返回数据整合处理
			result = integrateResult(token,lstOrderGenerate,lstCart,bonusType,null,null,0);	   
		return result;
	}
	/*
	 结算页面版本2.0
	 @param token		
	 @param is_estimate	true:返回不包含积分、红包、运费、TAX的订单费用  false:包含包含积分、红包、运费、TAX的订单费用
	 
	 @return Boolean	 
	*/
	public Map<String,Object> checkout(String token)throws Exception{

		Map<String,Object> result = new HashMap<String,Object>();
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		 List<Object> lstVendorCart = new ArrayList<Object>();
		 Map<String,Object> mapAmount = new HashMap<String,Object>();
		 //提取用户信息
		 Users users= userService.selectUserInfoByUid(uid);
		//1、提取购物车信息
			List<Cart> lstCart = cartRedisService.selectCartsForRedis(tokenIn);
			
			//1.1、如果购物车为空，直接发送返回值，不进行后续操作
			if(lstCart.size()==0){
				  mapAmount.put("amount", 0);
				  mapAmount.put("shipping", 0);
				  mapAmount.put("tax", 0);
				  mapAmount.put("pointDisplay", 0);
				  mapAmount.put("points", 0);
				  mapAmount.put("subtotal", 0);
				  mapAmount.put("bonus_sn", "");
				  mapAmount.put("currency", "$");
				  mapAmount.put("discount", 0);
				  mapAmount.put("pointFlag", 0);
				  result.put("total", mapAmount);
				  result.put("total", mapAmount);	
				  result.put("vendorCart", lstVendorCart);	
				  result.put("token", token);	  
				  return result;
			}
		//2、提取临时ORDER信息
			  List<OrderGenerate> lstOrderGenerate= orderGenerateRedisService.selectAllForOrderGenerate(tokenIn);
			 
			  //2.1验证order_generate数据是否正确，并自动补充
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
			  //2.2验证order_generate数据是否正确，并自动删除
			  UserAddress userAddress = new UserAddress();
			  UserProfile userProfileTemp = null;
			  String profileIdTemp = null;
			  UserAddress userAddressTemp = null;
			  Integer shippingAddTemp = null;
			  for(OrderGenerate orderGenerate:lstOrderGenerate){
				  if(null!=orderGenerate.getProfileId()){
					  userProfileTemp =  orderGenerate.getUserProfile();
					  profileIdTemp = orderGenerate.getProfileId();
				  }
				  if(null!=orderGenerate.getShippingAdd()){
					  userAddressTemp =  orderGenerate.getUserAddress();
					  shippingAddTemp = orderGenerate.getShippingAdd();
				  }
			  }
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
				  }else{
					  
					  //验证支付方式是否已设置，未设置给出设置默认值
					  if(null==orderGenerate.getProfileId()){
						  if(null==profileIdTemp){
							  String lastPayName = orderInfoService.selectLastPayName(uid);  
							  if(null!=lastPayName){
									if(lastPayName.equals("paypal")){
										orderGenerate.setProfileId("0");
									}else{
										UserProfile userProfileDefault = userService.selectProfileDefaultByUid(Integer.parseInt(tokenIn.getData()));
										if(userProfileDefault!=null){
											orderGenerate.setProfileId(userProfileDefault.getProfile_id());
											orderGenerate.setUserProfile(userProfileDefault);
										}
									}
								} 
						  }else{
							  orderGenerate.setProfileId(profileIdTemp);
							  orderGenerate.setUserProfile(userProfileTemp);
						  }
						  
					  }
					  //验证邮寄地址是否已设置，未设置给出设置默认值
					 if(null==orderGenerate.getShippingAdd()){
						 if(null==shippingAddTemp){
							 UserAddress userAddressdefault = userService.getAddressDefaultByUid(uid);
							 if(null!=userAddressdefault){
								 orderGenerate.setShippingAdd(userAddressdefault.getAddress_id());
								 orderGenerate.setUserAddress(userAddressdefault);
							 } 
						 }
						 else{
							 orderGenerate.setShippingAdd(shippingAddTemp);
							 orderGenerate.setUserAddress(userAddressTemp);
						 }
					 }
					 orderGenerateRedisService.update(tokenIn, StringUtil.formateOrederGenerateRedis(orderGenerate));
					 userAddress = orderGenerate.getUserAddress();
				 }
			  }
		//3、赠品处理
			//3.1、提取赠品活动信息
			  List<Activity> lstActivity =  activityService.selectActivity(Long.parseLong(DateUtil.getNowLong().toString()));
			//3.2、赠品信息处理
			    //3.2.1获取可以获得的赠品信息
				List<Map<String,Object>> lstMapTemp =  BusinessComputing.calculate_giftsV2(lstActivity,lstCart);
				//3.2.2处理数据库购物车中赠品数据，并同时更新缓存信息
				lstCart = compare_gifts(tokenIn,lstMapTemp,lstCart);
		//4、折扣处理
			//3.1、提取折扣活动信息
				BonusType bonusType = new BonusType();
				if(null!=lstOrderGenerate.get(0).getBonusId()){
					bonusType =bonusTypeService.selectBonusType(lstOrderGenerate.get(0).getBonusId());
				}
		//5、税率信息		
		 TaxLookup taxLookup=null;
		 if(null!=userAddress){
			 taxLookup = taxLookupService.selectTax(userAddress.getProvince(), userAddress.getZipcode());
		 }
		//5、整合返回值		
				result = integrateResult(token,lstOrderGenerate,lstCart,bonusType,taxLookup,users,1);	  
		return result;
	
	}
	
	
	/*
	   整合购物车，结算页面返回值
	  @param Token  
	  @param list lstOrderGenerate
	  @param list lstCart
	  @param BonusType bonusType
	  @param Users users	  
	  @param int fun_flag  0:viewcart调用   1：checkout调用 2:submitOrder调用
	  @return Map<String,Object> 放回结果信息集合
	 */
	  public Map<String,Object> integrateResult(String token,List<OrderGenerate> lstOrderGenerate,List<Cart> lstCart,BonusType bonusType,TaxLookup taxLookup,Users users,int fun_flag)throws Exception{
		  Map<String,Object> result = new HashMap<String,Object>();
		  
		//1、返回数据整合处理
			 
		  List<Object> lstCartItem = new ArrayList<Object>();
		  Map<String,Object> mapVendorCart = new HashMap<String,Object>();
		  Map<String,Object> mapVendor = new HashMap<String,Object>();
		  Map<String,Object> mapBonus = new HashMap<String,Object>();
		  Map<String,Object> mapShipping= new HashMap<String,Object>();
		  Map<String,Object> mapCartItem = new HashMap<String,Object>();
		  BigDecimal shippingFeeTotal = new BigDecimal(0.00);
		  BigDecimal yamibuySubtotal = new BigDecimal(0.00);
		  List<Object> lstVendorCart = new ArrayList<Object>();
		  Map<String,Object> mapAmount = new HashMap<String,Object>();
		  int pointFlag = 0;
		  UserAddress userAddress = new UserAddress();
		  
		  
		  for(OrderGenerate orderGenerate:lstOrderGenerate){
			  mapVendorCart = new HashMap<String,Object>();
			  //1.1购物车数据处理
			  lstCartItem = new ArrayList<Object>();
//			  for(Cart cart:lstCart){
			  for(int i=0;i<lstCart.size();i++){
				  Cart cart = lstCart.get(i);
				  if(orderGenerate.getVendorId().intValue()==cart.getVendor_id().intValue()){
					mapCartItem = new HashMap<String,Object>();  
					//1.1.1、下架、删除、购买数量判断，自动删除该商品
					if (!cart.getIsOnSale()||cart.getIsDelete()||cart.getGoods_number().intValue()<=0){
						quantityChange(token,cart.getVendor_id(),cart.getGoods_id(),0);
						lstCart.remove(i);
						continue;
					}  
					//1.1.2库存判断,库存不满足，自动删除该商品
					else if(cart.getGoods_number_stock()<cart.getGoods_number()){
							quantityChange(token,cart.getVendor_id(),cart.getGoods_id(),0);
							lstCart.remove(i);
							continue;
						}
					//1.1.3 商品限购判断
						else if(cart.getIsLimited()){
							if(cart.getLimitedQuantity()>cart.getLimitedNumber()){
							    if(cart.getGoods_number()>cart.getLimitedNumber()){
							    	 quantityChange(token,cart.getVendor_id(),cart.getGoods_id(),cart.getLimitedNumber());
							    	 cart.setGoods_number(cart.getLimitedNumber());
							    	 mapCartItem.put("is_change", 1);
							    }
							}
							else{
								 if(cart.getGoods_number()>cart.getLimitedQuantity()){
									 quantityChange(token,cart.getVendor_id(),cart.getGoods_id(),cart.getLimitedQuantity());
									 cart.setGoods_number(cart.getLimitedQuantity());
									 mapCartItem.put("is_change", 1);
								 }
							}
						}
						else{
							 mapCartItem.put("is_change", 0);
						}
					  mapCartItem.put("gid", cart.getGoods_id());
					  mapCartItem.put("name", cart.getGoods_name());
					  mapCartItem.put("ename", cart.getGoods_ename());
					  mapCartItem.put("price", StringUtil.formatPrice(cart.getGoods_price()));
					  mapCartItem.put("number", cart.getGoods_number());
					  BigDecimal goodsNum = new BigDecimal(new BigInteger(cart.getGoods_number().toString()));
					  mapCartItem.put("subtotal", StringUtil.formatPrice(cart.getGoods_price().multiply(goodsNum)));
					  mapCartItem.put("currency", "$");
					  mapCartItem.put("is_gift", cart.getIs_gift());
					  mapCartItem.put("image", YamiConstant.IMAGE_URL+cart.getGoods_thumb());
					  if((!cart.getIsOnSale())||cart.getIsDelete()){
						  mapCartItem.put("is_oos", 1);  
					  }else{
							mapCartItem.put("is_oos", 0); 
					  }
					  mapCartItem.put("is_limited", cart.getIsLimited()?1:0); 
					  mapCartItem.put("limited_number", cart.getLimitedNumber()); 
					  mapCartItem.put("limited_quantity",  cart.getLimitedQuantity()); 
					  lstCartItem.add(mapCartItem);
				  }
			  }
			  mapVendorCart.put("cart", lstCartItem);
			  //1.2供货商数据处理
			  mapVendor = new HashMap<String,Object>();
			  mapVendor.put("vendor_id", orderGenerate.getVendors().getVendorId());
			  mapVendor.put("vendor_name", orderGenerate.getVendors().getVendorName());
			  mapVendor.put("vendor_ename", orderGenerate.getVendors().getVendorEname());
			  BigDecimal vendor_subtotal = BusinessComputing.accountOrderByVendorId(lstCart, orderGenerate.getVendorId());
			  mapVendor.put("vendor_subtotal", vendor_subtotal.setScale(2,BigDecimal.ROUND_HALF_UP));
			  if(orderGenerate.getVendors().getVendorId().intValue()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
				  yamibuySubtotal = vendor_subtotal;
			  }
			  mapVendor.put("currency", "$");
			  mapVendorCart.put("vendor", mapVendor);
			  //1.3折扣活动信息处理
			  BigDecimal discountVendor = new BigDecimal(0.0);
			  if(null!=orderGenerate.getBonusId()&&null!=bonusType){
//			  if(null!=orderGenerate.getBonusId()&&bonusType.getIsPercentOff()==1){
				  mapBonus = new HashMap<String,Object>();
				  mapBonus.put("bonus_id", bonusType.getTypeId());
				  mapBonus.put("bonus_name", bonusType.getTypeDesc());
				  mapBonus.put("bonus_ename", bonusType.getTypeEdesc());
				  discountVendor = BusinessComputing.countPromoPriceByVendor(bonusType, lstCart, orderGenerate.getVendors()).getComputerPrice().setScale(2,BigDecimal.ROUND_HALF_UP);
				  mapBonus.put("discount", discountVendor);
				  mapBonus.put("currency", "$");
				  if(discountVendor.compareTo(new BigDecimal(0.0))>0){
					  mapVendorCart.put("bonus", mapBonus);
				  }
				  if(orderGenerate.getVendors().getVendorId().intValue()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
					  yamibuySubtotal = yamibuySubtotal.subtract(discountVendor);
				  }
				  mapVendor.put("vendor_subtotal", vendor_subtotal.subtract(discountVendor).setScale(2,BigDecimal.ROUND_HALF_UP));
				  mapVendor.put("before_vendor_subtotal", vendor_subtotal.setScale(2,BigDecimal.ROUND_HALF_UP));
			  }
			  //结算页面方法调用才统计该部分信息数据
			  if(fun_flag==1||fun_flag==2){
				  //1.4配送方式信息处理
				  if(null!=orderGenerate.getShippingId()){
					  mapShipping= new HashMap<String,Object>();
					  mapShipping.put("shipping_id", orderGenerate.getShippingId());
					  boolean free_shipping = false;
					  if(vendor_subtotal.subtract(discountVendor).compareTo(orderGenerate.getShipping().getFreeShippingAmount())>=0&&orderGenerate.getShipping().getFreeShippingAmount().compareTo(new BigDecimal(0.00))>0){
						  free_shipping = true;
					  }
					  else if(orderGenerate.getShipping().getShippingFee().compareTo(new BigDecimal(0.00))==0){
						  free_shipping = true; 
					  }
					  else{
						  shippingFeeTotal = shippingFeeTotal.add(orderGenerate.getShipping().getShippingFee());
					  }
					  mapShipping.put("free_shipping", free_shipping?1:0);
				  }
				  mapVendorCart.put("shipping", mapShipping);
				  //1.5积分使用信息
				  if(null!=orderGenerate.getPointFlag()){
					  pointFlag = orderGenerate.getPointFlag().intValue();
				  }
				  //1.6地址信息
				  userAddress = orderGenerate.getUserAddress();
			  }
			  mapVendorCart.put("currency", "$"); 
			  lstVendorCart.add(mapVendorCart);
		  }
		  
		  //2、金额信息处理
		  
		  //2.1商品原价金额合计
		  BigDecimal subtotal = BusinessComputing.accountOrder(lstCart);
		  mapAmount.put("subtotal", subtotal.setScale(2,BigDecimal.ROUND_HALF_UP));
		  //2.2折扣码
		  BigDecimal discount = new BigDecimal(0.00);
		  String bonus_sn= "";
		  ComputerResult computerResult4Dealprice = new ComputerResult();
		  if(null!=lstOrderGenerate.get(0).getBonusId()&&null!=bonusType){
			  bonus_sn = bonusType.getUserBonus().getBonusSn();
			  List<Vendors> lstBonusVendors = new ArrayList<Vendors>();
			  for(BonusVendor bonusVendor :bonusType.getLstBonusVendor()){
				  Vendors vendors = new Vendors();
				  vendors.setVendorId(bonusVendor.getVendorId());
				  lstBonusVendors.add(vendors);
			  }
			  computerResult4Dealprice = BusinessComputing.countPromoPrice(bonusType,lstCart,lstBonusVendors);
			  discount = computerResult4Dealprice.getComputerPrice();
		  }
		  if(discount.compareTo(new BigDecimal(0.0))==0){
			  cancelCode(token);
			  mapAmount.put("bonus_sn", "");
			  mapAmount.put("discount", discount.setScale(2,BigDecimal.ROUND_HALF_UP));
		  }else{
			  mapAmount.put("bonus_sn", bonus_sn);
			  mapAmount.put("discount", discount.setScale(2,BigDecimal.ROUND_HALF_UP));
		  }
		  //结算页面方法调用才统计该部分信息数据
		  BigDecimal tax = new BigDecimal(0.00);
		  BigDecimal point = new BigDecimal(0.00);
		  if(fun_flag==1||fun_flag==2){
			  //2.4运费合计值
			  mapAmount.put("shipping", shippingFeeTotal);
			  //2.5扣税合计值
			  ComputerResult computerResult4Tax = new ComputerResult();
			  if(null!=userAddress){
				  computerResult4Tax = BusinessComputing.countTax(users.getUserId(), lstCart, userAddress, taxLookup, computerResult4Dealprice.getComputerGoodResult());
				  tax = computerResult4Tax.getComputerPrice();
				  mapAmount.put("tax", tax);
			  }
			  //2.6积分使用值,只能YAMIBUY自营商品金额
			  int pointDisplay = 0;
			  if(users.getPayPoints()> yamibuySubtotal.multiply(new BigDecimal(100)).intValue()){
				  pointDisplay = yamibuySubtotal.multiply(new BigDecimal(100)).intValue();
				  if(pointFlag==1){
					  point = 	yamibuySubtotal;			  
				  }
			  }
			  else{
				  pointDisplay = users.getPayPoints();
				  if(pointFlag==1){
					  point = 	new BigDecimal(pointDisplay*0.01);			  
				  }
			  }
			  mapAmount.put("pointDisplay", pointDisplay);
			  mapAmount.put("pointFlag", pointFlag);
			  mapAmount.put("points", point.setScale(2,BigDecimal.ROUND_HALF_UP));
		  }
		  //2.7最终金额合计
		  BigDecimal amount = subtotal.add(shippingFeeTotal).add(tax).subtract(point).subtract(discount);
		  mapAmount.put("amount", amount.setScale(2,BigDecimal.ROUND_HALF_UP));
		  mapAmount.put("currency", "$");
		  result.put("total", mapAmount);	
		  result.put("vendorCart", lstVendorCart);	
		  result.put("token", token);
		  
		  
		  return result;
	  }
			/*
		 对计算后的礼品列表，做出相应数据库操作，并返回完整购物车信息
		@param Token  
		@param list 礼品列表
		@param goods 购物车
		@return List<Map<String,Object>> 补充赠品后的购物车信息
		*/
		public List<Cart> compare_gifts(Token token,List<Map<String,Object>> lstAct,List<Cart> listCartIn)  throws Exception{
			  //删除赠品信息
			  cartRedisService.deleteGift(token);
			  
		    	 List<Cart> listCart = new ArrayList<Cart>();
		    	 for(Cart cart:listCartIn){
		    		 if(cart.getIs_gift().intValue()==0){
		    			 listCart.add(cart) ;
		    		 }
		    	 }
		    	 //添加新赠品
		 		for(Map<String,Object> actMap:lstAct){
		 				Goods tempgoods = 	((ActivityGift)actMap.get("activityGift")).getGoods();
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
		 					Cart cartTemp = new Cart();
		 					cartTemp = cartRedisService.selectCartForRedisByGid(token, tempgoods.getGoodsId());
			 				 //添加赠品到返回的数据MAP
			 				 listCart.add(cartTemp);
		 				 }
		 		}
			  
			  return listCart;
		}
		
		

		
		/*
		 添加折扣码信息到ordergenerate
		 @param token		
		 @param code
		 @return Map<String,Object>	 
		*/
		private void  addCode(String token,int bonus_id)throws Exception{
			Gson gson = new Gson();  
			Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
			List<OrderGenerateRedis> orderGenerateTemp = orderGenerateRedisService.selectAll(tokenIn);
			for(OrderGenerateRedis orderGenerate:orderGenerateTemp){
				orderGenerate.setBonusId(bonus_id);
				orderGenerateRedisService.update(tokenIn, orderGenerate);
			}
		}
		

		/*
		 获取订单设置信息
		 @param token		
		 @param lstCart
		 @return BigDecimal 
		*/
		public Map<String,Object>  getOrderInfo(String token){
			Map<String,Object> result = new HashMap<String,Object>();
			Gson gson = new Gson();  
			Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
			List<OrderGenerateRedis> orderGenerateTemp = orderGenerateRedisService.selectAll(tokenIn);
			//未登陆处理
			if(tokenIn.getIsLogin()==0){
				 throw new YamiException(YamiConstant.ERRORCODE_ER1004,ErrorCodeEnum.ER1004.getMsg());
			}
			//登陆处理
			else if(orderGenerateTemp.size()>0){
				//地址查询
				if(orderGenerateTemp.get(0).getShippingAdd()!=null){
					UserAddress userAddress = userService.getAddressBookByAddId(orderGenerateTemp.get(0).getShippingAdd());
					if(null!=userAddress){
						Map<String,Object> userAddressMap = new HashMap<String,Object>();
						userAddressMap.put("address_id", userAddress.getAddress_id());
						userAddressMap.put("firstname", userAddress.getConsignee_firstname());
						userAddressMap.put("lastname", userAddress.getConsignee_lastname());
						userAddressMap.put("address1", userAddress.getAddress());
						userAddressMap.put("address2", userAddress.getAddress2());
						userAddressMap.put("city", userAddress.getCity());
						userAddressMap.put("state", userAddress.getProvince());
						userAddressMap.put("zipcode", userAddress.getZipcode());
						userAddressMap.put("phone", userAddress.getTel());
						result.put("userAddress", userAddressMap);
					}
				}
				//邮寄方式查询
				for(OrderGenerateRedis orderGenerate:orderGenerateTemp){
					Map<String,Object> VShipping = new HashMap<String,Object>();
					Map<String,Object> shippingMap = new HashMap<String,Object>();
					if(orderGenerate.getShippingId()!=null){
						Shipping shipping = shippingService.selectShippinginfo(Byte.parseByte(orderGenerate.getShippingId().toString()));
						if(null!=shipping){
							shippingMap.put("shipping_id", shipping.getShippingId());
							shippingMap.put("shippingName", shipping.getShippingName());
							shippingMap.put("shippingFee",shipping.getShippingFee());;
						}
					}
					VShipping.put("shipping", shippingMap);
					Vendors vendors = vendorsService.selectByPrimaryKey(orderGenerate.getVendorId());
					VShipping.put("vendor_id,", vendors.getVendorId());
					VShipping.put("vendor_name", vendors.getVendorName());
					VShipping.put("vendor_ename", vendors.getVendorEname());
					result.put("VShipping", VShipping);
				}
				//支付方式查询
				if(orderGenerateTemp.get(0).getProfileId()!=null){
					UserProfile userProfile = userService.getProfileByPid(orderGenerateTemp.get(0).getProfileId());
					if(null!=userProfile){
						Map<String,Object> userProfileMap = new HashMap<String,Object>();
						userProfileMap.put("profile_id", userProfile.getProfile_id().toString());
						userProfileMap.put("firstname", userProfile.getFirstname());
						userProfileMap.put("lastname",userProfile.getLastname());
						userProfileMap.put("type",userProfile.getCard_type());
						userProfileMap.put("tail",userProfile.getTail());
						userProfileMap.put("exp_year",userProfile.getExp_year());
						userProfileMap.put("exp_month",userProfile.getExp_month());
						UserAddress billAddress = userService.getAddressBookByAddId(userProfile.getAddress_id());
						
						
						if(null!=billAddress){
						Map<String,Object> mapBill = new HashMap<String,Object>();
						mapBill.put("address_id", billAddress.getAddress_id());
						mapBill.put("firstname", billAddress.getConsignee_firstname());
						mapBill.put("lastname", billAddress.getConsignee_lastname());
						mapBill.put("address1", billAddress.getAddress());
						mapBill.put("address2", billAddress.getAddress2());
						mapBill.put("city", billAddress.getCity());
						mapBill.put("state", billAddress.getProvince());
						mapBill.put("zipcode", billAddress.getZipcode());
						mapBill.put("phone", billAddress.getTel());
						userProfileMap.put("address", mapBill);
						}
						
						result.put("profile", userProfileMap);
					}else if(orderGenerateTemp.get(0).getProfileId().toString().equals("0")){
						Map<String,Object> userProfileMap = new HashMap<String,Object>();
						userProfileMap.put("profile_id", orderGenerateTemp.get(0).getProfileId().toString());
						result.put("profile", userProfileMap);
					}
				}
			}
			result.put("token", token);
			return result;
		}	
		
//		/*
//		获取邮寄方式总LIST
//		 @param token		
//		 @return List<Shipping> 
//		*/
//		public Map<String,Object>  getShippingList(String token){
//			Map<String,Object> result = new HashMap<String,Object>();
//			Map<String,Object> mapShipping = new HashMap<String,Object>();
//			Map<String,Object> mapVendor = new HashMap<String,Object>();
//			Map<String,Object> mapVendorTemp = new HashMap<String,Object>();
//			List<Map<String,Object>> lstShipping = new ArrayList<Map<String,Object>>();
//			List<Map<String,Object>> lstVendor = new ArrayList<Map<String,Object>>();
//			List<Shipping> lstShippingTemp = shippingService.selectShippingList();
//			for(Shipping shipping:lstShippingTemp){
//				Vendors vendors = vendorsService.selectByPrimaryKey(shipping.getVendorId());
//				mapVendorTemp.put(shipping.getVendorId().toString(), vendors);
//			}
//			BigDecimal freeShippingAmountVendor = new BigDecimal(0.0);
//			for(String key:mapVendorTemp.keySet()){
//				mapVendor = new HashMap<String,Object>();
//				freeShippingAmountVendor = new BigDecimal(0.0);
//				lstShipping = new ArrayList<Map<String,Object>>();
//				Vendors vendors = (Vendors)mapVendorTemp.get(key);
//				for(Shipping shipping:lstShippingTemp){
//					if(key.endsWith(shipping.getVendorId().toString())){
//						mapShipping = new HashMap<String,Object>();
//						mapShipping.put("shipping_id", shipping.getShippingId());
//						mapShipping.put("shippingName", shipping.getShippingName());
//						mapShipping.put("shippingFee", shipping.getShippingFee());
//						mapShipping.put("shippingDesc", shipping.getShippingDesc());
//						mapShipping.put("freeShippingAmount", shipping.getFreeShippingAmount());
//						mapShipping.put("is_primary", shipping.getIsPrimary());
//						if(shipping.getIsPrimary()==1){
//							freeShippingAmountVendor = shipping.getFreeShippingAmount();
//						}
//						lstShipping.add(mapShipping);
//					}
//				}
//				mapVendor.put("vendor_id", key);
//				mapVendor.put("vendor_name", vendors.getVendorName());
//				mapVendor.put("vendor_ename", vendors.getVendorEname());
//				mapVendor.put("freeShippingAmount", freeShippingAmountVendor);
//				mapVendor.put("shipping", lstShipping);
//				lstVendor.add(mapVendor);
//			}
//			result.put("token", token);
//			result.put("vendorShipping", lstVendor);
//			return result;
//		}
//		
//		/*
//		获取邮寄方式LIST
//		 @param token		
//		 @return List<Shipping> 
//		*/
//		public Map<String,Object>  getVendorShipping(String token,int vendor_id){
//			Map<String,Object> result = new HashMap<String,Object>();
//			Map<String,Object> mapShipping = new HashMap<String,Object>();
//			List<Map<String,Object>> lstShipping = new ArrayList<Map<String,Object>>();
//			List<Shipping> lstShippingTemp = shippingService.selectShippingListByVendorId(vendor_id);
//				for(Shipping shipping:lstShippingTemp){
//						mapShipping = new HashMap<String,Object>();
//						mapShipping.put("shipping_id", shipping.getShippingId());
//						mapShipping.put("shippingName", shipping.getShippingName());
//						mapShipping.put("shippingFee", shipping.getShippingFee());
//						mapShipping.put("shippingDesc", shipping.getShippingDesc());
//						mapShipping.put("freeShippingAmount", shipping.getFreeShippingAmount());
//						mapShipping.put("is_primary", shipping.getIsPrimary());
//						lstShipping.add(mapShipping);
//				}
//
//			result.put("token", token);
//			result.put("shipping", lstShipping);
//			return result;
//		}
		
//		/*
//		获取指定第三方包邮设置数值
//		 @param token		
//		 @return List<Shipping> 
//		*/
//		public Map<String,Object>  getVendorShippingFreeAmount(String token,int vendor_id){
//			Map<String,Object> result = new HashMap<String,Object>();
//			BigDecimal freeAmount = shippingService.selectFreeAmountByVendorId(vendor_id);
//			result.put("token", token);
//			result.put("freeAmount", freeAmount);
//			return result;
//		}
		
		   //更新用户订单配送方式信息
	     public Map<String,Object> chooseShipping(String token,int shipping_id,int vendor_id)throws Exception{
	    	 Map<String,Object> result = new HashMap<String,Object>();
	    	 Gson gson = new Gson();  
	  		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
	  	     //更新order_generate
	  		OrderGenerateRedis orderGenerate = orderGenerateRedisService.select(tokenIn, vendor_id);
	  		orderGenerate.setShippingId(shipping_id);
	  		orderGenerateRedisService.update(tokenIn, orderGenerate);
	  		result.put("token", token);
	 		result.put("status", 1);
	      	return result;
	 	}
	     //更新用户订单是否使用积分信息
	     public Map<String,Object> spendPoints(String token,int is_on)throws Exception{
	    	 Map<String,Object> result = new HashMap<String,Object>();
	    	 Gson gson = new Gson();  
	  		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
	  	  	//更新order_generate
	  		List<OrderGenerateRedis> lstOrderGenerate = orderGenerateRedisService.selectAll(tokenIn);
	  		for(OrderGenerateRedis orderGenerate:lstOrderGenerate){
	  			orderGenerate.setPointFlag(is_on);
		  		orderGenerateRedisService.update(tokenIn, orderGenerate);
	  		}
	  		result.put("token", token);
	 		result.put("status", 1);
	      	return result;
	 	}
	     //更新用户订单支付方式信息
	     public Map<String,Object> choosePayment(String token,String profile_id)throws Exception{
	    	 Map<String,Object> result = new HashMap<String,Object>();
	    	 Gson gson = new Gson();  
	  		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
	  	    //更新order_generate
	  		List<OrderGenerateRedis> lstOrderGenerate = orderGenerateRedisService.selectAll(tokenIn);
	  		for(OrderGenerateRedis orderGenerate:lstOrderGenerate){
	  			orderGenerate.setProfileId(profile_id);
		  		orderGenerateRedisService.update(tokenIn, orderGenerate);
	  		}
	  		result.put("token", token);
	 		result.put("status", 1);
	      	return result;
	 	}
	     //更新用户订单地址信息
	     public Map<String,Object> chooseAddress(String token,int address_id)throws Exception{
	    	 Map<String,Object> result = new HashMap<String,Object>();
	 		Gson gson = new Gson();  
	 		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
	 		//更新order_generate
	  		List<OrderGenerateRedis> lstOrderGenerate = orderGenerateRedisService.selectAll(tokenIn);
	  		for(OrderGenerateRedis orderGenerate:lstOrderGenerate){
	  			orderGenerate.setShippingAdd(address_id);
//	  			if(orderGenerate.getVendorId().intValue() == Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)&&orderGenerate.getShippingId().intValue()==YamiConstant.SHIPPING_ID_GESOO){
//	  				orderGenerate.setShippingId(null);
//	  			}
	  			
	  			
		  		orderGenerateRedisService.update(tokenIn, orderGenerate);
	  		}
	 		//修改为默认地址
	 		result.put("token", token);
	 		result.put("status", 1);
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
