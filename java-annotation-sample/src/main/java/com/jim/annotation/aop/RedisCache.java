package com.jim.annotation.aop;

import java.lang.annotation.*;

/**
 * 自定义注解，结合AOP实现redis自动缓存
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@Inherited
public @interface RedisCache {
}
