package com.example.ClassText.Class7a2;

/**
 * Created by wenkui on 16/9/12.
 */
public class Text {
    /** 创建入口函数 */
    public static void main(String[] args) {
        Book book = new Book("狼图腾", "姜戎", 28.8);
        System.out.println("这本书的名字:" + book.getTitle());
        System.out.println("这本书的作者:" + book.getAuthor());
        System.out.println("这本书的价格:" + book.getPrice());

    }
}
