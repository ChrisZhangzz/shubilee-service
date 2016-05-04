package com.shubilee.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.ActivityGiftDao;
import com.shubilee.entity.ActivityGift;
import com.shubilee.service.ActivityGiftService;

@Service
public class ActivityGiftServiceImpl implements ActivityGiftService{

	@Autowired
	private ActivityGiftDao activityGiftDao;
	
	
	public int countByGid(int gid) {
		int result = activityGiftDao.countByGid(gid);
		
		return result;
  
	}
	public List<ActivityGift> selectActivityGiftByActId(int act_id){
		return activityGiftDao.selectActivityGiftByActId(act_id);
	}

}
