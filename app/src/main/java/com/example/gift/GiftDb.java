package com.example.gift;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class GiftDb extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "information.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE = " CREATE TABLE " + DbContract.giftCon.TABLE_NAME + "(" + DbContract.giftCon.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + DbContract.giftCon.NAME + " TEXT," +
            DbContract.giftCon.FAM_NAME + " TEXT,"+ DbContract.giftCon.CITY + " TEXT," + DbContract.giftCon.PRESENTS + " TEXT);";
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS " + DbContract.giftCon.TABLE_NAME;

    public GiftDb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
   public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("sha","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        Log.d("sha","Table Droped");

    }

    public void addContacts(String name, String family,String city,String presents, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContract.giftCon.NAME, name);
        contentValues.put(DbContract.giftCon.FAM_NAME, family);
        contentValues.put(DbContract.giftCon.CITY,city);
        contentValues.put(DbContract.giftCon.PRESENTS,presents);
        database.insert(DbContract.giftCon.TABLE_NAME, null, contentValues);
    }

    public void updateContacts(int id,String name, String family,String city,String presents, SQLiteDatabase database)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContract.giftCon.ID,id);
        contentValues.put(DbContract.giftCon.NAME, name);
        contentValues.put(DbContract.giftCon.FAM_NAME, family);
        contentValues.put(DbContract.giftCon.CITY,city);
        contentValues.put(DbContract.giftCon.PRESENTS,presents);
        String selection = DbContract.giftCon.ID + "=" + id;
        database.update(DbContract.giftCon.TABLE_NAME, contentValues, selection, null);
    }
    public void deleteContacts(int  id, SQLiteDatabase database) {
        String selection = DbContract.giftCon.ID + "=" + id;
        database.delete(DbContract.giftCon.TABLE_NAME, selection, null);
    }
    public Cursor readContacts(SQLiteDatabase database) {
        String[] projection = {DbContract.giftCon.ID, DbContract.giftCon.NAME, DbContract.giftCon.FAM_NAME,DbContract.giftCon.CITY, DbContract.giftCon.PRESENTS};
        Cursor cursor = database.query(DbContract.giftCon.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }
}
