package com.shubilee.service;

import java.util.List;

import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityLookup;



public interface ActivityLookupService {
	
	public List<ActivityLookup> selectActivityByActId(int act_id);

}
