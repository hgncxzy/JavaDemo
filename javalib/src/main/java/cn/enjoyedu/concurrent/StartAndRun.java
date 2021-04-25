package cn.enjoyedu.concurrent;

import cn.enjoyedu.concurrent.tools.SleepTools;

/**
 * @author xzy
 * <p>
 * 类说明：start和run方法的区别
 *
 * start() 可以启动一个新线程，run() 不能
 *
 * start() 不能被重复调用，run() 可以
 *
 * start() 中的 run 代码可以不执行完就继续执行下面的代码，进行线程切换，而调用 run() 方法必须等待其代码全部执行完才能继续执行下面的代码
 *
 * start() 实现了多线程，run() 没有
 */
public class StartAndRun {
    public static class ThreadRun extends Thread {

        @Override
        public void run() {
            int i = 10;
            while (i > 0) {
                SleepTools.ms(1000);
                System.out.println("I am " + Thread.currentThread().getName()
                        + " and now the i=" + i--);
            }
        }
    }

    private static class User {
        public void us() {
            System.out.println("us method");
        }
    }

    public static void main(String[] args) {
        ThreadRun beCalled = new ThreadRun();
        beCalled.setName("beCalled");
//        beCalled.run();
        beCalled.start();
        new User().us();

    }
}
