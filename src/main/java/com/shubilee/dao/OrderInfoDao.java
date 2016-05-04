package com.shubilee.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Count;
import com.shubilee.entity.GoodsImage;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.PurchaseInfo;

public interface OrderInfoDao {    
    public OrderInfo selectInvoiceNoByOrderId(@Param("order_id") int order_id);
    public int selectOrderInfoNumByOrderSn(@Param("order_sn") String order_sn);
    public OrderInfo selectOrderInfoByOrderSn(@Param("order_sn") String order_sn);
    public int insert(OrderInfo record);
    public int updatePurchaseIdByOrderId(@Param("order_id") int order_id,@Param("purchase_id") int purchase_id);
    public List<OrderInfo> selectOrderInfo(@Param("purchase_id") int purchase_id);
	public List<OrderInfo> selectPurchaseList(@Param("uid") int uid,@Param("index") int index, @Param("items_Per_Page")int items_Per_Page);
	public List<OrderInfo> selectPurchaseListById(@Param("uid") int uid, @Param("purchase_id") int purchase_id);
	
	
	public List<OrderInfo> selectOrderInfoByUid(@Param("uid") int uid, @Param("listPid") int[] listPid);
	public int selectPurchaseListCount(@Param("uid") int uid, @Param("index") int index, @Param("items_Per_Page") int items_Per_Page);
	public OrderInfo selectOrderInfoByOrderId(@Param("user_id") int user_id,@Param("order_id") int order_id);
	public int updateOrderStatusByPurchaseId(@Param("order_status") int order_status,@Param("shipping_status") int shipping_status,@Param("pay_status") int pay_status,@Param("pay_time") int pay_time,@Param("purchase_id") int purchase_id);
	public BigDecimal selectOrderAmountByPurchaseId(@Param("purchase_id") int purchase_id);
	public int updateAbnormalByPurchaseId(@Param("abnormal") int abnormal, @Param("purchase_id") int purchase_id);
	public int selectBlackListResult(@Param("uid") int uid, @Param("bank_card") String bank_card, @Param("mobile") String mobile);
	public String selectLastPayName(@Param("uid") int uid);
	public List<Count> getSumOfitemsbyOrdersIDList( @Param("orderIdList") int[] orderIdList);
	public List<GoodsImage> getImagesbyOrdersIDList( @Param("orderIdList") int[] orderIdList);
	public List<PurchaseInfo> selectOrders(@Param("uid") int uid,@Param("table_year") Integer table_year,@Param("startDate") Long startDate,@Param("endDate") Long endDate,@Param("start") Integer start,@Param("length") Integer length);
	public int selectOrdersCount(@Param("uid") int uid,@Param("table_year") Integer table_year,@Param("startDate") Long startDate,@Param("endDate") Long endDate);
	public PurchaseInfo selectOrderByPurchaseId(@Param("purchase_id") int purchase_id);
	public OrderInfo selectOrderInfoByOrderIdV2(@Param("uid") int uid,@Param("table_year") Integer table_year,@Param("order_id") int order_id);
}
