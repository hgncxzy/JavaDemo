package cn.enjoyedu.concurrent.ch1.threadlocal;

/**
 *类说明：演示ThreadLocal的使用
 */
public class UseThreadLocal {
	
	//TODO

    /**
     * 运行3个线程
     */
    public void StartThreadArray(){
        Thread[] runs = new Thread[3];
        for(int i=0;i<runs.length;i++){
            runs[i]=new Thread(new TestThread(i));
        }
        for(int i=0;i<runs.length;i++){
            runs[i].start();
        }
    }
    
    /**
     *类说明：测试线程，线程的工作是将ThreadLocal变量的值变化，并写回，看看线程之间是否会互相影响
     */
    public static class TestThread implements Runnable{
        int id;
        public TestThread(int id){
            this.id = id;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+":start");
            //TODO

        }
    }

    public static void main(String[] args){
    	UseThreadLocal test = new UseThreadLocal();
        test.StartThreadArray();
    }
}
