package com.example.jesophwen.josephwenandroidtext.ListViewFiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.ListViewFiles.CustomList.CustomListActivity;
import com.example.jesophwen.josephwenandroidtext.ListViewFiles.DialogList.DialogListActivity;
import com.example.jesophwen.josephwenandroidtext.R;

public class ListViewActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        /** 设置标题内容 */
        TitleLayout titleLayout = (TitleLayout)findViewById(R.id.list_view_title);
        titleLayout.titleTextView.setText(R.string.list_view_activity_title);
    }

    /** 界面跳转事件 */
    public void transportActivity(View v) {
        switch (v.getId()) {

            case R.id.array_list_button: {
                Intent intent = new Intent(ListViewActivity.this, ArrayListActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.custom_list_button: {
                Intent intent = new Intent(ListViewActivity.this, CustomListActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.dialog_list_button: {
                Intent intent = new Intent(ListViewActivity.this, DialogListActivity.class);
                startActivity(intent);
                break;
            }
            default: break;
        }
    }
}
