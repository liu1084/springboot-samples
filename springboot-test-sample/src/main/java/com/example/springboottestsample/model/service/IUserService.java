package com.example.springboottestsample.model.service;

import com.example.springboottestsample.model.entity.User;

public interface IUserService {
    User findOne(Long id);
}
