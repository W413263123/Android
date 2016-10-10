package com.example.jesophwen.coolweather.util;

/**
 * Created by wenkui on 16/10/8.
 */

public interface HttpCallBackListenter {
    void onFinish(String response);
    void onError(Exception e);
}
