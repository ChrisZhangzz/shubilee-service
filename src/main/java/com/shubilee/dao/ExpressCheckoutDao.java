package com.shubilee.dao;


import com.shubilee.entity.ExpressCheckout;

public interface ExpressCheckoutDao {

    public int insert(ExpressCheckout expressCheckout);
    public ExpressCheckout selectByUid(int user_id);
    public int updatePayerIdByUid(ExpressCheckout expressCheckout);
    public int deleteByUid(int user_id);
    public int selectCountByUid(int user_id);
}
