
package com.shubilee.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;
import com.shubilee.entity.Shipping;




public interface ShippingDao {    
	public Shipping selectShippinginfo(@Param("shipping_id") Byte shipping_id );
	public List<Shipping> selectShippingList();
	public List<Shipping> selectShippingListByVendorId(@Param("vendor_id") int vendor_id );
	public BigDecimal selectFreeAmountByVendorId(@Param("vendor_id") int vendor_id );
}