package com.jim.inject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @author: liu jun
 * @date: 14:32 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@Configuration
@PropertySource(value = "classpath:config/${spring.profiles.active}.properties", encoding="utf-8")
public class PropertiesBeanConfig {
	@Value("#{'${my.servers}'.split(',')}")
	private List<String> servers;

	@Bean(name = "myServers")
	public List<String> getServers(){
		return servers;
	}

	@Bean(name="myServers3")
	public List<String> getServers2(@Value("#{'${my.servers}'.split(',')}") List<String> servers){
		return servers;
	}
}
