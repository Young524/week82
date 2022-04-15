package com.example.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public MyDatabaseHelper(Context context) {
        //创建数据库
        super(context, "book.db", null, 1);
        // TODO Auto-generated constructor stub
        System.out.println("MyDatabaseHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //创建表
        db.execSQL("create table Book (" +
                "id integer primary key autoincrement," +
                "author text," +
                "price real," +
                "pages integer," +
                "name text," +
                "category_id integer )");

        db.execSQL("create table Category (" +
                "id integer primary key autoincrement," +
                "category_name text," +
                "category_code integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}