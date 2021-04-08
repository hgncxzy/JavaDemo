package cn.enjoyedu.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xzy
 */
public class MarkCompany implements InvocationHandler {

    /**
     * 持有的真实对象
     */
    private Object factory;

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    /**
     * 通过Proxy获得动态代理对象
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), this);
    }

    /**
     * 通过动态代理对象方法进行增强
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        doSthAfter();
        Object result = method.invoke(factory, args);
        doSthBefore();
        return result;
    }

    /**
     * 前置处理器
     */
    private void doSthAfter() {
        System.out.println("精美包装，快递一条龙服务");
    }

    /**
     * 后置处理器
     */
    private void doSthBefore() {
        System.out.println("根据需求，进行市场调研和产品分析");
    }
}
