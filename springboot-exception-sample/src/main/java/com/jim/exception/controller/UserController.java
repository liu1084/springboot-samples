package com.jim.exception.controller;

import com.jim.exception.model.service.CustomException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liu jun
 * @date: 21:13 2017/12/12
 * @ver: 1.0
 * @desc:
 */
@RestController
@RequestMapping
public class UserController {
	@RequestMapping("/myUrl")
	public void index(){
		throw new CustomException();
	}
}
