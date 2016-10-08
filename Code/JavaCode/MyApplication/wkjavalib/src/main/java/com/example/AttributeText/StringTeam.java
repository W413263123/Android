package com.example.AttributeText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wenkui on 16/9/12.
 * 字符串课后任务
 */
public class StringTeam {
    public static void main(String[] args) {
        /** 输出字符串所含的'i'字符个数 */
//        stringHaveCharNumber();

        /** 去除字符串中的所有空格 */
//        deledeTirmAtString();
        /** 输出时间信息 */
        printDataAndTime();
    }


    /** 输出字符串所含的'i'字符个数 */
    static void stringHaveCharNumber() {
        int numbers = 0;
        try {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader buffer = new BufferedReader(input);
            System.out.print("请输入一个含有重复字符的字符串:");
            String string = buffer.readLine();
            for (int i = 0; i < string.toCharArray().length; i++) {
                if (string.toCharArray()[i] == 'i') {
                    numbers += 1;
                }
            }
            System.out.println("这个字符串之中一共有" + numbers + "个i!");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** 去除字符串中的所有空格 */
    static void deledeTirmAtString() {
        try {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(input);
            System.out.print("请输入带空格的字符串:");
            StringBuilder builder = new StringBuilder(reader.readLine());
            for (int i = 0; i < builder.length(); i++) {
                if (builder.charAt(i) == ' ') {
                    builder.deleteCharAt(i);
                    /** 删除当前位置的空格之后从当前位置继续开始检查 */
                    i--;
                }
            }


            System.out.println("删除空格后的字符串:" + builder.toString());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 输出当前时间的所有信息 */
    static void printDataAndTime() {
        Date currentDate = new Date();

        String year = String.format(Locale.CHINA, "%tY", currentDate);
        String mouth = String.format("%tm", currentDate);
        String day = String.format( "%td", currentDate);
        String hour = String.format("%tH", currentDate);
        String minitus = String.format("%tM", currentDate);
        String second = String.format("%tS", currentDate);
        String yearFormater = String.format("%tF", currentDate);
        String timeFormater = String.format("%tT", currentDate);

        System.out.println("当前时间年份:" + year);
        System.out.println("当前时间月份:" + mouth);
        System.out.println("当前时间日期:" + day);
        System.out.println("当前时间小时:" + hour);
        System.out.println("当前时间分钟:" + minitus);
        System.out.println("当前时间秒:" + second);
        System.out.println("当前时间日期格式:" + yearFormater);
        System.out.println("当前时间时间格式:" + timeFormater);


    }
    
    
}
