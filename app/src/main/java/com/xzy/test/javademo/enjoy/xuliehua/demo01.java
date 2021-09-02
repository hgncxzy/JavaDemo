package com.xzy.test.javademo.enjoy.xuliehua;

import java.io.Serializable;

/**
 * serialVersionUID的理解:
 *当某个已经序列化的对象持久化到磁盘
 *如果该对象后来有修改，比如添加新的字段，
 * 那个从之前持久化的对象中读取，则不会有问题。
 * 反之，如果某个对象没有进行序列化，那么执行以上步骤会有问题。报错：
 * InvalidClassException
 * @author xzy
 */
public class demo01 {

    static class User implements Serializable {
        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String name;
        public int age;

        public String nickName;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", nickName=" + nickName +
                    '}';
        }
    }

    static class User1 implements Serializable{

        private static final long serialVersionUID = 2;

        public User1(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String name;
        public int age;
        public String nickName;

        @Override
        public String toString() {
            return "User1{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", nickName=" + nickName +
                    '}';
        }
    }

    public static String basePath = System.getProperty("user.dir") +"\\";
    public static String tmp = "D:\\xuliehuaTest\\";

    public static void main(String[] args) {
        System.out.println("BasePath= " + basePath);
//        NoSerialIdTest();
        HasSerialIdTest();
    }

    private static void NoSerialIdTest(){
        User user = new User("zero",18);
//        SerializeableUtils.saveObject(user,tmp+"a.out");
//        System.out.println("1: " + user);
        user = SerializeableUtils.readObject(tmp+"a.out");
        System.out.println("反序列化： 2: " + user);
    }

    private static void HasSerialIdTest(){
        User1 user = new User1("zero",18);
//        SerializeableUtils.saveObject(user,tmp+"b.out");
//        System.out.println("1: " + user);
        user = SerializeableUtils.readObject(tmp+"b.out");
        System.out.println("2: " + user);
    }
}