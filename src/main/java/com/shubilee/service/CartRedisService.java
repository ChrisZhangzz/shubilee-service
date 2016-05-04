package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Cart;
import com.shubilee.entity.Token;
import com.shubilee.redis.entity.CartRedis;

public interface CartRedisService {	
	public void insert(Token token,CartRedis record)throws Exception;
    public void update(Token token,CartRedis record)throws Exception;
    public void delete(Token token,int goods_id);
    public void deleteGift(Token token);
    public void deleteAll(Token token);
    public CartRedis select(Token token,int goods_id);
    public List<CartRedis> selectAll(Token token);
    public Boolean check(Token token,int goods_id);
    public Boolean checkAll(Token token);
    public List<Cart> selectCartsVendorForRedis(Token token,int vendor_id) throws Exception;
    public List<Cart> selectCartsForRedis(Token token) throws Exception;
    public Cart selectCartForRedisByGid(Token token,int goods_id) throws Exception;
}
