package com.example.jesophwen.josephwenandroidtext.ListViewFiles;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

public class ArrayListActivity extends MainActivity {
    static String[] data = {"天地", "乾坤", "雷风", "震巽", "水火", "离坎", "山泽", "艮兑", "无极", "太极", "两仪", "三才", "四象", "五行", "六合", "七星", "八卦", "九宫"};  // 列表视图数据源
    static ListView listView;  // 列表视图
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        /** 设置标题内容 */
        TitleLayout titleLayout = (TitleLayout)findViewById(R.id.array_list_title);
        titleLayout.titleTextView.setText(R.string.array_list_activity_title);

        /** 获取到listView */
        listView = (ListView)findViewById(R.id.array_list_view);
        /** 创建数组适配器 */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ArrayListActivity.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
    }
}
