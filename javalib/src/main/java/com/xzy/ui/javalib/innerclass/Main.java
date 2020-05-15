package com.xzy.ui.javalib.innerclass;

import java.util.ArrayList;
import java.util.List;

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

        // 测试 list
        TestList testList = new TestList();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<5;i++){
            list.add(i+1);
        }
        testList.printList(list);
        testList.testSet(list);
        testList.testAdd(list,99);
        testList.testAdd2(list,999);
        testList.testRemove(list,0);
    }
}
