
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
import com.shubilee.redis.entity.LotterySetRedis;

@Service
public class LotterySetRedisDao {  
	@Autowired
	private RedisTemplate<String,String> redisTemplate4Lottery;
	private Gson gson = new Gson(); 

    public void insert(Token token,LotterySetRedis record)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_SET_INFO;
    	redisTemplate4Lottery.opsForHash().put(redisKey, DateUtil.dateFormater(record.getDate(), "yyyy-MM-dd"), gson.toJson(record));
    	
    }
    public void update(Token token,LotterySetRedis record)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_SET_INFO;
    	redisTemplate4Lottery.opsForHash().put(redisKey, DateUtil.dateFormater(record.getDate(), "yyyy-MM-dd"), gson.toJson(record));
    }
    public void delete(Token token,String date)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_SET_INFO;
    	redisTemplate4Lottery.opsForHash().delete(redisKey, date);
    	
    }
    public void deleteAll(Token token)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_SET_INFO;
    	redisTemplate4Lottery.delete(redisKey);
    	
    }
    public Boolean check(Token token,String date)throws Exception{
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_SET_INFO;
    	result =redisTemplate4Lottery.opsForHash().hasKey(redisKey, date);
    	return result;
    }
    public Boolean checkAll(Token token)throws Exception{
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_SET_INFO;
    	result = redisTemplate4Lottery.hasKey(redisKey);
    	return result;
    }
    public LotterySetRedis select(Token token,String date)throws Exception{
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_SET_INFO;
    	LotterySetRedis result =null;
    	if(check(token,date)){
    		result = gson.fromJson(redisTemplate4Lottery.opsForHash().get(redisKey, date).toString(), LotterySetRedis.class);
    	}
    	return result;
    }
    public List<LotterySetRedis> selectAll(Token token)throws Exception{
    	List<LotterySetRedis> lstResult = new ArrayList<LotterySetRedis>();
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_SET_INFO;
    	Map<String, String> data = new HashMap<String, String>();
    	if(redisTemplate4Lottery.hasKey(redisKey)){
			BoundHashOperations<String, String, String> boundHashOperations = redisTemplate4Lottery.boundHashOps(redisKey);
			data = boundHashOperations.entries();
		}

    	
    	TreeMap treeData = new TreeMap(data);

    	LotterySetRedis record = new LotterySetRedis();
    	for(Iterator<String> it = treeData.keySet().iterator(); it.hasNext();){
    		record = gson.fromJson(data.get(it.next()), LotterySetRedis.class);
    		lstResult.add(record);
    	}
    	
    	return lstResult;
    }
}
