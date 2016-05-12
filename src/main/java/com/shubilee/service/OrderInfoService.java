package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.common.WriteData;
import com.shubilee.entity.Cart;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.PurchaseInfo;

public interface OrderInfoService {

	public OrderInfo selectInvoiceNoByOrderId(int order_id);
	public int selectOrderInfoNumByOrderSn(String order_sn);
	public int insert(OrderInfo record);
    public int updatePurchaseIdByOrderId(int order_id,int purchase_id);
    public OrderInfo selectOrderInfoByOrderSn(String order_sn);
    public int updateOrderStatusByPurchaseId(int order_status,int shipping_status,int pay_status,int pay_time,int purchase_id);
    public List<OrderInfo> selectOrderInfo(int purchase_id);
	public int selectBlackListResult(int uid,String bank_card,String mobile);
	public BigDecimal selectOrderAmountByPurchaseId(int purchase_id);
	public int updateAbnormalByPurchaseId(int abnormal, int purchase_id);
	public String selectLastPayName(int uid);
	public List<PurchaseInfo> selectOrders(int uid,Integer table_year,Long startDate,Long endDate,Integer start,Integer length);
	public int selectOrdersCount(int uid,Integer table_year,Long startDate,Long endDate);
	public PurchaseInfo selectOrderByPurchaseId(int purchase_id);
}
