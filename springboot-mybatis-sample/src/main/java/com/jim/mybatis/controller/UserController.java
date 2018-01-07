package com.jim.mybatis.controller;

import com.jim.mybatis.model.entity.User;
import com.jim.mybatis.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private IUserService userService;
    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@Valid @PathVariable("id") String id){
        return userService.findUserById(id);
    }
}
