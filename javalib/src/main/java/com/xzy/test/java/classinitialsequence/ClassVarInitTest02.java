package com.xzy.ui.javalib.classinitialsequence;

/**
 *
 * 参考 Java成员变量初始化顺序：
 *  * https://blog.csdn.net/weixin_38283159/article/details/84454481?utm_medium=distribute.pc_relevant_download.none-task-blog-2~default~BlogCommendFromBaidu~default-1.test_version_3&depth_1-utm_source=distribute.pc_relevant_download.none-task-blog-2~default~BlogCommendFromBaidu~default-1.test_version_
 * 测试类变量的初始化时机
 * 类变量：类变量简单来说就是被static修饰的变量，类变量属于类本身
 * 结论：静态变量和静态代码块声明的顺序就是其执行的顺序。
 */
class ClassVarInitTest02 {
    static int value = 10;

    static {
        value = 100;
        name = "静态代码块中对类变量指定初始化";
    }

    static String name = "定义类变量时指定初始化";

    public static void main(String[] args) {
        System.out.println(value);//输出:100
        System.out.println(name);//输出:"定义类变量时指定初始化"
    }
}
