package com.shubilee.rest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.google.gson.Gson;
import com.shubilee.common.ErrorCodeEnum;
import com.shubilee.common.NeedLogin;
import com.shubilee.common.RedisUtil;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.common.YamiException;
import com.shubilee.delegate.GoodsServiceDelegate;
import com.shubilee.delegate.TransactionDelegate;
import com.shubilee.entity.SearchBar;
import com.shubilee.redis.entity.CartRedis;
@Service
@Path("/items")
public class RestGoodsService {
	@Autowired private RedisTemplate<String,String> redisTemplate;
	@Autowired
	private GoodsServiceDelegate goodsServicedelegate;
	@Autowired
	private TransactionDelegate transactionDelegate;

	private Logger logger = LogManager.getLogger(this.getClass().getName());
	
	@GET
	@Path("/getCatNewItems")
	@Produces("application/json;charset=utf-8")
	public Response getCatNewItems(@QueryParam("token") String token,@QueryParam("channel") int channel,@QueryParam("cat_id") int cat_id,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent) {
		Map<String, Object> result;
		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
	    result = goodsServicedelegate.selectCatNewItems(token,channel,cat_id, pageSet.get("start"), pageSet.get("length"));
	    result.put("page", page);
		return Response.status(Status.OK).entity(result).build();
	}
	
	
	@GET
	@Path("/getNewItems")
	@Produces("application/json;charset=utf-8")
	public Response getNewItems(@QueryParam("token") String token,@QueryParam("channel") int channel,@QueryParam("source") int source,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent) {
		Map<String, Object> result;
		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
	    result = goodsServicedelegate.selectNewItems(token,source,channel, pageSet.get("start"), pageSet.get("length"));
	    result.put("page", page);
		return Response.status(Status.OK).entity(result).build();
	}
	
		
	@GET
	@Path("/getFlashItems")
	@Produces("application/json;charset=utf-8")
	public Response getFlashItems(@QueryParam("token") String token,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent) {
		Map<String,Object> result;
		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
	    result = goodsServicedelegate.getFlashItems(token,  pageSet.get("start"), pageSet.get("length"));
	    result.put("page", page);
		return Response.status(Status.OK).entity(result).build();
	}
	
	
	@GET
	@Path("/getItemComments")
	@Produces("application/json;charset=utf-8")
	public Response getItemComments(@QueryParam("token") String token,@QueryParam("gid") int gid,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent) {
		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
		Map<String,Object>  result = goodsServicedelegate.getItemComments(token, gid,  pageSet.get("start"), pageSet.get("length"));
		result.put("page", page);
		return Response.status(Status.OK).entity(result).build();
	}
	
	@GET
	@Path("/getCatKeywords")
	@Produces("application/json;charset=utf-8")
	public Response getCatKeywords(@QueryParam("token") String token,@QueryParam("cat_id") int cat_id,@QueryParam("priority") int priority,@QueryParam("count") int count) {
		Map<String,Object> result;
	    result = goodsServicedelegate.getCatKeywords(token, cat_id, priority, count);
		return Response.status(Status.OK).entity(result).build();
	}
	//获取item商品信息
	
	@Value("${KEY_GETITEMINFO_REDIS}")
	private String KEY_GETITEMINFO_REDIS;
	@Value("${KEY_GETITEMINFO_REDIS_TIMEOUT}")
	private Integer KEY_GETITEMINFO_REDIS_TIMEOUT;
	@Value("${KEY_GETITEMINFO_REDIS_USE_FLAG}")
	private Integer KEY_GETITEMINFO_REDIS_USE_FLAG;
	
	@GET
	@Path("/getItemInfo")
	@Produces("application/json;charset=utf-8")
	public Response getItemInfo(@QueryParam("token") String token,@QueryParam("gid") String gid) throws Exception {		
		Integer goodsId=0;
		try {
			goodsId = Integer.valueOf(gid);
		} catch (Exception e) {
			logger.error("Catch Exception = " + e.toString());
			throw new YamiException(YamiConstant.ERRORCODE_ER1006,ErrorCodeEnum.ER1006.getMsg());
		}
		Gson gson = new Gson();
		if(KEY_GETITEMINFO_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.selectGoodsByid(token,goodsId);
			 return Response.status(Status.OK).entity(result).build();
		}
		else {
			if(null==redisTemplate.opsForValue().get(KEY_GETITEMINFO_REDIS+gid)){
				Map<String,Object>  result = goodsServicedelegate.selectGoodsByid(token,goodsId);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_GETITEMINFO_REDIS+gid, strResult,KEY_GETITEMINFO_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETITEMINFO_REDIS+gid)).build();
				
			}
		}
	}
	@Value("${KEY_CATITEMS_REDIS}")
	private String KEY_CATITEMS_REDIS;
	@Value("${KEY_CATITEMS_REDIS_TIMEOUT}")
	private Integer KEY_CATITEMS_REDIS_TIMEOUT;
	@Value("${KEY_CATITEMS_REDIS_USE_FLAG}")
	private Integer KEY_CATITEMS_REDIS_USE_FLAG;
	@GET
	@Path("/getCatItems")
	@Produces("application/json;charset=utf-8")
	public Response getCatItems(@QueryParam("token") String token,@QueryParam("cat_id") String cat_id,@QueryParam("sort_by") String sort_by,@QueryParam("sort_order") String sort_order
			,@QueryParam("brands") String brand_id,@QueryParam("is_promote") String is_promote,@QueryParam("page") String page,
			@HeaderParam("User-Agent") String agent) {	
			Gson gson = new Gson();
			Integer cat_id_=0;
			Integer sort_by_=0;
			Integer sort_order_=0;
			Integer is_promote_=0;
			Integer page_=0;
			try {
				cat_id_ = Integer.valueOf(cat_id);
				sort_by_ = Integer.valueOf(sort_by);
				sort_order_ = sort_order==null?0:Integer.valueOf(sort_order);
				is_promote_ = Integer.valueOf(is_promote);
				page_ = Integer.valueOf(page);
			} catch (Exception e) {
				logger.error("Catch Exception = " + e.toString());
				throw new YamiException(YamiConstant.ERRORCODE_ER1006,ErrorCodeEnum.ER1006.getMsg());
			}
			
			if(KEY_CATITEMS_REDIS_USE_FLAG.intValue()==0){
				Map<String,Object> result = goodsServicedelegate.selectCatItems(token,cat_id_,sort_by_,sort_order_,is_promote_,page_, brand_id,agent);
				 return Response.status(Status.OK).entity(result).build();
			}
			else{
				if(null==redisTemplate.opsForValue().get(KEY_CATITEMS_REDIS+cat_id+"|"+cat_id+"|"+sort_by+"|"+sort_order+"|"+brand_id+"|"+is_promote+"|"+page)){
					Map<String,Object>   result = goodsServicedelegate.selectCatItems(token,cat_id_,sort_by_,sort_order_,is_promote_,page_, brand_id,agent);
					String strResult = gson.toJsonTree(result).toString();
					redisTemplate.opsForValue().set(KEY_CATITEMS_REDIS+cat_id+"|"+cat_id+"|"+sort_by+"|"+sort_order+"|"+brand_id+"|"+is_promote+"|"+page, strResult,KEY_CATITEMS_REDIS_TIMEOUT,TimeUnit.HOURS);
				    return Response.status(Status.OK).entity(result).build();
		
				}else{
					return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_CATITEMS_REDIS+cat_id+"|"+cat_id+"|"+sort_by+"|"+sort_order+"|"+brand_id+"|"+is_promote+"|"+page)).build();
					
				}	
			}

		}
	
	@Value("${KEY_SHOWCATEGORY_REDIS}")
	private String KEY_SHOWCATEGORY_REDIS;
	@Value("${KEY_SHOWCATEGORY_REDIS_TIMEOUT}")
	private Integer KEY_SHOWCATEGORY_REDIS_TIMEOUT;
	@Value("${KEY_SHOWCATEGORY_REDIS_USE_FLAG}")
	private Integer KEY_SHOWCATEGORY_REDIS_USE_FLAG;
	
	@GET
	@Path("/showCategory")
	@Produces("application/json;charset=utf-8")
	public Response showCategory(@QueryParam("token") String token) {
		Gson gson = new Gson();
		if(KEY_SHOWCATEGORY_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.selectShowCategory(token);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_SHOWCATEGORY_REDIS)){
				Map<String,Object>  result = goodsServicedelegate.selectShowCategory(token);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_SHOWCATEGORY_REDIS, strResult,KEY_SHOWCATEGORY_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
	
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_SHOWCATEGORY_REDIS)).build();
				
			}
		}
		
	}
	
	@Value("${KEY_CATBRANDS_REDIS}")
	private String KEY_CATBRANDS_REDIS;
	@Value("${KEY_CATBRANDS_REDIS_TIMEOUT}")
	private Integer KEY_CATBRANDS_REDIS_TIMEOUT;
	@Value("${KEY_CATBRANDS_REDIS_USE_FLAG}")
	private Integer KEY_CATBRANDS_REDIS_USE_FLAG;
	@GET
	@Path("/getCatBrands")
	@Produces("application/json;charset=utf-8")
	public Response getCatBrands(@QueryParam("token") String token,@QueryParam("cat_id") int cat_id) {
		Gson gson = new Gson();
		if(KEY_CATBRANDS_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.selectCatBrands(token,cat_id);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_CATBRANDS_REDIS+cat_id)){
				Map<String,Object> result = goodsServicedelegate.selectCatBrands(token,cat_id);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_CATBRANDS_REDIS+cat_id, strResult,KEY_CATBRANDS_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
	
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_CATBRANDS_REDIS+cat_id)).build();
			}
		}
	}
	
	@Value("${KEY_GETINDEXINFO_REDIS}")
	private String KEY_GETINDEXINFO_REDIS;
	@Value("${KEY_GETINDEXINFO_REDIS_TIMEOUT}")
	private Integer KEY_GETINDEXINFO_REDIS_TIMEOUT;
	@Value("${KEY_GETINDEXINFO_REDIS_USE_FLAG}")
	private Integer KEY_GETINDEXINFO_REDIS_USE_FLAG;
	@GET
	@Path("/getIndexInfo")
	@Produces("application/json;charset=utf-8")
	public Response getIndexInfo(@QueryParam("token") String token)throws Exception {
		Gson gson = new Gson();
		if(KEY_GETINDEXINFO_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.getIndexInfo(token);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_GETINDEXINFO_REDIS)){
				Map<String,Object>  result = goodsServicedelegate.getIndexInfo(token);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_GETINDEXINFO_REDIS, strResult,KEY_GETINDEXINFO_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETINDEXINFO_REDIS)).build();	
			}
		}
	}
	
	@GET
	@Path("/getWeekItems")
	@Produces("application/json;charset=utf-8")
	public Response getWeekItems(@QueryParam("token") String token,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent)throws Exception {
		Map<String,Object> result;
		Map<String,Integer> pageSet = StringUtil.GetClientType(page, agent);
	    result = goodsServicedelegate.getWeekItems(token, pageSet.get("start"), pageSet.get("length"));
	    result.put("page", page);
		return Response.status(Status.OK).entity(result).build();
	}
	
	@GET
	@Path("/getPromoteItems")
	@Produces("application/json;charset=utf-8")
	public Response getPromoteItems(@QueryParam("token") String token,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent)throws Exception {
		Map<String,Object> result;
		Map<String,Integer> pageSet = StringUtil.GetClientTypeForPromoteItems(page,agent);
	    result = goodsServicedelegate.getPromoteItems(token, pageSet.get("start"), pageSet.get("length"));
	    result.put("page", page);
		return Response.status(Status.OK).entity(result).build();
	}
	
	
	@GET
	@Path("/getPromoteItemsV2")
	@Produces("application/json;charset=utf-8")
	public Response getPromoteItemsV2(@QueryParam("token") String token,@QueryParam("cat_id") Integer cat_id,@QueryParam("sort_by") Integer sort_by,
			@QueryParam("sort_order") Integer sort_order,@QueryParam("page") int page,@HeaderParam("User-Agent") String agent)throws Exception {
		Map<String,Object> result;
		Map<String,Integer> pageSet = StringUtil.GetClientTypeForPromoteItems(page,agent);
	    result = goodsServicedelegate.getPromoteItemsV2(token, cat_id, sort_by, sort_order, pageSet.get("start"), pageSet.get("length"));
	    result.put("page", page);
		return Response.status(Status.OK).entity(result).build();
	}
	
	@Value("${KEY_GETEXPLOREINFO_REDIS}")
	private String KEY_GETEXPLOREINFO_REDIS;
	@Value("${KEY_GETEXPLOREINFO_REDIS_TIMEOUT}")
	private Integer KEY_GETEXPLOREINFO_REDIS_TIMEOUT;
	@Value("${KEY_GETEXPLOREINFO_REDIS_USE_FLAG}")
	private Integer KEY_GETEXPLOREINFO_REDIS_USE_FLAG;
	
	@GET
	@Path("/getExploreInfo")
	@Produces("application/json;charset=utf-8")
	public Response getExploreInfo(@QueryParam("token") String token)throws Exception {

		Gson gson = new Gson();
		if(KEY_GETEXPLOREINFO_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.getExploreInfo(token);
			 return Response.status(Status.OK).entity(result).build();
		}
		if(null==redisTemplate.opsForValue().get(KEY_GETEXPLOREINFO_REDIS)){
			Map<String,Object>  result = goodsServicedelegate.getExploreInfo(token);
			String strResult = gson.toJsonTree(result).toString();
			redisTemplate.opsForValue().set(KEY_GETEXPLOREINFO_REDIS, strResult,KEY_GETEXPLOREINFO_REDIS_TIMEOUT,TimeUnit.HOURS);
		    return Response.status(Status.OK).entity(result).build();

		}else{
			return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETEXPLOREINFO_REDIS)).build();
			
		}
	}
	
	@Value("${KEY_GETCHANNELINFO_REDIS}")
	private String KEY_GETCHANNELINFO_REDIS;
	@Value("${KEY_GETCHANNELINFO_REDIS_TIMEOUT}")
	private Integer KEY_GETCHANNELINFO_REDIS_TIMEOUT;
	@Value("${KEY_GETCHANNELINFO_REDIS_USE_FLAG}")
	private Integer KEY_GETCHANNELINFO_REDIS_USE_FLAG;
	
	@GET
	@Path("/getChannelInfo")
	@Produces("application/json;charset=utf-8")
	public Response getChannelInfo(@QueryParam("token") String token,@QueryParam("channel") int channel)throws Exception {
		Gson gson = new Gson();
		if(KEY_GETCHANNELINFO_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.getExploreInfo(token);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_GETCHANNELINFO_REDIS+String.valueOf(channel))){
				Map<String,Object>  result = goodsServicedelegate.getChannelInfo(token,channel);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_GETCHANNELINFO_REDIS+String.valueOf(channel), strResult,KEY_GETCHANNELINFO_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
	
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETCHANNELINFO_REDIS+String.valueOf(channel))).build();
				
			}
		}

	}
	
	@Value("${KEY_GETHOTITEMS_REDIS}")
	private String KEY_GETHOTITEMS_REDIS;
	@Value("${KEY_GETHOTITEMS_REDIS_TIMEOUT}")
	private Integer KEY_GETHOTITEMS_REDIS_TIMEOUT;
	@Value("${KEY_GETHOTITEMS_REDIS_USE_FLAG}")
	private Integer KEY_GETHOTITEMS_REDIS_USE_FLAG;
	@GET
	@Path("/getHotItems")
	@Produces("application/json;charset=utf-8")
	public Response getHotItems(@QueryParam("token") String token,@QueryParam("channel") int channel) throws IOException 
	{
		Gson gson = new Gson();
		if(KEY_GETHOTITEMS_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.selectHotItems(token, channel);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_GETHOTITEMS_REDIS+String.valueOf(channel))){
				Map<String,Object>  result = goodsServicedelegate.selectHotItems(token, channel);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_GETHOTITEMS_REDIS+String.valueOf(channel), strResult,KEY_GETHOTITEMS_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
	
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETHOTITEMS_REDIS+String.valueOf(channel))).build();
				
			}
		}
	}
	
	@GET
	@Path("/getViewedItems")
	@Produces("application/json;charset=utf-8")
	public Response getViewedItems(@QueryParam("token") String token,@QueryParam("gids") String gids) throws IOException 
	{
		Map<String, Object> result;
		
		result = goodsServicedelegate.selectViewedItems(token,gids);
		return Response.status(Status.OK).entity(result).build();
	}
	
	@Value("${KEY_GETINDEXINFODKP_REDIS}")
	private String KEY_GETINDEXINFODKP_REDIS;
	@Value("${KEY_GETINDEXINFODKP_REDIS_TIMEOUT}")
	private Integer KEY_GETINDEXINFODKP_REDIS_TIMEOUT;
	@Value("${KEY_GETINDEXINFODKP_REDIS_USE_FLAG}")
	private Integer KEY_GETINDEXINFODKP_REDIS_USE_FLAG;
	
	@GET
	@Path("/getIndexInfoDkp")
	@Produces("application/json;charset=utf-8")
	public Response getIndexInfoDkp(@QueryParam("token") String token) {
		Gson gson = new Gson();
		if(KEY_GETINDEXINFODKP_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.getIndexInfoDkp(token);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_GETINDEXINFODKP_REDIS)){
				Map<String,Object>  result = goodsServicedelegate.getIndexInfoDkp(token);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_GETINDEXINFODKP_REDIS, strResult,1,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETINDEXINFODKP_REDIS)).build();	
			}
		}
	}
	@Value("${KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS}")
	private String KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS;
	@Value("${KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS_TIMEOUT}")
	private Integer KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS_TIMEOUT;
	@Value("${KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS_USE_FLAG}")
	private Integer KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS_USE_FLAG;
	@GET
	@Path("/getChannelBeautyInfoDkp")
	@Produces("application/json;charset=utf-8")
	public Response getChannelBeautyInfoDkp(@QueryParam("token") String token) {
		Gson gson = new Gson();
		if(KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result  = goodsServicedelegate.getChannelBeautyInfoDkp(token);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS)){
				Map<String,Object>  result = goodsServicedelegate.getChannelBeautyInfoDkp(token);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS, strResult,KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETCHANNEL_BEAUTY_INFO_DKP_REDIS)).build();	
			}
		}
	}
	
	@Value("${KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS}")
	private String KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS;
	@Value("${KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS_TIMEOUT}")
	private Integer KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS_TIMEOUT;
	@Value("${KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS_USE_FLAG}")
	private Integer KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS_USE_FLAG;
	@GET
	@Path("/getChannelElectronicsInfoDkp")
	@Produces("application/json;charset=utf-8")
	public Response getChannelElectronicsInfoDkp(@QueryParam("token") String token) {
		Gson gson = new Gson();
		if(KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result  = goodsServicedelegate.getChannelBeautyInfoDkp(token);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS)){
				Map<String,Object>  result = goodsServicedelegate.getChannelElectronicsInfoDkp(token);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS, strResult,KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETCHANNEL_ELECTRONICS_INFO_DKP_REDIS)).build();	
			}
		}
	}
	@Value("${KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS}")
	private String KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS;
	@Value("${KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS_TIMEOUT}")
	private Integer KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS_TIMEOUT;
	@Value("${KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS_USE_FLAG}")
	private Integer KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS_USE_FLAG;
	@GET
	@Path("/getChannelSnackInfoDkp")
	@Produces("application/json;charset=utf-8")
	public Response getChannelSnackInfoDkp(@QueryParam("token") String token) {
		Gson gson = new Gson();
		if(KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result  = goodsServicedelegate.getChannelBeautyInfoDkp(token);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS)){
				Map<String,Object>  result = goodsServicedelegate.getChannelSnackInfoDkp(token);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS, strResult,KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETCHANNEL_SNACK_INFO_DKP_REDIS)).build();	
			}
		}
	}
	@Value("${KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS}")
	private String KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS;
	@Value("${KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS_TIMEOUT}")
	private Integer KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS_TIMEOUT;
	@Value("${KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS_USE_FLAG}")
	private Integer KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS_USE_FLAG;
	@GET
	@Path("/getChannelHealthInfoDkp")
	@Produces("application/json;charset=utf-8")
	public Response getChannelHealthInfoDkp(@QueryParam("token") String token) {
		Gson gson = new Gson();
		if(KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result  = goodsServicedelegate.getChannelBeautyInfoDkp(token);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS)){
				Map<String,Object>  result = goodsServicedelegate.getChannelHealthInfoDkp(token);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS, strResult,KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_GETCHANNEL_HEALTH_INFO_DKP_REDIS)).build();	
			}
		}
	}
	@GET
	@NeedLogin
	@Path("/addItemComment")
	@Produces("application/json;charset=utf-8")
	public Response addItemComment(@QueryParam("token") String token,@QueryParam("gid") Integer gid,
			@QueryParam("nickname") String nickname,@QueryParam("content") String content,@QueryParam("paths") String paths,@QueryParam("rate") BigDecimal rate,@Context HttpServletRequest req,@QueryParam("ip_address") String ip_address)throws Exception {

		Map<String, Object> result;
		if(ip_address!=null){
			result = transactionDelegate.transactionAddItemComment(token, gid, nickname, content, paths, rate,ip_address);
       }else{
    	   result = transactionDelegate.transactionAddItemComment(token, gid, nickname, content, paths, rate,req.getRemoteAddr());
       }
		    return Response.status(Status.OK).entity(result).build();
		
	}
	@Value("${KEY_BRANDITEMS_REDIS}")
	private String KEY_BRANDITEMS_REDIS;
	@Value("${KEY_BRANDITEMS_REDIS_TIMEOUT}")
	private Integer KEY_BRANDITEMS_REDIS_TIMEOUT;
	@Value("${KEY_BRANDITEMS_REDIS_USE_FLAG}")
	private Integer KEY_BRANDITEMS_REDIS_USE_FLAG;
	@GET
	@Path("/getBrandItems")
	@Produces("application/json;charset=utf-8")
	public Response getBrandItems(@QueryParam("token") String token,@QueryParam("brand_id") int brand_id,@QueryParam("sort_by") Integer sort_by,@QueryParam("sort_order") Integer sort_order
			,@QueryParam("page") Integer page,@HeaderParam("User-Agent") String agent) {	
		
		
		Gson gson = new Gson();
		if(KEY_BRANDITEMS_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object> result = goodsServicedelegate.selectBrandItems(token,brand_id,sort_by,sort_order,page,agent);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_BRANDITEMS_REDIS+String.valueOf(brand_id)+"|"+String.valueOf(sort_by)+"|"+String.valueOf(sort_order)+"|"+String.valueOf(page))){
				Map<String,Object>   result = goodsServicedelegate.selectBrandItems(token,brand_id,sort_by,sort_order,page,agent);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_BRANDITEMS_REDIS+String.valueOf(brand_id)+"|"+String.valueOf(sort_by)+"|"+String.valueOf(sort_order)+"|"+String.valueOf(page), strResult,KEY_BRANDITEMS_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
	
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_BRANDITEMS_REDIS+String.valueOf(brand_id)+"|"+String.valueOf(sort_by)+"|"+String.valueOf(sort_order)+"|"+String.valueOf(page))).build();
				
			}	
		}
		}
	
	@Value("${KEY_BRANDINFO_REDIS}")
	private String KEY_BRANDINFO_REDIS;
	@Value("${KEY_BRANDINFO_REDIS_TIMEOUT}")
	private Integer KEY_BRANDINFO_REDIS_TIMEOUT;
	@Value("${KEY_BRANDINFO_REDIS_USE_FLAG}")
	private Integer KEY_BRANDINFO_REDIS_USE_FLAG;
	@GET
	@Path("/getBrandInfo")
	@Produces("application/json;charset=utf-8")
	public Response getBrandInfo(@QueryParam("token") String token,@QueryParam("b_id") int brand_id) {	
		
		
		Gson gson = new Gson();
		if(KEY_BRANDINFO_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.selectBrandInfo(token,brand_id);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_BRANDINFO_REDIS+String.valueOf(brand_id))){
				Map<String,Object>  result = goodsServicedelegate.selectBrandInfo(token,brand_id);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_BRANDINFO_REDIS+String.valueOf(brand_id), strResult,1,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
	
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_BRANDINFO_REDIS+String.valueOf(brand_id))).build();
				
			}
		}
		}
	
	@GET
	@Path("/getBrandIndex")
	@Produces("application/json;charset=utf-8")
	public Response getBrandIndex(@QueryParam("token") String token,@QueryParam("cat_id") Integer cat_id,@QueryParam("index") String inedx) {	
		Map<String, Object> result = goodsServicedelegate.selectBrandIndex(token,cat_id,inedx);
		return Response.status(Status.OK).entity(result).build();
		}
	@Value("${KEY_EVENT_SECTION_CON_REDIS}")
	private String KEY_EVENT_SECTION_CON_REDIS;
	@Value("${KEY_EVENT_SECTION_RESULT_REDIS}")
	private String KEY_EVENT_SECTION_RESULT_REDIS;
	@Value("${KEY_EVENT_SECTION_REDIS_TIMEOUT}")
	private Integer KEY_EVENT_SECTION_REDIS_TIMEOUT;
	@Value("${KEY_EVENT_SECTION_REDIS_USE_FLAG}")
	private Integer KEY_EVENT_SECTION_REDIS_USE_FLAG;
	@GET
	@Path("/getEventItems")
	@Produces("application/json;charset=utf-8")
	public Response getEventItems(@QueryParam("token") String token,@QueryParam("event") Integer event,@QueryParam("section") Integer section,@QueryParam("goods_ids") String goods_ids) {
		Gson gson = new Gson();
		
		if(KEY_EVENT_SECTION_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.getEventItems(token,goods_ids);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			//1、验证本次请求的参数信息REDIS是否存在:存在
			if(null!=redisTemplate.opsForValue().get(KEY_EVENT_SECTION_CON_REDIS+String.valueOf(event)+","+String.valueOf(section))){
				String section_key = redisTemplate.opsForValue().get(KEY_EVENT_SECTION_CON_REDIS+String.valueOf(event)+","+String.valueOf(section));
				//1.1、验证本次请求的参数信息与redis是否一致   :一致
				if(section_key.equals(goods_ids)){
					//1.1.1验证本次请求结果信息REDIS是否存在：不存在
					if(null==redisTemplate.opsForValue().get(KEY_EVENT_SECTION_RESULT_REDIS+String.valueOf(event)+","+String.valueOf(section))){
						Map<String,Object>  result = goodsServicedelegate.getEventItems(token,goods_ids);
						String strResult = gson.toJsonTree(result).toString();
						redisTemplate.opsForValue().set(KEY_EVENT_SECTION_RESULT_REDIS+String.valueOf(event)+","+String.valueOf(section), strResult,KEY_EVENT_SECTION_REDIS_TIMEOUT,TimeUnit.HOURS);
					    return Response.status(Status.OK).entity(result).build();
					}
					//1.1.2验证本次请求结果信息REDIS是否存在：存在
					else{
						return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_EVENT_SECTION_RESULT_REDIS+String.valueOf(event)+","+String.valueOf(section))).build();	
					}
					
					
				}
				//1.2、验证本次请求的参数信息与redis是否一致   :不一致
				else{
					redisTemplate.opsForValue().set(KEY_EVENT_SECTION_CON_REDIS+String.valueOf(event)+","+String.valueOf(section), goods_ids,KEY_EVENT_SECTION_REDIS_TIMEOUT,TimeUnit.HOURS);
					Map<String,Object>  result = goodsServicedelegate.getEventItems(token,goods_ids);
					String strResult = gson.toJsonTree(result).toString();
					redisTemplate.opsForValue().set(KEY_EVENT_SECTION_RESULT_REDIS+String.valueOf(event)+","+String.valueOf(section), strResult,KEY_EVENT_SECTION_REDIS_TIMEOUT,TimeUnit.HOURS);
				    return Response.status(Status.OK).entity(result).build();
				}
			}
			//2、验证本次请求的参数信息REDIS是否存在:不存在
			else{
				redisTemplate.opsForValue().set(KEY_EVENT_SECTION_CON_REDIS+String.valueOf(event)+","+String.valueOf(section), goods_ids,KEY_EVENT_SECTION_REDIS_TIMEOUT,TimeUnit.HOURS);
				Map<String,Object>  result = goodsServicedelegate.getEventItems(token,goods_ids);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_EVENT_SECTION_RESULT_REDIS+String.valueOf(event)+","+String.valueOf(section), strResult,KEY_EVENT_SECTION_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
	
			}
		}
	}
		
	@Value("${KEY_AGGREGATE_ITEMS_REDIS}")
	private String KEY_AGGREGATE_ITEMS_REDIS;
	@Value("${KEY_AGGREGATE_ITEMS_REDIS_TIMEOUT}")
	private Integer KEY_AGGREGATE_ITEMS_REDIS_TIMEOUT;
	@Value("${KEY_AGGREGATE_ITEMS_REDIS_USE_FLAG}")
	private Integer KEY_AGGREGATE_ITEMS_REDIS_USE_FLAG;
	@GET
	@Path("/getAggregateItems")
	@Produces("application/json;charset=utf-8")
	public Response getAggregateItems(@QueryParam("token") String token,@QueryParam("ag_id") Integer ag_id)throws Exception {
		Gson gson = new Gson();
		if(KEY_AGGREGATE_ITEMS_REDIS_USE_FLAG.intValue()==0){
			Map<String,Object>  result = goodsServicedelegate.getAggregateItems(token, ag_id);
			 return Response.status(Status.OK).entity(result).build();
		}
		else{
			if(null==redisTemplate.opsForValue().get(KEY_AGGREGATE_ITEMS_REDIS+String.valueOf(ag_id))){
				Map<String,Object>  result = goodsServicedelegate.getAggregateItems(token, ag_id);
				String strResult = gson.toJsonTree(result).toString();
				redisTemplate.opsForValue().set(KEY_AGGREGATE_ITEMS_REDIS+String.valueOf(ag_id), strResult,KEY_AGGREGATE_ITEMS_REDIS_TIMEOUT,TimeUnit.HOURS);
			    return Response.status(Status.OK).entity(result).build();
			}else{
				return Response.status(Status.OK).entity(redisTemplate.opsForValue().get(KEY_AGGREGATE_ITEMS_REDIS+String.valueOf(ag_id))).build();	
			}
		}
	}
	
	@Value("${KEY_SEARCHBAR_REDIS}")
	private String KEY_SEARCHBAR_REDIS;
	//@Value("${KEY_SEARCHBAR_REDIS_TIMEOUT}")
	//private Integer KEY_SEARCHBAR_REDIS_TIMEOUT;
	//@Value("${KEY_SEARCHBAR_REDIS_USE_FLAG}")
	//private Integer KEY_SEARCHBAR_REDIS_USE_FLAG;
	@GET
	@Path("/getSearchBar")
	@Produces("application/json;charset=utf-8")
	public Response getSearchBar(@QueryParam("token") String token)throws Exception {
		Map<String, Object> result;
	    result = getSearchBarTool(token);
		return Response.status(Status.OK).entity(result).build();
	}
	
	
	
	/*
	 获取搜索栏广告信息
	@param String token 
	@return Map<String,Object> 
	*/	
	private  Map<String,Object> getSearchBarTool(String token){
		Gson gson = new Gson(); 
   	List<SearchBar> lstResult = new ArrayList<SearchBar>();
   	Map<String, String> data = new HashMap<String, String>();
		String redisKey = KEY_SEARCHBAR_REDIS;
   	

   	if(redisTemplate.hasKey(redisKey)){
			BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(redisKey);
			data = boundHashOperations.entries();
	    	TreeMap treeData = new TreeMap(data);
	    	for(Object rec_id:treeData.keySet()){
	    		SearchBar record = new SearchBar();
	    		record = gson.fromJson(data.get(rec_id.toString()), SearchBar.class);
	    		lstResult.add(record);
	    	}
		}
   	else{
   		List<SearchBar> lstSearchBar  = goodsServicedelegate.getAllSearchBar();
   		for(SearchBar searchBar:lstSearchBar){
   	    	redisTemplate.opsForHash().put(redisKey, String.valueOf(searchBar.getRecId()), gson.toJson(searchBar));
   	    	lstResult.add(searchBar);
   		}
   	}

   	//随机返回一个searchBar信息
   	int randomIndex = StringUtil.getRandom(0, lstResult.size());
   	SearchBar searchBar =lstResult.get(randomIndex);
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> mapSearchBar = new HashMap<String,Object>();
		mapSearchBar.put("placeholder", searchBar.getPlaceholder());
		mapSearchBar.put("eplaceholder", searchBar.getPlaceholderE());
		mapSearchBar.put("type", searchBar.getType());
		mapSearchBar.put("value", searchBar.getValue());
		mapSearchBar.put("search", searchBar.getSearch());
		mapSearchBar.put("esearch", searchBar.getEsearch());
		mapSearchBar.put("url", searchBar.getUrl());
		result.put("searchBar", mapSearchBar);
		
		result.put("token", token);
		
		return result;
		
	}
	
	@GET
	@NeedLogin
	@Path("/checkRemindFlag")
	@Produces("application/json;charset=utf-8")
	public Response checkRemindFlag(@QueryParam("token") String token,@QueryParam("gid") int gid)throws Exception {
		Map<String, Object> result;
	    result =goodsServicedelegate.checkRemindFlag(token, gid);
		return Response.status(Status.OK).entity(result).build();
	}
	
	
	@GET
	@Path("/checkZipcode")
	@Produces("application/json;charset=utf-8")
	public Response checkZipcode(@QueryParam("token") String token,@QueryParam("gid") int gid,@QueryParam("zip") String zip)throws Exception {
		Map<String, Object> result;
	    result =goodsServicedelegate.checkZipcode(token, gid,zip);
		return Response.status(Status.OK).entity(result).build();
	}
	
	
	@GET
	@Path("/loadDiscoveryMessage")
	@Produces("application/json;charset=utf-8")
	public Response loadDiscoveryMessage(@QueryParam("token") String token,
			                    @QueryParam("currentIndex") int currentIndex,
			                    @QueryParam("direction") int direction,
			                    @HeaderParam("User-Agent") String agent
			                   )throws Exception{
		Map<String,Object> result = goodsServicedelegate.loadDiscoveryMessage(token,currentIndex,direction,agent);
		return Response.status(Status.OK).entity(result).build();
	}
	
	
	
}
