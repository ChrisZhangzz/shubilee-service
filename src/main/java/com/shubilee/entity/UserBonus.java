package com.shubilee.entity;

public class UserBonus {
    private Integer bonusId;

    private Integer bonusTypeId;

    private String bonusSn;

    private Integer userId;

    private Integer usedTime;

    private Integer orderId;

    private Byte emailed;

    private String bonusCount;

    private Short isDelete;

    public Integer getBonusId() {
        return bonusId;
    }

    public void setBonusId(Integer bonusId) {
        this.bonusId = bonusId;
    }

    public Integer getBonusTypeId() {
        return bonusTypeId;
    }

    public void setBonusTypeId(Integer bonusTypeId) {
        this.bonusTypeId = bonusTypeId;
    }

    public String getBonusSn() {
        return bonusSn;
    }

    public void setBonusSn(String bonusSn) {
        this.bonusSn = bonusSn == null ? null : bonusSn.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Integer usedTime) {
        this.usedTime = usedTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Byte getEmailed() {
        return emailed;
    }

    public void setEmailed(Byte emailed) {
        this.emailed = emailed;
    }

    public String getBonusCount() {
        return bonusCount;
    }

    public void setBonusCount(String bonusCount) {
        this.bonusCount = bonusCount == null ? null : bonusCount.trim();
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }
}