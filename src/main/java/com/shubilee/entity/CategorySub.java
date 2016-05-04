package com.shubilee.entity;

public class CategorySub {
    private Integer catId;

    private String subTree;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getSubTree() {
        return subTree;
    }

    public void setSubTree(String subTree) {
        this.subTree = subTree == null ? null : subTree.trim();
    }
}