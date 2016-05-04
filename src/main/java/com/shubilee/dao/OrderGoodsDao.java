package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;

public interface OrderGoodsDao {    
	public int insert(@Param("order_id") int order_id,@Param("user_id") int user_id,@Param("vendor_id") int vendor_id);

	public int insertOne(OrderGoods orderGoods);
	
	public int selectSumOfitemsbyOrdersId(@Param("order_id") int orderId);

	public List<Goods> selectImagesbyOrdersId(@Param("order_id") int orderId);

	public List<OrderGoods> selectOrderGoodsByOrdersId(@Param("order_id") int order_id);
	
	public List<OrderGoods> selectOrderGoodsByOrdersIDList(@Param("orderIdList") int[] orderIdList);

}
