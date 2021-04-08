package cn.enjoyedu.refle.more;

import java.io.FileNotFoundException;

/**
 * 类加载器相关的反射
 * @author xzy
 */
public class TestClassLoader {
    public static void main(String[] args) {
        try {
            testClassLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** 类加载器相关*/
    public static void testClassLoader() throws ClassNotFoundException,
            FileNotFoundException {
        //1. 获取一个系统的类加载器(可以获取，当前这个类PeflectTest就是它加载的)
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);


        //2. 获取系统类加载器的父类加载器（扩展类加载器，可以获取）.
        classLoader = classLoader.getParent();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);


        //3. 获取扩展类加载器的父类加载器（引导类加载器，不可获取）.
        classLoader = classLoader.getParent();
        // null
        System.out.println(classLoader);


        //4. 测试当前类由哪个类加载器进行加载（系统类加载器）:
        classLoader = Class.forName("cn.enjoyedu.refle.more.ReflectionTest")
                .getClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2 -- 系统的类加载器
        System.out.println(classLoader);


        //5. 测试 JDK 提供的 Object 类由哪个类加载器负责加载（引导类）
        classLoader = Class.forName("java.lang.Object")
                .getClassLoader();
        // null
        System.out.println(classLoader);
    }
}
