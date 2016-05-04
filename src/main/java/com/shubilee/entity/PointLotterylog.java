package com.shubilee.entity;

public class PointLotterylog {
    private Long recId;

    private Integer userId;

    private Integer getPoint;

    private Long time;

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGetPoint() {
        return getPoint;
    }

    public void setGetPoint(Integer getPoint) {
        this.getPoint = getPoint;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}