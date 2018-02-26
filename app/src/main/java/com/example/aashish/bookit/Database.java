package com.example.aashish.bookit;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aashish on 7/7/17.
 */

public class Database extends SQLiteOpenHelper{


    public Database(Context context) {
        super(context, "login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table LOGIN(EMAIL varchar,USERNAME varchar,PASSWORD varchar,PHONE varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists LOGIN");

        onCreate(db);
    }
}
