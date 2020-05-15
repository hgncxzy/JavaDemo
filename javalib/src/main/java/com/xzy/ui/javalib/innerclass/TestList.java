package com.xzy.ui.javalib.innerclass;


import java.util.ArrayList;
import java.util.List;


public class TestList {
    /**
     * 测试 set 方法
     *
     * @param list
     * @return
     */
    public void testSet(List list) {
        list.set(1, 100);
        printList(list);
    }

    /**
     * 测试 remove 方法
     *
     * @param list
     * @return
     */
    public void testRemove(List list, int index) {
        list.remove(index);
        printList(list);
    }

    public void testAdd(List list, int a) {
        list.add(a);
        printList(list);
    }

    public void testAdd2(List list, int a) {
        list.add(0, a);
        printList(list);
    }

    public void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "  ");
        }
        System.out.println("");
    }
}
