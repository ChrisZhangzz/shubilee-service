package com.shubilee.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;







import com.shubilee.entity.Token;
import com.shubilee.redis.dao.LotteryUserRedisDao;
import com.shubilee.redis.entity.LotteryUserRedis;
import com.shubilee.service.LotteryUserRedisService;


@Service
public class LotteryUserRedisServiceImpl implements LotteryUserRedisService{
	@Autowired
	private LotteryUserRedisDao lotteryUserRedisDao;
	
	
	 public void insert(Token token,LotteryUserRedis record)throws Exception{
		 lotteryUserRedisDao.insert(token, record);
	 }
	    public void update(Token token,LotteryUserRedis record)throws Exception{
	    	lotteryUserRedisDao.update(token, record);
	    }
	    public Boolean check(Token token)throws Exception{
	    	return lotteryUserRedisDao.check(token);
	    }
	    public Boolean checkAll(Token token)throws Exception{
	    	return lotteryUserRedisDao.checkAll(token);
	    }
	    public LotteryUserRedis select(Token token)throws Exception{
	    	return lotteryUserRedisDao.select(token);
	    }
    
    
    
    
    
}
