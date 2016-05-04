package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;
import com.shubilee.entity.TaxLookup;



public interface TaxLookupService {
	
	public TaxLookup selectTax(String province,String zipcode);

}
