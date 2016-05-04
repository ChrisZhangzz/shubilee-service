package com.shubilee.entity;

import java.math.BigDecimal;
import java.util.List;

public class Shipping {
    private Byte shippingId;

    private String shippingCode;

    private String shippingName;

    private String shippingDesc;

    private BigDecimal shippingFee;

    private BigDecimal freeShippingAmount;

    private String insure;

    private Boolean supportCod;

    private Boolean enabled;

    private String printBg;

    private Boolean printModel;

    private Byte shippingOrder;

    private Integer vendorId;
    
    private Integer isPrimary;
    
    private Integer ahFlag;
    
    private Integer zipcodeLimitId;
    
    List<ShippingDistrictZipcode> lstShippingDistrictZipcode;
    
    public Byte getShippingId() {
        return shippingId;
    }

    public void setShippingId(Byte shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    public String getShippingDesc() {
        return shippingDesc;
    }

    public void setShippingDesc(String shippingDesc) {
        this.shippingDesc = shippingDesc == null ? null : shippingDesc.trim();
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getFreeShippingAmount() {
        return freeShippingAmount;
    }

    public void setFreeShippingAmount(BigDecimal freeShippingAmount) {
        this.freeShippingAmount = freeShippingAmount;
    }

    public String getInsure() {
        return insure;
    }

    public void setInsure(String insure) {
        this.insure = insure == null ? null : insure.trim();
    }

    public Boolean getSupportCod() {
        return supportCod;
    }

    public void setSupportCod(Boolean supportCod) {
        this.supportCod = supportCod;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPrintBg() {
        return printBg;
    }

    public void setPrintBg(String printBg) {
        this.printBg = printBg == null ? null : printBg.trim();
    }

    public Boolean getPrintModel() {
        return printModel;
    }

    public void setPrintModel(Boolean printModel) {
        this.printModel = printModel;
    }

    public Byte getShippingOrder() {
        return shippingOrder;
    }

    public void setShippingOrder(Byte shippingOrder) {
        this.shippingOrder = shippingOrder;
    }

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Integer isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Integer getAhFlag() {
		return ahFlag;
	}

	public void setAhFlag(Integer ahFlag) {
		this.ahFlag = ahFlag;
	}

	public Integer getZipcodeLimitId() {
		return zipcodeLimitId;
	}

	public void setZipcodeLimitId(Integer zipcodeLimitId) {
		this.zipcodeLimitId = zipcodeLimitId;
	}

	public List<ShippingDistrictZipcode> getLstShippingDistrictZipcode() {
		return lstShippingDistrictZipcode;
	}

	public void setLstShippingDistrictZipcode(
			List<ShippingDistrictZipcode> lstShippingDistrictZipcode) {
		this.lstShippingDistrictZipcode = lstShippingDistrictZipcode;
	}




	
    
}