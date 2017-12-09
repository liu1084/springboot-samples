package com.jim.springbootcors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: liu jun
 * @date: 15:33 2017/12/9
 * @ver: 1.0
 * @desc:
 */
@Configuration
public class CORSConfig extends WebMvcConfigurerAdapter {
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/greeting")
				.allowedOrigins(new String[]{"http://localhost:9090", "http://localhost:9091"});
	}
}
