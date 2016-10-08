package com.example.AttributeText;

import java.util.Scanner;

/**
 * Created by wenkui on 16/9/9.
 * 循环语句
 */
public class CheckText {
    public static void main(String[] args) {
        /** 判断一个数是偶数还是奇数 */
//        checkTextOne();
        /** 输出一个菱形 */
//        checkTextTwo();
        /** 输出分数阶乘和 */
        checkTextThree();
    }

    /** 判断一个数是偶数还是奇数 */
    static void checkTextOne() {
        /** 创建输入函数 */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数:");
        /** 获取输入的数值 */
        int x = scanner.nextInt();
        if (x %2 == 0) {
            System.out.println(x + "是偶数");
        }else {
            System.out.println(x + "是奇数");
        }
    }

    /** 使用for循环打印一个菱形 */
    static void checkTextTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入菱形的Size");
        int size = scanner.nextInt();
        if (size %2 == 0) {
            size++;
        }
        for (int i = 0; i < size/2 + 1;i ++) {
            for (int j = 0 ; j < size; j ++) {
                if (j == size/2 - i || j == size/2 + i) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        for (int i = size/2 + 1; i < size;i++) {

            for (int j = 0 ; j < size; j++) {
                if (j == i - size/2 || j == size - i + 1) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    /** 输出一个阶乘和 */
    static void checkTextThree() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数:");
        int number = scanner.nextInt();
        float x = 1;
        int y = 1;
        int z = 1;
        float result = 0;
        float result1 = 1;
        while (number >= y) {

            while (y >= z) {
                result1 = result1*1/z;
                z++;
            }
            y++;

            result = result1 + result;

        }
        System.out.println(result);
    }


}

