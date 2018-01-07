package com.jim.mybatis.model.service;

import com.jim.mybatis.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findUserById(String id);
}
