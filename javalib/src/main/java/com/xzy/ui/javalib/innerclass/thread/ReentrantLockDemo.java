package com.xzy.ui.javalib.innerclass.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: xzy
 * https://blog.csdn.net/zxd8080666/article/details/83214089
 * Date:检验 ReentrantLock 的同步锁机制
 * Description:
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Runnable t1 = new TestThread();
        new Thread(t1, "t1").start();
        new Thread(t1, "t2").start();
    }
}

class TestThread implements Runnable {
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } finally {
            lock.unlock();
        }
    }
}
