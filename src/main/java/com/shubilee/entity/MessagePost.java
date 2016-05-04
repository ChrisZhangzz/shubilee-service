package com.shubilee.entity;

public class MessagePost {
    private Integer pid;

    private Integer mid;

    private Integer uid;

    private Integer rid;

    private Integer dateline;

    private String messNickname;

    private Short pRank;

    private Boolean type;

    private String ip;

    private Integer invisible;

    private String content;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getDateline() {
        return dateline;
    }

    public void setDateline(Integer dateline) {
        this.dateline = dateline;
    }

    public String getMessNickname() {
        return messNickname;
    }

    public void setMessNickname(String messNickname) {
        this.messNickname = messNickname == null ? null : messNickname.trim();
    }

    public Short getpRank() {
        return pRank;
    }

    public void setpRank(Short pRank) {
        this.pRank = pRank;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getInvisible() {
        return invisible;
    }

    public void setInvisible(Integer invisible) {
        this.invisible = invisible;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}