package cn.enjoyedu.refle;


/**
 * @author xzy
 */
public class Servant {

    public boolean service(String message) {
        System.out.println(message+" 我的手法很好，力度适中，让人倍感舒适。");
        return true;
    }

    @Override
    public String toString() {
        return "我是14号";
    }
}
