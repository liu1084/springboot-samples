package com.example.springbootreadymlsample.controller;

import com.example.springbootreadymlsample.model.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private IUserService userService;

    @GetMapping("/email")
    public String getEmail(){
        return userService.getMyEmail();
    }

    @GetMapping("/blog")
    public String getBlog(){
        return userService.getMyBlog();
    }


    @GetMapping("/email2")
    public String getEmail2(){
        return userService.getMyEmail();
    }

    @GetMapping("/blog2")
    public String getBlog2(){
        return userService.getMyBlog();
    }
}
