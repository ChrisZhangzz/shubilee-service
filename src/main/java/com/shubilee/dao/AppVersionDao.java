package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Address;
import com.shubilee.entity.AppVersion;
import com.shubilee.entity.UserAddress;

public interface AppVersionDao {

    public List<AppVersion> selectAppVersion();
    
}
