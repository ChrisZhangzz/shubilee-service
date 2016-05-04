package com.shubilee.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.entity.Token;
import com.shubilee.redis.dao.LotteryConfigRedisDao;
import com.shubilee.redis.entity.LotteryConfigRedis;
import com.shubilee.service.LotteryConfigRedisService;


@Service
public class LotteryConfigRedisServiceImpl implements LotteryConfigRedisService{
	@Autowired
	private LotteryConfigRedisDao lotterySetRedisDao;
	
	
	public void insert(Token token,LotteryConfigRedis record)throws Exception{
		lotterySetRedisDao.insert(token, record);
	}
    public void update(Token token,LotteryConfigRedis record)throws Exception{
    	lotterySetRedisDao.update(token, record);
    }
    public void delete(Token token,int rec_id)throws Exception{
    	lotterySetRedisDao.delete(token, rec_id);
    }
    public void deleteAll(Token token)throws Exception{
    	lotterySetRedisDao.deleteAll(token);
    }
    public Boolean check(Token token,int rec_id)throws Exception{
    	return lotterySetRedisDao.check(token, rec_id);
    }
    public Boolean checkAll(Token token)throws Exception{
    	return lotterySetRedisDao.checkAll(token);
    }
    public LotteryConfigRedis select(Token token,int rec_id)throws Exception{
    	return lotterySetRedisDao.select(token, rec_id);
    }
    public List<LotteryConfigRedis> selectAll(Token token)throws Exception{
    	return lotterySetRedisDao.selectAll(token);
    }
    
    
    
    
    
}
