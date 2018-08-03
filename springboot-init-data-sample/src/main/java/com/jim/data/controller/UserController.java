package com.jim.data.controller;

import com.jim.data.model.domain.User;
import com.jim.data.model.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Jim
 * Date: 2018/8/3:下午5:24
 * Description:
 */

@RestController
@RequestMapping(value = "/api/")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/")
    @ApiOperation(value = "取得所有用户")
    public List<User> index() {
        return userService.findAll();
    }
}
