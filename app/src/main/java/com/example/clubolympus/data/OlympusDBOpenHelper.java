package com.example.clubolympus.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.clubolympus.data.ClubOlympusContract.MemberEntry;


public class OlympusDBOpenHelper extends SQLiteOpenHelper {
    public OlympusDBOpenHelper(Context context) {
        super(context, ClubOlympusContract.DATABASE_NAME, null, ClubOlympusContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_MEMBERS_TABLE = "CREATE TABLE " + MemberEntry.TABLE_NAME + "("
                + MemberEntry._ID + " INTEGER PRIMARY KEY,"
                + MemberEntry.COLUMN_FIRST_NAME + " TEXT,"
                + MemberEntry.COLUMN_LAST_NAME + " TEXT,"
                + MemberEntry.COLUMN_GENDER + " INTEGER NOT NULL,"
                + MemberEntry.COLUMN_SPORT + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_MEMBERS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ClubOlympusContract.DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}
