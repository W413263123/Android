package com.example.jesophwen.josephwenandroidtext.ThreadFiles;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jesophwen.josephwenandroidtext.R;

public class ThreadActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        /** 线程内部类 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i > 1000000) {
                    i++;
                    Log.d("ThreadActivity", String.valueOf(i));
                }
            }
        }).start();

        /** 子线程更新UI怎么做,在子线程里发送消息,来通知主线程刷新UI */
    }
}
