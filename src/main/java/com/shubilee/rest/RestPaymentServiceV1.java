package com.shubilee.rest;


import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.NeedLogin;
import com.shubilee.delegate.OrderServiceDelegate;
import com.shubilee.delegate.OrderServiceDelegateV2;
import com.shubilee.delegate.PaymentServiceDelegate;


@Service
@Path("/pay")
public class RestPaymentServiceV1 {
	@Autowired
	private PaymentServiceDelegate paymentServiceDelegate;
	@Autowired
	private OrderServiceDelegateV2 orderServiceDelegateV2;
	@GET
	@NeedLogin
	@Path("/doPayment")
	@Produces("application/json")
	public Response doPayment(@QueryParam("token") String token,
			@QueryParam("profile_id") String profile_id,
			@QueryParam("purchase_id") String purchase_id, @QueryParam("csc") String csc,
			@QueryParam("amount") Double amount, @QueryParam("currency") String currency)
			throws Exception {

		Map<String, Object> result = paymentServiceDelegate.doPayment(token, profile_id,
				purchase_id, csc, amount, currency);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/submitOrder")
	@Produces("application/json")
	public Response submitOrder(@QueryParam("token") String token,@QueryParam("amount") String amount,@Context HttpServletRequest req,@QueryParam("ip_address") String ip_address,@QueryParam("source_flag") int source_flag,@QueryParam("lang") Integer lang)throws Exception {
		Map<String, Object> result;
		if(ip_address!=null){
			 result = orderServiceDelegateV2.submitOrder(token,amount,ip_address, req.getHeader("user-agent"),source_flag,lang);
        }else{
        	 result = orderServiceDelegateV2.submitOrder(token,amount,req.getHeader("CF-Connecting-IP"), req.getHeader("user-agent"),source_flag,lang);
        }
		
		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/finishOrder")
	@Produces("application/json")
	public Response finishOrder(@QueryParam("token") String token,@QueryParam("purchase_id") String purchase_id,@QueryParam("secret") String secret)throws Exception {

		Map<String, Object> result = orderServiceDelegateV2.finishOrder(token,purchase_id,secret);
		return Response.status(Status.OK).entity(result).build();

	}

	@GET
	@NeedLogin
	@Path("/verifyPayment")
	@Produces("application/json")
	public Response verifyPayment(@QueryParam("token") String token,
			@QueryParam("pay_id") String pay_id, @QueryParam("purchase_id") int purchase_id)
			throws Exception {

		Map<String, Object> result = paymentServiceDelegate.verifyPayment(token, pay_id, purchase_id);

		return Response.status(Status.OK).entity(result).build();

	}	
	
	@GET
	@NeedLogin
	@Path("/setExpressCheckout")
	@Produces("application/json")
	public Response setExpressCheckout(@QueryParam("token") String token,
			@QueryParam("amount") Double amount, @QueryParam("currency") String currency,@QueryParam("source_flag") String source_flag,@QueryParam("language") String language)
			throws Exception {


		Map<String, Object> result = paymentServiceDelegate.setExpressCheckout(token, amount, currency, source_flag, language);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/getExpressCheckout")
	@Produces("application/json")
	public Response getExpressCheckout(@QueryParam("token") String token) throws Exception {

		Map<String, Object> result = paymentServiceDelegate.getExpressCheckout(token);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/doExpressCheckout")
	@Produces("application/json")
	public Response doExpressCheckout(@QueryParam("token") String token, @QueryParam("amount") Double amount,
			@QueryParam("currency") String currency, @QueryParam("purchase_id") Integer purchase_id) throws Exception {

		Map<String, Object> result = paymentServiceDelegate.doExpressCheckout(token,
				amount, currency, purchase_id);

		return Response.status(Status.OK).entity(result).build();

	}
	
}
