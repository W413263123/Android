package com.example.ClassText.Class7a2;

/**
 * Created by wenkui on 16/9/12.
 */
public class Book {
    /** 创建私有属性(不可读不可写) */
    private String title;
    private String author;
    private Double price;

    // Book类的构造方法
    public Book(String bookTitle, String bookAuthor, Double bookPrice) {
        title = bookTitle;
        author = bookAuthor;
        price = bookPrice;
    }

    /** 重写属性的get方法让属性变得可读 */
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }



}
