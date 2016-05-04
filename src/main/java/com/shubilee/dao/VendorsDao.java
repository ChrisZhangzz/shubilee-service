
package com.shubilee.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Cart;
import com.shubilee.entity.Vendors;

public interface VendorsDao {    
	public Vendors selectByPrimaryKey(@Param("vendor_id") Integer vendor_id);

	public List<Vendors> selectByPrimaryKeyList(@Param("vendorIdList")int[] vendorIdList);
}
