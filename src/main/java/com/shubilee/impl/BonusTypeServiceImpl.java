package com.shubilee.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.ActivityDao;
import com.shubilee.dao.ActivityLookupDao;
import com.shubilee.dao.BonusLookupDao;
import com.shubilee.dao.BonusTypeDao;
import com.shubilee.dao.CartDao;
import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityLookup;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Vendors;
import com.shubilee.service.ActivityLookupService;
import com.shubilee.service.ActivityService;
import com.shubilee.service.BonusLookupService;
import com.shubilee.service.BonusTypeService;
import com.shubilee.service.CartService;

@Service
public class BonusTypeServiceImpl implements BonusTypeService{

	@Autowired
	private BonusTypeDao bonusTypeDao;
	
	
	public BonusType selectBonusType(int bonus_id){
		return bonusTypeDao.selectBonusType(bonus_id);
	}
}
