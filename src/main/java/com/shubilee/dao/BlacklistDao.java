
package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Activity;
import com.shubilee.entity.Blacklist;

public interface BlacklistDao {    
	public int insert(Blacklist blacklist);
	public int selectCountByBankCard(String bank_card);
	public int selectCountByUserId(int user_id);
}