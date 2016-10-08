package com.example.ClassText.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by wenkui on 16/9/18.
 */
public class FileReaderWriter {
    public static void main(String[] args) {
        File file = new File("/Users/Wenkui/Desktop/Java/text1.txt");
        try {
            FileWriter writer = new FileWriter(file);
            String strng = "这是第二个测试";
            writer.write(strng);
            writer.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader reader = new FileReader(file);
            char[] reasultByte = new char[1024];
            int len = reader.read(reasultByte);
            System.out.println("这是测试结果:" + new String(reasultByte, 1, len));
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

