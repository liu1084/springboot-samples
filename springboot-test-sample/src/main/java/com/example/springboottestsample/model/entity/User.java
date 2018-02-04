package com.example.springboottestsample.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private Date createTime;

}
