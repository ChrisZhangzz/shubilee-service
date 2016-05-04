package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.DiscoveryInfo;
import com.shubilee.entity.Message4Discovery;

public interface DiscoveryInfoDao {

	public int selectMaxRecId();

	public DiscoveryInfo selectDiscoveryInfoByRecId(@Param("rec_id") int rec_id);

	public List<DiscoveryInfo> selectDiscoveryInfos(@Param("start") Integer start,@Param("length") Integer length);
	
	public List<DiscoveryInfo> selectDiscoveryInfosOfTop();
	
	public Message4Discovery selectMessage4Discovery(@Param("p_id") Integer p_id);
}
