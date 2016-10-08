package com.example.ClassText.Class9a3;

/**
 * Created by wenkui on 16/9/13.
 */
public class Fields {
    int age = 10;
    private String name = "Jack";
    static String email = "11111111@163.com";

    public void run() {
        System.out.println("开始跑步!");
    }

    private void stop() {
        System.out.println("停止跑步!");

    }

    public Fields(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Fields fields = new Fields("Tom");
    }

}
