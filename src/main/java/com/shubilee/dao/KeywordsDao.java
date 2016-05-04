
package com.shubilee.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsFlash;
import com.shubilee.entity.GoodsGallery;
import com.shubilee.entity.GoodsOfCatItems;
import com.shubilee.entity.Keywords;

public interface KeywordsDao {  
	 
    public List<Keywords> selectKeywords(@Param("cat_id") Integer cat_id,@Param("priority") Integer priority,@Param("count") Integer count);

}