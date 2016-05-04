package com.shubilee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.ExpressCheckoutDao;
import com.shubilee.dao.OrderOrbitalGatewayDao;
import com.shubilee.dao.OrderPaypalDao;
import com.shubilee.entity.ExpressCheckout;
import com.shubilee.entity.OrderOrbitalGateway;
import com.shubilee.entity.OrderPaypal;
import com.shubilee.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private ExpressCheckoutDao expressCheckoutDao;
	@Autowired
	private OrderOrbitalGatewayDao orderOrbitalGatewayDao;
	@Autowired
	private OrderPaypalDao orderPaypalDao;
	
	public int insertExpressCheckout(ExpressCheckout expressCheckout) {
		return expressCheckoutDao.insert(expressCheckout);
	}

	public ExpressCheckout selectExpressCheckoutByUid(int user_id) {
		return expressCheckoutDao.selectByUid(user_id);
	}

	public int updatePayerIdByUid(ExpressCheckout expressCheckout) {
		return expressCheckoutDao.updatePayerIdByUid(expressCheckout);
	}

	public int deleteExpressCheckoutByUid(int user_id) {
		return expressCheckoutDao.deleteByUid(user_id);
	}

	public int insertOrderOrbitalGateway(OrderOrbitalGateway orderOrbitalGateway) {
		return orderOrbitalGatewayDao.insert(orderOrbitalGateway);
	}

	public OrderOrbitalGateway selectOrderOrbitalGatewayByOrderId(int order_id) {
		return orderOrbitalGatewayDao.selectOrderOrbitalGatewayByOrderId(order_id);
	}

	public int insertOrderPaypal(OrderPaypal orderPaypal) {
		return orderPaypalDao.insert(orderPaypal);
	}

	public OrderPaypal selectOrderPaypalByOrderSn(String order_sn) {
		return orderPaypalDao.selectOrderPaypalByOrderSn(order_sn);
	}

	public int countExpressCheckoutByUid(int user_id) {
		return expressCheckoutDao.selectCountByUid(user_id);
	}

}
