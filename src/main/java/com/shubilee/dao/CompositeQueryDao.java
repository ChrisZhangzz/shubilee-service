
package com.shubilee.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.bean.InviteSummary;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.Vendors;

public interface CompositeQueryDao {    
    public String selectSubTreeByGid(@Param("goods_id") int goods_id);
    public List<Goods> selectGoodsByActid(@Param("act_id") int act_id);
    public BonusType selectBonusByBonusSn(@Param("bonus_sn") String bonus_sn);
    public BonusType selectBonusByBonusId(@Param("bonus_id") int bonus_id);
    public List<Goods> selectGoodsByActIdOfType3(@Param("act_id") int act_id);
    public List<Goods> selectGoodsByActIdOfType2(@Param("act_id") int act_id);
    public List<Goods> selectGoodsByActIdOfType1(@Param("act_id") int act_id);
    public List<OrderInfo> selectPurchaseInfoByUid(@Param("user_id") int user_id,@Param("purchase_id") int purchase_id);
    public List<OrderGoods> selectOrderGoodsByOrderId(@Param("order_id") int order_id);
    public List<InviteSummary> selectInviteSummary(@Param("startDate") int startDate,@Param("endDate") int endDate);
}
