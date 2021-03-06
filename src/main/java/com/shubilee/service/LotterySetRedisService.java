package com.shubilee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.BoundHashOperations;

import com.shubilee.common.RedisKeyConstant;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Token;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.redis.entity.LotterySetRedis;

public interface LotterySetRedisService {	
	 public void insert(Token token,LotterySetRedis record)throws Exception;
	    public void update(Token token,LotterySetRedis record)throws Exception;
	    public void delete(Token token,String date)throws Exception;
	    public void deleteAll(Token token)throws Exception;
	    public Boolean check(Token token,String date)throws Exception;
	    public Boolean checkAll(Token token)throws Exception;
	    public LotterySetRedis select(Token token,String date)throws Exception;
	    public List<LotterySetRedis> selectAll(Token token)throws Exception;
}
