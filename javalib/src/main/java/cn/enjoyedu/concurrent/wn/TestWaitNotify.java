package cn.enjoyedu.concurrent.wn;

/**
 *@author xzy
 *
 *类说明：测试wait/notify/notifyAll
 *
 * wait() 方法：
 * wait 会让当前线程进入等待状态，除非其他线程调用了 notify 或者 notifyAll 方法唤醒它，又或者等待时间到。
 * 另外，当前线程必须持有对象监控器（也就是使用 synchronized 加锁）
 *
 * 必须把 wait 方法写在 synchronized 保护的 while 代码块中，并始终判断执行条件是否满足，如果满足就往下继续执行，
 * 如果不满足就执行 wait 方法，而在执行 wait 方法之前，必须先持有对象的 monitor 锁，也就是通常所说的 synchronized 加锁。
 *
 * 超时时间非法，抛 IllegalArgumentException 异常；不持有对象的 monitor 锁，抛 IllegalMonitorStateException 异常；
 * 在等待期间被其他线程中断，抛出 InterruptedException 异常。
 * notify () 随机唤醒一个等待该对象锁的线程，即使是多个也随机唤醒其中一个（跟线程优先级无关）。
 * notifyAll () 通知所有在等待该竞争资源的线程，谁抢到锁谁拥有执行权（跟线程优先级无关）。
 */
public class TestWaitNotify {
    private static Express express = new Express(0,Express.CITY);

    /**检查里程数变化的线程,不满足条件，线程一直等待*/
    private static class CheckKm extends Thread{
        @Override
        public void run() {
        	express.waitKm();
        }
    }

    /**检查地点变化的线程,不满足条件，线程一直等待*/
    private static class CheckSite extends Thread{
        @Override
        public void run() {
        	express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //三个线程,等待快递到达地点的变化
        for(int i=0;i<3;i++){
            new CheckSite().start();
        }
        //三个线程,等待里程数的变化
        for(int i=0;i<3;i++){
            new CheckKm().start();
        }

        Thread.sleep(1000);
        //快递里程数变化
        express.changeKm();
    }
}
