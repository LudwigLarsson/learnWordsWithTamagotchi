package com.ludwiglarsson.learnwordswithtamagotchi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHandler extends SQLiteOpenHelper {

    public DataBaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + Util.TABLE_NAME + " ("
                + Util.KEY_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY_NAME + " TEXT, "
                + Util.KEY_DESCRIPTION + " TEXT, "
                + Util.KEY_HINTS + " TEXT, "
                + Util.KEY_USAGE + " INTEGER " + " );";

        sqLiteDatabase.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME + ";");
        onCreate(sqLiteDatabase);
    }

    public void addWord(Words word) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_NAME, word.getName());
        contentValues.put(Util.KEY_DESCRIPTION, word.getDescription());
        contentValues.put(Util.KEY_HINTS, word.getHints());
        contentValues.put(Util.KEY_USAGE, 0);

        db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
    }

    public Words getWord(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_DESCRIPTION, Util.KEY_HINTS, Util.KEY_USAGE},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        while (cursor != null && cursor.moveToNext()) {
            Words words = new Words(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
            cursor.close();
            return words;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public ArrayList<Words> getAllWords() {

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Words> wordList = new ArrayList<>();
        String selectAllProd = "Select * from " + Util.TABLE_NAME + ";";
        Cursor cursor = db.rawQuery(selectAllProd, null);
        if (cursor.moveToFirst()) {

            do {
                Words words = new Words();
                words.setId(cursor.getInt(0));
                words.setName(cursor.getString(1));
                words.setDescription(cursor.getString(2));
                words.setHints(cursor.getString(3));
                words.setUsage(cursor.getInt(4));
                wordList.add(words);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return wordList;
    }

    public int updateUsage(Words word, long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_NAME, word.getName());
        contentValues.put(Util.KEY_DESCRIPTION, word.getDescription());
        contentValues.put(Util.KEY_HINTS, word.getHints());
        contentValues.put(Util.KEY_USAGE, 1);
        return db.update(Util.TABLE_NAME, contentValues, Util.KEY_ID + "=?", new String[]{String.valueOf(id)});
    }
}