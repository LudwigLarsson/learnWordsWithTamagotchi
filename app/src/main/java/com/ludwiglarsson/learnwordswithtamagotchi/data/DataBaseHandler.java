package com.ludwiglarsson.learnwordswithtamagotchi.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Util;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Words;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataBaseHandler extends SQLiteOpenHelper {

    public DataBaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_WORDS_TABLE = "CREATE TABLE " + Util.TABLE_NAME + " ("
                + Util.KEY_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY_NAME + " TEXT, "
                + Util.KEY_DESCRIPTION + " TEXT, "
                + Util.KEY_HINTS + " TEXT, "
                + Util.KEY_PHOTO + " TEXT " + " );";

        sqLiteDatabase.execSQL(CREATE_WORDS_TABLE);

        String CREATE_PLANTS_TABLE = "CREATE TABLE " + Util.TABLE1_NAME + " ("
                + Util.KEY1_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY1_NAME + " TEXT, "
                + Util.KEY1_DESCRIPTION + " TEXT, "
                + Util.KEY1_HINTS + " TEXT, "
                + Util.KEY1_PHOTO + " TEXT " + " );";

        sqLiteDatabase.execSQL(CREATE_PLANTS_TABLE);

        String CREATE_ANIMALS_TABLE = "CREATE TABLE " + Util.TABLE2_NAME + " ("
                + Util.KEY2_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY2_NAME + " TEXT, "
                + Util.KEY2_DESCRIPTION + " TEXT, "
                + Util.KEY2_HINTS + " TEXT, "
                + Util.KEY2_PHOTO + " TEXT " + " );";

        sqLiteDatabase.execSQL(CREATE_ANIMALS_TABLE);

        String CREATE_SPACE_TABLE = "CREATE TABLE " + Util.TABLE3_NAME + " ("
                + Util.KEY3_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY3_NAME + " TEXT, "
                + Util.KEY3_DESCRIPTION + " TEXT, "
                + Util.KEY3_HINTS + " TEXT, "
                + Util.KEY3_PHOTO + " TEXT " + " );";

        sqLiteDatabase.execSQL(CREATE_SPACE_TABLE);

        String CREATE_ARCHITECTURE_TABLE = "CREATE TABLE " + Util.TABLE4_NAME + " ("
                + Util.KEY4_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY4_NAME + " TEXT, "
                + Util.KEY4_DESCRIPTION + " TEXT, "
                + Util.KEY4_HINTS + " TEXT, "
                + Util.KEY4_PHOTO + " TEXT " + " );";

        sqLiteDatabase.execSQL(CREATE_ARCHITECTURE_TABLE);

        String CREATE_PROFESSIONS_TABLE = "CREATE TABLE " + Util.TABLE5_NAME + " ("
                + Util.KEY5_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY5_NAME + " TEXT, "
                + Util.KEY5_DESCRIPTION + " TEXT, "
                + Util.KEY5_HINTS + " TEXT, "
                + Util.KEY5_PHOTO + " TEXT " + " );";

        sqLiteDatabase.execSQL(CREATE_PROFESSIONS_TABLE);

        String CREATE_INVENTIONS_TABLE = "CREATE TABLE " + Util.TABLE6_NAME + " ("
                + Util.KEY6_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY6_NAME + " TEXT, "
                + Util.KEY6_DESCRIPTION + " TEXT, "
                + Util.KEY6_HINTS + " TEXT, "
                + Util.KEY6_PHOTO + " TEXT " + " );";

        sqLiteDatabase.execSQL(CREATE_INVENTIONS_TABLE);

        String CREATE_USED_TABLE = "CREATE TABLE " + Util.TABLE7_NAME + " ("
                + Util.KEY7_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY7_NAME + " TEXT, "
                + Util.KEY7_DESCRIPTION + " TEXT, "
                + Util.KEY7_HINTS + " TEXT, "
                + Util.KEY7_PHOTO + " TEXT " + " );";

        sqLiteDatabase.execSQL(CREATE_USED_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME + ";");
        onCreate(sqLiteDatabase);
    }
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, null, null);
        db.delete(Util.TABLE1_NAME, null, null);
        db.delete(Util.TABLE2_NAME, null, null);
        db.delete(Util.TABLE3_NAME, null, null);
        db.delete(Util.TABLE4_NAME, null, null);
        db.delete(Util.TABLE5_NAME, null, null);
        db.delete(Util.TABLE6_NAME, null, null);
        //db.delete(Util.TABLE7_NAME, null, null);
        //db.close();
    }

    public void addWord(Words word, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (tableName) {
            case "words":
                contentValues.put(Util.KEY_NAME, word.getName());
                contentValues.put(Util.KEY_DESCRIPTION, word.getDescription());
                contentValues.put(Util.KEY_HINTS, word.getHints());
                contentValues.put(Util.KEY_PHOTO, word.getPhoto());
                db.insert(Util.TABLE_NAME, null, contentValues);
                break;
            case "plants":
                contentValues.put(Util.KEY1_NAME, word.getName());
                contentValues.put(Util.KEY1_DESCRIPTION, word.getDescription());
                contentValues.put(Util.KEY1_HINTS, word.getHints());
                contentValues.put(Util.KEY1_PHOTO, word.getPhoto());
                db.insert(Util.TABLE1_NAME, null, contentValues);
                break;
            case "animals":
                contentValues.put(Util.KEY2_NAME, word.getName());
                contentValues.put(Util.KEY2_DESCRIPTION, word.getDescription());
                contentValues.put(Util.KEY2_HINTS, word.getHints());
                contentValues.put(Util.KEY2_PHOTO, word.getPhoto());
                db.insert(Util.TABLE2_NAME, null, contentValues);
                break;
            case "space":
                contentValues.put(Util.KEY3_NAME, word.getName());
                contentValues.put(Util.KEY3_DESCRIPTION, word.getDescription());
                contentValues.put(Util.KEY3_HINTS, word.getHints());
                contentValues.put(Util.KEY3_PHOTO, word.getPhoto());
                db.insert(Util.TABLE3_NAME, null, contentValues);
                break;
            case "architecture":
                contentValues.put(Util.KEY4_NAME, word.getName());
                contentValues.put(Util.KEY4_DESCRIPTION, word.getDescription());
                contentValues.put(Util.KEY4_HINTS, word.getHints());
                contentValues.put(Util.KEY4_PHOTO, word.getPhoto());
                db.insert(Util.TABLE4_NAME, null, contentValues);
                break;
            case "professions":
                contentValues.put(Util.KEY5_NAME, word.getName());
                contentValues.put(Util.KEY5_DESCRIPTION, word.getDescription());
                contentValues.put(Util.KEY5_HINTS, word.getHints());
                contentValues.put(Util.KEY5_PHOTO, word.getPhoto());
                db.insert(Util.TABLE5_NAME, null, contentValues);
                break;
            case "inventions":
                contentValues.put(Util.KEY6_NAME, word.getName());
                contentValues.put(Util.KEY6_DESCRIPTION, word.getDescription());
                contentValues.put(Util.KEY6_HINTS, word.getHints());
                contentValues.put(Util.KEY6_PHOTO, word.getPhoto());
                db.insert(Util.TABLE6_NAME, null, contentValues);
                break;
            case "used":
                contentValues.put(Util.KEY7_NAME, word.getName());
                contentValues.put(Util.KEY7_DESCRIPTION, word.getDescription());
                contentValues.put(Util.KEY7_HINTS, word.getHints());
                contentValues.put(Util.KEY7_PHOTO, word.getPhoto());
                db.insert(Util.TABLE7_NAME, null, contentValues);
                break;
        }
        //db.close();
    }

    public Words getWord(int id, String tableName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        switch (tableName) {
            case "words":
                cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_DESCRIPTION, Util.KEY_HINTS, Util.KEY_PHOTO},
                        Util.KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
                break;
            case "plants":
                cursor = db.query(Util.TABLE1_NAME, new String[]{Util.KEY1_ID, Util.KEY1_NAME, Util.KEY1_DESCRIPTION, Util.KEY1_HINTS, Util.KEY1_PHOTO},
                        Util.KEY1_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
                break;
            case "animals": cursor = db.query(Util.TABLE2_NAME, new String[]{Util.KEY2_ID, Util.KEY2_NAME, Util.KEY2_DESCRIPTION, Util.KEY2_HINTS, Util.KEY2_PHOTO},
                    Util.KEY2_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
                break;
            case "space": cursor = db.query(Util.TABLE3_NAME, new String[]{Util.KEY3_ID, Util.KEY3_NAME, Util.KEY3_DESCRIPTION, Util.KEY3_HINTS, Util.KEY3_PHOTO},
                    Util.KEY3_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
                break;
            case "architecture": cursor = db.query(Util.TABLE4_NAME, new String[]{Util.KEY4_ID, Util.KEY4_NAME, Util.KEY4_DESCRIPTION, Util.KEY4_HINTS, Util.KEY4_PHOTO},
                    Util.KEY4_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
                break;
            case "professions": cursor = db.query(Util.TABLE5_NAME, new String[]{Util.KEY5_ID, Util.KEY5_NAME, Util.KEY5_DESCRIPTION, Util.KEY5_HINTS, Util.KEY5_PHOTO},
                    Util.KEY5_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
                break;
            case "inventions": cursor = db.query(Util.TABLE6_NAME, new String[]{Util.KEY6_ID, Util.KEY6_NAME, Util.KEY6_DESCRIPTION, Util.KEY6_HINTS, Util.KEY6_PHOTO},
                    Util.KEY6_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
                break;
            case "used": cursor = db.query(Util.TABLE7_NAME, new String[]{Util.KEY7_ID, Util.KEY7_NAME, Util.KEY7_DESCRIPTION, Util.KEY7_HINTS, Util.KEY7_PHOTO},
                    Util.KEY7_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
                break;
        }
        while (cursor != null && cursor.moveToNext()) {
            Words words = new Words(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            cursor.close();
            return words;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public void deleteWord(int id, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        switch (tableName) {
            case "words":
                db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?", new String[]{String.valueOf(id)});
                break;
            case "plants":
                db.delete(Util.TABLE1_NAME, Util.KEY1_ID + "=?", new String[]{String.valueOf(id)});
                break;
            case "animals":
                db.delete(Util.TABLE2_NAME, Util.KEY2_ID + "=?", new String[]{String.valueOf(id)});
                break;
            case "space":
                db.delete(Util.TABLE3_NAME, Util.KEY3_ID + "=?", new String[]{String.valueOf(id)});
                break;
            case "architecture":
                db.delete(Util.TABLE4_NAME, Util.KEY4_ID + "=?", new String[]{String.valueOf(id)});
                break;
            case "professions":
                db.delete(Util.TABLE5_NAME, Util.KEY5_ID + "=?", new String[]{String.valueOf(id)});
                break;
            case "inventions":
                db.delete(Util.TABLE6_NAME, Util.KEY6_ID + "=?", new String[]{String.valueOf(id)});
                break;
            case "used":
                db.delete(Util.TABLE7_NAME, Util.KEY7_ID + "=?", new String[]{String.valueOf(id)});
                break;
        }
        //db.close();
    }

    public Words getRandomWord(String tableName) {
        SQLiteDatabase db = this.getReadableDatabase();
        long numRows = DatabaseUtils.queryNumEntries(db, tableName);
        int num = Math.toIntExact(numRows);
        Random rand = new Random();
        int randomNum = rand.nextInt(num + 1);
        Words word = getWord(randomNum, tableName);
        if (tableName != "used") {
            deleteWord(randomNum, tableName);
            addWord(word, "used");
        }
        return word;
    }

    public long tableSize(String tableName) {
        SQLiteDatabase db = this.getReadableDatabase();
        long numRows = DatabaseUtils.queryNumEntries(db, tableName);
        return numRows;
    }

    public ArrayList<Words> getAllUsedWords() {

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Words> wordList = new ArrayList<>();
        String selectAllProd = "Select * from " + Util.TABLE7_NAME + ";";
        Cursor cursor = db.rawQuery(selectAllProd, null);
        if (cursor.moveToFirst()) {

            do {
                Words products = new Words();
                products.setId(Integer.parseInt(cursor.getString(0)));
                products.setName(cursor.getString(1));
                products.setDescription(cursor.getString(2));
                products.setPhoto(cursor.getString(4));

                wordList.add(products);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return wordList;
    }
}