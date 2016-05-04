
package com.shubilee.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Cart;
import com.shubilee.entity.Sendmail;
import com.shubilee.entity.Template;
import com.shubilee.entity.Vendors;

public interface SendMailDao {

	public void insertEmailTupe(@Param("email") String email, @Param("template_subject") String template_subject,
			                    @Param("template_content") String template_content, @Param("user_name") String user_name);
	public int insert(Sendmail sendmail);
	public int selectCountByEmail(@Param("email") String email,@Param("subject") String subject);
}
