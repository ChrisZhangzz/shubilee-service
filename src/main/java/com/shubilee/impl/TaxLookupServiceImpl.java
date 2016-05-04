package com.shubilee.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.ActivityDao;
import com.shubilee.dao.ActivityLookupDao;
import com.shubilee.dao.CartDao;
import com.shubilee.dao.TaxLookupDao;
import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityLookup;
import com.shubilee.entity.Cart;
import com.shubilee.entity.TaxLookup;
import com.shubilee.service.ActivityLookupService;
import com.shubilee.service.ActivityService;
import com.shubilee.service.CartService;
import com.shubilee.service.TaxLookupService;

@Service
public class TaxLookupServiceImpl implements TaxLookupService{

	@Autowired
	private TaxLookupDao taxLookupDao;
	
	
	public TaxLookup selectTax(String province,String zipcode){
			return taxLookupDao.getTax(province, zipcode);	
	}

}
