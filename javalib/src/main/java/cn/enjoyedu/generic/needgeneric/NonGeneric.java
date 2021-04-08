package cn.enjoyedu.generic.needgeneric;

/**
 * @author xzy
 */
public class NonGeneric {

    public int addInt(int x,int y){
        return x+y;
    }

    public float addFloat(float x,float y){
        return x+y;
    }

    //double

    public static void main(String[] args) {
        NonGeneric nonGeneric = new NonGeneric();
        System.out.println(nonGeneric.addInt(1,2));
        System.out.println(nonGeneric.addFloat(1f,2f));
    }


}
