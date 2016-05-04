package com.shubilee.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class ComputerGoodResult {
	
    private Integer goods_id;

    private BigDecimal deal_price;

    private BigDecimal tax;

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public BigDecimal getDeal_price() {
		return deal_price;
	}

	public void setDeal_price(BigDecimal deal_price) {
		this.deal_price = deal_price;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
   




    
}
