package cn.enjoyedu.generic.typelimit;

import java.util.ArrayList;

/**
 * @author xzy
 * 类说明：类型变量的限定-方法上
 */
public class ArrayAlg {
//    public static <T> T min(T a,T b){
//        if(a.comapareTo(b)>0) return a; else return b;
//    }

    public static <T extends ArrayList & Comparable> T min(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }

    static class Test {
    }

    public static void main(String[] args) {
//        ArrayAlg.min(new Test(),new Test());
    }
}
