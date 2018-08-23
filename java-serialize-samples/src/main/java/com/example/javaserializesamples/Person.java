package com.example.javaserializesamples;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Author: Jim
 * Date: 2018/8/23:下午3:04
 * Description: Person类序列化
 *
 */

@Setter
@Getter
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;

    private Address address;
}
