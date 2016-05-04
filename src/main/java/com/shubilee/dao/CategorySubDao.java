
package com.shubilee.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Cart;

public interface CategorySubDao {    
    public List<Cart> selectCartsBySession_id(@Param("session_id") String session_id);
    public List<Cart> selectCartsByUserid(@Param("user_id") int user_id);
    public List<Cart> selectCarts(Cart record);
    public int updateGoodNumOfCart(@Param("rec_id") int rec_id,@Param("goods_number") int goods_num);
    public int insert(Cart record);
    public int deleteCartByTempid(int tempId);
    public int updateUserIdByTempid(Cart record);
    
}
