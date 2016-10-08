package com.example.jesophwen.josephwenandroidtext.ListViewFiles.CustomList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesophwen.josephwenandroidtext.R;

import java.util.List;

/**
 * Created by wenkui on 16/9/20.
 */

public class ColorAdapter extends ArrayAdapter<ColorDescribe> {
    private int resourceId;

    public ColorAdapter(Context context, int textViewResourceId, List<ColorDescribe> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        /** 获取当前模型对象实例 */
        ColorDescribe color = getItem(position);
        /** 获取当前的item的视图对象 */
        View view;
        /** 视图优化辅助类 */
        ViewHelper helper;
        if (converView == null) {
            helper = new ViewHelper();
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            helper.colorImage = (ImageView)view.findViewById(R.id.color_image_view);
            helper.englishName = (TextView)view.findViewById(R.id.color_english_name);
            helper.chineseName =  (TextView)view.findViewById(R.id.color_chinese_name);
            view.setTag(helper);
        }else  {
            view = converView;
            helper = (ViewHelper)view.getTag();
        }
        /** 获取视图控件 */
        helper.colorImage.setImageResource(color.getImageId());
        helper.englishName.setText(color.getEnglishName());
        helper.chineseName.setText(color.getChineseName());

        
        return view;
    }
    // 定义内部类来辅助性能优化
    class ViewHelper {
        ImageView colorImage;
        TextView englishName;
        TextView chineseName;
    }
}
