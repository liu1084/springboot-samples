package com.jim.annotation.model.sevice.annotation;

import java.lang.annotation.*;

/**
 * @author: liu jun
 * @date: 17:43 2017/12/15
 * @ver: 1.0
 * @desc:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  LogAnnotation {
}
