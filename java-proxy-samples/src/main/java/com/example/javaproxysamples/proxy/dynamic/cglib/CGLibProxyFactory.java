package com.example.javaproxysamples.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: Jim
 * Date: 2018/8/21:下午6:17
 * Description: 代理类将委托类作为自己的父类并为其中的非final委托方法创建两个方法，
 * 一个是与委托方法签名相同的方法，它在方法中会通过super调用委托方法；
 * 另一个是代理类独有的方法。在代理方法中，它会判断是否存在实现了MethodInterceptor接口的对象，
 * 若存在则将调用intercept方法对委托方法进行代理
 * 优点：可以在运行时对类和接口进行增强操作，且委托类无需实现接口
 * 缺点：不能对final类和final方法进行代理
 * 特点：底层将方法全部存入一个数组中，通过索引进行方法调用
 */

public class CGLibProxyFactory implements MethodInterceptor {
    private Object target;
    public CGLibProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(target.getClass());
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("-- translation started --");
        Object result = method.invoke(target, objects);
        System.out.println("-- translation end --");
        return result;
    }
}
