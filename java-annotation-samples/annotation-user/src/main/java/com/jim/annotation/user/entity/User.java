package com.jim.annotation.user.entity;
import com.jim.annotation.processor.service.annotation.BuilderProperty;

public class User {
    private String id;
    private int age;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getAge() {
        return age;
    }

    @BuilderProperty
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @BuilderProperty
    public void setName(String name) {
        this.name = name;
    }
}
