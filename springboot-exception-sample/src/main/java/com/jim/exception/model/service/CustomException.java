package com.jim.exception.model.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * @author: liu jun
 * @date: 21:04 2017/12/12
 * @ver: 1.0
 * @desc:
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Bad Request")
public class CustomException extends RuntimeException {
	public CustomException(String code, List<String> messages){

	}

	public CustomException(){}
}
