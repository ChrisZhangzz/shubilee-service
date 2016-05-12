package com.shubilee.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.bean.InviteHistory;
import com.shubilee.dao.AddressDao;
import com.shubilee.dao.AppSPDao;
import com.shubilee.dao.AppVersionDao;
import com.shubilee.dao.FeedbackDao;
import com.shubilee.dao.GoodsOosRemindDao;
import com.shubilee.dao.IntegralDao;
import com.shubilee.dao.OrderGoodsDao;
import com.shubilee.dao.OrderInfoDao;
import com.shubilee.dao.PointLotteryConfigDao;
import com.shubilee.dao.PointLotteryLogDao;
import com.shubilee.dao.PointLotterySetDao;
import com.shubilee.dao.ProfileDao;
import com.shubilee.dao.SendMailDao;
import com.shubilee.dao.TemplateDao;
import com.shubilee.dao.UsersDao;
import com.shubilee.dao.VendorsDao;
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
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserInfoOrder;
import com.shubilee.entity.UserInfoOrderMaxCat;
import com.shubilee.entity.UserInfoOrderMaxGoods;
import com.shubilee.entity.UserProfile;
import com.shubilee.entity.Users;
import com.shubilee.entity.Vendors;
import com.shubilee.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AppVersionDao appVersionDao;
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	@Autowired
	private OrderGoodsDao orderGoodsDao;
	
	@Autowired
	private VendorsDao vendorsDao;
	
	@Autowired
	private IntegralDao integralDao;
	
	@Autowired
	private TemplateDao templateDao;
	
	@Autowired
	private SendMailDao sendMailDao;
	@Autowired
	private FeedbackDao feedbackDao;
	
	@Autowired
	private GoodsOosRemindDao goodsOosRemindDao;
	
	
	@Autowired
	private PointLotterySetDao pointLotterySetDao;
	
	@Autowired
	private PointLotteryLogDao pointLotteryLogDao;
	
	@Autowired
	private PointLotteryConfigDao pointLotteryConfigDao;
	
	@Autowired
	private AppSPDao appSPDao;
	
	public String getUserName(int uid) {
		return usersDao.getUserName(uid);
	}

	public Users selectUsersByID(int id) {
		return usersDao.selectUsersByID(id);
	}
	
	public Users getPasswordSalt(String email) {
		return usersDao.getPasswordSalt(email);
	}
	
	public String getPassword(int id) {
		return usersDao.getPassword(id);
	}
	
	public void setPasswordSalt(Users user) {
		usersDao.setPasswordSalt(user);
	}
	
	public void setPasswordSaltByUid(Users user) {
		usersDao.setPasswordSaltByUid(user);
	}
	
	public List<UserAddress> getAddressBookByUid(int id) {
		return addressDao.getAddressBookByUid(id);
	}		
	
	public List<Profile> getProfileByUid(int id) {
		return profileDao.getProfileByUid(id);
	}	
	
    public int insertProfile(UserProfile profile){
    	return profileDao.insert(profile);
    }
    
    public int updateProfileByPK(UserProfile profile){
    	return profileDao.updateByPrimaryKey(profile);
    }
    
    public int deleteProfileByPK(String profile_id){
    	return profileDao.deleteByPrimaryKey(profile_id);
    }    

    public int countProfileByPK(String profile_id){
    	return profileDao.countByPrimaryKey(profile_id);    	
    }

    public int countProfileByUid(int user_id){
    	return profileDao.countByUid(user_id);    	
    }
    
    public UserAddress getAddressBookByAddId(int id){
    	return addressDao.getAddressBookByAddid(id);
    }

    
    public UserAddress getAddressDefaultByUid(int id){
    	return addressDao.getAddressDefaultByUid(id);
    }


	public int insertAddress(UserAddress userAddress) {
    	return addressDao.insert(userAddress);
	}

	public int updateAddressByPK(UserAddress userAddress) {
		return addressDao.updateByPrimaryKey(userAddress);
	}

	public int deleteAddressByPK(int address_id) {
		return addressDao.deleteByPrimaryKey(address_id);
	}

	public int countAddressByPK(int address_id) {
		return addressDao.countByPrimaryKey(address_id);
	}

	public int countAddressByUid(int id) {
		return addressDao.countByUid(id);
	}
	
	public int updateAddressIsPrimaryByPKUid(int user_id,int address_id) {
		return addressDao.updateIsPrimaryByPKUid(user_id,address_id);
	}

	public int updateAddressIsPrimaryByUid(int user_id) {
		return addressDao.updateIsPrimaryByUid(user_id);
	}

	public int updateProfileAddressIdByPK(int address_id,String profile_id) {
		return profileDao.updateAddressIdByPK(address_id,profile_id);
	}
	
	public int updateProfileIsPrimaryByPKUid(int user_id,String profile_id) {
		return profileDao.updateIsPrimaryByPKUid(user_id,profile_id);
	}

	public int updateProfileIsPrimaryByUid(int user_id) {
		return profileDao.updateIsPrimaryByUid(user_id);
	}
	
	public UserProfile getProfileByPid(String profile_id){
		return profileDao.selectByPrimaryKey(profile_id);

	}
    public UserProfile selectProfileDefaultByUid(int user_id){
    	return profileDao.selectProfileDefaultByUid(user_id);
    }

	public int updateProfileByAddressId(int user_id,int address_id,String profile_id) {
		return profileDao.updateByAddressId(user_id,address_id,profile_id);
	}   
	
	public List<OrderInfo> getOrderInfo(int purchase_id) {
		return orderInfoDao.selectOrderInfo(purchase_id);
	}

	public int getSumOfitemsbyOrdersId(int orderId) {
		// TODO Auto-generated method stub
		return orderGoodsDao.selectSumOfitemsbyOrdersId(orderId);
	}

	public List<Goods> getImagesbyOrdersId(int orderId) {
		// TODO Auto-generated method stub
		return orderGoodsDao.selectImagesbyOrdersId(orderId);
	}

	public Vendors getVendorsByVendorId(int vendorId) {
		// TODO Auto-generated method stub
		return vendorsDao.selectByPrimaryKey(vendorId);
	}
	
	public List<OrderInfo> getPurchaseList(int uid, int index, int items_Per_Page) {
		// TODO Auto-generated method stub
		return orderInfoDao.selectPurchaseList(uid, index, items_Per_Page);
	}
	public List<OrderInfo> getPurchaseListById(int uid, int purchase_id) {
		// TODO Auto-generated method stub
		return orderInfoDao.selectPurchaseListById(uid, purchase_id);
	}
	
	
	
	

	public List<OrderInfo> getOrderInfoByUid(int uid,int[]listPid) {
		// TODO Auto-generated method stub
		return orderInfoDao.selectOrderInfoByUid(uid,listPid);
	}
	
	public int getPurchaseListCount(int uid,int index,int items_Per_Page) {
		// TODO Auto-generated method stub
		return orderInfoDao.selectPurchaseListCount(uid,index, items_Per_Page);
	}

	public OrderInfo getOrderInfoByOrderId(int uid,int order_id) {
		// TODO Auto-generated method stub
		return orderInfoDao.selectOrderInfoByOrderId(uid,order_id);
	}

	public List<OrderGoods> getOrderGoodsByOrdersId(int order_id) {
		// TODO Auto-generated method stub
		return orderGoodsDao.selectOrderGoodsByOrdersId(order_id);
	}
	
	public void insertUsersByEmail(String email, String password,String user_name,String newSalt,int parent_id) {
		// TODO Auto-generated method stub
		usersDao.insertUsersByEmail(email,password,user_name,newSalt,parent_id);
	}
	
	public int selectUserCountByUserName(String user_name) {

		return usersDao.selectUserCountByUserName(user_name);
	}
	
	public Integer selectUIdByEmail(String email) {
		// TODO Auto-generated method stub
		return usersDao.selectUIdByEmail(email);
	}

	public void addIntegral(String addIntergralForRegister, int uid,long time, int type) {
        
		integralDao.insertIntegral(addIntergralForRegister,uid,time,type);
	}

	public Template selectTemplateById(int tid) {
		return templateDao.selectTemplateById(tid);
	}

	public void addWelcomeEmail(String email, String template_subject,String template_content, String user_name) {
	
		sendMailDao.insertEmailTupe(email,template_subject,template_content,user_name);
	}

	public BonusType getBonusTypeByBounsId(Integer bonusId) {
		// TODO Auto-generated method stub
		return usersDao.selectBonusTypeByBounsId(bonusId);
	}

	public Users selectUserInfoByUid(int user_id){
		return usersDao.selectUserInfoByID(user_id);
	}
	
    public int updateUserNameByUid(int user_id,String user_name){
    	return usersDao.updateUserNameByUid(user_id, user_name);
    }
    
    public int updateSexByUid(int user_id,int sex,String avatar){
    	return usersDao.updateSexByUid(user_id, sex, avatar);
    }
    
    public int selectCountByUserName(int user_id,String user_name){
    	return usersDao.selectCountByUserName(user_id,user_name);
    }
    
    
    public List<Integral> selectPointHistory(int user_id,Integer start,Integer length){
    	return usersDao.selectPointHistory(user_id, start, length);
    }
    public int selectPointHistoryCount(int user_id){
    	return usersDao.selectPointHistoryCount(user_id);
    }
    public List<Integral> selectPointHistoryGet(int user_id,Integer start,Integer length){
    	return usersDao.selectPointHistoryGet(user_id, start, length);
    }
    public int selectPointHistoryGetCount(int user_id){
    	return usersDao.selectPointHistoryGetCount(user_id);
    }
    public List<Integral> selectPointHistoryPay(int user_id,Integer start,Integer length){
    	return usersDao.selectPointHistoryPay(user_id, start, length);
    }
    public int selectPointHistoryPayCount(int user_id){
    	return usersDao.selectPointHistoryPayCount(user_id);
    } 
    
    public int updatePointByUid(int user_id, Long point){
    	return usersDao.updatePointByUid(user_id, point);
    }
    public int updatePhoneByUid(int user_id,String mobile_phone){
    	return usersDao.updatePhoneByUid(user_id, mobile_phone);
    }
    public int updateTureNameByUid(int user_id,String truename){
    	return usersDao.updateTureNameByUid(user_id, truename);
    }
    public int updateEmail(int user_id,String email){
    	return usersDao.updateEmail(user_id, email);
    }

	public void insertUsersByEmail(String email, Users users) {
		// TODO Auto-generated method stub
		usersDao.insertUsers(users);
	}

	public String getRegisterPoints() {
		// TODO Auto-generated method stub
		return usersDao.getRegisterPoints();
	}

	public int addIntegralSelective(Integral record){
		return integralDao.insertSelective(record);
	}
	
	public List<Count> getSumOfitemsbyOrdersIDList(int[] orderIdList) {
		// TODO Auto-generated method stub
		return orderInfoDao.getSumOfitemsbyOrdersIDList(orderIdList);
	}

	public List<GoodsImage> getImagesbyOrdersIDList(int[] orderIdList) {
		// TODO Auto-generated method stub
		return orderInfoDao.getImagesbyOrdersIDList(orderIdList);
	}

	public List<OrderGoods> getOrderGoodsByOrdersIDList(int[] orderIdList) {
		// TODO Auto-generated method stub
		return orderGoodsDao.selectOrderGoodsByOrdersIDList(orderIdList);
	}

	public List<Vendors> getVendorsByVendorIDList(int[] vendorIdList) {
		// TODO Auto-generated method stub
		return vendorsDao.selectByPrimaryKeyList(vendorIdList);
	}
	
	
	
	public int insertFeedback(Feedback feedback){
		return feedbackDao.insert(feedback);
	}
	public List<Feedback> selectFeedback(int user_id){
		return feedbackDao.selectFeedback(user_id);
	}
    public int updateUserInfoByUid(int user_id,String username,int sex,String birthday,String phone,String avatar){
    	return usersDao.updateUserInfoByUid(user_id, username, sex, birthday, phone, avatar);
    }
	public OrderInfo selectOrderInfoByOrderIdV2(int uid,Integer table_year,int order_id){
		return orderInfoDao.selectOrderInfoByOrderIdV2(uid, table_year, order_id);
	}
	
    public List<AppVersion> selectAppVersion(){
    	return appVersionDao.selectAppVersion();
    }
    
    public List<Goods> selectGoodsOosRemindInfoByUserId(int userId){
    	return goodsOosRemindDao.selectGoodsOosRemindInfoByUserId(userId);
    }
    public int insertRemind(int userId,int goodsId){
    	return goodsOosRemindDao.insert(userId, goodsId);
    }
    public int deleteRemind(int userId,int goodsId){
    	return goodsOosRemindDao.delete(userId, goodsId);
    }
    public int updateRemindEmail(int userId,String email){
    	return usersDao.updateRemindEmail(userId, email);
    }
    public int checkRemindFlag(int userId,int goodsId){
    	return goodsOosRemindDao.checkRemindFlag(userId, goodsId);
    }
    
    
	public PointLotterySet getPointLotterySet(String date){
		return pointLotterySetDao.getPointLotterySet(date);
	}
    public int updateTotalPoint4Winning(int rec_id,int point){
    	return pointLotterySetDao.updateTotalPoint4Winning(rec_id, point);
    }
    public int updateLotterySetNoWinning(int rec_id){
    	return pointLotterySetDao.updateLotterySetNoWinning(rec_id);
    }
    public int updateUserPayPoint(int user_id,int point){
    	return pointLotterySetDao.updateUserPayPoint(user_id, point);
    }
    public int insert(PointLotterylog pointLotterylog){
    	return pointLotteryLogDao.insert(pointLotterylog);
    }
    
    public List<PointLotteryConfig> getPointLotteryConfig(String date){
    	return pointLotteryConfigDao.getPointLotteryConfig(date);
    }
    public int updatePointLotteryConfigWinningNum(int rec_id){
    	return pointLotteryConfigDao.updatePointLotteryConfigWinningNum(rec_id);
    }
    
    public List<AppSP> selectAppSp(){
    	return appSPDao.selectAppSp();
    }
    public int updateInviteCodeByUid(int user_id,String invite_code){
    	return usersDao.updateInviteCodeByUid(user_id, invite_code);
    }
    public int selectUsersByInviteCode(String invite_code){
    	return usersDao.selectUsersByInviteCode(invite_code);
    }
    public Users selectUserInfoByInviteCode(String invite_code){
    	return usersDao.selectUserInfoByInviteCode(invite_code);
    }
    
    public List<InviteHistory> selectInviteHistoryByUserid(int user_id){
    	return usersDao.selectInviteHistoryByUserid(user_id);
    }
    public int updateFirstOrderTimeByUid(int user_id){
    	return usersDao.updateFirstOrderTimeByUid(user_id);
    }
    
    public List<UserInfoOrder> selectUserInfoOrderByUid(int user_id){
    	return usersDao.selectUserInfoOrderByUid(user_id);
    }
    public UserInfoOrderMaxGoods selectUserInfoOrderMaxGoodsByUid(int user_id){
    	return usersDao.selectUserInfoOrderMaxGoodsByUid(user_id);
    }
    public UserInfoOrderMaxCat selectUserInfoOrderMaxCatByUid(int user_id){
    	return usersDao.selectUserInfoOrderMaxCatByUid(user_id);
    }
}
