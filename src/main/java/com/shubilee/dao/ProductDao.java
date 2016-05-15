
package com.shubilee.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shubilee.entity.BrandHot;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.GoodsComment;
import com.shubilee.entity.GoodsDisplayApp;
import com.shubilee.entity.GoodsDisplayDkp;
import com.shubilee.entity.GoodsFlash;
import com.shubilee.entity.GoodsGallery;
import com.shubilee.entity.GoodsOfCatItems;
import com.shubilee.entity.Message;
import com.shubilee.entity.MessageComment;
import com.shubilee.entity.MessageImage;
import com.shubilee.entity.MessagePost;
import com.shubilee.entity.Product;
import com.shubilee.entity.ShopDistrictZipcode;
import com.shubilee.entity.YmZipcode;

public interface ProductDao {  
	
    public Product selectBySku(@Param("product_sku") String product_sku);
    public int updateProductNum(@Param("quantity") int quantity,@Param("product_sku") String product_sku);   
    public List<Product> selectByParentSku(String parent_sku);
    public List<Product> selectSimilarBySCC(@Param("style") String style,@Param("size_us") Integer size_us,@Param("color") String color); 
    public List<Product> filterBySSC(@Param("start") Integer start,@Param("leng") Integer leng,@Param("style") String style,@Param("size_us") Integer size_us,@Param("color") String color);
    public List<String> selectSizeByColor(@Param("product_sku") String product_sku,@Param("color") String color);

    
  
}
