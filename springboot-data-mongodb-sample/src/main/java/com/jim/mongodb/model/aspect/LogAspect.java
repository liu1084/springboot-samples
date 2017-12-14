package com.jim.mongodb.model.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author: liu jun
 * @date: 01:46 2017/12/15
 * @ver: 1.0
 * @desc:
 */
@Component
@Aspect
public class LogAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

	private ThreadLocal<Long> startTime = new ThreadLocal<>();
	private Gson gson = new Gson();

	@Pointcut("execution(* com.jim.mongodb.controller..*.*(..))")
	private void webLog() {

	}

	@Before("webLog()")
	public void beforeRequest(JoinPoint joinPoint) {
		startTime.set(System.currentTimeMillis());
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		LOGGER.debug("---------------Request begin---------------");
		LOGGER.debug(request.getRequestURL().toString());
		LOGGER.debug(request.getMethod());
		LOGGER.debug(request.getRequestedSessionId());
		LOGGER.debug(request.getRemoteAddr());
		LOGGER.debug(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		LOGGER.debug(Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void afterRequest(Object ret) {
		LOGGER.debug("Elapsed Time:" + (System.currentTimeMillis() - startTime.get()));
		LOGGER.debug("Response:" + gson.toJson(ret));
		LOGGER.debug("---------------Request end---------------");
	}

	@AfterThrowing(pointcut = "webLog()", throwing = "exception")
	public void afterThrowing(Exception exception) {
		LOGGER.debug(gson.toJson(exception));
	}
}
