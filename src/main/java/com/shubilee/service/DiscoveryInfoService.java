package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.common.WriteData;
import com.shubilee.entity.Cart;
import com.shubilee.entity.DiscoveryInfo;
import com.shubilee.entity.Message4Discovery;

public interface DiscoveryInfoService {


	public int selectMaxRecId();

	public DiscoveryInfo selectDiscoveryInfoByRecId(int rec_id);
	
	public List<DiscoveryInfo> selectDiscoveryInfos(Integer start,Integer length);
	
	public List<DiscoveryInfo> selectDiscoveryInfosOfTop();
	
	public Message4Discovery selectMessage4Discovery(Integer p_id);
}
