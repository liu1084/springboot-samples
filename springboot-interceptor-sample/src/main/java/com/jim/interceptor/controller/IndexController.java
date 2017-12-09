package com.jim.interceptor.controller;

import com.jim.interceptor.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author: liu jun
 * @date: 21:27 2017/12/9
 * @ver: 1.0
 * @desc:
 */
@Controller
public class IndexController {

	@GetMapping(value = "/")
	@ResponseBody
	public String index(){
		return "index";
	}

	@PostMapping (value = "/index")
	public String indexPage(Model model, @RequestBody User user){
		model.addAttribute("message", "hello");
		model.addAttribute("user", user);
		return "index";
	}
}
