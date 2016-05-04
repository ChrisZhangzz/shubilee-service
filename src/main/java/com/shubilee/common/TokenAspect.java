package com.shubilee.common;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.ws.rs.QueryParam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;   
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.shubilee.entity.Token;
import com.shubilee.service.UserService;

public class TokenAspect {

	@Autowired
	private UserService userService;	
	

	public void checkToken(JoinPoint point) throws Exception {
		Gson gson = new Gson();
		Token token = new Token();
		Object[] obj = point.getArgs();
		Object target = point.getTarget();
		//System.out.println(target.toString());
		String method = point.getSignature().getName();
		Class<?> classz = target.getClass();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod()
				.getParameterTypes();

		try {
			Method m = classz.getMethod(method, parameterTypes);
			//System.out.println(m.getName());
			Annotation[][] annotations = m.getParameterAnnotations();
			a: for (int i = 0; i < annotations.length; i++) {
				for (Annotation annotation : annotations[i]) {
					if (!(annotation instanceof QueryParam))
						continue;
					QueryParam param = (QueryParam) annotation;
					if (("token").equals(param.value())) {
						token = gson.fromJson(StringUtil.decode((String) obj[i]), Token.class);
						break a;
					}
				}
			}
			validateToken(token, m);
		} catch (YamiException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new YamiException(YamiConstant.ERRORCODE_ER1003, ErrorCodeEnum.ER1003.getMsg());
		}
		
	}

	public void validateToken(Token token,Method m) throws Exception {
		//1. if it is temporary token
		//validate user operation
		if (m != null && m.isAnnotationPresent(NeedLogin.class)) {
			if (token.getIsLogin() == YamiConstant.IS_NOT_LOGIN) {
				throw new YamiException(YamiConstant.ERRORCODE_ER1004, ErrorCodeEnum.ER1004.getMsg());
			}
		}
		//validate the expire date.
		//when the token is not expires.
		if(token.getExp()>DateUtil.timeFormat(DateUtil.getNowDateTimeAllString())){
			//validate the token.
			//when it is temporary token.
			if(token.getIsLogin()==YamiConstant.IS_NOT_LOGIN){
				String salt = token.getData().substring(token.getData().lastIndexOf("-"),token.getData().length()-1);
				String auth = StringUtil.EncoderByMd5(salt, token.getData(), YamiConstant.ENCTIMES);
				if (!token.getAuth().equals(auth)) {
					throw new YamiException(YamiConstant.ERRORCODE_ER1003, ErrorCodeEnum.ER1003.getMsg());
				}
			}
			//when it is the token of user who already login.
			else if(token.getIsLogin()==YamiConstant.IS_LOGIN){
				String salt = token.getSalt();
				String uid = token.getData();
				//String auth = userService.getPassword(Integer.valueOf(token.getData()));
				String auth = StringUtil.EncoderByMd5(salt, uid, YamiConstant.ENCTIMES);
				if (!token.getAuth().equals(auth)) {
					throw new YamiException(YamiConstant.ERRORCODE_ER1003, ErrorCodeEnum.ER1003.getMsg());
				}
			 }else{
					throw new YamiException(YamiConstant.ERRORCODE_ER1003, ErrorCodeEnum.ER1003.getMsg());
			 }
		}
		//when the token expires.
		else{
		    	throw new YamiException(YamiConstant.ERRORCODE_ER1003, ErrorCodeEnum.ER1001.getMsg());
		}

	}

}
