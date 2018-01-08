package com.example.springbootreadymlsample.model;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:env/${spring.profiles.active}.properties")
@ConfigurationProperties
public class UserService2 implements IUserService {

    private String email;
    private String blog;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override
    public String getMyEmail() {
        return email;
    }

    @Override
    public String getMyBlog() {
        return blog;
    }
}
