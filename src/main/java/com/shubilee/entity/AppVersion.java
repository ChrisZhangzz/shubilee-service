package com.shubilee.entity;

public class AppVersion {
    private Integer recId;

    private String version;

    private String versionDesc;

    private String versionEdesc;

    private Integer updateTime;

    private Integer isUpdate;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getVersionDesc() {
        return versionDesc;
    }

    public void setVersionDesc(String versionDesc) {
        this.versionDesc = versionDesc == null ? null : versionDesc.trim();
    }

    public String getVersionEdesc() {
        return versionEdesc;
    }

    public void setVersionEdesc(String versionEdesc) {
        this.versionEdesc = versionEdesc == null ? null : versionEdesc.trim();
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }
}