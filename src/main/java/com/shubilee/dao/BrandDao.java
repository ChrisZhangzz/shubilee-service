
package com.shubilee.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.Brand;
import com.shubilee.entity.BrandAttr;
import com.shubilee.entity.BrandName;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsOfCatItems;

public interface BrandDao {  
	
	public BrandName selectNameByBrandId(@Param("brand_id") int brandId);
	public List<BrandName> selectCatBrands(@Param("cat_id") int cat_id);
	public Brand selectBrandInfo(@Param("brand_id") int brandId);
	public List<Brand> selectBrands(@Param("cat_id") Integer cat_id,@Param("index") String index);
	public BrandAttr selectBrandAttrByBrandId(@Param("brand_id") int brandId);
}