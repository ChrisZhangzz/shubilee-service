
package com.shubilee.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Cart;

public interface CartDao {    
    public List<Cart> selectCartsBySession_id(@Param("session_id") String session_id);
    public List<Cart> selectCartsByUserid(@Param("user_id") int user_id);
    public List<Cart> selectCartsBySession_idAndVendorId(@Param("session_id") String session_id,@Param("vendor_id") int vendor_id);
    public List<Cart> selectCartsByUseridAndVendorId(@Param("user_id") int user_id,@Param("vendor_id") int vendor_id);
    public List<Cart> selectCarts(Cart record);
    public int updateGoodNumOfCart(@Param("rec_id") int rec_id,@Param("goods_number") int goods_num);
    public int updateGoodPriceOfCart(@Param("rec_id") int rec_id,@Param("goods_price") BigDecimal goods_price);
    public int insert(Cart record);
    public int selectRecidByUidGid(@Param("user_id") int user_id,@Param("goods_id") int goods_id);
    public int selectRecidByTempidGid(@Param("temp_id") String temp_id,@Param("goods_id") int goods_id);
    public int deleteCartByTempid(String tempId);
    public int deleteCartByUid(int userId);
    public int updateUserIdByTempid(Cart record);
    public int deleteActByUid(@Param("user_id") int user_id);
    public int deleteActByTempid(@Param("tempId") String tempId);
    public int deleteGoodsByTempid(@Param("tempId") String tempId,@Param("goods_id") int goods_id);
    public int deleteGoodsByUid(@Param("uid") int uid,@Param("goods_id") int goods_id);
    public int updateGoodsByTempid(@Param("tempId") String tempId,@Param("goods_id") int goods_id,@Param("goods_number") int goods_number);
    public int updateGoodsByUid(@Param("uid") int uid,@Param("goods_id") int goods_id,@Param("goods_number") int goods_number);
    public int updateTaxByUidAndGid(@Param("uid") int uid,@Param("goods_id") int goods_id,@Param("tax") BigDecimal tax);
    public int updateTaxByUid(@Param("uid") int uid,@Param("tax") BigDecimal tax);
    public int updateDealPriceByRecId(@Param("rec_id") int rec_id,@Param("deal_price") BigDecimal deal_price);
    public int updateDealPriceAndTax(@Param("uid") int uid,@Param("goods_id") int goods_id,@Param("tax") BigDecimal tax,@Param("deal_price") BigDecimal deal_price);
    public List<Cart> selectCarts4ViewByTemp_id(@Param("temp_id") String temp_id);
    public List<Cart> selectCarts4ViewByUserid(@Param("user_id") int user_id);
    public Cart selectCarts4ViewByTemp_idGoodsid(@Param("temp_id") String temp_id,@Param("goods_id") int goods_id);
    public Cart selectCarts4ViewByUidGoodsid(@Param("user_id") int user_id,@Param("goods_id") int goods_id);
    public List<Cart> selectCartsForRedis(@Param("goods_ids") String[] goods_ids);
    public Cart selectCartForRedisByGid(@Param("goods_id") int goods_id);
}
