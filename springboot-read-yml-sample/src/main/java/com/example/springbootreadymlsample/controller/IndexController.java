package com.example.springbootreadymlsample.controller;

import com.example.springbootreadymlsample.config.AppProperties;
import com.example.springbootreadymlsample.config.GlobalProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private AppProperties appProperties;
    @Autowired
    private GlobalProperties globalProperties;

    @RequestMapping("/")
    public String index(Model model){
        String ap = appProperties.toString();
        String gp = globalProperties.toString();

        LOGGER.debug("Index {}, {}", ap, gp);
        model.addAttribute("ap", ap);
        model.addAttribute("gp", gp);
        return "index";
    }
}
