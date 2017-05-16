package com.danielreimundo.appgym.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by daniel.reimundo on 8/05/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static String nombreBD="appgym.db";
    public static int version=1;

    public DatabaseHelper (Context context){
        super(context,nombreBD,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseManager.crearTabla());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
