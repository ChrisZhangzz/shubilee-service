
package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsHot;
import com.shubilee.entity.GoodsOosRemind;



public interface GoodsOosRemindDao {  
	
    public List<Goods> selectGoodsOosRemindInfoByUserId(@Param("userId") int userId);
    public int insert(@Param("userId") int userId,@Param("goodsId") int goodsId);
    public int delete(@Param("userId") int userId,@Param("goodsId") int goodsId);
    public int checkRemindFlag(@Param("userId") int userId,@Param("goodsId") int goodsId);
}
