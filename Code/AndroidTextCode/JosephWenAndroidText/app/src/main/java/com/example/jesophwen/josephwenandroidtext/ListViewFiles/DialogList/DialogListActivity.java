package com.example.jesophwen.josephwenandroidtext.ListViewFiles.DialogList;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.BaseActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

import java.util.ArrayList;
import java.util.List;

public class DialogListActivity extends BaseActivity {
    static EditText messageEditText;  // 发送消息输入框
    static List<Message> datas = new ArrayList<Message>();  // 数据源
    static boolean isSended;  // 是否是发送出来的消息
    static ListView listView;  // 列表视图
    DialogListAdapter adapter;  // 列表适配器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_list);
        TitleLayout title = (TitleLayout)findViewById(R.id.dialog_list_title);
        title.titleTextView.setText("DialogList");

        /** 初始化 */
        isSended = false;
        messageEditText = (EditText)findViewById(R.id.message_edit_text);
        /** 初始化列表视图 */
        listView = (ListView)findViewById(R.id.dialog_list_view);
        /** 实例化消息输入框 */
        initDatas();
        /** 实例化表格视图适配器 */
        adapter = new DialogListAdapter(DialogListActivity.this, R.layout.dialog_list_item, datas);
        listView.setAdapter(adapter);

    }
    /** 初始化Message模型列表 */
    private static void initDatas () {
        if (datas.size() == 0) {
            Message message1 = new Message("Hello!", Message.TYPE_SEND);
            Message message2 = new Message("Hello! ", Message.TYPE_RECIVED);
            Message message3 = new Message("I am Jack! Who are you ?", Message.TYPE_SEND);

            datas.add(message1);
            datas.add(message2);
            datas.add(message3);

        }
    }
    /** 发送按钮点击事件 */
    public void sendButtonAction(View v) {
        String content = messageEditText.getText().toString();
        if (!content.equals("")) {
            Message message;
            if (isSended) {
                isSended = false;
                message = new Message(content, Message.TYPE_SEND);
            }else  {
                isSended = true;
                message = new Message(content, Message.TYPE_RECIVED);
            }
            datas.add(message);
            /** 数据改变的时候刷新列表 */
            adapter.notifyDataSetChanged();
            /** 列表选择最后一列 */
            listView.setSelection(datas.size());
            /** 清空输入框 */
            messageEditText.setText("");

        }
    }
}
