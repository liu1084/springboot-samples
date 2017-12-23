package com.jim.lombok;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jim.liu on 2017/12/16.
 */
@Data
public class Person {
    private final String firstName;
    private final String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private final Date birthday;

    public static void main(String[] args) {
        Employee employee = new Employee()
                .setName("liujun")
                .setEmployed(true);

    }
}

@Slf4j
@Accessors(chain = true)
class Employee implements Serializable {
    @Getter
    @Setter
    @NonNull
    private boolean employed = true;
    @Setter
    @Getter(AccessLevel.PROTECTED)
    private String name;

    public void speak() {
        log.debug("my name is: " + this.getName());
    }
}


