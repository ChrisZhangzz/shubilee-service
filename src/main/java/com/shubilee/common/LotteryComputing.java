/**
 * Yamibuy 核心计算类
 * ============================================================================
 * * 版权所有 Yamibuy，并保留所有权利。
 * 网站地址: http://www.yamibuy.com；
 * ----------------------------------------------------------------------------
 * $Author: james $
 * $Id: DbHelper.java 2015-04-29 
*/
package com.shubilee.common;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import com.shubilee.bean.ComputerGoodResult;
import com.shubilee.bean.ComputerResult;
import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityGift;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.BonusVendor;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.Shipping;
import com.shubilee.entity.TaxLookup;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.Vendors;
import com.shubilee.redis.entity.LotteryConfigRedis;








public class LotteryComputing {
	
	/*
	 计算抽奖积分值
	 @param bonusType		
	 @param lstCart
	 @return Map<String,Object>	 
	*/
	public static LotteryConfigRedis countLotteryPoint(List<LotteryConfigRedis> lstLotteryRedis) throws Exception{
		LotteryConfigRedis result = null;
		int max=0;
		Random random = new Random();
		for(LotteryConfigRedis lotteryConfigRedis:lstLotteryRedis){
			max = max + (lotteryConfigRedis.getWinningNumLimit().intValue() - lotteryConfigRedis.getWinningNum().intValue());
		}
		if(max==0){
			return null;
		}
		int randomValue = random.nextInt(max);
		if(max==1){
			randomValue=1;
		}
		
	    //确定随机数所处区间范围
		int scopeMin = 1;
		int scopeMax = 0;
			for(LotteryConfigRedis lotteryConfigRedis:lstLotteryRedis){
				scopeMax = scopeMax + lotteryConfigRedis.getWinningNumLimit().intValue() - lotteryConfigRedis.getWinningNum().intValue();
				if(randomValue>=scopeMin&&randomValue<=scopeMax){
					result = 	lotteryConfigRedis;
				}

				scopeMin = scopeMin + lotteryConfigRedis.getWinningNumLimit().intValue() - lotteryConfigRedis.getWinningNum().intValue();
			}
	        return result;
	    }
		

	
		
}
