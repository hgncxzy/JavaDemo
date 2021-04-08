package cn.enjoyedu.concurrent.condition;

/**
 * 类说明：测试 Lock 和 Condition 实现等待通知
 * @author xzy
 */
public class TestCond {
    private static ExpressCond express = new ExpressCond(0, ExpressCond.CITY);


    /**
     * 检查里程数变化的线程,不满足条件，线程一直等待
     */
    private static class CheckKm extends Thread {
        @Override
        public void run() {
            express.waitKm();
        }
    }

    /**
     * 检查地点变化的线程,不满足条件，线程一直等待
     */
    private static class CheckSite extends Thread {
        @Override
        public void run() {
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new CheckSite().start();
        }
        for (int i = 0; i < 3; i++) {
            new CheckKm().start();
        }

        Thread.sleep(1000);
        // 快递里程变化
        express.changeKm();
    }
}
