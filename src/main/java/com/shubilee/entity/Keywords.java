package com.shubilee.entity;

public class Keywords {
    private Long keyId;

    private String keyName;

    private String keyEname;

    private String keyUrl;

    private String keyCat;

    private Long pNatural;

    private Long pManual;

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    public String getKeyEname() {
        return keyEname;
    }

    public void setKeyEname(String keyEname) {
        this.keyEname = keyEname == null ? null : keyEname.trim();
    }

    public String getKeyUrl() {
        return keyUrl;
    }

    public void setKeyUrl(String keyUrl) {
        this.keyUrl = keyUrl == null ? null : keyUrl.trim();
    }

    public String getKeyCat() {
        return keyCat;
    }

    public void setKeyCat(String keyCat) {
        this.keyCat = keyCat == null ? null : keyCat.trim();
    }

    public Long getpNatural() {
        return pNatural;
    }

    public void setpNatural(Long pNatural) {
        this.pNatural = pNatural;
    }

    public Long getpManual() {
        return pManual;
    }

    public void setpManual(Long pManual) {
        this.pManual = pManual;
    }
}