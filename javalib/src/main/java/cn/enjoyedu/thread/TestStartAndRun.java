package cn.enjoyedu.thread;

/**
 * https://www.cnblogs.com/zhaosq/p/10564698.html
 */
public class TestStartAndRun {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });
        // thread.start(); // hello world
        thread.run(); // world hello
        System.out.println("hello");
    }


    private static void test() {
        System.out.println("world");
    }
}
