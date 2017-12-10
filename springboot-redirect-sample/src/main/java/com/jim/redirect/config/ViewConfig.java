package com.jim.redirect.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author: liu jun
 * @date: 07:47 2017/12/10
 * @ver: 1.0
 * @desc:
 */
@Configuration
public class ViewConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".html");
		registry.viewResolver(viewResolver);

	}
}
