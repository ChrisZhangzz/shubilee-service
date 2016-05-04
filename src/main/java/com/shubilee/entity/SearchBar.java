package com.shubilee.entity;

public class SearchBar {
    private Integer recId;

    private String placeholder;

    private String placeholderE;

    private Integer type;

    private Integer value;

    private String search;

    private String esearch;

    private String url;

    private Short isActive;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder == null ? null : placeholder.trim();
    }

    public String getPlaceholderE() {
        return placeholderE;
    }

    public void setPlaceholderE(String placeholderE) {
        this.placeholderE = placeholderE == null ? null : placeholderE.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search == null ? null : search.trim();
    }

    public String getEsearch() {
        return esearch;
    }

    public void setEsearch(String esearch) {
        this.esearch = esearch == null ? null : esearch.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }
}