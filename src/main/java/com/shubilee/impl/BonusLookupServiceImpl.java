package com.shubilee.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.ActivityDao;
import com.shubilee.dao.ActivityLookupDao;
import com.shubilee.dao.BonusLookupDao;
import com.shubilee.dao.CartDao;
import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityLookup;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Vendors;
import com.shubilee.service.ActivityLookupService;
import com.shubilee.service.ActivityService;
import com.shubilee.service.BonusLookupService;
import com.shubilee.service.CartService;

@Service
public class BonusLookupServiceImpl implements BonusLookupService{

	@Autowired
	private BonusLookupDao bonusLookupDao;
	
	
	public List<BonusLookup> selectBonusLookupByTypeId(int type_id){
		return 	bonusLookupDao.selectBonusLookupByTypeId(type_id);
	}
	public int countNumByBonusTypeAndVendorId(int vendor_id,int bonus_id){
		return 	bonusLookupDao.countNumByBonusTypeAndVendorId(vendor_id, bonus_id);
	}
	public List<Vendors> selectVendorByBonusTypeId(int bonus_id){
		return 	bonusLookupDao.selectVendorByBonusTypeId(bonus_id);
	}
	public int updateBonusCountByBonusTypeId(int type_id){
		return 	bonusLookupDao.updateBonusCountByBonusTypeId(type_id);
	}
	public String selectBonusCountByBonusTypeId(int type_id){
		return bonusLookupDao.selectBonusCountByBonusTypeId(type_id);
	}
}
