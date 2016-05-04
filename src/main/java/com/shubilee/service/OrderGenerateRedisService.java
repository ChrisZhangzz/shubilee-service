package com.shubilee.service;

import java.util.List;







import com.shubilee.entity.OrderGenerate;
import com.shubilee.entity.Token;
import com.shubilee.redis.entity.OrderGenerateRedis;

public interface OrderGenerateRedisService {
	
	public void insert(Token token,OrderGenerateRedis record)throws Exception;
    public void update(Token token,OrderGenerateRedis record)throws Exception;
    public void delete(Token token,int vendor_id);
    public void deleteAll(Token token);
    public OrderGenerateRedis select(Token token,int vendor_id);
    public List<OrderGenerateRedis> selectAll(Token token);
    public Boolean check(Token token,int vendor_id);
    public Boolean checkAll(Token token);
    public List<OrderGenerate> selectAllForOrderGenerate(Token token);
}
