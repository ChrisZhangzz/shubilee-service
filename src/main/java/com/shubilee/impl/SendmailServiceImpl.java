package com.shubilee.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.MailTemplatesDao;
import com.shubilee.dao.SendMailDao;
import com.shubilee.entity.MailTemplates;
import com.shubilee.entity.Sendmail;
import com.shubilee.service.MailTemplatesService;
import com.shubilee.service.SendmailService;

@Service
public class SendmailServiceImpl implements SendmailService {

	@Autowired
	private MailTemplatesDao mailTemplatesDao;
	@Autowired
	private SendMailDao sendmailDao;
	public MailTemplates selectByPrimaryKey(String template_code){
		return mailTemplatesDao.selectByTemplateCode(template_code);
	}
	public int insert(Sendmail sendmail){
		return sendmailDao.insert(sendmail);
	}
	public int selectCountByEmail(String email, String subject) {
		return sendmailDao.selectCountByEmail(email,subject);
	}
	
}
