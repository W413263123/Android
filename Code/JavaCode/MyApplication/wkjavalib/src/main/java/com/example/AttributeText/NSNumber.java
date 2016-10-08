package com.example.AttributeText;

/**
 * Created by wenkui on 16/9/9.
 */
public class NSNumber {
    public  static void main(String[] args) {
        float myFloat = 123.123f;
        short myShort = 123;
        byte myByte = 123;
        int myInt = 4234234;
        long myLong = 42342;
        float result = (long) (myFloat + myByte + myShort + myInt + myLong);
        System.out.println("结果为: " + result);

        char c = 'b';
        int i = 'b';
        boolean b = true;

        int a = 1;
        System.out.println(a++);
        System.out.println(++a);

    }
}
