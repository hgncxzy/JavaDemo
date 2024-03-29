package cn.enjoyedu.generic.typelimit;

/**
 * @author xzy
 * 类说明：类型变量的限定-类上
 */
public class ClassBorder<T extends Comparable> {
    private T data;

    public T min(T outter){
        if(this.data.compareTo(outter)>0) {
            return outter;
        } else {
            return this.data;
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        ClassBorder<String> classBorder = new ClassBorder<>();
        classBorder.setData("mark");
        System.out.println(classBorder.min("av"));
    }
}
