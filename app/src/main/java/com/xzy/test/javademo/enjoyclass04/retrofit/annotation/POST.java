package com.xzy.test.javademo.enjoyclass04.retrofit.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * @author xzy
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface POST {

    String value() default "";
}