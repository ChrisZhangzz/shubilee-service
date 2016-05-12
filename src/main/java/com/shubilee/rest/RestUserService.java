package com.shubilee.rest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shubilee.common.NeedLogin;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.delegate.CartServiceDelegateV2;
import com.shubilee.delegate.GoodsServiceDelegate;
import com.shubilee.delegate.OrderServiceDelegate;
import com.shubilee.delegate.SecurityServiceDelegate;
import com.shubilee.delegate.TransactionDelegate;
import com.shubilee.delegate.UserServiceDelegate;
import com.shubilee.delegate.UspsServiceDelegate;
import com.shubilee.entity.Token;
import com.shubilee.entity.Users;
import com.shubilee.service.UserService;

@Service
@Path("/users")
public class RestUserService {
	@Autowired
	private UserServiceDelegate userServiceDelegate;
	@Autowired
	private GoodsServiceDelegate goodsServiceDelegate;
	@Autowired
	private SecurityServiceDelegate securityServiceDelegate;
	
	@Autowired
	private TransactionDelegate transactionDelegate;
	
	@Autowired
	private OrderServiceDelegate orderServiceDelegate;
	@Autowired
	private CartServiceDelegateV2 cartRedisServicedelegate;
	@Autowired
	private UspsServiceDelegate uspsServiceDelegate;
	@Autowired 
	private RedisTemplate<String,String> redisTemplate;
	
	@GET
	@NeedLogin
	@Path("/getOrdersV2")
	@Produces("application/json;charset=utf-8")
	public Response getOrdersV2(@QueryParam("token") String token,@QueryParam("page") int page,@QueryParam("year") Integer year,@HeaderParam("User-Agent") String agent)throws Exception {

		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
		Map<String,Object> result = userServiceDelegate.getOrdersV2(token,year,pageSet.get("start"), pageSet.get("length"));
		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/getOrderDetailsV2")
	@Produces("application/json;charset=utf-8")
	public Response getOrderDetailsV2(@QueryParam("token") String token,@QueryParam("year") Integer year,@QueryParam("order_id") int order_id) {

		Map<String, Object> result = userServiceDelegate.selectOrderDetailsV2(token,year,order_id);

		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/getOrderDetails")
	@Produces("application/json;charset=utf-8")
	public Response getOrderDetails(@QueryParam("token") String token,@QueryParam("order_id") int order_id) {

		Map<String, Object> result = userServiceDelegate.selectOrderDetails(token,order_id);

		return Response.status(Status.OK).entity(result).build();

	}
	

	@GET
	@NeedLogin
	@Path("/getOrders")
	@Produces("application/json;charset=utf-8")
//	public Response getOrders(@QueryParam("token") String token,@QueryParam("purchase_id") int purchase_id) {
	public Response getOrders(@QueryParam("token") String token,@QueryParam("page") int page,@QueryParam("purchase_id") Integer purchase_id,@HeaderParam("User-Agent") String agent) {


		//Map<String, Object> result = userServiceDelegate.selectOrders(token,purchase_id);
		Map<String, Object> result = userServiceDelegate.selectOrders(token,page,agent,purchase_id);
		return Response.status(Status.OK).entity(result).build();

	}
	
	
	@GET
	@NeedLogin
	@Path("/getPurchaseInfo")
	@Produces("application/json;charset=utf-8")
	public Response getPurchaseInfo(@QueryParam("token") String token,@QueryParam("purchase_id") Integer purchase_id) {


		Map<String, Object> result = userServiceDelegate.getPurchaseInfo(token,purchase_id);
		return Response.status(Status.OK).entity(result).build();

	}	
	
	@GET
	@Path("/getUserById")
	@Produces("application/json;charset=utf-8")
	public Response getUserById(@QueryParam("uid") int uid) {

		Users result = userServiceDelegate.selectUsersByID(uid);

		return Response.status(Status.OK).entity(result).build();

	}

	
	@GET
	@NeedLogin
	@Path("/getAccountInfo")
	@Produces("application/json;charset=utf-8")
	public Response getAccountInfo(@QueryParam("token") String token) {

		Map<String,Object> result = userServiceDelegate.getAccountInfo(token);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/editUserName")
	@Produces("application/json;charset=utf-8")
	public Response editUserName(@QueryParam("token") String token,@QueryParam("username") String username)throws Exception {

		Map<String,Object> result = transactionDelegate.transactionEditUserName(token,username);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/editUserGender")
	@Produces("application/json;charset=utf-8")
	public Response editUserGender(@QueryParam("token") String token,@QueryParam("gender") int gender)throws Exception {

		Map<String,Object> result = transactionDelegate.transactionEditSex(token,gender);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/editPhone")
	@Produces("application/json;charset=utf-8")
	public Response editPhone(@QueryParam("token") String token,@QueryParam("mobile_phone") String mobile_phone)throws Exception {

		Map<String,Object> result = transactionDelegate.transactionEditPhone(token,mobile_phone);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/editTruename")
	@Produces("application/json;charset=utf-8")
	public Response editTruename(@QueryParam("token") String token,@QueryParam("truename") String truename)throws Exception {

		Map<String,Object> result = transactionDelegate.transactionEditTruename(token,truename);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/editEmail")
	@Produces("application/json;charset=utf-8")
	public Response editEmail(@QueryParam("token") String token,@QueryParam("email") String email)throws Exception {

		Map<String,Object> result = transactionDelegate.transactionEditEmail(token,email);

		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/editAccountInfo")
	@Produces("application/json;charset=utf-8")
	public Response editAccountInfo(@QueryParam("token") String token,@QueryParam("username") String username,@QueryParam("gender") int gender,@QueryParam("birthday") String birthday,@QueryParam("phone") String phone)throws Exception {


		Map<String,Object> result = transactionDelegate.transactionUsersInfo(token, username, gender, birthday, phone);

		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/getPointInfo")
	@Produces("application/json;charset=utf-8")
	public Response getPointInfo(@QueryParam("token") String token,@QueryParam("type") int type,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent)throws Exception {
		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
		Map<String,Object> result = userServiceDelegate.getPointInfo(token,type, pageSet.get("start"), pageSet.get("length"));
		result.put("page", page);
		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@Path("/getUserNameById")
	@Produces("application/json;charset=utf-8")
	public Response getUserNameById(@QueryParam("token") String token,@QueryParam("uid") int uid) throws Exception {
		
		String result = userServiceDelegate.getUserName(uid);
		//KafkaProducer producer = new KafkaProducer();
		Map<String,String> message = new HashMap<String,String>();
		message.put("info", "user name:"+result);
		//producer.sendold("mytopic", message);
		return Response.status(Status.OK).entity(result).build();

	}

	@GET
	@Path("/login")
	@Produces("application/json;charset=utf-8")
	public Response loginUser(@QueryParam("token") String token,@QueryParam("email") String email,@QueryParam("pwd") String pwd) throws Exception {
		
		Map<String, Object> result = userServiceDelegate.loginUser(token, email, pwd);
		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@Path("/register_sendEmail")
	@Produces("application/json;charset=utf-8")
	public Response registerUser_sendEmail(@QueryParam("token") String token, @QueryParam("email") String email,
			@QueryParam("pwd") String pwd, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("zipcode") String zipcode, @QueryParam("sex") String sex, @QueryParam("birthday") String birthday) throws Exception {
		
		Map<String, Object> result = userServiceDelegate.registerUser_sendEmail(token, email, pwd, firstName, lastName, zipcode,sex,birthday);
		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@Path("/register_verifyEmail")
	@Produces("application/json;charset=utf-8")
	public Response registerUser_verifyEmail(@QueryParam("token") String token, 
			@QueryParam("pwd") String pwd) throws Exception {
		
		Map<String, Object> result = userServiceDelegate.registerUser_verifyEmail(token,  pwd);
		return Response.status(Status.OK).entity(result).build();

	}
	

	@GET
	@NeedLogin
	@Path("/logout")
	@Produces("application/json;charset=utf-8")
	public Response logoutUser(@QueryParam("token") String token) throws Exception {

		Map<String, Object> result = userServiceDelegate.logoutUser(token);
		
		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@Path("/forgetPassword")
	@Produces("application/json;charset=utf-8")
	public Response forgetPassword(@QueryParam("token") String token, @QueryParam("email") String email) throws Exception {

		Map<String, Object> result = userServiceDelegate.forgetPassword(token,email);
		
		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@Path("/resetPassword")
	@Produces("application/json;charset=utf-8")
	public Response resetPassword(@QueryParam("token") String token, @QueryParam("password") String password, @QueryParam("code") String code) throws Exception {

		Map<String, Object> result = userServiceDelegate.resetPassword(token,password,code);
		
		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/getAddressBook")
	@Produces("application/json;charset=utf-8")
	public Response getAddressBook(@QueryParam("token") String token)throws Exception {

		Map<String,Object> result = userServiceDelegate.getAddressBook(token);

		return Response.status(Status.OK).entity(result).build();

	}	
	
	@GET
	@NeedLogin
	@Path("/newAddress")
	@Produces("application/json;charset=utf-8")
	public Response newAddress(@QueryParam("token") String token,
			@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname,
			@QueryParam("address1") String address1, @QueryParam("address2") String address2,
			@QueryParam("city") String city, @QueryParam("state") String state,
			@QueryParam("zipcode") String zipcode, @QueryParam("phone") String phone, @QueryParam("email") String email, @QueryParam("verified") String verified)
			throws Exception {

		Map<String, Object> result = userServiceDelegate.newAddress(token, firstname, lastname,
				address1, address2, city, state, zipcode, phone, email, verified);

		return Response.status(Status.OK).entity(result).build();

	}

	@GET
	@NeedLogin
	@Path("/editAddress")
	@Produces("application/json;charset=utf-8")
	public Response editAddress(@QueryParam("token") String token,
			@QueryParam("address_id") Integer address_id,
			@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname,
			@QueryParam("address1") String address1, @QueryParam("address2") String address2,
			@QueryParam("city") String city, @QueryParam("state") String state,
			@QueryParam("zipcode") String zipcode, @QueryParam("phone") String phone,@QueryParam("profile_id") String profile_id, @QueryParam("email") String email)
			throws Exception {

		Map<String, Object> result = userServiceDelegate.editAddress(token, address_id, firstname,
				lastname, address1, address2, city, state, zipcode, phone,profile_id, email);

		return Response.status(Status.OK).entity(result).build();

	}

	@GET
	@NeedLogin
	@Path("/deleteAddress")
	@Produces("application/json;charset=utf-8")
	public Response deleteAddress(@QueryParam("token") String token,
			@QueryParam("address_id") Integer address_id)
			throws Exception {

		Map<String, Object> result = userServiceDelegate.deleteAddress(token, address_id);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/getPayments")
	@Produces("application/json;charset=utf-8")
	public Response getPayments(@QueryParam("token") String token)throws Exception {

		Map<String,Object> result = userServiceDelegate.getPayments(token);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/newPayment")
	@Produces("application/json;charset=utf-8")
	public Response newPayment(@QueryParam("token") String token,
			@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname,
			@QueryParam("type") String type, @QueryParam("account") String account,
			@QueryParam("exp_year") String exp_year, @QueryParam("exp_month") String exp_month,
			@QueryParam("address_id") String address_id)
			throws Exception {

		Map<String, Object> result = userServiceDelegate.newPayment(token, firstname, lastname,
				type, account,  exp_year, exp_month, address_id);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/editPayment")
	@Produces("application/json;charset=utf-8")
	public Response editPayment(@QueryParam("token") String token,
			@QueryParam("profile_id") String profile_id,
			@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname,
			@QueryParam("exp_year") String exp_year, @QueryParam("exp_month") String exp_month,
			@QueryParam("address_id") Integer address_id)
			throws Exception {

		Map<String, Object> result = userServiceDelegate.editPayment(token, profile_id, firstname,
				lastname, exp_year, exp_month, address_id);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/editPaymentAddress")
	@Produces("application/json;charset=utf-8")
	public Response editPaymentAddress(@QueryParam("token") String token,
			@QueryParam("profile_id") String profile_id,
			@QueryParam("address_id") Integer address_id)
			throws Exception {

		Map<String, Object> result = userServiceDelegate.editPaymentAddress(token, profile_id, address_id);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/deletePayment")
	@Produces("application/json;charset=utf-8")
	public Response deletePayment(@QueryParam("token") String token, @QueryParam("profile_id") String profile_id) throws Exception {

		Map<String, Object> result = userServiceDelegate.deletePayment(token,profile_id);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@Path("/getPayment")
	@Produces("application/json;charset=utf-8")
	public Response getPayment(@QueryParam("token") String token)throws Exception {

		Map<String,Object> result = userServiceDelegate.getPayment();

		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/choosePayment")
	@Produces("application/json;charset=utf-8")
	public Response choosePayment(@QueryParam("token") String token,@QueryParam("profile_id") String profile_id)throws Exception{

		//Map<String,Object> result = transactionDelegate.transactionChoosePayment(token,profile_id);
		Map<String,Object> result = cartRedisServicedelegate.choosePayment(token,profile_id);
		return Response.status(200).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/chooseAddress")
	@Produces("application/json;charset=utf-8")
	public Response chooseAddress(@QueryParam("token") String token,@QueryParam("address_id") int address_id)throws Exception{

		//Map<String,Object> result = transactionDelegate.transactionChooseAddress(token,address_id);
		Map<String,Object> result =  cartRedisServicedelegate.chooseAddress(token,address_id);
		return Response.status(200).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/getUserFavorites")
	@Produces("application/json;charset=utf-8")
	public Response getUserFavorites(@QueryParam("token") String token,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent)throws Exception {
		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
		Map<String,Object> result = goodsServiceDelegate.getUserFavorites(token,  pageSet.get("start"), pageSet.get("length"));
		result.put("page", page);
		return Response.status(Status.OK).entity(result).build();
	}
	@GET
	@NeedLogin
	@Path("/addToFavorites")
	@Produces("application/json;charset=utf-8")
	public Response addToFavorites(@QueryParam("token") String token,@QueryParam("gid") int gid)throws Exception {
		Map<String,Object> result = transactionDelegate.transactionAddToFavorites(token, gid);
		return Response.status(Status.OK).entity(result).build();
	}
	@GET
	@NeedLogin
	@Path("/removeFromFavorites")
	@Produces("application/json;charset=utf-8")
	public Response removeFromFavorites(@QueryParam("token") String token,@QueryParam("gid") int gid)throws Exception {
		Map<String,Object> result = transactionDelegate.transactionRemoveFromFavorites(token, gid);
		return Response.status(Status.OK).entity(result).build();
	}
	


	
	@GET
	@NeedLogin
	@Path("/getOrderTracking")
	@Produces("application/json;charset=utf-8")
	public Response getOrderTracking(@QueryParam("token") String token,@QueryParam("order_id") int order_id) throws Exception {

		Map<String, Object> result = orderServiceDelegate.getOrderTracking(token,order_id);

		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@Path("/getPersonalizedItems")
	@Produces("application/json;charset=utf-8")
	public Response getPersonalizedItems(@QueryParam("token") String token,@QueryParam("gid") Integer gid,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent) {
		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
		Map<String,Object>  result = goodsServiceDelegate.getPersonalizedItems(token, gid, pageSet.get("start"), pageSet.get("length"));
		result.put("page", page);
	    return Response.status(Status.OK).entity(result).build();
	}
	@GET
	@Path("/addFeedbackMessage")
	@Produces("application/json;charset=utf-8")
	public Response addFeedbackMessage(@QueryParam("token") String token,@QueryParam("msgTitle") String msgTitle,@QueryParam("msgContent") String msgContent,@QueryParam("msgEmail") String msgEmail,@QueryParam("filePath") String filePath)throws Exception {
		Map<String, Object> result;
	    result = transactionDelegate.transactionAddFeedback(token, msgTitle, msgContent, msgEmail,filePath);
		return Response.status(Status.OK).entity(result).build();
	}
	@GET
	@NeedLogin
	@Path("/getFeedbackMessages")
	@Produces("application/json;charset=utf-8")
	public Response getFeedbackMessages(@QueryParam("token") String token)throws Exception {
		Map<String, Object> result;
	    result = userServiceDelegate.getFeedbackMessages(token);
		return Response.status(Status.OK).entity(result).build();
	}
	@GET
	@NeedLogin
	@Path("/getGoodsOosReminds")
	@Produces("application/json;charset=utf-8")
	public Response getGoodsOosRemins(@QueryParam("token") String token)throws Exception {
		Map<String, Object> result;
	    result = userServiceDelegate.getGoodsOosRemins(token);
		return Response.status(Status.OK).entity(result).build();
	}

	@GET
	@NeedLogin
	@Path("/addRemind")
	@Produces("application/json;charset=utf-8")
	public Response addGoodsOosRemind(@QueryParam("token") String token,@QueryParam("gid") int gid)throws Exception {
		Map<String, Object> result;
	    result = userServiceDelegate.addGoodsOosRemind(token,gid);
		return Response.status(Status.OK).entity(result).build();
	}

	@GET
	@NeedLogin
	@Path("/delRemind")
	@Produces("application/json;charset=utf-8")
	public Response deleteGoodsOosRemind(@QueryParam("token") String token,@QueryParam("gid") int gid)throws Exception {
		Map<String, Object> result;
	    result = userServiceDelegate.deleteGoodsOosRemind(token,gid);
		return Response.status(Status.OK).entity(result).build();
	}
	
	@GET
	@NeedLogin
	@Path("/editRemindEmail")
	@Produces("application/json;charset=utf-8")
	public Response editRemindEmail(@QueryParam("token") String token,@QueryParam("email") String email)throws Exception {

		Map<String,Object> result = transactionDelegate.transactionEditRemindEmail(token,email);

		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/userLottery")
	@Produces("application/json;charset=utf-8")
	public Response userLottery(@QueryParam("token") String token)throws Exception {

		Map<String,Object> result = userServiceDelegate.userLottery(token);

		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/userLotteryTimes")
	@Produces("application/json;charset=utf-8")
	public Response userLotteryTimes(@QueryParam("token") String token)throws Exception {

		Map<String,Object> result = userServiceDelegate.userLotteryTimes(token);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/getInviteCode")
	@Produces("application/json;charset=utf-8")
	public Response getInviteCode(@QueryParam("token") String token)throws Exception {

		Map<String,Object> result = userServiceDelegate.getInviteCode(token);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/getInviteHistory")
	@Produces("application/json;charset=utf-8")
	public Response getInviteHistory(@QueryParam("token") String token)throws Exception {

		Map<String,Object> result = userServiceDelegate.getInviteHistory(token);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/addressValidate")
	@Produces("application/json;charset=utf-8")
	public Response addressValidate(@QueryParam("token") String token, @QueryParam("address") String address, @QueryParam("address2") String address2, @QueryParam("city") String city, @QueryParam("state") String state, @QueryParam("zipcode") String zipcode)throws Exception {

		Map<String,Object> result = uspsServiceDelegate.addressValidate(token, address, address2, city, state, zipcode);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@Path("/sendMail")
	@Produces("application/json;charset=utf-8")
	public Response sendMail(@QueryParam("token") String token,@QueryParam("toMail") String toMail, @QueryParam("mailType") String mailType,  @QueryParam("title") String title,@QueryParam("content") String content,@QueryParam("value") String value)throws Exception {

		Map<String,Object> result = userServiceDelegate.sendMail(token,  toMail, mailType, title, content,value);

		return Response.status(Status.OK).entity(result).build();

	}
	
	
	@GET
	@NeedLogin
	@Path("/userShoppingHistory")
	@Produces("application/json;charset=utf-8")
	public Response userShoppingHistory(@QueryParam("token") String token)throws Exception {

		Map<String,Object> result = userServiceDelegate.userShoppingHistory(token);

		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@Path("/inviteSummary")
	@Produces("application/json;charset=utf-8")
	public Response inviteSummary(@QueryParam("token") String token)throws Exception {

		Map<String,Object> result = userServiceDelegate.inviteSummary(token);

		return Response.status(Status.OK).entity(result).build();

	}
}
