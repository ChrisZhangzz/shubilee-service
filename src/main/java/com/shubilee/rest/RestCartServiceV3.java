package com.shubilee.rest;

import java.util.Map;














import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;














import com.shubilee.common.NeedLogin;
import com.shubilee.delegate.CartServiceDelegateV3;
import com.shubilee.delegate.TransactionDelegate;


@Service
@Path("/cartV3")
public class RestCartServiceV3 {

	@Autowired
	private CartServiceDelegateV3 cartServicedelegateV3;
	@Autowired
	private TransactionDelegate transactionDelegate;

	@GET
	@Path("/addToCart")
	@Produces("application/json;charset=utf-8")
	public Response addToCart(@QueryParam("token") String token,@QueryParam("gid") int gid,@QueryParam("add_number") String add_number,@QueryParam("is_gift") int is_gift)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.addItemToCart(token, gid, add_number, is_gift);
		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@Path("/quantityChange")
	@Produces("application/json;charset=utf-8")
	public Response quantityChange(@QueryParam("token") String token,@QueryParam("vendor_id") int vendor_id,@QueryParam("gid") int gid,@QueryParam("num") int num)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.quantityChange(token, vendor_id,gid, num);
		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@Path("/miniCart")
	@Produces("application/json;charset=utf-8")
	public Response miniCart(@QueryParam("token") String token)throws Exception {
		Map<String,Object> result = cartServicedelegateV3.miniCart(token);
		return Response.status(Status.OK).entity(result).build();

	}
	@GET
	@Path("/viewCart")
	@Produces("application/json;charset=utf-8")
	public Response viewCart(@QueryParam("token") String token,@QueryParam("zip") String zip)throws Exception {
		Map<String,Object> result = cartServicedelegateV3.viewCart(token,zip);
		return Response.status(Status.OK).entity(result).build();

	}

	@GET
	@NeedLogin
	@Path("/checkout")
	@Produces("application/json;charset=utf-8")
	public Response checkout(@QueryParam("token") String token)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.checkoutV3(token);
		return Response.status(Status.OK).entity(result).build();

	}  
	@GET
	@Path("/promoCode")
	@Produces("application/json;charset=utf-8")
	public Response promoCode(@QueryParam("token") String token,@QueryParam("code") String code)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.promoCode(token,code);
		return Response.status(200).entity(result).build();

	}
	@GET
	@Path("/cancelCode")
	@Produces("application/json;charset=utf-8")
	public Response cancelCode(@QueryParam("token") String token)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.cancelCode(token);
		return Response.status(200).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/getOrderInfo")
	@Produces("application/json;charset=utf-8")
	public Response getOrderInfo(@QueryParam("token") String token)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.getOrderInfo(token);
		return Response.status(200).entity(result).build();

	}
	@GET
	@Path("/getShippingList")
	@Produces("application/json;charset=utf-8")
	public Response getShippingList(@QueryParam("token") String token)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.getShippingListV3(token);
		return Response.status(200).entity(result).build();

	}
	@GET
	@Path("/getVendorShipping")
	@Produces("application/json;charset=utf-8")
	public Response getVendorShipping(@QueryParam("token") String token,@QueryParam("vendor_id") int vendor_id)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.getVendorShippingV3(token,vendor_id);
		return Response.status(200).entity(result).build();

	}
	@GET
	@Path("/getVendorShippingFreeAmount")
	@Produces("application/json;charset=utf-8")
	public Response getVendorShippingFreeAmount(@QueryParam("token") String token,@QueryParam("vendor_id") int vendor_id)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.getVendorShippingFreeAmount(token,vendor_id);
		return Response.status(200).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/chooseShipping")
	@Produces("application/json;charset=utf-8")
	public Response chooseShipping(@QueryParam("token") String token,@QueryParam("vendor_id") int vendor_id,@QueryParam("shipping_id") int shipping_id)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.chooseShipping(token,shipping_id,vendor_id);
		return Response.status(200).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/spendPoints")
	@Produces("application/json;charset=utf-8")
	public Response spendPoints(@QueryParam("token") String token,@QueryParam("is_on") int is_on)throws Exception{
		Map<String,Object> result = cartServicedelegateV3.spendPoints(token, is_on);
		return Response.status(200).entity(result).build();

	}
	@GET
	@Path("/getCartGoodsNum")
	@Produces("application/json;charset=utf-8")
	public Response getCartGoodsNum(@QueryParam("token") String token)throws Exception{
		Map<String,Object> result = cartServicedelegateV3.getCartGoodsNum(token);
		return Response.status(200).entity(result).build();

	}

	@GET
	@NeedLogin
	@Path("/choosePayment")
	@Produces("application/json;charset=utf-8")
	public Response choosePayment(@QueryParam("token") String token,@QueryParam("profile_id") String profile_id)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.choosePayment(token,profile_id);
		return Response.status(200).entity(result).build();

	}

	@GET
	@NeedLogin
	@Path("/chooseAddress")
	@Produces("application/json;charset=utf-8")
	public Response chooseAddress(@QueryParam("token") String token,@QueryParam("address_id") int address_id)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.chooseAddress(token,address_id);
		return Response.status(200).entity(result).build();

	}
	
	@GET
	@NeedLogin
	@Path("/getErrorItemsOfCart")
	@Produces("application/json;charset=utf-8")
	public Response getErrorItemsOfCart(@QueryParam("token") String token,@QueryParam("zip") String zip)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.getErrorItemsOfCart(token,zip);
		return Response.status(200).entity(result).build();

	}
	@GET
	@NeedLogin
	@Path("/moveErrorItemsOfCartToFav")
	@Produces("application/json;charset=utf-8")
	public Response moveErrorItemsOfCartToFav(@QueryParam("token") String token,@QueryParam("zip") String zip)throws Exception{

		Map<String,Object> result = cartServicedelegateV3.moveCartErrorItemsToFav(token,zip);
		return Response.status(200).entity(result).build();

	}
	
	
	
	
}
