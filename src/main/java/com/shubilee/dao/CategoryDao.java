
package com.shubilee.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.CategoryForShow;



public interface CategoryDao {  

	public List<CategoryForShow> selectShowCategory();
	public List<CategoryForShow> selectShowCategory4Index();
	public List<CategoryForShow> selectShowCategory4Channel3();
	public List<CategoryForShow> selectShowCategory4Channel5();
	public List<CategoryForShow> selectShowCategory4Channel2();
	public List<CategoryForShow> selectShowCategory4Channel4();
	public String selectCatInfoByGid(@Param("goods_id") int goods_id);
	public CategoryForShow selectCategoryInfo(@Param("cat_id") int cat_id);
}