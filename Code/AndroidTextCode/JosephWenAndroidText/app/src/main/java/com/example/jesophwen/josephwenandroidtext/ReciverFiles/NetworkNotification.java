package com.example.jesophwen.josephwenandroidtext.ReciverFiles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by wenkui on 16/9/27.
 */

public class NetworkNotification {

    private IntentFilter intentFilter;  // 创建意图过滤器
    private NetworkStateReciver reciver;    // 创建广播接收器

    public NetworkNotification(Context context) {
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        reciver = new NetworkStateReciver();
        context.registerReceiver(reciver, intentFilter);

        Toast.makeText(context, " Add NetworkStateReciver!", Toast.LENGTH_SHORT).show();

    }


    public void destoryReciver(Context context) {
        context.unregisterReceiver(reciver);
    }

    class NetworkStateReciver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Network Changed!", Toast.LENGTH_SHORT).show();
            Log.d("NetworkStateReciver", "Network Changed!");
        }
    }

}
