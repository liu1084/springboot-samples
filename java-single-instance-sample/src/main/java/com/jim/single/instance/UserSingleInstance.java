package com.jim.single.instance;

public enum UserSingleInstance implements ISingleInstance {
    INSTANCE;
    String name;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static ISingleInstance getInstance(){
        return UserSingleInstance.INSTANCE;
    }
}
