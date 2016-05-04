
package com.shubilee.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.CategoryForShow;
import com.shubilee.entity.Integral;



public interface IntegralDao {  

	public void insertIntegral(@Param("integral") String addIntergralForRegister,@Param("user_id") int uid, @Param("date")long time,@Param("type") int type);
	public int insertSelective(Integral record);
}