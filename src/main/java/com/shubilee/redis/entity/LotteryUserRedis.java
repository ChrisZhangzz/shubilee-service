package com.shubilee.redis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class LotteryUserRedis {
	

	private Integer user_id;

    private Integer lottery_number;
    
	private Integer winning_num;



	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getLottery_number() {
		return lottery_number;
	}

	public void setLottery_number(Integer lottery_number) {
		this.lottery_number = lottery_number;
	}

	public Integer getWinning_num() {
		return winning_num;
	}

	public void setWinning_num(Integer winning_num) {
		this.winning_num = winning_num;
	}








    
}
