package com.shubilee.common;

import java.util.List;

import com.shubilee.bean.ErrorGoodsInfo;

public class YamiException extends RuntimeException { 
    private static final long serialVersionUID = 1L;  
	private String errorId;
	private String enerrorMessage;
	private String cnerrorMessage;
	private String aderrorMessage;
	private List<ErrorGoodsInfo> lstErrorGoodsInfo;
	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getEnerrorMessage() {
		return enerrorMessage;
	}

	public void setEnerrorMessage(String enerrorMessage) {
		this.enerrorMessage = enerrorMessage;
	}

	public String getCnerrorMessage() {
		return cnerrorMessage;
	}

	public void setCnerrorMessage(String cnerrorMessage) {
		this.cnerrorMessage = cnerrorMessage;
	}

	public String getAderrorMessage() {
		return aderrorMessage;
	}

	public void setAderrorMessage(String aderrorMessage) {
		this.aderrorMessage = aderrorMessage;
	}

	public List<ErrorGoodsInfo> getLstErrorGoodsInfo() {
		return lstErrorGoodsInfo;
	}

	public void setLstErrorGoodsInfo(List<ErrorGoodsInfo> lstErrorGoodsInfo) {
		this.lstErrorGoodsInfo = lstErrorGoodsInfo;
	}

	public YamiException() {
		super();
	}

	public YamiException(String errorId, String errorMessage[]) {
		super(errorMessage[0]);
		this.errorId = errorId;
		this.enerrorMessage = errorMessage[0];
		this.cnerrorMessage = errorMessage[1];
	}

	public YamiException(String errorId, String errorMessage[], String adMessage) {
		super(errorMessage[0]);
		this.errorId = errorId;
		this.enerrorMessage = errorMessage[0];
		this.cnerrorMessage = errorMessage[1];
		this.aderrorMessage = adMessage;
	}
	
	public YamiException(String errorId, String errorMessage[],List<ErrorGoodsInfo> lstErrorGoodsInfo) {
		super();
		this.errorId = errorId;
		this.enerrorMessage = errorMessage[0];
		this.cnerrorMessage = errorMessage[1];
		this.lstErrorGoodsInfo = lstErrorGoodsInfo;
	}
}
