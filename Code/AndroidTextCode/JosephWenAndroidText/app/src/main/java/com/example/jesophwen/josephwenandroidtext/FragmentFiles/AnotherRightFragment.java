package com.example.jesophwen.josephwenandroidtext.FragmentFiles;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jesophwen.josephwenandroidtext.R;

/**
 * Created by wenkui on 16/9/22.
 */

public class AnotherRightFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceStatr) {
        View view = inflater.inflate(R.layout.another_right_fragment, container, false);
        return view;
    }

}
