package com.shubilee.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.BlacklistDao;
import com.shubilee.entity.Blacklist;
import com.shubilee.service.BlacklistService;

@Service
public class BlacklistServiceImpl implements BlacklistService{

	@Autowired
	private BlacklistDao blacklistDao;
	
	
	public int insert(Blacklist blacklist){
		return blacklistDao.insert(blacklist);
	}


	public int selectCountByBankCard(String bank_card) {
		return blacklistDao.selectCountByBankCard(bank_card);
	}


	public int selectCountByUserId(int user_id) {
		return blacklistDao.selectCountByUserId(user_id);
	}

}
