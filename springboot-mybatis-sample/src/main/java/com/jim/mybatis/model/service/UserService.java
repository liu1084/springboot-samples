package com.jim.mybatis.model.service;

import com.jim.mybatis.model.entity.User;
import com.jim.mybatis.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }
}
