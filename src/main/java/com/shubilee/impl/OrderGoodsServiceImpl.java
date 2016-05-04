package com.shubilee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.WriteData;
import com.shubilee.dao.CartDao;
import com.shubilee.dao.OrderGenerateDao;
import com.shubilee.dao.OrderGoodsDao;
import com.shubilee.dao.OrderInfoDao;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.service.CartService;
import com.shubilee.service.OrderGenerateService;
import com.shubilee.service.OrderGoodsService;
import com.shubilee.service.OrderInfoService;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {
	@Autowired
	private OrderGoodsDao orderGoodsDao;

	public int insert(int order_id,int user_id,int vendor_id){
		return orderGoodsDao.insert(order_id, user_id, vendor_id);
	}
	
	public List<Goods> selectImagesbyOrdersId(int orderId){
		return orderGoodsDao.selectImagesbyOrdersId(orderId);
	}

	public List<OrderGoods> selectOrderGoodsByOrdersId(int order_id){
		return orderGoodsDao.selectOrderGoodsByOrdersId(order_id);
	}
	public int insertOne(OrderGoods orderGoods){
		return orderGoodsDao.insertOne(orderGoods);
	}
}
