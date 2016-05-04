package com.shubilee.entity;

import java.math.BigDecimal;

public class UserInfoOrderMaxCat {
private Integer catId;
	
	private String catName;

	private String catEname;
	 
	private Integer totalNum;

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatEname() {
		return catEname;
	}

	public void setCatEname(String catEname) {
		this.catEname = catEname;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	
}