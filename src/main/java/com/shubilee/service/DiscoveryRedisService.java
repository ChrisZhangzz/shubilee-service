package com.shubilee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.BoundHashOperations;

import com.shubilee.common.DateUtil;
import com.shubilee.common.RedisKeyConstant;
import com.shubilee.entity.Cart;
import com.shubilee.entity.DiscoveryInfo;
import com.shubilee.entity.Token;
import com.shubilee.redis.entity.CartRedis;

public interface DiscoveryRedisService {	

    public void insert(DiscoveryInfo record);
    public void update(DiscoveryInfo record);
    public void delete(int rec_id);
    public void deleteAll();
    public Boolean check(int rec_id);
    public Boolean checkAll();
    public DiscoveryInfo select(int rec_id);
    public List<DiscoveryInfo> selectAll();
    public void insertMaxRecId(int rec_id);
    public Boolean checkMaxRecId();
    public int selectMaxRecId();
    
    
    public void insertTop(DiscoveryInfo record);
    public void updateTop(DiscoveryInfo record);
    public void deleteTop(int rec_id);
    public void deleteAllTop();
    public Boolean checkTop(int rec_id);
    public Boolean checkAllTop();
    public DiscoveryInfo selectTop(int rec_id);
    public List<DiscoveryInfo> selectAllTop();
}
