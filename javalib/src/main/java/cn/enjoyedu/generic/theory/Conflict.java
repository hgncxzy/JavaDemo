package cn.enjoyedu.generic.theory;

import java.util.List;

/**
 * @author xzy
 */
public class Conflict {

    public static String method(List<String> stringList){
        System.out.println("List");
        return "OK";
    }

//    public static Integer method(List<Integer> stringList){
//        System.out.println("List");
//        return 1;
//    }

    /*
    * Signature (弱记忆)
    *
    * ? super xxxx
    *
    * */

}
