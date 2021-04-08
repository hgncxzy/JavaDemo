package cn.enjoyedu.refle.type.typeVariable;

import java.io.Serializable;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * TypeVariable
 * 泛型变量, 泛型信息在编译时会被转换为一个特定的类型, 而TypeVariable就是用来反映在JVM编译该泛型前的信息.
 * TypeVariable就是<T>、<C extends Collection>中的变量T、C本身; 它有如下方法:
 * <p>
 * Type[] getBounds(): 获取类型变量的上边界, 若未明确声明上边界则默认为Object
 * D getGenericDeclaration(): 获取声明该类型变量的类型
 * String getName(): 获取在源码中定义时的名字
 * 注意:
 * <p>
 * 类型变量在定义的时候只能使用extends进行(多)边界限定, 不能用super;
 * <p>
 * 为什么边界是一个数组? 因为类型变量可以通过&进行多个上边界限定，因此上边界有多个
 *
 * @param <K>
 * @param <V>
 * @author xzy
 */
public class TestType<K extends Comparable & Serializable, V> {
    K key;
    V value;

    public static void main(String[] args) throws Exception {
        // 获取字段的类型
        Field fk = TestType.class.getDeclaredField("key");
        Field fv = TestType.class.getDeclaredField("value");

        TypeVariable keyType = (TypeVariable) fk.getGenericType();
        TypeVariable valueType = (TypeVariable) fv.getGenericType();
        // getName 方法
        // keyType 的泛型类型名称为 K
        System.out.println(keyType.getName());
        // valueType 的泛型类型名称为 V
        System.out.println(valueType.getName());
        // getGenericDeclaration 方法
        // class cn.enjoyedu.refle.type.typeVariable.TestType
        System.out.println(keyType.getGenericDeclaration());
        // class cn.enjoyedu.refle.type.typeVariable.TestType
        System.out.println(valueType.getGenericDeclaration());
        // getBounds 方法
        // 有两个  // interface java.lang.Comparable  // interface java.io.Serializable
        System.out.println("K 的上界:");
        for (Type type : keyType.getBounds()) {
            System.out.println(type);
        }
        System.out.println("V 的上界:");
        // 没明确声明上界的, 默认上界是 Object
        // class java.lang.Object
        for (Type type : valueType.getBounds()) {
            System.out.println(type);
        }
    }
}
