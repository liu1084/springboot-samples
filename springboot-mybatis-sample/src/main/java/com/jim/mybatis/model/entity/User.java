package com.jim.mybatis.model.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String email;

    private String username;
    private String password;
    private String salt;
    private String mobileNumber;
    private String position;
}
