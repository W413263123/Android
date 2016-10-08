package com.example.ClassText.ClassException;

/**
 * Created by wenkui on 16/9/18.
 */
public class ClassException {
    public static void main(String []args) {
        try {
            Class.forName("com.ceshi");
            System.out.println("测试成功");

        } catch (ClassNotFoundException e) {
            System.out.println("测试失败");
            e.printStackTrace();
        }
        System.out.println("测试");
    }

}
