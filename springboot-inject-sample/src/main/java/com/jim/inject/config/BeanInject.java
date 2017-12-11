package com.jim.inject.config;

import com.jim.inject.model.service.IBeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * @author: liu jun
 * @date: 20:07 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@Configuration
public class BeanInject {
	private static final int INIT = 1000;
	private static final Logger LOGGER = LoggerFactory.getLogger(BeanInject.class);
	@Autowired private IBeanService beanService;

	@Bean(name = "randomInt")
	public Integer getRandomInt(){
		return beanService.getRandomInteger(INIT);
	}

	@Bean(name = "random")
	public Integer getRand(){
		LOGGER.debug("create Bean");
		return new Random(INIT).nextInt();
	}
}
