package com.shubilee.delegate;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.QueryParam;

import net.paymentech.ws.NewOrderRequestElement;
import net.paymentech.ws.NewOrderResponseElement;
import net.paymentech.ws.ProfileAddElement;
import net.paymentech.ws.ProfileResponseElement;
import net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayLocator;
import net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayPortType;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.google.gson.Gson;
import com.shubilee.bean.InviteHistory;
import com.shubilee.bean.InviteSummary;
import com.shubilee.common.CardType;
import com.shubilee.common.DateUtil;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.LotteryComputing;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.entity.Address;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Count;
import com.shubilee.entity.EmailToken;
import com.shubilee.entity.Feedback;
import com.shubilee.entity.FeedbackRe;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsImage;
import com.shubilee.entity.Integral;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.PointLotteryConfig;
import com.shubilee.entity.PointLotterySet;
import com.shubilee.entity.Profile;
import com.shubilee.entity.PurchaseInfo;
import com.shubilee.entity.Sendmail;
import com.shubilee.entity.Token;
import com.shubilee.entity.User;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserInfoOrder;
import com.shubilee.entity.UserInfoOrderMaxCat;
import com.shubilee.entity.UserInfoOrderMaxGoods;
import com.shubilee.entity.UserProfile;
import com.shubilee.entity.Users;
import com.shubilee.entity.Vendors;
import com.shubilee.redis.entity.LotteryConfigRedis;
import com.shubilee.redis.entity.LotterySetRedis;
import com.shubilee.redis.entity.LotteryUserRedis;
import com.shubilee.service.BlacklistService;
import com.shubilee.service.CompositeQueryService;
import com.shubilee.service.GoodsService;
import com.shubilee.service.LotteryConfigRedisService;
import com.shubilee.service.LotterySetRedisService;
import com.shubilee.service.LotteryUserRedisService;
import com.shubilee.service.OrderInfoService;
import com.shubilee.service.SendmailService;
import com.shubilee.service.UserService;

@Service
public class UserServiceDelegate {

	@Autowired
	private UserService userService;	

	@Autowired
	private BlacklistService blacklistService;	
	
	
	@Autowired
	private SecurityServiceDelegate securityServiceDelegate;
	
	
	@Autowired
	private TransactionDelegate transactionDelegate;

	@Autowired
	private CompositeQueryService compositeQueryService;
	
	@Autowired
	private SendmailService sendmailService;	
	
	@Autowired
	private LotteryUserRedisService lotteryUserRedisService;	
	@Autowired
	private LotterySetRedisService lotterySetRedisService;
	@Autowired
	private LotteryConfigRedisService lotteryConfigRedisService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private TemplateEngine templateEngine;
	@Autowired
	private GoodsService goodsService;
	
	@Value("${USER_RESET_LINK_CN}")
	private String USER_RESET_LINK_CN;
	@Value("${USER_RESET_LINK_EN}")
	private String USER_RESET_LINK_EN;
	@Value("${USER_EMAIL_EXP}")
	private Integer USER_EMAIL_EXP;

	//@Autowired
	//private LogUtil logger;
	private Logger logger = LogManager.getLogger(this.getClass().getName());
	
	public String getUserName(int uid){
		
		// add your business logic here
		
		return userService.getUserName(uid);
	}
	

    public User selectUsersByID(int id){

		// add your business logic here
		
		return userService.selectUsersByID(id);
    }
    
	public Map<String, Object> registerUser_sendEmail(String token, String emailTemp,
			String pwd, String firstName, String lastName, String zipcode) throws Exception {
		if(!StringUtil.checkEmail(emailTemp)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1603,ErrorCodeEnum.ER1603.getMsg());	
		}
		if(!StringUtil.checkMoneLength(pwd, 6)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1604,ErrorCodeEnum.ER1604.getMsg());	
		}
		if(!StringUtil.checkZipcode(zipcode)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1610,ErrorCodeEnum.ER1610.getMsg());	
		} 
		//如果有email重名 报错
		User user = userService.getPasswordSalt(emailTemp);
		if(user!=null)
		{
			throw new YamiException(YamiConstant.ERRORCODE_ER1302,ErrorCodeEnum.ER1302.getMsg());
		}
		Map<String, Object> model = new HashMap<String, Object>();
		String email=emailTemp; 		
		
		Random random = new Random();
		String newSalt = String.valueOf(random.nextInt(YamiConstant.RANDOM_SALT_RANGE));
		String password = StringUtil.EncoderByMd5(newSalt, pwd, YamiConstant.ENCTIMES);  

		//添加 user数据库

		long time=System.currentTimeMillis()/1000;
		
		Users users= new Users();
		
		//String avatar= "images/avatar/s1.png";
		
		String temp="";
		temp=String.valueOf(time);
		Integer date=Integer.valueOf(temp); 	
		
		users.setRegTime(date);
		users.setLastLogin(date);
		
		//users.setAvatar(avatar);
		users.setEmail(email);
		users.setPassword(password);
		users.setFirstName(firstName);
		users.setLastName(lastName);
		//users.setParentId(parent_id);
		users.setSalt(newSalt);
		users.setPayPoints(YamiConstant.INT_ZERO);
		
		userService.insertUsersByEmail(users.getEmail(),users);
		int uid= userService.selectUIdByEmail(users.getEmail());
		String auth = StringUtil.EncoderByMd5(users.getSalt(), String.valueOf(uid), YamiConstant.ENCTIMES);
		int userType = 0;
		String newToken = securityServiceDelegate.getToken(uid, users.getSalt(), auth,userType);
		
		model.put("token",newToken);
		return model;		
	}
    
	public Map<String, Object> registerUser_verifyEmail(String token, String emailTemp,
			String pwd, String firstName, String lastName, String zipcode) throws Exception {

		String email=emailTemp;
		
		
		Random random = new Random();
		String newSalt = String.valueOf(random.nextInt(YamiConstant.RANDOM_SALT_RANGE));
		Map<String, Object> model = new HashMap<String, Object>();
		String password = StringUtil.EncoderByMd5(newSalt, pwd, YamiConstant.ENCTIMES);  

		//添加 user数据库

		long time=System.currentTimeMillis()/1000;
		
		Users users= new Users();
		
		//String avatar= "images/avatar/s1.png";

		
		String temp="";
		temp=String.valueOf(time);
		Integer date=Integer.valueOf(temp); 	
		
		users.setRegTime(date);
		users.setLastLogin(date);
		
		//users.setAvatar(avatar);
		users.setEmail(email);
		users.setPassword(password);
		users.setFirstName(firstName);
		users.setLastName(lastName);
		//users.setParentId(parent_id);
		users.setSalt(newSalt);
		users.setPayPoints(YamiConstant.INT_ZERO);
		
		userService.insertUsersByEmail(users.getEmail(),users);
		int uid= userService.selectUIdByEmail(users.getEmail());
		String auth = StringUtil.EncoderByMd5(users.getSalt(), String.valueOf(uid), YamiConstant.ENCTIMES);
		int userType = 0;
		String newToken = securityServiceDelegate.getToken(uid, users.getSalt(), auth,userType);
		
		model.put("token",newToken);
		return model;
	}
    
	public Map<String, Object> forgetPassword(String token, String email)
			throws Exception {
		EmailToken emailToken = new EmailToken();
		Map<String, Object> model = new HashMap<String, Object>();
		Gson gson = new Gson();
		User user = userService.getPasswordSalt(email);
		if(user==null){
			throw new YamiException(YamiConstant.ERRORCODE_ER1307,ErrorCodeEnum.ER1307.getMsg());				
		}
		String uname = user.getUser_Name();
		Integer user_id = user.getUser_Id();
		int timeout = 3600*USER_EMAIL_EXP;
		long exp = DateUtil.timeFormat(DateUtil.getNowDateTimeAllString())+timeout;
		String hash = StringUtil.EncoderByMd5(user.getEc_salt(),String.valueOf(user_id)); 
		emailToken.setUid(user_id);
		emailToken.setExp(exp);
		emailToken.setHash(hash);
		String link_cn = USER_RESET_LINK_CN +"&code="+StringUtil.encode(gson.toJson(emailToken));
		String link_en = USER_RESET_LINK_EN +"&code="+StringUtil.encode(gson.toJson(emailToken));
		transactionDelegate.transactionResetPassword(email,user_id,uname,link_cn,link_en);
		model.put("token",token);
		model.put("email",email);
		return model;
	}
	
	public Map<String, Object> resetPassword(String token, String pwd, String code)
			throws Exception {
		

		Gson gson = new Gson();
		Random random = new Random();
		EmailToken emailToken = new EmailToken();
		Integer user_id; 
		try {
			emailToken = gson.fromJson(StringUtil.decode(code), emailToken.getClass());

		} catch (Exception e) {
			throw new YamiException(YamiConstant.ERRORCODE_ER1305, ErrorCodeEnum.ER1305.getMsg());
		}
		user_id = emailToken.getUid();
		String salt = userService.selectUsersByID(user_id).getEc_salt();
		long exp = emailToken.getExp();
		String hash = emailToken.getHash();		
		if (!hash.equals(StringUtil.EncoderByMd5(salt, String.valueOf(user_id)))) {
			throw new YamiException(YamiConstant.ERRORCODE_ER1305,
					ErrorCodeEnum.ER1305.getMsg());
		}
		if (exp < DateUtil.timeFormat(DateUtil.getNowDateTimeAllString())) {
			throw new YamiException(YamiConstant.ERRORCODE_ER1306,
					ErrorCodeEnum.ER1306.getMsg());
		}		
		String newSalt = String.valueOf(random.nextInt(YamiConstant.RANDOM_SALT_RANGE));
		String password = StringUtil.EncoderByMd5(newSalt, pwd, YamiConstant.ENCTIMES);  

	    //logger.info("new salt="+ newSalt);
	    //logger.info("new password="+password);
	    User user = new User();
		user.setEc_salt(newSalt);
		user.setPassword(password);
		user.setUser_Id(user_id);


		transactionDelegate.transactionResetPassword(user);
		
		String tempid = securityServiceDelegate.getTempId();
		Map<String, Object> result = securityServiceDelegate.getToken4Tempid(tempid);
		return result;
	}
	
	public Map<String, Object> loginUser(String token, String email, String pwd)
			throws Exception {
		
		if(!StringUtil.checkEmail(email)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1601,ErrorCodeEnum.ER1601.getMsg());	
		}
		if(!StringUtil.checkMoneLength(pwd, 6)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1602,ErrorCodeEnum.ER1602.getMsg());	
		}
		
		String newSalt = null;
		Map<String, Object> model = new HashMap<String, Object>();
		Gson gson = new Gson();
		
		//1.get ecSalt and password(MD5) from DB.
		User user = userService.getPasswordSalt(email);
		
	    //logger.info("token="+token+";email="+email+";pwd="+pwd);
		if (null==user) {
			throw new YamiException(YamiConstant.ERRORCODE_ER1301,ErrorCodeEnum.ER1301.getMsg());
		}		
		String salt = user.getEc_salt();
		
		//2.calculate the password(MD5) with password(parameter) and ecSalt(DB).
		String password = StringUtil.EncoderByMd5(salt, pwd, YamiConstant.ENCTIMES);
		int uid =  user.getUser_Id();
		
	    //logger.info("password(MD5)="+password);
	    
	    //3.compare password(MD5).
		if (!password.equals(user.getPassword())) {
			throw new YamiException(YamiConstant.ERRORCODE_ER1301,ErrorCodeEnum.ER1301.getMsg());
		}
		
		//4.calculate the NEW password(MD5) with password(parameter) and NEW ecSalt(random).
		Random random = new Random();
		do {
			newSalt = String.valueOf(random.nextInt(YamiConstant.RANDOM_SALT_RANGE));
		} while (newSalt.equals(salt));
		password = StringUtil.EncoderByMd5(newSalt, pwd, YamiConstant.ENCTIMES);

	    //logger.info("salt="+salt);
	    //logger.info("new salt="+ newSalt);
	    //logger.info("new password="+password);
		user.setEc_salt(newSalt);
		user.setPassword(password);
		user.setEmail(email);
		user.setLastLogin(Integer.parseInt(DateUtil.getNowLong().toString()));

		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);

		String auth = StringUtil.EncoderByMd5(newSalt, String.valueOf(uid), YamiConstant.ENCTIMES);
		//5.return userId, userName and new token.
		String newToken = securityServiceDelegate.getToken(uid, newSalt, auth);
		model.put("uid", uid);
		model.put("name", user.getUser_Name());
		model.put("token",newToken);
		
	    //logger.info("retrun model="+model);
		//6.update new password(MD5) and ecSalt to DB.
		//7.update the userId of cart and clear tempId.
		transactionDelegate.transactionLogin(user,tokenIn);
		
		return model;

	}
	
	public Map<String, Object> logoutUser(String token) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();
		String tempid = securityServiceDelegate.getTempId();
		result = securityServiceDelegate.getToken4Tempid(tempid);
		return result;
		
	}	
	
	public Map<String, Object> getAddressBook(String token) throws Exception {

		Gson gson = new Gson();
		Map<String, Object> model = new HashMap<String, Object>();
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		List<UserAddress> address = userService.getAddressBookByUid(Integer.valueOf(tokenIn.getData()));
		model.put("addrList", address);
		model.put("token", token);
		return model;
		
	}
	
	public Map<String, Object> newAddress(String token, String firstname, String lastname,
			String address1, String address2, String city, String state, String zipcode, String phone, String email, String verified) throws Exception {

		if(null==firstname||firstname.trim().equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1607,ErrorCodeEnum.ER1607.getMsg());	
		}
		if(null==lastname||lastname.trim().equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1606,ErrorCodeEnum.ER1606.getMsg());	
		}		
		if(null==address1||address1.trim().equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1608,ErrorCodeEnum.ER1608.getMsg());	
		}
		if(null==city||city.trim().equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1609,ErrorCodeEnum.ER1609.getMsg());	
		}
		if(null==zipcode||!StringUtil.checkZipcode(zipcode)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1610,ErrorCodeEnum.ER1610.getMsg());	
		}
		if(null==phone||phone.trim().equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1611,ErrorCodeEnum.ER1611.getMsg());	
		}
		if(null==email||!StringUtil.checkEmail(email)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1612,ErrorCodeEnum.ER1612.getMsg());	
		}
		if(StringUtil.filterChinese(firstname).length()!=0||StringUtil.filterChinese(lastname).length()!=0){
			throw new YamiException(YamiConstant.ERRORCODE_ER1614,ErrorCodeEnum.ER1614.getMsg());				
		}
		if(StringUtil.filterChinese(address1).length()!=0||StringUtil.filterChinese(address2).length()!=0){
			throw new YamiException(YamiConstant.ERRORCODE_ER1615,ErrorCodeEnum.ER1615.getMsg());				
		}
		Gson gson = new Gson();
		Map<String, Object> model = new HashMap<String, Object>();	
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		UserAddress address = new UserAddress();
		int userId = Integer.valueOf(tokenIn.getData());
		int countAddress = userService.countAddressByUid(userId);
		address.setAddress(address1);
		address.setAddress2(address2);
		address.setCity(city);
		address.setConsignee(firstname+YamiConstant.STRING_SPACE+lastname);
		address.setConsignee_firstname(firstname);
		address.setConsignee_lastname(lastname);
		address.setCountry(YamiConstant.COUNTRY_UNITEDSTATES);
		address.setIs_primary(countAddress==YamiConstant.NO_RECORD?YamiConstant.IS_PRIMARY:YamiConstant.IS_NOT_PRIMARY);
		address.setProvince(state);
		address.setTel(phone);
		address.setUser_id(userId);
		address.setZipcode(zipcode);
		//for not used column but used by old PC logic
		address.setAddress_name(YamiConstant.STRING_EMPTY);
		address.setEmail(email==null?YamiConstant.STRING_EMPTY:email);
		address.setDistrict(YamiConstant.INT_ZERO);
		address.setMobile(YamiConstant.STRING_EMPTY);
		address.setSign_building(YamiConstant.STRING_EMPTY);
		address.setBest_time(YamiConstant.STRING_EMPTY);
		address.setVerified(verified==null?YamiConstant.INT_ZERO:Integer.valueOf(verified));
		
		transactionDelegate.transactionNewAddress(address);
		model.put("address_id", address.getAddress_id());
		model.put("firstname", address.getConsignee_firstname());
		model.put("lastname", address.getConsignee_lastname());
		model.put("address1", address.getAddress());
		model.put("address2", address.getAddress2());
		model.put("city", address.getCity());
		model.put("state", address.getProvince());
		model.put("zipcode", address.getZipcode());
		model.put("phone", address.getTel());
		model.put("email", address.getEmail());
		model.put("token", token);
		return model;

	}
	
	public Map<String, Object> editAddress(String token, int address_id, String firstname, String lastname,
			String address1, String address2, String city, String state, String zipcode, String phone,String profile_id, String email) throws Exception {

		if(null==firstname||firstname.equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1607,ErrorCodeEnum.ER1607.getMsg());	
		}
		if(null==lastname||lastname.trim().equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1606,ErrorCodeEnum.ER1606.getMsg());	
		}				
		if(null==address1||address1.equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1608,ErrorCodeEnum.ER1608.getMsg());	
		}
		if(null==city||city.equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1609,ErrorCodeEnum.ER1609.getMsg());	
		}
		if(null==zipcode||!StringUtil.checkZipcode(zipcode)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1610,ErrorCodeEnum.ER1610.getMsg());	
		}
		if(null==phone||phone.trim().equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1611,ErrorCodeEnum.ER1611.getMsg());	
		}
		if(null==email||!StringUtil.checkEmail(email)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1612,ErrorCodeEnum.ER1612.getMsg());	
		}
		if(StringUtil.filterChinese(firstname).length()!=0||StringUtil.filterChinese(lastname).length()!=0){
			throw new YamiException(YamiConstant.ERRORCODE_ER1614,ErrorCodeEnum.ER1614.getMsg());				
		}
		if(StringUtil.filterChinese(address1).length()!=0||StringUtil.filterChinese(address2).length()!=0){
			throw new YamiException(YamiConstant.ERRORCODE_ER1615,ErrorCodeEnum.ER1615.getMsg());				
		}	
		Gson gson = new Gson();
		Map<String, Object> model = new HashMap<String, Object>();
		if(userService.countAddressByPK(address_id)==YamiConstant.NO_RECORD){
			throw new YamiException(YamiConstant.ERRORCODE_ER1321,ErrorCodeEnum.ER1321.getMsg());			
		}		
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		UserAddress address = new UserAddress();
		address.setAddress_id(address_id);
		address.setAddress(address1);
		address.setAddress2(address2);
		address.setCity(city);
		address.setConsignee(firstname+YamiConstant.STRING_SPACE+lastname);
		address.setConsignee_firstname(firstname);
		address.setConsignee_lastname(lastname);
		address.setCountry(YamiConstant.COUNTRY_UNITEDSTATES);
		address.setProvince(state);
		address.setTel(phone);
		address.setUser_id(Integer.valueOf(tokenIn.getData()));
		address.setZipcode(zipcode);
		//for not used column but used by old PC logic
		address.setAddress_name(YamiConstant.STRING_EMPTY);
		address.setEmail(email==null?YamiConstant.STRING_EMPTY:email);
		address.setDistrict(YamiConstant.INT_ZERO);
		address.setMobile(YamiConstant.STRING_EMPTY);
		address.setSign_building(YamiConstant.STRING_EMPTY);
		address.setBest_time(YamiConstant.STRING_EMPTY);		
		
		transactionDelegate.transactionEditAddress(address,profile_id);
		model.put("status", YamiConstant.STATUS_OK);
		model.put("firstname", address.getConsignee_firstname());
		model.put("lastname", address.getConsignee_lastname());
		model.put("address1", address.getAddress());
		model.put("address2", address.getAddress2());
		model.put("city", address.getCity());
		model.put("state", address.getProvince());
		model.put("zipcode", address.getZipcode());
		model.put("phone", address.getTel());	
		model.put("email", address.getEmail());	
		model.put("token", token);
		return model;

	}
	
	public Map<String, Object> deleteAddress(String token, int address_id) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();
		UserAddress userAddress = userService.getAddressBookByAddId(address_id);
		if(userAddress==null){
			throw new YamiException(YamiConstant.ERRORCODE_ER1321,ErrorCodeEnum.ER1321.getMsg());			
		}
		Gson gson = new Gson();		
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		Integer uid = Integer.valueOf(tokenIn.getData());
		transactionDelegate.transactionDeleteAddress(address_id,uid,userAddress.getIs_primary(),null);
		model.put("status", YamiConstant.STATUS_OK);
		model.put("token", token);
		return model;

	}
	
	public Map<String, Object> getPayments(String token) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		Gson gson = new Gson();
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		List<Profile> profiles = userService.getProfileByUid(Integer.valueOf(tokenIn.getData()));
		model.put("payments", profiles);
		model.put("token", token);
		return model;

	}
	
	public Map<String, Object> newPayment(String token, String firstname, String lastname, String type, String account,
			String exp_year, String exp_month, String address_id) throws Exception {
		if(null==firstname||firstname.trim().equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1607,ErrorCodeEnum.ER1607.getMsg());	
		}

		if(null==account||!StringUtil.checkAccount(account.trim())){
			throw new YamiException(YamiConstant.ERRORCODE_ER1613,ErrorCodeEnum.ER1613.getMsg());	
		}
	
		Map<String, Object> model = new HashMap<String, Object>();
		Gson gson = new Gson();
		UserProfile profile = new UserProfile();
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		String cardNum = account.trim();
		Integer uid = Integer.valueOf(tokenIn.getData());
		Boolean addBlacklist = false;
		int countBlackCardNum = blacklistService.selectCountByBankCard(cardNum);
		if (countBlackCardNum != 0) {
			Integer countBlackUserId = blacklistService.selectCountByUserId(uid);
			if (countBlackUserId == 0)
				addBlacklist = true;
		}
		Integer tail =Integer.valueOf(cardNum.substring(cardNum.length() - 4));
		String cardType = CardType.detect(account).toString();
		if(cardType.equals(YamiConstant.OGWS_CARD_TYPE_UNKN)||cardType.equals(YamiConstant.OGWS_CARD_TYPE_DINE)){
			throw new YamiException(YamiConstant.ERRORCODE_ER1616,ErrorCodeEnum.ER1616.getMsg());				
		}
		String profileId = uid + "M" + DateUtil.getNowLong().toString();
		int countProfile = userService.countProfileByUid(uid);
		profile.setAddress_id(Integer.valueOf(address_id));
		profile.setCard_type(cardType);
		profile.setExp_year(exp_year);
		profile.setExp_month(exp_month);
		profile.setFirstname(firstname);
		profile.setLastname(lastname);
		profile.setProfile_id(profileId);
		profile.setTail(tail);
		profile.setUser_id(uid);
		profile.setIs_primary(countProfile==YamiConstant.NO_RECORD?YamiConstant.IS_PRIMARY:YamiConstant.IS_NOT_PRIMARY);
		transactionDelegate.transactionNewPayment(profile,account,addBlacklist);
		model.put("token", token);
		model.put("address_id", address_id);
		model.put("firstname", firstname);
		model.put("lastname", lastname);
		model.put("profile_id", String.valueOf(profileId));
		model.put("type", cardType);
		model.put("tail", tail);
		model.put("exp_year", exp_year);
		model.put("exp_month", exp_month);
		//logger.info("retrun model=" + model);
		return model;

	}
	
	public Map<String, Object> editPayment(String token, String profile_id, String firstname, String lastname,
			String exp_year, String exp_month, Integer address_id) throws Exception {

		if(null==firstname||firstname.equals("")){
			throw new YamiException(YamiConstant.ERRORCODE_ER1607,ErrorCodeEnum.ER1607.getMsg());	
		}


		Map<String, Object> model = new HashMap<String, Object>();
		Gson gson = new Gson();
		if(userService.countProfileByPK(profile_id)==YamiConstant.NO_RECORD){
			throw new YamiException(YamiConstant.ERRORCODE_ER1312,ErrorCodeEnum.ER1312.getMsg());			
		}
		UserProfile profile = new UserProfile();
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		//String cardNum = String.valueOf(account);
		//Integer tail =Integer.valueOf(cardNum.substring(cardNum.length() - 4));
		Integer uid = Integer.valueOf(tokenIn.getData());
		//String cardType = type != null && !type.isEmpty()?type:CardType.detect(String.valueOf(account)).toString();
		profile.setAddress_id(address_id);
		//profile.setCard_type(cardType);
		profile.setExp_year(exp_year);
		profile.setExp_month(exp_month);
		profile.setFirstname(firstname);
		profile.setLastname(lastname);
		profile.setProfile_id(profile_id);
		//profile.setTail(tail);
		profile.setUser_id(uid);
		transactionDelegate.transactionEditPayment(profile);
		model.put("token", token);
		model.put("address_id", address_id);
		model.put("firstname", firstname);
		model.put("lastname", lastname);
		model.put("profile_id", String.valueOf(profile_id));
		model.put("exp_year", exp_year);
		model.put("exp_month", exp_month);
		//logger.info("retrun model=" + model);
		return model;

	}
	
	public Map<String, Object> editPaymentAddress(String token, String profile_id, Integer address_id) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();

		if(userService.countProfileByPK(profile_id)==YamiConstant.NO_RECORD){
			throw new YamiException(YamiConstant.ERRORCODE_ER1312,ErrorCodeEnum.ER1312.getMsg());			
		}

		transactionDelegate.transactionEditPaymentAddress(address_id,profile_id);
		model.put("token", token);
		model.put("address_id", address_id);
		model.put("profile_id", String.valueOf(profile_id));
		//logger.info("retrun model=" + model);
		return model;

	}
	
	public Map<String, Object> deletePayment(String token, String profile_id) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();
		UserProfile profile = userService.getProfileByPid(profile_id);
		if(profile==null){
			throw new YamiException(YamiConstant.ERRORCODE_ER1312,ErrorCodeEnum.ER1312.getMsg());			
		}
		Gson gson = new Gson();		
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		Integer uid = Integer.valueOf(tokenIn.getData());
		transactionDelegate.transactionDeletePayment(profile_id,uid,profile.getIs_primary());
		model.put("token", token);
		model.put("status", YamiConstant.STATUS_OK);
		//logger.info("retrun model=" + model);
		return model;

	}
	
	//TODO
	public Map<String, Object> getPayment() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		NewOrderResponseElement authResponse = null;
		// First Get the service
		PaymentechGatewayLocator service = new PaymentechGatewayLocator();
		// Next create a port from the service – replace the url below
		PaymentechGatewayPortType portType = service.getPaymentechGateway(new URL(
				"https://wsvar.paymentech.net/PaymentechGateway"));

		// Create a Auth request
		NewOrderRequestElement authBean = new NewOrderRequestElement();
		authBean.setOrbitalConnectionUsername("TRAN0CT3ST01");
		authBean.setOrbitalConnectionPassword("R250URC3PA55");
		authBean.setVersion("2.6");
		authBean.setIndustryType("EC");
		authBean.setTransType("AC");
		authBean.setBin("000002");
		authBean.setMerchantID("700000005268");
		authBean.setTerminalID("001");
		authBean.setAmount("1000");
		authBean.setCcAccountNum("4055011111111111");
		authBean.setCcExp("201605");
		authBean.setComments("Test Web Service Auth Only Transaction");
		authBean.setOrderID("testOrder");
		// Invoke the newOrder service and print reponse
		try {
			authResponse = portType.newOrder(authBean);
		} catch (Exception ie) {
			logger.error("######### Error Response ##############");
			logger.error(ie.toString());
			throw ie;
		}
		//logger.info("###Response Received ###");
		//logger.info(" ProcStatus: " + authResponse.getProcStatus());
		//logger.info(" ProcStatusMessage: " + authResponse.getProcStatusMessage());
		//logger.info(" ApprovalStatus: " + authResponse.getApprovalStatus());

		return model;
	}


	//public Map<String, Object> selectOrders(String token, int purchase_id) {
	public Map<String, Object> selectOrders(String token, int page, String agent, Integer purchase_id) {
		Map<String, Object> model = new HashMap<String, Object>();
		//Map<String, Object> purchase = new HashMap<String, Object>();
		//List<Object> orders = new ArrayList<Object>();
		List<Object> Purchase = new ArrayList<Object>();
		Map<String, Object> items = new HashMap<String, Object>();
		if(purchase_id!=null)
		{
			page=1;
		}
		
		int index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
		int ITEMS_PER_PAGE = YamiConstant.ITEMS_PER_PAGE_MOBILE;
		model.put("token", token);
		//token get userid
		Gson gson = new Gson();		
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		int uid = Integer.valueOf(tokenIn.getData()).intValue();
		// uid =92277;
		 //int uid =126631;
		//如果有purchase_id值
		//int onlyOne=0;
			    //获取所有PURCHASE_id
				int orderInfoListCount;
				List<OrderInfo> orderInfoList;
				if(purchase_id!=null)
				{
					orderInfoList = userService.getPurchaseListById(uid,purchase_id.intValue());
				}else{
					     orderInfoList = userService.getPurchaseList(uid,index,ITEMS_PER_PAGE);
					 }
			 	int []listPid= new int[orderInfoList.size()];
			 	
			 	for(int i=0;i<orderInfoList.size();i++)
			 	{
			 		listPid[i]=orderInfoList.get(i).getPurchaseId().intValue();
			 	}
		 		orderInfoListCount= userService.getPurchaseListCount(uid,index,ITEMS_PER_PAGE);
			 	//一次性得出所有ORDER
				if(listPid.length<1)
				{
					model.put("purchase", "");	        
					model.put("page",1);
					//page_count
					//获取数据库总行数数
					//总行数除以每页行数==页数  共页面,则显示page(1~x)之间
					model.put("page_count",1);	
					return model;
				}
				if(purchase_id!=null)
				{
					listPid= new int[1];
					listPid[0]=purchase_id.intValue();
					page=1;
				}	
				List<OrderInfo> orderInfoTemp = userService.getOrderInfoByUid(uid,listPid);
				//获取所有count
				int [] orderIdList= new int[orderInfoTemp.size()];
				int [] vendorIdList=new int[orderInfoTemp.size()];
				
				for(int i=0;i<orderInfoTemp.size();i++)
				{
					orderIdList[i]=orderInfoTemp.get(i).getOrder_id().intValue();
					vendorIdList[i]=orderInfoTemp.get(i).getVendorId().intValue();
				}
				List<Count> countTemp =userService.getSumOfitemsbyOrdersIDList(orderIdList);
				
				List<GoodsImage> goods=userService.getImagesbyOrdersIDList(orderIdList);
				
				List<OrderGoods> orderGoods=userService.getOrderGoodsByOrdersIDList(orderIdList);
				
				List<Vendors> vendors=userService.getVendorsByVendorIDList(vendorIdList);
				
		        for(int i=0;i<orderInfoList.size();i++)
		        {
		        	Map<String, Object> purchase = new HashMap<String, Object>();
					List<Object> orders = new ArrayList<Object>();
		        	if(orderInfoList.get(i) != null)
		        	{
		        		BigDecimal amount=BigDecimal.valueOf(0);
		        		BigDecimal points= BigDecimal.valueOf(0);
		        		List<OrderInfo> orderInfo = new ArrayList<OrderInfo>();
		        		for(int l=0;l<orderInfoTemp.size();l++)
		        		{
		        			if(orderInfoTemp.get(l)!=null)
		        			{
		        				if(orderInfoTemp.get(l).getPurchaseId()!=null)
		        				{
		        					int W =orderInfoList.get(i).getPurchaseId().intValue();
			        				int E =orderInfoTemp.get(l).getPurchaseId().intValue();
			        				//if(orderInfoList.get(i).getPurchaseId().intValue() == orderInfoTemp.get(l).getPurchaseId().intValue())
			        				if(W == E)
			        				{
			        					orderInfo.add(orderInfoTemp.get(l));
			        					orderInfoTemp.remove(l);
			        					//l-=1;
			        				}	
		        				}
		        			}
		        		}
		        		//List<OrderInfo> orderInfo = userService.getOrderInfo(uid,orderInfoList.get(i).getPurchaseId().intValue());
						for(int j=0;j<orderInfo.size();j++)
						{
							int orderId=orderInfo.get(j).getOrder_id().intValue();
							int count = 0;
						
							//count =userService.getSumOfitemsbyOrdersId(orderId);
							
							for(int k=0;k<countTemp.size();k++)
							{
								if(countTemp.get(k).getOrder_id()==orderId)
								{
									count =countTemp.get(k).getCount();
								}
							}
							
							//List<Goods> goods=userService.getImagesbyOrdersId(orderId);
							int total=0;
							for(int k=0;k<goods.size();k++)
							{
								if(orderId==goods.get(k).getOrder_id())
								{
									total+=1;
								}
								//point_get=point_get+goods.get(k).getIntegral().intValue()*goods.get(k).getGoodsNumber().intValue();
							}
							String[] images= new String[total];
							BigDecimal point_get=BigDecimal.valueOf(0);
							total=0;
							
							//List<OrderGoods> orderGoods=userService.getOrderGoodsByOrdersId(orderInfo.get(j).getOrder_id());
							for(int k=0;k<goods.size();k++)
							{
								if(orderId==goods.get(k).getOrder_id())
								{
									images[total++]=YamiConstant.IMAGE_URL+goods.get(k).getGoodsThumb();
								}
								//point_get=point_get+goods.get(k).getIntegral().intValue()*goods.get(k).getGoodsNumber().intValue();
							}
							for(int k=0;k<orderGoods.size();k++)
							{
								if(orderGoods.get(k)!=null)
								{
									if(orderGoods.get(k).getOrderId().intValue()==orderInfo.get(j).getOrder_id().intValue())
									{
										BigDecimal u= BigDecimal.valueOf(orderGoods.get(k).getGoodsNumber());
										BigDecimal v= orderGoods.get(k).getGiveIntegral();
										BigDecimal w=u.multiply(v);
										point_get=point_get.add(w);
									}
								}
							}
							
						
							
							//Vendors vendors=userService.getVendorsByOrderId(orderId);
							//Vendors vendors=userService.getVendorsByVendorId(orderInfo.get(j).getVendorId());
							
							Map<String, Object> order = new HashMap<String, Object>();
							//order.put("purchase_id",orderInfo.get(i).getPurchaseId());
							order.put("points_get",point_get.setScale(0, BigDecimal.ROUND_DOWN));
							points= points.add(point_get);	
							order.put("order_id", orderInfo.get(j).getOrder_id());
							order.put("order_sn", orderInfo.get(j).getOrderSn());
							//order.put("vendor",vendors);
							Map<String, Object> vendor = new HashMap<String, Object>();
							for(int k=0;k<vendors.size();k++)
							{
								if(vendors.get(k).getVendorId().intValue()==orderInfo.get(j).getVendorId().intValue())
								{
									vendor.put("vendor_id",vendors.get(k).getVendorId());
									vendor.put("vendor_name",vendors.get(k).getVendorName());
									vendor.put("vendor_ename",vendors.get(k).getVendorEname());
								}
							}
							order.put("vendor",vendor);
							items = new HashMap<String, Object>();
							items.put("count", count);
							items.put("images", images);
							order.put("items",items);
							order.put("amount", orderInfo.get(j).getOrderAmount());
							amount= amount.add(orderInfo.get(j).getOrderAmount()) ;
							Long timestamp = orderInfo.get(j).getAddTime().longValue()*1000;   
							String date = new java.text.SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date(timestamp)); 
							order.put("order_time", date);
							//status
							int x=orderInfo.get(j).getOrderStatus()*100;
							int y=orderInfo.get(j).getShippingStatus()*10;
							int z=orderInfo.get(j).getPayStatus();
                            int s=x+y+z;
                            int status=3;
                            if(s==102||s==132||s==152)
                            {
                            	status=1;
                            }
                            if(s==100||s==483)
                            {
                            	status=3;
                            }
                            if(s==512||s==522||s==484)
                            {
                            	status=2;
                            }
                            
                            order.put("status", status);	
                            //100状态不显示
                            orders.add(order);         

						}
						
						if(orderInfo.size()>0)
						{
							purchase.put("purchase_id",orderInfoList.get(i).getPurchaseId());
							purchase.put("orders",orders);
							purchase.put("amount", amount.setScale(2,BigDecimal.ROUND_UP));
							purchase.put("points", points.setScale(0,BigDecimal.ROUND_DOWN));
							
							Purchase.add(purchase);	  
						}   
		        	}
		        model.put("purchase", Purchase);	        
				model.put("page",page);
				//page_count
				//获取数据库总行数数
				//总行数除以每页行数==页数  共页面,则显示page(1~x)之间
				model.put("page_count",new Double(Math.ceil(new Double(orderInfoListCount)/new Double( ITEMS_PER_PAGE))).intValue());			
		     }
		return model;
	}
	
	public Map<String, Object> selectOrderDetails(String token, int order_id) {
		Gson gson = new Gson();		
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		int uid = Integer.valueOf(tokenIn.getData()).intValue();
		Map<String, Object> top = new HashMap<String, Object>();
		Map<String, Object> model = new HashMap<String, Object>();
		
		//get order-info by order id.
		OrderInfo orderInfo = userService.getOrderInfoByOrderId(uid,order_id);
		
		//BonusType bonusType= userService.getBonusTypeByBounsId(orderInfo.getBonusId());
		
		//System.out.println(orderInfo.getOrder_id());
		Vendors vendors=userService.getVendorsByVendorId(orderInfo.getVendorId());
		//科学计数法求COUNT
		List<Goods> goods=userService.getImagesbyOrdersId(order_id);
		//
		List<OrderGoods> orderGoods=userService.getOrderGoodsByOrdersId(order_id);
		Map<String, Object> vendor = new HashMap<String, Object>();
		Map<String, Object> shipping = new HashMap<String, Object>();
		//Map<String, Object> bonus = new HashMap<String, Object>();
		Map<String, Object> goodsTab = new HashMap<String, Object>();
		Map<String, Object> order_info = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> shippingInfo = new HashMap<String, Object>();
		Map<String, Object> orderDesc = new HashMap<String, Object>();
		//System.out.println(orderGoods.get(0).getGoodsSn());
		List<Object> items = new ArrayList<Object>();
		for(int i=0;i<orderGoods.size();i++)
		{
			if(orderGoods.get(i)!=null)
			{
				Map<String, Object> item = new HashMap<String, Object>();
				BigDecimal x=BigDecimal.valueOf(orderGoods.get(i).getGoodsPrice().doubleValue());
				BigDecimal y=BigDecimal.valueOf(orderGoods.get(i).getGoodsNumber());
				BigDecimal z=x.multiply(y).setScale(2, RoundingMode.HALF_UP);	
				item.put("subtotal", z);
				item.put("gid", orderGoods.get(i).getGoodsId());
				item.put("name", orderGoods.get(i).getGoodsName());
				item.put("ename", orderGoods.get(i).getGoodsEname());
				item.put("price", orderGoods.get(i).getGoodsPrice());
				item.put("number", orderGoods.get(i).getGoodsNumber());
				item.put("isGift", orderGoods.get(i).getIsGift());
				if(null==orderGoods.get(i).getIsOnSale()||null==orderGoods.get(i).getIsDelete()||null==orderGoods.get(i).getGoodsNumberOnscoke()){
					item.put("isOnSale", 0);
					item.put("isDelete", 1);
					item.put("isOos", 1);
				}else{
					item.put("isOnSale", orderGoods.get(i).getIsOnSale()?1:0);
					item.put("isDelete", orderGoods.get(i).getIsDelete()?1:0);
					item.put("isOos", orderGoods.get(i).getGoodsNumberOnscoke()==0?1:0);
					
				}
				item.put("currency", YamiConstant.CURRENCY);
				item.put("image","");
				for(int j=0;j<goods.size();j++)
				{
					if(goods.get(j)!=null)
					{
						if(orderGoods.get(i).getGoodsId().equals(goods.get(j).getGoodsId()))
						{
							item.put("image",YamiConstant.IMAGE_URL+goods.get(j).getGoodsThumb());
						}
					}
				}
				//count
				//BigDecimal x=orderGoods.get(i).getGoodsPrice();
				//BigDecimal y=BigDecimal.valueOf(orderGoods.get(i).getGoodsNumber().doubleValue());
				//BigDecimal z=x.multiply(y).setScale(2, RoundingMode.HALF_UP);
			    //item.put("count", z);
			    items.add(item);
			}
			
		}
		vendor.put("vendor_id",vendors.getVendorId());
		vendor.put("vendor_name",vendors.getVendorName());
		vendor.put("vendor_ename",vendors.getVendorEname());
//?		//vendor.put("vendor_subtotal",vendors.);
		
		shipping.put("shipping_id",orderInfo.getShippingId());
		shipping.put("shipping_name",orderInfo.getShippingName());
		shipping.put("shipping_fee",orderInfo.getShippingFee());
		
		//bonus.put("bonus_id",orderInfo.getBonusId());/////////////////////////////////////////////////
		//goodsTab.put("discount", orderInfo.getDiscount());
		
		goodsTab.put("currency", YamiConstant.CURRENCY);
		goodsTab.put("vendor", vendor);
		goodsTab.put("items", items);
		goodsTab.put("shipping",shipping);
		
		model.put("goods", goodsTab);
		////////////////////////////////////////////////////////////////
		order_info.put("subtotal", orderInfo.getGoodsAmount());
		order_info.put("discount", orderInfo.getBonus());
		order_info.put("shipping", orderInfo.getShippingFee());
		order_info.put("points", orderInfo.getIntegralMoney());
		order_info.put("tax", orderInfo.getTax());
		order_info.put("amount", orderInfo.getOrderAmount());
		order_info.put("currency",YamiConstant.CURRENCY );
		//加status
		int x=orderInfo.getOrderStatus()*100;
		int y=orderInfo.getShippingStatus()*10;
		int z=orderInfo.getPayStatus();
        int s=x+y+z;
        int status=3;
        String edesc;
        String desc;
        if(s==102||s==132||s==152)
        {
        	status=1;//发货中
        	order_info.put("desc", "");
        	order_info.put("edesc", "");
        }
        if(s==100||s==483)
        {
        	status=3;//已取消
        	order_info.put("desc", "退款预计7-10个工作日内会显示在您当时付款的帐户上");
        	order_info.put("edesc", "Refund will show in your account in 7-10 business days");
        }
        if(s==512||s==522||s==484)
        {
        	status=2;//已发货
        	order_info.put("desc", "");
        	order_info.put("edesc", "");      
        }
       
        order_info.put("status", status);
        
        order_info.put("pay_id", orderInfo.getPayId());
		
		model.put("orderInfo", order_info);
		/////////////////////////////////////////////////////////////
		profile.put("consignee",orderInfo.getConsigneeZd());
		profile.put("type",orderInfo.getCardType());
		profile.put("tail",orderInfo.getTail());
		                                                                                                                                                                                                                Map<String, Object> address = new HashMap<String, Object>();
		address.put("address1",orderInfo.getAddressZd());
		address.put("address2",orderInfo.getAddress2Zd());
		address.put("city",orderInfo.getCityZd());
		address.put("state",orderInfo.getProvinceZd());
		address.put("zipcode",orderInfo.getZipcodeZd());
		profile.put("address",address);
		profile.put("exp_year",orderInfo.getExpYear());
		profile.put("exp_month",orderInfo.getExpMonth());	
		
		if(orderInfo.getPayId() == YamiConstant.CREDIT_CARD)
		{
			model.put("profile", profile);
		}
		//////////////////////////////////////////////
		shippingInfo.put("consignee",orderInfo.getConsignee());
		shippingInfo.put("address1",orderInfo.getAddress());
		shippingInfo.put("address2",orderInfo.getAddress2());
		shippingInfo.put("city",orderInfo.getCity());
		shippingInfo.put("state",orderInfo.getProvince());
		shippingInfo.put("zipcode",orderInfo.getZipcode());
		shippingInfo.put("phone",orderInfo.getTel());
		model.put("shippingInfo", shippingInfo);
		/////////////////////////////////////////////////////////////
		

      
		
		
		
		Long timestamp = orderInfo.getAddTime().longValue()*1000;  
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
	    sdf.setTimeZone(TimeZone.getTimeZone("PST"));
	    String month = sdf.format(new java.util.Date(timestamp));  // 2009-11-19 14:12:23
		
		//int month1=new java.util.Date(timestamp).getMonth();
		//System.out.println(">>"+month1);
		String date = new java.text.SimpleDateFormat(" dd , yyyy").format(new java.util.Date(timestamp)); 
		
		sdf = new SimpleDateFormat(" dd , yyyy");
	    sdf.setTimeZone(TimeZone.getTimeZone("PST"));
	    date = sdf.format(new java.util.Date(timestamp));  // 2009-11-19 14:12:23
		
		
		
		
		if(month.equals("01"))
		{
			orderDesc.put("order_time","January"+date);
		}else if(month.equals("02"))
		{
			orderDesc.put("order_time","February"+date);
		}else if(month.equals("03"))
		{
			orderDesc.put("order_time","March"+date);
		}else if(month.equals("04"))
		{
			orderDesc.put("order_time","April"+date);
		}else if(month.equals("05"))
		{
			orderDesc.put("order_time","May"+date);
		}else if(month.equals("06"))
		{
			orderDesc.put("order_time","June"+date);
		}else if(month.equals("07"))
		{
			orderDesc.put("order_time","July"+date);
		}else if(month.equals("08"))
		{
			orderDesc.put("order_time","August"+date);
		}else if(month.equals("09"))
		{
			orderDesc.put("order_time","September"+date);
		}else if(month.equals("10"))
		{
			orderDesc.put("order_time","October"+date);
		}else if(month.equals("11"))
		{
			orderDesc.put("order_time","November"+date);
		}else if(month.equals("12"))
		{
			orderDesc.put("order_time","December"+date);
		}else
		{
			orderDesc.put("order_time","Error Time");
		}
		
		orderDesc.put("order_id",orderInfo.getOrder_id());
		orderDesc.put("order_sn",orderInfo.getOrderSn());
		orderDesc.put("order_amount",orderInfo.getOrderAmount());
		BigDecimal total=BigDecimal.valueOf(0);
		
		//BigDecimal x=orderGoods.get(i).getGoodsPrice();
		//BigDecimal y=BigDecimal.valueOf(orderGoods.get(i).getGoodsNumber().doubleValue());
		//BigDecimal z=x.multiply(y).setScale(2, RoundingMode.HALF_UP);
	    //item.put("count", z);
		
		for(int i=0;i<orderGoods.size();i++)
		{
			if(orderGoods.get(i)!=null)
			{
				BigDecimal u= BigDecimal.valueOf(orderGoods.get(i).getGoodsNumber());
				BigDecimal v= orderGoods.get(i).getGiveIntegral();
				BigDecimal w=u.multiply(v);
				total=total.add(w);
			}
		}
		orderDesc.put("give_integral",total.longValue());
		orderDesc.put("track_no",orderInfo.getInvoiceNo());
		model.put("orderDesc", orderDesc);	
		
		top.put("orderDetail", model);
		top.put("token", token);
		return top;
	}
	/*
	订单详情查询V2
	@param String token
	@param String year
	@param int start
	@param int length
	@return Map<String,Object> Purchase相关信息
	*/
	public Map<String, Object> selectOrderDetailsV2(String token, Integer year,int order_id) {
		Gson gson = new Gson();		
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		int uid = Integer.valueOf(tokenIn.getData()).intValue();
		if(null!=year&&DateUtil.getYear().equals(year.toString())){
			year=null;
		}
		OrderInfo orderInfo = userService.selectOrderInfoByOrderIdV2(uid, year, order_id);
		
		Map<String, Object> top = new HashMap<String, Object>();
		Map<String, Object> model = new HashMap<String, Object>();
		
		Vendors vendors=new Vendors();
		vendors.setVendorId(orderInfo.getVendorId());
		vendors.setVendorName(orderInfo.getVendorName());
		vendors.setVendorEname(orderInfo.getVendorEname());
		//科学计数法求COUNT
		List<Goods> good=userService.getImagesbyOrdersId(order_id);
		//
		List<OrderGoods> orderGoods=orderInfo.getLstOrderGoods();
		Map<String, Object> vendor = new HashMap<String, Object>();
		Map<String, Object> shipping = new HashMap<String, Object>();
		//Map<String, Object> bonus = new HashMap<String, Object>();
		Map<String, Object> goodsTab = new HashMap<String, Object>();
		Map<String, Object> order_info = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> shippingInfo = new HashMap<String, Object>();
		Map<String, Object> orderDesc = new HashMap<String, Object>();
		//System.out.println(orderGoods.get(0).getGoodsSn());
		List<Object> items = new ArrayList<Object>();
		for(int i=0;i<orderGoods.size();i++)
		{
			if(orderGoods.get(i)!=null)
			{
				Map<String, Object> item = new HashMap<String, Object>();
				BigDecimal x=BigDecimal.valueOf(orderGoods.get(i).getGoodsPrice().doubleValue());
				BigDecimal y=BigDecimal.valueOf(orderGoods.get(i).getGoodsNumber());
				BigDecimal z=x.multiply(y).setScale(2, RoundingMode.HALF_UP);	
				item.put("subtotal", z);
				item.put("gid", orderGoods.get(i).getGoodsId());
				item.put("name", orderGoods.get(i).getGoodsName());
				item.put("ename", orderGoods.get(i).getGoodsEname());
				item.put("price", orderGoods.get(i).getGoodsPrice());
				item.put("number", orderGoods.get(i).getGoodsNumber());
				item.put("isGift", orderGoods.get(i).getIsGift());
				if(null==orderGoods.get(i).getIsOnSale()||null==orderGoods.get(i).getIsDelete()||null==orderGoods.get(i).getGoodsNumberOnscoke()){
					item.put("isOnSale", 0);
					item.put("isDelete", 1);
					item.put("isOos", 1);
				}else{
					item.put("isOnSale", orderGoods.get(i).getIsOnSale()?1:0);
					item.put("isDelete", orderGoods.get(i).getIsDelete()?1:0);
					item.put("isOos", orderGoods.get(i).getGoodsNumberOnscoke()==0?1:0);
					
				}
				item.put("currency", YamiConstant.CURRENCY);
				item.put("image","");
				item.put("image",YamiConstant.IMAGE_URL+orderGoods.get(i).getGoodsThumb());
			    items.add(item);
			}
			
		}
		vendor.put("vendor_id",vendors.getVendorId());
		vendor.put("vendor_name",vendors.getVendorName());
		vendor.put("vendor_ename",vendors.getVendorEname());
//?		//vendor.put("vendor_subtotal",vendors.);
		
		shipping.put("shipping_id",orderInfo.getShippingId());
		shipping.put("shipping_name",orderInfo.getShippingName());
		shipping.put("shipping_fee",orderInfo.getShippingFee());
		
		//bonus.put("bonus_id",orderInfo.getBonusId());/////////////////////////////////////////////////
		//goodsTab.put("discount", orderInfo.getDiscount());
		
		goodsTab.put("currency", YamiConstant.CURRENCY);
		goodsTab.put("vendor", vendor);
		goodsTab.put("items", items);
		goodsTab.put("shipping",shipping);
		
		model.put("goods", goodsTab);
		////////////////////////////////////////////////////////////////
		order_info.put("subtotal", orderInfo.getGoodsAmount());
		order_info.put("discount", orderInfo.getBonus());
		order_info.put("shipping", orderInfo.getShippingFee());
		order_info.put("points", orderInfo.getIntegralMoney());
		order_info.put("tax", orderInfo.getTax());
		order_info.put("amount", orderInfo.getOrderAmount());
		order_info.put("currency",YamiConstant.CURRENCY );
		//加status
		int x=orderInfo.getOrderStatus()*100;
		int y=orderInfo.getShippingStatus()*10;
		int z=orderInfo.getPayStatus();
        int s=x+y+z;
        int status=3;
        String edesc;
        String desc;
        if(s==102||s==132||s==152)
        {
        	status=1;//发货中
        	order_info.put("desc", "");
        	order_info.put("edesc", "");
        }
        if(s==100||s==483)
        {
        	status=3;//已取消
        	order_info.put("desc", "退款预计7-10个工作日内会显示在您当时付款的帐户上");
        	order_info.put("edesc", "Refund will show in your account in 7-10 business days");
        }
        if(s==512||s==522||s==484)
        {
        	status=2;//已发货
        	order_info.put("desc", "");
        	order_info.put("edesc", "");      
        }
       
        order_info.put("status", status);
        
        order_info.put("pay_id", orderInfo.getPayId());
		
		model.put("orderInfo", order_info);
		/////////////////////////////////////////////////////////////
		profile.put("consignee",orderInfo.getConsigneeZd());
		profile.put("type",orderInfo.getCardType());
		profile.put("tail",orderInfo.getTail());
		                                                                                                                                                                                                                Map<String, Object> address = new HashMap<String, Object>();
		address.put("address1",orderInfo.getAddressZd());
		address.put("address2",orderInfo.getAddress2Zd());
		address.put("city",orderInfo.getCityZd());
		address.put("state",orderInfo.getProvinceZd());
		address.put("zipcode",orderInfo.getZipcodeZd());
		profile.put("address",address);
		profile.put("exp_year",orderInfo.getExpYear());
		profile.put("exp_month",orderInfo.getExpMonth());	
		
		if(orderInfo.getPayId() == YamiConstant.CREDIT_CARD)
		{
			model.put("profile", profile);
		}
		//////////////////////////////////////////////
		shippingInfo.put("consignee",orderInfo.getConsignee());
		shippingInfo.put("address1",orderInfo.getAddress());
		shippingInfo.put("address2",orderInfo.getAddress2());
		shippingInfo.put("city",orderInfo.getCity());
		shippingInfo.put("state",orderInfo.getProvince());
		shippingInfo.put("zipcode",orderInfo.getZipcode());
		shippingInfo.put("phone",orderInfo.getTel());
		model.put("shippingInfo", shippingInfo);
		/////////////////////////////////////////////////////////////
		

      
		
		
		
		Long timestamp = orderInfo.getAddTime().longValue()*1000;  
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
	    sdf.setTimeZone(TimeZone.getTimeZone("PST"));
	    String month = sdf.format(new java.util.Date(timestamp));  // 2009-11-19 14:12:23
		
		//int month1=new java.util.Date(timestamp).getMonth();
		//System.out.println(">>"+month1);
		String date = new java.text.SimpleDateFormat(" dd , yyyy").format(new java.util.Date(timestamp)); 
		
		sdf = new SimpleDateFormat(" dd , yyyy");
	    sdf.setTimeZone(TimeZone.getTimeZone("PST"));
	    date = sdf.format(new java.util.Date(timestamp));  // 2009-11-19 14:12:23
		
		
		
		
		if(month.equals("01"))
		{
			orderDesc.put("order_time","January"+date);
		}else if(month.equals("02"))
		{
			orderDesc.put("order_time","February"+date);
		}else if(month.equals("03"))
		{
			orderDesc.put("order_time","March"+date);
		}else if(month.equals("04"))
		{
			orderDesc.put("order_time","April"+date);
		}else if(month.equals("05"))
		{
			orderDesc.put("order_time","May"+date);
		}else if(month.equals("06"))
		{
			orderDesc.put("order_time","June"+date);
		}else if(month.equals("07"))
		{
			orderDesc.put("order_time","July"+date);
		}else if(month.equals("08"))
		{
			orderDesc.put("order_time","August"+date);
		}else if(month.equals("09"))
		{
			orderDesc.put("order_time","September"+date);
		}else if(month.equals("10"))
		{
			orderDesc.put("order_time","October"+date);
		}else if(month.equals("11"))
		{
			orderDesc.put("order_time","November"+date);
		}else if(month.equals("12"))
		{
			orderDesc.put("order_time","December"+date);
		}else
		{
			orderDesc.put("order_time","Error Time");
		}
		
		orderDesc.put("order_id",orderInfo.getOrder_id());
		orderDesc.put("order_sn",orderInfo.getOrderSn());
		orderDesc.put("order_amount",orderInfo.getOrderAmount());
		BigDecimal total=BigDecimal.valueOf(0);
		
		//BigDecimal x=orderGoods.get(i).getGoodsPrice();
		//BigDecimal y=BigDecimal.valueOf(orderGoods.get(i).getGoodsNumber().doubleValue());
		//BigDecimal z=x.multiply(y).setScale(2, RoundingMode.HALF_UP);
	    //item.put("count", z);
		
		for(int i=0;i<orderGoods.size();i++)
		{
			if(orderGoods.get(i)!=null)
			{
				BigDecimal u= BigDecimal.valueOf(orderGoods.get(i).getGoodsNumber());
				BigDecimal v= orderGoods.get(i).getGiveIntegral();
				BigDecimal w=u.multiply(v);
				total=total.add(w);
			}
		}
		orderDesc.put("give_integral",total.longValue());
		orderDesc.put("track_no",orderInfo.getInvoiceNo());
		model.put("orderDesc", orderDesc);	
		
		top.put("orderDetail", model);
		top.put("token", token);
		return top;
	}
    public Map<String,Object> getAccountInfo(String token){
    	Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
    	Map<String,Object> result  = new HashMap<String,Object>();
    	Map<String,Object> account  = new HashMap<String,Object>();
    	Users users = userService.selectUserInfoByUid(uid);
    	account.put("uid", uid);
    	//account.put("username", users.getUserName());
    	account.put("email", users.getEmail());
    	account.put("avatar", YamiConstant.IMAGE_URL+users.getAvatar());
    	account.put("points", users.getPayPoints());
    	//account.put("truename", users.getTruename());
    	account.put("birthday_year", DateUtil.dateFormater(users.getBirthday(),"yyyy"));
    	account.put("birthday_month", DateUtil.dateFormater(users.getBirthday(),"MM"));
    	account.put("birthday_date", DateUtil.dateFormater(users.getBirthday(),"dd"));
    	//account.put("remind_email", users.getQuestion());
    	account.put("gender", users.getSex());
    	account.put("phone", users.getMobilePhone());
    	result.put("token", token);
    	result.put("account", account);
		return result;
    }
    
    
    public Map<String,Object> getPointInfo(String token,int type,int start,int length){
    	Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
    	Map<String,Object> result  = new HashMap<String,Object>();
    	Map<String,Object> history  = new HashMap<String,Object>();
    	List<Object> lstHistory = new ArrayList<Object> ();
    	Users users = userService.selectUserInfoByUid(uid);
    	List<Integral> lstIntegral= new ArrayList<Integral>();
    	int count = 0;
    	if(type==0){
    		lstIntegral= userService.selectPointHistoryPay(uid,start,length);
    		count = userService.selectPointHistoryPayCount(uid);
    	}else if(type==1){
    		lstIntegral= userService.selectPointHistoryGet(uid,start,length);
    		count = userService.selectPointHistoryGetCount(uid);
    	}else if(type==2){
    		lstIntegral= userService.selectPointHistory(uid,start,length);
    		count = userService.selectPointHistoryCount(uid);
    	}
    	
    	
    	
    	
    	for(Integral integral:lstIntegral){
    		 history  = new HashMap<String,Object>();
    		 history.put("order_sn", integral.getOrderSn());
    		 history.put("order_amount", integral.getFormatedTotalFee());
    		 history.put("date", DateUtil.formateUTC(integral.getDate()));
    		 history.put("points", integral.getIntegral());
    		 if(integral.getType()==YamiConstant.POINTS_TYPE_NO_1||integral.getType()==YamiConstant.POINTS_TYPE_NO_6){
    		      history.put("type", 0);
    		 }else{
    			 history.put("type", 1); 
    		 }
    		 if(integral.getType()==YamiConstant.POINTS_TYPE_NO_0){
    			 history.put("desc", YamiConstant.POINTS_TYPE_DESC_0);
    			 history.put("edesc", YamiConstant.POINTS_TYPE_EDESC_0);
    		 }else if(integral.getType()==YamiConstant.POINTS_TYPE_NO_1){
    			 history.put("desc", YamiConstant.POINTS_TYPE_DESC_1);
    			 history.put("edesc", YamiConstant.POINTS_TYPE_EDESC_1);
    		 }else if(integral.getType()==YamiConstant.POINTS_TYPE_NO_2){
    			 history.put("desc", YamiConstant.POINTS_TYPE_DESC_2);
    			 history.put("edesc", YamiConstant.POINTS_TYPE_EDESC_2);
    		 }else if(integral.getType()==YamiConstant.POINTS_TYPE_NO_3){
    			 history.put("desc", YamiConstant.POINTS_TYPE_DESC_3);
    			 history.put("edesc", YamiConstant.POINTS_TYPE_EDESC_3);
    		 }else if(integral.getType()==YamiConstant.POINTS_TYPE_NO_4){
    			 history.put("desc", YamiConstant.POINTS_TYPE_DESC_4);
    			 history.put("edesc", YamiConstant.POINTS_TYPE_EDESC_4);
    		 }else if(integral.getType()==YamiConstant.POINTS_TYPE_NO_5){
    			 history.put("desc", YamiConstant.POINTS_TYPE_DESC_5);
    			 history.put("edesc", YamiConstant.POINTS_TYPE_EDESC_5);
    		 }else if(integral.getType()==YamiConstant.POINTS_TYPE_NO_6){
    			 history.put("desc", YamiConstant.POINTS_TYPE_DESC_6);
    			 history.put("edesc", YamiConstant.POINTS_TYPE_EDESC_6);
    		 }
    		 lstHistory.add(history);
    	}
    	result.put("token", token);
    	result.put("points", users.getPayPoints());
    	result.put("history", lstHistory);
    	result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		return result;
    }
    
	/*
	获取购买信息（读）（登）
	@param String token
	@param int purchase_id
	@return Map<String,Object> Purchase相关信息
	*/
	public Map<String, Object> getPurchaseInfo(String token,Integer purchase_id) {
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> purchase = new HashMap<String, Object>();
		List<OrderInfo> lstOrders = compositeQueryService.selectPurchaseInfoByUid(uid, purchase_id);
		List<Map<String, Object>> lstOrdersResult = new ArrayList<Map<String, Object>>();
		Map<String, Object> mapOrder = new HashMap<String, Object>();
		Map<String, Object> mapVendor = new HashMap<String, Object>();
		BigDecimal subtotal = new BigDecimal(0.0);
		BigDecimal shipping_fee = new BigDecimal(0.0);
		BigDecimal tax = new BigDecimal(0.0);
		BigDecimal discount = new BigDecimal(0.0);
		BigDecimal point = new BigDecimal(0.0);
		BigDecimal order_amount = new BigDecimal(0.0);
		BigDecimal point_get_purchase = new BigDecimal(0.0);
		String purchase_time="";
		Map<String, Object> userAddress = new HashMap<String, Object>();
		for(OrderInfo orderInfo:lstOrders){
			mapOrder = new HashMap<String, Object>();
			mapOrder.put("order_id", orderInfo.getOrder_id());
			mapOrder.put("order_sn", orderInfo.getOrderSn());
			mapOrder.put("bonus_sn", orderInfo.getBonusSn());
			if(orderInfo.getOrderStatus().intValue()==1&&orderInfo.getShippingStatus().intValue()==0&&orderInfo.getPayStatus().intValue()==2){
				mapOrder.put("status", 1);
			}
			mapOrder.put("order_time", DateUtil.formateUTC(orderInfo.getAddTime()));
			purchase_time = DateUtil.formateUTC(orderInfo.getAddTime());
			
			userAddress = new HashMap<String, Object>();
			userAddress.put("address", orderInfo.getAddress());
			userAddress.put("address2", orderInfo.getAddress2());
			userAddress.put("city", orderInfo.getCity());
			userAddress.put("province", orderInfo.getProvince());
			userAddress.put("country", orderInfo.getCountry());
			userAddress.put("zipcode", orderInfo.getZipcode());
			userAddress.put("tel", orderInfo.getTel());
			
			
			mapVendor = new HashMap<String, Object>();
			mapVendor.put("vendor_id", orderInfo.getVendorId());
			mapVendor.put("vendor_name", orderInfo.getVendorName());
			mapVendor.put("vendor_ename", orderInfo.getVendorEname());
			mapOrder.put("Vendor", mapVendor);
			List<OrderGoods> lstOrderGoods = compositeQueryService.selectOrderGoodsByOrderId(orderInfo.getOrder_id());
			List<Map<String, Object>> lstItemResult = new ArrayList<Map<String, Object>>();
			Map<String, Object> mapItems = new HashMap<String, Object>();
			int goodsCount = 0;
			BigDecimal point_get = new BigDecimal(0.0);
			for(OrderGoods orderGoods:lstOrderGoods){
				mapItems = new HashMap<String, Object>();
				mapItems.put("goods_id", orderGoods.getGoodsId());
				mapItems.put("goods_name", orderGoods.getGoodsName());
				mapItems.put("goods_ename", orderGoods.getGoodsEname());
				mapItems.put("goods_number", orderGoods.getGoodsNumber());
				goodsCount = goodsCount+orderGoods.getGoodsNumber();
				mapItems.put("goods_thumb", YamiConstant.IMAGE_URL+orderGoods.getGoodsThumb());
				mapItems.put("price", orderGoods.getGoodsPrice());
				mapItems.put("cat_id", orderGoods.getCatId());
				mapItems.put("cat_name", orderGoods.getCatName());
				mapItems.put("cat_ename", orderGoods.getCatEName());
				
				BigDecimal giveIntegral = orderGoods.getGiveIntegral();
				BigDecimal goodsNumber = new BigDecimal(orderGoods.getGoodsNumber());
				
				
				
				point_get = point_get.add(giveIntegral.multiply(goodsNumber));
				point_get_purchase =  point_get_purchase.add(giveIntegral.multiply(goodsNumber));
				lstItemResult.add(mapItems);
			}
			mapOrder.put("point_get", point_get);
			mapOrder.put("goodsCount", goodsCount);
			mapOrder.put("Items", lstItemResult);
			mapOrder.put("subtotal", orderInfo.getGoodsAmount());
			subtotal = subtotal.add(orderInfo.getGoodsAmount());
			mapOrder.put("shipping_fee", orderInfo.getShippingFee());
			shipping_fee = shipping_fee.add(orderInfo.getShippingFee());
			mapOrder.put("tax", orderInfo.getTax());
			tax = tax.add(orderInfo.getTax());
			mapOrder.put("discount", orderInfo.getBonus());
			discount = discount.add(orderInfo.getBonus());
			mapOrder.put("point", orderInfo.getIntegralMoney());
			point = point.add(orderInfo.getIntegralMoney());
			mapOrder.put("order_amount", orderInfo.getOrderAmount());
			order_amount = order_amount.add(orderInfo.getOrderAmount());
			lstOrdersResult.add(mapOrder);	
		}
		
		
		
		
		purchase.put("purchase_id", purchase_id);
		purchase.put("subtotal", subtotal);
		purchase.put("shipping_fee", shipping_fee);
		purchase.put("tax", tax);
		purchase.put("discount", discount);
		purchase.put("point", point);
		purchase.put("amount", order_amount);
		purchase.put("point_get", point_get_purchase.intValue());
		purchase.put("orders", lstOrdersResult);
		purchase.put("time", purchase_time);
		purchase.put("userAddress", userAddress);
		result.put("token", token);
		result.put("purchase", purchase);
		return result;
	} 
	/*
	订单历史查询V2
	@param String token
	@param String year
	@param int start
	@param int length
	@return Map<String,Object> Purchase相关信息
	*/
	public Map<String, Object> getOrdersV2(String token,Integer year,Integer start,Integer length)throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		//1.1日期处理
		Long startDate = null;
		Long endDate = null;
		if(null==year||"".equals(year.toString())){
			endDate =  DateUtil.getNowLong();
			startDate = DateUtil.getDateLong(DateUtil.getNextMonth(new Date(), -6));
		}else if(DateUtil.getYear().equals(year.toString())){
			endDate =  null;
			startDate = null;
			year=null;
		}
		List<PurchaseInfo> lstPurchaseInfo = orderInfoService.selectOrders(uid, year, startDate, endDate, start, length);
		int count = orderInfoService.selectOrdersCount(uid, year, startDate, endDate);
		List<Map<String, Object>> lstPurchaseResult = new ArrayList<Map<String, Object>>();
		//1.2订单列表信息处理
		for(PurchaseInfo purchaseInfo:lstPurchaseInfo){
			Map<String, Object> mapPurchase = new HashMap<String, Object>();
			List<OrderInfo> lstOrderInfo = purchaseInfo.getLstOrderInfo();
			BigDecimal purchase_amount = new BigDecimal(0.0);
			int add_time=0;
			List<Map<String, Object>> lstOrderResult = new ArrayList<Map<String, Object>>();
			Map<String, Object> mapOrder = new HashMap<String, Object>();
			Map<String, Object> mapVendor = new HashMap<String, Object>();
			for(OrderInfo orderInfo:lstOrderInfo){
				mapOrder = new HashMap<String, Object>();
				//供货商信息
				mapVendor = new HashMap<String, Object>();
				mapVendor.put("vendor_id", orderInfo.getVendorId());
				mapVendor.put("vendor_name", orderInfo.getVendorName());
				mapVendor.put("vendor_ename", orderInfo.getVendorEname());
				mapOrder.put("Vendor", mapVendor);
				purchase_amount = purchase_amount.add(orderInfo.getOrderAmount());
				add_time= orderInfo.getAddTime();
				mapOrder.put("order_amount", orderInfo.getOrderAmount());
				mapOrder.put("order_sn", orderInfo.getOrderSn());
				mapOrder.put("order_id", orderInfo.getOrder_id());
				mapOrder.put("track_no", orderInfo.getInvoiceNo());
				List<OrderGoods> lstOrderGoods = orderInfo.getLstOrderGoods();
				List<Map<String, Object>> lstItemResult = new ArrayList<Map<String, Object>>();
				Map<String, Object> mapItems = new HashMap<String, Object>();
				int goods_number_count = 0;
				for(OrderGoods orderGoods:lstOrderGoods){
					mapItems = new HashMap<String, Object>();
					mapItems.put("goods_id", orderGoods.getGoodsId());
					mapItems.put("goods_name", orderGoods.getGoodsName());
					mapItems.put("goods_ename", orderGoods.getGoodsEname());
					mapItems.put("goods_number", orderGoods.getGoodsNumber());
					goods_number_count = goods_number_count+orderGoods.getGoodsNumber();
					mapItems.put("goods_thumb", YamiConstant.IMAGE_URL+orderGoods.getGoodsThumb());
					mapItems.put("is_gift", orderGoods.getIsGift());
					mapItems.put("price", orderGoods.getGoodsPrice());
					if(orderGoods.getIsOnSale()||!orderGoods.getIsDelete()){
						mapItems.put("is_on_slae", 1);	
					}else{
						mapItems.put("is_on_slae", 0);	
					}
					lstItemResult.add(mapItems);
				}
				mapOrder.put("items", lstItemResult);
				mapOrder.put("count", goods_number_count);
				int order_status=orderInfo.getOrderStatus()*100;
				int sgupping_status=orderInfo.getShippingStatus()*10;
				int pay_status=orderInfo.getPayStatus();
                int statusnum=order_status+sgupping_status+pay_status;
                int status=3;
                //发货中
                if(statusnum==102||statusnum==132||statusnum==152)
                {
                	status=1;
                }
                //已发货
                if(statusnum==512||statusnum==522||statusnum==484)
                {
                	status=2;
                }
                //已取消
                if(statusnum==483)
                {
                	status=3;
                }
                mapOrder.put("status", status);	
				lstOrderResult.add(mapOrder);
			}
			mapPurchase.put("orders", lstOrderResult);
			mapPurchase.put("purchase_amount", purchase_amount);
			mapPurchase.put("time", add_time);
			lstPurchaseResult.add(mapPurchase);
		}
		result.put("token", token);
		result.put("purchase", lstPurchaseResult);
		result.put("page_count", new Double(Math.ceil(new Double(count)/new Double(length))).intValue());
		return result;
	}
	
	
    public Map<String,Object> getFeedbackMessages(String token){
    	Gson gson = new Gson();  
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
    	Map<String,Object> result  = new HashMap<String,Object>();
    	List<Feedback> lstFeedback = userService.selectFeedback(uid);
    	List<Map<String, Object>> lstMessage = new ArrayList<Map<String, Object>>();
		Map<String, Object> mapMessage = new HashMap<String, Object>();
		List<String> lstImage = new ArrayList<String>();
		
    	for(Feedback feedback:lstFeedback){
    		mapMessage = new HashMap<String, Object>();
    		mapMessage.put("user_name", feedback.getUserName());
    		mapMessage.put("msg_time",  DateUtil.formateUTC2Time(feedback.getMsgTime()));
    		mapMessage.put("msg_content",  feedback.getMsgContent());
    		mapMessage.put("is_reply",  0);
    		String[] arrayImage;
    		if(null!=feedback.getMessageImg()){
    		arrayImage = feedback.getMessageImg().split(",");
    		lstImage = new ArrayList<String>();
	    		for(int i=0;i<arrayImage.length;i++){
	    			lstImage.add(YamiConstant.IMAGE_URL+arrayImage[i]);
	    		}
    		}
    		mapMessage.put("msg_imgs",  lstImage);
    		lstMessage.add(mapMessage);
    		for(FeedbackRe feedbackRe:feedback.getLstFeedbackRe()){
    			mapMessage = new HashMap<String, Object>();
        		mapMessage.put("user_name", feedbackRe.getUserName());
        		mapMessage.put("msg_time",  DateUtil.formateUTC2Time(feedbackRe.getMsgTime()));
        		mapMessage.put("msg_content",  feedbackRe.getMsgContent());
        		mapMessage.put("is_reply",  1);
        		if(null!=feedback.getMessageImg()){
	        		arrayImage = feedbackRe.getMessageImg().split(",");
	        		lstImage = new ArrayList<String>();
	        		for(int i=0;i<arrayImage.length;i++){
	        			lstImage.add(YamiConstant.IMAGE_URL+arrayImage[i]);
	        		}
        		}
        		mapMessage.put("msg_imgs",  lstImage);
        		lstMessage.add(mapMessage);
    		}
    	}
    	result.put("token", token);
    	result.put("messages", lstMessage);
		return result;
    }
    
	/*
	个人缺货商品邮件提醒信息查询
	@param String token
	@return Map<String,Object> 
	*/
	public Map<String, Object> getGoodsOosRemins(String token){
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result = new HashMap<String,Object>();
		List<Goods> lstGoods = userService.selectGoodsOosRemindInfoByUserId(uid);
		List<Map<String,Object>> lstItems = new ArrayList<Map<String,Object>>();
		Map<String, Object> item = new HashMap<String, Object>();
		for(Goods goods:lstGoods){
			item = new HashMap<String, Object>();
			item.put("goods_id", goods.getGoodsId());
			item.put("goods_name", goods.getGoodsName());
			item.put("goods_ename", goods.getGoodsEname());
			item.put("shop_price", goods.getShopPrice());
			item.put("is_promote", goods.getIsPromote()?1:0);
			item.put("promote_price", goods.getPromotePrice());
			item.put("is_oos", goods.getGoodsNumber().intValue()>0?0:1);
			item.put("image", YamiConstant.IMAGE_URL+goods.getGoodsImg());
			lstItems.add(item);
		}
		result.put("items", lstItems);
		User user = userService.selectUsersByID(uid);
		result.put("email", user.getQuestion());
		result.put("token", token);
		
		return result;
	}
	
	/*
	个人缺货商品邮件提醒信息添加
	@param String token
	@return Map<String,Object> 
	*/
	public Map<String, Object> addGoodsOosRemind(String token,int gid){
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result  = new HashMap<String,Object>();
		int countNum = userService.checkRemindFlag(uid, gid);
		if(countNum==0){
			result  = transactionDelegate.transactionAddRemind(token,gid);
		}else{
			User user = userService.selectUsersByID(uid);
			result.put("token", token);
			result.put("status", 1);
			result.put("email", user.getQuestion());
			
		}
		return result;
	}
	
	/*
	个人缺货商品邮件提醒信息删除
	@param String token
	@return Map<String,Object> 
	*/
	public Map<String, Object> deleteGoodsOosRemind(String token,int gid){
		Map<String,Object> result   = transactionDelegate.transactionRemoveRemind(token,gid);
		
		return result;
	}
	
	
	
	
	/*
	用户积分抽奖，获得积分
	@param String token
	@return Map<String,Object> 
	*/
	public Map<String, Object> userLottery(String token)throws Exception{
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result  = new HashMap<String,Object>();
		//当前日期
		String date = DateUtil.getShortNow2();
		//获取redis奖池配置信息
		LotterySetRedis lotterySetRedis = null;
		if(lotterySetRedisService.check(tokenIn, date)){
			lotterySetRedis = lotterySetRedisService.select(tokenIn, date);
		}else{
			PointLotterySet pointLotterySet = userService.getPointLotterySet(date);
			if(null!=pointLotterySet){
				lotterySetRedis = new LotterySetRedis();
				lotterySetRedis.setRecId(pointLotterySet.getRecId());
				lotterySetRedis.setTotalPoint(pointLotterySet.getTotalPoint());
				lotterySetRedis.setDate(pointLotterySet.getDate());
				lotterySetRedis.setSpend(pointLotterySet.getSpend());
				lotterySetRedis.setUserLotteryTimes(pointLotterySet.getUserLotteryTimes());
				lotterySetRedis.setUserWinningTiimes(pointLotterySet.getUserWinningTiimes());
				lotterySetRedis.setUserLotteryTimesLimit(pointLotterySet.getUserLotteryTimesLimit());
				lotterySetRedis.setUserWinningTiimesLimit(pointLotterySet.getUserWinningTiimesLimit());
				lotterySetRedis.setWinningRate(pointLotterySet.getWinningRate());
				lotterySetRedisService.insert(tokenIn, lotterySetRedis);
			}
		}
		//获取各抽奖项爆率设置信息
		List<LotteryConfigRedis> lstLotteryConfigRedis =  new ArrayList<LotteryConfigRedis>();
		if(lotteryConfigRedisService.checkAll(tokenIn)){
			lstLotteryConfigRedis =  lotteryConfigRedisService.selectAll(tokenIn);
		}else{
			List<PointLotteryConfig> lstPointLotteryConfig = userService.getPointLotteryConfig(date);
			for(PointLotteryConfig pointLotteryConfig:lstPointLotteryConfig){
				LotteryConfigRedis lotteryConfigRedis = new LotteryConfigRedis();
				lotteryConfigRedis.setRecId(pointLotteryConfig.getRecId());
				lotteryConfigRedis.setPointNum(pointLotteryConfig.getPointNum());
				lotteryConfigRedis.setDate(pointLotteryConfig.getDate());
				lotteryConfigRedis.setWinningNum(pointLotteryConfig.getWinningNum());
				lotteryConfigRedis.setWinningNumLimit(pointLotteryConfig.getWinningNumLimit());
				lotteryConfigRedisService.insert(tokenIn, lotteryConfigRedis);
				lstLotteryConfigRedis.add(lotteryConfigRedis);
			}
		}
		
		
		
		//1、验证奖池金额是否为0
		if(lotterySetRedis==null){
			 throw new YamiException(YamiConstant.ERRORCODE_ER1803,ErrorCodeEnum.ER1803.getMsg()); 
		}
		if(lotterySetRedis.getTotalPoint().intValue()<=0){
			 throw new YamiException(YamiConstant.ERRORCODE_ER1801,ErrorCodeEnum.ER1801.getMsg()); 
		}
		//2、验证用户抽奖次数是否满足
		LotteryUserRedis  lotteryUserRedis =null;
		if(lotteryUserRedisService.check(tokenIn)){
			lotteryUserRedis = lotteryUserRedisService.select(tokenIn);
		}else{
			lotteryUserRedis = new LotteryUserRedis();
			lotteryUserRedis.setUser_id(uid);
			lotteryUserRedis.setLottery_number(0);
			lotteryUserRedis.setWinning_num(0);
			lotteryUserRedisService.insert(tokenIn, lotteryUserRedis);
		}
		if(lotteryUserRedis.getLottery_number().intValue()>=lotterySetRedis.getUserLotteryTimesLimit().intValue()){
			throw new YamiException(YamiConstant.ERRORCODE_ER1802,ErrorCodeEnum.ER1802.getMsg()); 
		}
		
		//获取用户抽中奖项信息
		LotteryConfigRedis userLotteryInfo=null;
		//3、用户抽奖
		Random random = new Random();
    	int randomValue = random.nextInt(lotterySetRedis.getUserLotteryTimesLimit());
			//3.1根据系统设置每日用户中奖次数，判断用户是否有再次中间机会
		    if(lotteryUserRedis.getWinning_num().intValue()<lotterySetRedis.getUserWinningTiimesLimit().intValue() && randomValue <= lotterySetRedis.getUserWinningTiimesLimit()){
		    	//3.1.1用户是否有抽奖机会
		    	//系统设定中奖概率
		    	BigDecimal winningRate = new BigDecimal(lotterySetRedis.getWinningRate()).multiply(new BigDecimal(0.01)).setScale(3,BigDecimal.ROUND_HALF_UP);
		    	//系统当前中奖比率
		    	BigDecimal currentWinningRate;
		    	if(lotterySetRedis.getUserLotteryTimes()==0){
		    		currentWinningRate = new BigDecimal(0);
		    	}else{
		    		
		    		//currentWinningRate =  new BigDecimal(lotterySetRedis.getUserWinningTiimes()).divide(new BigDecimal(lotterySetRedis.getUserLotteryTimes()),5,BigDecimal.ROUND_HALF_UP);
		    		BigDecimal currentWinPerNum = new BigDecimal(lotterySetRedis.getUserWinningTiimes());
		    		BigDecimal currentLotPerNum = new BigDecimal(lotterySetRedis.getUserLotteryTimes()).divide(new BigDecimal(lotterySetRedis.getUserLotteryTimesLimit()),1,BigDecimal.ROUND_HALF_UP);
		    		currentWinningRate =  currentWinPerNum.divide(currentLotPerNum,5,BigDecimal.ROUND_HALF_UP);
		    	}
		    	
		    	if(currentWinningRate.compareTo(winningRate)<0){
		    		userLotteryInfo = LotteryComputing.countLotteryPoint(lstLotteryConfigRedis);
		    	}
		    }

			
			//更新数据库各信息
			transactionDelegate.transactionUpdateLotteryDetails(token,userLotteryInfo,lotterySetRedis);
			
		    //中奖后各redis信息更新
		    if(null!=userLotteryInfo){
		    	//更新lottery_set信息
		    	lotterySetRedis.setUserLotteryTimes(lotterySetRedis.getUserLotteryTimes().intValue()+1);
		    	lotterySetRedis.setUserWinningTiimes(lotterySetRedis.getUserWinningTiimes()+1);
		    	lotterySetRedis.setTotalPoint(lotterySetRedis.getTotalPoint()-userLotteryInfo.getPointNum());
		    	lotterySetRedisService.update(tokenIn, lotterySetRedis);
		    	//更新lottery_Config信息
		    	userLotteryInfo.setWinningNum(userLotteryInfo.getWinningNum()+1);
		    	lotteryConfigRedisService.update(tokenIn, userLotteryInfo);
		    	//更新lottery_user_log
		    	lotteryUserRedis.setLottery_number(lotteryUserRedis.getLottery_number()+1);
		    	lotteryUserRedis.setWinning_num(lotteryUserRedis.getWinning_num()+1);
		    	lotteryUserRedisService.update(tokenIn, lotteryUserRedis);
		    	
		    	result.put("token", token);
				result.put("points", userLotteryInfo.getPointNum());
		    	
		    }
		    //未中奖各redis信息更新
		    else{
		    	//更新lottery_set信息
		    	lotterySetRedis.setUserLotteryTimes(lotterySetRedis.getUserLotteryTimes().intValue()+1);
		    	lotterySetRedisService.update(tokenIn, lotterySetRedis);
		    	//更新lottery_user_log
		    	lotteryUserRedis.setLottery_number(lotteryUserRedis.getLottery_number()+1);
		    	lotteryUserRedisService.update(tokenIn, lotteryUserRedis);	
		    	
		    	result.put("token", token);
				result.put("points", 0);
		    }
		    
		    
		    
		    
		    
		    
		    
		return result;
	}
	
	
	/*
	用户积分抽奖剩余次数
	@param String token
	@return Map<String,Object> 
	*/
	public Map<String, Object> userLotteryTimes(String token)throws Exception{
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Map<String,Object> result  = new HashMap<String,Object>();
		//当前日期
		String date = DateUtil.getShortNow2();
		//获取redis奖池配置信息
		LotterySetRedis lotterySetRedis = null;
		if(lotterySetRedisService.check(tokenIn, date)){
			lotterySetRedis = lotterySetRedisService.select(tokenIn, date);
		}else{
			PointLotterySet pointLotterySet = userService.getPointLotterySet(date);
			if(null!=pointLotterySet){
				lotterySetRedis = new LotterySetRedis();
				lotterySetRedis.setRecId(pointLotterySet.getRecId());
				lotterySetRedis.setTotalPoint(pointLotterySet.getTotalPoint());
				lotterySetRedis.setDate(pointLotterySet.getDate());
				lotterySetRedis.setSpend(pointLotterySet.getSpend());
				lotterySetRedis.setUserLotteryTimes(pointLotterySet.getUserLotteryTimes());
				lotterySetRedis.setUserWinningTiimes(pointLotterySet.getUserWinningTiimes());
				lotterySetRedis.setUserLotteryTimesLimit(pointLotterySet.getUserLotteryTimesLimit());
				lotterySetRedis.setUserWinningTiimesLimit(pointLotterySet.getUserWinningTiimesLimit());
				lotterySetRedis.setWinningRate(pointLotterySet.getWinningRate());
				lotterySetRedisService.insert(tokenIn, lotterySetRedis);
			}
		}
		//获取各抽奖项爆率设置信息
		List<LotteryConfigRedis> lstLotteryConfigRedis =  new ArrayList<LotteryConfigRedis>();
		if(lotteryConfigRedisService.checkAll(tokenIn)){
			lstLotteryConfigRedis =  lotteryConfigRedisService.selectAll(tokenIn);
		}else{
			List<PointLotteryConfig> lstPointLotteryConfig = userService.getPointLotteryConfig(date);
			for(PointLotteryConfig pointLotteryConfig:lstPointLotteryConfig){
				LotteryConfigRedis lotteryConfigRedis = new LotteryConfigRedis();
				lotteryConfigRedis.setRecId(pointLotteryConfig.getRecId());
				lotteryConfigRedis.setPointNum(pointLotteryConfig.getPointNum());
				lotteryConfigRedis.setDate(pointLotteryConfig.getDate());
				lotteryConfigRedis.setWinningNum(pointLotteryConfig.getWinningNum());
				lotteryConfigRedis.setWinningNumLimit(pointLotteryConfig.getWinningNumLimit());
				lotteryConfigRedisService.insert(tokenIn, lotteryConfigRedis);
				lstLotteryConfigRedis.add(lotteryConfigRedis);
			}
		}
		
		
		
		//1、验证奖池金额是否为0
		if(lotterySetRedis==null){
			 throw new YamiException(YamiConstant.ERRORCODE_ER1803,ErrorCodeEnum.ER1803.getMsg()); 
		}
		//2、验证用户抽奖次数是否满足
		LotteryUserRedis  lotteryUserRedis =null;
		if(lotteryUserRedisService.check(tokenIn)){
			lotteryUserRedis = lotteryUserRedisService.select(tokenIn);
		}else{
			lotteryUserRedis = new LotteryUserRedis();
			lotteryUserRedis.setUser_id(uid);
			lotteryUserRedis.setLottery_number(0);
			lotteryUserRedis.setWinning_num(0);
			lotteryUserRedisService.insert(tokenIn, lotteryUserRedis);
		}

		
		int surplusTimes = lotterySetRedis.getUserLotteryTimesLimit().intValue() - lotteryUserRedis.getLottery_number().intValue();
		    
		    
		result.put("token", token);  
		result.put("surplusTimes", surplusTimes);   
		result.put("total_points", lotterySetRedis.getTotalPoint());       
		    
		    
		return result;
	}
	
	
	
	/*
	获取邀请码
	@param String token
	@return Map<String,Object> 
	*/
	public Map<String, Object> getInviteCode(String token){
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Users users  = userService.selectUserInfoByUid(uid);
		Map<String,Object> result  = new HashMap<String,Object>();
		String inviteCode=null;
		if(null!=users.getInvitationCode()){
			inviteCode = users.getInvitationCode();
		}else{
			//验证邀请码未重复
			for(int j=0;j>-1;j++){
		    	//生成邀请码
				inviteCode = StringUtil.createInvitationCode();
	 		    //判断新邀请码是否存在
				int count = userService.selectUsersByInviteCode(inviteCode);
		    	 if(count==0){
		    		 break;
		    	 }
		     }
			
			//更新用户邀请码
			transactionDelegate.transactionUpdateInviteCodeByUid(uid,inviteCode);
		}
		
		result.put("toekn", token);
		result.put("invite_code", inviteCode);
		return result;
	}
	
	
	
	
	/*
	获取邀请历史信息
	@param String token
	@return Map<String,Object> 
	*/
	public Map<String, Object> getInviteHistory(String token){
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		List<InviteHistory> lstInviteHistory  = userService.selectInviteHistoryByUserid(uid);
		Map<String,Object> result  = new HashMap<String,Object>();
		List<Map<String,Object>> lstMapInviteHistory  = new ArrayList<Map<String,Object>>();
		Map<String,Object> mapInviteHistory = new HashMap<String,Object>();
		Map<String,Object> mapInviteStat = new HashMap<String,Object>();
		//推荐注册人数
		 int signUpNum = lstInviteHistory.size();
		 //推荐注册后成功下单人数
		 int puchaseNum = 0;
		 //推荐注册成功下单    还未发放积分数
		 int pendingPoint = 0;
		//推荐注册成功下单    已发放积分数
		 int confirmedPoint = 0;
		
		for(InviteHistory inviteHistory:lstInviteHistory){
			mapInviteHistory = new HashMap<String,Object>();
			mapInviteHistory.put("email", inviteHistory.getEmail());
			
			
			//inviteStatus: 1:已注册  2、已下单
			//pointStatus  0:积分pending 1 :积分confirmed
			if(null!=inviteHistory.getFirstOrderTime()){
				puchaseNum++;
				if(inviteHistory.getFlag()==0){
					confirmedPoint = confirmedPoint + 500;
					mapInviteHistory.put("point_status", 1);
				}
				else if(inviteHistory.getFlag()==1) {
					pendingPoint = pendingPoint + 500;
					mapInviteHistory.put("point_status", 0);
				}
				mapInviteHistory.put("invite_status", 2);
				mapInviteHistory.put("point", 500);
			}else{
				mapInviteHistory.put("invite_status", 1);
				mapInviteHistory.put("point", 0);
			}
			mapInviteHistory.put("reg_time", DateUtil.formateUTC2LATime(inviteHistory.getRegTime()));
			if(null!=inviteHistory.getFirstOrderTime()){
			mapInviteHistory.put("first_order_time", DateUtil.formateUTC2LATime(inviteHistory.getFirstOrderTime()));
			}else{
				mapInviteHistory.put("first_order_time", inviteHistory.getFirstOrderTime());	
			}


			lstMapInviteHistory.add(mapInviteHistory);

		}
		mapInviteStat.put("signUp_num", signUpNum);
		mapInviteStat.put("purchase_num", puchaseNum);
		mapInviteStat.put("pending_point", pendingPoint);
		mapInviteStat.put("confirmed_point", confirmedPoint);
		
		
		result.put("toekn", token);
		result.put("invite_history", lstMapInviteHistory);
		result.put("invite_stat", mapInviteStat);
		return result;
	}
	
	/*
	发送邮件接口
	@param String token
	@param String FromMail
	@param String toMail
	@param String mailType    1、注册邀请邮件   2、单品分享邮件
	@param String title
	@param String content
	@return Map<String,Object> 
	*/
	public Map<String, Object> sendMail(String token, String toMail, String mailType,  String title,String content,String value){
		Map<String,Object> result  = new HashMap<String,Object>();
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		String email  = new String();
		
		//获取邀请人信息及邀请码
		Users users = userService.selectUserInfoByUid(uid);
		String inviteUrl= "https://www.yamibuy.com/cn/login.php"+"?invite_code="+users.getInvitationCode();
		Context data = new Context();
		switch (mailType){
			//1、单品分享邮件
			case "1":
				Goods goods = goodsService.selectByPrimaryKey(Integer.parseInt(value));
				String goodsUrl= "http://www.yamibuy.com/cn/goods.php?id="+value+"&invite_code="+users.getInvitationCode();
				
				
				
				
				data = new Context();
				data.setVariable("user_email", users.getEmail());
				//data.setVariable("user_name", users.getUserName());
				data.setVariable("goods_url", goodsUrl);
				data.setVariable("goods_name", goods.getGoodsName());
				data.setVariable("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());
				data.setVariable("goods_price", "$"+StringUtil.formatPrice(goods.getShopPrice()));
				data.setVariable("register_url", inviteUrl);
				email = templateEngine.process("InviteFriendsWithGoods", data);
				try{
		    		Sendmail sendmail = new Sendmail();
		        	sendmail.setContent(email);

		        	sendmail.setName(toMail);
		        	sendmail.setEmail(toMail);
		        	sendmail.setCount((short)YamiConstant.INT_ZERO);
		        	sendmail.setSendTime(Integer.parseInt(DateUtil.getNowLong().toString()));
		        	sendmail.setSubject("Greetings from Yamibuy.com");
		        	transactionDelegate.transactionAddSendMail(sendmail);
		    		}catch (Exception e){
						logger.fatal("Failed to insert sendmail of share items");
						logger.fatal(e.toString());
		    		}
				
				
				break;
			//2、注册邀请邮件
			case "2":
				
				
				data = new Context();
				data.setVariable("user_email", users.getEmail());
				//data.setVariable("user_name", users.getUserName());
				data.setVariable("register_url", inviteUrl);
				data.setVariable("content", content);
				email = templateEngine.process("InviteFriends", data);
				try{
		    		Sendmail sendmail = new Sendmail();
		        	sendmail.setContent(email);

		        	sendmail.setName(toMail);
		        	sendmail.setEmail(toMail);
		        	sendmail.setCount((short)YamiConstant.INT_ZERO);
		        	sendmail.setSendTime(Integer.parseInt(DateUtil.getNowLong().toString()));
		        	sendmail.setSubject("Greetings from Yamibuy.com");
		        	transactionDelegate.transactionAddSendMail(sendmail);
		    		}catch (Exception e){
						logger.fatal("Failed to insert sendmail of Friend Invite letter");
						logger.fatal(e.toString());
		    		}
				
				
				
				break;
		
		}
		
		result.put("token", token);
		result.put("status", 1);
		
		
		return result;
	}
	
	
	/*
	用户购物信息历史
	@param String token
	@param String FromMail
	@param String toMail
	@param String mailType    1、注册邀请邮件   2、单品分享邮件
	@param String title
	@param String content
	@return Map<String,Object> 
	*/
	public Map<String, Object> userShoppingHistory(String token){
		Map<String,Object> result  = new HashMap<String,Object>();
		Gson gson = new Gson(); 
		Token tokenIn = gson.fromJson( StringUtil.decode(token), Token.class);
		int uid = Integer.parseInt(tokenIn.getData());
		Users users = userService.selectUserInfoByUid(uid);
		Map<String,Object> reg_info  = new HashMap<String,Object>();
		String reg_date = DateUtil.formateUTC2Date2(users.getRegTime());
		reg_info.put("reg_date", reg_date.substring(0, 4)+"年"+reg_date.substring(4, 6)+"月"+reg_date.substring(6, 8)+"日");
		reg_info.put("reg_ranking", uid);
		
		//第一次下单时间、下单总数信息处理
		List<UserInfoOrder> lstUserInfoOrder = userService.selectUserInfoOrderByUid(uid);
		Map<String,Object> shopping_info  = new HashMap<String,Object>();
		if(lstUserInfoOrder.size()==0){
			
		}else{
			UserInfoOrder userInfoOrder = lstUserInfoOrder.get(0);
			shopping_info  = new HashMap<String,Object>();
			String first_order_date = userInfoOrder.getOrderSn().substring(0, 8);
			shopping_info.put("first_order_date", first_order_date.substring(0, 4)+"年"+first_order_date.substring(4, 6)+"月"+first_order_date.substring(6, 8)+"日");
			
			shopping_info.put("total_order_number", lstUserInfoOrder.size());
		}
		

		//买过最多商品、最喜爱分类信息处理
		UserInfoOrderMaxGoods userInfoOrderMaxGoods = userService.selectUserInfoOrderMaxGoodsByUid(uid);
		UserInfoOrderMaxCat userInfoOrderMaxCat = userService.selectUserInfoOrderMaxCatByUid(uid);
		Map<String,Object> shop_goods_info  = new HashMap<String,Object>();
		if(null!=userInfoOrderMaxGoods&&null!=userInfoOrderMaxCat){
				Map<String,Object> max_goods  = new HashMap<String,Object>();
				max_goods.put("goods_id", userInfoOrderMaxGoods.getGoodsId());
				max_goods.put("goods_name", userInfoOrderMaxGoods.getGoodsName());
				max_goods.put("goods_ename", userInfoOrderMaxGoods.getGoodsEname());
				max_goods.put("goods_img", YamiConstant.IMAGE_URL+userInfoOrderMaxGoods.getGoodsImg());
				shop_goods_info.put("max_goods", max_goods);
				Map<String,Object> max_cat  = new HashMap<String,Object>();
				max_cat.put("cat_id", userInfoOrderMaxCat.getCatId());
				max_cat.put("cat_name", userInfoOrderMaxCat.getCatName());
				max_cat.put("cat_ename", userInfoOrderMaxCat.getCatEname());
				shop_goods_info.put("max_cat", max_cat);
		}
		
		//推荐商品信息处理
		String goods_ids = "986,4688,6393,2836,532,8347,4461,5794,588,3587,984,3501,4566,11282,425,9288,11300,6180,2524,636,11070,6786,2461,8939,2916";
		String[] arrayGoodsIds = goods_ids.split(",");
		Map<String,Object> recommend_item  = new HashMap<String,Object>();
		 int max=arrayGoodsIds.length-1;
	     int min=0;
	     Random random = new Random();
	     int s = random.nextInt(max)%(max-min+1) + min;
		
	     Goods goods = goodsService.selectByPrimaryKey(Integer.parseInt(arrayGoodsIds[s]));
		
	     recommend_item.put("goods_id", goods.getGoodsId());
	     recommend_item.put("goods_name", goods.getGoodsName());
	     recommend_item.put("goods_ename", goods.getGoodsEname());
	     recommend_item.put("goods_img", YamiConstant.IMAGE_URL+goods.getGoodsImg());

		
		result.put("token", token);
		result.put("reg_info", reg_info);
		result.put("shopping_info", shopping_info);
		result.put("shop_goods_info", shop_goods_info);
		result.put("recommend_item", recommend_item);
		
		return result;
	}
	
	
	/*
	用户购物信息历史
	@param String token
	@param String FromMail
	@param String toMail
	@param String mailType    1、注册邀请邮件   2、单品分享邮件
	@param String title
	@param String content
	@return Map<String,Object> 
	*/
	public Map<String, Object> inviteSummary(String token)throws Exception{
		Map<String,Object> result  = new HashMap<String,Object>();
		int startDate = 1460012400;
		int endDate = Integer.parseInt(DateUtil.getNowLong().toString());
		
		
		List<InviteSummary> lstInviteSummary = compositeQueryService.selectInviteSummary(startDate, endDate);
		
		for(InviteSummary inviteSummary:lstInviteSummary){
			
		}
		
		
		
		
		
		
		
		
		return result;
	}
	
}
