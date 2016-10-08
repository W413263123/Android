package com.example.AttributeText;

/**
 * Created by wenkui on 16/9/12.
 */
public class StringEncrypt {
    public static void main(String[] args) {
        String string = "I love you";
        char secret = 'w';

        String encryptString = encryptString(string, secret);
        System.out.println(encryptString);
        String unencryptString = encryptString(encryptString, secret);
        System.out.println(unencryptString);
    }

    /** 加密字符 */
    static String encryptString(String value, char secret) {
        byte[] bt = value.getBytes();
        for (int i = 0; i < bt.length; i++) {
            bt[i] = (byte)(bt[i]^(int)secret);
        }
        return new String(bt, 0, bt.length);
    }
}
