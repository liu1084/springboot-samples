package com.jim.annotation.controller;
import com.jim.annotation.model.entity.User;
import com.jim.annotation.service.IUserRepository;
import com.jim.annotation.service.IUserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    @Autowired
    private IUserRepositoryImpl userRepository;

    @PostMapping(value = "/getUsersByIds")
    public List<User> getUsersByIds(@RequestBody String [] ids){
        return userRepository.findUserByIds(ids);
    }

    @GetMapping(value = "/init")
    public void initUser(){
        for (int i =0; i < 10; i++){
            User user = new User("user" + i);
            userRepository.saveUser(user);
        }
    }
}
