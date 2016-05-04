package com.shubilee.common;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Provider
public class RestExceptionMapper implements ExceptionMapper<Exception> {

	//@Autowired
	//private LogUtil logger;
	private static Logger logger = LogManager.getLogger(RestExceptionMapper.class.getName());
	
	@Override
	public Response toResponse(Exception exception) {

		Map<String, Object> model = new HashMap<String, Object>();
		if(exception instanceof YamiException){
		    logger.error("Catch Exception " + ((YamiException)exception).getErrorId() + " = " + exception+" | Line = "+exception.getStackTrace()[0].getLineNumber()+" | Method = "+exception.getStackTrace()[0].getMethodName()+" | Class = "+exception.getStackTrace()[0].getClassName());
			model.put("errorId", ((YamiException) exception).getErrorId());
			model.put("enerrorMessage", ((YamiException) exception).getEnerrorMessage());
			model.put("cnerrorMessage", ((YamiException) exception).getCnerrorMessage());
			model.put("aderrorMessage", ((YamiException) exception).getAderrorMessage());
			model.put("goodsErrorDetail", ((YamiException) exception).getLstErrorGoodsInfo());
		}else{
		    logger.fatal("Catch Exception = " + exception+" | Line = "+exception.getStackTrace()[0].getLineNumber()+" | Method = "+exception.getStackTrace()[0].getMethodName()+" | Class = "+exception.getStackTrace()[0].getClassName());
			YamiException error = new YamiException(YamiConstant.ERRORCODE_ER1006,ErrorCodeEnum.ER1006.getMsg());
			model.put("errorId", error.getErrorId());
			model.put("enerrorMessage", error.getEnerrorMessage());
			model.put("cnerrorMessage", error.getCnerrorMessage());
			model.put("aderrorMessage", error.getAderrorMessage());
		}
		return Response.status(Status.OK).entity(model).build();
	}

}
