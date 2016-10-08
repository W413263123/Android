package com.example.jesophwen.josephwenandroidtext.FileManagerFiles;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jesophwen.josephwenandroidtext.BaseFiles.MainActivity;
import com.example.jesophwen.josephwenandroidtext.BaseFiles.TitleLayout;
import com.example.jesophwen.josephwenandroidtext.R;

import java.util.HashSet;
import java.util.Set;

public class FileActivity extends MainActivity {
    private static final String FILENAME = "date";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        TitleLayout titleLayout = (TitleLayout)findViewById(R.id.file_activity_title);
        titleLayout.titleTextView.setText(R.string.file_activity_title);

        Button writer = (Button)findViewById(R.id.button_writer_file);
        writer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** 使用SharePreference 储存数据 */
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("Param1", "name");
                editor.putInt("Param2", 1);
                editor.putBoolean("Param3", false);

                Set<String> set = new HashSet<String>();
                set.add("Hello1");
                set.add("Hello2");
                set.add("Hello3");
                set.add("Hello4");
                set.add("Hello5");
                editor.putStringSet("Param4", set);
                editor.commit();
                Toast.makeText(FileActivity.this, "储存成功", Toast.LENGTH_SHORT).show();

                /** 执行储存String到文件中 */
//                if (FileManager.saveStringToFile("Hello Android!", FILENAME, FileActivity.this)) {
//                    Toast.makeText(FileActivity.this, "储存成功", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(FileActivity.this, "储存失败", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        Button reader = (Button)findViewById(R.id.button_reader_file);
        reader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** 执行储存String到文件中 */
//                String readerString = FileManager.readerStringToFile(FILENAME, FileActivity.this);
                String readerString;
                SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                readerString = sharedPreferences.getString("Param1", "");

                Toast.makeText(FileActivity.this, readerString, Toast.LENGTH_SHORT).show();


            }
        });

        final DatabaseHelper dbHelper = new DatabaseHelper(FileActivity.this, "DBHelper.db", null, 1);
        Button sqlite = (Button)findViewById(R.id.button_create_table);
        sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

            }
        });

    }
}
