package com.shubilee.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









import com.shubilee.dao.GoodsDao;
import com.shubilee.entity.ShopDistrictZipcode;
import com.shubilee.redis.dao.GoodsRedisDao;
import com.shubilee.redis.entity.YmZipcodeRedis;
import com.shubilee.service.GoodsRedisService;
@Service
public class GoodsRedisServiceImpl implements GoodsRedisService{
	@Autowired
	private GoodsRedisDao goodsRedisDao;


	public void insertShopZipcode(ShopDistrictZipcode record){
	 goodsRedisDao.insertShopZipcode(record);
	}
	public Boolean checkShopZipcode(int ruleId){
		return goodsRedisDao.checkShopZipcode(ruleId);
	}
	public List<ShopDistrictZipcode> selectShopZipcode(int ruleId){
		return goodsRedisDao.selectShopZipcode(ruleId);
	}
}
