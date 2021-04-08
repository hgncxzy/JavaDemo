package com.xzy.ui.javalib.innerclass;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 静态内部类和普通内部类。
 * reference https://www.cnblogs.com/daxia/p/7998774.html
 *
 * @author xzy
 */
public class Main {
    public static void main(String[] args) {
        // 静态的内部类
        // 和普通的顶层类new的方法一样
        TestClass.Inner1 inner1 = new TestClass.Inner1();
        inner1.report();

        // 普通内部成员类
        TestClass tc = new TestClass();
        // 注意这里的使用方式
        TestClass.Inner2 inner2 = tc.new Inner2();
        inner2.report();

        testVarargs("dicky", "love", "china");
    }

    public static void testVarargs(String a, String... b) {
        System.out.println(a + Arrays.toString(b));
    }

    // 编译不通过
//    public static void testVarargs1(String a,...){
//        System.out.println(a);
//    }

    public static <T extends Comparable & Serializable> T max(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }
}
