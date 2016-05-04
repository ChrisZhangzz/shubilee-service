package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Address;
import com.shubilee.entity.TaxLookup;
import com.shubilee.entity.UserAddress;

public interface TaxLookupDao {

    public TaxLookup getTax(@Param("province") String province,@Param("zipcode") String zipcode);
}
