package cn.enjoyedu.generic.theory;

import java.util.ArrayList;

/**
 * @author xzy
 */
public class GenericRaw<T extends ArrayList&Comparable> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void test(){
        //(Comparable)data.compareTo()
    }


    public static void main(String[] args) {

    }
}
