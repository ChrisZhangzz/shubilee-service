package com.shubilee.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
	
	    private Integer product_id;	    
	    private String product_sku;   
	    private String produc_name;  
	    private Integer upc; 
	    private String product_description;
	    private Integer brand_id;
	    private String brand_name;
	    private String style_type;
	    private String style_name;
	    private BigDecimal standard_price;
	    private BigDecimal member_price;
	    private Integer quantity;
	    private BigDecimal weight;
	    private Integer size_us;
	    private Integer x_narrow;
	    private Integer narrow;
	    private Integer medium;
	    private Integer wide;
	    private Integer x_wide;
	    private String material;
	    private String color;
	    private String fit;
	    private BigDecimal outside_heel_height;
	    private BigDecimal inside_heel_height;
	    private BigDecimal shaft_height;
	    private BigDecimal platform_height;
	    private BigDecimal calf_circumference;
	    private BigDecimal heel_to_toe;
	    private String closure_type;
	    private String image_url;
	    private String parentage;
	    private String parent_sku;
	    private String relationship_type;
	    private String variation_theme;
	    private List<Image> images;
	    
		public List<Image> getImages() {
			return images;
		}
		public void setImages(List<Image> images) {
			this.images = images;
		}
		public Integer getProduct_id() {
			return product_id;
		}
		public void setProduct_id(Integer product_id) {
			this.product_id = product_id;
		}
		public String getProduct_sku() {
			return product_sku;
		}
		public void setProduct_sku(String product_sku) {
			this.product_sku = product_sku;
		}
		public String getProduc_name() {
			return produc_name;
		}
		public void setProduc_name(String produc_name) {
			this.produc_name = produc_name;
		}
		public Integer getUpc() {
			return upc;
		}
		public void setUpc(Integer upc) {
			this.upc = upc;
		}
		public String getProduct_description() {
			return product_description;
		}
		public void setProduct_description(String product_description) {
			this.product_description = product_description;
		}
		public Integer getBrand_id() {
			return brand_id;
		}
		public void setBrand_id(Integer brand_id) {
			this.brand_id = brand_id;
		}
		public String getBrand_name() {
			return brand_name;
		}
		public void setBrand_name(String brand_name) {
			this.brand_name = brand_name;
		}
		public String getStyle_type() {
			return style_type;
		}
		public void setStyle_type(String style_type) {
			this.style_type = style_type;
		}
		public String getStyle_name() {
			return style_name;
		}
		public void setStyle_name(String style_name) {
			this.style_name = style_name;
		}
		public BigDecimal getStandard_price() {
			return standard_price;
		}
		public void setStandard_price(BigDecimal standard_price) {
			this.standard_price = standard_price;
		}
		public BigDecimal getMember_price() {
			return member_price;
		}
		public void setMember_price(BigDecimal member_price) {
			this.member_price = member_price;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public BigDecimal getWeight() {
			return weight;
		}
		public void setWeight(BigDecimal weight) {
			this.weight = weight;
		}
		public Integer getSize_us() {
			return size_us;
		}
		public void setSize_us(Integer size_us) {
			this.size_us = size_us;
		}
		public Integer getX_narrow() {
			return x_narrow;
		}
		public void setX_narrow(Integer x_narrow) {
			this.x_narrow = x_narrow;
		}
		public Integer getNarrow() {
			return narrow;
		}
		public void setNarrow(Integer narrow) {
			this.narrow = narrow;
		}
		public Integer getMedium() {
			return medium;
		}
		public void setMedium(Integer medium) {
			this.medium = medium;
		}
		public Integer getWide() {
			return wide;
		}
		public void setWide(Integer wide) {
			this.wide = wide;
		}
		public Integer getX_wide() {
			return x_wide;
		}
		public void setX_wide(Integer x_wide) {
			this.x_wide = x_wide;
		}
		public String getMaterial() {
			return material;
		}
		public void setMaterial(String material) {
			this.material = material;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getFit() {
			return fit;
		}
		public void setFit(String fit) {
			this.fit = fit;
		}
		public BigDecimal getOutside_heel_height() {
			return outside_heel_height;
		}
		public void setOutside_heel_height(BigDecimal outside_heel_height) {
			this.outside_heel_height = outside_heel_height;
		}
		public BigDecimal getInside_heel_height() {
			return inside_heel_height;
		}
		public void setInside_heel_height(BigDecimal inside_heel_height) {
			this.inside_heel_height = inside_heel_height;
		}
		public BigDecimal getShaft_height() {
			return shaft_height;
		}
		public void setShaft_height(BigDecimal shaft_height) {
			this.shaft_height = shaft_height;
		}
		public BigDecimal getPlatform_height() {
			return platform_height;
		}
		public void setPlatform_height(BigDecimal platform_height) {
			this.platform_height = platform_height;
		}
		public BigDecimal getCalf_circumference() {
			return calf_circumference;
		}
		public void setCalf_circumference(BigDecimal calf_circumference) {
			this.calf_circumference = calf_circumference;
		}
		public BigDecimal getHeel_to_toe() {
			return heel_to_toe;
		}
		public void setHeel_to_toe(BigDecimal heel_to_toe) {
			this.heel_to_toe = heel_to_toe;
		}
		public String getClosure_type() {
			return closure_type;
		}
		public void setClosure_type(String closure_type) {
			this.closure_type = closure_type;
		}
		public String getImage_url() {
			return image_url;
		}
		public void setImage_url(String image_url) {
			this.image_url = image_url;
		}
		public String getParentage() {
			return parentage;
		}
		public void setParentage(String parentage) {
			this.parentage = parentage;
		}
		public String getParent_sku() {
			return parent_sku;
		}
		public void setParent_sku(String parent_sku) {
			this.parent_sku = parent_sku;
		}
		public String getRelationship_type() {
			return relationship_type;
		}
		public void setRelationship_type(String relationship_type) {
			this.relationship_type = relationship_type;
		}
		public String getVariation_theme() {
			return variation_theme;
		}
		public void setVariation_theme(String variation_theme) {
			this.variation_theme = variation_theme;
		}


	  


}
