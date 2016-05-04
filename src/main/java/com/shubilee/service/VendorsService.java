package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Address;
import com.shubilee.entity.Profile;
import com.shubilee.entity.User;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserProfile;
import com.shubilee.entity.Vendors;

public interface VendorsService {
	public Vendors selectByPrimaryKey(Integer vendor_id);

}
