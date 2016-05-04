package com.shubilee.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.AddressDao;
import com.shubilee.dao.ProfileDao;
import com.shubilee.dao.ShippingDao;
import com.shubilee.dao.VendorsDao;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.Token;
import com.shubilee.redis.dao.OrderGenerateRedisDao;
import com.shubilee.redis.entity.OrderGenerateRedis;
import com.shubilee.service.OrderGenerateRedisService;

@Service
public class OrderGenerateRedisServiceImpl implements OrderGenerateRedisService{
	@Autowired
	private OrderGenerateRedisDao orderGenerateRedisDao;
	@Autowired
	private ShippingDao shippingDao;
	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private VendorsDao vendorsDao;
	@Autowired
	private AddressDao addressDao;
	public void insert(Token token,OrderGenerateRedis record)throws Exception{
		orderGenerateRedisDao.insert(token, record);
	}
    public void update(Token token,OrderGenerateRedis record)throws Exception{
    	orderGenerateRedisDao.update(token, record);
    }
    public void delete(Token token,int goods_id){
    	orderGenerateRedisDao.delete(token, goods_id);
    }
    public void deleteAll(Token token){
    	orderGenerateRedisDao.deleteAll(token);
    }
    public OrderGenerateRedis select(Token token,int goods_id){
    	return orderGenerateRedisDao.select(token, goods_id);
    }
    public List<OrderGenerateRedis> selectAll(Token token){
    	return orderGenerateRedisDao.selectAll(token);
    }
    public Boolean check(Token token,int goods_id){
    	return orderGenerateRedisDao.check(token, goods_id);
    }
    public Boolean checkAll(Token token){
    	return orderGenerateRedisDao.checkAll(token);
    }
    public List<OrderGenerate> selectAllForOrderGenerate(Token token){
    	List<OrderGenerateRedis> lstOrderGenerateRedis = orderGenerateRedisDao.selectAll(token);
    	List<OrderGenerate> result = new ArrayList<OrderGenerate>();
    	for(OrderGenerateRedis orderGenerateRedis:lstOrderGenerateRedis){
    		OrderGenerate orderGenerate = new OrderGenerate();
    		orderGenerate.setBonusId(orderGenerateRedis.getBonusId());
    		orderGenerate.setPointFlag(orderGenerateRedis.getPointFlag());
    		if(null!=orderGenerateRedis.getShippingId()){
	    		orderGenerate.setShippingId(orderGenerateRedis.getShippingId());
	    		orderGenerate.setShipping(shippingDao.selectShippinginfo(orderGenerateRedis.getShippingId().byteValue()));
    		}
    		if(null!=orderGenerateRedis.getProfileId()){
	    		orderGenerate.setProfileId(orderGenerateRedis.getProfileId());
	    		orderGenerate.setUserProfile(profileDao.selectByPrimaryKey(orderGenerateRedis.getProfileId()));
    		}
    		if(null!=orderGenerateRedis.getVendorId()){
    		orderGenerate.setVendorId(orderGenerateRedis.getVendorId());
    		orderGenerate.setVendors(vendorsDao.selectByPrimaryKey(orderGenerateRedis.getVendorId()));
    		}
    		if(null!=orderGenerateRedis.getShippingAdd()){
    		orderGenerate.setShippingAdd(orderGenerateRedis.getShippingAdd());
    		orderGenerate.setUserAddress(addressDao.getAddressBookByAddid(orderGenerateRedis.getShippingAdd()));
    		}
    		result.add(orderGenerate);
    	}
    	return result;
    	
    }
}
