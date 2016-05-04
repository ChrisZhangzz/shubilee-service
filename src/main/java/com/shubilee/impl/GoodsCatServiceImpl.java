package com.shubilee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.GoodsCatDao;
import com.shubilee.dao.GoodsDao;
import com.shubilee.entity.Goods;
import com.shubilee.service.GoodsCatService;
import com.shubilee.service.GoodsService;

@Service
public class GoodsCatServiceImpl implements GoodsCatService{
	@Autowired
	private GoodsCatDao goodsCatDao;
	
		
	public String selectCartidByGid(int goods_id){
		
		return goodsCatDao.selectCartidByGid(goods_id);
	}
}
