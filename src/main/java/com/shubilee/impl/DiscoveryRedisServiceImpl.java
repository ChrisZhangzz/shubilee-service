package com.shubilee.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.StringUtil;
import com.shubilee.dao.CartDao;
import com.shubilee.dao.GoodsDao;
import com.shubilee.entity.Cart;
import com.shubilee.entity.DiscoveryInfo;
import com.shubilee.entity.Goods;
import com.shubilee.entity.Token;
import com.shubilee.redis.dao.CartRedisDao;
import com.shubilee.redis.dao.DiscoverRedisDao;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.service.CartRedisService;
import com.shubilee.service.DiscoveryRedisService;

@Service
public class DiscoveryRedisServiceImpl implements DiscoveryRedisService{
	@Autowired
	private DiscoverRedisDao discoverRedisDao;
	@Autowired
	private GoodsDao goodsDao;
	
    public void insert(DiscoveryInfo record){
    	discoverRedisDao.insert(record);
    }
    public void update(DiscoveryInfo record){
    	discoverRedisDao.update(record);
    }
    public void delete(int rec_id){
    	discoverRedisDao.delete(rec_id);
    }
    public void deleteAll(){
    	discoverRedisDao.deleteAll();
    }
    public Boolean check(int rec_id){
    	return discoverRedisDao.check(rec_id);
    }
    public Boolean checkAll(){
    	return discoverRedisDao.checkAll();
    }
    public DiscoveryInfo select(int rec_id){
    	DiscoveryInfo result = new DiscoveryInfo();
    	DiscoveryInfo discoveryInfo = discoverRedisDao.select(rec_id);
    	if(null!=discoveryInfo.getDiscoveryDetail().getGoodsIds()){
    		List<Goods> lstGoods = goodsDao.selectGoodsByGoodsIds(discoveryInfo.getDiscoveryDetail().getGoodsIds().split(","));
			discoveryInfo.getDiscoveryDetail().setLstGoods(lstGoods);
			result = discoveryInfo;
		}else{
			result = discoveryInfo;
		}
    	
    	return result;
    }
    public List<DiscoveryInfo> selectAll(){
    	
    	List<DiscoveryInfo> result = new ArrayList<DiscoveryInfo>();
    	List<DiscoveryInfo> lstDiscoveryInfoRedis = discoverRedisDao.selectAll();
    	List<Goods> lstGoods = new ArrayList<Goods>();
    	for(DiscoveryInfo discoveryInfo:lstDiscoveryInfoRedis){
    		if(null!=discoveryInfo.getDiscoveryDetail().getGoodsIds()){
    			lstGoods = goodsDao.selectGoodsByGoodsIds(discoveryInfo.getDiscoveryDetail().getGoodsIds().split(","));
    			discoveryInfo.getDiscoveryDetail().setLstGoods(lstGoods);
    		}
    		result.add(discoveryInfo);
    	}
    	return result;
    }
    public void insertMaxRecId(int rec_id){
    	discoverRedisDao.insertMaxRecId(rec_id);
    }
    public Boolean checkMaxRecId(){
    	return discoverRedisDao.checkMaxRecId();
    }
    public int selectMaxRecId(){
    	return discoverRedisDao.selectMaxRecId();
    }
    
    
    public void insertTop(DiscoveryInfo record){
    	discoverRedisDao.insertTop(record);
    }
    public void updateTop(DiscoveryInfo record){
    	discoverRedisDao.updateTop(record);
    }
    public void deleteTop(int rec_id){
    	discoverRedisDao.deleteTop(rec_id);
    }
    public void deleteAllTop(){
    	discoverRedisDao.deleteAllTop();
    }
    public Boolean checkTop(int rec_id){
    	return discoverRedisDao.checkTop(rec_id);
    }
    public Boolean checkAllTop(){
    	return discoverRedisDao.checkAllTop();
    }
    public DiscoveryInfo selectTop(int rec_id){
    	DiscoveryInfo result = new DiscoveryInfo();
    	DiscoveryInfo discoveryInfo = discoverRedisDao.selectTop(rec_id);
    	if(null!=discoveryInfo.getDiscoveryDetail().getGoodsIds()){
    		List<Goods> lstGoods = goodsDao.selectGoodsByGoodsIds(discoveryInfo.getDiscoveryDetail().getGoodsIds().split(","));
			discoveryInfo.getDiscoveryDetail().setLstGoods(lstGoods);
			result = discoveryInfo;
		}else{
			result = discoveryInfo;
		}
    	
    	return result;
    }
    public List<DiscoveryInfo> selectAllTop(){
    	
    	List<DiscoveryInfo> result = new ArrayList<DiscoveryInfo>();
    	List<DiscoveryInfo> lstDiscoveryInfoRedis = discoverRedisDao.selectAllTop();
    	List<Goods> lstGoods = new ArrayList<Goods>();
    	for(DiscoveryInfo discoveryInfo:lstDiscoveryInfoRedis){
    		if(null!=discoveryInfo.getDiscoveryDetail().getGoodsIds()){
    			lstGoods = goodsDao.selectGoodsByGoodsIds(discoveryInfo.getDiscoveryDetail().getGoodsIds().split(","));
    			discoveryInfo.getDiscoveryDetail().setLstGoods(lstGoods);
    		}
    		result.add(discoveryInfo);
    	}
    	return result;
    }
}
