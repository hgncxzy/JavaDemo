package com.xzy.ui.javademo.annotation.mytest;


/**
 * @author ：created by xzy.
 * @date ：2020/12/4
 */
public class TestAnnotation1 {
    private void setNumber(@Number int a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        TestAnnotation1 test = new TestAnnotation1();
        // 报错
        // test.setNumber(99);
        test.setNumber(100);
    }
}


