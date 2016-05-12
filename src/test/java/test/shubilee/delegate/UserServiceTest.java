package test.shubilee.delegate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.test.util.ReflectionTestUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.shubilee.common.CardType;
import com.shubilee.common.DateUtil;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.delegate.SecurityServiceDelegate;
import com.shubilee.delegate.TransactionDelegate;
import com.shubilee.delegate.UserServiceDelegate;
import com.shubilee.entity.Token;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.Users;
import com.shubilee.service.UserService;

public class UserServiceTest {
	public UserServiceDelegate userServiceDelegate = null;
	public UserService userService = null;
	public TransactionDelegate transactionDelegate = null;
	public SecurityServiceDelegate securityServiceDelegate = null;
	public String token = "eyJleHAiOjE0NDU1MTg2OTYsImRhdGEiOiIxMjk3ODgiLCJhdXRoIjoiOTRiMmI0OTVkNTFlMmUzYWYwZjI0MWRiOGI3ODNjOWUiLCJzYWx0IjoiNjEzMiIsImlzTG9naW4iOjF9";
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
    public void initialize()  
    {     
		userServiceDelegate = new UserServiceDelegate();
		userService = EasyMock.createMock(UserService.class);  
		transactionDelegate = EasyMock.createMock(TransactionDelegate.class);  
		securityServiceDelegate =  EasyMock.createMock(SecurityServiceDelegate.class);
		ReflectionTestUtils.setField(userServiceDelegate, "userService", userService);
		ReflectionTestUtils.setField(userServiceDelegate, "transactionDelegate", transactionDelegate);
    }
	
	@Test
	public void testLoginUserException1() throws Exception{

		exception.expect(YamiException.class);
		exception.expectMessage("Incorrect user name");
		Map<String, Object> result = userServiceDelegate.loginUser(token,"11&cn", "123");	
	}	
	@Test
	public void testLoginUserException2() throws Exception{
		
		exception.expect(YamiException.class);
		exception.expectMessage("Incorrect password");
		Map<String, Object> result = userServiceDelegate.loginUser(token,"11@sina.com", "12345");		
	}
	@Test
	public void testLoginUserException3() throws Exception{
		
		EasyMock.expect(userService.getPasswordSalt("11@sina.com")).andReturn(null);
		
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid user and password");
		Map<String, Object> result = userServiceDelegate.loginUser(token,"11@sina.com", "123456");		
	}	
	@Test
	public void testLoginUserException4() throws Exception{
		Users user = new Users();
		user.setSalt("3299");
		user.setPassword("319be2d76a64027af4ac6ae36fa9c249");
		EasyMock.expect(userService.getPasswordSalt("12@sina.com")).andReturn(user);
		
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid user and password");
		Map<String, Object> result = userServiceDelegate.loginUser(token,"12@sina.com", "1234567");		
	}	
	@Test
	public void testSendMail() throws Exception{
		try {
			Context data = new Context();
			data.setVariable("user_name", "zhang");
			data.setVariable("reset_email_en", "33333");
			TemplateEngine templateEngine = new TemplateEngine();
			String emailContent = templateEngine.process("ResetPasswordEmail", data);
			  HtmlEmail htmlEmail = new HtmlEmail();
			  htmlEmail.setHostName("smtp.gmail.com");
			  htmlEmail.addTo("chris.zhang@yamibuy.com", "haha");
			  htmlEmail.setFrom("chris.zhang@yamibuy.com", "Me");
			  htmlEmail.setSubject("title");
			  htmlEmail.setSSLOnConnect(true);
			  htmlEmail.setStartTLSEnabled(true);
			  htmlEmail.setSmtpPort(587);
			  // embed the image and get the content id
			  URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
			  String cid = htmlEmail.embed(url, "Apache logo");
			  
			  // set the html message
			  htmlEmail.setHtmlMsg(emailContent);
			  
			// send the email
			  htmlEmail.send();
		} catch (MalformedURLException e) {
			System.out.println("Failed to send email");
			System.out.println(e.toString());
		} catch (EmailException e) {
			System.out.println("Failed to send email");
			System.out.println(e.toString());
		}
	}
	/*	@Test
	public void testLoginUser() throws Exception{
		EasyMock.expect(securityServiceDelegate.getToken(EasyMock.eq(250), EasyMock.isA(String.class), EasyMock.isA(String.class))).andReturn("M456");
		User user = new User();
		user.setUser_Id(250);
		user.setEc_salt("3299");
		user.setUser_Name("chris");
		user.setPassword("319be2d76a64027af4ac6ae36fa9c249");
		EasyMock.expect(userService.getPasswordSalt("12@sina.com")).andReturn(user);
		transactionDelegate.transactionLogin(EasyMock.isA(User.class),EasyMock.isA(Token.class));
		EasyMock.replay(securityServiceDelegate);  
		EasyMock.replay(userService); 
		EasyMock.replay(transactionDelegate);  
		
		
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid user and password");
		Map<String, Object> result = userServiceDelegate.loginUser(token,"12@sina.com", "1234567");	
		Map<String, Object> expect = new HashMap<String, Object>();
		expect.put("uid", 250);
		expect.put("name", user.getUser_Name());
		expect.put("token","M456");	
		assertEquals(expect, result);
		EasyMock.verify(securityServiceDelegate);
		EasyMock.verify(userService);
		EasyMock.verify(transactionDelegate);
		
	}*/
	
	@Test
	public void testNewAddressException1() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid first name");
		Map<String, Object> result = userServiceDelegate.newAddress(token," ","lastname","address1","address2","city","state","zipcode","phone","email","0");	
	}
	@Test
	public void testNewAddressException2() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid first name");
		Map<String, Object> result = userServiceDelegate.newAddress(token,null,"lastname","address1","address2","city","state","zipcode","phone","email","0");	
	}
	@Test
	public void testNewAddressException3() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid last name");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname"," ","address1","address2","city","state","zipcode","phone","email","0");	
	}
	@Test
	public void testNewAddressException4() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid last name");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname",null,"address1","address2","city","state","zipcode","phone","email","0");	
	}
	@Test
	public void testNewAddressException5() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid address 1");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","","address2","city","state","zipcode","phone","email","0");	
	}
	@Test
	public void testNewAddressException6() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid address 1");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname",null,"address2","city","state","zipcode","phone","email","0");	
	}
	@Test
	public void testNewAddressException7() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid city");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","","state","zipcode","phone","email","0");	
	}
	@Test
	public void testNewAddressException8() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid city");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2",null,"state","zipcode","phone","email","0");	
	}
	@Test
	public void testNewAddressException9() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid zip code");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state",null,"phone","email","0");	
	}
	@Test
	public void testNewAddressException10() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid zip code");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state","A2234","phone","email","0");	
	}
	@Test
	public void testNewAddressException11() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid zip code");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state","2234","phone","email","0");	
	}
	@Test
	public void testNewAddressException12() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid phone number");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state","92344",null,"email","0");	
	}
	//@Ignore
	@Test
	public void testNewAddressException13() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid phone number");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state","92344"," ","email","0");	
	}
	@Test
	public void testNewAddressException14() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid email address");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state","92344","12345",null,"0");	
	}
	@Test
	public void testNewAddressException15() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid email address");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state","92344","12345"," ","0");	
	}
	@Test
	public void testNewAddressException16() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid email address");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state","92344","12345","123@","0");	
	}
	@Test
	public void testNewAddressException17() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid email address");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state","92344","12345","123@com","0");	
	}
	@Test
	public void testNewAddressException18() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid email address");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2","city","state","92344","12345","123ee.com","0");	
	}
	@Test
	public void testNewAddressException19() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Please use English alphabet for names");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firs你tname","lastname","address1","address2","city","state","92344","12345","123@ee.com","0");	
	}
	@Test
	public void testNewAddressException20() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Please use English alphabet for names");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","last你name","address1","address2","city","state","92344","12345","123@ee.com","0");	
	}
	@Test
	public void testNewAddressException21() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Please use English alphabet for addresses");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1你","address2","city","state","92344","12345","123@ee.com","0");	
	}
	@Test
	public void testNewAddressException22() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Please use English alphabet for addresses");
		Map<String, Object> result = userServiceDelegate.newAddress(token,"firstname","lastname","address1","address2你","city","state","92344","12345","123@ee.com","0");	
	}
	
	@Test
	public void testNewPaymentException1() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid first name");
		Map<String, Object> result = userServiceDelegate.newPayment(token, null, "lastname", "Visa", "379719276061023", "2016", "05", "1001");	
	}
	@Test
	public void testNewPaymentException2() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid first name");
		Map<String, Object> result = userServiceDelegate.newPayment(token, " ", "lastname", "Visa", "379719276061023", "2016", "05", "1001");	
	}
	@Test
	public void testNewPaymentException3() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid card number");
		Map<String, Object> result = userServiceDelegate.newPayment(token, "firstname", "lastname", "Visa", null, "2016", "05", "1001");	
	}
	@Test
	public void testNewPaymentException4() throws Exception{
	
		exception.expect(YamiException.class);
		exception.expectMessage("Invalid card number");
		Map<String, Object> result = userServiceDelegate.newPayment(token, "firstname", "lastname", "Visa", "3797192760610", "2016", "05", "1001");	
	}

	
	
	@Test
	public void testDeleteAddress() throws Exception{
		EasyMock.expect(userService.getAddressBookByAddId(111)).andReturn(null);
		UserAddress userAddress  = new UserAddress();
		userAddress.setIs_primary(1);
		EasyMock.expect(userService.getAddressBookByAddId(222)).andReturn(userAddress);
		transactionDelegate.transactionDeleteAddress(222, 129788, 1, null);
		//EasyMock.expectLastCall();
		EasyMock.replay(userService);  
		EasyMock.replay(transactionDelegate);  
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("status", YamiConstant.STATUS_OK);
		model.put("token", token);


		Map<String, Object> result2 = userServiceDelegate.deleteAddress(token, 222);
		assertEquals(model, result2);
		
		exception.expect(YamiException.class);
		exception.expectMessage("The address does not exist.");
		Map<String, Object> result = userServiceDelegate.deleteAddress(token, 111);
		EasyMock.verify(userService);
		EasyMock.verify(transactionDelegate);
	}
	@Test
	public void testAddtional() throws Exception{
		Calendar calendar=new GregorianCalendar(); 
        Date now = new Date(calendar.getTimeInMillis());
		long m1 = DateUtil.timeFormat(DateUtil.getNowDateTimeAllString());
		long timeout = 3600*24;
		long m2 = m1 + timeout;
		System.out.println("now="+now);
		System.out.println("m1="+m1);
		System.out.println("m2="+m2);
		changetime(m1);
		changetime(m2);
	}
	public void changetime(long time) throws Exception{
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date begin = dfs.parse("1970-01-01 00:00:00:00");
			java.util.Date end = new java.util.Date(time * 1000
					+ begin.getTime());
			String endStr = dfs.format(end);
			System.out.println(endStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}			
	}
	@Test
	public void testCardType() throws Exception {
		String cardNum = "379719276061023";
		String m1 = CardType.detect(String.valueOf(cardNum)).toString();
		System.out.println(m1);
		int timeout = 3600*48;
		long exp = DateUtil.timeFormat(DateUtil.getNowDateTimeAllString())+timeout;
		System.out.println("exp="+exp);
		changetime(exp);
	}
	@After  
    public void cleanup()   
    {  
		userServiceDelegate=null;  
		userService=null;   
		transactionDelegate=null;  
    }  
}
