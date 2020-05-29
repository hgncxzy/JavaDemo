package com.xzy.ui.javalib.innerclass.thread;

/**
 * reference: https://blog.csdn.net/zxd8080666/article/details/83214089
 * Date: 验证 synchronized 的同步锁特性
 * Description:
 * @author xzy
 */
public class SyncDemo {

    public static void main(String[] args) {
        Runnable t1 = new MyThread();
        new Thread(t1, "t1").start();
        new Thread(t1, "t2").start();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
