package com.shubilee.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InviteHistory {
	
    private int userId;
    private String email;
    private int flag;
    private Integer regTime;
    private Integer firstOrderTime;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Integer getRegTime() {
		return regTime;
	}
	public void setRegTime(Integer regTime) {
		this.regTime = regTime;
	}
	public Integer getFirstOrderTime() {
		return firstOrderTime;
	}
	public void setFirstOrderTime(Integer firstOrderTime) {
		this.firstOrderTime = firstOrderTime;
	}

	
    

    
}
