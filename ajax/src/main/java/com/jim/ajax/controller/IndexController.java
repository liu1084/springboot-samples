package com.jim.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: liu jun
 * @date: 17:43 2017/12/8
 * @ver: 1.0
 * @desc:
 */
@Controller
public class IndexController {
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("message", "hello");
		return "index";
	}
}
