
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
import com.shubilee.entity.DiscoveryInfo;
import com.shubilee.entity.Token;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.redis.entity.OrderGenerateRedis;

@Service
public class DiscoverRedisDao {  
	@Autowired
	private RedisTemplate<String,String> redisTemplate4Discover;
	private Gson gson = new Gson(); 

	
    public void insertMaxRecId(int rec_id){
    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_MAX_REC_ID;
    	redisTemplate4Discover.opsForValue().set(redisKey, String.valueOf(rec_id));
    	
    }
    

    public Boolean checkMaxRecId(){
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_MAX_REC_ID;
    	if(null!=redisTemplate4Discover.opsForValue().get(redisKey)){
    		result = true;
    	}
    	return result;
    }
    public int selectMaxRecId(){
    	
    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_MAX_REC_ID;
    	int maxRecid  = Integer.parseInt(redisTemplate4Discover.opsForValue().get(redisKey));
    	return maxRecid;
    }
    
    
    
    
	    public void insert(DiscoveryInfo record){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO;
	    	redisTemplate4Discover.opsForHash().put(redisKey, String.valueOf(record.getRecId()), gson.toJson(record));
	    	
	    }
	    public void update(DiscoveryInfo record){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO;
	    	redisTemplate4Discover.opsForHash().put(redisKey, String.valueOf(record.getRecId()), gson.toJson(record));
	    }
	    public void delete(int rec_id){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO;
	    	redisTemplate4Discover.opsForHash().delete(redisKey, String.valueOf(rec_id));
	    	
	    }
	    public void deleteAll(){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO;
	    	redisTemplate4Discover.delete(redisKey);
	    	
	    }
	    public Boolean check(int rec_id){
	    	Boolean result = false;
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO;
	    	result =redisTemplate4Discover.opsForHash().hasKey(redisKey, String.valueOf(rec_id));
	    	return result;
	    }
	    public Boolean checkAll(){
	    	Boolean result = false;
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO;
	    	result = redisTemplate4Discover.hasKey(redisKey);
	    	return result;
	    }
	    public DiscoveryInfo select(int rec_id){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO;
	    	DiscoveryInfo result = gson.fromJson(redisTemplate4Discover.opsForHash().get(redisKey, String.valueOf(rec_id)).toString(), DiscoveryInfo.class);
	    	return result;
	    }
	    public List<DiscoveryInfo> selectAll(){
	    	List<DiscoveryInfo> lstResult = new ArrayList<DiscoveryInfo>();
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO;
	    	Map<String, String> data = new HashMap<String, String>();
	    	if(redisTemplate4Discover.hasKey(redisKey)){
				BoundHashOperations<String, String, String> boundHashOperations = redisTemplate4Discover.boundHashOps(redisKey);
				data = boundHashOperations.entries();
			}
	    	TreeMap treeData = new TreeMap(data);
	    	
	    	DiscoveryInfo record = new DiscoveryInfo();
	    	for(Iterator<String> it = treeData.keySet().iterator(); it.hasNext();){
	    		record = gson.fromJson(data.get(it.next()), DiscoveryInfo.class);
	    		lstResult.add(record);
	    	}
	    	return lstResult;
	    }
	
	    
	    
	    

	    public void insertTop(DiscoveryInfo record){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO_TOP;
	    	redisTemplate4Discover.opsForHash().put(redisKey, String.valueOf(record.getRecId()), gson.toJson(record));
	    	
	    }
	    public void updateTop(DiscoveryInfo record){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO_TOP;
	    	redisTemplate4Discover.opsForHash().put(redisKey, String.valueOf(record.getRecId()), gson.toJson(record));
	    }
	    public void deleteTop(int rec_id){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO_TOP;
	    	redisTemplate4Discover.opsForHash().delete(redisKey, String.valueOf(rec_id));
	    	
	    }
	    public void deleteAllTop(){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO_TOP;
	    	redisTemplate4Discover.delete(redisKey);
	    	
	    }
	    public Boolean checkTop(int rec_id){
	    	Boolean result = false;
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO_TOP;
	    	result =redisTemplate4Discover.opsForHash().hasKey(redisKey, String.valueOf(rec_id));
	    	return result;
	    }
	    public Boolean checkAllTop(){
	    	Boolean result = false;
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO_TOP;
	    	result = redisTemplate4Discover.hasKey(redisKey);
	    	return result;
	    }
	    public DiscoveryInfo selectTop(int rec_id){
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO_TOP;
	    	DiscoveryInfo result = gson.fromJson(redisTemplate4Discover.opsForHash().get(redisKey, String.valueOf(rec_id)).toString(), DiscoveryInfo.class);
	    	return result;
	    }
	    public List<DiscoveryInfo> selectAllTop(){
	    	List<DiscoveryInfo> lstResult = new ArrayList<DiscoveryInfo>();
	    	String redisKey = RedisKeyConstant.REDIS_KEY_DISCOVERY_INFO_TOP;
	    	Map<String, String> data = new HashMap<String, String>();
	    	if(redisTemplate4Discover.hasKey(redisKey)){
				BoundHashOperations<String, String, String> boundHashOperations = redisTemplate4Discover.boundHashOps(redisKey);
				data = boundHashOperations.entries();
			}
	    	TreeMap treeData = new TreeMap(data);
	    	
	    	DiscoveryInfo record = new DiscoveryInfo();
	    	for(Iterator<String> it = treeData.keySet().iterator(); it.hasNext();){
	    		record = gson.fromJson(data.get(it.next()), DiscoveryInfo.class);
	    		lstResult.add(record);
	    	}
	    	return lstResult;
	    }
}
