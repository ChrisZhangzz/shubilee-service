package com.shubilee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.WriteData;
import com.shubilee.dao.CartDao;
import com.shubilee.dao.OrderGenerateDao;
import com.shubilee.entity.Cart;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.service.CartService;
import com.shubilee.service.OrderGenerateService;

@Service
public class OrderGenerateServiceImpl implements OrderGenerateService {
	@Autowired
	private OrderGenerateDao orderGenerateDao;

	public int addOrderGenerate(OrderGenerate orderGenerate) {
		return orderGenerateDao.insert(orderGenerate);
	}

	public int addOrderGenerateSelective(OrderGenerate record) {
		return orderGenerateDao.insertSelective(record);
	}

	public int updateOrderGenerateByTempId(OrderGenerate orderGenerate) {
		return orderGenerateDao.updateByTempId(orderGenerate);
	}

	public int updateOrderGenerateByUId(OrderGenerate orderGenerate) {
		return orderGenerateDao.updateByUId(orderGenerate);
	}

	public int updateUIdByTempId(OrderGenerate orderGenerate) {
		return orderGenerateDao.updateUIdByTempId(orderGenerate);
	}

	 public OrderGenerate selectOrderGenerateByTempId(String temp_id,int vendor_id){
		 return orderGenerateDao.selectOrderGenerateByTempIdAndVendorId(temp_id,vendor_id);
	 }
	 public OrderGenerate selectOrderGenerateByUserId(int user_Id,int vendor_id){
		 return orderGenerateDao.selectOrderGenerateByUserIdAndVendorId(user_Id,vendor_id);
	 }
	 public int deleteOrderGenerateByTempId(String temp_id){
		 return orderGenerateDao.deleteOrderGenerateByTempId(temp_id);
	 }
	 public int deleteOrderGenerateByUId(int user_id){
		 return orderGenerateDao.deleteOrderGenerateByUId(user_id);
	 }
	 public int deleteByTempIdAndVendorId(String temp_id,int vendor_id){
		 return orderGenerateDao.deleteByTempIdAndVendorId(temp_id, vendor_id);
	 }
	 public int deleteByUIdAndVendorId(int user_id,int vendor_id){
		 return orderGenerateDao.deleteByUIdAndVendorId(user_id, vendor_id);
	 }
	 public int selectCountByTempId(String temp_id){
		 return orderGenerateDao.countByTempId(temp_id);
	 }
	 public int selectCountByUserId(int user_id){
	    	 return orderGenerateDao.countByUserId(user_id);
	 }
	    public List<OrderGenerate> selectOrderGenerateByTempId(String temp_id){
	    	 return orderGenerateDao.selectOrderGenerateByTempId(temp_id);
	    }
	    public List<OrderGenerate> selectOrderGenerateByUserId(int user_Id){
	    	 return orderGenerateDao.selectOrderGenerateByUserId(user_Id);
	    }
	    
	    public int updateBonsIdByTempId(String temp_id,Integer bonus_id){
	    	return orderGenerateDao.updateBonsIdByTempId(temp_id, bonus_id);
	    }
	    public int updateBonsIdByUId( int user_id,Integer bonus_id){
	    	return orderGenerateDao.updateBonsIdByUId(user_id, bonus_id);
	    }
	    public int updateShippingIdByUId(int user_id,Integer shipping_id,Integer vendor_id){
	    	return orderGenerateDao.updateShippingIdByUId(user_id, shipping_id, vendor_id);
	    }
	    public int updateProfileIdByUId(int user_id,String profile_id){
	    	return orderGenerateDao.updateProfileIdByUId(user_id, profile_id);
	    }
	    public int updateShippingAddByUId(int user_id,Integer shipping_add){
	    	return orderGenerateDao.updateShippingAddByUId(user_id, shipping_add);
	    }
	    public int updatePointFlagByUId(int user_id,Integer point_flag){
	    	return orderGenerateDao.updatePointFlagByUId(user_id, point_flag);
	    }
}
