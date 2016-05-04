
package com.shubilee.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.CollectGoods;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsComment;
import com.shubilee.entity.GoodsFlash;
import com.shubilee.entity.GoodsGallery;
import com.shubilee.entity.GoodsOfCatItems;

public interface CollectGoodsDao {  
	
    public List<Goods> selectGoodsByUid(@Param("user_id") int user_id,@Param("start") int start,@Param("length") int length);
    
    public List<Goods> selectGoodsOfNotSaleByUid(@Param("user_id") int user_id);
    
    public int selectGoodsCountByUid(@Param("user_id") int user_id);
    
    public int selectGoodsCountByUidGid(@Param("user_id") int user_id,@Param("goods_id") int goods_id);
     
    public int deleteByGidAndUid(@Param("goods_id") int goods_id,@Param("user_id") int user_id);

    public int insert(CollectGoods record);
    
    

}