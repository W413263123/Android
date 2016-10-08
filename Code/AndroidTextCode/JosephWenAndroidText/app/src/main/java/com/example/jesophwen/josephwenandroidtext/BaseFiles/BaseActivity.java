package com.example.jesophwen.josephwenandroidtext.BaseFiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jesophwen.josephwenandroidtext.ContentResolverFiles.ContentResolverActivity;
import com.example.jesophwen.josephwenandroidtext.FileManagerFiles.FileActivity;
import com.example.jesophwen.josephwenandroidtext.FragmentFiles.FragmentActivity;
import com.example.jesophwen.josephwenandroidtext.FragmentFiles.NewsActivity;
import com.example.jesophwen.josephwenandroidtext.LayoutFiles.LayoutActivity;
import com.example.jesophwen.josephwenandroidtext.ListViewFiles.ListViewActivity;
import com.example.jesophwen.josephwenandroidtext.R;
import com.example.jesophwen.josephwenandroidtext.ReciverFiles.ReciverActivity;

public class BaseActivity extends MainActivity {
    static TitleLayout titleLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        titleLayout = (TitleLayout)findViewById(R.id.base_title_layout);
        titleLayout.backButton.setVisibility(View.INVISIBLE);
        titleLayout.titleTextView.setText(R.string.base_activity_title);

    }

    /** 跳转到LayoutActivity */
    public void layoutAvtivityAction(View v) {
        switch (v.getId()) {
            case R.id.layout_button: {
                /** 创建跳转视图适配器 */
                presentActivity(LayoutActivity.class);
                break;
            }
            case R.id.list_view_button: {
                /** 创建跳转视图适配器 */
                presentActivity(ListViewActivity.class);
                break;
            }
            case R.id.fragment_button: {
                /** 创建跳转视图适配器 */
                presentActivity(FragmentActivity.class);
                break;
            }
            case R.id.news_activity_button: {
                /** 创建跳转视图适配器 */
                presentActivity(NewsActivity.class);
                break;
            }
            case R.id.reciver_activity_button: {
                presentActivity(ReciverActivity.class);
                break;
            }
            case R.id.file_activity_button: {
                presentActivity(FileActivity.class);
                break;
            }
            case R.id.content_activity_button: {
                presentActivity(ContentResolverActivity.class);
                break;
            }
            default: break;
        }
    }

    public  void presentActivity(Class<?> cls) {
        /** 创建跳转视图适配器 */
        Intent intent = new Intent(BaseActivity.this, cls);
        startActivity(intent);

    }
}
