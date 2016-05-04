package com.shubilee.entity;

import java.math.BigDecimal;
import java.util.Date;

public class User {
	
	private int user_Id;

    private String email;

    private String user_Name;

    private String password;

    private String question;

    private String answer;

    private int sex;

    private Date birthday;

    private BigDecimal userMoney;

    private BigDecimal frozenMoney;

    private int pay_points;

    private int rankPoints;

    private int addressId;

    private int regTime;

    private int lastLogin;

    private Date lastTime;

    private String lastIp;

    private int visit_Count;

    private Byte userRank;

    private Byte isSpecial;


	private String ec_salt;

    private String salt;

    private int parentId;

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String userName) {
		this.user_Name = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public BigDecimal getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(BigDecimal userMoney) {
		this.userMoney = userMoney;
	}

	public BigDecimal getFrozenMoney() {
		return frozenMoney;
	}

	public void setFrozenMoney(BigDecimal frozenMoney) {
		this.frozenMoney = frozenMoney;
	}

	

	public int getPay_points() {
		return pay_points;
	}

	public void setPay_points(int pay_points) {
		this.pay_points = pay_points;
	}

	public int getRankPoints() {
		return rankPoints;
	}

	public void setRankPoints(int rankPoints) {
		this.rankPoints = rankPoints;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getRegTime() {
		return regTime;
	}

	public void setRegTime(int regTime) {
		this.regTime = regTime;
	}

	public int getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(int lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public int getVisit_Count() {
		return visit_Count;
	}

	public void setVisit_Count(int visit_Count) {
		this.visit_Count = visit_Count;
	}

	public Byte getUserRank() {
		return userRank;
	}

	public void setUserRank(Byte userRank) {
		this.userRank = userRank;
	}

	public Byte getIsSpecial() {
		return isSpecial;
	}

	public void setIsSpecial(Byte isSpecial) {
		this.isSpecial = isSpecial;
	}

    public String getEc_salt() {
		return ec_salt;
	}

	public void setEc_salt(String ec_salt) {
		this.ec_salt = ec_salt;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
