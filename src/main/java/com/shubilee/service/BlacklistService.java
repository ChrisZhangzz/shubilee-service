package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.ActivityGift;
import com.shubilee.entity.Blacklist;



public interface BlacklistService {
		
	public int insert(Blacklist blacklist);
	public int selectCountByBankCard(String bank_card);
	public int selectCountByUserId(int user_id);

}
