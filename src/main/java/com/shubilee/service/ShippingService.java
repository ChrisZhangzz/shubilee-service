package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;
import com.shubilee.entity.Shipping;



public interface ShippingService {
	
	public Shipping selectShippinginfo(Byte shipping_id );
	public List<Shipping> selectShippingList();
	public List<Shipping> selectShippingListByVendorId(int vendor_id );
	public BigDecimal selectFreeAmountByVendorId(int vendor_id );
}
