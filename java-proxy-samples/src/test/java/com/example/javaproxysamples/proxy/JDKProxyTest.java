package com.example.javaproxysamples.proxy;

import com.example.javaproxysamples.proxy.dynamic.jdk.ProxyFactory;
import com.example.javaproxysamples.proxy.statics.IUserDAO;
import com.example.javaproxysamples.proxy.statics.UserDAO;
import org.junit.Test;

/**
 * Author: Jim
 * Date: 2018/8/21:下午5:51
 * Description: JDK提供的动态代理
 * 特点：代理对象不需要实现接口，但是目标对象需要实现接口
 * 用法：使用代理工程类生成目标类的实例，调用目标方法
 */

public class JDKProxyTest {

    @Test
    public void testSaveUser() {
        IUserDAO target = new UserDAO();
        System.out.println(target.getClass().getName());
        IUserDAO proxy = (IUserDAO) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass().getName());
        proxy.save();
    }
}
