package com.shubilee.entity;

public class Brand {
    private Short brandId;

    private String brandName;

    private String brandEname;

    private String brandLogo;

    private String siteUrl;

    private Byte sortOrder;

    private Boolean isShow;

    private Boolean isIndexPage;

    private String alphabeticIndex;

    private Short brandCat;

    private String brandDesc;
    private int attrId;
    private String attrValue;
    private String attrEvalue;
    public Short getBrandId() {
        return brandId;
    }

    public void setBrandId(Short brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandEname() {
        return brandEname;
    }

    public void setBrandEname(String brandEname) {
        this.brandEname = brandEname == null ? null : brandEname.trim();
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo == null ? null : brandLogo.trim();
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl == null ? null : siteUrl.trim();
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsIndexPage() {
        return isIndexPage;
    }

    public void setIsIndexPage(Boolean isIndexPage) {
        this.isIndexPage = isIndexPage;
    }

    public String getAlphabeticIndex() {
        return alphabeticIndex;
    }

    public void setAlphabeticIndex(String alphabeticIndex) {
        this.alphabeticIndex = alphabeticIndex == null ? null : alphabeticIndex.trim();
    }

    public Short getBrandCat() {
        return brandCat;
    }

    public void setBrandCat(Short brandCat) {
        this.brandCat = brandCat;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc == null ? null : brandDesc.trim();
    }

	public int getAttrId() {
		return attrId;
	}

	public void setAttrId(int attrId) {
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