package cn.enjoyedu.generic.restrict;

/**
 * @author xzy
 * 类说明：泛型和异常
 */
public class ExceptionRestrict {

    /*泛型类不能extends Exception/Throwable*/
    //private class Problem<T> extends Exception;

    /*不能捕获泛型类对象*/
//    public <T extends Throwable> void doWork(T x){
//        try{
//
//        }catch(T x){
//            //do sth;
//        }
//    }


    public <T extends Throwable> void doWorkSuccess(T x) throws T {
        try {

        } catch (Throwable e) {
            throw x;
        }
    }
}
