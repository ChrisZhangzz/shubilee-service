package com.shubilee.redis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class LotterySetRedis {
	
	private Integer recId;

    private Integer totalPoint;

    private Date date;

    private Integer spend;

    private Integer userLotteryTimesLimit;

    private Integer userWinningTiimesLimit;

    private Integer winningRate;

    private Integer userLotteryTimes;

    private Integer userWinningTiimes;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSpend() {
        return spend;
    }

    public void setSpend(Integer spend) {
        this.spend = spend;
    }

    public Integer getUserLotteryTimesLimit() {
        return userLotteryTimesLimit;
    }

    public void setUserLotteryTimesLimit(Integer userLotteryTimesLimit) {
        this.userLotteryTimesLimit = userLotteryTimesLimit;
    }

    public Integer getUserWinningTiimesLimit() {
        return userWinningTiimesLimit;
    }

    public void setUserWinningTiimesLimit(Integer userWinningTiimesLimit) {
        this.userWinningTiimesLimit = userWinningTiimesLimit;
    }

    public Integer getWinningRate() {
        return winningRate;
    }

    public void setWinningRate(Integer winningRate) {
        this.winningRate = winningRate;
    }

    public Integer getUserLotteryTimes() {
        return userLotteryTimes;
    }

    public void setUserLotteryTimes(Integer userLotteryTimes) {
        this.userLotteryTimes = userLotteryTimes;
    }

    public Integer getUserWinningTiimes() {
        return userWinningTiimes;
    }

    public void setUserWinningTiimes(Integer userWinningTiimes) {
        this.userWinningTiimes = userWinningTiimes;
    }   
    




    
}
