package com.shubilee.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.MailTemplatesDao;
import com.shubilee.entity.MailTemplates;
import com.shubilee.service.MailTemplatesService;

@Service
public class MailTemplateServiceImpl implements MailTemplatesService {

	@Autowired
	private MailTemplatesDao mailTemplatesDao;

	public MailTemplates selectByPrimaryKey(String template_code){
		return mailTemplatesDao.selectByTemplateCode(template_code);
	}
}
