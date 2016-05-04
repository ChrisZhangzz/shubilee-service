package com.shubilee.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.StringUtil;
import com.shubilee.dao.CartDao;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Token;
import com.shubilee.redis.dao.CartRedisDao;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.service.CartRedisService;

@Service
public class CartRedisServiceImpl implements CartRedisService{
	@Autowired
	private CartRedisDao cartRedisDao;
	@Autowired
	private CartDao cartDao;
	
	public void insert(Token token,CartRedis record)throws Exception{
		cartRedisDao.insert(token, record);
	}
    public void update(Token token,CartRedis record)throws Exception{
    	cartRedisDao.update(token, record);
    }
    public void delete(Token token,int goods_id){
    	cartRedisDao.delete(token, goods_id);
    }
    public void deleteGift(Token token){
    	List<CartRedis> lstCartRedis = cartRedisDao.selectAll(token);
    	for(CartRedis cartRedis:lstCartRedis){
    		if(cartRedis.getIs_gift().intValue()==1){
    			cartRedisDao.delete(token, cartRedis.getGoods_id());
    		}
    	}
    }
    public void deleteAll(Token token){
    	cartRedisDao.deleteAll(token);
    }
    public CartRedis select(Token token,int goods_id){
    	return cartRedisDao.select(token, goods_id);
    }
    public List<CartRedis> selectAll(Token token){
    	return cartRedisDao.selectAll(token);
    }
    public Boolean check(Token token,int goods_id){
    	return cartRedisDao.check(token, goods_id);
    }
    public Boolean checkAll(Token token){
    	return cartRedisDao.checkAll(token);
    }
    public List<Cart> selectCartsVendorForRedis(Token token,int vendor_id) throws Exception{
    	List<Cart> result = new ArrayList<Cart>();
    	List<CartRedis> lstCartRedis = cartRedisDao.selectAll(token);
    	String gids ="";
    	if(lstCartRedis.size()>0){
    		Map<String,CartRedis> mapCartRedis = new HashMap<String,CartRedis>(); 
	    	for(CartRedis cartRedis:lstCartRedis){
	    		if(cartRedis.getVendor_id().intValue()==vendor_id){
		    		gids = gids+","+cartRedis.getGoods_id().toString();
		    		mapCartRedis.put(cartRedis.getGoods_id().toString(), cartRedis);
	    		}
	    	}
	    	gids = gids.substring(1, gids.length());
	    	
	    	List<Cart> lstCartTemp =  cartDao.selectCartsForRedis(gids.split(","));
	    	for(Cart cart:lstCartTemp){
	    		CartRedis cartRedisTemp = mapCartRedis.get(cart.getGoods_id().toString());
	    		cart.setGoods_number(cartRedisTemp.getGoods_number());
	    		cart.setIs_gift(cartRedisTemp.getIs_gift().shortValue());
	    		cart.setGoods_price(StringUtil.checkPrice(cart)?cart.getPromote_price_stock():cart.getShop_price_stock());
	    		result.add(cart);
	    	}
    	}
    	return result;
    	
    	
    	
    }
    public List<Cart> selectCartsForRedis(Token token) throws Exception{
    	List<Cart> result = new ArrayList<Cart>();
    	List<CartRedis> lstCartRedis = cartRedisDao.selectAll(token);
    	String gids ="";
    	if(lstCartRedis.size()>0){
    		Map<String,CartRedis> mapCartRedis = new HashMap<String,CartRedis>(); 
	    	for(CartRedis cartRedis:lstCartRedis){
	    		gids = gids+","+cartRedis.getGoods_id().toString();
	    		mapCartRedis.put(cartRedis.getGoods_id().toString(), cartRedis);
	    	}
	    	gids = gids.substring(1, gids.length());
	    	
	    	List<Cart> lstCartTemp =  cartDao.selectCartsForRedis(gids.split(","));
	    	for(Cart cart:lstCartTemp){
	    		CartRedis cartRedisTemp = mapCartRedis.get(cart.getGoods_id().toString());
	    		cart.setGoods_number(cartRedisTemp.getGoods_number());
	    		cart.setIs_gift(cartRedisTemp.getIs_gift().shortValue());
	    		cart.setGoods_price(StringUtil.checkPrice(cart)?cart.getPromote_price_stock():cart.getShop_price_stock());
	    		result.add(cart);
	    	}
    	}
    	return result;
    }
    public Cart selectCartForRedisByGid(Token token,int goods_id) throws Exception{
    	CartRedis cartRedis = cartRedisDao.select(token, goods_id);
    	Cart cart =null;
    	if(null!=cartRedis){
	    	cart = cartDao.selectCartForRedisByGid(goods_id);
	    	cart.setGoods_number(cartRedis.getGoods_number());
			cart.setIs_gift(cartRedis.getIs_gift().shortValue());
			cart.setGoods_price(StringUtil.checkPrice(cart)?cart.getPromote_price_stock():cart.getShop_price_stock());
    	}
    	return cart;
    	
    } 
    
    
    
    
    
}
