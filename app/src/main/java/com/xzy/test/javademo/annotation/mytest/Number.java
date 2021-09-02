package com.xzy.test.javademo.annotation.mytest;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author ：created by xzy.
 * @date ：2020/12/4
 */
@IntDef(value = {1,100})
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface Number {
}
