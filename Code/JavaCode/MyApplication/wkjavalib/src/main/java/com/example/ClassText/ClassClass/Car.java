package com.example.ClassText.Class8a3;

/**
 * Created by wenkui on 16/9/12.
 */
public class Car {
    Shape shape = new Shape() {
        @Override
        public void run() {
            System.out.println("画了一个图");
        }
    };

    public void run() {
        System.out.println("汽车跑起来了");
    }
    public void stop() {
        System.out.println("汽车停下来了");
    }
}
