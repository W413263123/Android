package com.example.ClassText.Class9a2;

/**
 * Created by wenkui on 16/9/13.
 */
public class OutherClass {
    private int age;
    private String name;

    InnerClass inner = new InnerClass();
    public  void outf() {
        inner.emailS();
    }

    private class InnerClass {
        private String email;

        private void emailS() {

        }
    }
    /** 创建外部方法,返回内部类实体对象 */
    public InnerClass dot() {
        inner.email = "111111@163.com";
        return inner;
    }

    public static void main(String[] args) {
        OutherClass out = new OutherClass();
        OutherClass.InnerClass inner = out.dot();
        System.out.println(inner.email);
    }
}
