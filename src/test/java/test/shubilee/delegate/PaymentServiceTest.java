package test.shubilee.delegate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.easymock.EasyMock;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

















import com.google.gson.Gson;
import com.shubilee.common.CardType;
import com.shubilee.common.DateUtil;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.delegate.PaymentServiceDelegate;
import com.shubilee.delegate.SecurityServiceDelegate;
import com.shubilee.delegate.TransactionDelegate;
import com.shubilee.delegate.UserServiceDelegate;
import com.shubilee.entity.DeliveryDetail;
import com.shubilee.entity.DeliveryEstimate;
import com.shubilee.entity.Location;
import com.shubilee.entity.Token;
import com.shubilee.entity.TrackDetail;
import com.shubilee.entity.TrackMessage;
import com.shubilee.entity.User;
import com.shubilee.entity.UserAddress;
import com.shubilee.service.PaymentService;
import com.shubilee.service.UserService;

public class PaymentServiceTest {
	public PaymentServiceDelegate paymentServiceDelegate = null;
	public PaymentService paymentService = null;
	public TransactionDelegate transactionDelegate = null;
	public SecurityServiceDelegate securityServiceDelegate = null;
	public String token = "eyJleHAiOjE0NDU1MTg2OTYsImRhdGEiOiIxMjk3ODgiLCJhdXRoIjoiOTRiMmI0OTVkNTFlMmUzYWYwZjI0MWRiOGI3ODNjOWUiLCJzYWx0IjoiNjEzMiIsImlzTG9naW4iOjF9";
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
    public void initialize()  
    {     
		paymentServiceDelegate = new PaymentServiceDelegate();
		paymentService = EasyMock.createMock(PaymentService.class);  
		transactionDelegate = EasyMock.createMock(TransactionDelegate.class);  
		securityServiceDelegate =  EasyMock.createMock(SecurityServiceDelegate.class);
		ReflectionTestUtils.setField(paymentServiceDelegate, "paymentService", paymentService);
		ReflectionTestUtils.setField(paymentServiceDelegate, "transactionDelegate", transactionDelegate);
    }
	@Test
	public void testNihao() throws Exception{
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
		RestTemplate restTemplate = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		//String apiToken="Bearer 75d7e3772a84b9c174ede65d20f85dfb26bbbcc124f385d24ddd4c53261e2a8e";
		String apiToken="Bearer b4ed25ed3e1b52dd4c8860ccf408770bf6a23d85b8072472a5de7450ad6e35f2";
        headers.setContentType(type);
        //headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Accept-Encoding", "gzip,deflate");
        //headers.add("Accept", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        headers.add("Authorization", apiToken);
        //headers.add("Connection", "Keep-Alive");
        
        MultiValueMap<String, String> postParams = new LinkedMultiValueMap<String, String>();
        //JSONObject postParams = new JSONObject();
        postParams.add("amount", "103");
        postParams.add("currency", "USD");
        postParams.add("card_number", "6221558812340000");
        postParams.add("card_exp_month", "11");
        postParams.add("card_exp_year", "2017");
        postParams.add("card_cvv", "123");
        //postParams.add("card_type", "unionpay");
        
/*        ResponseEntity<byte[]> response = restTemplate.exchange("http://api.test.nihaopay.com/v1/transactions/expresspay",
        		HttpMethod.POST,
        	      new HttpEntity<String>(postParams.toString(),headers),
        	      byte[].class);*/
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(postParams, headers);

        String url ="http://api.test.nihaopay.com/v1.1/transactions/expresspay";
        //HttpEntity<String> formEntity = new HttpEntity<String>("amount=102&currency=USD&card_number=6221558812340000&card_expire_month=11&card_expire_year=2017&card_cvv=123&card_type=unionpay", headers);
        String result = "";
/*        HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
		HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
		List<HttpMessageConverter<?>> ms = new ArrayList<HttpMessageConverter<?>>();
		ms.add(stringHttpMessageConverternew);
		ms.add(formHttpMessageConverter);
		restTemplate.setMessageConverters(ms);*/
        try{
        result = restTemplate.postForObject(url, request, String.class);
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }

	    System.out.println(result);
	}
	@Test
	public void testNihaoPay() throws Exception{
			Map<String, Object> model = new HashMap<String, Object>();
			//model.put("tracking_number", tracking_number);
			//CloseableHttpClient  httpClient = null;
			ResteasyClient client = null;
			String apiToken="75d7e3772a84b9c174ede65d20f85dfb26bbbcc124f385d24ddd4c53261e2a8e";
			try {
				client = new ResteasyClientBuilder().build();
			    ResteasyWebTarget target = client.target("http://api.test.nihaopay.com/v1/transactions/expresspay");
			    Response response = target.request().header("Authorization", "Bearer 75d7e3772a84b9c174ede65d20f85dfb26bbbcc124f385d24ddd4c53261e2a8e")
			            .acceptEncoding("gzip, deflate")
			            .post(Entity.entity("amount=100", "application/x-www-form-urlencoded"));
				
			    System.out.println(response.getEntity());
				
				/*RestTemplate restTemplate = new RestTemplate();
				StringEntity se = new StringEntity(
						"API=TrackV2&XML=<TrackFieldRequest USERID=\""
								+ USPS_USERID
								+ "\"><Revision>1</Revision><ClientIp>127.0.0.1</ClientIp><SourceId>John Doe</SourceId><TrackID ID=\""
								+ tracking_number + "\"></TrackID></TrackFieldRequest>", HTTP.UTF_8);
				se.setContentType("text/xml");
				httpClient =  HttpClientBuilder.create().build();
				HttpPost httpPost = new HttpPost("https://api.nihaopay.com");
				httpPost.setEntity(se);
				HttpEntity resEntity = httpPost.getEntity();
				//logger.info(EntityUtils.toString(resEntity));

				HttpResponse response = httpClient.execute(httpPost);

				String responsexml = EntityUtils.toString(response.getEntity());
				logger.info("UspsTrackResponse=" + responsexml);
				Document document = DocumentHelper.parseText(responsexml);
				Element root = document.getRootElement();
				Element infoElement = root.element("TrackInfo");
				Element errorElement = infoElement.element("Error");
				if (errorElement != null) {
					logger.error("errorElement=" + errorElement + ";tracking_number=" + tracking_number);
					throw new YamiException(YamiConstant.ERRORCODE_ER1462,
							ErrorCodeEnum.ER1462.getMsg(),tracking_number);
				}
				DeliveryDetail uspsDeliveryDetail = new DeliveryDetail();
				Location uspsAddress = new Location();
				uspsAddress.setCity(infoElement.element("DestinationCity").getText());
				uspsAddress.setState(infoElement.element("DestinationState").getText());
				uspsAddress.setZipcode(infoElement.element("DestinationZip").getText());
				DeliveryEstimate deliveryEstimate = new DeliveryEstimate();
				if (infoElement.element("ExpectedDeliveryDate") != null) {
					deliveryEstimate.setDate(infoElement.element("ExpectedDeliveryDate").getText());
					deliveryEstimate.setDesc("ExpectedDeliveryDate");
				}
				TrackMessage uspsMessage = new TrackMessage();
				uspsMessage.setDesc(infoElement.element("StatusSummary").getText());

				uspsDeliveryDetail.setLocation(uspsAddress);
				uspsDeliveryDetail.setDeliveryEstimate(deliveryEstimate);
				uspsDeliveryDetail.setTrackMessage(uspsMessage);

				List<Element> list = infoElement.elements("TrackDetail");
				TrackDetail[] uspsActivitys = new TrackDetail[list.size() + 1];
				Element summaryElement = infoElement.element("TrackSummary");
				Location summarylocation = new Location();
				summarylocation.setCity(summaryElement.element("EventCity").getText());
				summarylocation.setState(summaryElement.element("EventState").getText());
				summarylocation.setCountry(summaryElement.element("EventCountry").getText());
				summarylocation.setZipcode(summaryElement.element("EventZIPCode").getText());
				TrackDetail uspsActivity = new TrackDetail();
				uspsActivity.setLocation(summarylocation);
				uspsActivity.setStatus(summaryElement.element("Event").getText());
				uspsActivity.setDate(summaryElement.element("EventDate").getText());
				uspsActivity.setTime(summaryElement.element("EventTime").getText());
				uspsActivitys[0] = uspsActivity;
				for (int i = 0; i < list.size(); i++) {
					Location location = new Location();
					location.setCity(list.get(i).element("EventCity").getText());
					location.setState(list.get(i).element("EventState").getText());
					location.setCountry(list.get(i).element("EventCountry").getText());
					location.setZipcode(list.get(i).element("EventZIPCode").getText());
					TrackDetail trackDetail = new TrackDetail();
					trackDetail.setLocation(location);
					trackDetail.setStatus(list.get(i).element("Event").getText());
					trackDetail.setDate(list.get(i).element("EventDate").getText());
					trackDetail.setTime(list.get(i).element("EventTime").getText());
					uspsActivitys[i + 1] = trackDetail;
				}
				model.put("delivery", uspsDeliveryDetail);
				model.put("track", uspsActivitys);*/
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw e;
				
			}finally{
				if(client!=null)
					client.close();			
			}

	}	
	
	@After  
    public void cleanup()   
    {  
		paymentServiceDelegate=null;  
		paymentService=null;   
		transactionDelegate=null;  
    }  
}
