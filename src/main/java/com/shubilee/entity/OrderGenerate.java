package com.shubilee.entity;

import java.math.BigDecimal;

public class OrderGenerate {
	private String tempId;

    private Integer userId;

    private Integer bonusId;

    private Integer shippingId;

    private Integer shippingAdd;

    private String profileId;
    
    private Integer vendorId;

	private Integer pointFlag;

	private Shipping shipping;
	
	private Vendors vendors;	
	
	private UserAddress userAddress;
	
	private UserProfile userProfile;
	
	
	
	
	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Vendors getVendors() {
		return vendors;
	}

	public void setVendors(Vendors vendors) {
		this.vendors = vendors;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}





    
}