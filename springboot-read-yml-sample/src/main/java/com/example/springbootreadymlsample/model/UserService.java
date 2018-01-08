package com.example.springbootreadymlsample.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * using @Value read properties file
 */

//@Service
//@PropertySource("classpath:env/${spring.profiles.active}.properties")
public class UserService implements IUserService {

    @Value("${email}")
    private String email;
    @Value("${blog}")
    private String blog;

    @Override
    public String getMyEmail() {
        return email;
    }

    @Override
    public String getMyBlog() {
        return blog;
    }
}
