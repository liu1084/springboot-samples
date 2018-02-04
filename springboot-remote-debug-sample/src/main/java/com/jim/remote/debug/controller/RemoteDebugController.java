package com.jim.remote.debug.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteDebugController{


    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}