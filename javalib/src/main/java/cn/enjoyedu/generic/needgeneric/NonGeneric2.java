package cn.enjoyedu.generic.needgeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzy
 */
public class NonGeneric2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("mark");
        list.add("OK");
        //list.add(100);

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            System.out.println("name:" + name);
        }
    }
}
