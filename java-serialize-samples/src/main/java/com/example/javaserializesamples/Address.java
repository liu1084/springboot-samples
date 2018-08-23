package com.example.javaserializesamples;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Author: Jim
 * Date: 2018/8/23:下午3:03
 * Description:
 */

@Getter
@Setter
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    private String number;
}
