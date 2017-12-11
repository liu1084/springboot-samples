package com.jim.inject.controller;

import com.jim.inject.model.service.IBeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author: liu jun
 * @date: 20:09 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@RestController
public class BeanController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BeanController.class);
	@Autowired
	private IBeanService beanService;

	@GetMapping("/getRandom")
	public Integer getRandomInt() {
		LOGGER.debug("controller");
		return beanService.getRandomInteger(1000);
	}
}
