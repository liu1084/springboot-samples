package com.jim.redis.template.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private String id;
    private String username;
}
