package com.xzy.test.java.classinitialsequence;

/**
 *
 * JAVA类初始化顺序总结:https://blog.csdn.net/luoyoub/article/details/82874993
 * 测试类的初始化顺序
 *  结论：类的初始化顺序为：类对象（静态变量）/静态代码块初始化 -->实例变量/非静态代码块初始化-->构造方法初始化
 *       如果有继承关系，先调用父类的构造方法，再调用子类的构造方法。
 *
 *       其中，静态代码/静态代码块的初始化顺序与声明的顺序一致；
 *       其中，实例变量/非静态代码块初始化的顺序与声明的顺序一致；
 *
 */
public class ClassVarInitTest01 {

    ClassA a = new ClassA();
    static ClassB b = new ClassB();

    public ClassVarInitTest01() {
        ClassC c = new ClassC();
    }

    public static void main(String[] args) {
        new ClassVarInitTest01();
        /*
         打印结果：
          init ClassB
          init ClassA
          init ClassD
          init ClassC

          结论：类的初始化顺序为：静态代码块初始化 -->实例变量初始化-->构造方法初始化
          如果有继承关系，先调用父类的构造方法，再调用子类的构造方法
          **/
    }

    class ClassA {
        public ClassA() {
            System.out.println("init ClassA");
        }
    }

    static class ClassB {
        public ClassB() {
            System.out.println("init ClassB");
        }
    }

    class ClassC extends ClassD{
        public ClassC() {
            System.out.println("init ClassC");
        }
    }

    class ClassD{

        public ClassD(){
            System.out.println("init ClassD");
        }
    }
}
