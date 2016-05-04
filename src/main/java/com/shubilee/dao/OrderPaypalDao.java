package com.shubilee.dao;


import com.shubilee.entity.OrderPaypal;

public interface OrderPaypalDao {

    public int insert(OrderPaypal orderPaypal);
    public OrderPaypal selectOrderPaypalByOrderSn(String order_sn);
    
}
