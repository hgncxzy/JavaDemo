package com.xzy.ui.javalib.innerclass;

class TestClass {
    //静态成员类
    static class Inner1{
        void report(){
            System.out.println("This is a static inner class.");
        }
    }

    //普通内部成员类
    class Inner2{
        void report(){
            System.out.println("This is a inner class. (NOT static)");
        }
    }
}
