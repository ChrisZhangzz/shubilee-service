package com.shubilee.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.WriteData;
import com.shubilee.dao.CartDao;
import com.shubilee.dao.OrderGenerateDao;
import com.shubilee.dao.OrderInfoDao;
import com.shubilee.entity.Cart;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.PurchaseInfo;
import com.shubilee.service.CartService;
import com.shubilee.service.OrderGenerateService;
import com.shubilee.service.OrderInfoService;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
	@Autowired
	private OrderInfoDao orderInfoDao;

	public int selectOrderInfoNumByOrderSn(String order_sn){
		return orderInfoDao.selectOrderInfoNumByOrderSn(order_sn);
	}
	public int insert(OrderInfo record){
		return orderInfoDao.insert(record);
	}
    public int updatePurchaseIdByOrderId(int order_id,int purchase_id){
    	return orderInfoDao.updatePurchaseIdByOrderId(order_id, purchase_id);
    }
    public OrderInfo selectOrderInfoByOrderSn(String order_sn){
    	return orderInfoDao.selectOrderInfoByOrderSn(order_sn);
    }
    public int updateOrderStatusByPurchaseId(int order_status,int shipping_status,int pay_status,int pay_time,int purchase_id){
    	return orderInfoDao.updateOrderStatusByPurchaseId(order_status, shipping_status, pay_status,pay_time, purchase_id);
    }
    
    public List<OrderInfo> selectOrderInfo(int purchase_id){
    	return orderInfoDao.selectOrderInfo(purchase_id);
    }
	public OrderInfo selectInvoiceNoByOrderId(int order_id) {
		return orderInfoDao.selectInvoiceNoByOrderId(order_id);
	}
	public int selectBlackListResult(int uid,String bank_card,String mobile){
		return orderInfoDao.selectBlackListResult(uid,bank_card,mobile);
	}
	public BigDecimal selectOrderAmountByPurchaseId(int purchase_id) {
		return orderInfoDao.selectOrderAmountByPurchaseId(purchase_id);
	}
	public int updateAbnormalByPurchaseId(int abnormal, int purchase_id) {
		return orderInfoDao.updateAbnormalByPurchaseId(abnormal, purchase_id);
	}
	public String selectLastPayName(int uid){
		return orderInfoDao.selectLastPayName(uid);
	}
	public List<PurchaseInfo> selectOrders(int uid,Integer table_year,Long startDate,Long endDate,Integer start,Integer length){
		return orderInfoDao.selectOrders(uid, table_year, startDate, endDate, start, length);
	}
	public int selectOrdersCount(int uid,Integer table_year,Long startDate,Long endDate){
		return orderInfoDao.selectOrdersCount(uid, table_year, startDate, endDate);
	}
	public PurchaseInfo selectOrderByPurchaseId(int purchase_id){
		return orderInfoDao.selectOrderByPurchaseId(purchase_id);
	}
}
