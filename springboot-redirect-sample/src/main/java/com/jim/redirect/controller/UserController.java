package com.jim.redirect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author: liu jun
 * @date: 06:38 2017/12/10
 * @ver: 1.0
 * @desc:
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	//使用RedirectView进行重定向 -- HttpServletResponse.sendRedirect()

	@GetMapping("/add")
	public ModelAndView add(ModelAndView modelAndView, @ModelAttribute("id") Object id){
		LOGGER.info("====================================>" + id.toString());
		modelAndView.setViewName("/user/add-user");
		return modelAndView;
	}

	@GetMapping("/origin")
	public RedirectView add(RedirectAttributes attributes){
		attributes.addAttribute("username", "liujun");
		attributes.addFlashAttribute("id", "1");
		return new RedirectView("target");
	}

	@GetMapping("/target")
	public String index(){
		return "forward:/user/add";
	}
}
