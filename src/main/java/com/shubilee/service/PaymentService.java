package com.shubilee.service;


import com.shubilee.entity.ExpressCheckout;
import com.shubilee.entity.OrderOrbitalGateway;
import com.shubilee.entity.OrderPaypal;


public interface PaymentService {
    public int insertExpressCheckout(ExpressCheckout expressCheckout);
    public ExpressCheckout selectExpressCheckoutByUid(int user_id);
    public int updatePayerIdByUid(ExpressCheckout expressCheckout);
    public int deleteExpressCheckoutByUid(int user_id);
    public int countExpressCheckoutByUid(int user_id);
    public int insertOrderOrbitalGateway(OrderOrbitalGateway orderOrbitalGateway);
    public OrderOrbitalGateway selectOrderOrbitalGatewayByOrderId(int order_id);
    public int insertOrderPaypal(OrderPaypal orderPaypal);
    public OrderPaypal selectOrderPaypalByOrderSn(String order_sn);
}
