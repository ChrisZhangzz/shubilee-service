package com.shubilee.entity;

import java.math.BigDecimal;
import java.util.List;

public class Image {
    private Integer image_id;

    private String product_sku;

    private Integer image_seq;

    private String image_url;

	public Integer getImage_id() {
		return image_id;
	}

	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}

	public String getProduct_sku() {
		return product_sku;
	}

	public void setProduct_sku(String product_sku) {
		this.product_sku = product_sku;
	}

	public Integer getImage_seq() {
		return image_seq;
	}

	public void setImage_seq(Integer image_seq) {
		this.image_seq = image_seq;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}



}