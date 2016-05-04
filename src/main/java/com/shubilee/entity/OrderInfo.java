package com.shubilee.entity;

import java.math.BigDecimal;
import java.util.List;

public class OrderInfo {
    private Integer order_id;
    
    private String orderSn;

    private Integer purchaseId;

    private Integer userId;

    private Integer orderStatus;

    private Integer shippingStatus;

    private Integer payStatus;

    private String consignee;
    
    private Integer vendorId;
    
    private String vendorName;
    
    private String vendorEname;
    
    private String country;

    private String province;

    private String city;

    private String district;

    private String address;

    private String address2;

    private String zipcode;

    private String tel;

    private String mobile;

    private String email;

    private String bestTime;

    private String signBuilding;

    private String postscript;

    private Byte shippingId;

    private String shippingName;

    private Byte payId;

    private String payName;
    
    private String profileId;

    private String firstname;

    private String lastname;

    private String cardType;

    private Integer tail;

    private String expYear;

    private String expMonth;

    private String howOos;

    private String howSurplus;

    private String packName;

    private String cardName;

    private String cardMessage;

    private String invPayee;

    private String invContent;

    private BigDecimal costAmount;

    private BigDecimal goodsAmount;

    private BigDecimal shippingFee;

    private BigDecimal insureFee;

    private BigDecimal payFee;

    private BigDecimal packFee;

    private BigDecimal cardFee;

    private BigDecimal moneyPaid;

    private BigDecimal surplus;

    private Integer integral;

    private BigDecimal integralMoney;

    private BigDecimal giftCardMoney;

    private BigDecimal bonus;

    private BigDecimal orderAmount;

    private Short fromAd;

    private String referer;

    private Integer addTime;

    private Integer confirmTime;

    private Integer payTime;

    private Integer shippingTime;

    private Byte packId;

    private Byte cardId;

    private Integer bonusId;

    private String invoiceNo;

    private String extensionCode;

    private Integer extensionId;

    private String toBuyer;

    private String payNote;

    private Short agencyId;

    private Long adTrackId;

    private String invType;

    private BigDecimal tax;

    private Boolean isSeparate;

    private Integer parentId;

    private BigDecimal discount;

    private String countryZd;

    private String provinceZd;

    private String cityZd;

    private String addressZd;

    private String address2Zd;

    private String consigneeZd;

    private String zipcodeZd;

    private String mobileZd;

    private String telZd;

    private String emailZd;

    private String lang;

    private Integer gift;

    private String ip;
    private Byte abnormal;
    private String userAgent;
    private Integer sourceFlag;
    private String shippingMethod;
    
    private List<OrderGoods> lstOrderGoods;
    
    private String bonusSn;
    
    public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

 

    public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(Integer shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2 == null ? null : address2.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getBestTime() {
        return bestTime;
    }

    public void setBestTime(String bestTime) {
        this.bestTime = bestTime == null ? null : bestTime.trim();
    }

    public String getSignBuilding() {
        return signBuilding;
    }

    public void setSignBuilding(String signBuilding) {
        this.signBuilding = signBuilding == null ? null : signBuilding.trim();
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript == null ? null : postscript.trim();
    }

    public Byte getShippingId() {
        return shippingId;
    }

    public void setShippingId(Byte shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    public Byte getPayId() {
        return payId;
    }

    public void setPayId(Byte payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    public String getHowOos() {
        return howOos;
    }

    public void setHowOos(String howOos) {
        this.howOos = howOos == null ? null : howOos.trim();
    }

    public String getHowSurplus() {
        return howSurplus;
    }

    public void setHowSurplus(String howSurplus) {
        this.howSurplus = howSurplus == null ? null : howSurplus.trim();
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName == null ? null : packName.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getCardMessage() {
        return cardMessage;
    }

    public void setCardMessage(String cardMessage) {
        this.cardMessage = cardMessage == null ? null : cardMessage.trim();
    }

    public String getInvPayee() {
        return invPayee;
    }

    public void setInvPayee(String invPayee) {
        this.invPayee = invPayee == null ? null : invPayee.trim();
    }

    public String getInvContent() {
        return invContent;
    }

    public void setInvContent(String invContent) {
        this.invContent = invContent == null ? null : invContent.trim();
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getInsureFee() {
        return insureFee;
    }

    public void setInsureFee(BigDecimal insureFee) {
        this.insureFee = insureFee;
    }

    public BigDecimal getPayFee() {
        return payFee;
    }

    public void setPayFee(BigDecimal payFee) {
        this.payFee = payFee;
    }

    public BigDecimal getPackFee() {
        return packFee;
    }

    public void setPackFee(BigDecimal packFee) {
        this.packFee = packFee;
    }

    public BigDecimal getCardFee() {
        return cardFee;
    }

    public void setCardFee(BigDecimal cardFee) {
        this.cardFee = cardFee;
    }

    public BigDecimal getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(BigDecimal moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public BigDecimal getSurplus() {
        return surplus;
    }

    public void setSurplus(BigDecimal surplus) {
        this.surplus = surplus;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public BigDecimal getIntegralMoney() {
        return integralMoney;
    }

    public void setIntegralMoney(BigDecimal integralMoney) {
        this.integralMoney = integralMoney;
    }

    public BigDecimal getGiftCardMoney() {
        return giftCardMoney;
    }

    public void setGiftCardMoney(BigDecimal giftCardMoney) {
        this.giftCardMoney = giftCardMoney;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Short getFromAd() {
        return fromAd;
    }

    public void setFromAd(Short fromAd) {
        this.fromAd = fromAd;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer == null ? null : referer.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Integer confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Integer shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Byte getPackId() {
        return packId;
    }

    public void setPackId(Byte packId) {
        this.packId = packId;
    }

    public Byte getCardId() {
        return cardId;
    }

    public void setCardId(Byte cardId) {
        this.cardId = cardId;
    }

    public Integer getBonusId() {
        return bonusId;
    }

    public void setBonusId(Integer bonusId) {
        this.bonusId = bonusId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode == null ? null : extensionCode.trim();
    }

    public Integer getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(Integer extensionId) {
        this.extensionId = extensionId;
    }

    public String getToBuyer() {
        return toBuyer;
    }

    public void setToBuyer(String toBuyer) {
        this.toBuyer = toBuyer == null ? null : toBuyer.trim();
    }

    public String getPayNote() {
        return payNote;
    }

    public void setPayNote(String payNote) {
        this.payNote = payNote == null ? null : payNote.trim();
    }

    public Short getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
    }

    public Long getAdTrackId() {
        return adTrackId;
    }

    public void setAdTrackId(Long adTrackId) {
        this.adTrackId = adTrackId;
    }

    public String getInvType() {
        return invType;
    }

    public void setInvType(String invType) {
        this.invType = invType == null ? null : invType.trim();
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Boolean getIsSeparate() {
        return isSeparate;
    }

    public void setIsSeparate(Boolean isSeparate) {
        this.isSeparate = isSeparate;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getCountryZd() {
        return countryZd;
    }

    public void setCountryZd(String countryZd) {
        this.countryZd = countryZd == null ? null : countryZd.trim();
    }

    public String getProvinceZd() {
        return provinceZd;
    }

    public void setProvinceZd(String provinceZd) {
        this.provinceZd = provinceZd == null ? null : provinceZd.trim();
    }

    public String getCityZd() {
        return cityZd;
    }

    public void setCityZd(String cityZd) {
        this.cityZd = cityZd == null ? null : cityZd.trim();
    }

    public String getAddressZd() {
        return addressZd;
    }

    public void setAddressZd(String addressZd) {
        this.addressZd = addressZd == null ? null : addressZd.trim();
    }

    public String getAddress2Zd() {
        return address2Zd;
    }

    public void setAddress2Zd(String address2Zd) {
        this.address2Zd = address2Zd == null ? null : address2Zd.trim();
    }

    public String getConsigneeZd() {
        return consigneeZd;
    }

    public void setConsigneeZd(String consigneeZd) {
        this.consigneeZd = consigneeZd == null ? null : consigneeZd.trim();
    }

    public String getZipcodeZd() {
        return zipcodeZd;
    }

    public void setZipcodeZd(String zipcodeZd) {
        this.zipcodeZd = zipcodeZd == null ? null : zipcodeZd.trim();
    }

    public String getMobileZd() {
        return mobileZd;
    }

    public void setMobileZd(String mobileZd) {
        this.mobileZd = mobileZd == null ? null : mobileZd.trim();
    }

    public String getTelZd() {
        return telZd;
    }

    public void setTelZd(String telZd) {
        this.telZd = telZd == null ? null : telZd.trim();
    }

    public String getEmailZd() {
        return emailZd;
    }

    public void setEmailZd(String emailZd) {
        this.emailZd = emailZd == null ? null : emailZd.trim();
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang == null ? null : lang.trim();
    }

    public Integer getGift() {
        return gift;
    }

    public void setGift(Integer gift) {
        this.gift = gift;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getTail() {
		return tail;
	}

	public void setTail(Integer tail) {
		this.tail = tail;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public Byte getAbnormal() {
		return abnormal;
	}

	public void setAbnormal(Byte abnormal) {
		this.abnormal = abnormal;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorEname() {
		return vendorEname;
	}

	public void setVendorEname(String vendorEname) {
		this.vendorEname = vendorEname;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public List<OrderGoods> getLstOrderGoods() {
		return lstOrderGoods;
	}

	public void setLstOrderGoods(List<OrderGoods> lstOrderGoods) {
		this.lstOrderGoods = lstOrderGoods;
	}

	public String getBonusSn() {
		return bonusSn;
	}

	public void setBonusSn(String bonusSn) {
		this.bonusSn = bonusSn;
	}


    
}
