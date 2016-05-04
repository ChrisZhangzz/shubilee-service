package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.common.WriteData;
import com.shubilee.entity.Cart;
import com.shubilee.entity.User;

public interface CartService {
	
	public List<Cart> selectCartsByTempid(String tempid);
	public List<Cart> selectCartsByUserid(int userid);
	public List<Cart> selectCarts(Cart cart);
    public int deleteCartByTempid(String tempid);
    public int addItemToCart(Cart cart);
    public void updateUserIdByTempid(Cart cart);
    public int updateGoodNumOfCart(int rec_id,int goods_num);
    public int deleteActByUid(int uid);
    public int deleteActByTempid(String tempid);
    public int deleteCartByUid(int userId);
    public int deleteGoodsByTempid(String tempId,int goods_id);
    public int deleteGoodsByUid(int uid,int goods_id);
    public int updateGoodsByTempid(String tempId,int goods_id, int goods_number);
    public int updateGoodsByUid(int uid,int goods_id,int goods_number);
    public int updateTaxByUidAndGid(int uid,int goods_id,BigDecimal tax);
    public int updateTaxByUid(int uid,BigDecimal tax);
    public List<Cart> selectCartsByUseridAndVendorId(int user_id,int vendor_id);
    public List<Cart> selectCartsBySession_idAndVendorId(String session_id,int vendor_id);
    public int updateDealPriceByRecId(int rec_id,BigDecimal deal_price);
    public List<Cart> selectCarts4ViewByTemp_id(String temp_id);
    public List<Cart> selectCarts4ViewByUserid(int user_id);
    public Cart selectCarts4ViewByTemp_idGoodsid(String temp_id,int goods_id);
    public Cart selectCarts4ViewByUidGoodsid(int user_id,int goods_id);
    public int selectRecidByUidGid(int user_id,int goods_id);
    public int selectRecidByTempidGid( String temp_id,int goods_id);
    public int updateGoodPriceOfCart(int rec_id,BigDecimal goods_price);
    public int updateDealPriceAndTax(int uid,int goods_id,BigDecimal tax,BigDecimal deal_price);
}
