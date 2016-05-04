package com.shubilee.delegate;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.paypal.base.rest.JSONFormatter;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.entity.DeliveryDetail;
import com.shubilee.entity.DeliveryEstimate;
import com.shubilee.entity.Location;
import com.shubilee.entity.TrackDetail;
import com.shubilee.entity.TrackMessage;
import com.shubilee.entity.UserAddress;
import com.shubilee.service.UserService;

@Service
public class UspsServiceDelegate {

	@Autowired
	private UserService userService;	
	//@Autowired
	//private LogUtil logger;
	private Logger logger = LogManager.getLogger(this.getClass().getName());
	@Value("${USPS_USERID}")
	private String USPS_USERID;
	@Value("${USPS_ENDPOINT_URL}")
	private String USPS_ENDPOINT_URL;

	/**
	 * send TrackRequest to USPS
	 * 
	 * @param tracking_number
	 *            tracking number 
	 * @throws Exception
	 * @author chris
	 */
	public Map<String, Object> uspsTrackingService(String tracking_number)
			throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tracking_number", tracking_number);
		CloseableHttpClient  httpClient = null;
		try {
			StringEntity se = new StringEntity(
					"API=TrackV2&XML=<TrackFieldRequest USERID=\""
							+ USPS_USERID
							+ "\"><Revision>1</Revision><ClientIp>127.0.0.1</ClientIp><SourceId>John Doe</SourceId><TrackID ID=\""
							+ tracking_number + "\"></TrackID></TrackFieldRequest>", HTTP.UTF_8);
			se.setContentType("text/xml");
			httpClient =  HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost(USPS_ENDPOINT_URL);
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
			model.put("track", uspsActivitys);
		} catch (Exception e) {
			if (e instanceof YamiException) {
				throw e;
			} else {
				logger.error("Usps Exception=" + e.getMessage() + ";tracking_number=" + tracking_number);
				throw new YamiException(YamiConstant.ERRORCODE_ER1461,
						ErrorCodeEnum.ER1461.getMsg(),tracking_number);
			}
		}finally{
			if(httpClient!=null)
			httpClient.close();			
		}
		return model;

	}

	/**
	 * send AddressValidateRequest to USPS
	 * 
	 * @param amount
	 *            Transaction Amount
	 * @throws Exception
	 * @author chris
	 */
	public Map<String, Object> addressValidate(String token,String address,String address2,String city,String state,String zipcode)
			throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		CloseableHttpClient  httpClient = null;
		try {
			String entity = "API=Verify&XML=<AddressValidateRequest USERID=\""
					+ USPS_USERID
					+ "\"><IncludeOptionalElements>true</IncludeOptionalElements><Address><Address1>"
					+ (address2==null?"":address2)
					+ "</Address1><Address2>"
					+ (address==null?"":address)
					+ "</Address2><City>"
					+ (city==null?"":city)
					+ "</City><State>"
					+ (state==null?"":state)
					+ "</State><Zip5>"
					+ (zipcode==null?"":zipcode)
					+ "</Zip5><Zip4></Zip4></Address></AddressValidateRequest>";

			logger.info("AddressValidateRequest=" + entity);
			StringEntity se = new StringEntity(entity, HTTP.UTF_8);
			se.setContentType("text/xml");
			httpClient =  HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost(USPS_ENDPOINT_URL);
			httpPost.setEntity(se);
			HttpEntity resEntity = httpPost.getEntity();
			//logger.info(EntityUtils.toString(resEntity));

			HttpResponse response = httpClient.execute(httpPost);

			String responsexml = EntityUtils.toString(response.getEntity());
			logger.info("AddressValidateResponse=" + responsexml);
			Document document = DocumentHelper.parseText(responsexml);
			Element root = document.getRootElement();
			Element infoElement = root.element("Address");
			if (infoElement == null) {
				throw new YamiException(YamiConstant.ERRORCODE_ER1461,
						ErrorCodeEnum.ER1461.getMsg(),address);
			}
			Element errorElement = infoElement.element("Error");
			if (errorElement != null) {
				String errorMsg = errorElement.element("Description").getText();
				if(errorMsg.startsWith("Address Not Found.")){
					logger.error("addressError=" + errorMsg + ";address=" + address);
					throw new YamiException(YamiConstant.ERRORCODE_ER1466,
							ErrorCodeEnum.ER1466.getMsg(),address);					
				}else if(errorMsg.startsWith("Invalid City.")){
					logger.fatal("addressError=" + errorMsg + ";address=" + address);	
					throw new YamiException(YamiConstant.ERRORCODE_ER1467,
							ErrorCodeEnum.ER1467.getMsg(),address);									
				}else if(errorMsg.startsWith("Invalid Zip Code.")){
					logger.fatal("addressError=" + errorMsg + ";address=" + address);	
					throw new YamiException(YamiConstant.ERRORCODE_ER1468,
							ErrorCodeEnum.ER1468.getMsg(),address);									
				}else if(errorMsg.startsWith("Multiple addresses were found")){
					logger.fatal("addressError=" + errorMsg + ";address=" + address);	
					throw new YamiException(YamiConstant.ERRORCODE_ER1469,
							ErrorCodeEnum.ER1469.getMsg(),address);									
				}else{
					logger.fatal("addressError=" + errorMsg + ";address=" + address);					
				}

			}else{
				Element returnText = infoElement.element("ReturnText");
				if (returnText != null){
					String errorMsg = returnText.getText();
					if(errorMsg.startsWith("Default address: The address you entered was found but more")){
						logger.error("addressError=" + errorMsg + ";address=" + address);
						throw new YamiException(YamiConstant.ERRORCODE_ER1464,
								ErrorCodeEnum.ER1464.getMsg(),address);					
					}else{
						Element deliveryElement = infoElement.element("DeliveryPoint");
						if(deliveryElement==null){
							throw new YamiException(YamiConstant.ERRORCODE_ER1465,
									ErrorCodeEnum.ER1465.getMsg(),address);
						}		
					}
				}else{
					// temporary block
/*					Element cityText = infoElement.element("City");
					Element zipText = infoElement.element("Zip5");
					Element stateText = infoElement.element("State");
					String returnState = StringUtil.STATE_MAP.get(stateText.getText());
					Element address2Text = infoElement.element("Address2");
					Element addressText = infoElement.element("Address1");
					model.put("Address1", addressText==null?"":addressText.getText());
					model.put("Address2", address2Text.getText());
					model.put("city", cityText.getText());
					model.put("state", returnState);
					model.put("zipcode", zipText.getText());
					if(!cityText.getText().equalsIgnoreCase(city)||!zipText.getText().equals(zipcode)){
						throw new YamiException(YamiConstant.ERRORCODE_ER1469,
								ErrorCodeEnum.ER1469.getMsg(),address);
					}*/
				}
			}
			model.put("status", YamiConstant.STATUS_OK);
			model.put("token", token);
		} catch (Exception e) {
			if (e instanceof YamiException) {
				throw e;
			} else {
				logger.error("Usps Exception=" + e.getMessage());
/*				throw new YamiException(YamiConstant.ERRORCODE_ER1461,
						ErrorCodeEnum.ER1461.getMsg(),address);*/
			}
		}finally{
			if(httpClient!=null)
			httpClient.close();			
		}
		return model;

	}
	@Test
	public void testAddress() throws Exception{
		for(int i=301397;i>301297;i--){
			UserAddress address = userService.getAddressBookByAddId(i);
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				logger.info("address id="+address.getAddress_id());
				model = addressValidate("",address.getAddress(),address.getAddress2(),address.getCity(),address.getProvince(),address.getZipcode());
				logger.info(JSONFormatter.toJSON(model));
			} catch (Exception e) {
				if (e instanceof YamiException) {
					logger.error(((YamiException) e).getCnerrorMessage());
				}else{
				//System.out.println("address id="+address.getAddress_id());
				e.printStackTrace();
				}
			}
			
		}
	}
}
