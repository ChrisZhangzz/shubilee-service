package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;




































import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Brand;
import com.shubilee.entity.BrandAttr;
import com.shubilee.entity.BrandHot;
import com.shubilee.entity.BrandName;
import com.shubilee.entity.CategoryForShow;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsAggregate;
import com.shubilee.entity.GoodsComment;
import com.shubilee.entity.GoodsDisplayApp;
import com.shubilee.entity.GoodsDisplayDkp;
import com.shubilee.entity.GoodsFlash;
import com.shubilee.entity.GoodsGallery;
import com.shubilee.entity.GoodsHot;
import com.shubilee.entity.GoodsOfCatItems;
import com.shubilee.entity.Keywords;
import com.shubilee.entity.Message;
import com.shubilee.entity.MessageComment;
import com.shubilee.entity.MessageImage;
import com.shubilee.entity.MessagePost;
import com.shubilee.entity.SearchBar;
import com.shubilee.entity.ShopDistrictZipcode;
import com.shubilee.entity.YmZipcode;
import com.shubilee.redis.entity.YmZipcodeRedis;

public interface GoodsRedisService {
	

	public void insertShopZipcode(ShopDistrictZipcode record);
	public Boolean checkShopZipcode(int ruleId);
	public List<ShopDistrictZipcode> selectShopZipcode(int ruleId);
}
