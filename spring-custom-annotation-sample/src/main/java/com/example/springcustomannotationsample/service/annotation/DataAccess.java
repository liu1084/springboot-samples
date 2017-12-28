package com.example.springcustomannotationsample.service.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface DataAccess {
    Class<?> entity();
}
