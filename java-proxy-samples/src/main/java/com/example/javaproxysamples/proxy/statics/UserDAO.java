package com.example.javaproxysamples.proxy.statics;

/**
 * Author: Jim
 * Date: 2018/8/21:下午5:16
 * Description:
 */

public class UserDAO implements IUserDAO {
    @Override
    public void save() {
        System.out.println("--saved--");
    }
}
