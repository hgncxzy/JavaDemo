package com.xzy.test.java.enjoyclass04.retrofit.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author xzy
 */
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface Field {

    String value();
}
