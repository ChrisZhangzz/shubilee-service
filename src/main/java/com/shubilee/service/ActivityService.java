package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;



public interface ActivityService {
	
	public List<Activity> selectActivityByTime(Long time);
	public List<Activity> selectActivity(Long time);

}
