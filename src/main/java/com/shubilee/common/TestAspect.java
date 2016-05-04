package com.shubilee.common;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.paypal.base.rest.JSONFormatter;
import com.shubilee.entity.Token;
@Component
public class TestAspect {
	//@Autowired
	//private LogUtil logger;
	long t1 = 0;
	long t2 = 0;
	private Logger logger = LogManager.getLogger("test");
	private Logger loggerPayment = LogManager.getLogger("payment");

	public void pointCut() {
	};

	public void before(JoinPoint point) {

		HttpServletRequest request = ResteasyProviderFactory
				.getContextData(HttpServletRequest.class);
		Gson gson = new Gson();
		Token token = new Token();
		String uid = "";
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod()
				.getParameterTypes();

		Object[] obj = point.getArgs();
		Object target = point.getTarget();
		// System.out.println(target.toString());
		String method = point.getSignature().getName();
		Class<?> classz = target.getClass();
		if ("getIndexInfo".equals(method) || "showCategory".equals(method)
				|| "getShippingList".equals(method)) {

		} else {
			try {
				Method m = classz.getMethod(method, parameterTypes);
				// System.out.println(m.getName());
				Annotation[][] annotations = m.getParameterAnnotations();
				a: for (int i = 0; i < annotations.length; i++) {
					for (Annotation annotation : annotations[i]) {
						if (!(annotation instanceof QueryParam))
							continue;
						QueryParam param = (QueryParam) annotation;
						if (("token").equals(param.value())) {
							token = gson.fromJson(StringUtil.decode((String) obj[i]), Token.class);
							uid = token.getData();
							break a;
						}
					}
				}
			} catch (Exception e) {
			}
		}

		if (classz.equals(com.shubilee.rest.RestPaymentServiceV1.class)) {
			loggerPayment.info("---USER:" + uid + "---IP:" + request.getHeader("CF-Connecting-IP") + "---URI:"
					+ request.getRequestURI() + "---PARAMETERS:" + request.getQueryString());
			loggerPayment.info("---header:" + request.getHeader("user-agent"));
		}else{
			logger.info("---USER:" + uid + "---IP:" + request.getHeader("CF-Connecting-IP") + "---URI:"
					+ request.getRequestURI() + "---PARAMETERS:" + request.getQueryString());
			logger.info("---header:" + request.getHeader("user-agent"));
		}
		/*
		 * MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		 * MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //
		 * 椎内存使用情况 long totalMemorySize = memoryUsage.getInit(); // 初始的总内存 long
		 * maxMemorySize = memoryUsage.getMax(); // 最大可用内存 long usedMemorySize =
		 * memoryUsage.getUsed(); // 已使用的内存 t1 = System.currentTimeMillis();
		 * ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean(); long
		 * currentCpuTime = threadMXBean.getCurrentThreadCpuTime(); //
		 * 当前线程的cpu使用时间 Object target = point.getTarget(); String m =
		 * point.getSignature().getName(); logger.info("Start target===>" +
		 * target.toString() + "|" + m); logger.info("totalMemorySize===>" +
		 * totalMemorySize); logger.info("maxMemorySize===>" + maxMemorySize);
		 * logger.info("usedMemorySize===>" + usedMemorySize);
		 * logger.info("currentCpuTime===>" + currentCpuTime);
		 */
	}

	public void after(JoinPoint point) throws IOException {

		/*
		 * MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		 * MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //
		 * 椎内存使用情况 long totalMemorySize = memoryUsage.getInit(); // 初始的总内存 long
		 * maxMemorySize = memoryUsage.getMax(); // 最大可用内存 long usedMemorySize =
		 * memoryUsage.getUsed(); // 已使用的内存 Object target = point.getTarget();
		 * String m = point.getSignature().getName();
		 * logger.info("End target===>" + target.toString() + "|" + m);
		 * logger.info("totalMemorySize===>" + totalMemorySize);
		 * logger.info("maxMemorySize===>" + maxMemorySize);
		 * logger.info("usedMemorySize===>" + usedMemorySize); ThreadMXBean
		 * threadMXBean = ManagementFactory.getThreadMXBean(); long
		 * currentCpuTime = threadMXBean.getCurrentThreadCpuTime(); //
		 * 当前线程的cpu使用时间 logger.info("currentCpuTime===>" + currentCpuTime); t2 =
		 * System.currentTimeMillis(); logger.info("run time======>  " + (int)
		 * ((t2 - t1) / 1000) + "   seconds   " + ((t2 - t1) % 1000) +
		 * "   micro   seconds");
		 */

	}

	public void log(JoinPoint point, Object returnVal) {
		ServerResponse response = (ServerResponse) returnVal;
		Gson gson = new Gson();
		Token token = new Token();
		String uid = "";
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod()
				.getParameterTypes();

		Object[] obj = point.getArgs();
		Object target = point.getTarget();
		// System.out.println(target.toString());
		String method = point.getSignature().getName();
		Class<?> classz = target.getClass();
		if ("getIndexInfo".equals(method) || "showCategory".equals(method)
				|| "getShippingList".equals(method)) {

		} else {
			try {
				Method m = classz.getMethod(method, parameterTypes);
				// System.out.println(m.getName());
				Annotation[][] annotations = m.getParameterAnnotations();
				a: for (int i = 0; i < annotations.length; i++) {
					for (Annotation annotation : annotations[i]) {
						if (!(annotation instanceof QueryParam))
							continue;
						QueryParam param = (QueryParam) annotation;
						if (("token").equals(param.value())) {
							token = gson.fromJson(StringUtil.decode((String) obj[i]), Token.class);
							uid = token.getData();
							break a;
						}
					}
				}
			} catch (Exception e) {
			}
		}

		if (classz.equals(com.shubilee.rest.RestPaymentServiceV1.class)) {
			loggerPayment.info("---USER:" + uid + "---returnMethod:" + point.getSignature().getName()
					+ "---returnVal:" + JSONFormatter.toJSON(response.getEntity()));			
		}else{
			logger.info("---USER:" + uid + "---returnMethod:" + point.getSignature().getName()
					+ "---returnVal:" + JSONFormatter.toJSON(response.getEntity()));			
		}
		if(JSONFormatter.toJSON(response.getEntity()).contains("Yamibuy_Master")){
			logger.fatal("!!!Include DB NAME! " + "---returnMethod:" + point.getSignature().getName()
					+ "---returnVal:" + response.getEntity());	
		}
	}

}
