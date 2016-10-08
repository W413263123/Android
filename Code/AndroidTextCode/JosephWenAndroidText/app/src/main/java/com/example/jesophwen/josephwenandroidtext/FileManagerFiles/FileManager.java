package com.example.jesophwen.josephwenandroidtext.FileManagerFiles;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by wenkui on 16/9/28.
 */

public class FileManager {

    /** 储存内容到文件中的方法 */
    public static boolean saveStringToFile(String string, String fileName, Context context) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(string);
            return true;
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }catch (IOException e)  {
                e.printStackTrace();
            }
        }

    }

    /** 从文件中读取数据 */
    public static String readerStringToFile(String fileName, Context context) {
        FileInputStream input = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            input = context.openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(input));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content.toString();
    }

}
