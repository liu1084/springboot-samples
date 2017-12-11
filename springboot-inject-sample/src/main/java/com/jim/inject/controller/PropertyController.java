package com.jim.inject.controller;

import com.jim.inject.config.PropertiesBeanInjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: liu jun
 * @date: 14:26 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@RestController
@RequestMapping(value = "/")
public class PropertyController {

	@Autowired
	private PropertiesBeanInjectConfig config;

	@Autowired
	private List<String> myServers;

	@Autowired
	private List<String> myServers3;

	@Autowired
	private List<String> myServers4;

	@GetMapping("/getServers")
	public List<String> getServers(){
		return config.getServers();
	}

	@GetMapping("/getServers2")
	public List<String> getServers2(){
		return myServers;
	}


	@GetMapping("/getServers3")
	public List<String> getServers3() {
		return myServers3;
	}

	@GetMapping("/getServers4")
	public List<String> getServers4(){
		return myServers4;
	}
}
