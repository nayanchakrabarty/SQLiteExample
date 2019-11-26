package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.UsersModel;

public class UsersDb extends DbHelper {
    public UsersDb(Context context) {
        super(context);
    }

    public void insertUser(UsersModel usersModel){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(DbHelper.COL_USERNAME,usersModel.getUsername());
        cv.put(DbHelper.COL_PASSWORD,usersModel.getPassword());

        db.insert(DbHelper.TAB_NAME,null,cv);

        db.close();
    }
}
