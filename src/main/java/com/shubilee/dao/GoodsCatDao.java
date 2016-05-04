
package com.shubilee.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Cart;

public interface GoodsCatDao {    
    public String selectCartidByGid(@Param("goods_id") int goods_id);
}
