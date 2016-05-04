package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;









import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.BrandName;
import com.shubilee.entity.CategoryForShow;
import com.shubilee.entity.CollectGoods;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsComment;
import com.shubilee.entity.GoodsFlash;
import com.shubilee.entity.GoodsGallery;
import com.shubilee.entity.GoodsOfCatItems;
import com.shubilee.entity.Keywords;

public interface CollectGoodsService {
    public List<Goods> selectGoodsByUid(int user_id,int start,int length);
    
    public int selectGoodsCountByUid(int user_id);
    
    public List<Goods> selectGoodsOfNotSaleByUid(int user_id);
     
    public int deleteByGidAndUid(int goods_id,int user_id);

    public int insert(CollectGoods record);
    public int selectGoodsCountByUidGid(int user_id,int goods_id);
}
