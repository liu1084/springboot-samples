package com.example.javaproxysamples.proxy.statics;

/**
 * Author: Jim
 * Date: 2018/8/21:下午5:17
 * Description: 静态代理
 * 特点：
 * 1. 代理类和被代理类需要实现相同的接口，或者继承相同的父类;
 * 2. 优点：可以在不修改目标对象功能的前提下，对目标进行扩展；简单，容易理解和实现；
 * 3. 缺点：因为代理对象和目标对象需要实现相同的接口，所以会有很多代理类；
 * 同时，一旦增减方法，目标对象与代理对象需要同时维护；
 * 用法：被代理类需要作为代理类的内部对象
 */

public class UserDAOProxy implements IUserDAO {
    private IUserDAO target;

    public UserDAOProxy(IUserDAO target){
        this.target = target;
    }
    @Override
    public void save() {
        System.out.println("-- translation started --");
        target.save();
        System.out.println("-- translation end --");
    }
}
