package com.shubilee.entity;

import java.math.BigDecimal;

public class BrandName {

	private short brand_id;
    
    private String brand_name;
    
    private String brand_ename;

	private String alphabetic_index;
	
	public short getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(short brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getBrand_ename() {
		return brand_ename;
	}

	public void setBrand_ename(String brand_ename) {
		this.brand_ename = brand_ename;
	}

    public String getAlphabetic_index() {
		return alphabetic_index;
	}

	public void setAlphabetic_index(String alphabetic_index) {
		this.alphabetic_index = alphabetic_index;
	}


}