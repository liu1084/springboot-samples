package com.jim.exception.controller;

import com.jim.exception.model.service.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liu jun
 * @date: 21:28 2017/12/12
 * @ver: 1.0
 * @desc:
 */
@RestController
public class IndexController {
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/")
	public void index() throws CustomException {
		throw new CustomException();
	}

	@ExceptionHandler({Exception.class, CustomException.class})
	@ResponseStatus(value = HttpStatus.LOCKED, reason = "Bad request locked")
	private void orderExceptionHandler(){

	}

}
