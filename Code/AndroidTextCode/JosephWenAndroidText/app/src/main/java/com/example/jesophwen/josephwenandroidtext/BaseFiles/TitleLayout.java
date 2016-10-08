package com.example.jesophwen.josephwenandroidtext.BaseFiles;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesophwen.josephwenandroidtext.R;

/**
 * Created by wenkui on 16/9/20.
 */
public class TitleLayout extends LinearLayout {
    public Button backButton;  // 左边的返回按钮
    public Button editButton;  // 右边的编辑按钮
    public TextView titleTextView;  // 显示标题

    public TitleLayout(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        /** 为属性赋值 */
        backButton = (Button)findViewById(R.id.title_layout_back);
        editButton = (Button)findViewById(R.id.title_layout_edit);
        titleTextView = (TextView)findViewById(R.id.title_layout_title);
        editButton.setVisibility(INVISIBLE);
        /** 添加返回按钮的点击事件 */
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });

        editButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You have clicked edit button!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
