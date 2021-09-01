package com.xzy.ui.javalib.classinitialsequence;

/**
 *
 * 参考 Java成员变量初始化顺序：
 *  * https://blog.csdn.net/weixin_38283159/article/details/84454481?utm_medium=distribute.pc_relevant_download.none-task-blog-2~default~BlogCommendFromBaidu~default-1.test_version_3&depth_1-utm_source=distribute.pc_relevant_download.none-task-blog-2~default~BlogCommendFromBaidu~default-1.test_version_
 * 测试实例变量的初始化时机
 * <p>
 * 结论：实例变量和非静态代码块声明的顺序就是其执行的顺序。而且都先与构造函数执行初始化。
 */
class InstanceVarInit03 {

    public InstanceVarInit03(int value, String name) {
        this.value = value;
        this.name = name;
    }

    int value = 10;

    {
        value = 100;
        name = "非静态代码块中对实例变量指定初始化";
    }

    String name = "定义实例变量时指定初始化";

    public static void main(String[] args) {
        InstanceVarInit03 obj = new InstanceVarInit03(1000, "构造器中对实例变量指定初始化");
        System.out.println(obj.value);//输出:1000
        System.out.println(obj.name);//输出:"构造器中对实例变量指定初始化"
    }
}
