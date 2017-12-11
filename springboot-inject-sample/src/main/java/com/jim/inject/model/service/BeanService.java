package com.jim.inject.model.service;

import com.jim.inject.controller.BeanController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: liu jun
 * @date: 20:44 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@Service
public class BeanService implements IBeanService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BeanService.class);
	@Autowired
	private Integer random;

	@Override
	public Integer getRandomInteger(Integer max) {
		LOGGER.debug("bean inject");
		return random;
	}

	@PostConstruct
	public void randomIntABS(){
		LOGGER.debug("after bean init");
		random = random < 0 ? Math.abs(random) : random;
	}

	@PreDestroy
	public void destroy(){
		LOGGER.debug("before bean destroy");
		random = 0;
	}
}
