
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











import com.google.gson.Gson;
import com.shubilee.common.RedisKeyConstant;
import com.shubilee.entity.ShopDistrictZipcode;
import com.shubilee.entity.Token;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.redis.entity.YmZipcodeRedis;

@Service
public class GoodsRedisDao {  
	@Autowired
	private RedisTemplate<String,String> redisTemplate4Goods;
	private Gson gson = new Gson(); 
//
//	public void insertYmZipcode(YmZipcodeRedis record){
//    	String redisKey = RedisKeyConstant.REDIS_KEY_YM_ZIPCODE_INFO;
//    	redisTemplate4Goods.opsForHash().put(redisKey, String.valueOf(record.getZip()), gson.toJson(record));
//    	
//    }
//    public Boolean checkZipcode(int zip){
//    	Boolean result = false;
//    	String redisKey = RedisKeyConstant.REDIS_KEY_YM_ZIPCODE_INFO;
//    	result =redisTemplate4Goods.opsForHash().hasKey(redisKey, String.valueOf(zip));
//    	return result;
//    }
//    public Boolean checkAllZipcode(){
//    	Boolean result = false;
//    	String redisKey = RedisKeyConstant.REDIS_KEY_YM_ZIPCODE_INFO;
//    	result = redisTemplate4Goods.hasKey(redisKey);
//    	return result;
//    }
    
    
    
	public void insertShopZipcode(ShopDistrictZipcode record){
    	String redisKey = RedisKeyConstant.REDIS_KEY_SHOP_ZIPCODE_INFO;
    	redisTemplate4Goods.opsForHash().put(redisKey+String.valueOf(record.getRuleId()), record.getZipcode(), gson.toJson(record));
    	
    }
    
    public Boolean checkShopZipcode(int ruleId){
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_SHOP_ZIPCODE_INFO;
    	result =redisTemplate4Goods.hasKey(redisKey+String.valueOf(ruleId));
    	return result;
    }
    
    
    public List<ShopDistrictZipcode> selectShopZipcode(int ruleId){
    	List<ShopDistrictZipcode> lstResult = new ArrayList<ShopDistrictZipcode>();
    	String redisKey = RedisKeyConstant.REDIS_KEY_SHOP_ZIPCODE_INFO+String.valueOf(ruleId);
    	Map<String, String> data = new HashMap<String, String>();
    	if(redisTemplate4Goods.hasKey(redisKey)){
			BoundHashOperations<String, String, String> boundHashOperations = redisTemplate4Goods.boundHashOps(redisKey);
			data = boundHashOperations.entries();
		}

    	
    	TreeMap treeData = new TreeMap(data);

    	ShopDistrictZipcode record = new ShopDistrictZipcode();
    	for(Iterator<String> it = treeData.keySet().iterator(); it.hasNext();){
    		record = gson.fromJson(data.get(it.next()), ShopDistrictZipcode.class);
    		lstResult.add(record);
    	}
    	
    	return lstResult;
    }
    
    
    
    
}
