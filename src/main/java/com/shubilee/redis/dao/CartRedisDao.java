
package com.shubilee.redis.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import scala.collection.mutable.LinkedHashMap;

import com.google.gson.Gson;
import com.shubilee.common.DateUtil;
import com.shubilee.common.RedisKeyConstant;
import com.shubilee.entity.Token;
import com.shubilee.redis.entity.CartRedis;

@Service
public class CartRedisDao {  
	@Autowired
	private RedisTemplate<String,String> redisTemplate4Cart;
	private Gson gson = new Gson(); 

    public void insert(Token token,CartRedis record)throws Exception{
    	record.setTime(Integer.parseInt(DateUtil.getNowLong().toString()));
    	String redisKey = RedisKeyConstant.REDIS_KEY_CART_INFO+token.getData();
    	redisTemplate4Cart.opsForHash().put(redisKey, String.valueOf(record.getGoods_id()), gson.toJson(record));
    	
    }
    public void update(Token token,CartRedis record)throws Exception{
    	record.setTime(Integer.parseInt(DateUtil.getNowLong().toString()));
    	String redisKey = RedisKeyConstant.REDIS_KEY_CART_INFO+token.getData();
    	redisTemplate4Cart.opsForHash().put(redisKey, String.valueOf(record.getGoods_id()), gson.toJson(record));
    }
    public void delete(Token token,int goods_id){
    	String redisKey = RedisKeyConstant.REDIS_KEY_CART_INFO+token.getData();
    	redisTemplate4Cart.opsForHash().delete(redisKey, String.valueOf(goods_id));
    	
    }
    public void deleteAll(Token token){
    	String redisKey = RedisKeyConstant.REDIS_KEY_CART_INFO+token.getData();
    	redisTemplate4Cart.delete(redisKey);
    	
    }
    public Boolean check(Token token,int goods_id){
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_CART_INFO+token.getData();
    	result =redisTemplate4Cart.opsForHash().hasKey(redisKey, String.valueOf(goods_id));
    	return result;
    }
    public Boolean checkAll(Token token){
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_CART_INFO+token.getData();
    	result = redisTemplate4Cart.hasKey(redisKey);
    	return result;
    }
    public CartRedis select(Token token,int goods_id){
    	String redisKey = RedisKeyConstant.REDIS_KEY_CART_INFO+token.getData();
    	CartRedis result =null;
    	if(check(token,goods_id)){
    		result = gson.fromJson(redisTemplate4Cart.opsForHash().get(redisKey, String.valueOf(goods_id)).toString(), CartRedis.class);
    	}
    	return result;
    }
    public List<CartRedis> selectAll(Token token){
    	List<CartRedis> lstResult = new ArrayList<CartRedis>();
    	String redisKey = RedisKeyConstant.REDIS_KEY_CART_INFO+token.getData();
    	Map<String, String> data = new HashMap<String, String>();
    	if(redisTemplate4Cart.hasKey(redisKey)){
			BoundHashOperations<String, String, String> boundHashOperations = redisTemplate4Cart.boundHashOps(redisKey);
			data = boundHashOperations.entries();
		}

    	
    	TreeMap treeData = new TreeMap(data);

    	CartRedis record = new CartRedis();
    	for(Iterator<String> it = treeData.keySet().iterator(); it.hasNext();){
    		record = gson.fromJson(data.get(it.next()), CartRedis.class);
    		lstResult.add(record);
    	}
    	
    	return lstResult;
    }
}
