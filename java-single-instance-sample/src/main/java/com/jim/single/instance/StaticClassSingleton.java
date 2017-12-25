package com.jim.single.instance;

public class StaticClassSingleton {
    private StaticClassSingleton(){}

    public static class SingletonHolder{
        private static final StaticClassSingleton instance = new StaticClassSingleton();
    }

    public static final StaticClassSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
