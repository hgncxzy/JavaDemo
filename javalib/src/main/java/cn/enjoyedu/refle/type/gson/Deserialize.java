package cn.enjoyedu.refle.type.gson;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;

import cn.enjoyedu.refle.type.gson.a.TypeReference;

/**
 * @author xzy
 */
public class Deserialize {

    static class Response<T> implements Serializable {
        T data;
        int code;
        String message;

        @Override
        public String toString() {
            return "Response{" +
                    "data=" + data +
                    ", code=" + code +
                    ", message='" + message + '\'' +
                    '}';
        }

        public Response(T data, int code, String message) {

            this.data = data;
            this.code = code;
            this.message = message;
        }
    }

    static class Data implements Serializable{
        String result;

        public Data(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "result=" + result +
                    '}';
        }
    }

    static class ChildTypeReference {
        Response<Data> t;
    }

    public static void main(String[] args) {
        Response<Data> dataResponse = new Response(new Data("数据"), 1, "成功");

        Gson gson = new Gson();
        String json = gson.toJson(dataResponse);
        System.out.println(json);
        // 测试序列化
        try {
            doSerializable(dataResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //反序列化......

        /*
         *  有花括号： 代表是匿名内部类，创建一个匿名内部类的实例对象
         *  没花括号：创建实例对象
         */
        Type type = new TypeReference<Response<Data>>() {
        }.getType();
        Response<Data> response = gson.fromJson(json, type);
        System.out.println(response.data.getClass());
    }

    private static void doSerializable(Response<Data> response) throws IOException {
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("E:/Response.txt")));
        oo.writeObject(response);
        System.out.println("Response<Data>对象序列化成功！");
        oo.close();

    }

}
