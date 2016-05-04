package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.ActivityGift;



public interface ActivityGiftService {
	
	public int countByGid(int gid);
	
	public List<ActivityGift> selectActivityGiftByActId(int act_id);

}
