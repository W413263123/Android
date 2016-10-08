package com.example.jesophwen.josephwenandroidtext.FragmentFiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jesophwen.josephwenandroidtext.R;

import java.util.List;

/**
 * Created by wenkui on 16/9/26.
 */

public class NewsListAdapter extends ArrayAdapter<News> {

    int resourceId;  // listView的item的ID

    public NewsListAdapter(Context context, int resourceID, List<News> objects) {
        super(context, resourceID, objects);
        resourceId = resourceID;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        } else {
            view = convertView;
        }

        TextView newsTitleView = (TextView) view.findViewById(R.id.news_title);

        newsTitleView.setText(news.getNewsTitle());

        return view;
    }
}
