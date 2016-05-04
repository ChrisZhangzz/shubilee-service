package com.shubilee.delegate;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shubilee.common.DateUtil;
import com.shubilee.common.StringUtil;
import com.shubilee.common.YamiConstant;
import com.shubilee.entity.AppSP;
import com.shubilee.entity.AppVersion;
import com.shubilee.entity.Token;
import com.shubilee.entity.User;
import com.shubilee.service.UserService;

@Service
public class SecurityServiceDelegate {

	@Value("${USER_TOKEN_EXP}")
	private Integer USER_TOKEN_EXP;
	
	@Autowired
	private UserService userService;
	
	/**
     * 获取未登陆状态下token
     * @param tempid 临时ID
     * @param token 
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public Map<String, Object> getToken4Tempid(String tempid) throws Exception {
		// 暂时设置tempId生成token超时时间为1年
		long timeOut4TempId = 3600L * 24L * 365L;
		long exp = DateUtil.timeFormat(DateUtil.getNowDateTimeAllString()) + timeOut4TempId;
		Map<String, Object> result = new HashMap<String, Object>();
		int enctimes = 2;
		String data = tempid;
		String ecSalt = tempid.substring(tempid.lastIndexOf("-"), tempid.length() - 1);
		String auth = StringUtil.EncoderByMd5(ecSalt, tempid, enctimes);
		Token tokenNew = new Token();
		tokenNew.setExp(exp);
		tokenNew.setData(data);
		tokenNew.setAuth(auth);
		Gson gson = new Gson();
		result.put("token", StringUtil.encode(gson.toJson(tokenNew)));

		return result;

	}
	/**
     * 检查token
     * @param token 
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public Boolean checkToken(String token)throws Exception{
		
		Boolean result = false;
		Gson gson = new Gson();  
		Token tokenIn = gson.fromJson(StringUtil.decode(token), Token.class);
		
		//验证token是否过期
		//token未过期处理
		if(tokenIn.getExp()>DateUtil.timeFormat(DateUtil.getNowDateTimeAllString())){
			//未登陆token验证
			if(tokenIn.getIsLogin()==0){
				String ecSalt = tokenIn.getData().substring(tokenIn.getData().lastIndexOf("-"),tokenIn.getData().length()-1);
				 String	auth =  StringUtil.EncoderByMd5(ecSalt,tokenIn.getData(),2);
				 if(tokenIn.getAuth().equals(auth)){
					 result = true; 
				 }else{
					 result = false; 
				 }
			}
			//登陆token验证
			else if(tokenIn.getIsLogin()==1){
				
			 }
		}
		//token过期处理，生成新token	
		else{
			result = false;
		}
		
		return result;  
   
 
	}
	
	/**
	 * getToken
	 * 
	 * @param uid
	 * @param auth
	 * @throws Exception
	 * @author chris
	 */
	public String getToken(int uid, String salt, String auth, int userType) throws Exception {

		int timeout = 3600*USER_TOKEN_EXP;
		long exp = DateUtil.timeFormat(DateUtil.getNowDateTimeAllString()) + timeout;
		String data = null;

		data = String.valueOf(uid);

		Token tokenNew = new Token();
		tokenNew.setExp(exp);
		tokenNew.setData(data);
		tokenNew.setAuth(auth);
		tokenNew.setSalt(salt);
		tokenNew.setIsLogin(1);
		tokenNew.setUserType(userType);
		Gson gson = new Gson();
		String result = StringUtil.encode(gson.toJson(tokenNew));
		return result;

	}
	/**
     * getTempId
     * @param N/A
     * @author chris
     */
	public String getTempId() {

		return UUID.randomUUID().toString();

	}
	/**
     * checkVersion
     * @param token String
     * @param version String
     * @author chris
     */
	public Map<String,Object> checkVersion(String token,String version) {
		Map<String,Object> result = new HashMap<String,Object>();
		List<AppVersion> lstAppVersion = userService.selectAppVersion();
		
		AppVersion lastAppVersion = new AppVersion();
		
		int status =2;
		
		boolean newVersion = true;
		
		for(AppVersion appVersion:lstAppVersion){
			if(lastAppVersion.getUpdateTime()!=null){
				if(lastAppVersion.getUpdateTime()<appVersion.getUpdateTime()){
					lastAppVersion = appVersion;
				}
			}else{
				lastAppVersion = appVersion;
			}
			
			if(version.equals(appVersion.getVersion())){
				if(appVersion.getIsUpdate()==1){
					status = 0 ;	
				}
				newVersion = false;
			}
		}
		
		if(version.equals(lastAppVersion.getVersion())){
			status = 1 ;	
		}else{
			if(lastAppVersion.getIsUpdate()==1){
				status = 0 ;	
			}
		}
		

		
		
		Map<String,Object> detail = new HashMap<String,Object>();
		//最新版本描述
		detail.put("last_ver_desc", lastAppVersion.getVersionDesc());
		//最新版本描述
		detail.put("last_ver_edesc", lastAppVersion.getVersionEdesc());
		//最新版本号
		detail.put("last_ver", lastAppVersion.getVersion());
		//最新版本发布日期
		detail.put("last_ver_date", lastAppVersion.getUpdateTime());
		// 0 :  版本太旧，不再支持  ，必须升级 1 : 当前为最新版   2： 当前版本不是最新版本，
		result.put("detail", detail);
		result.put("status", status);
		
		//为对应苹果检查，传递过来比数据库还要新的版本处理
		if(newVersion){
			status = 1 ;
			//最新版本描述
			detail.put("last_ver_desc", "");
			//最新版本描述
			detail.put("last_ver_edesc", "");
			//最新版本号
			detail.put("last_ver", version);
			//最新版本发布日期
			detail.put("last_ver_date", "");
			// 0 :  版本太旧，不再支持  ，必须升级 1 : 当前为最新版   2： 当前版本不是最新版本，
			result.put("detail", detail);
			result.put("status", status);
		}
		return result;

	}
	
	
	/**
     * 获取APP启动加载宣传图片
     * @param token String
     * @author james
     */
	public Map<String,Object> getAppSP(String token) {
		Map<String,Object> result = new HashMap<String,Object>();
		List<AppSP> lstAppSP = userService.selectAppSp();
		List<Map<String,Object>> lstImages = new ArrayList<Map<String,Object>>();
		Map<String,Object> image = new HashMap<String,Object>();
		Map<String,Object> basic   = new HashMap<String,Object>();
		for(AppSP appSP:lstAppSP){
			image = new HashMap<String,Object>();
			image.put("rec_id", appSP.getRecId());
			image.put("type", appSP.getType());
			image.put("start_time", appSP.getStartTime());
			image.put("end_time", appSP.getEndTime());
			if(appSP.getType()==YamiConstant.DISPLAY_DATA_TYPE_1){
				image.put("value", Integer.parseInt(appSP.getValue()));
				basic   = new HashMap<String,Object>();
				basic.put("name", appSP.getGoodsName());
				basic.put("ename", appSP.getGoodsEname());
				basic.put("is_promote", appSP.getIsPromote()?1:0);
				basic.put("promote_price", StringUtil.formatPrice(appSP.getPromotePrice()));
				basic.put("shop_price", StringUtil.formatPrice(appSP.getShopPrice()));
				basic.put("currency", "$");
				image.put("basic", basic);
				image.put("image",  appSP.getIsImage()==1?YamiConstant.IMAGE_URL+appSP.getImage():YamiConstant.IMAGE_URL+appSP.getGoodsImg());
				image.put("eimage",  appSP.getIsImage()==1?YamiConstant.IMAGE_URL+appSP.getImage():YamiConstant.IMAGE_URL+appSP.getGoodsImg());
			}else if(appSP.getType()==YamiConstant.DISPLAY_DATA_TYPE_2){
				image.put("value", Integer.parseInt(appSP.getValue()));
				Map<String,Object>  brand = new HashMap<String, Object>();
				brand.put("name",appSP.getBrandName());
				brand.put("ename",appSP.getBrandEname());
				image.put("brand", brand);
				image.put("image",  YamiConstant.IMAGE_URL+appSP.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+appSP.getEimage());
			}
			else if(appSP.getType()==YamiConstant.DISPLAY_DATA_TYPE_3){
				image.put("value", Integer.parseInt(appSP.getValue()));
				Map<String,Object>  cat = new HashMap<String, Object>();
				cat.put("name",appSP.getCatName());
				cat.put("ename",appSP.getCatEname());
				image.put("cat", cat);
				image.put("image",  YamiConstant.IMAGE_URL+appSP.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+appSP.getEimage());
			}

			else if(appSP.getType()==YamiConstant.DISPLAY_DATA_TYPE_4){
				image.put("value", appSP.getValue());
				image.put("evalue", appSP.getEvalue());
				image.put("image",  YamiConstant.IMAGE_URL+appSP.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+appSP.getEimage());
			}
			else if(appSP.getType()==YamiConstant.DISPLAY_DATA_TYPE_0){
				image.put("url",   appSP.getUrl());
				image.put("title",  appSP.getValue());
				image.put("etitle",  appSP.getEvalue());
				image.put("image",  YamiConstant.IMAGE_URL+appSP.getImage());
				image.put("eimage",  YamiConstant.IMAGE_URL+appSP.getEimage());
			}
			lstImages.add(image);

			
		}
		result.put("token", token);
		result.put("images", lstImages);
		return result;

	}
}
