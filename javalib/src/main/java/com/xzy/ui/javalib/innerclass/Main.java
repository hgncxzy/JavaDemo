package com.xzy.ui.javalib.innerclass;

/**
 * 静态内部类和普通内部类。
 * reference https://www.cnblogs.com/daxia/p/7998774.html
 */
public class Main {
    public static void main(String[] args) {
        //静态的内部类
        TestClass.Inner1 inner1 = new TestClass.Inner1();   //和普通的顶层类new的方法一样
        inner1.report();

        //普通内部成员类
        TestClass tc = new TestClass();
        TestClass.Inner2 inner2 = tc.new Inner2();    //注意这里的使用方式
        inner2.report();
    }
}
