/**
 * Yamibuy 核心服务层
 * ============================================================================
 * * 版权所有 Yamibuy，并保留所有权利。
 * 网站地址: http://www.yamibuy.com；
 * ----------------------------------------------------------------------------
 * $Author: james $
 * $Id: DbHelper.java 2015-04-29 
*/
package com.shubilee.common;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Deflater;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jboss.resteasy.util.Base64;





import com.shubilee.entity.Cart;
import com.shubilee.entity.Goods;
import com.shubilee.entity.OrderGenerate;
import com.shubilee.redis.entity.CartRedis;
import com.shubilee.redis.entity.OrderGenerateRedis;

import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;







public class StringUtil {
	
	public static final Map<String, String> STATE_MAP;
	static {
	    STATE_MAP = new HashMap<String, String>();
	    STATE_MAP.put("AL", "Alabama");
	    STATE_MAP.put("AK", "Alaska");
	    STATE_MAP.put("AB", "Alberta");
	    STATE_MAP.put("AZ", "Arizona");
	    STATE_MAP.put("AR", "Arkansas");
	    STATE_MAP.put("BC", "British Columbia");
	    STATE_MAP.put("CA", "California");
	    STATE_MAP.put("CO", "Colorado");
	    STATE_MAP.put("CT", "Connecticut");
	    STATE_MAP.put("DE", "Delaware");
	    STATE_MAP.put("DC", "District of Columbia");
	    STATE_MAP.put("FL", "Florida");
	    STATE_MAP.put("GA", "Georgia");
	    STATE_MAP.put("GU", "Guam");
	    STATE_MAP.put("HI", "Hawaii");
	    STATE_MAP.put("ID", "Idaho");
	    STATE_MAP.put("IL", "Illinois");
	    STATE_MAP.put("IN", "Indiana");
	    STATE_MAP.put("IA", "Iowa");
	    STATE_MAP.put("KS", "Kansas");
	    STATE_MAP.put("KY", "Kentucky");
	    STATE_MAP.put("LA", "Louisiana");
	    STATE_MAP.put("ME", "Maine");
	    STATE_MAP.put("MB", "Manitoba");
	    STATE_MAP.put("MD", "Maryland");
	    STATE_MAP.put("MA", "Massachusetts");
	    STATE_MAP.put("MI", "Michigan");
	    STATE_MAP.put("MN", "Minnesota");
	    STATE_MAP.put("MS", "Mississippi");
	    STATE_MAP.put("MO", "Missouri");
	    STATE_MAP.put("MT", "Montana");
	    STATE_MAP.put("NE", "Nebraska");
	    STATE_MAP.put("NV", "Nevada");
	    STATE_MAP.put("NB", "New Brunswick");
	    STATE_MAP.put("NH", "New Hampshire");
	    STATE_MAP.put("NJ", "New Jersey");
	    STATE_MAP.put("NM", "New Mexico");
	    STATE_MAP.put("NY", "New York");
	    STATE_MAP.put("NF", "Newfoundland");
	    STATE_MAP.put("NC", "North Carolina");
	    STATE_MAP.put("ND", "North Dakota");
	    STATE_MAP.put("NT", "Northwest Territories");
	    STATE_MAP.put("NS", "Nova Scotia");
	    STATE_MAP.put("NU", "Nunavut");
	    STATE_MAP.put("OH", "Ohio");
	    STATE_MAP.put("OK", "Oklahoma");
	    STATE_MAP.put("ON", "Ontario");
	    STATE_MAP.put("OR", "Oregon");
	    STATE_MAP.put("PA", "Pennsylvania");
	    STATE_MAP.put("PE", "Prince Edward Island");
	    STATE_MAP.put("PR", "Puerto Rico");
	    STATE_MAP.put("QC", "Quebec");
	    STATE_MAP.put("RI", "Rhode Island");
	    STATE_MAP.put("SK", "Saskatchewan");
	    STATE_MAP.put("SC", "South Carolina");
	    STATE_MAP.put("SD", "South Dakota");
	    STATE_MAP.put("TN", "Tennessee");
	    STATE_MAP.put("TX", "Texas");
	    STATE_MAP.put("UT", "Utah");
	    STATE_MAP.put("VT", "Vermont");
	    STATE_MAP.put("VI", "Virgin Islands");
	    STATE_MAP.put("VA", "Virginia");
	    STATE_MAP.put("WA", "Washington");
	    STATE_MAP.put("WV", "West Virginia");
	    STATE_MAP.put("WI", "Wisconsin");
	    STATE_MAP.put("WY", "Wyoming");
	    STATE_MAP.put("YT", "Yukon Territory");
	}
	
	/**
	 * base64编码
	 * 
	 * @param String
	 * @return String
	 */
	public static String encode(String input) throws Exception {
		String result = Base64.encodeBytes(input.getBytes("utf-8"));

		return result;
	}

	/**
	 * base64解码
	 * 
	 * @param string
	 * @return string
	 */
	public static String decode(String str) {
		byte[] bt = null;
		try {
			bt = Base64.decode(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new String(bt);
	}  
	
	/**
     * MD5加密（多次）登陆
     * @param salt 
     * @param pwd 
     * @param enctimes 加密次数
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public static String EncoderByMd5(String salt,String pwd,int enctimes) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		String saltTemp = salt;
		for(int i =0;i<enctimes;i++){
			saltTemp = StringUtil.EncoderByMd5(saltTemp, pwd);
		}
		return saltTemp;
	}
	/**
     * MD5加密（单次）登陆
     * @param salt 
     * @param pwd 
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public  static String EncoderByMd5(String salt,String pwd) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update((salt+"||"+pwd).getBytes("UTF-8"));
		 StringBuffer buf=new StringBuffer(); 
		 for(byte b:md5.digest()){
			 buf.append(String.format("%02x", b&0xff));        
        }
		
		 String md5pwd = buf.toString();
		return md5pwd;
	}
	

	/**
     * MD5加密FinishOrder
     * @param salt 
     * @param pwd 
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public  static String EncoderByMd5ForFinishOrder(String salt,String purchase_id) throws NoSuchAlgorithmException,UnsupportedEncodingException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update((purchase_id).getBytes("UTF-8"));
		 StringBuffer buf=new StringBuffer(); 
		 for(byte b:md5.digest()){
			 buf.append(String.format("%02x", b&0xff));        
        }
		
		 String md5purchase_id = buf.toString();
		 
		 MessageDigest md5Sec = MessageDigest.getInstance("MD5");
		 md5Sec.update((md5purchase_id+salt).getBytes("UTF-8"));
		 StringBuffer bufSec=new StringBuffer(); 
		 for(byte b:md5Sec.digest()){
			 bufSec.append(String.format("%02x", b&0xff));        
        }
		 

		return bufSec.toString();
	}
	
	
	/**
     * 订单号生成工具
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public  static String GetOrderSN(){
		int max=99999;
        int min=10000;
		String result;
		Random random = new Random();
		String randomValue = String.valueOf(random.nextInt(max)%(max-min+1) + min);
		result = DateUtil.getShortNow1().concat(randomValue);
		return result;
	}
	
	
	/**
     * 根据客户端类型 、当前要求显示页，确定数据的起始点
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public  static Map<String,Integer> GetClientType(int page,String agent){
		Map<String,Integer> result = new HashMap<String,Integer>();
		if(page==0){page=1;}
		
		//默认为手机配置
				int index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
				int ITEMS_PER_PAGE = YamiConstant.ITEMS_PER_PAGE_MOBILE;
				
				if(agent==null||agent.trim().equals(YamiConstant.STRING_EMPTY)){
					agent = "android";
				}
				//System.out.println(agent.toString());
				//识别调试器,完成调试器配置
				Pattern pattern = Pattern.compile(YamiConstant.REGEX_SOAPUI, Pattern.CASE_INSENSITIVE);
		        Matcher matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find soapUI ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
		    		ITEMS_PER_PAGE = YamiConstant.ITEMS_PER_PAGE_MOBILE;
		        }
			    //识别苹果手机
		        pattern = Pattern.compile(YamiConstant.REGEX_IPHONE, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find iphone ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_MOBILE;
		        }
		        //识别三星系列智能设备.
		        pattern = Pattern.compile(YamiConstant.REGEX_ANDROID, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find android ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_MOBILE;
		        }
		        //识别火狐浏览器
		        pattern = Pattern.compile(YamiConstant.REGEX_FIREFOX, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find firefox ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
		        }
				//识别windows平台浏览器
		        pattern = Pattern.compile(YamiConstant.REGEX_IE, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find ie ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
		        }
		        //识别chrome浏览器
		        pattern = Pattern.compile(YamiConstant.REGEX_CHROME, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find chrome ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
		        }
		        //识别ipad平台.
		        pattern = Pattern.compile(YamiConstant.REGEX_IPAD, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find ipad ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
		        }
		        //识别mac平台.
		        pattern = Pattern.compile(YamiConstant.REGEX_MAC, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find imac ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_LABTOP;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP;
		        }
		        result.put("start", index);
		        result.put("length", ITEMS_PER_PAGE);
		        return result;
	}
	/**
     * 根据客户端类型 、当前要求显示页，确定数据的起始点
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public  static Map<String,Integer> GetClientTypeForPromoteItems(int page,String agent){
		Map<String,Integer> result = new HashMap<String,Integer>();
		if(page==0){page=1;}
		
		//默认为手机配置
				int index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
				int ITEMS_PER_PAGE = YamiConstant.ITEMS_PER_PAGE_MOBILE;
				
				if(agent==null||agent.trim().equals(YamiConstant.STRING_EMPTY)){
					agent = "android";
				}
				//System.out.println(agent.toString());
				//识别调试器,完成调试器配置
				Pattern pattern = Pattern.compile(YamiConstant.REGEX_SOAPUI, Pattern.CASE_INSENSITIVE);
		        Matcher matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find soapUI ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
		    		ITEMS_PER_PAGE = YamiConstant.ITEMS_PER_PAGE_MOBILE;
		        }
			    //识别苹果手机
		        pattern = Pattern.compile(YamiConstant.REGEX_IPHONE, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find iphone ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_MOBILE;
		        }
		        //识别三星系列智能设备.
		        pattern = Pattern.compile(YamiConstant.REGEX_ANDROID, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find android ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_MOBILE;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_MOBILE;
		        }
		        //识别火狐浏览器
		        pattern = Pattern.compile(YamiConstant.REGEX_FIREFOX, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find firefox ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		        }
				//识别windows平台浏览器
		        pattern = Pattern.compile(YamiConstant.REGEX_IE, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find ie ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		        }
		        //识别chrome浏览器
		        pattern = Pattern.compile(YamiConstant.REGEX_CHROME, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find chrome ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		        }
		        //识别ipad平台.
		        pattern = Pattern.compile(YamiConstant.REGEX_IPAD, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find ipad ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		        }
		        //识别mac平台.
		        pattern = Pattern.compile(YamiConstant.REGEX_MAC, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		        	//System.out.println("find imac ");
		    		index = (page-1)*YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_PROMOTEITEMS;
		        }
		        result.put("start", index);
		        result.put("length", ITEMS_PER_PAGE);
		        return result;
	}
	
	/**
     * 根据客户端类型 、当前数据位置，确定需要显示数据的起始点(为发现页服务)
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public  static Map<String,Integer> GetClientType4Discovery(int currentIndex,String agent){
		Map<String,Integer> result = new HashMap<String,Integer>();

		
				//默认为手机配置
				int index = currentIndex+1;
				int ITEMS_PER_PAGE = YamiConstant.ITEMS_PER_PAGE_MOBILE_DISCOVERY;
				
				if(agent==null||agent.trim().equals(YamiConstant.STRING_EMPTY)){
					agent = "android";
				}
				//System.out.println(agent.toString());
				//识别调试器,完成调试器配置
				Pattern pattern = Pattern.compile(YamiConstant.REGEX_SOAPUI, Pattern.CASE_INSENSITIVE);
		        Matcher matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		    		ITEMS_PER_PAGE = YamiConstant.ITEMS_PER_PAGE_MOBILE_DISCOVERY;
		        }
			    //识别苹果手机
		        pattern = Pattern.compile(YamiConstant.REGEX_IPHONE, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_MOBILE_DISCOVERY;
		        }
		        //识别三星系列智能设备.
		        pattern = Pattern.compile(YamiConstant.REGEX_ANDROID, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_MOBILE_DISCOVERY;
		        }
		        //识别火狐浏览器
		        pattern = Pattern.compile(YamiConstant.REGEX_FIREFOX, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP_DISCOVERY;
		        }
				//识别windows平台浏览器
		        pattern = Pattern.compile(YamiConstant.REGEX_IE, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP_DISCOVERY;
		        }
		        //识别chrome浏览器
		        pattern = Pattern.compile(YamiConstant.REGEX_CHROME, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP_DISCOVERY;
		        }
		        //识别ipad平台.
		        pattern = Pattern.compile(YamiConstant.REGEX_IPAD, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP_DISCOVERY;
		        }
		        //识别mac平台.
		        pattern = Pattern.compile(YamiConstant.REGEX_MAC, Pattern.CASE_INSENSITIVE);
		        matcher = pattern.matcher(agent);
		        if (matcher.find()) 
		        {
		    		ITEMS_PER_PAGE=YamiConstant.ITEMS_PER_PAGE_LABTOP_DISCOVERY;
		        }
		        result.put("start", index);
		        result.put("length", ITEMS_PER_PAGE);
		        return result;
	}
	/**
	 * 判断商品该使用何种价格，false-原价 true-折扣价
	 * 
	 * @param String
	 * @return String
	 */
	public  static Boolean checkPrice(Goods goods) throws Exception{
		Boolean result = false;
		if(goods.getIsPromote()){
//			if(Long.valueOf(goods.getPromoteWeekly())>DateUtil.getNowLong()){
//				result=true;
//			}else 
				if(Long.valueOf(goods.getPromoteStartDate())<DateUtil.getNowLong()&&Long.valueOf(goods.getPromoteEndDate())>DateUtil.getNowLong()){
				result=true;
			}else if(Long.valueOf(goods.getPromoteCountdown())>DateUtil.getNowLong()){
				result=true;
			}
		}
		return result;
	}
	/**
	 * 判断商品该使用何种价格，false-原价 true-折扣价
	 * 
	 * @param String
	 * @return String
	 */
	public  static Boolean checkPrice(Cart cart) throws Exception{
		Boolean result = false;
		if(cart.getIs_promote_stock()){
//			if(Long.valueOf(cart.getPromote_weekly_stock())>DateUtil.getNowLong()){
//				result=true;
//			}else 
			if(Long.valueOf(cart.getPromote_start_date_stock())<DateUtil.getNowLong()&&Long.valueOf(cart.getPromote_end_date_stock())>DateUtil.getNowLong()){
				result=true;
			}else if(Long.valueOf(cart.getPromote_countdown_stock())>DateUtil.getNowLong()){
				result=true;
			}
		}
		return result;
	}
	
	
	/**
	 * 邮箱校验判断有唯一[ @ ] 跟随唯一[ . ]
	 * 
	 * @param String
	 * @return Boolean true:通过验证 false:未通过验证
	 */
	public  static Boolean checkEmail(String email) {
		Boolean result = false;
		
		if(email.indexOf("@")==-1){
			return false;
		}
		if(email.indexOf(".")==-1){
			return false;
		}
		if(email.indexOf("@")==email.lastIndexOf("@")){
			 result = true;
		}
		if(email.substring(email.indexOf("@"), email.length()-1).indexOf(".")==email.substring(email.indexOf("@"), email.length()-1).lastIndexOf(".")){
			result = true;
		}
		return result;
	}
	/**
	 * 判断字符串长度是否大于等于指定值
	 * 
	 * @param String
	 * @return Boolean true:通过验证 false:未通过验证
	 */
	public  static Boolean checkMoneLength(String param,int length) {
		Boolean result = false;
		if(param.length()>=length){
			result =  true;
		}
		return result;
	}
	/**
	 * 判断字符串长度是否小于等于指定值
	 * 
	 * @param String
	 * @return Boolean true:通过验证 false:未通过验证
	 */
	public  static Boolean checkLessLength(String param,int length) {
		Boolean result = false;
		if(param.length()<=length){
			result =  true;
		}
		return result;
	}
	/**
	 * 邮编为0-9  五为数字
	 * 
	 * @param String
	 * @return Boolean true:通过验证 false:未通过验证
	 */
	public  static Boolean checkZipcode(String zipcode) {
		String zipCodePattern = YamiConstant.ZIP_CODE_PATTERN;
		Boolean result = false;
		result = zipcode.matches(zipCodePattern);

		return result;
	}
	/**
	 * 卡号为0-9 14-16位
	 * 
	 * @param String
	 * @return Boolean true:通过验证 false:未通过验证
	 */
	public  static Boolean checkAccount(String account) {
		Boolean result = false;
		if(account.length()>=14&&account.length()<=16){
			result =  true;
		}
		return result;
	}
	
	/**
	 * 格式化金额，保留小数点后00
	 * 
	 * @param BigDecimal
	 * @return Boolean true:通过验证 false:未通过验证
	 */
	public  static String formatPrice(BigDecimal price) {
		
		BigDecimal result =    price.multiply(new BigDecimal(100)).divide(new BigDecimal(100)).setScale(2);
		

		return String.valueOf(result);
	}
	
	/**
	   * 
	   * @Title : filterChinese
	   * @Type : FilterStr
	   * @Description : 过滤出中文
	   * @param chin
	   * @return
	   */
	  public static String filterChinese(String chin)
	  {
	    chin = chin.replaceAll("[^(\\u4e00-\\u9fa5)]", "");
	    return chin;
	  }
	  
	  
		/**
		 * 格式化CartRedis
		 * 
		 * @param String
		 * @return 
		 */
	  public static CartRedis formateCartRedis(Cart cart){
		CartRedis cartRedis = new CartRedis();
		cartRedis.setGoods_id(cart.getGoods_id());
		cartRedis.setGoods_number(cart.getGoods_number());
		cartRedis.setIs_gift(cart.getIs_gift().intValue());
		cartRedis.setVendor_id(cart.getVendor_id());
	    return cartRedis;
	  }
	  
		/**
		 * 格式化OrederGenerateRedis
		 * 
		 * @param String
		 * @return 
		 */
	  public static OrderGenerateRedis formateOrederGenerateRedis(OrderGenerate orderGenerate){
	    OrderGenerateRedis orderGenerateRedis = new OrderGenerateRedis();
		    orderGenerateRedis.setBonusId(orderGenerate.getBonusId());
		    orderGenerateRedis.setPointFlag(orderGenerate.getPointFlag());
	  		orderGenerateRedis.setShippingId(orderGenerate.getShippingId());
		    orderGenerateRedis.setProfileId(orderGenerate.getProfileId());
		    orderGenerateRedis.setVendorId(orderGenerate.getVendorId());
		    orderGenerateRedis.setShippingAdd(orderGenerate.getShippingAdd());
	    return orderGenerateRedis;
	  }

		/**
		 * 加密共享URL字符串
		 * 加密算法为：先用zlib压缩明文，之后转码成Base64编码
		 * 密文 = Base64.Encode ( zlib.deflate(明文) )
		 * @param String
		 * @return 
		 */
	  public static String deflater(String input)throws Exception{

		     byte[] pInput = input.getBytes("UTF-8");
		     
		     // Compress the bytes
		     byte[] pOutput = new byte[512];
		     Deflater theCompresser = new Deflater();
		     
		     theCompresser.setInput(pInput);
		     theCompresser.finish();
		     int nZipLen = theCompresser.deflate(pOutput);
		     theCompresser.end();
		     
		     byte[] pRealOutput = Arrays.copyOf(pOutput, nZipLen);
		     byte [] pOutInBase64 = org.apache.commons.codec.binary.Base64.encodeBase64(pRealOutput);
		     
		     int nLen = pOutInBase64.length;		     
		     StringBuilder strbdTemp = new StringBuilder();
		     for(int i=0;i<nLen;i++){		    	 
		    	 strbdTemp.append(Character.toString((char) pOutInBase64[i]));
		     }

		     String result = strbdTemp.toString();
		  
		  
		  return result;
		  
	  }
	  
		/**
		 * 解压缩字符串
		 * 解密算法为：先Base64转码，然后用zlib解压缩
		 * 明文 = zlib.unzip( Base64.Decode(密文))
		 * @param String
		 * @return 
		 */
	  public static String iflater(String input)throws Exception{
		  
		     byte [] pCipher = org.apache.commons.codec.binary.Base64.decodeBase64(input);
		     		     
		     // Decompress the bytes
		     Inflater theDecompresser = new Inflater();
		     theDecompresser.setInput(pCipher, 0, pCipher.length);
		     byte[] result = new byte[200];
		     int resultLength = theDecompresser.inflate(result);
		     theDecompresser.end();

		     // Decode the bytes into a String
		     String outputString = new String(result, 0, resultLength, "UTF-8");
		     return outputString;
	  }
		/**
		 * 生成分享链接URL
		 * 
		 * @param String
		 * @return 
		 */
	  public static String makeShareUrl(String token,Integer gid)throws Exception{
		  	String result = "";
		  	String urlSection1 = "http://idata.yamibuy.com/ad?";
		  	String urlSection2 = "n="+"6";
		  	String urlSection3 = "a=y"+"75614";
		  	String urlSection4 = "s="+"75614";
		     // Encode a String into bytes
		     String inputString = "0010201510282015112700000756140000060100020036www.yamibuy.com/cn/goods.php?id=4543";
		     result = deflater(inputString);

		  	return result;
	   
	  }
	  
		/**
		 * 获取指定范围随机数
		 * 
		 * @param String
		 * @return 
		 */
	  public static int getRandom(int min,int max){
	        Random random = new Random();
	        int s = random.nextInt(max)%(max-min+1) + min;

		  	return s;
	   
	  } 
		/**
		 * 判断字符串是否包含中文
		 * 
		 * @param String
		 * @return 
		 */
	  public static boolean isContainChinese(String str) {
		  
		  if(null==str||"".equals(str)){
			  return false;
		  }
		  Pattern p=Pattern.compile("[u4e00-u9fa5]");
		  Matcher m=p.matcher(str);
		  if(m.find())
		  {
		   return false;
		  }
		  return true;
		 }  
	  
	  
		/**
		 * 判断字符串是否包含中文
		 * 
		 * @param String
		 * @return 
		 */
	  public static String htmlEncode(String str) {
		  

		  return StringEscapeUtils.escapeHtml3(str);
		 }  
	  
	  



		/**
		 * 生成随机8位邀请码
		 * 
		 * @param String
		 * @return 
		 */
	  public static String createInvitationCode() {
		  char ch[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
		          '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
		          'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
		          'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
		          'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
		          'z', '0', '1' };
		  Random random = new Random();
	          int index = 0;
	          char[] temp = new char[8];
	          int num = random.nextInt();
	          for (int i = 0; i < 8 % 5; i++) {
	              temp[index++] = ch[num & 63];//取后面六位，记得对应的二进制是以补码形式存在的。
	              num >>= 6;//63的二进制为:111111
	              // 为什么要右移6位？因为数组里面一共有64个有效字符。为什么要除5取余？因为一个int型要用4个字节表示，也就是32位。
	          }
	          for (int i = 0; i < 8 / 5; i++) {
	              num = random.nextInt();
	              for (int j = 0; j < 5; j++) {
	                  temp[index++] = ch[num & 63];
	                  num >>= 6;
	              }
	          }
	          return new String(temp, 0, 8);
	  }
	  /* 
	   * 判断是否为整数  
	   * @param str 传入的字符串  
	   * @return 是整数返回true,否则返回false  
	 */  
	   
	   
	   public static boolean isInteger(String str) {  
		   if("".equals(str)){
			   return false;
		   }
		   
		   
	     Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
	     return pattern.matcher(str).matches();    
	   }
		  /* 
		   * 判断是否为数字  
		   * @param str 传入的字符串  
		   * @return 是数字返回true,否则返回false  
		 */ 
	   public static boolean isNumeric(String str){  
		   for (int i = str.length();--i>=0;){    
		    if (!Character.isDigit(str.charAt(i))){  
		     return false;  
		    }  
		   }  
		   return true;  
		 } 
}
