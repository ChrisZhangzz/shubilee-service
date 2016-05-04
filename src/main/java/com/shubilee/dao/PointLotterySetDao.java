package com.shubilee.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Count;
import com.shubilee.entity.GoodsImage;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.PointLotteryConfig;
import com.shubilee.entity.PointLotterySet;
import com.shubilee.entity.PurchaseInfo;

public interface PointLotterySetDao {    

	public PointLotterySet getPointLotterySet(@Param("date") String date);
    public int updateTotalPoint4Winning(@Param("rec_id") int rec_id,@Param("point") int point);
    public int updateLotterySetNoWinning(@Param("rec_id") int rec_id);
    public int updateUserPayPoint(@Param("user_id") int user_id,@Param("point") int point);
}
