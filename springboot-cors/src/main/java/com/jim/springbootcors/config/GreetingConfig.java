package com.jim.springbootcors.config;

import com.jim.springbootcors.model.entity.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: liu jun
 * @date: 15:18 2017/12/8
 * @ver: 1.0
 * @desc:
 */
@Component
@Configuration
public class GreetingConfig {
	@Bean
	public Greeting greeting(){
		final AtomicLong counter = new AtomicLong();
		final String content = "";
		return new Greeting(counter.incrementAndGet(), content);
	}
}
