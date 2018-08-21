package com.example.javaproxysamples.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

/**
 * Author: Jim
 * Date: 2018/8/21:下午5:43
 * Description: 目标类需要实现接口，但是代理类不需要
 * 优点：代码复用率高
 * 缺点：只能实现接口的的委托类
 * 特点：利用反射进行方法调用
 */

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("-- translation started --");
                    Object result = method.invoke(target, args);
                    System.out.println("-- translation end --");
                    return result;
                }
        );
    }
}
