package com.jim.interceptor.config;

import com.jim.interceptor.model.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: liu jun
 * @date: 21:25 2017/12/9
 * @ver: 1.0
 * @desc:
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired private MyInterceptor myInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor);
	}
}
