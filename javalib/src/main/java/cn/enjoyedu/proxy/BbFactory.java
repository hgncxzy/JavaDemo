package cn.enjoyedu.proxy;

/**
 * @author xzy
 */
public class BbFactory implements WomanToolsFactory {
    @Override
    public void saleWomanTools(float length) {
        System.out.println("按需求定制了一个高度为"+length+"的男model");
    }
}
