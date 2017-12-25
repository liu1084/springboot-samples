package com.jim.single.instance;

public enum SingleInstance implements ISingleInstance {
    INSTANCE;

    public static ISingleInstance getInstance(){
        return SingleInstance.INSTANCE;
    }
}
