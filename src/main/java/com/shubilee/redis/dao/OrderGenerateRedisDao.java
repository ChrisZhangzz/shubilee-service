
package com.shubilee.redis.dao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shubilee.common.DateUtil;
import com.shubilee.common.RedisKeyConstant;
import com.shubilee.entity.Token;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.redis.entity.OrderGenerateRedis;

@Service
public class OrderGenerateRedisDao {  
	@Autowired
	private RedisTemplate<String,String> redisTemplate4Cart;
	private Gson gson = new Gson(); 

    public void insert(Token token,OrderGenerateRedis record)throws Exception{
    	record.setTime(Integer.parseInt(DateUtil.getNowLong().toString()));
    	String redisKey = RedisKeyConstant.REDIS_KEY_ORDER_GENERATE_INFO+token.getData();
    	redisTemplate4Cart.opsForHash().put(redisKey, String.valueOf(record.getVendorId()), gson.toJson(record));
    	
    }
    public void update(Token token,OrderGenerateRedis record)throws Exception{
    	record.setTime(Integer.parseInt(DateUtil.getNowLong().toString()));
    	String redisKey = RedisKeyConstant.REDIS_KEY_ORDER_GENERATE_INFO+token.getData();
    	redisTemplate4Cart.opsForHash().put(redisKey, String.valueOf(record.getVendorId()), gson.toJson(record));
    }
    public void delete(Token token,int vendor_id){
    	String redisKey = RedisKeyConstant.REDIS_KEY_ORDER_GENERATE_INFO+token.getData();
    	redisTemplate4Cart.opsForHash().delete(redisKey, String.valueOf(vendor_id));
    	
    }
    public void deleteAll(Token token){
    	String redisKey = RedisKeyConstant.REDIS_KEY_ORDER_GENERATE_INFO+token.getData();
    	redisTemplate4Cart.delete(redisKey);
    	
    }
    public Boolean check(Token token,int vendor_id){
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_ORDER_GENERATE_INFO+token.getData();
    	result =redisTemplate4Cart.opsForHash().hasKey(redisKey, String.valueOf(vendor_id));
    	return result;
    }
    public Boolean checkAll(Token token){
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_ORDER_GENERATE_INFO+token.getData();
    	result = redisTemplate4Cart.hasKey(redisKey);
    	return result;
    }
    public OrderGenerateRedis select(Token token,int vendor_id){
    	String redisKey = RedisKeyConstant.REDIS_KEY_ORDER_GENERATE_INFO+token.getData();
    	OrderGenerateRedis result = gson.fromJson(redisTemplate4Cart.opsForHash().get(redisKey, String.valueOf(vendor_id)).toString(), OrderGenerateRedis.class);
    	return result;
    }
    public List<OrderGenerateRedis> selectAll(Token token){
    	List<OrderGenerateRedis> lstResult = new ArrayList<OrderGenerateRedis>();
    	String redisKey = RedisKeyConstant.REDIS_KEY_ORDER_GENERATE_INFO+token.getData();
    	Map<String, String> data = new HashMap<String, String>();
    	if(redisTemplate4Cart.hasKey(redisKey)){
			BoundHashOperations<String, String, String> boundHashOperations = redisTemplate4Cart.boundHashOps(redisKey);
			data = boundHashOperations.entries();
		}
    	TreeMap treeData = new TreeMap(data);
    	
    	OrderGenerateRedis record = new OrderGenerateRedis();
    	for(Iterator<String> it = treeData.keySet().iterator(); it.hasNext();){
    		record = gson.fromJson(data.get(it.next()), OrderGenerateRedis.class);
    		lstResult.add(record);
    	}
    	return lstResult;
    }
}
