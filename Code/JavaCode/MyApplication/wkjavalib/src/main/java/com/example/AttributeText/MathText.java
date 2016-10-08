package com.example.AttributeText;

/**
 * Created by wenkui on 16/9/9.
 * 基本运算
 */
public class MathText {
    /** 公共方法 */
    public void mathematicalOne() {
        /** 声明一个变量 必须用实例才能调用 */
        int a = 21;
        /** 对变量进行位运算 */
        a = a<<4;
        /** 输出运算后的变量 */
        System.out.println(a);
    }


    /** 静态方法(私有) 可以直接进行调用 */
    static void mathematicalTwo() {
        int a = 12;
        int b = 13;
        int c = a > b ? a : b;
        System.out.println(c);
    }

    public static void main(String[] args) {
        /** 创建出class实例 */
        MathText text = new MathText();
        /** 调用实例的方法 */
        text.mathematicalOne();
        /** 调用内部静态方法 */
        mathematicalTwo();
    }



}
