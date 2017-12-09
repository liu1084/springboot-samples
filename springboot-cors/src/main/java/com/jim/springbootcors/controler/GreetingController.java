package com.jim.springbootcors.controler;

import com.jim.springbootcors.model.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liu jun
 * @date: 15:13 2017/12/8
 * @ver: 1.0
 * @desc:
 */
@RestController
@PropertySource("classpath:cors.properties")
public class GreetingController {

	@Autowired
	private Greeting greeting;

	//@CrossOrigin(origins = "http://localhost:9090")
	@GetMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		greeting.setContent(name);
		return greeting;
	}
}
