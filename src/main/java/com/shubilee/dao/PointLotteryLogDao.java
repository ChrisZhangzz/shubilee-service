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
import com.shubilee.entity.PointLotterylog;
import com.shubilee.entity.PurchaseInfo;

public interface PointLotteryLogDao {    

	public int insert(PointLotterylog pointLotterylog);
}
