package com.xzy.ui.javademo.annotation.mytest;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：created by xzy.
 * @date ：2020/12/4
 */
public class TestAnnotation2 {

    /**
     * 用枚举修饰
     */
    private static WeekDay mCurrentDay;
    /**
     * 用注解来修饰
     */
    @WeekDays
    private static int mCurrentIntDay;

    enum WeekDay {
        SUNDAY,
        MONDAY
    }

    private static final int SUNDAY = 0;
    private static final int MONDAY = 1;


    @IntDef({SUNDAY, MONDAY})
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface WeekDays {  //注解

    }

    public static void setCurrentDay(WeekDay currentDay) {
        mCurrentDay = currentDay;
    }

    public static void setCurrentDay(@WeekDays int currentDay) {
        mCurrentIntDay = currentDay;
    }

    public static void main(String... args) {
        setCurrentDay(WeekDay.SUNDAY);
        setCurrentDay(WeekDay.MONDAY);

        setCurrentDay(MONDAY);
        setCurrentDay(SUNDAY);
    }
}
