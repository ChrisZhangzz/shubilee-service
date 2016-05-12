
package com.shubilee.dao;
import org.apache.ibatis.annotations.Param;

import com.shubilee.bean.InviteHistory;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Integral;
import com.shubilee.entity.UserInfoOrder;
import com.shubilee.entity.UserInfoOrderMaxCat;
import com.shubilee.entity.UserInfoOrderMaxGoods;
import com.shubilee.entity.Users;

import java.util.List;

import javax.ws.rs.QueryParam;

public interface UsersDao {    
    public Users selectUserInfoByID(@Param("user_id") int user_id);
    public int updateUserNameByUid(@Param("user_id") int user_id,@Param("user_name") String user_name);
    public int updateUserInfoByUid(@Param("user_id") int user_id,@Param("username") String username,@Param("sex") int sex,@Param("birthday") String birthday,@Param("phone") String phone,@Param("avatar") String avatar);
    public int updatePointByUid(@Param("user_id") int user_id,@Param("point") Long point);
    public int updateSexByUid(@Param("user_id") int user_id,@Param("sex") int sex,@Param("avatar") String avatar);
    public int updatePhoneByUid(@Param("user_id") int user_id,@Param("mobile_phone") String mobile_phone);
    public int updateTureNameByUid(@Param("user_id") int user_id,@Param("truename") String truename);
    public int updateEmail(@Param("user_id") int user_id,@Param("email") String email);
    public int updateRemindEmail(@Param("user_id") int user_id,@Param("email") String email);
    public int selectCountByUserName(@Param("user_id") int user_id,@Param("user_name") String user_name);
    public List<Integral> selectPointHistory(@Param("user_id") int user_id,@Param("start") Integer start,@Param("length") Integer length);
    public int selectPointHistoryCount(@Param("user_id") int user_id);
    public List<Integral> selectPointHistoryGet(@Param("user_id") int user_id,@Param("start") Integer start,@Param("length") Integer length);
    public int selectPointHistoryGetCount(@Param("user_id") int user_id);
    public List<Integral> selectPointHistoryPay(@Param("user_id") int user_id,@Param("start") Integer start,@Param("length") Integer length);
    public int selectPointHistoryPayCount(@Param("user_id") int user_id);
	public void insertUsers(Users users);
	public String getRegisterPoints();
    public int updateInviteCodeByUid(@Param("user_id") int user_id,@Param("invite_code") String invite_code);
    public int selectUsersByInviteCode(@Param("invite_code") String invite_code);
    public Users selectUserInfoByInviteCode(@Param("invite_code") String invite_code);
    public List<InviteHistory> selectInviteHistoryByUserid(@Param("user_id") int user_id);
    public int updateFirstOrderTimeByUid(@Param("user_id") int user_id);
    public List<UserInfoOrder> selectUserInfoOrderByUid(@Param("user_id") int user_id);
    public UserInfoOrderMaxGoods selectUserInfoOrderMaxGoodsByUid(@Param("user_id") int user_id);
    public UserInfoOrderMaxCat selectUserInfoOrderMaxCatByUid(@Param("user_id") int user_id);
    public String getUserName(int id);
    public Users selectUsersByID(int id);
    public Users getPasswordSalt(String email);
    public String getPassword(int id);
    public void setPasswordSalt(Users user);
    public void setPasswordSaltByUid(Users user);
	public void insertUsersByEmail(@Param("email") String email, @Param("password") String password,@Param("user_name") String user_name,@Param("newSalt") String newSalt,@Param("parent_id") int parent_id);
	public int selectUserCountByUserName(@Param("user_name") String user_name);
	public Integer selectUIdByEmail(@Param("email") String email);
	public BonusType selectBonusTypeByBounsId(@Param("bonus_id") Integer bonusId);
	public void insertUsersByEmailId( Users users);
}