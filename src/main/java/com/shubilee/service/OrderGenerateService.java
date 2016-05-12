package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.common.WriteData;
import com.shubilee.entity.Cart;
import com.shubilee.entity.OrderGenerate;

public interface OrderGenerateService {
	
    public int addOrderGenerate(OrderGenerate orderGenerate);
    public int addOrderGenerateSelective(OrderGenerate record);
    public int updateOrderGenerateByTempId(OrderGenerate orderGenerate);
    public int updateOrderGenerateByUId(OrderGenerate orderGenerate);
    public int updateUIdByTempId(OrderGenerate orderGenerate);
    public OrderGenerate selectOrderGenerateByTempId(String temp_id, int vendor_id);
    public OrderGenerate selectOrderGenerateByUserId(int user_Id, int vendor_id);
    public List<OrderGenerate> selectOrderGenerateByTempId(String temp_id);
    public List<OrderGenerate> selectOrderGenerateByUserId(int user_Id);
    public int deleteOrderGenerateByTempId(String temp_id);
    public int deleteOrderGenerateByUId(int user_id);
    public int deleteByTempIdAndVendorId(String temp_id,int vendor_id);
    public int deleteByUIdAndVendorId(int user_id,int vendor_id);
    public int selectCountByTempId(String temp_id);
    public int selectCountByUserId(int user_id);
    public int updateBonsIdByTempId(String temp_id,Integer bonus_id);
    public int updateBonsIdByUId( int user_id,Integer bonus_id);
    public int updateShippingIdByUId(int user_id,Integer shipping_id,Integer vendor_id);
    public int updateProfileIdByUId(int user_id,String profile_id);
    public int updateShippingAddByUId(int user_id,Integer shipping_add);
    public int updatePointFlagByUId(int user_id,Integer point_flag);
}
