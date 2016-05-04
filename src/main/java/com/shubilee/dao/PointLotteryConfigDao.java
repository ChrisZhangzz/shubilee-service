package com.shubilee.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Count;
import com.shubilee.entity.GoodsImage;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.PointLotteryConfig;
import com.shubilee.entity.PurchaseInfo;

public interface PointLotteryConfigDao {    

	public List<PointLotteryConfig> getPointLotteryConfig(@Param("date")  String date);
	public int updatePointLotteryConfigWinningNum(@Param("rec_id") int rec_id);
}
