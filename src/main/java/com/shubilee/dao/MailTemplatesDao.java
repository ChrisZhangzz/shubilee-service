
package com.shubilee.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Cart;
import com.shubilee.entity.MailTemplates;
import com.shubilee.entity.Vendors;

public interface MailTemplatesDao {    
	public MailTemplates selectByTemplateCode(@Param("template_code") String template_code);

}
