
package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityLookup;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.Vendors;




public interface BonusLookupDao {    
	public List<BonusLookup> selectBonusLookupByTypeId(@Param("type_id") int type_id);
	public int countNumByBonusTypeAndVendorId(@Param("vendor_id") int vendor_id,@Param("bonus_id") int bonus_id);
	public List<Vendors> selectVendorByBonusTypeId(@Param("bonus_id") int bonus_id);
	public int updateBonusCountByBonusTypeId(@Param("bonus_id") int type_id);
	public String selectBonusCountByBonusTypeId(@Param("bonus_id") int type_id);
	
}