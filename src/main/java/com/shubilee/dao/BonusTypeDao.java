
package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityLookup;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Vendors;




public interface BonusTypeDao {    
	public BonusType selectBonusType(@Param("bonus_id") int bonus_id);

	
}