package com.jim.inject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author: liu jun
 * @date: 17:12 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@EnableConfigurationProperties(PropertiesBeanConfig2.class)
@Configuration
public class PropertiesBeanConfig21 {

	@Autowired
	private PropertiesBeanConfig2 propertiesBeanConfig2;

	@Bean(name = "myServers4")
	public List<String> getServers4(){
		return propertiesBeanConfig2.getServers();
	}
}
