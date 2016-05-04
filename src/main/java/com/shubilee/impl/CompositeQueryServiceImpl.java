package com.shubilee.impl;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.bean.InviteSummary;
import com.shubilee.dao.CartDao;
import com.shubilee.dao.CompositeQueryDao;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.Vendors;
import com.shubilee.service.CartService;
import com.shubilee.service.CompositeQueryService;

@Service
public class CompositeQueryServiceImpl implements CompositeQueryService{

	@Autowired
	private CompositeQueryDao compositeQueryDao;
	public String selectSubTreeByGid(int goods_id){
		return compositeQueryDao.selectSubTreeByGid(goods_id);
	}
	public List<Goods> selectGoodsByActid(int act_id){
			return compositeQueryDao.selectGoodsByActid(act_id);
	}
	public BonusType selectBonusByBonusSn(String bonus_sn){
		return compositeQueryDao.selectBonusByBonusSn(bonus_sn);
	}
	public BonusType selectBonusByBonusId(int bonus_id){
		return compositeQueryDao.selectBonusByBonusId(bonus_id);
	}
	
    public List<Goods> selectGoodsByActIdOfType3(int act_id){
    	return compositeQueryDao.selectGoodsByActIdOfType3(act_id);
    }
    public List<Goods> selectGoodsByActIdOfType2(int act_id){
    	return compositeQueryDao.selectGoodsByActIdOfType2(act_id);
    }
    public List<Goods> selectGoodsByActIdOfType1(int act_id){
    	return compositeQueryDao.selectGoodsByActIdOfType1(act_id);
    }
    
    public List<OrderInfo> selectPurchaseInfoByUid(int user_id,int purchase_id){
    	return compositeQueryDao.selectPurchaseInfoByUid(user_id,purchase_id);
    }
    public List<OrderGoods> selectOrderGoodsByOrderId( int order_id){
    	return compositeQueryDao.selectOrderGoodsByOrderId(order_id);
    }
    public List<InviteSummary> selectInviteSummary(int startDate,int endDate){
    	return compositeQueryDao.selectInviteSummary(startDate, endDate);
    	}
    }
