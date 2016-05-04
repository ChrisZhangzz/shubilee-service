package com.shubilee.redis.entity;

import java.math.BigDecimal;

public class YmZipcodeRedis {

    private Integer zip;

    private String primaryCity;

    private String state;

    private String county;

    private Byte sdZone;

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getPrimaryCity() {
		return primaryCity;
	}

	public void setPrimaryCity(String primaryCity) {
		this.primaryCity = primaryCity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Byte getSdZone() {
		return sdZone;
	}

	public void setSdZone(Byte sdZone) {
		this.sdZone = sdZone;
	}

	
	
}