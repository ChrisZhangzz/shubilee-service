
package com.shubilee.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Cart;
import com.shubilee.entity.Template;
import com.shubilee.entity.Vendors;

public interface TemplateDao {

	public Template selectTemplateById(@Param("template_id") int tid);    

}
