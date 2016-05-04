package com.shubilee.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Cart {
	
	private Integer rec_id;

	private Integer user_id;
	
	private String session_id;
	
	private Integer vendor_id;
	
	private String vendor_name;

	private String vendor_ename;
	
	private Integer goods_id;
	
	private String goods_sn;
	
	private Integer product_id;
	
	private String goods_name;
	
	private String goods_ename;

    private BigDecimal cost;

    private BigDecimal tax;

    private BigDecimal market_price;

    private BigDecimal goods_price;

    private Integer goods_number;
    
    private Integer goods_number_stock;
    
    private String goods_thumb;


    private Boolean is_real;

    private String extension_code;

    private Integer parent_id;

    private Boolean rec_type;

    private Short is_gift;

    private Boolean is_shipping;

    private Byte can_handsel;

    private String goods_attr_id;

    private BigDecimal deal_price;

    private String goods_attr;
    
    private Boolean isOnSale;
    
    private Boolean isDelete;
    
    private Boolean isLimited;

    private Integer limitedNumber;

    private Integer limitedQuantity;
    
    private String subTree;
    
    private Integer brand_id;
    
    private Integer cat_id;

    private BigDecimal shop_price_stock;
    
    private Boolean is_promote_stock;
    
    private BigDecimal promote_price_stock;

    private Integer promote_start_date_stock;

    private Integer promote_end_date_stock;

    private String promote_countdown_stock;

    private String promote_weekly_stock;
    
    private Integer give_Integral_stock;
    
    
    private Map<String,String> mapActivity;
    
    private Integer isDistrict;

    private Integer is1day;
    
    private Integer zipcodeLimitId;
    
	public Integer getRec_id() {
		return rec_id;
	}

	public void setRec_id(Integer rec_id) {
		this.rec_id = rec_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_sn() {
		return goods_sn;
	}

	public void setGoods_sn(String goods_sn) {
		this.goods_sn = goods_sn;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
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

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getMarket_price() {
		return market_price;
	}

	public void setMarket_price(BigDecimal market_price) {
		this.market_price = market_price;
	}

	public BigDecimal getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(BigDecimal goods_price) {
		this.goods_price = goods_price;
	}

	public Integer getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(Integer goods_number) {
		this.goods_number = goods_number;
	}

	public Boolean getIs_real() {
		return is_real;
	}

	public void setIs_real(Boolean is_real) {
		this.is_real = is_real;
	}

	public String getExtension_code() {
		return extension_code;
	}

	public void setExtension_code(String extension_code) {
		this.extension_code = extension_code;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Boolean getRec_type() {
		return rec_type;
	}

	public void setRec_type(Boolean rec_type) {
		this.rec_type = rec_type;
	}

	public Short getIs_gift() {
		return is_gift;
	}

	public void setIs_gift(Short is_gift) {
		this.is_gift = is_gift;
	}

	public Boolean getIs_shipping() {
		return is_shipping;
	}

	public void setIs_shipping(Boolean is_shipping) {
		this.is_shipping = is_shipping;
	}

	public Byte getCan_handsel() {
		return can_handsel;
	}

	public void setCan_handsel(Byte can_handsel) {
		this.can_handsel = can_handsel;
	}

	public String getGoods_attr_id() {
		return goods_attr_id;
	}

	public void setGoods_attr_id(String goods_attr_id) {
		this.goods_attr_id = goods_attr_id;
	}

	public BigDecimal getDeal_price() {
		return deal_price;
	}

	public void setDeal_price(BigDecimal deal_price) {
		this.deal_price = deal_price;
	}

	public String getGoods_attr() {
		return goods_attr;
	}

	public void setGoods_attr(String goods_attr) {
		this.goods_attr = goods_attr;
	}

	public Map<String, String> getMapActivity() {
		return mapActivity;
	}

	public void setMapActivity(Map<String, String> mapActivity) {
		this.mapActivity = mapActivity;
	}

	public Integer getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(Integer vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getVendor_ename() {
		return vendor_ename;
	}

	public void setVendor_ename(String vendor_ename) {
		this.vendor_ename = vendor_ename;
	}

	public Integer getGoods_number_stock() {
		return goods_number_stock;
	}

	public void setGoods_number_stock(Integer goods_number_stock) {
		this.goods_number_stock = goods_number_stock;
	}

	public String getGoods_thumb() {
		return goods_thumb;
	}

	public void setGoods_thumb(String goods_thumb) {
		this.goods_thumb = goods_thumb;
	}

	public Boolean getIsOnSale() {
		return isOnSale;
	}

	public void setIsOnSale(Boolean isOnSale) {
		this.isOnSale = isOnSale;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsLimited() {
		return isLimited;
	}

	public void setIsLimited(Boolean isLimited) {
		this.isLimited = isLimited;
	}

	public Integer getLimitedNumber() {
		return limitedNumber;
	}

	public void setLimitedNumber(Integer limitedNumber) {
		this.limitedNumber = limitedNumber;
	}

	public Integer getLimitedQuantity() {
		return limitedQuantity;
	}

	public void setLimitedQuantity(Integer limitedQuantity) {
		this.limitedQuantity = limitedQuantity;
	}

	public String getSubTree() {
		return subTree;
	}

	public void setSubTree(String subTree) {
		this.subTree = subTree;
	}

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

	public Integer getCat_id() {
		return cat_id;
	}

	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}

	public BigDecimal getShop_price_stock() {
		return shop_price_stock;
	}

	public void setShop_price_stock(BigDecimal shop_price_stock) {
		this.shop_price_stock = shop_price_stock;
	}

	public Boolean getIs_promote_stock() {
		return is_promote_stock;
	}

	public void setIs_promote_stock(Boolean is_promote_stock) {
		this.is_promote_stock = is_promote_stock;
	}

	public BigDecimal getPromote_price_stock() {
		return promote_price_stock;
	}

	public void setPromote_price_stock(BigDecimal promote_price_stock) {
		this.promote_price_stock = promote_price_stock;
	}

	public Integer getPromote_start_date_stock() {
		return promote_start_date_stock;
	}

	public void setPromote_start_date_stock(Integer promote_start_date_stock) {
		this.promote_start_date_stock = promote_start_date_stock;
	}

	public Integer getPromote_end_date_stock() {
		return promote_end_date_stock;
	}

	public void setPromote_end_date_stock(Integer promote_end_date_stock) {
		this.promote_end_date_stock = promote_end_date_stock;
	}

	public String getPromote_countdown_stock() {
		return promote_countdown_stock;
	}

	public void setPromote_countdown_stock(String promote_countdown_stock) {
		this.promote_countdown_stock = promote_countdown_stock;
	}

	public String getPromote_weekly_stock() {
		return promote_weekly_stock;
	}

	public void setPromote_weekly_stock(String promote_weekly_stock) {
		this.promote_weekly_stock = promote_weekly_stock;
	}

	public Integer getGive_Integral_stock() {
		return give_Integral_stock;
	}

	public void setGive_Integral_stock(Integer give_Integral_stock) {
		this.give_Integral_stock = give_Integral_stock;
	}

	public Integer getIsDistrict() {
		return isDistrict;
	}

	public void setIsDistrict(Integer isDistrict) {
		this.isDistrict = isDistrict;
	}

	public Integer getIs1day() {
		return is1day;
	}

	public void setIs1day(Integer is1day) {
		this.is1day = is1day;
	}

	public Integer getZipcodeLimitId() {
		return zipcodeLimitId;
	}

	public void setZipcodeLimitId(Integer zipcodeLimitId) {
		this.zipcodeLimitId = zipcodeLimitId;
	}







    
}
