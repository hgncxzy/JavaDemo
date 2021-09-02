package com.xzy.test.java.string;

/**
 * 研究字符串的最大长度问题
 *
 * @author ：created by xzy.
 * @date ：2021/8/10
 */
public class StringMaxLengthTest {

    private String s2;

    public static void main(String[] args) {
        // 正常
        String s1 = randomStr(65534);
        System.out.println(s1);
        System.out.println(s1.length());

        // 正常
        String s2 = randomStr(65536);
        System.out.println(s2);
        System.out.println(s2.length());

        // OOM :Requested array size exceeds VM limit
        String s3 = randomStr(Integer.MAX_VALUE);
        System.out.println(s3);
        System.out.println(s3.length());
    }


    /**
     * generate random string；
     */
    private static String randomStr(int length) {
        char[] ss = new char[length];
        int i = 0;
        while (i < length) {
            int f = (int) (Math.random() * 3 % 3);
            if (f == 0) {
                ss[i] = (char) ('A' + Math.random() * 26);
            } else if (f == 1) {
                ss[i] = (char) ('a' + Math.random() * 26);
            } else {
                ss[i] = (char) ('0' + Math.random() * 10);
            }
            i++;
        }
        return new String(ss);
    }
}
