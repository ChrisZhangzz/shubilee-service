
package com.shubilee.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.OrderGenerate;

public interface OrderGenerateDao {    

    public int insert(OrderGenerate orderGenerate);
    public int insertSelective(OrderGenerate record);
    public int updateByTempId(@Param("orderGenerate") OrderGenerate orderGenerate);
    public int updateByUId(@Param("orderGenerate") OrderGenerate orderGenerate);
    public int updateBonsIdByTempId(@Param("temp_id") String temp_id,@Param("bonus_id") Integer bonus_id);
    public int updateBonsIdByUId(@Param("user_id") int user_id,@Param("bonus_id") Integer bonus_id);
    public int updateShippingIdByUId(@Param("user_id") int user_id,@Param("shipping_id") Integer shipping_id,@Param("vendor_id") Integer vendor_id);
    public int updateProfileIdByUId(@Param("user_id") int user_id,@Param("profile_id") String profile_id);
    public int updateShippingAddByUId(@Param("user_id") int user_id,@Param("shipping_add") Integer shipping_add);
    public int updatePointFlagByUId(@Param("user_id") int user_id,@Param("point_flag") Integer point_flag);
    public int deleteByTempIdAndVendorId(@Param("temp_id") String temp_id,@Param("vendor_id") int vendor_id);
    public int deleteByUIdAndVendorId(@Param("user_id") int user_id,@Param("vendor_id") int vendor_id);
    public int updateUIdByTempId(@Param("orderGenerate") OrderGenerate orderGenerate);
    public int countByTempId(@Param("temp_id") String temp_id);
    public int countByUserId(@Param("user_id") int user_id);
    public OrderGenerate selectOrderGenerateByTempIdAndVendorId(@Param("temp_id") String temp_id,@Param("vendor_id") int vendor_id);
    public OrderGenerate selectOrderGenerateByUserIdAndVendorId(@Param("user_id") int user_id,@Param("vendor_id") int vendor_id);
    public int deleteOrderGenerateByTempId(@Param("temp_id") String temp_id);
    public int deleteOrderGenerateByUId(@Param("user_id") int user_id);
    public List<OrderGenerate> selectOrderGenerateByTempId(@Param("temp_id") String temp_id);
    public List<OrderGenerate> selectOrderGenerateByUserId(@Param("user_id") int user_id);
}
