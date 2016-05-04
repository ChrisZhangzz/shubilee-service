package com.shubilee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.BoundHashOperations;

import com.shubilee.common.DateUtil;
import com.shubilee.common.RedisKeyConstant;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Token;
import com.shubilee.redis.entity.LotteryUserRedis;

public interface LotteryUserRedisService {	
	 public void insert(Token token,LotteryUserRedis record)throws Exception;
	    public void update(Token token,LotteryUserRedis record)throws Exception;
	    public Boolean check(Token token)throws Exception;
	    public Boolean checkAll(Token token)throws Exception;
	    public LotteryUserRedis select(Token token)throws Exception;
}
