package com.example.ClassText.Class8a1;

/**
 * Created by wenkui on 16/9/12.
 */
public class ImplitText implements InterfaceText {

    @Override
    public Double add(Double obj1, Double obj2) {
        System.out.println(obj1 + obj2);
        return obj1 + obj2;
    }

    @Override
    public Double subsract(Double obj1, Double obj2) {
        System.out.println(obj1 - obj2);
        return obj1 - obj2;
    }

    @Override
    public Double mutiply(Double obj1, Double obj2) {
        System.out.println(obj1 * obj2);
        return obj1 * obj2;
    }

    @Override
    public Double division(Double obj1, Double obj2) {
        System.out.println(obj1 / obj2);
        return obj1 / obj2;
    }
}

