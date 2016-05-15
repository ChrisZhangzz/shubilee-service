package com.shubilee.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubilee.dao.ProductDao;
import com.shubilee.entity.Product;
import com.shubilee.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	

	@Override
	public Product selectBySku(String product_sku) {
		// TODO Auto-generated method stub
		return productDao.selectBySku(product_sku);
	}
	@Override
	public int updateProductNum(int quantity, String product_sku) {
		// TODO Auto-generated method stub
		return productDao.updateProductNum(quantity, product_sku);
	}
	@Override
	public List<Product> selectByParentSku(String parent_sku) {
		// TODO Auto-generated method stub
		return productDao.selectByParentSku(parent_sku);
	}
	@Override
	public List<Product> selectSimilarBySCC(String style, Integer size_us, String color) {
		// TODO Auto-generated method stub
		return productDao.selectSimilarBySCC(style, size_us, color);
	}
	@Override
	public List<Product> filterBySSC(Integer start, Integer leng, String style, Integer size_us,
			String color) {
		// TODO Auto-generated method stub
		return productDao.filterBySSC(size_us, leng, style, size_us, color);
	}
	@Override
	public List<String> selectSizeByColor(String product_sku, String color) {
		// TODO Auto-generated method stub
		return productDao.selectSizeByColor(product_sku, color);
	}

}
