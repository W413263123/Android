package com.example.jesophwen.josephwenandroidtext.FileManagerFiles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by wenkui on 16/9/29.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table book (" + "id integer primary key autoincrement," + "author text," + "price real," + "pages integer," + "name text)";

    public Context myContext;
    public DatabaseHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);

        Toast.makeText(myContext, "Create succeeded", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        onCreate(db);
    }
}
