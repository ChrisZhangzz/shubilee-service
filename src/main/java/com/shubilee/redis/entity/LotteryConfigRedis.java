package com.shubilee.redis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class LotteryConfigRedis {
	
	private Integer recId;

    private Integer pointNum;

    private Long winningNum;

    private Long winningNumLimit;

    private Date date;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getPointNum() {
        return pointNum;
    }

    public void setPointNum(Integer pointNum) {
        this.pointNum = pointNum;
    }

    public Long getWinningNum() {
        return winningNum;
    }

    public void setWinningNum(Long winningNum) {
        this.winningNum = winningNum;
    }

    public Long getWinningNumLimit() {
        return winningNumLimit;
    }

    public void setWinningNumLimit(Long winningNumLimit) {
        this.winningNumLimit = winningNumLimit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }









    
}
