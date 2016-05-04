package com.shubilee.entity;

import java.util.List;

public class DiscoveryDetail {
    private Integer recId;

    private Integer dMsgId;

    private Integer type;

    private String value;

    private String evalue;
    
    private String goodsName;
    
    private String goodsEname;
    
    private String brandName;
    
    private String brandEname;
    
    private String catName;
    
    private String catEname;

    private String goodsIds;

    private List<Goods> lstGoods;
    
    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getdMsgId() {
        return dMsgId;
    }

    public void setdMsgId(Integer dMsgId) {
        this.dMsgId = dMsgId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getEvalue() {
        return evalue;
    }

    public void setEvalue(String evalue) {
        this.evalue = evalue == null ? null : evalue.trim();
    }

	public List<Goods> getLstGoods() {
		return lstGoods;
	}

	public void setLstGoods(List<Goods> lstGoods) {
		this.lstGoods = lstGoods;
	}

	public String getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsEname() {
		return goodsEname;
	}

	public void setGoodsEname(String goodsEname) {
		this.goodsEname = goodsEname;
	}

	public String getBrandEname() {
		return brandEname;
	}

	public void setBrandEname(String brandEname) {
		this.brandEname = brandEname;
	}

	public String getCatEname() {
		return catEname;
	}

	public void setCatEname(String catEname) {
		this.catEname = catEname;
	}






    
}