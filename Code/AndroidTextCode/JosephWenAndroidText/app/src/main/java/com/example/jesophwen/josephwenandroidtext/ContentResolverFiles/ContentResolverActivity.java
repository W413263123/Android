package com.example.jesophwen.josephwenandroidtext.ContentResolverFiles;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

import java.util.ArrayList;
import java.util.List;

public class ContentResolverActivity extends MainActivity {

    ListView contentListView;
    ArrayAdapter<String> adapter;
    List<String> contentList = new ArrayList<String>();

    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_resolver);

        int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.READ_CONTACTS);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.READ_CONTACTS},
                    REQUEST_CODE_ASK_PERMISSIONS);
            return;
        }


        TitleLayout layout = (TitleLayout)findViewById(R.id.content_title_layout);
        layout.titleTextView.setText("内容读取器");
        initContentList();
        contentListView = (ListView)findViewById(R.id.content_list);
        adapter = new ArrayAdapter<String>(ContentResolverActivity.this, android.R.layout.simple_list_item_1, contentList);
        contentListView.setAdapter(adapter);

    }

    /** 获取联系人信息 */
    public void initContentList() {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (cursor.moveToNext()) {
                String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String displayNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contentList.add(displayName + "\n" + displayNumber);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }
}
