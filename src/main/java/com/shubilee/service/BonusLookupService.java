package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityLookup;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.Vendors;



public interface BonusLookupService {
	
	public List<BonusLookup> selectBonusLookupByTypeId(int type_id);
	public int countNumByBonusTypeAndVendorId(int vendor_id,int bonus_id);
	public List<Vendors> selectVendorByBonusTypeId(int bonus_id);
	public int updateBonusCountByBonusTypeId(int type_id);
	public String selectBonusCountByBonusTypeId(int type_id);
}
