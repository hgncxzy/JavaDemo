package cn.enjoyedu.proxy;

/**
 * @author xzy
 */
public class AaFactory implements ManToolsFactory {
    @Override
    public void saleManTools(String size) {
        System.out.println("按需求定制了一个size为"+size+"的女model");
    }
}
