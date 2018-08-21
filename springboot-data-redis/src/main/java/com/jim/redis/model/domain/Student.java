package com.jim.redis.model.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author 刘军
 * @version ${VERSION}
 * @project springboot-data-redis
 * @create 2018/8/10
 */

@RedisHash
@Data
@Slf4j
public class Student implements Serializable {

    public enum Gender {
        MALE, FEMALE
    }

    private String id;
    private String name;
    private int grade;
    private Gender gender;
}
