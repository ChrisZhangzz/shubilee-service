
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
import com.shubilee.redis.entity.LotteryConfigRedis;

@Service
public class LotteryConfigRedisDao {  
	@Autowired
	private RedisTemplate<String,String> redisTemplate4Lottery;
	private Gson gson = new Gson(); 

    public void insert(Token token,LotteryConfigRedis record)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_CONFIG_INFO+DateUtil.getShortNow2();
    	redisTemplate4Lottery.opsForHash().put(redisKey, String.valueOf(record.getRecId()), gson.toJson(record));
    	
    }
    public void update(Token token,LotteryConfigRedis record)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_CONFIG_INFO+DateUtil.getShortNow2();
    	redisTemplate4Lottery.opsForHash().put(redisKey, String.valueOf(record.getRecId()), gson.toJson(record));
    }
    public void delete(Token token,int rec_id)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_CONFIG_INFO+DateUtil.getShortNow2();
    	redisTemplate4Lottery.opsForHash().delete(redisKey, String.valueOf(rec_id));
    	
    }
    public void deleteAll(Token token)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_CONFIG_INFO+DateUtil.getShortNow2();
    	redisTemplate4Lottery.delete(redisKey);
    	
    }
    public Boolean check(Token token,int rec_id)throws Exception{
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_CONFIG_INFO+DateUtil.getShortNow2();
    	result =redisTemplate4Lottery.opsForHash().hasKey(redisKey, String.valueOf(rec_id));
    	return result;
    }
    public Boolean checkAll(Token token)throws Exception{
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_CONFIG_INFO+DateUtil.getShortNow2();
    	result = redisTemplate4Lottery.hasKey(redisKey);
    	return result;
    }
    public LotteryConfigRedis select(Token token,int rec_id)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_CONFIG_INFO+DateUtil.getShortNow2();
    	LotteryConfigRedis result =null;
    	if(check(token,rec_id)){
    		result = gson.fromJson(redisTemplate4Lottery.opsForHash().get(redisKey, String.valueOf(rec_id)).toString(), LotteryConfigRedis.class);
    	}
    	return result;
    }
    public List<LotteryConfigRedis> selectAll(Token token)throws Exception{
    	List<LotteryConfigRedis> lstResult = new ArrayList<LotteryConfigRedis>();
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_CONFIG_INFO+DateUtil.getShortNow2();
    	Map<String, String> data = new HashMap<String, String>();
    	if(redisTemplate4Lottery.hasKey(redisKey)){
			BoundHashOperations<String, String, String> boundHashOperations = redisTemplate4Lottery.boundHashOps(redisKey);
			data = boundHashOperations.entries();
		}

    	
    	TreeMap treeData = new TreeMap(data);

    	LotteryConfigRedis record = new LotteryConfigRedis();
    	for(Iterator<String> it = treeData.keySet().iterator(); it.hasNext();){
    		record = gson.fromJson(data.get(it.next()), LotteryConfigRedis.class);
    		lstResult.add(record);
    	}
    	
    	return lstResult;
    }
}
