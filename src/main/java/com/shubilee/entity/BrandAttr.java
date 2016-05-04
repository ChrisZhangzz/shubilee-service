package com.shubilee.entity;

public class BrandAttr {
    private Integer brandAttrId;

    private Integer brandId;

    private Short attrId;
    private String attrValue;

    private String attrEvalue;

    public Integer getBrandAttrId() {
        return brandAttrId;
    }

    public void setBrandAttrId(Integer brandAttrId) {
        this.brandAttrId = brandAttrId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Short getAttrId() {
        return attrId;
    }

    public void setAttrId(Short attrId) {
        this.attrId = attrId;
    }

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public String getAttrEvalue() {
		return attrEvalue;
	}

	public void setAttrEvalue(String attrEvalue) {
		this.attrEvalue = attrEvalue;
	}
    
}