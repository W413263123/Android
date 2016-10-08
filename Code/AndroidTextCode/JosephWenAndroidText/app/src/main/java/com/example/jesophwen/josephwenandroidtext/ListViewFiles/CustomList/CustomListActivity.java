package com.example.jesophwen.josephwenandroidtext.ListViewFiles.CustomList;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.R;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends MainActivity {
    static String[] colorEnglishNames = {"LightPink", "Pink", "Crimson", "LavenderBlush", "PaleVioletRed", "HotPink", "DeepPink", "MediumVioletRed", "Orchid", "Thistle", "Plum", "Violet", "Magenta", "Fuchsia", "DarkMagenta"};
    static String[] colorChinesName = {"浅粉红", "粉红", "猩红", "脸红的淡紫色", "苍白的紫罗兰红色", "热情的粉红", "深粉色", "适中的紫罗兰红色", "兰花的紫色", "蓟", "李子", "紫罗兰", "洋红", "灯笼海棠(紫红色)", "深洋红色"};
    static int[] colorImages = {R.drawable.light_pink, R.drawable.pink, R.drawable.crimson, R.drawable.lavender_blush, R.drawable.pale_violet_red, R.drawable.hot_pink, R.drawable.deep_pink, R.drawable.medium_violet_red, R.drawable.orchid, R.drawable.thistle, R.drawable.plum, R.drawable.violet, R.drawable.magenta, R.drawable.fuchsia, R.drawable.dark_magenta};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        final List<ColorDescribe> colors = new ArrayList<ColorDescribe>();
        for (int i = 0; i < colorEnglishNames.length; i++) {
            ColorDescribe color = new ColorDescribe(colorEnglishNames[i], colorChinesName[i], colorImages[i]);
            colors.add(color);
        }

        /** 获取列表视图对象 */
        ListView listView = (ListView)findViewById(R.id.custom_list_view);
        /** 实例化列表视图适配器 */
        ColorAdapter adapter = new ColorAdapter(CustomListActivity.this, R.layout.color_describe_item, colors);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ColorDescribe color = colors.get(position);
                Toast.makeText(CustomListActivity.this, color.getEnglishName() + ":" +color.getChineseName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
