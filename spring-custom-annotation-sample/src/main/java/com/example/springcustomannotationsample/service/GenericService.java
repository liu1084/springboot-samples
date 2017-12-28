package com.example.springcustomannotationsample.service;

import com.example.springcustomannotationsample.entity.User;
import com.example.springcustomannotationsample.service.annotation.DataAccess;
import org.springframework.stereotype.Service;

@Service
public class GenericService {

    @DataAccess(entity = User.class)
    private GenericDAO<User> dao;
}
