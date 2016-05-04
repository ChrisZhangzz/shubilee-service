package com.shubilee.delegate;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.QueryParam;

import net.paymentech.ws.ProfileAddElement;
import net.paymentech.ws.ProfileChangeElement;
import net.paymentech.ws.ProfileDeleteElement;
import net.paymentech.ws.ProfileResponseElement;
import net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayLocator;
import net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayPortType;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.google.gson.Gson;
import com.shubilee.bean.ComputerGoodResult;
import com.shubilee.common.DateUtil;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.entity.ActivityGift;
import com.shubilee.entity.Blacklist;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Cart;
import com.shubilee.entity.CollectGoods;
import com.shubilee.entity.ExpressCheckout;
import com.shubilee.entity.Feedback;
import com.shubilee.entity.Goods;
import com.shubilee.entity.Integral;
import com.shubilee.entity.Message;
import com.shubilee.entity.MessageComment;
import com.shubilee.entity.MessageImage;
import com.shubilee.entity.MessagePost;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.OrderOrbitalGateway;
import com.shubilee.entity.OrderPaypal;
import com.shubilee.entity.PointLotterylog;
import com.shubilee.entity.PurchaseInfo;
import com.shubilee.entity.Sendmail;
import com.shubilee.entity.Shipping;
import com.shubilee.entity.Template;
import com.shubilee.entity.Token;
import com.shubilee.entity.User;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserProfile;
import com.shubilee.entity.Users;
import com.shubilee.entity.Vendors;
import com.shubilee.redis.entity.LotteryConfigRedis;
import com.shubilee.redis.entity.LotterySetRedis;
import com.shubilee.redis.entity.OrderGenerateRedis;
import com.shubilee.service.BlacklistService;
import com.shubilee.service.BonusLookupService;
import com.shubilee.service.CartRedisService;
import com.shubilee.service.CartService;
import com.shubilee.service.CollectGoodsService;
import com.shubilee.service.CompositeQueryService;
import com.shubilee.service.GoodsService;
import com.shubilee.service.OrderGenerateRedisService;
import com.shubilee.service.OrderGenerateService;
import com.shubilee.service.OrderGoodsService;
import com.shubilee.service.OrderInfoService;
import com.shubilee.service.PaymentService;
import com.shubilee.service.SendmailService;
import com.shubilee.service.ShippingService;
import com.shubilee.service.UserService;

@Service
public class TransactionDelegate {		

	@Autowired
	private UserService userService;	
	@Autowired
	private BlacklistService blacklistService;	
	@Autowired
	private CartServiceDelegateV2 cartRedisServiceDelegate;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CollectGoodsService collectGoodsService;
	@Autowired
	private CartService cartService;
	@Autowired
	private CartRedisService cartRedisService;
	@Autowired
	private OrderGenerateService orderGenerateService;
	@Autowired
	private OrderGenerateRedisService orderGenerateRedisService;
	@Autowired
	private CompositeQueryService compositeQueryService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private OrderGoodsService orderGoodsService;
	@Autowired
	private ShippingService shippingService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private SecurityServiceDelegate securityServiceDelegate;
	@Autowired
	private SendmailService sendmailService;
	@Autowired
	private BonusLookupService bonusLookupService;
	@Autowired
	private TemplateEngine templateEngine;

	//@Autowired
	//private LogUtil logger;
	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Value("${TOPIC_SENDMAIL}")
	private String TOPIC_SENDMAIL;
	@Value("${OGWS_CONNECTION_USERNAME}")
	private String OGWS_CONNECTION_USERNAME;
	@Value("${OGWS_CONNECTION_PASSWORD}")
	private String OGWS_CONNECTION_PASSWORD;
	@Value("${OGWS_MERCHANT_ID}")
	private String OGWS_MERCHANT_ID;
	@Value("${OGWS_URL}")
	private String OGWS_URL;
	@Value("${OGWS_VERSION}")
	private String OGWS_VERSION;
	@Value("${OGWS_TERMINALID}")
	private String OGWS_TERMINALID;
	@Value("${OGWS_BIN_SALEM}")
	private String OGWS_BIN_SALEM;
	@Value("${OGWS_BIN_PNS}")
	private String OGWS_BIN_PNS;
	@Value("${OGWS_TRANSTYPE_AC}")
	private String OGWS_TRANSTYPE_AC;
	@Value("${OGWS_INDUSTRYTYPE_EC}")
	private String OGWS_INDUSTRYTYPE_EC;
	@Value("${OGWS_CUSTOMER_PROFILE_ORDER_OVERIDE_NO}")
	private String OGWS_CUSTOMER_PROFILE_ORDER_OVERIDE_NO;
	@Value("${OGWS_CUSTOMER_PROFILE_FROM_ORDER_S}")
	private String OGWS_CUSTOMER_PROFILE_FROM_ORDER_S;
	@Value("${OGWS_CUSTOMER_ACCOUNT_TYPE_CC}")
	private String OGWS_CUSTOMER_ACCOUNT_TYPE_CC;
	
	
	public void transactionLogin(User user,Token tokenIn) throws Exception {

		//update new password(MD5) and ecSalt to DB.
		userService.setPasswordSalt(user);
		//update the userId of cart and clear tempId.
		if (null != tokenIn) {
			String tempId = tokenIn.getData();
			cartRedisServiceDelegate.updateUserIdByTempid(tempId,user.getUser_Id());
		}
	}
	
	public void transactionResetPassword(User user) throws Exception {

		//update new password(MD5) and ecSalt to DB.
		userService.setPasswordSaltByUid(user);

	}
	
	public void transactionNewAddress(UserAddress userAddress) throws Exception {

		//insert new UserAddress to DB.
		userService.insertAddress(userAddress);
	}
	
	public void transactionEditAddress(UserAddress userAddress,String profile_id) throws Exception {

		//update UserAddress to DB.
		userService.updateAddressByPK(userAddress);
		//clear address_id of the profile when edit the address.
		userService.updateProfileByAddressId(userAddress.getUser_id(),userAddress.getAddress_id(),profile_id);
	}
	
	public void transactionDeleteAddress(int address_id,int uid,int is_primary,String profile_id) throws Exception {

		//delete UserAddress from DB.
		userService.deleteAddressByPK(address_id);
		//If the address which will be deleted is a primary address.
		if(is_primary==YamiConstant.IS_PRIMARY){
			//update next address if exist to be a primary one.
			userService.updateAddressIsPrimaryByUid(uid);
		}
		//clear address_id of the profile when edit the address.
		userService.updateProfileByAddressId(uid,address_id,profile_id);
	}
	
	public void transactionAddOrderOrbitalGateway(OrderOrbitalGateway orderOrbitalGateway) throws Exception {

		//Update order_orbital_gateway.
		paymentService.insertOrderOrbitalGateway(orderOrbitalGateway);
	}
	
	public void transactionAddOrderPaypal(OrderPaypal orderPaypal) throws Exception {

		//Update order_paypal.
		paymentService.insertOrderPaypal(orderPaypal);
	}
	
	public void transactionNewPayment(UserProfile profile, String account,boolean addBlacklist) throws Exception {

		//Insert new profile to DB.
		userService.insertProfile(profile);
		//Send Profile Add Request to OrbitalGatewayWebService.
		ProfileResponseElement authResponse = null;
		//First Get the service
		PaymentechGatewayLocator service = new PaymentechGatewayLocator();
		//Create a Auth request
		ProfileAddElement authBean = new ProfileAddElement();
		//TODO Next create a port from the service
		PaymentechGatewayPortType portType = service.getPaymentechGateway(new URL(
				 OGWS_URL));
		//Testing merchant
		authBean.setOrbitalConnectionUsername( OGWS_CONNECTION_USERNAME);
		authBean.setOrbitalConnectionPassword( OGWS_CONNECTION_PASSWORD);
		authBean.setMerchantID( OGWS_MERCHANT_ID);
/*		//Next create a port from the service
		PaymentechGatewayPortType portType = service.getPaymentechGateway(new URL(
				YamiConstant.OGWS_URL));
		//Live merchant
		authBean.setOrbitalConnectionUsername(YamiConstant.OGWS_CONNECTION_USERNAME);
		authBean.setOrbitalConnectionPassword(YamiConstant.OGWS_CONNECTION_PASSWORD);
		authBean.setMerchantID(YamiConstant.OGWS_MERCHANT_ID);*/
		
		authBean.setVersion(OGWS_VERSION);
		authBean.setBin(OGWS_BIN_PNS);
		authBean.setCustomerProfileOrderOverideInd(OGWS_CUSTOMER_PROFILE_ORDER_OVERIDE_NO);
		authBean.setCustomerProfileFromOrderInd(OGWS_CUSTOMER_PROFILE_FROM_ORDER_S);
		authBean.setCustomerAccountType(OGWS_CUSTOMER_ACCOUNT_TYPE_CC);
		authBean.setCustomerRefNum(profile.getProfile_id().toString());
		authBean.setCcAccountNum(account);
		authBean.setCcExp(profile.getExp_year()+profile.getExp_month());
		//authBean.setCustomerZIP(zipcode);
		//Invoke the newOrder service and print reponse
		try {
			authResponse = portType.profileAdd(authBean);
		} catch (Exception ie) {
			logger.error("######### Error Response ##############");
			logger.error(ie.toString());
			String err = ie.toString().split(" ")[2];
			if(YamiConstant.OGWS_CARD_ERROR_839.equals(err) || YamiConstant.OGWS_CARD_ERROR_841.equals(err)){
				throw new YamiException(YamiConstant.ERRORCODE_ER1313,ErrorCodeEnum.ER1313.getMsg());
			}else{
				throw new YamiException(YamiConstant.ERRORCODE_ER1311,ErrorCodeEnum.ER1311.getMsg());				
			}
		}
		try {
			if(addBlacklist){
				Blacklist blacklist = new Blacklist();
				blacklist.setUserId(profile.getUser_id());
				blacklist.setAddTime(Integer.parseInt(DateUtil.getNowLong().toString()));
				blacklist.setOrigin(1);
				blacklist.setType(1);
				blacklistService.insert(blacklist);
			}
		} catch (Exception ie) {
			logger.error("Failed to add account to blacklist");
			logger.error(ie.toString());
		}
		logger.info("###Response Received ###");
		logger.info(" ProcStatus: " + authResponse.getProcStatus());
		logger.info(" ProcStatusMessage: " + authResponse.getProcStatusMessage());
	}
	
	public void transactionEditPayment(UserProfile profile) throws Exception {

		//Insert new profile to DB.
		userService.updateProfileByPK(profile);
		//Send Profile Add Request to OrbitalGatewayWebService.
		ProfileResponseElement authResponse = null;
		//First Get the service
		PaymentechGatewayLocator service = new PaymentechGatewayLocator();
		//Create a Auth request
		ProfileChangeElement authBean = new ProfileChangeElement();
		//TODO Next create a port from the service
		PaymentechGatewayPortType portType = service.getPaymentechGateway(new URL(
				OGWS_URL));
		//Testing merchant
		authBean.setOrbitalConnectionUsername(OGWS_CONNECTION_USERNAME);
		authBean.setOrbitalConnectionPassword(OGWS_CONNECTION_PASSWORD);
		authBean.setMerchantID(OGWS_MERCHANT_ID);
/*		//Next create a port from the service
		PaymentechGatewayPortType portType = service.getPaymentechGateway(new URL(
				YamiConstant.OGWS_URL));
		//Live merchant
		authBean.setOrbitalConnectionUsername(YamiConstant.OGWS_CONNECTION_USERNAME);
		authBean.setOrbitalConnectionPassword(YamiConstant.OGWS_CONNECTION_PASSWORD);
		authBean.setMerchantID(YamiConstant.OGWS_MERCHANT_ID);*/
		
		authBean.setVersion(OGWS_VERSION);
		authBean.setBin(OGWS_BIN_PNS);
		authBean.setCustomerProfileOrderOverideInd(OGWS_CUSTOMER_PROFILE_ORDER_OVERIDE_NO);
		authBean.setCustomerAccountType(OGWS_CUSTOMER_ACCOUNT_TYPE_CC);
		authBean.setCustomerRefNum(profile.getProfile_id().toString());
		authBean.setCcExp(profile.getExp_year()+profile.getExp_month());
		//authBean.setCustomerZIP(zipcode);
		//Invoke the newOrder service and print reponse
		try {
			authResponse = portType.profileChange(authBean);
		} catch (Exception ie) {
			logger.error("######### Error Response ##############");
			logger.error(ie.toString());
			String err = ie.toString().split(" ")[2];
			if(YamiConstant.OGWS_CARD_ERROR_839.equals(err) || YamiConstant.OGWS_CARD_ERROR_841.equals(err)){
				throw new YamiException(YamiConstant.ERRORCODE_ER1313,ErrorCodeEnum.ER1313.getMsg());
			}else{
				throw new YamiException(YamiConstant.ERRORCODE_ER1311,ErrorCodeEnum.ER1311.getMsg());				
			}
		}
		logger.info("###Response Received ###");
		logger.info(" ProcStatus: " + authResponse.getProcStatus());
		logger.info(" ProcStatusMessage: " + authResponse.getProcStatusMessage());
	}	
	
	public void transactionEditPaymentAddress(int address_id, String profile_id) throws Exception {

		//Update AddressId.
		userService.updateProfileAddressIdByPK(address_id,profile_id);

	}	
	
	public void transactionDeletePayment(String profile_id,int uid,int is_primary) throws Exception {

		//Insert new profile to DB.
		userService.deleteProfileByPK(profile_id);
		//If the profile which will be deleted is a primary profile.
		if(is_primary==YamiConstant.IS_PRIMARY){
			//update next profile if exist to be a primary one.
			userService.updateProfileIsPrimaryByUid(uid);
		}		
		//Send Profile Add Request to OrbitalGatewayWebService.
		ProfileResponseElement authResponse = null;
		//First Get the service
		PaymentechGatewayLocator service = new PaymentechGatewayLocator();		
		//Create a Auth request
		ProfileDeleteElement authBean = new ProfileDeleteElement();
		//TODO Next create a port from the service
		PaymentechGatewayPortType portType = service.getPaymentechGateway(new URL(
				OGWS_URL));
		//Testing merchant
		authBean.setOrbitalConnectionUsername(OGWS_CONNECTION_USERNAME);
		authBean.setOrbitalConnectionPassword(OGWS_CONNECTION_PASSWORD);
		authBean.setMerchantID(OGWS_MERCHANT_ID);
/*		//Next create a port from the service
		PaymentechGatewayPortType portType = service.getPaymentechGateway(new URL(
				YamiConstant.OGWS_URL));
		//Live merchant
		authBean.setOrbitalConnectionUsername(YamiConstant.OGWS_CONNECTION_USERNAME);
		authBean.setOrbitalConnectionPassword(YamiConstant.OGWS_CONNECTION_PASSWORD);
		authBean.setMerchantID(YamiConstant.OGWS_MERCHANT_ID);*/
		
		authBean.setVersion(OGWS_VERSION);
		authBean.setBin(OGWS_BIN_PNS);
		authBean.setCustomerRefNum(profile_id.toString());
		//Invoke the newOrder service and print reponse
		try {
			authResponse = portType.profileDelete(authBean);
		} catch (Exception ie) {
			logger.error("######### Error Response ##############");
			logger.error(ie.toString());
			throw new YamiException(YamiConstant.ERRORCODE_ER1311,ErrorCodeEnum.ER1311.getMsg());
		}
		logger.info("###Response Received ###");
		logger.info(" ProcStatus: " + authResponse.getProcStatus());
		logger.info(" ProcStatusMessage: " + authResponse.getProcStatusMessage());
	}	
	
	//更新购物车商品数量
	public int transactionUpdateGoodNumOfCart(Token token,int goods_id,int goods_number){
		if(token.getIsLogin()==0){
			return cartService.updateGoodsByTempid(token.getData(), goods_id, goods_number);
		}else{
			return cartService.updateGoodsByUid(Integer.parseInt(token.getData()), goods_id, goods_number);
		}
	}
	//删除购物车商品
	public int transactionDelGoodOfCart(Token token,int vendor_id,int goods_id){
		int result = 0;
		List<Cart> lstCart = new ArrayList<Cart>();
		if(token.getIsLogin()==0){
			result = cartService.deleteGoodsByTempid(token.getData(), goods_id);
			lstCart = cartService.selectCartsBySession_idAndVendorId(token.getData(), vendor_id);
			if(lstCart.size()==0){
				orderGenerateService.deleteByTempIdAndVendorId(token.getData(), vendor_id);
			}
		}else{
			result = cartService.deleteGoodsByUid(Integer.parseInt(token.getData()), goods_id);
			lstCart = cartService.selectCartsByUseridAndVendorId(Integer.parseInt(token.getData()), vendor_id);
			if(lstCart.size()==0){
				orderGenerateService.deleteByUIdAndVendorId(Integer.parseInt(token.getData()),  vendor_id);
			}
		}
		return result;
	}
	//更新购物车商品数量
	public int transactionUpdateGoodNumOfCart(int rec_id,int goods_number){
		return cartService.updateGoodNumOfCart(rec_id,goods_number);
	}
	//添加商品到购物车
    public int transactionAddItemToCart(Cart cart){
    	return cartService.addItemToCart(cart);
	}
    //删除购物车中赠品信息
	public void transactionDelCartAct(Token token) {
		//删除购物车中现有赠品  
			if(token.getIsLogin()==0){
				cartService.deleteActByTempid(token.getData());
			}else{
				cartService.deleteActByUid(Integer.parseInt(token.getData()));
			} 
	 }
	
	
	//更新购物车中赠品信息，先全部删除，后添加
		public void transactionUpdateCartAct(Token token,List<Goods> lstGift) {
			//删除购物车中现有赠品  
				if(token.getIsLogin()==0){
					cartService.deleteActByTempid(token.getData());
				}else{
					cartService.deleteActByUid(Integer.parseInt(token.getData()));
				} 
			//添加新赠品	
				for(Goods gift:lstGift){
	 				Goods tempgoods = 	goodsService.selectByPrimaryKey(gift.getGoodsId());
	 				//需要赠送礼品数量
	 				int giftNumber = (int)gift.getGoodsNumber();
	 				
	 				 //添加赠品到数据库
	 				 Cart cartTemp = new Cart();
	 				 if(token.getIsLogin()==0){
	 					cartTemp.setUser_id(0);
	 					cartTemp.setSession_id(token.getData()); 
	 				 }else{
	 					cartTemp.setUser_id(Integer.parseInt(token.getData())); 
	 					cartTemp.setSession_id("");
	 				 }
	 				 cartTemp.setGoods_id(tempgoods.getGoodsId());
	 				 cartTemp.setGoods_number(Integer.parseInt(String.valueOf(giftNumber)));
	 				 cartTemp.setIs_gift(Short.parseShort("1"));
	 				 cartTemp.setGoods_sn(tempgoods.getGoodsSn());
	 				//Product_id暂时给默认值0
	 				 cartTemp.setProduct_id(0);
	 				 cartTemp.setGoods_name(tempgoods.getGoodsName());
	 				 cartTemp.setGoods_ename(tempgoods.getGoodsEname());
	 				 cartTemp.setCost(tempgoods.getCost());
	 				//添加商品到购物车阶段，tax数值默认为0
	 				 cartTemp.setTax(BigDecimal.valueOf(0.00));
	 				 cartTemp.setMarket_price(BigDecimal.valueOf(0.00));
	 				 cartTemp.setGoods_price(BigDecimal.valueOf(0.00));
	 				//添加商品到购物车阶段，Goods_Attr数值默认为""
	 				 cartTemp.setGoods_attr("");
	 				//添加商品到购物车阶段，is_real数值默认为false
	 				 cartTemp.setIs_real(false);
	 				 cartTemp.setExtension_code(tempgoods.getExtensionCode());
	 				//添加商品到购物车阶段，parent_Id数值默认为0
	 				 cartTemp.setParent_id(0);
	 				//添加商品到购物车阶段，rec_type数值默认为false
	 				 cartTemp.setRec_type(false);
	 				 cartTemp.setIs_shipping(tempgoods.getIsShipping());
	 				//添加商品到购物车阶段，can_handsel数值默认为0
	 				 cartTemp.setCan_handsel((byte)0);
	 				//添加商品到购物车阶段，Goods_Attr_Id数值默认为""
	 				 cartTemp.setGoods_attr_id("");
	 				//添加商品到购物车阶段，Deal_Price数值默认为0
	 				 cartTemp.setDeal_price(BigDecimal.valueOf(0.00));
	 				 cartService.addItemToCart(cartTemp);
	 		}		
		 }
	
	
	
	
	 //添加购物车中赠品信息
     public List<Map<String,Object>> transactionAddCartAct(Token token,List<Map<String,String>> lstAct,List<Map<String,Object>> listCartTemp) {
    	 Map<String,Object> tempMap;
    	 List<Map<String,Object>> listCart = new ArrayList<Map<String,Object>>();
    	 for(Map<String,Object> cartGoods:listCartTemp){
    		 int is_gift = Integer.parseInt(cartGoods.get("is_gift").toString());
    		 if(is_gift==0){
    			 listCart.add(cartGoods) ;
    		 }
    	 }
    	 
    	 
    	 
    	 //添加新赠品
 		for(Map<String,String> actMap:lstAct){
 				Goods tempgoods = 	goodsService.selectByPrimaryKey(Integer.parseInt(actMap.get("goods_id")));
 				//需要赠送礼品数量
 				int giftNumber = Integer.parseInt(actMap.get("gift_number"));
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
 				 //添加赠品到数据库
 				 Cart cartTemp = new Cart();
 				 if(token.getIsLogin()==0){
 					cartTemp.setUser_id(0);
 					cartTemp.setSession_id(token.getData()); 
 				 }else{
 					cartTemp.setUser_id(Integer.parseInt(token.getData())); 
 					cartTemp.setSession_id("");
 				 }
 				 cartTemp.setGoods_id(tempgoods.getGoodsId());
 				 cartTemp.setGoods_number(Integer.parseInt(String.valueOf(giftNumber)));
 				 cartTemp.setIs_gift(Short.parseShort("1"));
 				 cartTemp.setGoods_sn(tempgoods.getGoodsSn());
 				//Product_id暂时给默认值0
 				 cartTemp.setProduct_id(0);
 				 cartTemp.setGoods_name(tempgoods.getGoodsName());
 				 cartTemp.setGoods_ename(tempgoods.getGoodsEname());
 				 cartTemp.setCost(tempgoods.getCost());
 				//添加商品到购物车阶段，tax数值默认为0
 				 cartTemp.setTax(BigDecimal.valueOf(0.00));
 				 cartTemp.setMarket_price(BigDecimal.valueOf(0.00));
 				 cartTemp.setGoods_price(BigDecimal.valueOf(0.00));
 				//添加商品到购物车阶段，Goods_Attr数值默认为""
 				 cartTemp.setGoods_attr("");
 				//添加商品到购物车阶段，is_real数值默认为false
 				 cartTemp.setIs_real(false);
 				 cartTemp.setExtension_code(tempgoods.getExtensionCode());
 				//添加商品到购物车阶段，parent_Id数值默认为0
 				 cartTemp.setParent_id(0);
 				//添加商品到购物车阶段，rec_type数值默认为false
 				 cartTemp.setRec_type(false);
 				 cartTemp.setIs_shipping(tempgoods.getIsShipping());
 				//添加商品到购物车阶段，can_handsel数值默认为0
 				 cartTemp.setCan_handsel((byte)0);
 				//添加商品到购物车阶段，Goods_Attr_Id数值默认为""
 				 cartTemp.setGoods_attr_id("");
 				//添加商品到购物车阶段，Deal_Price数值默认为0
 				 cartTemp.setDeal_price(BigDecimal.valueOf(0.00));
 				cartTemp.setVendor_id(Integer.parseInt(tempgoods.getVendorId().toString()));
 				
 				 if(giftNumber<=tempgoods.getGoodsNumber()&&tempgoods.getIsOnSale()&&!tempgoods.getIsDelete()){
	 				cartService.addItemToCart(cartTemp);
	 				int rec_id=0;
	 				 if(token.getIsLogin()==0){
	  					rec_id = cartService.selectRecidByTempidGid(token.getData(), tempgoods.getGoodsId());
	  				 }else{
	  					rec_id = cartService.selectRecidByUidGid(Integer.parseInt(token.getData()), tempgoods.getGoodsId());
	  				 }
	 				 tempMap.put("rec_id", rec_id); 
	 				 //添加赠品到返回的数据MAP
	 				 listCart.add(tempMap);
 				 }
 		}
 		  return listCart;
	 }
   //添加购物车中赠品信息
     public List<Cart> transactionAddCartActV2(Token token,List<Map<String,Object>> lstAct,List<Cart> listCartIn) {
    	 Map<String,Object> tempMap;
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
 				 Cart cartTemp = new Cart();
 				 if(token.getIsLogin()==0){
 					cartTemp.setUser_id(0);
 					cartTemp.setSession_id(token.getData()); 
 				 }else{
 					cartTemp.setUser_id(Integer.parseInt(token.getData())); 
 					cartTemp.setSession_id("");
 				 }
 				 cartTemp.setGoods_id(tempgoods.getGoodsId());
 				 cartTemp.setGoods_number(Integer.parseInt(String.valueOf(giftNumber)));
 				 cartTemp.setIs_gift(Short.parseShort("1"));
 				 cartTemp.setGoods_sn(tempgoods.getGoodsSn());
 				//Product_id暂时给默认值0
 				 cartTemp.setProduct_id(0);
 				 cartTemp.setGoods_name(tempgoods.getGoodsName());
 				 cartTemp.setGoods_ename(tempgoods.getGoodsEname());
 				 cartTemp.setCost(tempgoods.getCost());
 				//添加商品到购物车阶段，tax数值默认为0
 				 cartTemp.setTax(BigDecimal.valueOf(0.00));
 				 cartTemp.setMarket_price(BigDecimal.valueOf(0.00));
 				 cartTemp.setGoods_price(BigDecimal.valueOf(0.00));
 				//添加商品到购物车阶段，Goods_Attr数值默认为""
 				 cartTemp.setGoods_attr("");
 				//添加商品到购物车阶段，is_real数值默认为false
 				 cartTemp.setIs_real(false);
 				 cartTemp.setExtension_code(tempgoods.getExtensionCode());
 				//添加商品到购物车阶段，parent_Id数值默认为0
 				 cartTemp.setParent_id(0);
 				//添加商品到购物车阶段，rec_type数值默认为false
 				 cartTemp.setRec_type(false);
 				 cartTemp.setIs_shipping(tempgoods.getIsShipping());
 				//添加商品到购物车阶段，can_handsel数值默认为0
 				 cartTemp.setCan_handsel((byte)0);
 				//添加商品到购物车阶段，Goods_Attr_Id数值默认为""
 				 cartTemp.setGoods_attr_id("");
 				//添加商品到购物车阶段，Deal_Price数值默认为0
 				 cartTemp.setDeal_price(BigDecimal.valueOf(0.00));
 				cartTemp.setVendor_id(Integer.parseInt(tempgoods.getVendorId().toString()));
 				
 				 if(giftNumber<=tempgoods.getGoodsNumber()&&tempgoods.getIsOnSale()&&!tempgoods.getIsDelete()){
	 				cartService.addItemToCart(cartTemp);
	 				if(token.getIsLogin()==0){
	 					cartTemp = cartService.selectCarts4ViewByTemp_idGoodsid(token.getData(), tempgoods.getGoodsId());
	 				}else{
	 					cartTemp = cartService.selectCarts4ViewByUidGoodsid(Integer.parseInt(token.getData()), tempgoods.getGoodsId());
	 				}
	 				 //添加赠品到返回的数据MAP
	 				 listCart.add(cartTemp);
 				 }
 		}
 		  return listCart;
	 }
      //添加订单预处理信息
     public void transactionAddOrderGenerate(OrderGenerate orderGenerate){
     	 orderGenerateService.addOrderGenerate(orderGenerate);
 	}
     //添加订单预处理信息(可部分为空NULL)
     public void transactionAddOrderGenerateSelective(OrderGenerate orderGenerate){
     	 orderGenerateService.addOrderGenerateSelective(orderGenerate);
 	}
     //更新订单预处理信息
     public int transactionUpdateOrderGenerateByTempId(OrderGenerate orderGenerate){
     	return orderGenerateService.updateOrderGenerateByTempId(orderGenerate);
 	}
     //更新订单预处理信息
     public int transactionUpdateOrderGenerateByUId(OrderGenerate orderGenerate){
     	return orderGenerateService.updateOrderGenerateByUId(orderGenerate);
 	}
     
   //更新订单折扣码理信息
     public int transactionUpdateBonsIdByTempId(String temp_id,Integer bonus_id){
     	return orderGenerateService.updateBonsIdByTempId(temp_id, bonus_id);
 	}
     //更新订单折扣码预处理信息
     public int transactionUpdateBonsIdByUId(int user_id,Integer bonus_id){
     	return orderGenerateService.updateBonsIdByUId(user_id, bonus_id);
 	}
     //删除订单预处理信息
     public int transactionDelOrderGenerateByTempIdAndVendorId(String temp_id,int vendor_id){
    	 return orderGenerateService.deleteByTempIdAndVendorId(temp_id, vendor_id);
     }
     //删除订单预处理信息
     public int transactionDelOrderGenerateByUIdAndVendorId(int user_id,int vendor_id){
    	 return orderGenerateService.deleteByUIdAndVendorId(user_id, vendor_id);
     }
     //更新购物车商品扣税信息
     public int transactionUpdateTaxByUidAndGid(int uid,int goods_id,BigDecimal tax){
     	return cartService.updateTaxByUidAndGid(uid, goods_id, tax);
 	}
   //更新购物车商品扣税信息
     public int transactionUpdateTaxByUId(int uid,BigDecimal tax){
     	return cartService.updateTaxByUid(uid, tax);
 	}
   //更新用户订单地址信息
     public Map<String,Object> transactionChooseAddress(String token,int address_id){
    	 Map<String,Object> result = new HashMap<String,Object>();
 		Gson gson = new Gson();  
 		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
 		//更新order_generate
 		orderGenerateService.updateShippingAddByUId(Integer.parseInt(tokenIn.getData()), address_id);
 		//修改为默认地址
 		//userService.updateAddressIsPrimaryByPKUid(Integer.parseInt(tokenIn.getData()), address_id);
 		result.put("token", token);
 		result.put("status", 1);
     	return result;
 	}
   //更新用户订单配送方式信息
     public Map<String,Object> transactionChooseShipping(String token,int shipping_id,int vendor_id){
    	 Map<String,Object> result = new HashMap<String,Object>();
    	 Gson gson = new Gson();  
  		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
  	     //更新order_generate
  		orderGenerateService.updateShippingIdByUId(Integer.parseInt(tokenIn.getData()), shipping_id, vendor_id);
  		result.put("token", token);
 		result.put("status", 1);
      	return result;
 	}
   //更新用户订单支付方式信息
     public Map<String,Object> transactionChoosePayment(String token,String profile_id){
    	 Map<String,Object> result = new HashMap<String,Object>();
    	 Gson gson = new Gson();  
  		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
  	    //更新order_generate
 		orderGenerateService.updateProfileIdByUId(Integer.parseInt(tokenIn.getData()), profile_id);
  		//修改为默认支付方式
  		//userService.updateProfileIsPrimaryByPKUid(Integer.parseInt(tokenIn.getData()), BigDecimal.valueOf(profile_id));
  		result.put("token", token);
 		result.put("status", 1);
      	return result;
 	}
   //更新用户订单是否使用积分信息
     public Map<String,Object> transactionSpendPoints(String token,int is_on){
    	 Map<String,Object> result = new HashMap<String,Object>();
    	 Gson gson = new Gson();  
  		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
  	  	//更新order_generate
  	 	orderGenerateService.updatePointFlagByUId(Integer.parseInt(tokenIn.getData()), is_on);
  		result.put("token", token);
 		result.put("status", 1);
      	return result;
 	}
     
     
 	/**
      * 提交订单
      * @param uid
      * @param lstCart 购物车信息
      * @param lstGoods 购物车中对应的商品的原始信息
      * @param lstOrderGenerate 订单信息
      * @throws Exception
      * @author James
      */
     public int transactionOrder(int uid,List<Cart> lstCart,List<Goods> lstGoods,List<OrderGenerate> lstOrderGenerate,Map<String,Object> mapCheckOut,Map<String,Object> mapViewCart,String ip,String userAgent,int source_flag)throws Exception{
    	 int result = 0;
    	 BigDecimal purchasePoints = (BigDecimal)mapCheckOut.get("points");
    	 List<Map<String,Object>> lstVendorStat = (ArrayList<Map<String,Object>>)mapViewCart.get("vendorCart");
    	 Map<String,BigDecimal> mapVendorPerent = new HashMap<String,BigDecimal>();
    	 Users users = userService.selectUserInfoByUid(uid);
	    //1.2修改折扣使用次数
  		
  		
  		
  		
  		OrderInfo orderInfo;
  		int j=1;
  		int purchase_id=1;
  		for(OrderGenerate orderGenerate:lstOrderGenerate){
  			//收货人信息
  			UserAddress userAddress = userService.getAddressBookByAddId(orderGenerate.getShippingAdd());
  		
  			if(userAddress.getProvince().equals(YamiConstant.PROVINCE_ALASKA)||userAddress.getProvince().equals(YamiConstant.PROVINCE_HAWAII)){
  				if(orderGenerate.getVendorId()!=Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
  					throw new YamiException(YamiConstant.ERRORCODE_ER1111,ErrorCodeEnum.ER1111.getMsg());
  				}
  			}
  			
  			
  			
  			
  			orderInfo = new OrderInfo();
  		    //获取订单号
 		     String order_sn = StringUtil.GetOrderSN();
 		     //判断新ORDER_SN是否存在
 		     int orderSnNum = orderInfoService.selectOrderInfoNumByOrderSn(order_sn);
 		     for(int i=0;i>-1;i++){
 		    	order_sn = StringUtil.GetOrderSN();
 		    	orderSnNum = orderInfoService.selectOrderInfoNumByOrderSn(order_sn);
 		    	 if(orderSnNum==0){
 		    		 break;
 		    	 }
 		     }
 		     //活动信息
 		    BonusType bonusType=null;
 		     if(orderGenerate.getBonusId()!=null){
 		    bonusType = compositeQueryService.selectBonusByBonusId(orderGenerate.getBonusId());
 		     }

  			//配送方式
  			Shipping shipping = shippingService.selectShippinginfo(Byte.valueOf(orderGenerate.getShippingId().toString()));
  			//支付方式
  			UserProfile userProfile = new UserProfile();
  			UserAddress billAddress;
  			if(orderGenerate.getProfileId().equals("0")){
  				userProfile.setProfile_id("0");
  				billAddress = userAddress;
  			}else{
  				userProfile = userService.getProfileByPid(orderGenerate.getProfileId());
  				     billAddress = userService.getAddressBookByAddId(userProfile.getAddress_id());
  				     if(null==billAddress){
  				    	throw new YamiException(YamiConstant.ERRORCODE_ER1109,ErrorCodeEnum.ER1109.getMsg());
  				     }
  				
  				
  			}
  			
  			
  			//设置订单信息
  			//订单号
  			orderInfo.setOrderSn(order_sn);
  			//purchase_id
  			//orderInfo.setPurchaseId(0);
  			orderInfo.setUserId(uid);
  			//订单状态。0，未确认；1，已确认；2，已取消；3，无效；4，退货；
  			orderInfo.setOrderStatus(1);
  		    //商品配送情况，0，未发货；1，已发货；2，已收货；3，备货中
  			orderInfo.setShippingStatus(0);
  		    //支付状态；0，未付款；1，付款中；2，已付款
  			orderInfo.setPayStatus(0);
  			orderInfo.setConsignee(userAddress.getConsignee());
  			orderInfo.setVendorId(orderGenerate.getVendorId());
  			orderInfo.setCountry(userAddress.getCountry());
  			orderInfo.setProvince(userAddress.getProvince());
  			orderInfo.setCity(userAddress.getCity());
  			orderInfo.setDistrict(userAddress.getDistrict().toString());
  			orderInfo.setAddress(userAddress.getAddress());
  			orderInfo.setAddress2(userAddress.getAddress2());
  			orderInfo.setZipcode(userAddress.getZipcode());
  			orderInfo.setTel(userAddress.getTel());
  			orderInfo.setMobile(userAddress.getMobile());
  			orderInfo.setEmail(userAddress.getEmail());
  			//收货人的最佳送货时间
  			orderInfo.setBestTime("");
  		    //收货人的地址的标志性建筑
  			orderInfo.setSignBuilding("");
  		    //订单附言
  			orderInfo.setPostscript("");
  			orderInfo.setShippingId(shipping.getShippingId());
  			orderInfo.setShippingName(shipping.getShippingName());
  			if(String.valueOf(userProfile.getProfile_id()).equals("0")){
	  			orderInfo.setPayId(Byte.valueOf("3"));
	  			orderInfo.setPayName("paypal");
	  			orderInfo.setAbnormal(Byte.valueOf("0"));
	  			orderInfo.setProfileId("0");
  			}else{
  				orderInfo.setPayId(Byte.valueOf("4"));
	  			orderInfo.setPayName("credit card");
	  			orderInfo.setProfileId(userProfile.getProfile_id());
	  			orderInfo.setFirstname(userProfile.getFirstname());
	  			orderInfo.setLastname(userProfile.getLastname());
	  			orderInfo.setCardType(userProfile.getCard_type());
	  			orderInfo.setTail(userProfile.getTail());
	  			orderInfo.setExpYear(userProfile.getExp_year());
	  			orderInfo.setExpMonth(userProfile.getExp_month());
	  			
	  		   //黑名单判断
	  			int blackCount = orderInfoService.selectBlackListResult(uid,null,users.getMobilePhone());
	  			
	  			if(blackCount>0){
	  				orderInfo.setAbnormal(Byte.valueOf("1"));
	  			}else{
	  				orderInfo.setAbnormal(Byte.valueOf("0"));	
	  			}
  			}
  			//缺货处理方式，等待所有商品备齐后再发； 取消订单；与店主协商
  			orderInfo.setHowOos("");
  			//不知道这个字段什么意思
  			orderInfo.setHowSurplus("");
  			//包装名称
  			orderInfo.setPackName("");
  			//贺卡名称
  			orderInfo.setCardName("");
  		    //贺卡内容
  			orderInfo.setCardMessage("");
  			//发票头
  			orderInfo.setInvPayee("");
  			//发票内容
  			orderInfo.setInvContent("");
  			//商品成本金额
  			BigDecimal costAmount = new BigDecimal(0.00);
  			//商品销售金额
  			BigDecimal goodsAmount = new BigDecimal(0.00);
  		    //商品扣税金额
  			BigDecimal taxAmount = new BigDecimal(0.00);
  			for(Cart cart:lstCart){
  				if(orderGenerate.getVendorId()==cart.getVendor_id()){
  					costAmount = costAmount.add(cart.getCost().multiply(BigDecimal.valueOf(cart.getGoods_number())));
  					goodsAmount =  goodsAmount.add(cart.getGoods_price().multiply(BigDecimal.valueOf(cart.getGoods_number())));
  					taxAmount = taxAmount.add(cart.getTax());
  				}
  			}
  		    //商品成本金额
  			orderInfo.setCostAmount(costAmount);
  			//商品销售金额
  			orderInfo.setGoodsAmount(goodsAmount);
  		    //运费金额
  			BigDecimal shippingFee = new BigDecimal(0.00);
  			 //使用折扣红包金额
  			BigDecimal bonus = new BigDecimal(0.00);
  			 for(Map<String,Object> mapTemp:lstVendorStat){
  	    		 if(orderGenerate.getVendorId()==Integer.parseInt(((HashMap<String,Object>)mapTemp.get("vendor")).get("vendor_id").toString())){
  	    			 //使用折扣红包金额
  	    			 if(mapTemp.get("bonus")!=null){
  	    			    bonus =  BigDecimal.valueOf(Double.parseDouble(((HashMap<String,Object>)mapTemp.get("bonus")).get("discount").toString()));
  	    			 }
  	     			orderInfo.setBonus(bonus);
  	    			 //运费
  	    			 if(((HashMap<String,Object>)mapTemp.get("shipping")).get("free_shipping").toString().equals("0")){
  	    				shippingFee=  shippingService.selectShippinginfo(Byte.valueOf(((HashMap<String,Object>)mapTemp.get("shipping")).get("shipping_id").toString())).getShippingFee();
  	    			 }
  	    		 }
  	    	 }
  			 
  			 if(bonus.compareTo(new BigDecimal(0))==0&&new BigDecimal(mapCheckOut.get("discount").toString()).compareTo(new BigDecimal(0.0))>0){
  				if(orderGenerate.getVendorId()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
  					bonus = new BigDecimal(mapCheckOut.get("discount").toString());
  				}
  			 }
  			orderInfo.setBonus(bonus);
  		    //红包的id
  			if(bonus.compareTo(new BigDecimal(0))>0){
  			orderInfo.setBonusId(orderGenerate.getBonusId()==null?0:orderGenerate.getBonusId());
  			}else{
  				orderInfo.setBonusId(0);	
  			}
  			orderInfo.setShippingFee(shippingFee);
  			//保价费用
  			orderInfo.setInsureFee(new BigDecimal(0.00));
  			//支付费用
  			orderInfo.setPayFee(new BigDecimal(0.00));
  		    //包装费用
  			orderInfo.setPackFee(new BigDecimal(0.00));
  		    //贺卡费用，
  			orderInfo.setCardFee(new BigDecimal(0.00));
  		    //已付款金额
  			orderInfo.setMoneyPaid(new BigDecimal(0.00));
  		    //该订单使用余额的数量，取用户设定余额，用户可用余额，订单金额中最小者
  			orderInfo.setSurplus(new BigDecimal(0.00));
  			
  			int integral = 0;
  			BigDecimal integralMoney = new BigDecimal(0.0);
  			if(orderGenerate.getVendorId()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
	  		    //使用的积分的数量
  				integral = purchasePoints.multiply(new BigDecimal(100)).intValue();
	  		    //使用积分金额
  				integralMoney = purchasePoints.setScale(2,BigDecimal.ROUND_HALF_UP);
  			}
  			 //使用的积分的数量
  			orderInfo.setIntegral(integral);
  		    //使用积分金额
  			orderInfo.setIntegralMoney(integralMoney);
  			
  			
  			 //发票税额
  			orderInfo.setTax(taxAmount.setScale(2,BigDecimal.ROUND_HALF_UP));
  			
  		   
  			
  			
  			
  			
  			BigDecimal orderAmount = goodsAmount.add(shippingFee).add(taxAmount).subtract(bonus).subtract(integralMoney);
  		    //应付款金额
  			orderInfo.setOrderAmount(orderAmount);
  		    //使用礼品卡金额
  			orderInfo.setGiftCardMoney(new BigDecimal(0.00));
  			//订单由某广告带来的广告id
  			orderInfo.setFromAd(Short.valueOf("0"));
  			//订单的来源页面
  			orderInfo.setReferer("本站");
  			//订单生成时间
  			orderInfo.setAddTime(Integer.parseInt(DateUtil.getNowLong().toString()));
  		    //订单确认时间
  			orderInfo.setConfirmTime(0);
  			//订单支付时间
  			orderInfo.setPayTime(0);
  		    //订单配送时间
  			orderInfo.setShippingTime(0);
  			//包装id
  			orderInfo.setPackId(Byte.valueOf("0"));
  			//贺卡id
  			orderInfo.setCardId(Byte.valueOf("0"));
  			
  			//发货单号
  			orderInfo.setInvoiceNo("");
  			//通过活动购买的商品的代号
  			orderInfo.setExtensionCode("");
  			//通过活动购买的物品的id
  			orderInfo.setExtensionId(0);
  			//商家给客户的留言
  			orderInfo.setToBuyer("");
  		    //付款备注
  			orderInfo.setPayNote("");
  		    //付款备注
  			orderInfo.setPayNote("");
  			//该笔订单被指派给的办事处的id
  			orderInfo.setAgencyId(Short.valueOf("0"));
  		    //不知道
  			orderInfo.setAdTrackId(Long.valueOf("0"));
  			//发票类型
  			orderInfo.setInvType("");
  		   
  			//0，未分成或等待分成；1，已分成；2，取消分成；
  			orderInfo.setIsSeparate(false);
  		    //能获得推荐分成的用户id，id取值于表ecs_users
  			orderInfo.setParentId(0);
  		    //？？金额
  			orderInfo.setDiscount(new BigDecimal(0.00));
            //账单信息
  			orderInfo.setConsigneeZd(billAddress.getConsignee());
  			orderInfo.setCountryZd(billAddress.getCountry());
  			orderInfo.setProvinceZd(billAddress.getProvince());
  			orderInfo.setCityZd(billAddress.getCity());
  			orderInfo.setAddressZd(billAddress.getAddress());
  			orderInfo.setAddress2Zd(billAddress.getAddress2());
  			orderInfo.setZipcodeZd(billAddress.getZipcode());
  			orderInfo.setTelZd(billAddress.getTel());
  			orderInfo.setMobileZd(billAddress.getMobile());
  			orderInfo.setEmailZd(billAddress.getEmail());
  			//语言
  			orderInfo.setLang("0");
  			
  			
  			
  			
  			
  		    //礼物
  			orderInfo.setGift(0);
  		   //IP
  			orderInfo.setIp(ip);
   		   //IP
   			orderInfo.setUserAgent(userAgent);
   			orderInfo.setSourceFlag(source_flag);
  		//1.3生成订单
  			orderInfoService.insert(orderInfo);
  			int orderId = orderInfoService.selectOrderInfoByOrderSn(order_sn).getOrder_id();
  			if(j==1){
  				purchase_id = orderId;
  			}
  			j++;
  			orderInfoService.updatePurchaseIdByOrderId(orderId, purchase_id);
  			//订单关联商品数据
  			orderGoodsService.insert(orderId, orderGenerate.getUserId(), orderGenerate.getVendorId());	
  		}
  		
      	return purchase_id;
 	}
     
     /**
      * 提交订单
      * @param uid
      * @param lstCart 购物车信息
      * @param lstGoods 购物车中对应的商品的原始信息
      * @param lstOrderGenerate 订单信息
      * @throws Exception
      * @author James
      */
     public int transactionOrderV2(int uid,List<Cart> lstCart,List<OrderGenerate> lstOrderGenerate,Map<String,Object> mapCheckOut,BonusType bonusType,String ip,String userAgent,int source_flag,Integer lang)throws Exception{
    	 Users users = userService.selectUserInfoByUid(uid);
    	//使用积分对应金额
    	BigDecimal purchasePoints = (BigDecimal)((Map)(mapCheckOut.get("total"))).get("points");
    	//使用积分对应金额
    	BigDecimal purchaseAmount = (BigDecimal)((Map)(mapCheckOut.get("total"))).get("amount");
    	//各供货商数据信息
    	List<Map<String,Object>> lstVendorStat = (ArrayList<Map<String,Object>>)mapCheckOut.get("vendorCart");
  		int purchase_id=1;
  		
  		//1.循环各供货商ORDER设置信息，生成正式ORDER信息
  		for(int i=0;i<lstOrderGenerate.size();i++){
  			//1.1ORDER设置信息
  			OrderGenerate orderGenerate = lstOrderGenerate.get(i);
  			//1.2收货地址信息
  			UserAddress userAddress = orderGenerate.getUserAddress();
  			//1.3配送方式信息
  			Shipping shipping = orderGenerate.getShipping();
  			//1.4支付方式信息
  			UserProfile userProfile = new UserProfile();
  			UserAddress billAddress;
  			if(orderGenerate.getProfileId().equals("0")){
  				userProfile.setProfile_id("0");
  				billAddress = userAddress;
  			}else{
  				userProfile = orderGenerate.getUserProfile();
  				billAddress = userProfile.getAddress();
  				if(null==billAddress||null==billAddress.getConsignee()||null==billAddress.getAddress()||null==billAddress.getProvince()||null==billAddress.getCity()||null==billAddress.getCountry()||null==billAddress.getZipcode()){
  				  throw new YamiException(YamiConstant.ERRORCODE_ER1109,ErrorCodeEnum.ER1109.getMsg());
  				}
  			}
  			//1.5设置订单信息
  			OrderInfo orderInfo = new OrderInfo();
  			//1.5.1生成订单号
		     String order_sn = new String();
		     for(int j=0;j>-1;j++){
		    	//1.5.1.1 生成订单号
		    	order_sn = StringUtil.GetOrderSN();
	 		    //1.5.1.2判断新ORDER_SN是否存在
		    	int orderSnNum = orderInfoService.selectOrderInfoNumByOrderSn(order_sn);
		    	 if(orderSnNum==0){
		    		 break;
		    	 }
		     }
  			orderInfo.setOrderSn(order_sn);
  			//1.5.2用户ID
  			orderInfo.setUserId(uid);
  			//1.5.3订单状态。0，未确认；1，已确认；2，已取消；3，无效；4，退货；
  			orderInfo.setOrderStatus(1);
  		    //1.5.4商品配送情况，0，未发货；1，已发货；2，已收货；3，备货中
  			orderInfo.setShippingStatus(0);
  		    //1.5.5支付状态；0，未付款；1，付款中；2，已付款
  			orderInfo.setPayStatus(0);
  			//1.5.6收货地址信息
  			orderInfo.setConsignee(userAddress.getConsignee());
  			orderInfo.setVendorId(orderGenerate.getVendorId());
  			orderInfo.setCountry(userAddress.getCountry());
  			orderInfo.setProvince(userAddress.getProvince());
  			orderInfo.setCity(userAddress.getCity());
  			orderInfo.setDistrict(userAddress.getDistrict().toString());
  			orderInfo.setAddress(userAddress.getAddress());
  			orderInfo.setAddress2(userAddress.getAddress2());
  			orderInfo.setZipcode(userAddress.getZipcode());
  			orderInfo.setTel(userAddress.getTel());
  			orderInfo.setMobile(userAddress.getMobile());
  			orderInfo.setEmail(userAddress.getEmail());
  			//1.5.6配送方式信息
  			orderInfo.setShippingId(shipping.getShippingId());
  			orderInfo.setShippingName(shipping.getShippingName());
  			//1.5.7支付方式信息
  			if(String.valueOf(userProfile.getProfile_id()).equals("0")){
	  			orderInfo.setPayId(Byte.valueOf("3"));
	  			orderInfo.setPayName("paypal");
	  			orderInfo.setAbnormal(Byte.valueOf("0"));
	  			orderInfo.setProfileId("0");
  			}else{
  				orderInfo.setPayId(Byte.valueOf("4"));
	  			orderInfo.setPayName("credit card");
	  			orderInfo.setProfileId(userProfile.getProfile_id());
	  			orderInfo.setFirstname(userProfile.getFirstname());
	  			orderInfo.setLastname(userProfile.getLastname());
	  			orderInfo.setCardType(userProfile.getCard_type());
	  			orderInfo.setTail(userProfile.getTail());
	  			orderInfo.setExpYear(userProfile.getExp_year());
	  			orderInfo.setExpMonth(userProfile.getExp_month());
	  		   //黑名单判断
	  			int blackCount = 0;
	  			if(null!=users.getMobilePhone()&&!"".equals(users.getMobilePhone())){
	  				blackCount = orderInfoService.selectBlackListResult(uid,null,users.getMobilePhone());
	  			}else{
	  				blackCount = orderInfoService.selectBlackListResult(uid,null,null);
	  			}
	  			if(blackCount>0){
	  				orderInfo.setAbnormal(Byte.valueOf("101"));
	  			}else{
	  				if(purchaseAmount.compareTo(new BigDecimal(300.00))>=0){
	  					orderInfo.setAbnormal(Byte.valueOf("1"));		
	  				}else{
	  					orderInfo.setAbnormal(Byte.valueOf("0"));	
	  				}
	  				
	  			}
  			}
  			//1.5.8各金额信息计算
	  			BigDecimal costAmount = new BigDecimal(0.00);
	  			BigDecimal goodsAmount = new BigDecimal(0.00);
	  			BigDecimal taxAmount = new BigDecimal(0.00);
	  			BigDecimal shippingFee = new BigDecimal(0.00);
	  			BigDecimal bonus = new BigDecimal(0.00);
	  			int integral = 0;
	  			BigDecimal integralMoney = new BigDecimal(0.0);
	  			BigDecimal orderAmount = new BigDecimal(0.0);
	  			//1.5.8.1成本、销售、扣税金额计算
	  			for(Cart cart:lstCart){
	  				if(orderGenerate.getVendorId()==cart.getVendor_id()){
	  					costAmount = costAmount.add(cart.getCost().multiply(BigDecimal.valueOf(cart.getGoods_number())));
	  					goodsAmount =  goodsAmount.add(cart.getGoods_price().multiply(BigDecimal.valueOf(cart.getGoods_number())));
	  					taxAmount = taxAmount.add(cart.getTax());
	  				}
	  			}
	  			//1.5.8.2折扣、运费金额计算
	  			for(Map<String,Object> mapTemp:lstVendorStat){
	 	    		 if(orderGenerate.getVendorId()==Integer.parseInt(((HashMap<String,Object>)mapTemp.get("vendor")).get("vendor_id").toString())){
	 	    			 //1.5.8.2.1使用折扣红包金额
	 	    			 if(mapTemp.get("bonus")!=null){
	 	    			    bonus =  BigDecimal.valueOf(Double.parseDouble(((HashMap<String,Object>)mapTemp.get("bonus")).get("discount").toString()));
	 	    			 }
	 	     			orderInfo.setBonus(bonus);
	 	    			 //1.5.8.2.2运费
	 	    			 if(((HashMap<String,Object>)mapTemp.get("shipping")).get("free_shipping").toString().equals("0")){
	 	    				shippingFee=  shipping.getShippingFee();
	 	    			 }
	 	    		 }
	 	    	 }
//	 			 if(bonus.compareTo(new BigDecimal(0))==0&&new BigDecimal(((Map)(mapCheckOut.get("total"))).get("discount").toString()).compareTo(new BigDecimal(0.0))>0){
//	 				if(orderGenerate.getVendorId()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
//	 					bonus = new BigDecimal(((Map)(mapCheckOut.get("total"))).get("discount").toString());
//	 				}
//	 			 }
	  			//1.5.8.3积分金额计算
	 			if(orderGenerate.getVendorId()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
		  		    //1.5.8.3.1使用的积分的数量
	  				integral = purchasePoints.multiply(new BigDecimal(100)).intValue();
		  		    //1.5.8.3.2使用积分金额
	  				integralMoney = purchasePoints.setScale(2,BigDecimal.ROUND_HALF_UP);
	  			}
	 			//1.5.8.4应付款金额计算
	 			orderAmount = goodsAmount.add(shippingFee).add(taxAmount).subtract(bonus).subtract(integralMoney);

  		    //1.5.9商品成本金额
  			orderInfo.setCostAmount(costAmount);
  			//1.5.10商品销售金额
  			orderInfo.setGoodsAmount(goodsAmount);
  			//1.5.11商品扣税金额
  			orderInfo.setTax(taxAmount.setScale(2,BigDecimal.ROUND_HALF_UP));
  			//1.5.12折扣码对应金额
  			orderInfo.setBonus(bonus);
  			//1.5.13运费金额
  			orderInfo.setShippingFee(shippingFee);
  			//1.5.14使用的积分的数量
  			orderInfo.setIntegral(integral);
  		    //1.5.15使用积分金额
  			orderInfo.setIntegralMoney(integralMoney);
  		    //1.5.16应付款金额
  			orderInfo.setOrderAmount(orderAmount);
  			//1.5.17订单生成时间
  			orderInfo.setAddTime(Integer.parseInt(DateUtil.getNowLong().toString()));
  		    //1.5.18订单确认时间
  			orderInfo.setConfirmTime(0);
  			//1.5.19订单支付时间
  			orderInfo.setPayTime(0);
  		    //1.5.20订单配送时间
  			orderInfo.setShippingTime(0);
  			//1.5.21红包的id
  			if(bonus.compareTo(new BigDecimal(0))>0){
  			orderInfo.setBonusId(orderGenerate.getBonusId()==null?0:orderGenerate.getBonusId());
  			}else{
  				orderInfo.setBonusId(0);	
  			}
            //1.5.22账单信息
  			orderInfo.setConsigneeZd(billAddress.getConsignee());
  			orderInfo.setCountryZd(billAddress.getCountry());
  			orderInfo.setProvinceZd(billAddress.getProvince());
  			orderInfo.setCityZd(billAddress.getCity());
  			orderInfo.setAddressZd(billAddress.getAddress());
  			orderInfo.setAddress2Zd(billAddress.getAddress2());
  			orderInfo.setZipcodeZd(billAddress.getZipcode());
  			orderInfo.setTelZd(billAddress.getTel());
  			orderInfo.setMobileZd(billAddress.getMobile());
  			orderInfo.setEmailZd(billAddress.getEmail());
  		    //1.5.23IP
  			orderInfo.setIp(ip);
   		    //1.5.24客户端类型
   			orderInfo.setUserAgent(userAgent);
   			//1.5.25请求客户端平台标识
   			orderInfo.setSourceFlag(source_flag);
   			
   			/*----------------无用信息，只给出数据库需要默认值---------------------*/
	   			//收货人的最佳送货时间
	  			orderInfo.setBestTime("");
	  		    //收货人的地址的标志性建筑
	  			orderInfo.setSignBuilding("");
	  		    //订单附言
	  			orderInfo.setPostscript("");
	  			//缺货处理方式，等待所有商品备齐后再发； 取消订单；与店主协商
	  			orderInfo.setHowOos("");
	  			//不知道这个字段什么意思
	  			orderInfo.setHowSurplus("");
	  			//包装名称
	  			orderInfo.setPackName("");
	  			//贺卡名称
	  			orderInfo.setCardName("");
	  		    //贺卡内容
	  			orderInfo.setCardMessage("");
	  			//发票头
	  			orderInfo.setInvPayee("");
	  			//发票内容
	  			orderInfo.setInvContent("");
	  			//保价费用
	  			orderInfo.setInsureFee(new BigDecimal(0.00));
	  			//支付费用
	  			orderInfo.setPayFee(new BigDecimal(0.00));
	  		    //包装费用
	  			orderInfo.setPackFee(new BigDecimal(0.00));
	  		    //贺卡费用，
	  			orderInfo.setCardFee(new BigDecimal(0.00));
	  		    //已付款金额
	  			orderInfo.setMoneyPaid(new BigDecimal(0.00));
	  			 //使用礼品卡金额
	  			orderInfo.setGiftCardMoney(new BigDecimal(0.00));
	  			//订单由某广告带来的广告id
	  			orderInfo.setFromAd(Short.valueOf("0"));
	  			//该订单使用余额的数量，取用户设定余额，用户可用余额，订单金额中最小者
	  			orderInfo.setSurplus(new BigDecimal(0.00));
	  			//订单的来源页面
	  			orderInfo.setReferer("本站");
	  			//包装id
	  			orderInfo.setPackId(Byte.valueOf("0"));
	  			//贺卡id
	  			orderInfo.setCardId(Byte.valueOf("0"));
				//发货单号
	  			orderInfo.setInvoiceNo("");
	  			//通过活动购买的商品的代号
	  			orderInfo.setExtensionCode("");
	  			//通过活动购买的物品的id
	  			orderInfo.setExtensionId(0);
	  			//商家给客户的留言
	  			orderInfo.setToBuyer("");
	  		    //付款备注
	  			orderInfo.setPayNote("");
	  		    //付款备注
	  			orderInfo.setPayNote("");
	  			//该笔订单被指派给的办事处的id
	  			orderInfo.setAgencyId(Short.valueOf("0"));
	  		    //不知道
	  			orderInfo.setAdTrackId(Long.valueOf("0"));
	  			//发票类型
	  			orderInfo.setInvType("");
	  			//0，未分成或等待分成；1，已分成；2，取消分成；
	  			orderInfo.setIsSeparate(false);
	  		    //能获得推荐分成的用户id，id取值于表ecs_users
	  			orderInfo.setParentId(0);
	  		    //？？金额
	  			orderInfo.setDiscount(new BigDecimal(0.00));
	  			//语言
	  			if(null==lang){
	  				orderInfo.setLang("2");
	  			}else{
	  				orderInfo.setLang(lang.toString());
	  			}
	  		    //礼物
	  			orderInfo.setGift(0);
	  		/*----------------无用信息，只给出数据库需要默认值---------------------*/
  		    //1.3生成订单
  			orderInfoService.insert(orderInfo);
  			int orderId = orderInfo.getOrder_id();
  			if(i==0){
  				purchase_id = orderId;
  			}
  			orderInfoService.updatePurchaseIdByOrderId(orderId, purchase_id);
  			//订单关联商品数据
  			//循环添加订单商品数据
  			for(Cart cart:lstCart){
  				if(cart.getVendor_id().intValue()==orderGenerate.getVendorId().intValue()){
	  				OrderGoods ordergoods = new OrderGoods();
	  				ordergoods.setOrderId(orderId);
	  				ordergoods.setGoodsId(cart.getGoods_id());
	  				ordergoods.setGoodsName(cart.getGoods_name());
	  				ordergoods.setGoodsEname(cart.getGoods_ename());
	  				ordergoods.setGoodsSn(cart.getGoods_sn());
	  				ordergoods.setProductId(cart.getProduct_id());
	  				ordergoods.setGoodsNumber(cart.getGoods_number());
	  				ordergoods.setCost(cart.getCost());
	  				ordergoods.setTax(cart.getTax());
	  				ordergoods.setMarketPrice(cart.getMarket_price());
	  				ordergoods.setGoodsPrice(cart.getGoods_price());
	  				ordergoods.setGoodsAttr("");
	  				ordergoods.setIsReal(cart.getIs_real());
	  				ordergoods.setExtensionCode(cart.getExtension_code());
	  				ordergoods.setParentId(0);
	  				ordergoods.setIsGift(cart.getIs_gift());
	  				ordergoods.setGoodsAttrId("");
	  				ordergoods.setDealPrice(cart.getDeal_price());
	  				
	  				if(cart.getGive_Integral_stock().intValue()==-1){
	  					if(cart.getIs_promote_stock()){
	  						ordergoods.setGiveIntegral(cart.getPromote_price_stock());
	  					}else{
	  						ordergoods.setGiveIntegral(cart.getShop_price_stock());
	  					}
	  				}
	  				else{
	  					ordergoods.setGiveIntegral(new BigDecimal(cart.getGive_Integral_stock()));
	  				}
	  				ordergoods.setVendorId(cart.getVendor_id());
	  				orderGoodsService.insertOne(ordergoods);
	  			}
  			}
  		}
  		
      	return purchase_id;
 	}
     public int transactionupdateDealPriceByRecId(int rec_id,BigDecimal deal_price){
    	 return cartService.updateDealPriceByRecId(rec_id, deal_price);
     }
     public int transactionUpdateDealPriceAndTax(int uid,int goods_id,BigDecimal tax,BigDecimal deal_price){
    	 return cartService.updateDealPriceAndTax(uid, goods_id, tax, deal_price);
     }     
	public void transactionSetExpressCheckout(String token, int user_id, String ec_token)
			throws Exception {
		// Delete this user's record from express_checkout
		paymentService.deleteExpressCheckoutByUid(user_id);
		// Insert record to express_checkout
		ExpressCheckout expressCheckout = new ExpressCheckout();
		expressCheckout.setPayer_id(YamiConstant.STRING_EMPTY);
		expressCheckout.setSession_id(YamiConstant.STRING_EMPTY);
		expressCheckout.setToken(ec_token);
		expressCheckout.setUser_id(user_id);
		paymentService.insertExpressCheckout(expressCheckout);
	} 
	
	public void transactionGetExpressCheckout(String token, int user_id, String payer_id)
			throws Exception {

		// Update payer_id by user_id
		ExpressCheckout expressCheckout = new ExpressCheckout();
		expressCheckout.setPayer_id(payer_id);
		expressCheckout.setUser_id(user_id);
		paymentService.updatePayerIdByUid(expressCheckout);
	} 
	
	/**
     * 完成订单
     * @param purchase_id
     * @throws Exception
     * @author James
     */
    public void transactionFinishOrder(int uId,String purchase_id,Map<Integer,Integer> mapGoodsStock,long point)throws Exception{
    	
    	
  	    //1.1修改库存
  		for(Integer goods_id:mapGoodsStock.keySet()){
  			Goods goods = goodsService.selectByPrimaryKey(goods_id);
  				    //库存修改
  					goodsService.updateGoodsNum(mapGoodsStock.get(goods_id),goods_id);
  					//限购修改
  					if(goods.getIsLimited()){
  						goodsService.updateLimitedNum(mapGoodsStock.get(goods_id), goods_id);
  					}
  		}
    	//更改订单状态
    		//订单状态。0，未确认；1，已确认；2，已取消；3，无效；4，退货；
    		int order_status = 1;
    		//商品配送情况，0，未发货；1，已发货；2，已收货；3，备货中
    		int shipping_status = 0;
    		//支付状态；0，未付款；1，付款中；2，已付款
    		int pay_status = 2;
    	orderInfoService.updateOrderStatusByPurchaseId(order_status, shipping_status, pay_status, Integer.parseInt(DateUtil.getNowLong().toString()),Integer.parseInt(purchase_id));
    	//删除购物信息
    	cartService.deleteCartByUid(uId);
    	List<OrderGenerate> lstOrderGenerate = orderGenerateService.selectOrderGenerateByUserId(uId);
    	//修改为默认支付方式
    	if(!lstOrderGenerate.get(0).getProfileId().toString().equals("0")){
  		userService.updateProfileIsPrimaryByPKUid(uId,lstOrderGenerate.get(0).getProfileId());
    	}
    	//修改折扣码使用次数
    	if(null!=lstOrderGenerate.get(0).getBonusId()){
    		String BonusCount = bonusLookupService.selectBonusCountByBonusTypeId(Integer.parseInt(lstOrderGenerate.get(0).getBonusId().toString()));
   		if(Integer.parseInt(BonusCount)>0){
    			bonusLookupService.updateBonusCountByBonusTypeId(Integer.parseInt(lstOrderGenerate.get(0).getBonusId().toString()));
    		}
        	}
    	
    	if(point>0){
	    	//修改用户积分余额信息
	    	userService.updatePointByUid(uId, point);
	    	
	    	
	    	List<OrderInfo> lstOrderInfo = orderInfoService.selectOrderInfo(Integer.parseInt(purchase_id));
	    	int orderid = 0;
	    	String ordersn = null;
	    	BigDecimal orderAmount = new BigDecimal(0.00);
	    	for(OrderInfo orderInfo :lstOrderInfo){
	    		if(orderInfo.getVendorId()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
	    			orderid = orderInfo.getOrder_id();
	    			ordersn = orderInfo.getOrderSn();
	    			orderAmount = orderInfo.getOrderAmount();
	    		}
	    	}
	    	
	    	Integral integral = new Integral();
    		integral.setIntegral(String.valueOf(point));
    		integral.setDate(DateUtil.getNowLong().intValue());
    		integral.setUserId(uId);
    		integral.setType(YamiConstant.POINTS_TYPE_NO_1);
    		integral.setOrderId(orderid);
    		integral.setOrderSn(ordersn);
    		integral.setFormatedTotalFee(String.valueOf(orderAmount));
    		userService.addIntegralSelective(integral);
	    	
	    	
	    	//添加积分历史
	    	
    	}
    	
    	
    	//修改默认收货地址
  		userService.updateAddressIsPrimaryByPKUid(uId, lstOrderGenerate.get(0).getShippingAdd());
    	//删除临时ORDER信息
    	orderGenerateService.deleteOrderGenerateByUId(uId);
    	//删除PAYPAL登陆信息(改为删除redis移到doExpressCheckout)
    	//paymentService.deleteExpressCheckoutByUid(uId);
    	
    	//发送电子邮件
    	String email  = new String();
    	List<OrderInfo> lstOrder = orderInfoService.selectOrderInfo(Integer.parseInt(purchase_id));
    	for(OrderInfo orderInfo:lstOrder){
    		List<OrderGoods> lstOrderGoods = orderGoodsService.selectOrderGoodsByOrdersId(orderInfo.getOrder_id());
    		List<OrderGoods> lstOrderGoodsResult = new ArrayList<OrderGoods>();
    		for(OrderGoods orderGoods:lstOrderGoods){
    			orderGoods.setGoodsThumb(YamiConstant.IMAGE_URL+orderGoods.getGoodsThumb());
    			
    			lstOrderGoodsResult.add(orderGoods);
    		}
    		Context data = new Context();
    		data.setVariable("goodsInfo", lstOrderGoodsResult);
    		data.setVariable("pay_time", DateUtil.formateUTC(orderInfo.getPayTime()));
    		data.setVariable("pay_method", orderInfo.getPayName());
    		data.setVariable("address_zd", orderInfo.getAddressZd());
    		data.setVariable("address2_zd", orderInfo.getAddress2Zd());
    		data.setVariable("city_zd", orderInfo.getCityZd());
    		data.setVariable("province_zd", orderInfo.getProvinceZd());
    		data.setVariable("zipcode_zd", orderInfo.getZipcodeZd());
    		data.setVariable("country_zd", orderInfo.getCountryZd());
    		data.setVariable("address", orderInfo.getAddress());
    		data.setVariable("address2", orderInfo.getAddress2());
    		data.setVariable("city", orderInfo.getCity());
    		data.setVariable("province", orderInfo.getProvince());
    		data.setVariable("zipcode", orderInfo.getZipcode());
    		data.setVariable("country", orderInfo.getCountry());
    		data.setVariable("subtotal", String.valueOf(orderInfo.getGoodsAmount()));
    		data.setVariable("shipping", String.valueOf(orderInfo.getShippingFee()));
    		data.setVariable("tax",String.valueOf( orderInfo.getTax()));
    		data.setVariable("total", String.valueOf(orderInfo.getOrderAmount()));
    		data.setVariable("order_sn", orderInfo.getOrderSn());
    		data.setVariable("consignee", orderInfo.getConsignee());
    		email = templateEngine.process("OrderEmail", data);
    		String username = userService.getUserName(uId);
    		try{
    		Sendmail sendmail = new Sendmail();
        	sendmail.setContent(email);
        	sendmail.setOrderId(orderInfo.getOrder_id());
        	sendmail.setName(username);
        	sendmail.setEmail(orderInfo.getEmail());
        	sendmail.setCount((short)YamiConstant.INT_ZERO);
        	sendmail.setSendTime(Integer.parseInt(DateUtil.getNowLong().toString()));
        	sendmail.setSubject("ORDER CONFIRMATION");

        	//kafkaProducer.sendold(TOPIC_SENDMAIL, sendmail);
       	    sendmailService.insert(sendmail);
    		}catch (Exception e){
				logger.fatal("Failed to insert sendmail for orderId:"+orderInfo.getOrder_id());
				logger.fatal(e.toString());
    		}
    	}
    }
    
	/**
     * 完成订单
     * @param purchase_id
     * @throws Exception
     * @author James
     */
    public void transactionFinishOrderV2(Token token,PurchaseInfo purchaseInfo,Map<Integer,Integer> mapGoodsStock,long point)throws Exception{
    	
    	int uId = Integer.parseInt(token.getData());
  	    //1.1修改库存
  		for(Integer goods_id:mapGoodsStock.keySet()){
  			Goods goods = goodsService.selectByPrimaryKey(goods_id);
  				    //库存修改
  					goodsService.updateGoodsNum(mapGoodsStock.get(goods_id),goods_id);
  					//限购修改
  					if(goods.getIsLimited()){
  						goodsService.updateLimitedNum(mapGoodsStock.get(goods_id), goods_id);
  					}
  		}
    	//更改订单状态
    		//订单状态。0，未确认；1，已确认；2，已取消；3，无效；4，退货；
    		int order_status = 1;
    		//商品配送情况，0，未发货；1，已发货；2，已收货；3，备货中
    		int shipping_status = 0;
    		//支付状态；0，未付款；1，付款中；2，已付款
    		int pay_status = 2;
    	orderInfoService.updateOrderStatusByPurchaseId(order_status, shipping_status, pay_status, Integer.parseInt(DateUtil.getNowLong().toString()),purchaseInfo.getPurchaseId());
    	//删除购物信息
    	cartRedisService.deleteAll(token);
    	List<OrderGenerate> lstOrderGenerate = orderGenerateRedisService.selectAllForOrderGenerate(token);
    	//修改为默认支付方式
    	if(!lstOrderGenerate.get(0).getProfileId().toString().equals("0")){
  		userService.updateProfileIsPrimaryByPKUid(uId,lstOrderGenerate.get(0).getProfileId());
    	}
    	
    	//修改用户第一次成功下单时间
    	Users user = userService.selectUserInfoByUid(uId);
    	
/*    	if(null==user.getFirstOrderTime()){
    		userService.updateFirstOrderTimeByUid(uId);
    	}*/
    	
    	
    	//修改折扣码使用次数
    	if(null!=lstOrderGenerate.get(0).getBonusId()){
    		String BonusCount = bonusLookupService.selectBonusCountByBonusTypeId(Integer.parseInt(lstOrderGenerate.get(0).getBonusId().toString()));
   		if(null!=BonusCount&&Integer.parseInt(BonusCount)>0){
    			bonusLookupService.updateBonusCountByBonusTypeId(Integer.parseInt(lstOrderGenerate.get(0).getBonusId().toString()));
    		}
        	}
    	
    	if(point>0){
	    	//修改用户积分余额信息
	    	userService.updatePointByUid(uId, point);
	    	
	    	
	    	List<OrderInfo> lstOrderInfo = purchaseInfo.getLstOrderInfo();
	    	int orderid = 0;
	    	String ordersn = null;
	    	BigDecimal orderAmount = new BigDecimal(0.00);
	    	for(OrderInfo orderInfo :lstOrderInfo){
	    		if(orderInfo.getVendorId()==Integer.parseInt(YamiConstant.VENDOR_ID_YAMIBUY)){
	    			orderid = orderInfo.getOrder_id();
	    			ordersn = orderInfo.getOrderSn();
	    			orderAmount = orderInfo.getOrderAmount();
	    		}
	    	}
	    	
	    	Integral integral = new Integral();
    		integral.setIntegral(String.valueOf(point));
    		integral.setDate(DateUtil.getNowLong().intValue());
    		integral.setUserId(uId);
    		integral.setType(YamiConstant.POINTS_TYPE_NO_1);
    		integral.setOrderId(orderid);
    		integral.setOrderSn(ordersn);
    		integral.setFormatedTotalFee(String.valueOf(orderAmount));
    		userService.addIntegralSelective(integral);
	    	
	    	
	    	//添加积分历史
	    	
    	}
    	
    	
    	//修改默认收货地址
  		userService.updateAddressIsPrimaryByPKUid(uId, lstOrderGenerate.get(0).getShippingAdd());
    	//删除临时ORDER信息
    	orderGenerateRedisService.deleteAll(token);
    	//删除PAYPAL登陆信息(改为删除redis移到doExpressCheckout)
    	//paymentService.deleteExpressCheckoutByUid(uId);
    	
    	//发送电子邮件:订单成功
    	int abnormal = 0;
    	BigDecimal amount = new BigDecimal(0.00);
    	String email  = new String();
		String username = userService.getUserName(uId);
    	List<OrderInfo> lstOrder = purchaseInfo.getLstOrderInfo();
    	for(OrderInfo orderInfo:lstOrder){
    		abnormal = orderInfo.getAbnormal().intValue();
    		amount = amount.add(orderInfo.getOrderAmount());
    		List<OrderGoods> lstOrderGoods = orderInfo.getLstOrderGoods();
    		List<OrderGoods> lstOrderGoodsResult = new ArrayList<OrderGoods>();
    		for(OrderGoods orderGoods:lstOrderGoods){
    			orderGoods.setGoodsThumb(YamiConstant.IMAGE_URL+orderGoods.getGoodsThumb());
    			
    			lstOrderGoodsResult.add(orderGoods);
    		}
    		Context data = new Context();
    		data.setVariable("goodsInfo", lstOrderGoodsResult);
    		data.setVariable("pay_time", DateUtil.formateUTC(orderInfo.getAddTime()));
    		data.setVariable("pay_method", orderInfo.getPayName());
    		data.setVariable("address_zd", orderInfo.getAddressZd());
    		data.setVariable("address2_zd", orderInfo.getAddress2Zd());
    		data.setVariable("city_zd", orderInfo.getCityZd());
    		data.setVariable("province_zd", orderInfo.getProvinceZd());
    		data.setVariable("zipcode_zd", orderInfo.getZipcodeZd());
    		data.setVariable("country_zd", orderInfo.getCountryZd());
    		data.setVariable("address", orderInfo.getAddress());
    		data.setVariable("address2", orderInfo.getAddress2());
    		data.setVariable("city", orderInfo.getCity());
    		data.setVariable("province", orderInfo.getProvince());
    		data.setVariable("zipcode", orderInfo.getZipcode());
    		data.setVariable("country", orderInfo.getCountry());
    		data.setVariable("subtotal", String.valueOf(orderInfo.getGoodsAmount()));
    		data.setVariable("shipping", String.valueOf(orderInfo.getShippingFee()));
    		data.setVariable("tax",String.valueOf( orderInfo.getTax()));
    		data.setVariable("total", String.valueOf(orderInfo.getOrderAmount()));
    		data.setVariable("order_sn", orderInfo.getOrderSn());
    		data.setVariable("consignee", orderInfo.getConsignee());
    		email = templateEngine.process("OrderEmail", data);

    		try{
    		Sendmail sendmail = new Sendmail();
        	sendmail.setContent(email);
        	sendmail.setOrderId(orderInfo.getOrder_id());
        	sendmail.setName(username);
        	sendmail.setEmail(orderInfo.getEmail());
        	sendmail.setCount((short)YamiConstant.INT_ZERO);
        	sendmail.setSendTime(Integer.parseInt(DateUtil.getNowLong().toString()));
        	sendmail.setSubject("ORDER CONFIRMATION");

        	//kafkaProducer.sendold(TOPIC_SENDMAIL, sendmail);
       	    sendmailService.insert(sendmail);
    		}catch (Exception e){
				logger.fatal("Failed to insert sendmail for orderId:"+orderInfo.getOrder_id());
				logger.fatal(e.toString());
    		}
    	}
    	
    	//发送电子邮件：异常订单或订单金额大于300
    	if(abnormal==1||amount.compareTo(new BigDecimal(300))>=0){
    		String purchase_id = "";
    		String order_sn = "";
    		String order_id = "";
    		BigDecimal order_amount = new BigDecimal(0.00);
    		String name = "";
    		String e_mail = "";
    		String address = "";
    		for(OrderInfo orderInfo:lstOrder){
    			purchase_id = orderInfo.getPurchaseId().toString();
    			order_sn = order_sn+","+orderInfo.getOrderSn();
    			order_id = order_id+","+orderInfo.getOrder_id().toString();
    			order_amount = order_amount.add(orderInfo.getOrderAmount());
    			name = orderInfo.getConsignee();
    			e_mail = orderInfo.getEmail();
    			address = orderInfo.getAddress()+" "+orderInfo.getAddress2()+" "+orderInfo.getCity()+" "+orderInfo.getProvince()+" "+orderInfo.getZipcode();
    		}
    		Context data = new Context();
    		data.setVariable("purchase_id", purchase_id);
    		data.setVariable("order_sn", order_sn.substring(1, order_sn.length()));
    		data.setVariable("order_id", order_id.substring(1, order_id.length()));
    		data.setVariable("amount", order_amount);
    		data.setVariable("username", username);
    		data.setVariable("name", name);
    		data.setVariable("e_mail", e_mail);
    		data.setVariable("address", address);
    		if (amount.compareTo(new BigDecimal(300))>=0){
    			email = templateEngine.process("OrderExceed", data);	
    		}else if(abnormal==1){
    			email = templateEngine.process("OrderBlackList", data);
    		}
    		try{
        		Sendmail sendmail = new Sendmail();
            	sendmail.setContent(email);
            	//sendmail.setOrderId(orderInfo.getOrder_id());
            	sendmail.setName(username);
            	sendmail.setEmail(YamiConstant.CUSTOMER_SERVICE_EMAIL);
            	sendmail.setCc(YamiConstant.OTHER_CC_EMAIL);
            	sendmail.setCount((short)YamiConstant.INT_ZERO);
            	sendmail.setSendTime(Integer.parseInt(DateUtil.getNowLong().toString()));
            	sendmail.setSubject("Yamibuy Order abnormal alarm system");
            	//kafkaProducer.sendold(TOPIC_SENDMAIL, sendmail);
           	    sendmailService.insert(sendmail);
        		}catch (Exception e){
    				logger.fatal("Failed to insert sendmail of abnormal alarm system for purchase_id:"+purchase_id);
    				logger.fatal(e.toString());
        		}
    	}
    	
    }
	public void transactionRegister(String email, String password,String user_name,String newSalt,int parent_id) {
		
		userService.insertUsersByEmail(email,password,user_name,newSalt,parent_id);
	}

	public void transactionIntegral(String addIntergralForRegister, int uid, long time, int type, String email,String user_name) throws Exception {
	
//		if(Integer.valueOf(addIntergralForRegister).doubleValue()>0)
//		{
//			userService.addIntegral(addIntergralForRegister,uid,time,type);
//		}
		//int tid=8;
		//Template tplt=userService.selectTemplateById(tid);
		//userService.addWelcomeEmail(email,tplt.getTemplate_subject(),tplt.getTemplate_content(),user_name);
		

		Context data = new Context();
		//data.setVariable("user_name", user_name);
		//data.setVariable("user_email", email);
		try {
			String emailContent = templateEngine.process("WelcomeEmail", data);
			Sendmail sendmail = new Sendmail();
			sendmail.setContent(emailContent);
			// sendmail.setOrderId(YamiConstant.INT_ZERO);
			// sendmail.setCount(s);
			sendmail.setName(user_name);
			sendmail.setEmail(email);
			sendmail.setCount((short) YamiConstant.INT_ZERO);
			sendmail.setSendTime(Integer.parseInt(DateUtil.getNowLong().toString()));
			sendmail.setSubject("Greetings from Yamibuy.com");

	    	//kafkaProducer.sendold(TOPIC_SENDMAIL, sendmail);
			sendmailService.insert(sendmail);
		} catch (Exception e) {
			logger.fatal("Failed to insert sendmail for userId:" + uid);
			logger.fatal(e.toString());
		}
	}
//	users,token,YamiConstant.ADD_INTERGRAL_FOR_REGISTER,time,type
	public String transactionRegister(Users users, String token, long time) throws Exception {
		// TODO Auto-generated method stub
		userService.insertUsersByEmail(users.getEmail(),users);
		int uid= userService.selectUIdByEmail(users.getEmail());
		String auth = StringUtil.EncoderByMd5(users.getSalt(), String.valueOf(uid), YamiConstant.ENCTIMES);
		String newToken = securityServiceDelegate.getToken(uid, users.getSalt(), auth);
		
		if (null != token) {
			Gson gson = new Gson();
			Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
			String tempId = tokenIn.getData();
			//cartRedisServiceDelegate.updateUserIdByTempid(tempId,uid);
		}
		//throw new RuntimeException();
		return newToken;
	}
	
	public void transactionResetPassword(String email,Integer user_id,String user_name,String link_cn,String link_en) throws Exception {
		
		int count = sendmailService.selectCountByEmail(email, "Reset Password");
		if(count>=2){
			throw new YamiException(YamiConstant.ERRORCODE_ER1304,ErrorCodeEnum.ER1304.getMsg());				
		}		
		Context data = new Context();
		data.setVariable("user_name", user_name);
		data.setVariable("reset_email_cn", link_cn);
		data.setVariable("reset_email_en", link_en);

		String emailContent = templateEngine.process("ResetPasswordEmail", data);
		Sendmail sendmail = new Sendmail();
    	sendmail.setContent(emailContent);
    	sendmail.setName(user_name);
    	sendmail.setEmail(email);
    	sendmail.setCount((short)YamiConstant.INT_ZERO);
    	sendmail.setSubject("Reset Password");
    	//kafkaProducer.sendold(TOPIC_SENDMAIL, sendmail);
   	    sendmailService.insert(sendmail);
	}
	
	/*
	删除收藏商品
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionRemoveFromFavorites(String token,int gid){
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		Map<String,Object> result = new HashMap<String,Object>();
		collectGoodsService.deleteByGidAndUid(gid, Integer.parseInt(tokenIn.getData()));
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	/*
	批量删除收藏商品（下架、删除商品）
	@param int uid 
	@param List<String> lstGid 
	@return int
	*/	
	public  void transactionRemoveFromFavorites(int uid,List<Integer> lstGid){
		for(Integer gid:lstGid){
			collectGoodsService.deleteByGidAndUid(gid, uid);
		}
	}
	
	/*
	添加收藏商品
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionAddToFavorites(String token,int gid)throws Exception{
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		Map<String,Object> result = new HashMap<String,Object>();
		int count = collectGoodsService.selectGoodsCountByUidGid(Integer.parseInt(tokenIn.getData()), gid);
		
		if(count==0){
			CollectGoods collectGoods = new CollectGoods();
			collectGoods.setGoodsId(gid);
			collectGoods.setUserId(Integer.parseInt(tokenIn.getData()));
			collectGoods.setIsAttention(false);
			collectGoods.setAddTime(Integer.parseInt(DateUtil.getNowLong().toString()));
			collectGoodsService.insert(collectGoods);
		}
		result.put("token", token);
		result.put("status", 1);
		
		return result;
	}
	
	/*
	修改用户名
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionEditUserName(String token,String username)throws Exception{
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		int count = userService.selectCountByUserName(uid,username);
		if(count==0){
		userService.updateUserNameByUid(uid, username);
		}else{
			 throw new YamiException(YamiConstant.ERRORCODE_ER1303,ErrorCodeEnum.ER1303.getMsg());	
		}
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	/*
	修改用户性别
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionEditSex(String token,int gender)throws Exception{
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		String avatar=YamiConstant.STRING_EMPTY;
		if(gender==1){
			avatar = "images/avatar/m1.png";
		}else if(gender==2){
			avatar = "images/avatar/f1.png";			
		}else{
			avatar = "images/avatar/s1.png";
		}		
		userService.updateSexByUid(uid, gender, avatar);
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	
	/*
	修改用户性别
	@param String token 
	@param int gid 
	@return int
	*/	
	public  int transactionUpdateGoodPriceOfCart(int rec_id,BigDecimal goods_price){

		return cartService.updateGoodPriceOfCart(rec_id, goods_price);
	}

	public  int transactionUpdateAbnormalByPurchaseId(int abnormal,int purchase_id){

		return orderInfoService.updateAbnormalByPurchaseId(abnormal, purchase_id);
	}
	
	/*
	修改用户手机号
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionEditPhone(String token,String mobile_phone){
		if(null==mobile_phone||mobile_phone.equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1605,ErrorCodeEnum.ER1605.getMsg());	
		}
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		userService.updatePhoneByUid(uid, mobile_phone);
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	/*
	修改用户手机号
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionEditTruename(String token,String truename){

		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		userService.updateTureNameByUid(uid, truename);
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	/*
	修改用户手机号
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionEditEmail(String token,String email){

		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		userService.updateEmail(uid, email);
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	/*
	修改用户信息
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionUsersInfo(String token,String username,int gender,String birthday,String phone){

		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		int count = userService.selectCountByUserName(uid,username);
		if(count==0){
			userService.updateUserNameByUid(uid, username);
		}else{
			 throw new YamiException(YamiConstant.ERRORCODE_ER1303,ErrorCodeEnum.ER1303.getMsg());	
		}	
		String avatar=YamiConstant.STRING_EMPTY;
		if(gender==1){
			avatar = "images/avatar/m1.png";
		}else if(gender==2){
			avatar = "images/avatar/f1.png";			
		}else{
			avatar = "images/avatar/s1.png";
		}
		userService.updateUserInfoByUid(uid, username, gender, birthday, phone, avatar);
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	/*
	修改用户手机号
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionAddFeedback(String token,String msgTitle,String msgContent,String msgEmail,String filePath)throws Exception{

		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = 0;
		Users users = new Users();
		if(tokenIn.getIsLogin()==1){
			uid = Integer.parseInt(tokenIn.getData());
			users = userService.selectUserInfoByUid(uid);
		}else{
			users.setUserId(uid);
			//users.setUserName(YamiConstant.NO_LOGIN_USER_NAME);
		}
		
		Map<String,Object> result = new HashMap<String,Object>();
		Feedback feedback = new Feedback();
		feedback.setParentId(0);
		feedback.setUserId(uid);
		//feedback.setUserName(users.getUserName());
		
		
		if(null!=msgEmail){
			feedback.setUserEmail(msgEmail);		
		}else{
			feedback.setUserEmail(users.getEmail());		
		}
		feedback.setMsgTitle(msgTitle);
		feedback.setMsgType(0);
		feedback.setMsgStatus(false);
		feedback.setMsgContent(msgContent);
		feedback.setMsgTime(Integer.parseInt(DateUtil.getNowLong().toString()));
		feedback.setMessageImg(filePath);
		feedback.setOrderId(0);
		feedback.setMsgArea(false);
		userService.insertFeedback(feedback);
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	/*
	添加用户评论信息
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionAddItemComment(String token,Integer gid,String nickname,String content,String paths,BigDecimal rate,String ip)throws Exception{
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		
		Map<String,Object> result = new HashMap<String,Object>(); 
		//插入评论基础信息xusc_message
		Message message = new Message();
		message.setCaseId(0);
		message.setUid(uid);
		message.setRid(0);
		message.setOrderId(0);
		message.setGoodsId(gid);
		message.setType(true);
		message.setDateline(Integer.parseInt(DateUtil.getNowLong().toString()));
		message.setIp(ip);
		 goodsService.insertMessage(message);
		int mid =message.getMid();
		
		
		
		//插入评论详细信息xusc_message_post
		MessagePost messagePost = new MessagePost();
		messagePost.setMid(mid);
		messagePost.setUid(uid);
		messagePost.setRid(0);
		messagePost.setDateline(Integer.parseInt(DateUtil.getNowLong().toString()));
		messagePost.setContent(StringUtil.htmlEncode(content));
		messagePost.setMessNickname(StringUtil.htmlEncode(nickname));
		messagePost.setpRank(Short.parseShort("0"));
		messagePost.setType(false);
		messagePost.setIp(ip);
		messagePost.setInvisible(0);
		 goodsService.insertMessagePost(messagePost);
		int pid =messagePost.getPid();
		
		//插入评论打分信息xusc_message_comment
		MessageComment messageComment = new MessageComment();
		messageComment.setMid(mid);
		messageComment.setDateline(Integer.parseInt(DateUtil.getNowLong().toString()));
		messageComment.setRank(rate.floatValue());
		messageComment.setIp(ip);
		goodsService.insertMessageComment(messageComment);
		int cid = messageComment.getCid();
		//添加评论图片信息xusc_message_image
		if(null!=paths){
			String[] strPath = paths.split(",");
			for(int i=0;i<strPath.length;i++){
				MessageImage messageImage = new MessageImage();
				messageImage.setPid(pid);
				messageImage.setPath(strPath[i]);
				messageImage.setDateline(Integer.parseInt(DateUtil.getNowLong().toString()));
				messageImage.setImgStatus(0);
				goodsService.insertMessageImage(messageImage);
			}
		}
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	
	/*
	查询订单信息
	@param String purchase_id 
	@return PurchaseInfo
	*/	
	public  PurchaseInfo transactionSelectOrderByPurchaseId(String purchase_id){
		 return orderInfoService.selectOrderByPurchaseId(Integer.parseInt(purchase_id));
	}
	
	/*
	修改用户缺货邮件提醒邮箱
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionEditRemindEmail(String token,String email){

		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		userService.updateRemindEmail(uid, email);
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	
	/*
	添加用户缺货邮件提醒
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionAddRemind(String token,int gid){

		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		userService.insertRemind(uid, gid);
		User user = userService.selectUsersByID(uid);
		
		
		result.put("token", token);
		result.put("status", 1);
		result.put("email", user.getQuestion());
		return result;
	}
	/*
	删除用户缺货邮件提醒
	@param String token 
	@param int gid 
	@return int
	*/	
	public  Map<String,Object> transactionRemoveRemind(String token,int gid){

		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		userService.deleteRemind(uid, gid);
		
		
		result.put("token", token);
		result.put("status", 1);
		return result;
	}
	
	
	/*
	更新抽奖信息各相关数据
	@param String token 
	@param int gid 
	@return int
	*/	
	public  void transactionUpdateLotteryDetails(String token,LotteryConfigRedis userLotteryInfo,LotterySetRedis lotterySetRedis)throws Exception{

		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		if(null!=userLotteryInfo){
			//1、减少奖池金额
			userService.updateTotalPoint4Winning(lotterySetRedis.getRecId(), userLotteryInfo.getPointNum());
			//2、记录抽奖历史
			PointLotterylog pointLotterylog = new PointLotterylog();
			pointLotterylog.setUserId(uid);
			pointLotterylog.setTime(DateUtil.getNowLong());
			pointLotterylog.setGetPoint(userLotteryInfo.getPointNum());
			userService.insert(pointLotterylog);
			//3、增加用户对应积分
			userService.updateUserPayPoint(uid,userLotteryInfo.getPointNum());
			//修改lottery_config 信息
			userService.updatePointLotteryConfigWinningNum(userLotteryInfo.getRecId());
			//4、记录抽奖需要使用积分信息
			if(lotterySetRedis.getSpend().intValue()>0){
				//4.1扣除用户积分
				userService.updatePointByUid(uid, lotterySetRedis.getSpend().longValue());
				//4.2记录使用积分抽奖历史
		    	Integral integral = new Integral();
	    		integral.setIntegral(String.valueOf(lotterySetRedis.getSpend()));
	    		integral.setDate(DateUtil.getNowLong().intValue());
	    		integral.setUserId(uid);
	    		integral.setType(YamiConstant.POINTS_TYPE_NO_1);
	    		integral.setOrderId(0);
	    		userService.addIntegralSelective(integral);
			}
			//5、记录抽奖获得积分历史
	    	Integral integral = new Integral();
    		integral.setIntegral(String.valueOf(userLotteryInfo.getPointNum()));
    		integral.setDate(DateUtil.getNowLong().intValue());
    		integral.setUserId(uid);
    		integral.setType(YamiConstant.POINTS_TYPE_NO_4);
    		integral.setOrderId(0);
    		userService.addIntegralSelective(integral);
			
			
			
			
		}
		else{
			userService.updateLotterySetNoWinning(lotterySetRedis.getRecId());
		}
		
	
		

	}
	
	/*
	更新用户邀请码
	@param String token 
	@param int uid
	@param String invite_code 
	@return int
	*/	
	public  void transactionUpdateInviteCodeByUid(int user_id,String invite_code){
		userService.updateInviteCodeByUid(user_id, invite_code);
	}
	
	
	/*
	更新用户邀请码
	@param String token 
	@param int uid
	@param String invite_code 
	@return int
	*/	
	public  void transactionAddSendMail(Sendmail sendmail){
		sendmailService.insert(sendmail);
	}
	
	
}
