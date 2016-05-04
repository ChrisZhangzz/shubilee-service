
package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.ActivityLookup;

public interface ActivityLookupDao {    
	public List<ActivityLookup> selectActivityByActId(@Param("act_id") int act_id);
}