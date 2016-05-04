package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.bean.InviteHistory;
import com.shubilee.entity.Address;
import com.shubilee.entity.AppSP;
import com.shubilee.entity.AppVersion;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.Count;
import com.shubilee.entity.Feedback;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsImage;
import com.shubilee.entity.GoodsOosRemind;
import com.shubilee.entity.Integral;
import com.shubilee.entity.OrderGoods;
import com.shubilee.entity.OrderInfo;
import com.shubilee.entity.PointLotteryConfig;
import com.shubilee.entity.PointLotterySet;
import com.shubilee.entity.PointLotterylog;
import com.shubilee.entity.Profile;
import com.shubilee.entity.Template;
import com.shubilee.entity.User;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserInfoOrder;
import com.shubilee.entity.UserInfoOrderMaxCat;
import com.shubilee.entity.UserInfoOrderMaxGoods;
import com.shubilee.entity.UserProfile;
import com.shubilee.entity.Users;
import com.shubilee.entity.Vendors;

public interface UserService {
	public String getUserName(int uid);
	
    public User selectUsersByID(int id);
	
    public User getPasswordSalt(String email);

    public String getPassword(int id);
    
    public void setPasswordSalt(User user);
    
    public void setPasswordSaltByUid(User user);

    public List<UserAddress> getAddressBookByUid(int id);    

    public List<Profile> getProfileByUid(int id);
    
    public int insertProfile(UserProfile profile);
    
    public int updateProfileByPK(UserProfile profile);
    
    public int deleteProfileByPK(String profile_id);    

    public int countProfileByPK(String profile_id);    
    
    public int countProfileByUid(int user_id);

    public int updateProfileByAddressId(int user_id,int address_id,String profile_id);  
    
    public UserAddress getAddressBookByAddId(int id);  
    
    public UserAddress getAddressDefaultByUid(int id);

    public int insertAddress(UserAddress userAddress);
    
    public int updateAddressByPK(UserAddress userAddress);
    
    public int deleteAddressByPK(int address_id);
    
    public int countAddressByPK(int address_id);  
    
    public int countAddressByUid(int user_id);  
    
    public int updateAddressIsPrimaryByPKUid(int user_id,int address_id);  
    
    public int updateAddressIsPrimaryByUid(int address_id);    

    public int updateProfileAddressIdByPK(int address_id,String profile_id);  
    
    public int updateProfileIsPrimaryByPKUid(int user_id,String profile_id);  
    
    public int updateProfileIsPrimaryByUid(int user_id);
    
    public UserProfile getProfileByPid(String profile_id);
    
    public UserProfile selectProfileDefaultByUid(int user_id);

	public List<OrderInfo> getOrderInfo(int purchase_id);

	public int getSumOfitemsbyOrdersId(int orderId);

	public List<Goods> getImagesbyOrdersId(int orderId);

	public Vendors getVendorsByVendorId(int vendorId);

	public List<OrderInfo> getPurchaseList(int uid, int index, int items_Per_Page);
	
	public List<OrderInfo> getPurchaseListById(int uid, int purchase_id);
	
//
	public List<OrderInfo> getOrderInfoByUid(int uid,int[] listPid );/////////////////////////////////////////////////////////////////
	
	public int getPurchaseListCount(int uid, int index, int items_Per_Page);

	public OrderInfo getOrderInfoByOrderId(int uid,int order_id);

	public List<OrderGoods> getOrderGoodsByOrdersId(int order_id);

	public void insertUsersByEmail(String email, String password,String user_name,String newSalt,int parent_id);

	public int selectUserCountByUserName(String user_name);

	public Integer selectUIdByEmail(String email);

	public void addIntegral(String addIntergralForRegister, int uid,long time, int type);
	
	public int addIntegralSelective(Integral record);

	public Template selectTemplateById(int tid);

	public void addWelcomeEmail(String email, String template_subject,String template_content, String user_name);

	public BonusType getBonusTypeByBounsId(Integer bonusId);

	public Users selectUserInfoByUid(int user_id);
	
    public int updateUserNameByUid(int user_id,String user_name);
    
    public int updateSexByUid(int user_id,int sex,String avatar);
    
    public int selectCountByUserName(int user_id,String user_name);
    
    public List<Integral> selectPointHistory(int user_id,Integer start,Integer length);
    public int selectPointHistoryCount(int user_id);
    public List<Integral> selectPointHistoryGet(int user_id,Integer start,Integer length);
    public int selectPointHistoryGetCount(int user_id);
    public List<Integral> selectPointHistoryPay(int user_id,Integer start,Integer length);
    public int selectPointHistoryPayCount(int user_id);
    
    public int updatePointByUid(int user_id, Long point);
    
    public int updatePhoneByUid(int user_id,String mobile_phone);
    public int updateTureNameByUid(int user_id,String truename);
    public int updateEmail(int user_id,String email);

	public void insertUsersByEmail(String email, Users users);

	public String getRegisterPoints();

	public List<Count> getSumOfitemsbyOrdersIDList(int[] orderIdList);

	public List<GoodsImage> getImagesbyOrdersIDList(int[] orderIdList);

	public List<OrderGoods> getOrderGoodsByOrdersIDList(int[] orderIdList);

	public List<Vendors> getVendorsByVendorIDList(int[] vendorIdList);

	public int insertFeedback(Feedback feedback);
	public List<Feedback> selectFeedback(int user_id);
	
    public int updateUserInfoByUid(int user_id,String username,int sex,String birthday,String phone,String avatar);
    
	public OrderInfo selectOrderInfoByOrderIdV2(int uid,Integer table_year,int order_id);
	
    public List<AppVersion> selectAppVersion();
    
    public List<Goods> selectGoodsOosRemindInfoByUserId(int userId);
    public int insertRemind(int userId,int goodsId);
    public int deleteRemind(int userId,int goodsId);
    public int updateRemindEmail(int userId,String email);
    public int checkRemindFlag(int userId,int goodsId);
    
	public PointLotterySet getPointLotterySet(String date);
    public int updateTotalPoint4Winning(int rec_id,int point);
    public int updateLotterySetNoWinning(int rec_id);
    public int updateUserPayPoint(int user_id,int point);
    public int insert(PointLotterylog pointLotterylog);
    public List<PointLotteryConfig> getPointLotteryConfig(String date);
	public int updatePointLotteryConfigWinningNum(int rec_id);
    
	
	public List<AppSP> selectAppSp();
    public int updateInviteCodeByUid(int user_id,String invite_code);
    public int selectUsersByInviteCode(String invite_code);
    
    public Users selectUserInfoByInviteCode(String invite_code);
    
    public List<InviteHistory> selectInviteHistoryByUserid(int user_id);
    public int updateFirstOrderTimeByUid(int user_id);
    
    
    public List<UserInfoOrder> selectUserInfoOrderByUid(int user_id);
    public UserInfoOrderMaxGoods selectUserInfoOrderMaxGoodsByUid(int user_id);
    public UserInfoOrderMaxCat selectUserInfoOrderMaxCatByUid(int user_id);
}
