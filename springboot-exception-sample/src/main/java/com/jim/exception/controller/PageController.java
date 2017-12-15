package com.jim.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: liu jun
 * @date: 21:53 2017/12/12
 * @ver: 1.0
 * @desc:
 */
@Controller
public class PageController {

	@RequestMapping("/page")
	public ModelAndView index(ModelAndView modelAndView){
		String mess = null;
		mess.split(",");
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@ExceptionHandler({Exception.class})
	public ModelAndView handleException(Exception ex, HttpServletRequest request, HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", ex.getMessage() + ex.getClass().getName());
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.addObject("code", response.getStatus());
		modelAndView.setViewName("exception");
		return modelAndView;
	}
}
