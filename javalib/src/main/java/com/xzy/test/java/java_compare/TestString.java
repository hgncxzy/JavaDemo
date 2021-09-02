package com.xzy.test.java.java_compare;

/**
 * https://www.cnblogs.com/zhxhdean/archive/2011/03/25/1995431.html
 *
 * @author ：created by xzy.
 * @date ：2021/8/10
 */
class TestString {
    public static void main(String[] args) {

        // 基本数据类型，== 比较的是值，没有equals方法
        int a = 11;
        int b = 11;
        // true
        System.out.println(a == b);
        // 编译错误，语法检查不通过
        // System.out.println(a.equals(b));

        // 复合数据类型（类），如果重写了equals方法，则 == 比较的使对象的引用地址，equals比较的是值
        // 如果没有重写equals，== 和 equals 比较的都是对象的引用地址
        String s1 = "xzy";
        String s2 = "xzy";
        String s3 = new String("xzy");
        // true
        System.out.println(s1 == s2);
        // false
        System.out.println(s1 == s3);
        // true
        System.out.println(s1.equals(s3));
        // true
        System.out.println(s1.equals(s2));

        // 使用字符串缓存池
        s3 = s3.intern();
        // true
        System.out.println(s1 == s3);


    }
}
