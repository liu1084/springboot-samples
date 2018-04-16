package com.jim.annotation.user.controller;
import com.jim.annotation.user.entity.User;
import com.jim.annotation.user.entity.UserBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/one")
    public User getOne(){
        UserBuilder builder = new UserBuilder();
        builder.setName("better")
                .setAge(10);
        return builder.build();
    }
}
