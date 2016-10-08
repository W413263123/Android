package com.example.AttributeText;

import java.util.Scanner;

/**
 * Created by wenkui on 16/9/9.
 * 条件语句
 */
public class Volume {
    public static void main(String[] args) {
        /** 输入函数 */
        Scanner scaner = new Scanner(System.in);
        /** 控制台输出提醒输入年份 */
        System.out.println("请输入当前的年份:");
        /** 获取输入的数值 */
        int year = scaner.nextInt();
        /** 根据输入的年份进行判断,是否是闰年 */
        if (year%4 == 0 && year % 100 != 0 || year %400 == 0 ) {
            System.out.println(year + "年是闰年!");
        }else {
            System.out.println(year + "年不是闰年!");
        }
    }
}


