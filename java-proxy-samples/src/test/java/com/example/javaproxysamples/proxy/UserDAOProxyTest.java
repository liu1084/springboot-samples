package com.example.javaproxysamples.proxy;

import com.example.javaproxysamples.proxy.statics.UserDAO;
import com.example.javaproxysamples.proxy.statics.UserDAOProxy;
import org.junit.Test;

/**
 * Author: Jim
 * Date: 2018/8/21:下午5:19
 * Description: 简单代理类
 */

public class UserDAOProxyTest {

    @Test
    public void testSaveUser(){
        UserDAO target = new UserDAO();
        UserDAOProxy proxy = new UserDAOProxy(target);
        proxy.save();
    }
}
