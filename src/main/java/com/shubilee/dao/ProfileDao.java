package com.shubilee.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Address;
import com.shubilee.entity.Profile;
import com.shubilee.entity.UserProfile;

public interface ProfileDao {

    public List<Profile> getProfileByUid(int user_id);
    public int insert(UserProfile profile);
    public int updateByPrimaryKey(UserProfile profile);
    public int deleteByPrimaryKey(String profile_id);
    public int countByPrimaryKey(String profile_id);
    public int countByUid(int user_id);
    public int updateByAddressId(@Param("user_id") int id,@Param("address_id") int address_id,@Param("profile_id") String profile_id);  
    public int updateAddressIdByPK(@Param("address_id") int address_id,@Param("profile_id") String profile_id);        
    public int updateIsPrimaryByPKUid(@Param("user_id") int id,@Param("profile_id") String profile_id);      
    public int updateIsPrimaryByUid(int user_id);
    public UserProfile selectByPrimaryKey(String profile_id);
    public UserProfile selectProfileDefaultByUid(@Param("user_id") int user_id);
}
