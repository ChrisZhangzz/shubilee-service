package com.shubilee.entity;

public class Vendors {
    private Integer vendorId;

    private String vendorName;

    private String vendorEname;

    private String quality;

    private String qualityEn;

    private String points;

    private String pointsEn;

    private String returnPolicy;

    private String returnPolicyEn;

    private String delivery;

    private String deliveryEn;

    private Integer ahFlag;
    
    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName == null ? null : vendorName.trim();
    }

    public String getVendorEname() {
        return vendorEname;
    }

    public void setVendorEname(String vendorEname) {
        this.vendorEname = vendorEname == null ? null : vendorEname.trim();
    }

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getQualityEn() {
		return qualityEn;
	}

	public void setQualityEn(String qualityEn) {
		this.qualityEn = qualityEn;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getPointsEn() {
		return pointsEn;
	}

	public void setPointsEn(String pointsEn) {
		this.pointsEn = pointsEn;
	}

	public String getReturnPolicy() {
		return returnPolicy;
	}

	public void setReturnPolicy(String returnPolicy) {
		this.returnPolicy = returnPolicy;
	}

	public String getReturnPolicyEn() {
		return returnPolicyEn;
	}

	public void setReturnPolicyEn(String returnPolicyEn) {
		this.returnPolicyEn = returnPolicyEn;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getDeliveryEn() {
		return deliveryEn;
	}

	public void setDeliveryEn(String deliveryEn) {
		this.deliveryEn = deliveryEn;
	}

	public Integer getAhFlag() {
		return ahFlag;
	}

	public void setAhFlag(Integer ahFlag) {
		this.ahFlag = ahFlag;
	}
    
	
}