package com.example.jesophwen.josephwenandroidtext.BaseFiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** 隐藏标题栏 */
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }


}
