package com.jim.mongodb.model.entity.exception;

import com.jim.mongodb.config.EnumResponseStatus;
import org.springframework.stereotype.Component;

/**
 * @author: liu jun
 * @date: 20:29 2017/12/14
 * @ver: 1.0
 * @desc:
 */
@Component
public class ExceptionInfo {
	private String url;
	private String message;
	private EnumResponseStatus status;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EnumResponseStatus getStatus() {
		return status;
	}

	public void setStatus(EnumResponseStatus status) {
		this.status = status;
	}
}
