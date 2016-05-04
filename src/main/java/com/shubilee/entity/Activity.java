package com.shubilee.entity;

import java.math.BigDecimal;
import java.util.List;

public class Activity {
    private Integer act_id;

    private Integer is_active;

    private Short is_delete;

    private String act_name;

    private String act_code;

    private Short act_type;

    private Short cal_type;

    private Short gift_mode;

    private Short overlap;

    private Integer num;

    private BigDecimal line;

    private Integer act_start;

    private Integer act_end;

    private Integer add_time;
    
    private List<ActivityLookup> lstActivityLookup;
    
    private List<ActivityGift> lstActivityGift;

	public Integer getAct_id() {
		return act_id;
	}

	public void setAct_id(Integer act_id) {
		this.act_id = act_id;
	}

	public Integer getIs_active() {
		return is_active;
	}

	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}

	public Short getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Short is_delete) {
		this.is_delete = is_delete;
	}

	public String getAct_name() {
		return act_name;
	}

	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}

	public String getAct_code() {
		return act_code;
	}

	public void setAct_code(String act_code) {
		this.act_code = act_code;
	}

	public Short getAct_type() {
		return act_type;
	}

	public void setAct_type(Short act_type) {
		this.act_type = act_type;
	}

	public Short getCal_type() {
		return cal_type;
	}

	public void setCal_type(Short cal_type) {
		this.cal_type = cal_type;
	}

	public Short getGift_mode() {
		return gift_mode;
	}

	public void setGift_mode(Short gift_mode) {
		this.gift_mode = gift_mode;
	}

	public Short getOverlap() {
		return overlap;
	}

	public void setOverlap(Short overlap) {
		this.overlap = overlap;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public BigDecimal getLine() {
		return line;
	}

	public void setLine(BigDecimal line) {
		this.line = line;
	}

	public Integer getAct_start() {
		return act_start;
	}

	public void setAct_start(Integer act_start) {
		this.act_start = act_start;
	}

	public Integer getAct_end() {
		return act_end;
	}

	public void setAct_end(Integer act_end) {
		this.act_end = act_end;
	}

	public Integer getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Integer add_time) {
		this.add_time = add_time;
	}

	public List<ActivityLookup> getLstActivityLookup() {
		return lstActivityLookup;
	}

	public void setLstActivityLookup(List<ActivityLookup> lstActivityLookup) {
		this.lstActivityLookup = lstActivityLookup;
	}

	public List<ActivityGift> getLstActivityGift() {
		return lstActivityGift;
	}

	public void setLstActivityGift(List<ActivityGift> lstActivityGift) {
		this.lstActivityGift = lstActivityGift;
	}

}