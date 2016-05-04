
package com.shubilee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.ActivityGift;

public interface ActivityGiftDao {    
    public int countByGid(int goods_id);
    public List<ActivityGift> selectActivityGiftByActId(@Param("act_id") int act_id);
}