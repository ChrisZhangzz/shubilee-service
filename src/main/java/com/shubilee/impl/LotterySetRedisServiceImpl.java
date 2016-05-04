package com.shubilee.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.StringUtil;
import com.shubilee.dao.CartDao;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Token;
import com.shubilee.redis.dao.CartRedisDao;
import com.shubilee.redis.dao.LotterySetRedisDao;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.redis.entity.LotterySetRedis;
import com.shubilee.service.CartRedisService;
import com.shubilee.service.LotterySetRedisService;

@Service
public class LotterySetRedisServiceImpl implements LotterySetRedisService{
	@Autowired
	private LotterySetRedisDao lotterySetRedisDao;
	
	public void insert(Token token,LotterySetRedis record)throws Exception{
		lotterySetRedisDao.insert(token, record);
	}
    public void update(Token token,LotterySetRedis record)throws Exception{
    	lotterySetRedisDao.update(token, record);
    }
    public void delete(Token token,String date)throws Exception{
    	lotterySetRedisDao.delete(token, date);
    }
    public void deleteAll(Token token)throws Exception{
    	lotterySetRedisDao.deleteAll(token);
    }
    public Boolean check(Token token,String date)throws Exception{
    	return lotterySetRedisDao.check(token, date);
    }
    public Boolean checkAll(Token token)throws Exception{
    	return lotterySetRedisDao.checkAll(token);
    }
    public LotterySetRedis select(Token token,String date)throws Exception{
    	return lotterySetRedisDao.select(token, date);
    }
    public List<LotterySetRedis> selectAll(Token token)throws Exception{
    	return lotterySetRedisDao.selectAll(token);
    }
    
    
    
    
}
