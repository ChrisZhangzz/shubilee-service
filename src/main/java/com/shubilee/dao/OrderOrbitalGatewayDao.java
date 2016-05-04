package com.shubilee.dao;


import com.shubilee.entity.OrderOrbitalGateway;

public interface OrderOrbitalGatewayDao {

    public int insert(OrderOrbitalGateway orderOrbitalGateway);
    public OrderOrbitalGateway selectOrderOrbitalGatewayByOrderId(int order_id);
    
}
