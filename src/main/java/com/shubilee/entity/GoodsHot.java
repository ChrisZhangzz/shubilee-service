package com.shubilee.entity;

import java.math.BigDecimal;

public class GoodsHot {
    private Integer recId;

    private Integer page;

    private Integer position;

    private Integer goodsId;
    
    private String goodsName;

    private String goodsEname;

    private Boolean isPromote;
    
    private BigDecimal promotePrice;
    
    private BigDecimal shopPrice;
    
    private String goodsThumb;
    private String goodsImg;


    private String originalImg;
    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

	public Boolean getIsPromote() {
		return isPromote;
	}

	public void setIsPromote(Boolean isPromote) {
		this.isPromote = isPromote;
	}

	public BigDecimal getPromotePrice() {
		return promotePrice;
	}

	public void setPromotePrice(BigDecimal promotePrice) {
		this.promotePrice = promotePrice;
	}

	public BigDecimal getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(BigDecimal shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getGoodsThumb() {
		return goodsThumb;
	}

	public void setGoodsThumb(String goodsThumb) {
		this.goodsThumb = goodsThumb;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getOriginalImg() {
		return originalImg;
	}

	public void setOriginalImg(String originalImg) {
		this.originalImg = originalImg;
	}
    
}