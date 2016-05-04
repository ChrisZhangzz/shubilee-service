package com.shubilee.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.ActivityDao;
import com.shubilee.dao.CartDao;
import com.shubilee.dao.ShippingDao;
import com.shubilee.entity.Activity;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Shipping;
import com.shubilee.service.ActivityService;
import com.shubilee.service.CartService;
import com.shubilee.service.ShippingService;

@Service
public class ShippingServiceImpl implements ShippingService{

	@Autowired
	private ShippingDao shippingDao;
	
	
	public Shipping selectShippinginfo(Byte shipping_id ){
		return shippingDao.selectShippinginfo(shipping_id);
	}
	public List<Shipping> selectShippingList(){
		return shippingDao.selectShippingList();
	}
	public List<Shipping> selectShippingListByVendorId(int vendor_id ){
		return shippingDao.selectShippingListByVendorId(vendor_id);
	}
	public BigDecimal selectFreeAmountByVendorId(int vendor_id ){
		return shippingDao.selectFreeAmountByVendorId(vendor_id);
	}
}
