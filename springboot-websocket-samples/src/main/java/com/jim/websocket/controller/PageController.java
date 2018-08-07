package com.jim.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Jim
 * Date: 2018/8/7:下午6:03
 * Description:
 */
@Controller
public class PageController {
    @RequestMapping(value = "/")
    public String test() {
        return "socketTest";
    }
}
