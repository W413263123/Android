package com.example.jesophwen.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wenkui on 16/10/8.
 * 数据库建表辅助类
 */

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
    /**
     * 创建Province表的建表语句
     */
    public static final String CREATE_PROVINCE = "create table Province (" + "id integer primary " +
            "key autoincrement, " + "province_name text, " + "province_code text)";
    /**
     * 创建City表的建表语句
     */
    public static final String CREATE_CITY = "create table City (" + "id integer primary key " +
            "autoincrement, " + "city_name text, " + "city_code text, " + "province_id integer)";
    /**
     * 创建County表的建表语句
     */
    public static final String CREATE_COUNTY = "create table County(" + "id integer primary key " +
            "autoincrement," + "county_name text, " + "county_code text, " + "city_id integer)";

    /** 删除表 */
    public static final String DELETE_PROVINCE = "drop table if exists Province";

    /**
     * @param context 上下文
     * @param name  数据库名称
     * @param factory
     * @param version  数据库版本
     */
    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory
            factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /** 创建数据库表 */
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_PROVINCE);

    }
}
