package com.example.databaseex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static com.example.databaseex.Grades.GRADE;
import static com.example.databaseex.Grades.QUARTER;
import static com.example.databaseex.Grades.SUBJECT;
import static com.example.databaseex.Grades.TABLE_GRADES;
import static com.example.databaseex.Students.ADDRESS;
import static com.example.databaseex.Students.DADNAME;
import static com.example.databaseex.Students.DADPHONE;
import static com.example.databaseex.Students.HOMEPHONE;
import static com.example.databaseex.Students.KEY_ID;
import static com.example.databaseex.Students.MOMNAME;
import static com.example.databaseex.Students.MOMPHONE;
import static com.example.databaseex.Students.NAME;
import static com.example.databaseex.Students.PHONENUMBER;
import static com.example.databaseex.Students.TABLE_STUDENTS;


public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;


    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate="CREATE TABLE "+TABLE_STUDENTS;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+NAME+" TEXT,";
        strCreate+=" "+ADDRESS+" TEXT";
        strCreate+=" "+PHONENUMBER+" TEXT";
        strCreate+=" "+HOMEPHONE+" TEXT";
        strCreate+=" "+MOMNAME+" TEXT";
        strCreate+=" "+MOMPHONE+" TEXT";
        strCreate+=" "+DADNAME+" TEXT";
        strCreate+=" "+DADPHONE+" TEXT";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_GRADES;
        strCreate+=" ("+Grades.KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+NAME+" TEXT,";
        strCreate+=" "+SUBJECT+" TEXT,";
        strCreate+=" "+GRADE+" INTEGER";
        strCreate+=" "+QUARTER+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete="DROP TABLE IF EXISTS "+TABLE_STUDENTS;
        db.execSQL(strDelete);

        strDelete="DROP TABLE IF EXISTS "+TABLE_GRADES;
        db.execSQL(strDelete);

        onCreate(db);

    }
}
