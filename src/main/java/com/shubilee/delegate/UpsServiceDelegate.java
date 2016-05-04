package com.shubilee.delegate;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.paypal.base.rest.JSONFormatter;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.entity.DeliveryDetail;
import com.shubilee.entity.DeliveryEstimate;
import com.shubilee.entity.Location;
import com.shubilee.entity.TrackDetail;
import com.shubilee.entity.TrackMessage;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackErrorMessage;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.ActivityType;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.DeliveryDateUnavailableType;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.DeliveryDetailType;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.RequestType;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.ServiceAccessToken_type0;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.ShipmentAddressType;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.ShipmentType;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.TrackRequest;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.TrackResponse;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.UPSSecurity;
import com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.UsernameToken_type0;

@Service
public class UpsServiceDelegate {

	// private static Properties props = null;
	private static String statusCode = null;
	private static String description = null;
	@Value("${UPS_LICENSE_NUMBER}")
	private String UPS_LICENSE_NUMBER;
	@Value("${UPS_USER_NAME}")
	private String UPS_USER_NAME;
	@Value("${UPS_PASSWORD}")
	private String UPS_PASSWORD;
	@Value("${UPS_ENDPOINT_URL}")
	private String UPS_ENDPOINT_URL;
	@Value("${UPS_SUB_VERSION}")
	private String UPS_SUB_VERSION;
	@Value("${UPS_REQUEST_VERSION}")
	private String UPS_REQUEST_VERSION;
	@Value("${UPS_TRACKING_VERSION}")
	private String UPS_TRACKING_VERSION;
	@Value("${UPS_STATUS_OK}")
	private String UPS_STATUS_OK;
	@Value("${UPS_SHIPTO_ADDRESS}")
	private String UPS_SHIPTO_ADDRESS;
	@Value("${UPS_ERRORCODE_151044}")
	private String UPS_ERRORCODE_151044;
	@Value("${UPS_ERRORCODE_150022}")
	private String UPS_ERRORCODE_150022;

	//@Autowired
	//private LogUtil logger;
	private Logger logger = LogManager.getLogger(this.getClass().getName());

	/**
	 * send NewOrderRequest to CHASE
	 * 
	 * @param amount
	 *            Transaction Amount
	 * @throws Exception
	 * @author chris
	 */
	public Map<String, Object> upsTrackingService(String tracking_number)
			throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tracking_number", tracking_number);
		DateFormat formatDate = new SimpleDateFormat("MMM d, yyyy");
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		DateFormat formatTime = new SimpleDateFormat("h:mm a");
		SimpleDateFormat sdfTime = new SimpleDateFormat("hhmmss");
		try {
			TrackServiceStub trackServiceStub = new TrackServiceStub(UPS_ENDPOINT_URL);

			UPSSecurity upss = new UPSSecurity();
			ServiceAccessToken_type0 upsSvcToken = new ServiceAccessToken_type0();
			upsSvcToken.setAccessLicenseNumber(UPS_LICENSE_NUMBER);
			upss.setServiceAccessToken(upsSvcToken);
			UsernameToken_type0 upsSecUsrnameToken = new UsernameToken_type0();
			upsSecUsrnameToken.setUsername(UPS_USER_NAME);
			upsSecUsrnameToken.setPassword(UPS_PASSWORD);
			upss.setUsernameToken(upsSecUsrnameToken);

			TrackRequest trackRequest = new TrackRequest();
			RequestType request = new RequestType();
			request.setSubVersion(UPS_SUB_VERSION);
			String[] requestOption = { UPS_REQUEST_VERSION };
			request.setRequestOption(requestOption);
			trackRequest.setRequest(request);
			trackRequest.setInquiryNumber(tracking_number);
			trackRequest.setTrackingOption(UPS_TRACKING_VERSION);

			TrackResponse tr = trackServiceStub.processTrack(trackRequest, upss);
			try {
				logger.info("TrackResponse: " + JSONFormatter.toJSON(tr));
			} catch (Exception e) {
				logger.error("Ups Response toJSON Error Message : " + e.getMessage());
			}
			statusCode = tr.getResponse().getResponseStatus().getCode();
			if (!statusCode.equals(UPS_STATUS_OK)) {
				// throw
				logger.error("statusCode=" + statusCode + ";tracking_number=" + tracking_number);
				throw new YamiException(YamiConstant.ERRORCODE_ER1451,
						ErrorCodeEnum.ER1451.getMsg(),tracking_number);
			}
			DeliveryDetail upsDeliveryDetail = new DeliveryDetail();
			ShipmentType shipment = tr.getShipment()[0];
			ShipmentAddressType[] shipmentAddresses = shipment.getShipmentAddress();
			Location upsAddress = new Location();
			if(shipmentAddresses!=null){
			for (int i = shipmentAddresses.length - 1; i >= 0; i--) {
				if (UPS_SHIPTO_ADDRESS
						.equals(shipmentAddresses[i].getType().getCode())) {
					upsAddress.setCity(shipmentAddresses[i].getAddress().getCity());
					upsAddress.setState(shipmentAddresses[i].getAddress().getStateProvinceCode());
					upsAddress.setZipcode(shipmentAddresses[i].getAddress().getPostalCode());
					upsAddress.setCountry(shipmentAddresses[i].getAddress().getCountryCode());
					break;
				}
			}
			}
			DeliveryDateUnavailableType deliveryDateUnavailable = shipment
					.getDeliveryDateUnavailable();
			TrackMessage upsMessage = new TrackMessage();

			if (null != deliveryDateUnavailable) {
				String unavailable = deliveryDateUnavailable.getDescription();
				upsMessage.setDesc(unavailable);
			} else {
				DeliveryDetailType[] deliveryDetails = shipment.getPackage()[0].getDeliveryDetail();
				if(deliveryDetails==null){
					deliveryDetails=shipment.getDeliveryDetail();
				}
				if(deliveryDetails!=null){
				DeliveryEstimate deliveryEstimate = new DeliveryEstimate();
				deliveryEstimate.setCode(deliveryDetails[0].getType().getCode());
				deliveryEstimate.setDesc(deliveryDetails[0].getType().getDescription());
				deliveryEstimate.setDate(formatDate.format(sdfDate.parse(deliveryDetails[0].getDate())));
				upsDeliveryDetail.setDeliveryEstimate(deliveryEstimate);
				}
				if (null != shipment.getPackage()[0].getMessage()) {
					upsMessage.setStatus(shipment.getPackage()[0].getMessage()[0].getDescription());
				}
			}
			upsDeliveryDetail.setLocation(upsAddress);
			upsDeliveryDetail.setTrackMessage(upsMessage);
			ActivityType[] activities = shipment.getPackage()[0].getActivity();
			TrackDetail[] upsActivitys = new TrackDetail[activities.length];
			for (int i = 0; i < activities.length; i++) {
				TrackDetail trackDetail = new TrackDetail();
				trackDetail.setStatus(activities[i].getStatus()==null?YamiConstant.STRING_EMPTY:activities[i].getStatus().getDescription());
				trackDetail.setTime(formatTime.format(sdfTime.parse(activities[i].getTime())));
				trackDetail.setDate(formatDate.format(sdfDate.parse(activities[i].getDate())));
				Location location = new Location();
				if(activities[i].getActivityLocation()!=null&&activities[i].getActivityLocation().getAddress()!=null){
				location.setCity(activities[i].getActivityLocation().getAddress().getCity());
				location.setCountry(activities[i].getActivityLocation().getAddress()
						.getCountryCode());
				location.setState(activities[i].getActivityLocation().getAddress()
						.getStateProvinceCode());
				}else{
					location.setCity(YamiConstant.STRING_EMPTY);
					location.setCountry(YamiConstant.STRING_EMPTY);
					location.setState(YamiConstant.STRING_EMPTY);					
				}
				trackDetail.setLocation(location);
				upsActivitys[i] = trackDetail;
			}

			model.put("delivery", upsDeliveryDetail);
			model.put("track", upsActivitys);
		} catch (Exception e) {
			if (e instanceof YamiException) {
				throw e;
			} else if (e instanceof TrackErrorMessage) {
				TrackErrorMessage tErrorMessage = (TrackErrorMessage) e;
				statusCode = tErrorMessage.getFaultMessage().getErrorDetail()[0]
						.getPrimaryErrorCode().getCode();
				description = tErrorMessage.getFaultMessage().getErrorDetail()[0]
						.getPrimaryErrorCode().getDescription();
				if (UPS_ERRORCODE_151044.equals(statusCode)) {
					// No tracking information available.
					logger.error("statusCode=" + statusCode + ";tracking_number=" + tracking_number);
					logger.error("description=" + description);
					throw new YamiException(YamiConstant.ERRORCODE_ER1452,
							ErrorCodeEnum.ER1452.getMsg(),tracking_number);
				}else if(UPS_ERRORCODE_150022.equals(statusCode)){
					logger.error("statusCode=" + statusCode + ";tracking_number=" + tracking_number);
					logger.error("description=" + description);
					throw new YamiException(YamiConstant.ERRORCODE_ER1453,
							ErrorCodeEnum.ER1453.getMsg(),tracking_number);					
				}
			} else {
				statusCode = e.getMessage();
				description = e.toString();
			}
			logger.error("statusCode=" + statusCode + ";tracking_number=" + tracking_number);
			logger.error("description=" + description);
			throw new YamiException(YamiConstant.ERRORCODE_ER1451, ErrorCodeEnum.ER1451.getMsg(),tracking_number);
		}

		return model;

	}

}
