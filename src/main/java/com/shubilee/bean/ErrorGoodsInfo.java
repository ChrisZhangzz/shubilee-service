package com.shubilee.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ErrorGoodsInfo {
	
    private int goods_id;
    private String goods_name;
    private String goods_ename;
    private String error_message;
    private String error_emessage;
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_ename() {
		return goods_ename;
	}
	public void setGoods_ename(String goods_ename) {
		this.goods_ename = goods_ename;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	public String getError_emessage() {
		return error_emessage;
	}
	public void setError_emessage(String error_emessage) {
		this.error_emessage = error_emessage;
	}
	
    

    
}
