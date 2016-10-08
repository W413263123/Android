package com.example.jesophwen.josephwenandroidtext.ListViewFiles.DialogList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jesophwen.josephwenandroidtext.R;

import java.util.List;

/**
 * Created by wenkui on 16/9/21.
 */

public class DialogListAdapter extends ArrayAdapter<Message> {
    static int resourceId;
    public DialogListAdapter(Context context, int resourceItemId, List<Message> objects) {
        super(context, resourceItemId, objects);

        resourceId = resourceItemId;
    }

    @Override
    public View getView( int position, View converView, ViewGroup group) {
        /** 获取模型对象 */
        Message message = (Message)getItem(position);
        View view;
        /** 视图类型保存 */
        ViewHelpler helper;
        if (converView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            helper = new ViewHelpler();
            helper.recivedLayout = (LinearLayout)view.findViewById(R.id.layout_recive);
            helper.sendLayout = (LinearLayout)view.findViewById(R.id.layout_send);
            helper.recivedText = (TextView)view.findViewById(R.id.dialog_recive_text);
            helper.sendText = (TextView)view.findViewById(R.id.dialog_send_text);
            /** 添helper到View */
            view.setTag(helper);
        }else {
            view = converView;
            helper = (ViewHelpler)view.getTag();

        }
        try {
            if (message.getType() == Message.TYPE_SEND) {
                helper.sendLayout.setVisibility(View.VISIBLE);
                helper.recivedLayout.setVisibility(View.GONE);
                Log.d("DialogListAdapter", message.getContent());
                helper.sendText.setText(message.getContent());
            }else if (message.getType() == Message.TYPE_RECIVED) {
                helper.sendLayout.setVisibility(View.GONE);
                Log.d("DialogListAdapter", message.getContent());
                helper.recivedLayout.setVisibility(View.VISIBLE);
                helper.recivedText.setText(message.getContent());

            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }


    class ViewHelpler {
        LinearLayout recivedLayout;  // 接收消息的布局文件
        LinearLayout sendLayout;  // 发送消息的布局文件
        TextView recivedText;  // 接收消息的文本框
        TextView sendText;  // 发送消息的文本框

    }
}
