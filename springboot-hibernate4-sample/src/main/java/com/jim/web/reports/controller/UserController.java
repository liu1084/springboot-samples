package com.jim.web.reports.controller;

import com.jim.web.reports.model.entity.User;
import com.jim.web.reports.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private IUserService userService;
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }
}
