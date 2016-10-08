package com.example.jesophwen.josephwenandroidtext.ReciverFiles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by wenkui on 16/9/27.
 */

public class CustomReciver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Recived an message!", Toast.LENGTH_SHORT).show();
    }
}
