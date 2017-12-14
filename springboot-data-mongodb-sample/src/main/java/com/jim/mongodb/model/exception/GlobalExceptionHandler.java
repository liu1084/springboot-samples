package com.jim.mongodb.model.exception;

import com.jim.mongodb.config.EnumResponseStatus;
import com.jim.mongodb.model.entity.exception.ExceptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: liu jun
 * @date: 19:11 2017/12/14
 * @ver: 1.0
 * @desc:
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private ExceptionInfo exceptionInfo;

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ExceptionInfo exceptionHandler(HttpServletRequest request, Exception e) {
		String url = request.getRequestURI(), message = e.getMessage();
		EnumResponseStatus status = EnumResponseStatus.EMPTY;

		exceptionInfo.setMessage(message);
		exceptionInfo.setStatus(status);
		exceptionInfo.setUrl(url);
		return exceptionInfo;
	}
}
