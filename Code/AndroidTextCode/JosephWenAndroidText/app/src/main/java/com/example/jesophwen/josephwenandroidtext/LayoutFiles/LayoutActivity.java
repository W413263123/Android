package com.example.jesophwen.josephwenandroidtext.LayoutFiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

public class LayoutActivity extends MainActivity {

    static TitleLayout titleLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        titleLayout = (TitleLayout)findViewById(R.id.base_title_layout);
        titleLayout.titleTextView.setText(R.string.layout_activity_title);
    }
    /** 跳转到相应布局视图 */
    public void trasportActivity(View v) {
        switch (v.getId()) {
            case R.id.linear_layout: {
                Intent intent = new Intent(LayoutActivity.this, LinearLayoutActivity.class);
                startActivity(intent);

            } break;
            case R.id.frame_layout: {
                Intent intent = new Intent(LayoutActivity.this, FrameLayoutActivity.class);
                startActivity(intent);

            } break;
            case R.id.table_layout: {
                Intent intent = new Intent(LayoutActivity.this, TableLayoutActivity.class);
                startActivity(intent);

            } break;
            case R.id.relative_layout: {
                Intent intent = new Intent(LayoutActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);

            } break;
            default: break;

        }
    }

}
