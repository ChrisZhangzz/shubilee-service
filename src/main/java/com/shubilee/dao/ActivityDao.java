
package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;

public interface ActivityDao {    
	public List<Activity> selectActivityByTime(@Param("time") Long time);
	public List<Activity> selectActivity(@Param("time") Long time);
}