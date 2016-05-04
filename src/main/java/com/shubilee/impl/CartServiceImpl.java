package com.shubilee.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.common.WriteData;
import com.shubilee.dao.CartDao;
import com.shubilee.entity.Cart;
import com.shubilee.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	
	public List<Cart> selectCartsByTempid(String tempId) {
		List<Cart> result = cartDao.selectCartsBySession_id(tempId);
		
		return result;
  
	}
	public List<Cart> selectCartsByUserid(int userid){
		List<Cart> result = cartDao.selectCartsByUserid(userid);
		return result;
	}
	public List<Cart> selectCarts(Cart cart){
		List<Cart> result = cartDao.selectCarts(cart);
		return result;
	};

    public int deleteCartByTempid(String tempId){
    	int result = cartDao.deleteCartByTempid(tempId);
    	
    	return result;
    };
    
    public int deleteCartByUid(int userId){
    	return cartDao.deleteCartByUid(userId);
    }
    
    public int addItemToCart(Cart cart){
    	int result = cartDao.insert(cart);
    	return result;
    }

    public void updateUserIdByTempid(Cart cart){
    	cartDao.updateUserIdByTempid(cart);
    }
    public int updateGoodNumOfCart(int rec_id,int goods_num){
    	int result  = cartDao.updateGoodNumOfCart(rec_id, goods_num);
    	return result;
    }
    public int deleteActByUid(int uid){
    	int result  = cartDao.deleteActByUid(uid);
    	return result;
    }
    public int deleteActByTempid(String tempid){
    	int result  = cartDao.deleteActByTempid(tempid);
    	return result;
    }
    
    public int deleteGoodsByTempid(String tempId,int goods_id){
    	return cartDao.deleteGoodsByTempid(tempId, goods_id);
    }
    public int deleteGoodsByUid(int uid,int goods_id){
    	return cartDao.deleteGoodsByUid(uid, goods_id);
    }
    public int updateGoodsByTempid(String tempId,int goods_id, int goods_number){
    	return cartDao.updateGoodsByTempid(tempId, goods_id, goods_number);
    }
    public int updateGoodsByUid(int uid,int goods_id,int goods_number){
    	return cartDao.updateGoodsByUid(uid, goods_id, goods_number);
    }
    public int updateTaxByUidAndGid(int uid,int goods_id,BigDecimal tax){
    	return cartDao.updateTaxByUidAndGid(uid, goods_id, tax);
    }
    public int updateTaxByUid(int uid,BigDecimal tax){
    	return cartDao.updateTaxByUid(uid,tax);
    }
    public List<Cart> selectCartsByUseridAndVendorId(int user_id,int vendor_id){
    	return  cartDao.selectCartsByUseridAndVendorId(user_id, vendor_id);
    }
    public List<Cart> selectCartsBySession_idAndVendorId(String session_id,int vendor_id){
    	return  cartDao.selectCartsBySession_idAndVendorId(session_id, vendor_id);
    }
    public int updateDealPriceByRecId(int rec_id,BigDecimal deal_price){
    	return cartDao.updateDealPriceByRecId(rec_id, deal_price);
    }
    public List<Cart> selectCarts4ViewByTemp_id(String temp_id){
    	return cartDao.selectCarts4ViewByTemp_id(temp_id);
    }
    public List<Cart> selectCarts4ViewByUserid(int user_id){
    	return cartDao.selectCarts4ViewByUserid(user_id);
    	}
    
    public int selectRecidByUidGid(int user_id,int goods_id){
    	return cartDao.selectRecidByUidGid(user_id, goods_id);
    }
    public int selectRecidByTempidGid( String temp_id,int goods_id){
    	return cartDao.selectRecidByTempidGid(temp_id, goods_id);
    }
    public int updateGoodPriceOfCart(int rec_id,BigDecimal goods_price){
    	return cartDao.updateGoodPriceOfCart(rec_id, goods_price);
    }
    public int updateDealPriceAndTax(int uid,int goods_id,BigDecimal tax,BigDecimal deal_price){
    	return cartDao.updateDealPriceAndTax(uid, goods_id, tax, deal_price);
    }
    public Cart selectCarts4ViewByTemp_idGoodsid(String temp_id,int goods_id){
    	return cartDao.selectCarts4ViewByTemp_idGoodsid(temp_id, goods_id);
    }
    public Cart selectCarts4ViewByUidGoodsid(int user_id,int goods_id){
    	return cartDao.selectCarts4ViewByUidGoodsid(user_id, goods_id);
    }
}
