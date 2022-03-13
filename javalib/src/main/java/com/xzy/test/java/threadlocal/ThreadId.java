package com.xzy.test.java.threadlocal;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.cnblogs.com/cjsblog/p/9773079.html
 * */
public class ThreadId {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
//            return nextId.getAndIncrement();
            return 4;
        }
    };

    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {
        threadId.set(5);
        System.out.println("threadId = " + threadId.get());
        for (int i = 0; i < 10; i++) {
            threadId.set(1*10 + 1);
            System.out.println("threadId = " + threadId.get());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadId.set(1);
                    System.out.println("id = " +  threadId.get());
                }
            }).start();
        }
    }
}