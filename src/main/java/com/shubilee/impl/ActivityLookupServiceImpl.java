package com.shubilee.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.ActivityDao;
import com.shubilee.dao.ActivityLookupDao;
import com.shubilee.dao.CartDao;
import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityLookup;
import com.shubilee.entity.Cart;
import com.shubilee.service.ActivityLookupService;
import com.shubilee.service.ActivityService;
import com.shubilee.service.CartService;

@Service
public class ActivityLookupServiceImpl implements ActivityLookupService{

	@Autowired
	private ActivityLookupDao activityLookupDao;
	
	
	public List<ActivityLookup> selectActivityByActId(int act_id){
			List<ActivityLookup> result = activityLookupDao.selectActivityByActId(act_id);
			return result;	
	}

}
