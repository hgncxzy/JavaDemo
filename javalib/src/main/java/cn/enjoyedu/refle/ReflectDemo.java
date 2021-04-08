package cn.enjoyedu.refle;


/**
 * 使用反射技术实例化一个对象
 * @author xzy
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //实例化对象的标准用法
        Servant servant = new Servant();
        servant.service("Hello");

        Class servantClass = Servant.class;
        Class servantClass2 = servant.getClass();
        Class servantClass3 = Class.forName("cn.enjoyedu.refle.Servant");

        System.out.println(servantClass);
        System.out.println(servantClass2);
        System.out.println(servantClass3);

        Servant servant1 = (Servant) servantClass.newInstance();
        servant1.service("OK");


    }
}
