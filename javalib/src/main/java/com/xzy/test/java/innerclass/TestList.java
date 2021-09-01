package com.xzy.ui.javalib.innerclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * https://blog.csdn.net/wangpeng047/article/details/7590555?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
 */
public class TestList {

    public static void main(String[] args) {
        TestList testList = new TestList();
        List<Integer> list = new ArrayList<>();

        testList.initList(list);
        testList.print(list);

        // 删除前两个元素
        testList.remove(list, 2);
        testList.print(list);
        // 测试 set
        testList.set(list, 0, 1000);
        testList.print(list);
        // 测试 add
        testList.add(list, -1);
        testList.print(list);

        // 测试 add2
        testList.add2(list, 0, 99);
        testList.print(list);
    }

    void initList(List<Integer> list) {
        for (int i = 0; i < 5; i++) {
            list.add(i + 1);
        }
    }

    /**
     * 测试 set 方法
     *
     * @param list
     * @return
     */
    public void set(List list, int index, int value) {
        list.set(index, value);
    }

    /**
     * 测试 remove 方法
     * 参考 https://blog.csdn.net/qingchunweiliang/article/details/47684455
     *
     * @param list
     * @return
     */
    void remove(List list, int len) {
        // 这种删除方式会改变索引，有问题
        //  list.remove(index);
        //  应该使用迭代器删除元素
        Iterator<Integer> it = list.iterator();
        int count = 0;
        while (it.hasNext()) {
            // 如果你想在循环语句中删除集合中的某个元素，就要用迭代器iterator的remove()方法，
            // 因为它的remove()方法不仅会删除元素，还会维护一个标志，用来记录目前是不是可删除状态，
            // 例如，你不能连续两次调用它的remove()方法，调用之前至少有一次next()方法的调用
            it.next();
            if (count < 2) {
                it.remove();
                count++;
            }
        }
    }

    void add(List list, int a) {
        list.add(a);
    }

    void add2(List list, int index, int value) {
        list.add(index, value);
    }

    void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "  ");
        }
        System.out.println("");
    }
}
