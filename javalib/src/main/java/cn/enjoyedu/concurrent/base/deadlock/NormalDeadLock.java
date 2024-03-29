package cn.enjoyedu.concurrent.base.deadlock;

/**
 *@author xzy
 *
 *类说明：演示死锁的产生
 */
public class NormalDeadLock {
    //第一个锁
    private static Object No13 = new Object();
    //第二个锁
    private static Object No14 = new Object();

    //第一个拿锁的方法
    private static void jamesDo() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (No13){
            System.out.println(threadName+" get nO13");
            Thread.sleep(100);
            synchronized (No14){
                System.out.println(threadName+" get nO14");
            }
        }
    }

    //第二个拿锁的方法
    private static void lisonDo() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (No13){
            System.out.println(threadName+" get nO13");
            Thread.sleep(100);
            synchronized (No14){
                System.out.println(threadName+" get nO14");
            }
        }
    }

    //子线程，代表Lance老师
    private static class Lance extends Thread{

        private String name;

        public Lance(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Thread.currentThread().setName(name);
            try {
                jamesDo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //主线程，代表AV老师
        Thread.currentThread().setName("AV");
        Lance lance = new Lance("Lance");
        lance.start();
        lisonDo();
    }

}
