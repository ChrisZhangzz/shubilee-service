package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Goods;

public interface GoodsCatService {
	public String selectCartidByGid(int goods_id);
}
