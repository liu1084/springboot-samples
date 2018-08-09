package com.jim.annotation.getter;
import lombok.Getter;

public class SystemPath {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.home"));
    }
}

@Getter
class Person{

}
