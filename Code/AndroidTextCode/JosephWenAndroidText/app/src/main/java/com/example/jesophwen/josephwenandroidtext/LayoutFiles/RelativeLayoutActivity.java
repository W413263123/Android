package com.example.jesophwen.josephwenandroidtext.LayoutFiles;

import android.os.Bundle;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

public class RelativeLayoutActivity extends MainActivity {

    static TitleLayout titleLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        titleLayout = (TitleLayout)findViewById(R.id.base_title_layout);
        titleLayout.titleTextView.setText(R.string.relative_layout_activity_title);
    }

}
