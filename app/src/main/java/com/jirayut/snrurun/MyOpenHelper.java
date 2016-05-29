package com.jirayut.snrurun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JIRAYUT on 17/5/2559.
 */
public class MyOpenHelper extends SQLiteOpenHelper{//ทำหน้าที่เก็บข้อมูลและดึงข้อมูล

    //ประกาศตัวแปร
    public static final String database_name = "userTABLE_pn.db";
    private  static  final  int database_version = 1;

    private  static  final  String create_user_table ="create table user(" +
            "_id integer primary key," +
            "Name text," +
            "Surname text," +
            "User text," +
            "Password," +
            "Address text," +
            "Phone);";

    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);


    } //นี่คือ Constuctor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(create_user_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}   //Main Class
