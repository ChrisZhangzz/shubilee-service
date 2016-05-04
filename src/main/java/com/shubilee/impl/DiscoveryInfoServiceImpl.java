package com.shubilee.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.WriteData;
import com.shubilee.dao.CartDao;
import com.shubilee.dao.DiscoveryInfoDao;
import com.shubilee.dao.GoodsDao;
import com.shubilee.entity.Cart;
import com.shubilee.entity.DiscoveryInfo;
import com.shubilee.entity.Goods;
import com.shubilee.entity.Message4Discovery;
import com.shubilee.service.CartService;
import com.shubilee.service.DiscoveryInfoService;

@Service
public class DiscoveryInfoServiceImpl implements DiscoveryInfoService{

	@Autowired
	private DiscoveryInfoDao discoveryInfoDao;
	
	@Autowired
	private GoodsDao goodsDao;

	public int selectMaxRecId(){
		return discoveryInfoDao.selectMaxRecId();
	}

	public DiscoveryInfo selectDiscoveryInfoByRecId(int rec_id){
		
		DiscoveryInfo result = new DiscoveryInfo();
    	DiscoveryInfo discoveryInfo = discoveryInfoDao.selectDiscoveryInfoByRecId(rec_id);
    	if(null!=discoveryInfo.getDiscoveryDetail().getGoodsIds()){
    		List<Goods> lstGoods = goodsDao.selectGoodsByGoodsIds(discoveryInfo.getDiscoveryDetail().getGoodsIds().split(","));
			discoveryInfo.getDiscoveryDetail().setLstGoods(lstGoods);
		}
    	result = discoveryInfo;
    	return result;
	}
	public List<DiscoveryInfo> selectDiscoveryInfos(Integer start,Integer length){
		List<DiscoveryInfo> result = new ArrayList<DiscoveryInfo>();
    	List<DiscoveryInfo> lstDiscoveryInfoRedis = discoveryInfoDao.selectDiscoveryInfos(start, length);
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
	
	
	
	public List<DiscoveryInfo> selectDiscoveryInfosOfTop(){
		
		List<DiscoveryInfo> result = new ArrayList<DiscoveryInfo>();
    	List<DiscoveryInfo> lstDiscoveryInfoRedis = discoveryInfoDao.selectDiscoveryInfosOfTop();
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
	
	public Message4Discovery selectMessage4Discovery(Integer p_id){
		return discoveryInfoDao.selectMessage4Discovery(p_id);
	}

}
