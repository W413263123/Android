package com.example.jesophwen.josephwenandroidtext.FragmentFiles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

public class NewsDetailActivity extends MainActivity {

    /** 活动启动方法 */
    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra("Title", newsTitle);
        intent.putExtra("Content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        TitleLayout titleLayout = (TitleLayout)findViewById(R.id.news_detail_layout_activity);
        titleLayout.titleTextView.setText(R.string.news_detail_title);
        /** 获取Intent */
        Intent intent = getIntent();
        String newsTitle = intent.getStringExtra("Title").toString();
        String newsContext = intent.getStringExtra("Content").toString();

        NewsDetailFragment detailFragment = (NewsDetailFragment)getFragmentManager().findFragmentById(R.id.news_detail_fragment);
        detailFragment.refreash(newsTitle, newsContext);


    }
}
