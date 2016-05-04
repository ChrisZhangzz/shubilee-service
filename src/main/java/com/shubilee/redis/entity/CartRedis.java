package com.shubilee.redis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class CartRedis {
	

	private Integer goods_id;

    private Integer goods_number;
    
	private Integer is_gift;

	private Integer vendor_id;
	
	private Integer time;

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}


	public Integer getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(Integer goods_number) {
		this.goods_number = goods_number;
	}

	public Integer getIs_gift() {
		return is_gift;
	}

	public void setIs_gift(Integer is_gift) {
		this.is_gift = is_gift;
	}

	public Integer getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(Integer vendor_id) {
		this.vendor_id = vendor_id;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}





    
}
