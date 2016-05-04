package com.shubilee.impl;

import java.math.BigDecimal;
import java.util.List;















import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.YamiConstant;
import com.shubilee.dao.BrandDao;
import com.shubilee.dao.CategoryDao;
import com.shubilee.dao.CollectGoodsDao;
import com.shubilee.dao.GoodsDao;
import com.shubilee.dao.KeywordsDao;
import com.shubilee.entity.BrandName;
import com.shubilee.entity.CategoryForShow;
import com.shubilee.entity.CollectGoods;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsComment;
import com.shubilee.entity.GoodsFlash;
import com.shubilee.entity.GoodsGallery;
import com.shubilee.entity.GoodsOfCatItems;
import com.shubilee.entity.Keywords;
import com.shubilee.service.CollectGoodsService;
import com.shubilee.service.GoodsService;

@Service
public class CollectGoodsServiceImpl implements CollectGoodsService{
	@Autowired
	private CollectGoodsDao collectGoodsDao;
	
    public List<Goods> selectGoodsByUid(int user_id,int start,int length){
    	return collectGoodsDao.selectGoodsByUid(user_id, start, length);
    }
    
    public int selectGoodsCountByUid(int user_id){
    	return collectGoodsDao.selectGoodsCountByUid(user_id);
    }
    
    public List<Goods> selectGoodsOfNotSaleByUid(int user_id){
    	return collectGoodsDao.selectGoodsOfNotSaleByUid(user_id);
    }
     
    public int deleteByGidAndUid(int goods_id,int user_id){
    	return collectGoodsDao.deleteByGidAndUid(goods_id, user_id);
    }

    public int insert(CollectGoods record){
    	return collectGoodsDao.insert(record);
    }
    
    public int selectGoodsCountByUidGid(int user_id,int goods_id){
    	return collectGoodsDao.selectGoodsCountByUidGid(user_id, goods_id);
    }
}
