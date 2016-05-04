package com.shubilee.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.ActivityDao;
import com.shubilee.dao.CartDao;
import com.shubilee.entity.Activity;
import com.shubilee.entity.Cart;
import com.shubilee.service.ActivityService;
import com.shubilee.service.CartService;

@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private ActivityDao activityDao;
	
	
	public List<Activity> selectActivityByTime(Long time){
			List<Activity> result = activityDao.selectActivityByTime(time);
			return result;	
	}
	public List<Activity> selectActivity(Long time){
		return activityDao.selectActivity(time);
	}
}
