/**
 * Yamibuy 核心计算类
 * ============================================================================
 * * 版权所有 Yamibuy，并保留所有权利。
 * 网站地址: http://www.yamibuy.com；
 * ----------------------------------------------------------------------------
 * $Author: james $
 * $Id: DbHelper.java 2015-04-29 
*/
package com.shubilee.common;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shubilee.bean.ComputerGoodResult;
import com.shubilee.bean.ComputerResult;
import com.shubilee.entity.Activity;
import com.shubilee.entity.ActivityGift;
import com.shubilee.entity.BonusLookup;
import com.shubilee.entity.BonusType;
import com.shubilee.entity.BonusVendor;
import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.Shipping;
import com.shubilee.entity.ShippingDistrictZipcode;
import com.shubilee.entity.ShopDistrictZipcode;
import com.shubilee.entity.TaxLookup;
import com.shubilee.entity.UserAddress;
import com.shubilee.entity.Vendors;








public class DistrictCheck {
	
	
	/*
	 商品区域限购检查
	 @param bonusType		
	 @param lstCart
	 @return Map<String,Object>	 
	*/
	public static Boolean  goodsDistrictCheck(String zipcode,List<ShopDistrictZipcode> lstShopZipcodeLimit) {
		Boolean result =false;
	
		//1、如果商品、供货商不存在区域限购配置设定，该商品默认为 无 区域限购，不理会good表中的is_district设置值
		if(null==lstShopZipcodeLimit||lstShopZipcodeLimit.size()==0){
			result = true;
		}
		else{
			for(ShopDistrictZipcode shopZipcodeLimit:lstShopZipcodeLimit){
				//截取前台输入zipcode前5位与数据库数据进行比对，防止出现5+4zipcode
				if(zipcode.substring(0, 5).equals(shopZipcodeLimit.getZipcode())){
					result = true;
				}
			}
		}
		
		
		
		return result;
		
	}
	
	/*
	 配货方式区域限购检查
	 @param bonusType		
	 @param lstCart
	 @return Map<String,Object>	 
	*/
	public static Boolean  shippingDistrictCheck(String zipcode,List<ShippingDistrictZipcode> lstShippingZipcodeLimit) {
		Boolean result =false;
		if(null==zipcode||"".equals(zipcode)){
			result = true;
		}else{
			

			//1、如果配货方式不存在区域限购配置设定，该配货方式默认为 无 区域限购，不理会shipping表中的zipcode_limit_id设置值
			if(null==lstShippingZipcodeLimit||lstShippingZipcodeLimit.size()==0){
				result = true;
			}
			else{
				for(ShippingDistrictZipcode shippingZipcodeLimit:lstShippingZipcodeLimit){
					//截取前台输入zipcode前5位与数据库数据进行比对，防止出现5+4zipcode
					if(zipcode.substring(0, 5).equals(shippingZipcodeLimit.getZipcode())){
						result = true;
					}
				}
			}
	}
		return result;
		
	}
		
		
		
}
