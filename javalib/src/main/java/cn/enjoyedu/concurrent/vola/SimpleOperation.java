package cn.enjoyedu.concurrent.vola;

/**
 * @author xzy
 * <p>
 * 类说明：简单的程序会有线程安全问题吗？会有安全问题
 */
public class SimpleOperation {
    /**
     * 计数器
     */
    private volatile long count = 0;

    /**
     * count进行累加
     */
    public synchronized void incCount() {
        //count++;
        count = count + 1;
    }

    /**
     * 进行累加的线程
     */
    private static class Count extends Thread {

        private SimpleOperation simplOper;

        public Count(SimpleOperation simplOper) {
            this.simplOper = simplOper;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                simplOper.incCount();//加10000
            }
            //=11000
            System.out.println(Thread.currentThread().getName() + ":" + simplOper.count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleOperation simplOper = new SimpleOperation();
        //启动两个线程
        Count count1 = new Count(simplOper);
        Count count2 = new Count(simplOper);
        count1.start();
        count2.start();
        Thread.sleep(50);
        //=20000?
        System.out.println(Thread.currentThread().getName() + ":" + simplOper.count);
    }

}
