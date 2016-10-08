package com.example.jesophwen.josephwenandroidtext.ReciverFiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

public class ReciverActivity extends MainActivity {
    NetworkNotification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciver);
        TitleLayout titleLayout = (TitleLayout)findViewById(R.id.reciver_layout_title);
        titleLayout.titleTextView.setText("广播通知视图");
    }

    /** 按钮点击事件 */
    public void reciverButtonAction(View v) {
        switch (v.getId()) {
             case R.id.network_reciver_button: {
                notification = new NetworkNotification(ReciverActivity.this);
                break;
            }
            case R.id.custom_reciver_button: {
                Intent intent = new Intent("com.example.jesophwen.josephwenandroidtext.CUSTOMRECIVER");
                sendBroadcast(intent);
                break;
            }
            case R.id.local_reciver_button: {

                break;
            }
            default:  break;
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        notification.destoryReciver(ReciverActivity.this);
    }
}
