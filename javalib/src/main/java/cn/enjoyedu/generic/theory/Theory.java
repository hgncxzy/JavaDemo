package cn.enjoyedu.generic.theory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xzy
 */
public class Theory {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("mark","18");
        System.out.println(map.get("mark"));
    }
}
