package com.shubilee.delegate;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import net.paymentech.ws.NewOrderRequestElement;
import net.paymentech.ws.NewOrderResponseElement;
import net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayLocator;
import net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayPortType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.CountryCodeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.ErrorType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;
import urn.ebay.apis.eBLBaseComponents.SellerDetailsType;
import urn.ebay.apis.eBLBaseComponents.SetExpressCheckoutRequestDetailsType;

import com.google.gson.Gson;
import com.paypal.api.payments.Payment;
import com.paypal.base.ConfigManager;
import com.paypal.base.Constants;
import com.paypal.base.rest.JSONFormatter;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalResource;
import com.shubilee.common.DateUtil;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.RedisKeyConstant;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.entity.Activity;
import com.shubilee.entity.Cart;
import com.shubilee.entity.ExpressCheckout;
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.OrderOrbitalGateway;
import com.shubilee.entity.OrderPaypal;
import com.shubilee.entity.Token;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserProfile;
import com.shubilee.service.ActivityGiftService;
import com.shubilee.service.ActivityLookupService;
import com.shubilee.service.ActivityService;
import com.shubilee.service.OrderGenerateService;
import com.shubilee.service.OrderInfoService;
import com.shubilee.service.PaymentService;
import com.shubilee.service.UserService;

@Service
public class PaymentServiceDelegate {

	@Autowired private RedisTemplate<String,String> redisTemplate4EC;
	
	@Autowired
	private TransactionDelegate transactionDelegate;

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private OrderInfoService orderInfoService;
	
	@Autowired
	private UserService userService;

	//@Autowired
	//private LogUtil logger;
	private Logger logger = LogManager.getLogger(this.getClass().getName());
	
	@Value("${PAYPAL_RETURN_URL}")
	private String PAYPAL_RETURN_URL;
	@Value("${PAYPAL_CANCEL_URL}")
	private String PAYPAL_CANCEL_URL;
	@Value("${PAYPAL_PCRETURN_URL_EN}")
	private String PAYPAL_PCRETURN_URL_EN;
	@Value("${PAYPAL_PCCANCEL_URL_EN}")
	private String PAYPAL_PCCANCEL_URL_EN;	
	@Value("${PAYPAL_PCRETURN_URL_CN}")
	private String PAYPAL_PCRETURN_URL_CN;
	@Value("${PAYPAL_PCCANCEL_URL_CN}")
	private String PAYPAL_PCCANCEL_URL_CN;
	@Value("${PAYPAL_RS_STATE_APPROVED}")
	private String PAYPAL_RS_STATE_APPROVED;
	@Value("${PAYPAL_ERRORCODE_11607}")
	private String PAYPAL_ERRORCODE_11607;
	@Value("${PAYPAL_VERIFY_ERROR}")
	private String PAYPAL_VERIFY_ERROR;
	@Value("${PAYPAL_TIMEOUT_ERROR}")
	private String PAYPAL_TIMEOUT_ERROR;
	@Value("${PAYPAL_RS_PAYMENT_MODE}")
	private String PAYPAL_RS_PAYMENT_MODE;
	@Value("${SDK_CONFIGURATION_FILE}")
	private String SDK_CONFIGURATION_FILE;
	@Value("${PAYPAL_RESPONSE_ACK_SUCCESS}")
	private String PAYPAL_RESPONSE_ACK_SUCCESS;
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


	/**
     * send NewOrderRequest to CHASE
     * @param amount Transaction Amount
     * @throws Exception
     * @author chris
     */
	public Map<String, Object> doPayment(String token,String profile_id,String purchase_id,String csc,Double amount,String currency) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		UserProfile userProfile = userService.getProfileByPid(profile_id);
		if(userProfile==null){
			throw new YamiException(YamiConstant.ERRORCODE_ER1312,ErrorCodeEnum.ER1312.getMsg());			
		}
		Integer addressId = userProfile.getAddress_id();
		UserAddress userAddress = userService.getAddressBookByAddId(addressId);
		if(userAddress==null){
			throw new YamiException(YamiConstant.ERRORCODE_ER1322,ErrorCodeEnum.ER1322.getMsg());			
		}
		String zipCode = userAddress.getZipcode();
		DecimalFormat df1 = new DecimalFormat(YamiConstant.FMT_NO_DECIMAL_POINT);
		String money = df1.format(amount*100);
		NewOrderResponseElement authResponse = null;
		// First Get the service
		PaymentechGatewayLocator service = new PaymentechGatewayLocator();

		// Create a Auth request
		NewOrderRequestElement authBean = new NewOrderRequestElement();
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
		authBean.setTransType(OGWS_TRANSTYPE_AC);
		authBean.setIndustryType(OGWS_INDUSTRYTYPE_EC);
		authBean.setAmount(money);
		authBean.setTerminalID(OGWS_TERMINALID);		
		authBean.setOrderID(purchase_id);
		authBean.setUseCustomerRefNum(profile_id);
		authBean.setCcCardVerifyNum(csc);
		authBean.setAvsZip(zipCode);
		authBean.setPCardDestZip(zipCode);
		authBean.setPCardOrderID(purchase_id);
		authBean.setRetryTrace(purchase_id);
		authBean.setTaxInd("0");
		authBean.setTaxAmount("0");
		

		// Invoke the newOrder service and print response
		try {
			authResponse = portType.newOrder(authBean);
		} catch (Exception ie) {
			logger.error("######### Error Response ##############");
			logger.error(ie.toString());
			throw new YamiException(YamiConstant.ERRORCODE_ER1331,ErrorCodeEnum.ER1331.getMsg(),ie.toString());
		}
		
		OrderOrbitalGateway orderOrbitalGateway = new OrderOrbitalGateway();
		orderOrbitalGateway.setAmount(new BigDecimal(amount.toString()));
		orderOrbitalGateway.setApprovalStatus(authResponse.getApprovalStatus());
		orderOrbitalGateway.setAuthCode(authResponse.getAuthorizationCode());
		orderOrbitalGateway.setCardBrand(authResponse.getCardBrand());
		orderOrbitalGateway.setIndustryType(authResponse.getIndustryType());
		orderOrbitalGateway.setOrderId(authResponse.getOrderID());
		orderOrbitalGateway.setProcStatus(Integer.valueOf(authResponse.getProcStatus()));
		orderOrbitalGateway.setRespCode(authResponse.getRespCode());
		orderOrbitalGateway.setRespDate(authResponse.getRespDateTime());
		orderOrbitalGateway.setRetryTimes(authResponse.getRetryAttempCount()==null?"":authResponse.getRetryAttempCount());
		orderOrbitalGateway.setRetryTrace(authResponse.getRetryTrace());
		orderOrbitalGateway.setTransType(authResponse.getTransType());
		orderOrbitalGateway.setTxRefIdx(Integer.valueOf(authResponse.getTxRefIdx()));
		orderOrbitalGateway.setTxRefNum(authResponse.getTxRefNum());
		orderOrbitalGateway.setAvsRespCode(authResponse.getAvsRespCode()==null?"":authResponse.getAvsRespCode());
		orderOrbitalGateway.setCvvRespCode(authResponse.getCvvRespCode()==null?"":authResponse.getCvvRespCode());
		// Update order_orbital_gateway
		try {
			transactionDelegate.transactionAddOrderOrbitalGateway(orderOrbitalGateway);
		} catch (Exception e) {
			logger.error("Failed to update order_orbital_gateway");
		}
		logger.info("###Response Received ###");
		try {
			logger.info(" authResponse: " + JSONFormatter.toJSON(authResponse));
		} catch (Exception e) {
			logger.error("doPayment Response toJSON Error Message : " + e.getMessage());
		}		
		//logger.info(" ProcStatusMessage: " + authResponse.getProcStatusMessage());
		//logger.info(" ApprovalStatus: " + authResponse.getApprovalStatus());
		if(!"0".equals(authResponse.getProcStatus())||!"1".equals(authResponse.getApprovalStatus())){
			throw new YamiException(YamiConstant.ERRORCODE_ER1333,ErrorCodeEnum.ER1333.getMsg(),authResponse.getProcStatusMessage());			
		}
		model.put("status", YamiConstant.STATUS_OK);
		model.put("token", token);
		return model;

	}

	public Map<String, Object> verifyPayment(String token, String pay_id, int purchase_id) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		InputStream is = PaymentServiceDelegate.class.getResourceAsStream(SDK_CONFIGURATION_FILE);
		try {
			PayPalResource.initConfig(is);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new YamiException(YamiConstant.ERRORCODE_ER1331,ErrorCodeEnum.ER1331.getMsg(),e.getMessage());	
		}
		String clientID = ConfigManager.getInstance().getValue(Constants.CLIENT_ID);
		String clientSecret = ConfigManager.getInstance().getValue(Constants.CLIENT_SECRET);
		OAuthTokenCredential tokenCredential = new OAuthTokenCredential(clientID, clientSecret);

		String accessToken = tokenCredential.getAccessToken();
		String updateTime = YamiConstant.STRING_EMPTY;
		String payerId = YamiConstant.STRING_EMPTY;
		String paymentStatus = YamiConstant.STRING_EMPTY;
		String paymentType = YamiConstant.STRING_EMPTY;
		BigDecimal paypalCharge = new BigDecimal(0);
		BigDecimal totalAmount = new BigDecimal(0);
		String transactionId = YamiConstant.STRING_EMPTY;
		String transactionType = "verify-payment";
		String merchantAccount = YamiConstant.STRING_EMPTY;
		try {
			Payment payment = Payment.get(accessToken, pay_id);
			totalAmount = new BigDecimal(payment.getTransactions().get(0).getAmount()
					.getTotal());
			BigDecimal amount = orderInfoService.selectOrderAmountByPurchaseId(purchase_id);
			updateTime = payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getUpdateTime();
			payerId = payment.getPayer().getPayerInfo().getPayerId();
			paymentStatus = payment.getState();
			paymentType = payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getPaymentMode();
			if(null!=payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getTransactionFee()){
				paypalCharge = new BigDecimal(payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getTransactionFee().getValue());
			}
			transactionId = payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId();
			
			logger.info(" totalAmount: " + totalAmount);
			logger.info(" amount: " + amount);
			logger.info(" PaymentStatus: " + payment.getState());
			logger.info(" payment: " + payment);
			if (!PAYPAL_RS_STATE_APPROVED.equals(payment.getState()) || !totalAmount.equals(amount)||!"USD".equals(payment.getTransactions().get(0).getAmount().getCurrency())
					||!PAYPAL_RS_PAYMENT_MODE.equals(payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getPaymentMode())) {
				try {
					logger.error("Verify Payment Not Match!!!");
					if (!totalAmount.equals(amount)) {
						merchantAccount = String.valueOf(amount);
						paymentStatus = "Amount not equal";
						logger.fatal(" Verify Payment Error: " + ErrorCodeEnum.ER1332.getMsg()[0]);
					}else{
						logger.fatal(" Verify Payment Error: " + ErrorCodeEnum.ER1331.getMsg()[0]);						
					}
					transactionDelegate.transactionUpdateAbnormalByPurchaseId(
							Integer.valueOf(PAYPAL_VERIFY_ERROR), purchase_id);
				} catch (Exception ie) {
					logger.fatal("Failed to update abnormal to order_info");
					logger.fatal(ie.toString());
				}
			}
		
		} catch (PayPalRESTException e) {
			logger.fatal("Verify Payment Error:" + e.getMessage());
			merchantAccount = String.valueOf(e.getResponsecode());
			transactionDelegate.transactionUpdateAbnormalByPurchaseId(
					Integer.valueOf(PAYPAL_VERIFY_ERROR), purchase_id);
		} catch (Exception e) {
			logger.fatal("Verify Payment Error:" + e.getMessage());
			if(e.getMessage().length()>30){
				merchantAccount = e.getMessage().substring(0, 30);
			}else{
				merchantAccount = e.getMessage();
			}
			transactionDelegate.transactionUpdateAbnormalByPurchaseId(
					Integer.valueOf(PAYPAL_VERIFY_ERROR), purchase_id);
		}finally{
			OrderPaypal orderPaypal = new OrderPaypal();
			orderPaypal.setMerchantAccount(merchantAccount==null?YamiConstant.STRING_EMPTY:merchantAccount);
			orderPaypal.setOrderSn(String.valueOf(purchase_id));
			orderPaypal.setPayDate(updateTime==null?YamiConstant.STRING_EMPTY:updateTime);
			orderPaypal.setPayerId(payerId==null?YamiConstant.STRING_EMPTY:payerId);
			orderPaypal.setPaymentStatus(paymentStatus==null?YamiConstant.STRING_EMPTY:paymentStatus);
			orderPaypal.setPaymentType(paymentType==null?YamiConstant.STRING_EMPTY:paymentType);
			orderPaypal.setPaypalCharge(paypalCharge);
			orderPaypal.setToken(pay_id);
			orderPaypal.setTotalAmount(totalAmount);
			orderPaypal.setTransactionId(transactionId==null?YamiConstant.STRING_EMPTY:transactionId);
			orderPaypal.setTransactionType(transactionType==null?YamiConstant.STRING_EMPTY:transactionType);
			// Update order_orbital_paypal
			try {
				transactionDelegate.transactionAddOrderPaypal(orderPaypal);
			} catch (Exception e) {
				logger.fatal("Failed to update order_orbital_gateway :"+orderPaypal.getOrderSn());
				logger.fatal(e.toString());
			}
		}
		//logger.info(" PaymentResponse: " + Payment.getLastResponse());
		model.put("status", YamiConstant.STATUS_OK);
		model.put("token", token);
		return model;
	}
	
    public Map<String, Object> setExpressCheckout(String token, Double amount,
			String currency,String source_flg,String language) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		DecimalFormat df1 = new DecimalFormat(YamiConstant.FMT_TWO_DECIMAL_POINT);
		String money = df1.format(amount);

		Gson gson = new Gson();
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		int user_id = Integer.valueOf(tokenIn.getData());
		// ## SetExpressCheckoutReq
		SetExpressCheckoutRequestDetailsType setExpressCheckoutRequestDetails = new SetExpressCheckoutRequestDetailsType();

		// URL to which the buyer's browser is returned after choosing to pay
		// with PayPal. For digital goods, you must add JavaScript to this page
		// to close the in-context experience.
		// `Note:
		// PayPal recommends that the value be the final review page on which
		// the buyer confirms the order and payment or billing agreement.`
		setExpressCheckoutRequestDetails
				.setReturnURL(PAYPAL_RETURN_URL);

		// URL to which the buyer is returned if the buyer does not approve the
		// use of PayPal to pay you. For digital goods, you must add JavaScript
		// to this page to close the in-context experience.
		// `Note:
		// PayPal recommends that the value be the original page on which the
		// buyer chose to pay with PayPal or establish a billing agreement.`
		setExpressCheckoutRequestDetails
				.setCancelURL(PAYPAL_CANCEL_URL);
		if(source_flg!=null && source_flg.equals("2")){
			// request came from PC
			if(language!=null && "en".equals(language)){
				setExpressCheckoutRequestDetails.setReturnURL(PAYPAL_PCRETURN_URL_EN);
				setExpressCheckoutRequestDetails.setCancelURL(PAYPAL_PCCANCEL_URL_EN);
			}else{
				setExpressCheckoutRequestDetails.setReturnURL(PAYPAL_PCRETURN_URL_CN);
				setExpressCheckoutRequestDetails.setCancelURL(PAYPAL_PCCANCEL_URL_CN);				
			}
		}
		// ### Payment Information
		// list of information about the payment
		List<PaymentDetailsType> paymentDetailsList = new ArrayList<PaymentDetailsType>();

		// information about the first payment
		PaymentDetailsType paymentDetails1 = new PaymentDetailsType();

		// Total cost of the transaction to the buyer. If shipping cost and tax
		// charges are known, include them in this value. If not, this value
		// should be the current sub-total of the order.
		//
		// If the transaction includes one or more one-time purchases, this
		// field must be equal to
		// the sum of the purchases. Set this field to 0 if the transaction does
		// not include a one-time purchase such as when you set up a billing
		// agreement for a recurring payment that is not immediately charged.
		// When the field is set to 0, purchase-specific fields are ignored.
		// 
		// * `Currency Code` - You must set the currencyID attribute to one of
		// the
		// 3-character currency codes for any of the supported PayPal
		// currencies.
		// * `Amount`
		BasicAmountType orderTotal1 = new BasicAmountType(CurrencyCodeType.USD,money);
		paymentDetails1.setOrderTotal(orderTotal1);

		// How you want to obtain payment. When implementing parallel payments,
		// this field is required and must be set to `Order`. When implementing
		// digital goods, this field is required and must be set to `Sale`. If
		// the
		// transaction does not include a one-time purchase, this field is
		// ignored. It is one of the following values:
		// 
		// * `Sale` - This is a final sale for which you are requesting payment
		// (default).
		// * `Authorization` - This payment is a basic authorization subject to
		// settlement with PayPal Authorization and Capture.
		// * `Order` - This payment is an order authorization subject to
		// settlement with PayPal Authorization and Capture.
		// `Note:
		// You cannot set this field to Sale in SetExpressCheckout request and
		// then change the value to Authorization or Order in the
		// DoExpressCheckoutPayment request. If you set the field to
		// Authorization or Order in SetExpressCheckout, you may set the field
		// to Sale.`
		paymentDetails1.setPaymentAction(PaymentActionCodeType.SALE);

		// Unique identifier for the merchant. For parallel payments, this field
		// is required and must contain the Payer Id or the email address of the
		// merchant.
		//SellerDetailsType sellerDetails1 = new SellerDetailsType();
		//sellerDetails1.setPayPalAccountID("jb-us-seller@paypal.com");
		//paymentDetails1.setSellerDetails(sellerDetails1);

		// A unique identifier of the specific payment request, which is
		// required for parallel payments.
		//paymentDetails1.setPaymentRequestID("PaymentRequest1");

		// `Address` to which the order is shipped, which takes mandatory
		// params:
		// 
		// * `Street Name`
		// * `City`
		// * `State`
		// * `Country`
		// * `Postal Code`
		//AddressType shipToAddress1 = new AddressType();
		//shipToAddress1.setStreet1("Ape Way");
		//shipToAddress1.setCityName("Austin");
		//shipToAddress1.setStateOrProvince("TX");
		//shipToAddress1.setCountry(CountryCodeType.US);
		//shipToAddress1.setPostalCode("78750");

		// Your URL for receiving Instant Payment Notification (IPN) about this
		// transaction. If you do not specify this value in the request, the
		// notification URL from your Merchant Profile is used, if one exists.
		//paymentDetails1.setNotifyURL("http://localhost/ipn");

		//paymentDetails1.setShipToAddress(shipToAddress1);


		paymentDetailsList.add(paymentDetails1);

		setExpressCheckoutRequestDetails.setPaymentDetails(paymentDetailsList);

		SetExpressCheckoutReq setExpressCheckoutReq = new SetExpressCheckoutReq();
		SetExpressCheckoutRequestType setExpressCheckoutRequest = new SetExpressCheckoutRequestType(
				setExpressCheckoutRequestDetails);

		setExpressCheckoutReq
				.setSetExpressCheckoutRequest(setExpressCheckoutRequest);

		// ## Creating service wrapper object
		// Creating service wrapper object to make API call and loading
		// configuration file for your credentials and endpoint
		PayPalAPIInterfaceServiceService service = null;
		try {
			InputStream is = PaymentServiceDelegate.class.getResourceAsStream(SDK_CONFIGURATION_FILE);
			service = new PayPalAPIInterfaceServiceService(is);
		} catch (IOException e) {
			logger.error("PayPal Get Service Error Message : " + e.getMessage());
			throw new YamiException(YamiConstant.ERRORCODE_ER1401,ErrorCodeEnum.ER1401.getMsg(),e.getMessage());	
		}
		SetExpressCheckoutResponseType setExpressCheckoutResponse = null;
		try {
			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			setExpressCheckoutResponse = service
					.setExpressCheckout(setExpressCheckoutReq);
		} catch (Exception e) {
			logger.error("PayPal SetExpressCheckout Error Message : " + e.getMessage());
			throw new YamiException(YamiConstant.ERRORCODE_ER1402,ErrorCodeEnum.ER1402.getMsg());	
		}
		
		// ## Accessing response parameters
		// You can access the response parameters using getter methods in
		// response object as shown below
		// ### Success values
		if (setExpressCheckoutResponse.getAck().getValue()
				.equalsIgnoreCase(PAYPAL_RESPONSE_ACK_SUCCESS)) {

			// ### Redirecting to PayPal for authorization
			// Once you get the "Success" response, needs to authorise the
			// transaction by making buyer to login into PayPal. For that,
			// need to construct redirect url using EC token from response.
			// For example,
			// `redirectURL="https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="+setExpressCheckoutResponse.getToken();`
			
			// Express Checkout Token
			logger.info("PayPal EC Token:" + setExpressCheckoutResponse.getToken());
			// Delete this user's record from express_checkout
			// Insert record to express_checkout
			//transactionDelegate.transactionSetExpressCheckout(token, user_id, setExpressCheckoutResponse.getToken());
			// Insert record to redis
				ExpressCheckout expressCheckout = new ExpressCheckout();
				expressCheckout.setPayer_id(YamiConstant.STRING_EMPTY);
				expressCheckout.setSession_id(YamiConstant.STRING_EMPTY);
				expressCheckout.setToken(setExpressCheckoutResponse.getToken());
				expressCheckout.setUser_id(user_id);
				String strResult = gson.toJsonTree(expressCheckout).toString();
				redisTemplate4EC.opsForValue().set(YamiConstant.KEY_EXPRESSCHECKOUT_REDIS+":"+user_id, strResult,3600,TimeUnit.SECONDS);
		}
		// ### Error Values
		// Access error values from error list using getter methods
		else {
			List<ErrorType> errorList = setExpressCheckoutResponse.getErrors();
			logger.error("PayPal API Error Message : "
					+ errorList.get(0).getLongMessage());
			throw new YamiException(YamiConstant.ERRORCODE_ER1403,ErrorCodeEnum.ER1403.getMsg(),errorList.get(0).getLongMessage());	
		}
		model.put("status", YamiConstant.STATUS_OK);
		model.put("token", token);
		model.put("ec_token", setExpressCheckoutResponse.getToken());
		logger.info(" model: " + model);
		return model;
	}


	public Map<String, Object> getExpressCheckout(String token) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
 		String ec_token = "";
 		String payer_id = "";
		// ## GetExpressCheckoutDetailsReq
		GetExpressCheckoutDetailsReq getExpressCheckoutDetailsReq = new GetExpressCheckoutDetailsReq();
		ExpressCheckout expressCheckout = new ExpressCheckout();
		
		Gson gson = new Gson();
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		int user_id = Integer.valueOf(tokenIn.getData());

		if(null!=redisTemplate4EC.opsForValue().get(YamiConstant.KEY_EXPRESSCHECKOUT_REDIS+":"+user_id)){
			String sResult = redisTemplate4EC.opsForValue().get(YamiConstant.KEY_EXPRESSCHECKOUT_REDIS+":"+user_id);
			expressCheckout  = gson.fromJson(sResult, ExpressCheckout.class);
			// get token of PayPal.
			if(expressCheckout==null||expressCheckout.getToken().equals(YamiConstant.STRING_EMPTY)){
				throw new YamiException(YamiConstant.ERRORCODE_ER1405,ErrorCodeEnum.ER1405.getMsg());				
			}
			ec_token = expressCheckout.getToken();
		}else{
			throw new YamiException(YamiConstant.ERRORCODE_ER1405,ErrorCodeEnum.ER1405.getMsg());				
		}

		// A timestamped token, the value of which was returned by
		// `SetExpressCheckout` response.
		GetExpressCheckoutDetailsRequestType getExpressCheckoutDetailsRequest = new GetExpressCheckoutDetailsRequestType(
				ec_token);

		getExpressCheckoutDetailsReq
				.setGetExpressCheckoutDetailsRequest(getExpressCheckoutDetailsRequest);

		// ## Creating service wrapper object
		// Creating service wrapper object to make API call and loading
		// configuration file for your credentials and endpoint
		PayPalAPIInterfaceServiceService service = null;
		try {
			InputStream is = PaymentServiceDelegate.class.getResourceAsStream(SDK_CONFIGURATION_FILE);
			service = new PayPalAPIInterfaceServiceService(is);
		} catch (IOException e) {
			logger.error("PayPal Error Message : " + e.getMessage());
			throw new YamiException(YamiConstant.ERRORCODE_ER1401,ErrorCodeEnum.ER1401.getMsg(),e.getMessage());	
		}

		GetExpressCheckoutDetailsResponseType getExpressCheckoutDetailsResponse = null;
		try {
			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			 getExpressCheckoutDetailsResponse = service
					.getExpressCheckoutDetails(getExpressCheckoutDetailsReq);
		} catch (Exception e) {
			logger.error("PayPal Error Message : " + e.getMessage());
			throw new YamiException(YamiConstant.ERRORCODE_ER1402,ErrorCodeEnum.ER1402.getMsg(),e.getMessage());	
		}
		// ## Accessing response parameters
		// You can access the response parameters using getter methods in
		// response object as shown below
		// ### Success values
		if (getExpressCheckoutDetailsResponse.getAck().getValue()
				.equalsIgnoreCase(PAYPAL_RESPONSE_ACK_SUCCESS)) {
			payer_id = getExpressCheckoutDetailsResponse
					.getGetExpressCheckoutDetailsResponseDetails()
					.getPayerInfo().getPayerID();
			if(payer_id==null){
				throw new YamiException(YamiConstant.ERRORCODE_ER1403,ErrorCodeEnum.ER1403.getMsg());				
			}
			//transactionDelegate.transactionGetExpressCheckout(token, user_id, payer_id);
			expressCheckout.setPayer_id(payer_id);
			expressCheckout.setUser_id(user_id);
			String strResult = gson.toJsonTree(expressCheckout).toString();
			redisTemplate4EC.opsForValue().set(YamiConstant.KEY_EXPRESSCHECKOUT_REDIS+":"+user_id, strResult,3600,TimeUnit.SECONDS);
			// Unique PayPal Customer Account identification number. This
			// value will be null unless you authorize the payment by
			// redirecting to PayPal after `SetExpressCheckout` call.
			logger.info("PayPal PayerID : "
					+ getExpressCheckoutDetailsResponse
							.getGetExpressCheckoutDetailsResponseDetails()
							.getPayerInfo().getPayerID());
			logger.info("PayPal Address : "
					+ getExpressCheckoutDetailsResponse
							.getGetExpressCheckoutDetailsResponseDetails()
							.getPayerInfo().getAddress().toXMLString("addr-", "address"));

		}
		// ### Error Values
		// Access error values from error list using getter methods
		else {
			List<ErrorType> errorList = getExpressCheckoutDetailsResponse
					.getErrors();
			logger.error("PayPal API Error Message : "
					+ errorList.get(0).getLongMessage());
			throw new YamiException(YamiConstant.ERRORCODE_ER1403,ErrorCodeEnum.ER1403.getMsg(),errorList.get(0).getLongMessage());	
		}	
		model.put("status", YamiConstant.STATUS_OK);
		model.put("token", token);
		model.put("payer", getExpressCheckoutDetailsResponse
				.getGetExpressCheckoutDetailsResponseDetails()
				.getPayerInfo().getPayer());
		logger.info(" model: " + model);
		return model;
	}
	
	public Map<String, Object> doExpressCheckout(String token, Double amount, String currency, Integer purchase_id) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		DecimalFormat df1 = new DecimalFormat(YamiConstant.FMT_TWO_DECIMAL_POINT);
		String money = df1.format(amount);
 		String ec_token = "";
 		String payer_id = "";
 		
		Gson gson = new Gson();
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		int user_id = Integer.valueOf(tokenIn.getData());
	
		if(null!=redisTemplate4EC.opsForValue().get(YamiConstant.KEY_EXPRESSCHECKOUT_REDIS+":"+user_id)){
			String sResult = redisTemplate4EC.opsForValue().get(YamiConstant.KEY_EXPRESSCHECKOUT_REDIS+":"+user_id);
			ExpressCheckout expressCheckout  = gson.fromJson(sResult, ExpressCheckout.class);
			// get token of PayPal.
			if(expressCheckout==null||expressCheckout.getToken().equals(YamiConstant.STRING_EMPTY)){
				throw new YamiException(YamiConstant.ERRORCODE_ER1405,ErrorCodeEnum.ER1405.getMsg());				
			}
			ec_token = expressCheckout.getToken();
			payer_id = expressCheckout.getPayer_id();
			if(ec_token==null||payer_id==null||payer_id.equals(YamiConstant.STRING_EMPTY)){
				throw new YamiException(YamiConstant.ERRORCODE_ER1402,ErrorCodeEnum.ER1402.getMsg());				
			}
		}else{
			throw new YamiException(YamiConstant.ERRORCODE_ER1405,ErrorCodeEnum.ER1405.getMsg());				
		}

		// ## DoExpressCheckoutPaymentReq
		DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq = new DoExpressCheckoutPaymentReq();

		DoExpressCheckoutPaymentRequestDetailsType doExpressCheckoutPaymentRequestDetails = new DoExpressCheckoutPaymentRequestDetailsType();

		// The timestamped token value that was returned in the
		// `SetExpressCheckout` response and passed in the
		// `GetExpressCheckoutDetails` request.
		doExpressCheckoutPaymentRequestDetails.setToken(ec_token);

		// Unique paypal buyer account identification number as returned in
		// `GetExpressCheckoutDetails` Response
		doExpressCheckoutPaymentRequestDetails.setPayerID(payer_id);

		// ### Payment Information
		// list of information about the payment
		List<PaymentDetailsType> paymentDetailsList = new ArrayList<PaymentDetailsType>();

		// information about the first payment
		PaymentDetailsType paymentDetails1 = new PaymentDetailsType();

		// Total cost of the transaction to the buyer. If shipping cost and tax
		// charges are known, include them in this value. If not, this value
		// should be the current sub-total of the order. 
		// 
		// If the transaction includes one or more one-time purchases, this field must be equal to
		// the sum of the purchases. Set this field to 0 if the transaction does
		// not include a one-time purchase such as when you set up a billing
		// agreement for a recurring payment that is not immediately charged.
		// When the field is set to 0, purchase-specific fields are ignored.
		// 
		// * `Currency Code` - You must set the currencyID attribute to one of the
		// 3-character currency codes for any of the supported PayPal
		// currencies.
		// * `Amount`
		BasicAmountType orderTotal1 = new BasicAmountType(CurrencyCodeType.USD,
				money);
		paymentDetails1.setOrderTotal(orderTotal1);
		paymentDetails1.setOrderDescription("Purchase# " + String.valueOf(purchase_id));

		// How you want to obtain payment. When implementing parallel payments,
		// this field is required and must be set to `Order`. When implementing
		// digital goods, this field is required and must be set to `Sale`. If the
		// transaction does not include a one-time purchase, this field is
		// ignored. It is one of the following values:
		// 
		// * `Sale` - This is a final sale for which you are requesting payment
		// (default).
		// * `Authorization` - This payment is a basic authorization subject to
		// settlement with PayPal Authorization and Capture.
		// * `Order` - This payment is an order authorization subject to
		// settlement with PayPal Authorization and Capture.
		// Note:
		// You cannot set this field to Sale in SetExpressCheckout request and
		// then change the value to Authorization or Order in the
		// DoExpressCheckoutPayment request. If you set the field to
		// Authorization or Order in SetExpressCheckout, you may set the field
		// to Sale.
		paymentDetails1.setPaymentAction(PaymentActionCodeType.SALE);

		// Unique identifier for the merchant. For parallel payments, this field
		// is required and must contain the Payer Id or the email address of the
		// merchant.
		//SellerDetailsType sellerDetails1 = new SellerDetailsType();
		//sellerDetails1.setPayPalAccountID("jb-us-seller@paypal.com");
		//paymentDetails1.setSellerDetails(sellerDetails1);

		// A unique identifier of the specific payment request, which is
		// required for parallel payments.
		//paymentDetails1.setPaymentRequestID("PaymentRequest1");
		
		// Your URL for receiving Instant Payment Notification (IPN) about this transaction. If you do not specify this value in the request, the notification URL from your Merchant Profile is used, if one exists.
		//paymentDetails1.setNotifyURL("http://localhost/ipn");
		
		paymentDetailsList.add(paymentDetails1);
		doExpressCheckoutPaymentRequestDetails
				.setPaymentDetails(paymentDetailsList);
		DoExpressCheckoutPaymentRequestType doExpressCheckoutPaymentRequest = new DoExpressCheckoutPaymentRequestType(
				doExpressCheckoutPaymentRequestDetails);
		doExpressCheckoutPaymentReq
				.setDoExpressCheckoutPaymentRequest(doExpressCheckoutPaymentRequest);

		// ## Creating service wrapper object
		// Creating service wrapper object to make API call and loading
		// configuration file for your credentials and endpoint
		PayPalAPIInterfaceServiceService service = null;
		try {
			InputStream is = PaymentServiceDelegate.class.getResourceAsStream(SDK_CONFIGURATION_FILE);
			service = new PayPalAPIInterfaceServiceService(is);
		} catch (IOException e) {
			logger.fatal("PayPal Error Message : " + e.getMessage());
			if("Read timed out".equals(e.getMessage())){
				transactionDelegate.transactionUpdateAbnormalByPurchaseId(
						Integer.valueOf(PAYPAL_TIMEOUT_ERROR), purchase_id);
				throw new YamiException(YamiConstant.ERRORCODE_ER1406,ErrorCodeEnum.ER1406.getMsg(),e.getMessage());
			}else{
				throw new YamiException(YamiConstant.ERRORCODE_ER1401,ErrorCodeEnum.ER1401.getMsg(),e.getMessage());
			}
		}
		DoExpressCheckoutPaymentResponseType doExpressCheckoutPaymentResponse = null;
		try {
			// ## Making API call
			// Invoke the appropriate method corresponding to API in service
			// wrapper object
			 doExpressCheckoutPaymentResponse = service
					.doExpressCheckoutPayment(doExpressCheckoutPaymentReq);
		} catch (Exception e) {
			logger.error("PayPal Error Message : " + e.getMessage());
			throw new YamiException(YamiConstant.ERRORCODE_ER1402,ErrorCodeEnum.ER1402.getMsg(),e.getMessage());	
		}

		// ## Accessing response parameters
		// You can access the response parameters using getter methods in
		// response object as shown below
		// ### Success values
		if (doExpressCheckoutPaymentResponse.getAck().getValue()
				.equalsIgnoreCase(PAYPAL_RESPONSE_ACK_SUCCESS)) {

			// Transaction identification number of the transaction that was
			// created.
			// This field is only returned after a successful transaction
			// for DoExpressCheckout has occurred.
			if (doExpressCheckoutPaymentResponse
					.getDoExpressCheckoutPaymentResponseDetails()
					.getPaymentInfo() != null) {
				Iterator<PaymentInfoType> paymentInfoIterator = doExpressCheckoutPaymentResponse
						.getDoExpressCheckoutPaymentResponseDetails()
						.getPaymentInfo().iterator();
				while (paymentInfoIterator.hasNext()) {
					PaymentInfoType paymentInfo = paymentInfoIterator
							.next();
					logger.info("PayPal Transaction ID : "
							+ paymentInfo.getTransactionID());
				}
			}
		}
		// ### Error Values
		// Access error values from error list using getter methods
		else {
			List<ErrorType> errorList = doExpressCheckoutPaymentResponse
					.getErrors();
			logger.error("PayPal API Error Message : "
					+ errorList.get(0).getLongMessage());
			if (PAYPAL_ERRORCODE_11607.equals(errorList.get(0).getErrorCode())) {
				throw new YamiException(YamiConstant.ERRORCODE_ER1404,ErrorCodeEnum.ER1404.getMsg());
			} else {
				throw new YamiException(YamiConstant.ERRORCODE_ER1403,ErrorCodeEnum.ER1403.getMsg(),errorList.get(0).getLongMessage());
			}
		}
		PaymentInfoType paymentInfo =  doExpressCheckoutPaymentResponse.getDoExpressCheckoutPaymentResponseDetails().getPaymentInfo().get(0); 
		try {
			logger.info(" paymentInfo: " + JSONFormatter.toJSON(paymentInfo));
		} catch (Exception e) {
			logger.error("doExpressCheckout Response toJSON Error Message : " + e.getMessage());
		}
		OrderPaypal orderPaypal = new OrderPaypal();
		orderPaypal.setMerchantAccount(paymentInfo.getSellerDetails().getSecureMerchantAccountID());
		orderPaypal.setOrderSn(String.valueOf(purchase_id));
		orderPaypal.setPayDate(paymentInfo.getPaymentDate());
		orderPaypal.setPayerId(payer_id);
		orderPaypal.setPaymentStatus(paymentInfo.getPaymentStatus().getValue());
		orderPaypal.setPaymentType(paymentInfo.getPaymentType().getValue());
		orderPaypal.setPaypalCharge(new BigDecimal(paymentInfo.getFeeAmount().getValue()));
		orderPaypal.setToken(ec_token);
		orderPaypal.setTotalAmount(new BigDecimal(paymentInfo.getGrossAmount().getValue()));
		orderPaypal.setTransactionId(paymentInfo.getTransactionID());
		orderPaypal.setTransactionType(paymentInfo.getTransactionType().getValue());
		// Update order_orbital_paypal
		try {
			transactionDelegate.transactionAddOrderPaypal(orderPaypal);
		} catch (Exception e) {
			logger.fatal("Failed to update order_orbital_gateway :"+orderPaypal.getOrderSn());
			logger.fatal(e.toString());
		}
    	String redisKey = YamiConstant.KEY_EXPRESSCHECKOUT_REDIS+":"+user_id;
    	redisTemplate4EC.delete(redisKey);
		model.put("status", YamiConstant.STATUS_OK);
		model.put("token", token);
		logger.info(" model: " + model);
		return model;
	}
	
	
	
}
