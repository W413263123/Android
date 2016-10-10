package com.example.jesophwen.coolweather.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wenkui on 16/10/8.
 * 网络请求辅助类
 */

public class HttpUtil {
    public static void sendHttpRequest(final String address, final HttpCallBackListenter listener) {
        /** 网络请求不能在主线程中进行 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    /** 设置网络请求的URL路径 */
                    URL url = new URL(address);
                    /** 获取网络数据连接对象 */
                    connection = (HttpURLConnection) url.openConnection();
                    /** 设置请求方法 */
                    connection.setRequestMethod("GET");
                    /** 设置请求头 */
                    connection.setRequestProperty("apikey", "3d24c8c152b44b6202e0011a1fa2e199");
                    /** 设置超时时间 */
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.connect();
                    /** 获取返回数据的内容 */
                    /** 获取返回数据的内容 */
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    if (listener != null) {
                        // 回调onFinish()方法
                        String string = "";
                        listener.onFinish(string);
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
}
