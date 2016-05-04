package com.shubilee.entity;

public class YmZipcode {
    private Integer zip;

    private String primaryCity;

    private String state;

    private String county;

    private Byte sdZone;

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getPrimaryCity() {
        return primaryCity;
    }

    public void setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity == null ? null : primaryCity.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public Byte getSdZone() {
        return sdZone;
    }

    public void setSdZone(Byte sdZone) {
        this.sdZone = sdZone;
    }
}