package com.shubilee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.bean.InviteSummary;
import com.shubilee.common.WriteData;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.User;
import com.shubilee.entity.Vendors;

public interface CompositeQueryService {
	
	public String selectSubTreeByGid(int goods_id);
	public List<Goods> selectGoodsByActid( int act_id);
	public BonusType selectBonusByBonusSn(String bonus_sn);
	public BonusType selectBonusByBonusId(int bonus_id);
    public List<Goods> selectGoodsByActIdOfType3(int act_id);
    public List<Goods> selectGoodsByActIdOfType2(int act_id);
    public List<Goods> selectGoodsByActIdOfType1(int act_id);
    public List<OrderInfo> selectPurchaseInfoByUid(int user_id,int purchase_id);
    public List<OrderGoods> selectOrderGoodsByOrderId( int order_id);
    public List<InviteSummary> selectInviteSummary(int startDate,int endDate);
}
