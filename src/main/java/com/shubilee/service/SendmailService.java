package com.shubilee.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Address;
import com.shubilee.entity.MailTemplates;
import com.shubilee.entity.Profile;
import com.shubilee.entity.Sendmail;
import com.shubilee.entity.User;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.UserProfile;
import com.shubilee.entity.Vendors;

public interface SendmailService {
	public MailTemplates selectByPrimaryKey(String template_code);
	public int insert(Sendmail sendmail);
	public int selectCountByEmail(String email, String subject);
}
