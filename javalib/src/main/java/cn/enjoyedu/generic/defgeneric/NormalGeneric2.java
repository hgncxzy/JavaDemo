package cn.enjoyedu.generic.defgeneric;

/**
 * @author xzy
 * 类说明：泛型类
 */
public class NormalGeneric2<T, K> {
    private T data;
    private K result;

    public NormalGeneric2() {
    }

    public NormalGeneric2(T data) {
        this();
        this.data = data;
    }

    public NormalGeneric2(T data, K result) {
        this.data = data;
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public K getResult() {
        return result;
    }

    public void setResult(K result) {
        this.result = result;
    }

    public static void main(String[] args) {
        NormalGeneric2<String, Integer> normalGeneric2 = new NormalGeneric2<>();
        normalGeneric2.setData("OK");
        System.out.println(normalGeneric2.getData());
        normalGeneric2.setResult(23);
        System.out.println(normalGeneric2.getResult());

    }
}
