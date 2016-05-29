package com.jirayut.snrurun;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JIRAYUT on 17/5/2559.
 */
public class MyManage {
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    public static final String user_table = "userTABLE_pn";
    public static final String column_id = "_id";
    public static final String column_name = "Name";
    public static final String column_surname = "Surname";
    public static final String column_user = "User";
    public static final String column_password = "Password";
    public static final String column_addess = "Addess";
    public static final String column_phone = "Phone";

    public MyManage(Context context) {
        myOpenHelper=new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();




    }   //Constucter

    public long addUser( String strName,
                        String strSurname,
                        String strUser,
                        String strPassword,
                         String strAddess,
                        String strPhone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_name,strName);
        contentValues.put(column_surname,strSurname);
        contentValues.put(column_user,strUser);
        contentValues.put(column_password,strPassword);
        contentValues.put(column_addess,strAddess);
        contentValues.put(column_phone,strPhone);
        return sqLiteDatabase.insert(user_table,null,contentValues);
    }

}
