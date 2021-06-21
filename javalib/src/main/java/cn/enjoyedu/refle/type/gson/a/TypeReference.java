package cn.enjoyedu.refle.type.gson.a;



import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author xzy
 */
public class TypeReference<T> {
    Type type;
    T t;

    public TypeReference() {
        //获得泛型类型
        Type genericSuperclass = getClass().getGenericSuperclass();
        System.out.println("genericSuperclass:" + genericSuperclass);
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        System.out.println("parameterizedType:" + parameterizedType);
        //因为类泛型可以定义多个  A<T,E..> 所以是个数组
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        type = actualTypeArguments[0];
        System.out.println("type:" + type);

    }

    static class Test extends TypeReference<String> {

    }

    public static void main(String[] args) {
        /**
         * 测试注意：
         * 如果报错：java.lang.Class cannot be cast to java.lang.reflect.ParameterizedType
         * 原因是：
         * 构造方法写的没错，是泛型用错了，有两种解决方案
         * 1.再写一个子类继承这个类，子类可以没有任何属性和方法，但必须指明泛型类型，然后使用子类创建对象
         * 2.写一个含有Class<T>类型的构造方法，在使用该类创建对象时给出具体类型
         *
         * **/
        new Test();
    }

    public Type getType() {

        return type;
    }
}
