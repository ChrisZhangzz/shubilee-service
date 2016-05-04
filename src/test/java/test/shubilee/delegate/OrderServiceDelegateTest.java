package test.shubilee.delegate;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.test.util.ReflectionTestUtils;

import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.YamiException;
import com.shubilee.delegate.OrderServiceDelegate;
import com.shubilee.delegate.UpsServiceDelegate;
import com.shubilee.delegate.UspsServiceDelegate;
import com.shubilee.service.OrderInfoService;

public class OrderServiceDelegateTest {
	/*测试getOrderTracking方法*/
	private OrderServiceDelegate orderServiceDelegate = null;
	private OrderInfoService mockedOrderInfoService = null;
	private UspsServiceDelegate mockedUspsServiceDelegate = null;
	private UpsServiceDelegate mockedUpsServiceDelegate = null;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void initialize(){
		/*测试getOrderTrack方法*/
		orderServiceDelegate = new OrderServiceDelegate();
		mockedOrderInfoService = EasyMock.createMock(OrderInfoService.class);
		mockedUspsServiceDelegate = EasyMock.createMock(UspsServiceDelegate.class);
		mockedUpsServiceDelegate = EasyMock.createMock(UpsServiceDelegate.class);
		ReflectionTestUtils.setField(orderServiceDelegate, "orderInfoService", mockedOrderInfoService);
		ReflectionTestUtils.setField(orderServiceDelegate, "uspsServiceDelegate", mockedUspsServiceDelegate);
		ReflectionTestUtils.setField(orderServiceDelegate, "upsServiceDelegate", mockedUpsServiceDelegate);
		
	}
	
/*	@Test
	public void testGetOrderTrack() throws Exception{
		EasyMock.expect(mockedOrderInfoService.selectInvoiceNoByOrderId(2222)).andReturn(null);
		EasyMock.expect(mockedOrderInfoService.selectInvoiceNoByOrderId(1111)).andReturn("9878787878");
		EasyMock.expect(mockedOrderInfoService.selectInvoiceNoByOrderId(3333)).andReturn("7878787878");
		Map<String,Object> postServiceResultUsps = new HashMap<String,Object>();
		postServiceResultUsps.put("name","usps");
		Map<String,Object> postServiceResultUps = new HashMap<String,Object>();
		postServiceResultUps.put("name", "ups");
		EasyMock.expect(mockedUspsServiceDelegate.uspsTrackingService("9878787878")).andReturn(postServiceResultUsps);
		EasyMock.expect(mockedUpsServiceDelegate.upsTrackingService("7878787878")).andReturn(postServiceResultUps);
		EasyMock.replay(mockedOrderInfoService);
		EasyMock.replay(mockedUspsServiceDelegate);
		EasyMock.replay(mockedUpsServiceDelegate);
		
		String token = "eyJleHAiOjE0NDU1MTg2OTYsImRhdGEiOiIxMjk3ODgiLCJhdXRoIjoiOTRiMmI0OTVkNTFlMmUzYWYwZjI0MWRiOGI3ODNjOWUiLCJzYWx0IjoiNjEzMiIsImlzTG9naW4iOjF9";
		Map<String, Object> resultCheckUsps = new HashMap<String, Object>();
		resultCheckUsps.put("name", "usps");
		resultCheckUsps.put("token", token);
		Map<String, Object> resultCheckUps = new HashMap<String, Object>();
		resultCheckUps.put("name", "ups");
		resultCheckUps.put("token", token);
		
		Map<String,Object> resultUsps = new HashMap<String,Object>();		
		resultUsps = orderServiceDelegate.getOrderTracking(token, 1111);
		assertEquals(resultCheckUsps,resultUsps);
		EasyMock.verify(mockedUspsServiceDelegate);
		
		Map<String,Object> resultUps = new HashMap<String,Object>();
		resultUps = orderServiceDelegate.getOrderTracking(token, 3333);
		assertEquals(resultCheckUps,resultUps);
		EasyMock.verify(mockedUpsServiceDelegate);
		
		
        //assertEquals(resultCheck, result);	
		Map<String,Object> resultNull = new HashMap<String,Object>();
		exception.expect(YamiException.class);
		exception.expectMessage(ErrorCodeEnum.ER1453.getMsg()[0]);
		resultNull = orderServiceDelegate.getOrderTracking(token, 2222);
		
	}*/
	
	@After
	public void cleanUp(){
		orderServiceDelegate = null;
		mockedUpsServiceDelegate = null;
		mockedUspsServiceDelegate = null;
	}

}
