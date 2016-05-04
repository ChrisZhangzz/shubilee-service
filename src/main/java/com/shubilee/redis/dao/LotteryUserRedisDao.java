
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
import com.shubilee.redis.entity.LotteryUserRedis;


@Service
public class LotteryUserRedisDao {  
	@Autowired
	private RedisTemplate<String,String> redisTemplate4Lottery;
	private Gson gson = new Gson(); 

    public void insert(Token token,LotteryUserRedis record)throws Exception{
    	int uid = Integer.parseInt(token.getData());
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_USER_HISTORY_INFO+DateUtil.getShortNow2();
    	redisTemplate4Lottery.opsForHash().put(redisKey, String.valueOf(uid), gson.toJson(record));
    	
    }
    public void update(Token token,LotteryUserRedis record)throws Exception{
    	int uid = Integer.parseInt(token.getData());
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_USER_HISTORY_INFO+DateUtil.getShortNow2();
    	redisTemplate4Lottery.opsForHash().put(redisKey,String.valueOf(uid), gson.toJson(record));
    }

    public Boolean check(Token token)throws Exception{
    	int uid = Integer.parseInt(token.getData());
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_USER_HISTORY_INFO+DateUtil.getShortNow2();
    	result =redisTemplate4Lottery.opsForHash().hasKey(redisKey, String.valueOf(uid));
    	return result;
    }
    public Boolean checkAll(Token token)throws Exception{
    	Boolean result = false;
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_USER_HISTORY_INFO+DateUtil.getShortNow2();
    	result = redisTemplate4Lottery.hasKey(redisKey);
    	return result;
    }
    public LotteryUserRedis select(Token token)throws Exception{
    	int uid = Integer.parseInt(token.getData());
    	String redisKey = RedisKeyConstant.REDIS_KEY_LOTTERY_USER_HISTORY_INFO+DateUtil.getShortNow2();
    	LotteryUserRedis result =null;
    	if(check(token)){
    		result = gson.fromJson(redisTemplate4Lottery.opsForHash().get(redisKey, String.valueOf(uid)).toString(), LotteryUserRedis.class);
    	}
    	return result;
    }

}
