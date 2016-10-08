package com.example.jesophwen.josephwenandroidtext.FragmentFiles;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jesophwen.josephwenandroidtext.R;

/**
 * Created by wenkui on 16/9/26.
 */

public class NewsDetailFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanveState) {
        view = inflater.inflate(R.layout.news_detail_fragment, container, false);
        return view;
    }

    public void refreash(String newsTitle, String newsContent) {
        TextView newsTitleView = (TextView)view.findViewById(R.id.new_detail_title);
        TextView newsContentView = (TextView)view.findViewById(R.id.new_detail_content);
        newsTitleView.setText(newsTitle);
        newsContentView.setText(newsContent);
    }

}
