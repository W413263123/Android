package com.example.jesophwen.josephwenandroidtext.FragmentFiles;

import android.os.Bundle;
import android.view.View;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

public class FragmentActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        TitleLayout title = (TitleLayout)findViewById(R.id.fragment_title);
        title.titleTextView.setText("Fragment");
    }

    public void fragmentButtonClick(View v) {
        AnotherRightFragment fragment = new AnotherRightFragment();
        getFragmentManager().beginTransaction().replace(R.id.right_fragment, fragment).addToBackStack(null).commit();
    }
}
