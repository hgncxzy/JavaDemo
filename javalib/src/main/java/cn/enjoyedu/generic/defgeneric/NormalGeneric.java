package cn.enjoyedu.generic.defgeneric;

/**
 * @author xzy
 */
public class NormalGeneric<K> {
    private K data;

    public NormalGeneric() {
    }

    public NormalGeneric(K data) {
        this.data = data;
    }

    public K getData() {
        return data;
    }

    public void setData(K data) {
        this.data = data;
    }

    public static void main(String[] args) {
        NormalGeneric<String> normalGeneric = new NormalGeneric<>();
        normalGeneric.setData("OK");
        //normalGeneric.setData(1);
        System.out.println(normalGeneric.getData());
        NormalGeneric normalGeneric1 = new NormalGeneric();
        normalGeneric1.setData(1);
        normalGeneric1.setData("dsf");
        System.out.println(normalGeneric1.getData());
    }
}
