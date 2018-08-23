package com.example.javaserializesamples;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Jim
 * Date: 2018/8/23:下午3:14
 * Description: Female类没有实现序列号，但是由于其父类已经实现序列化，所以也可以正常
 */

@Getter
@Setter
public class Female extends Person {
    private static final long serialVersionUID = 1L;
    private int boyFriends;
}
