package com.xzy.ui.javalib.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * https://www.cnblogs.com/pejsidney/p/9269635.html
 *
 * @author ：created by xzy.
 * @date ：2020/12/7
 */
public class Student {
    static final String TAG = "Student~";
    private String name;
    private int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void speak() {
        System.out.println("speak~~~~~~~~~~~");
    }


    public static void main(String[] args) throws NoSuchFieldException {


        Student test = new Student("xzy", 101);
        // 获取私有属性
        Field[] fields = Student.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                System.out.print(fields[i].get(test));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println("--" + fields[i].getName());
        }

        System.out.println("=========================");
        // 获取私有方法
        Method[] methods = Student.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            methods[i].setAccessible(true);
            System.out.println(methods[i].getName());
        }

        System.out.println("=========================");

        // 获取私有方法
        Method[] methods2 = Student.class.getDeclaredMethods();
        for (int i = 0; i < methods2.length; i++) {
            methods2[i].setAccessible(true);
            System.out.println(methods2[i].getName());
        }

        System.out.println("=========================");
        // 调用私有方法
        Method[] methods3 = Student.class.getDeclaredMethods();
        for (int i = 0; i < methods3.length; i++) {
            methods3[i].setAccessible(true);
            try {
                if (methods3[i].getName() == "speak") {
                    methods3[i].invoke(test);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
