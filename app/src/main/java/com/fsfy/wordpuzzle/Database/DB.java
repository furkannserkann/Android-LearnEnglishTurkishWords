package com.fsfy.wordpuzzle.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MYDATABASE";//database adı

    private static final String TABLE_NAME = "tableArrays";

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = String.valueOf("CREATE TABLE " + TABLE_NAME + "("
                + ItemArray.Sid + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ItemArray.Sindex + " INTEGER, "
                + ItemArray.Sselect + " INTEGER, "
                + ItemArray.Sname + " TEXT, "
                + ItemArray.SbeginWord + " INTEGER, "
                + ItemArray.SendWord + " INTEGER, "
                + ItemArray.SallWord + " INTEGER" + ")");

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addArray(ItemArray itemArray) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemArray.Sindex, itemArray.getIndex());
        values.put(ItemArray.Sselect, itemArray.isSelect());
        values.put(ItemArray.Sname, itemArray.getName());
        values.put(ItemArray.SbeginWord, itemArray.getBeginWord());
        values.put(ItemArray.SendWord, itemArray.getEndWord());
        values.put(ItemArray.SallWord, itemArray.isAllWord());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<ItemArray> getArray() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<ItemArray> listItemArray = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                ItemArray itemArray = new ItemArray();
                itemArray.setIndex(cursor.getInt(1));
                itemArray.setSelect(cursor.getInt(2));
                itemArray.setName(cursor.getString(3));
                itemArray.setBeginWord(cursor.getInt(4));
                itemArray.setEndWord(cursor.getInt(5));
                itemArray.setAllWord(cursor.getInt(6));

                listItemArray.add(itemArray);
            } while (cursor.moveToNext());
        }
        db.close();

        return listItemArray;
    }

    public void updateArrays(final ItemArray itemArray) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ItemArray.Sselect, itemArray.isSelect());
        values.put(ItemArray.SbeginWord, itemArray.getBeginWord());
        values.put(ItemArray.SendWord, itemArray.getEndWord());
        values.put(ItemArray.SallWord, itemArray.isAllWord());

        // updating row
        db.update(TABLE_NAME, values, ItemArray.Sid + " = ?",
                new String[]{String.valueOf(itemArray.getId())});
    }
}
