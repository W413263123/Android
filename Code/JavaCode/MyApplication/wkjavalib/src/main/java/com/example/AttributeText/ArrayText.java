package com.example.AttributeText;

/**
 * Created by wenkui on 16/9/9.
 * 数组练习
 */
public class ArrayText {

    public static void main(String[] args) {
        /** 创建并输出一维数组 */
        arrayTextOne();
        /** 创建并输出一维数组最大值 */
        arrarTextTwo();
        /** 创建并输出二维数组和 */
        arrayTextThree();
    }

    /** 创建并输出一维数组 */
    static void arrayTextOne() {
        /** 创建一个int型一维数组 */
        int numberArray[] = {1,2,3,4,5};
        for (int i= 0; i < numberArray.length; i++) {
            System.out.print(numberArray[i]);
        }
        System.out.println("");
    }

    /** 创建并输出一维数组最大值 */
    static void arrarTextTwo() {
        int array[] = {112,121,4454, 4545, 1251};
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println(max);

    }

    /** 创建并输出二维数组和 */
    static void arrayTextThree() {
        int array[][] = {{1,342,234,24,24},{1,342,234,24,24},{1,342,234,24,24}};
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result += array[i][j];
            }
        }

        System.out.println(result);
    }
}
