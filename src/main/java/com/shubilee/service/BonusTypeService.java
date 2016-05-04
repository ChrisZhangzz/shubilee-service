package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityLookup;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Vendors;



public interface BonusTypeService {
	
	public BonusType selectBonusType(int bonus_id);
}
