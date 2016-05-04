package com.shubilee.entity;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseInfo {

    private Integer purchaseId;

    private List<OrderInfo> lstOrderInfo;

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public List<OrderInfo> getLstOrderInfo() {
		return lstOrderInfo;
	}

	public void setLstOrderInfo(List<OrderInfo> lstOrderInfo) {
		this.lstOrderInfo = lstOrderInfo;
	}
    
    
    
    
}
