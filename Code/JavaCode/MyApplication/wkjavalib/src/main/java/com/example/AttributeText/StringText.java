package com.example.AttributeText;

import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Created by wenkui on 16/9/9.
 * 字符串练习
 */
public class StringText {
    public static void main(String[] args) {
        String string = "absoslutely";
        /** 获取字符串内指定字符的位置  方法: indexOf()  只能返回第一个出现字符的位置 */
        System.out.println("字符串's'的位置:" + string.indexOf('s'));
        /** 获取字符串长度  方法:length() */
        System.out.println("字符串absolutely的长度:" + string.length());
        /** 去除字符串内的前导,尾部空格  方法: trim() */
        String string1 = "   Java  Class    ";
        System.out.println(string1);
        String string2 = string1.trim();
        System.out.println(string2);
        /** 去除字符串内的所有空格 方法一: StringTokenizer(String str(从此字符串去除目标字符), String delim(要去除的字符)) */
        /** 使用空格来分割字符串 */
        StringTokenizer stringToken = new StringTokenizer(string1, " ");
        /** 定义字符串缓存对象 */
        StringBuffer buffer = new StringBuffer();
        /** 判断字符串是否还存在空格 */
        while (stringToken.hasMoreTokens()) {
            /** 向字符串缓存器中添加字符 */
            buffer.append(stringToken.nextToken());
            
        }
        /** 输出修改后的字符 */
        System.out.println(buffer.toString());
        /** 方法二 :replaceAll(String str(要替换的字符串), String regex(用来替换的字符串))  */
        String string4 = string1.replaceAll(" ", "");
        /** 输出修改后的字符 */
        System.out.println(string4);

        /** 字体大小写类型转换 */
        /** 转为大写 */
        String upperStirng = string.toUpperCase();
        System.out.println("转换为大写字符:" + upperStirng);
        /** 转为小写 */
        String lowerString = upperStirng.toLowerCase();
        System.out.println("转换为小写字符:" + lowerString);

        /** 字符串分割 */
        String splitString = "abc,bcd,def,gjh hre sdo fhe ahd ";
        String[] splits = splitString.split(",| ");
        System.out.println("splits的长度:" + splits.length);
        System.out.println("分割后的字符数组:");
        for (int i = 0; i < splits.length; i++) {
            System.out.println(splits[i]);
        }

        /** 转换日期格式 */
        logOutDateFormatter();

        /** 对比追加子字符串的方法性能比 */
        appendStringDiff();

    }

    /** 转换日期格式 */static void logOutDateFormatter() {
        Date date = new Date();
        String a = String.format(Locale.US, "%tb", date);
        String b = String.format(Locale.US, "%tB", date);
        String c = String.format("%ta", date);
        String d = String.format("%tA", date);
        String e = String.format("%tY", date);
        String f = String.format("%ty", date);
        String g = String.format("%tm", date);
        String h = String.format("%td", date);
        String i = String.format("%te", date);
        System.out.println("格式化后的字符串为月份的英文缩写:" + a);
        System.out.println("月格式化后的字符串为月份的全文:" + b);
        System.out.println("格式化后的字符串为星期:" + c);
        System.out.println("格式化后的字符串为星期:" + d);
        System.out.println("格式化后的字符串为4位的年份:" + e);
        System.out.println("格式化后的字符串为2位的年份:" + f);
        System.out.println("格式化后的字符串为2位的月份:" + g);
        System.out.println("格式化后的字符串为2位的日期:" + h);
        System.out.println("格式化后的字符串为1位的日期:" + i);

    }

    /** 对比追加子字符串的方法性能比 */
    static void appendStringDiff() {
        /** 使用加号 */
        String string = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            string = string + i;
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("使用+号追加字符串所消耗的时间" + time);
        /** 使用StringBuilder */
        StringBuilder builder = new StringBuilder("");
        long startTime1 = System.currentTimeMillis();
        for (int j = 0; j < 10000; j++) {
            builder.append(j);
        }
        String changeString = builder.toString();
        long endTime1 = System.currentTimeMillis();
        long time1 = endTime1 - startTime1;
        System.out.println("使用StringBuilder号追加字符串所消耗的时间" + time1);


    }


}
