package cn.enjoyedu.generic.defgeneric.genmethod;

/**
 * @author xzy
 */
public class GenericMethod {

    public <T> T genericMethod(T...a){
        return a[a.length/2];
    }

    public void test(int x,int y){
        System.out.println(x+y);
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.test(23,343);
        System.out.println(genericMethod.<String>genericMethod("mark","av","lance"));
        System.out.println(genericMethod.genericMethod(12,34));
    }
}
