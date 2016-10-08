package com.example.jesophwen.josephwenandroidtext.FragmentFiles;

import android.os.Bundle;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

public class NewsActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        TitleLayout titleLayout = (TitleLayout)findViewById(R.id.news_title_layout);
        titleLayout.titleTextView.setText(R.string.news_activity_title);
    }
}
