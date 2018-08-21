package com.example.javaproxysamples.proxy;

import com.example.javaproxysamples.proxy.dynamic.cglib.CGLibProxyFactory;
import com.example.javaproxysamples.proxy.statics.UserDAO;
import org.junit.Test;

/**
 * Author: Jim
 * Date: 2018/8/21:下午6:36
 * Description:
 */

public class CGLibTest {

    @Test
    public void testSaveUser(){
        UserDAO userDAO = new UserDAO();
        UserDAO proxy = (UserDAO) new CGLibProxyFactory(userDAO).getProxyInstance();
        proxy.save();
    }
}
