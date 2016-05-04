package com.shubilee.entity;

import java.math.BigDecimal;

public class UserInfoOrderMaxGoods {
	private Integer goodsId;
	
	private String goodsName;

	private String goodsEname;
	
	private String goodsImg;
	 
	private Integer totalNum;

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsEname() {
		return goodsEname;
	}

	public void setGoodsEname(String goodsEname) {
		this.goodsEname = goodsEname;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	
	
}