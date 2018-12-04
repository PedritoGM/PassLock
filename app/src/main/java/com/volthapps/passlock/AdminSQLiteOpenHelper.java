package com.volthapps.passlock;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table passwords(\n" +
                "\tid int primary key autoincrement,\n" +
                "\ttitulo varchar(30),\n" +
                "\tpassword varchar(30),\n" +
                "\tcolor varchar(30),\n" +
                "\timagen varchar(100)\n" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
