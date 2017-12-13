package com.jim.i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @author: liu jun
 * @date: 12:22 2017/12/13
 * @ver: 1.0
 * @desc:
 */
@RestController
public class I18NController {
	@Autowired private ResourceBundleMessageSource source;
	@RequestMapping("/i18n/{lang}")
	public String international(@PathVariable("lang") String lang){
		Locale l = new Locale(lang);
		return source.getMessage("msg", null, l);
	}
}
