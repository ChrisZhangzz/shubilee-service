package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.common.WriteData;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.User;

public interface OrderGoodsService {
	
	public int insert(int order_id,int user_id,int vendor_id);
	
	public List<Goods> selectImagesbyOrdersId(int orderId);

	public List<OrderGoods> selectOrderGoodsByOrdersId(int order_id);
	
	public int insertOne(OrderGoods orderGoods);
}
