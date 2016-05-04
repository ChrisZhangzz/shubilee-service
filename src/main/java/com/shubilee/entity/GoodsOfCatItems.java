package com.shubilee.entity;

import java.math.BigDecimal;

public class GoodsOfCatItems {
	private int goods_id;

    private String goods_name;

    private String goods_ename;
    
    private BigDecimal shop_price;

    private BigDecimal promote_price;

    private int is_promote;
    
	private int goods_number;
    
    private String goods_thumb;
    
    private String goodsImg;

    private String originalImg;
    
    public int getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}

	public String getGoods_thumb() {
		return goods_thumb;
	}

	public void setGoods_thumb(String goods_thumb) {
		this.goods_thumb = goods_thumb;
	}
 
	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_ename() {
		return goods_ename;
	}

	public void setGoods_ename(String goods_ename) {
		this.goods_ename = goods_ename;
	}

	public BigDecimal getShop_price() {
		return shop_price;
	}

	public void setShop_price(BigDecimal shop_price) {
		this.shop_price = shop_price;
	}

	public BigDecimal getPromote_price() {
		return promote_price;
	}

	public void setPromote_price(BigDecimal promote_price) {
		this.promote_price = promote_price;
	}

	public int getIs_promote() {
		return is_promote;
	}

	public void setIs_promote(int is_promote) {
		this.is_promote = is_promote;
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