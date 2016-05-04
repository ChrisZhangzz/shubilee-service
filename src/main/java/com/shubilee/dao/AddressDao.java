package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Address;
import com.shubilee.entity.UserAddress;

public interface AddressDao {

    public List<UserAddress> getAddressBookByUid(int id);
    public UserAddress getAddressBookByAddid(@Param("addId") int addId);
    public UserAddress getAddressDefaultByUid(int id);
    public int insert(UserAddress userAddress);
    public int updateByPrimaryKey(UserAddress userAddress);
    public int deleteByPrimaryKey(int address_id);
    public int countByPrimaryKey(int address_id);
    public int countByUid(int user_id);
    public int updateIsPrimaryByPKUid(@Param("user_id") int id,@Param("address_id") int address_id);      
    public int updateIsPrimaryByUid(int user_id);
    
}
