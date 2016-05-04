package com.shubilee.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.AddressDao;
import com.shubilee.dao.ProfileDao;
import com.shubilee.dao.UserDao;
import com.shubilee.dao.VendorsDao;
import com.shubilee.entity.Address;
import com.shubilee.entity.Profile;
import com.shubilee.entity.User;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserProfile;
import com.shubilee.entity.Vendors;
import com.shubilee.service.UserService;
import com.shubilee.service.VendorsService;

@Service
public class VendorsServiceImpl implements VendorsService {

	@Autowired
	private VendorsDao vendorsDao;

	public Vendors selectByPrimaryKey(Integer vendor_id){
		return vendorsDao.selectByPrimaryKey(vendor_id);
	}
}
