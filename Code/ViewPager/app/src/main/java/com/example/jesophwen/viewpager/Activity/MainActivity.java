package com.example.jesophwen.viewpager.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.jesophwen.viewpager.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** 隐藏标题栏 */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    /**
     * 按钮点击事件
     */
    public void buttonClickAction(View v) {
        switch (v.getId()) {
            /** 跳转到轮播Banner Activity */
            case R.id.main_button1: {

                break;
            }
            case R.id.main_button2: {

                break;
            }
            case R.id.main_button3: {

                break;
            }
            case R.id.main_button4: {

                break;
            }
            case R.id.main_button5: {

                break;
            }
            case R.id.main_button6: {

                break;
            }
            case R.id.main_button7: {

                break;
            }
            case R.id.main_button8: {

                break;
            }
            default:
                break;
        }
    }
}
