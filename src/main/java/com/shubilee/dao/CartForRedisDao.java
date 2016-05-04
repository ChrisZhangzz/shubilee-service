
package com.shubilee.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Cart;

public interface CartForRedisDao {    
    public List<Cart> selectCartsByGids(@Param("gids") String gids);

}
