
package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.GoodsHot;



public interface GoodsHotDao {  
	
    public List<GoodsHot> selectGoodsHot(@Param("page") int page);
}
