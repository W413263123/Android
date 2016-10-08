package com.example.ClassText.InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by wenkui on 16/9/18.
 */
public class FileManagerClass {

    public static void main(String []args) {
        File file = new File("/Users/wenkui/Desktop/text.txt");
        try {
            /** 创建文件输出流 */
            FileOutputStream output = new FileOutputStream(file);
            byte[] outputStirng = "这是我的一个测试".getBytes();
            /** 往文件中写入数据 */
            output.write(outputStirng);
            /** 关闭文件输出流 */
            output.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            /** 创建文件输入流 */
            FileInputStream input = new FileInputStream(file);
            byte[] new_byte = new byte[1024];
            /** 从文件中读取数据 */
            int len = input.read(new_byte);
            System.out.println("文件中的内容是:" + new String(new_byte, 1 , len));
            /** 关闭文件输入流 */
            input.close();

        }catch (Exception e) {
            e.printStackTrace();
        }


    }

}
