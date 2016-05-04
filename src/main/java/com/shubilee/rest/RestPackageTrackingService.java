package com.shubilee.rest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.stereotype.Service;

import com.shubilee.delegate.UpsServiceDelegate;
import com.shubilee.delegate.UserServiceDelegate;
import com.shubilee.delegate.UspsServiceDelegate;

@Service
@Path("/utilities")
public class RestPackageTrackingService {
	
	@Autowired
	private UpsServiceDelegate upsServiceDelegate;
	@Autowired
	private UspsServiceDelegate uspsServiceDelegate;
	
	
	@GET
	@Path("/UPSTrackingService")
	@Produces("application/json;charset=utf-8")
	public Response upsTrackingService(@QueryParam("tracking_number") String tracking_number) throws Exception {

		Map<String, Object> result = upsServiceDelegate.upsTrackingService(tracking_number);

		return Response.status(Status.OK).entity(result).build();

	}
	
	@GET
	@Path("/USPSTrackingService")
	@Produces("application/json;charset=utf-8")
	public Response uspsTrackingService(@QueryParam("tracking_number") String tracking_number) throws Exception {

		Map<String, Object> result = uspsServiceDelegate.uspsTrackingService(tracking_number);

		return Response.status(Status.OK).entity(result).build();

	}	
	
	@GET
	@Path("/testusps")
	@Produces("application/json;charset=utf-8")
	public Response testusps(@QueryParam("tracking_number") String tracking_number) throws Exception {

		uspsServiceDelegate.testAddress();

		return Response.status(Status.OK).entity(null).build();

	}	
	
	
	
	
	
}
