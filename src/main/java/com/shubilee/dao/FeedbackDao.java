
package com.shubilee.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Brand;
import com.shubilee.entity.BrandName;
import com.shubilee.entity.Feedback;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsOfCatItems;

public interface FeedbackDao {  
	
	public int insert(Feedback feedback);

	public List<Feedback> selectFeedback(@Param("user_id") int user_id);
}