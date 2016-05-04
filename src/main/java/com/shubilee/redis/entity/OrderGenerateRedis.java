package com.shubilee.redis.entity;

import java.math.BigDecimal;

public class OrderGenerateRedis {

    private Integer bonusId;

    private Integer shippingId;

    private Integer shippingAdd;

    private String profileId;
    
    private Integer vendorId;

	private Integer pointFlag;
	
	private Integer time;

	public Integer getBonusId() {
		return bonusId;
	}

	public void setBonusId(Integer bonusId) {
		this.bonusId = bonusId;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public Integer getShippingAdd() {
		return shippingAdd;
	}

	public void setShippingAdd(Integer shippingAdd) {
		this.shippingAdd = shippingAdd;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getPointFlag() {
		return pointFlag;
	}

	public void setPointFlag(Integer pointFlag) {
		this.pointFlag = pointFlag;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}
	
	
}