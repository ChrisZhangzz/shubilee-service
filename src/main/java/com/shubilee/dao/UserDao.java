
package com.shubilee.dao;
import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.BonusType;
import com.shubilee.entity.User;
import com.shubilee.entity.Users;

public interface UserDao {    
    public String getUserName(int id);
    public User selectUsersByID(int id);
    public User getPasswordSalt(String email);
    public String getPassword(int id);
    public void setPasswordSalt(User user);
    public void setPasswordSaltByUid(User user);
	public void insertUsersByEmail(@Param("email") String email, @Param("password") String password,@Param("user_name") String user_name,@Param("newSalt") String newSalt,@Param("parent_id") int parent_id);
	public int selectUserCountByUserName(@Param("user_name") String user_name);
	public Integer selectUIdByEmail(@Param("email") String email);
	public BonusType selectBonusTypeByBounsId(@Param("bonus_id") Integer bonusId);
	public void insertUsersByEmailId( Users users);
	
}