package com.jim.inject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: liu jun
 * @date: 17:10 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@Component
@ConfigurationProperties(prefix = "my")
public class PropertiesBeanConfig2 {
	private List<String> servers;

	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}
}
