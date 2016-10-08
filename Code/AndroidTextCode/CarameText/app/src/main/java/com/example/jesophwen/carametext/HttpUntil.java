package com.example.jesophwen.carametext;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wenkui on 16/9/30.
 */

public class HttpUntil {


    public HttpUntil() throws IOException {
        URL url = new URL("http://www.baidu.com");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

    }
}


