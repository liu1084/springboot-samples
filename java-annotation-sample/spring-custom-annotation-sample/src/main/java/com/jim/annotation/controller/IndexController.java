package com.jim.annotation.controller;

import com.jim.annotation.model.sevice.annotation.LogAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liu jun
 * @date: 17:47 2017/12/15
 * @ver: 1.0
 * @desc:
 */
@RestController
public class IndexController {
	@LogAnnotation
	@RequestMapping("/")
	public String index(){

		return "index";
	}
}
