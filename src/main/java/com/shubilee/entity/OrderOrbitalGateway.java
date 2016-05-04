package com.shubilee.entity;

import java.math.BigDecimal;

public class OrderOrbitalGateway {
    private Integer recId;

    private String orderId;

    private BigDecimal amount;

    private String industryType;

    private String transType;

    private String approvalStatus;

    private String respCode;

    private String retryTrace;

    private String txRefNum;

    private Integer txRefIdx;

    private String cardBrand;

    private String respDate;

    private Integer procStatus;

    private String authCode;

    private String retryTimes;

    private String avsRespCode;

    private String cvvRespCode;
    
	public Integer getRecId() {
		return recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRetryTrace() {
		return retryTrace;
	}

	public void setRetryTrace(String retryTrace) {
		this.retryTrace = retryTrace;
	}

	public String getTxRefNum() {
		return txRefNum;
	}

	public void setTxRefNum(String txRefNum) {
		this.txRefNum = txRefNum;
	}

	public Integer getTxRefIdx() {
		return txRefIdx;
	}

	public void setTxRefIdx(Integer txRefIdx) {
		this.txRefIdx = txRefIdx;
	}

	public String getCardBrand() {
		return cardBrand;
	}

	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}

	public String getRespDate() {
		return respDate;
	}

	public void setRespDate(String respDate) {
		this.respDate = respDate;
	}

	public Integer getProcStatus() {
		return procStatus;
	}

	public void setProcStatus(Integer procStatus) {
		this.procStatus = procStatus;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(String retryTimes) {
		this.retryTimes = retryTimes;
	}

	public String getAvsRespCode() {
		return avsRespCode;
	}

	public void setAvsRespCode(String avsRespCode) {
		this.avsRespCode = avsRespCode;
	}

	public String getCvvRespCode() {
		return cvvRespCode;
	}

	public void setCvvRespCode(String cvvRespCode) {
		this.cvvRespCode = cvvRespCode;
	}

   
}