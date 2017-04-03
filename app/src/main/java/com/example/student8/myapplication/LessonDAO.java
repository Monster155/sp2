package com.example.student8.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class LessonDAO {

    private DBHelper mDBH;
    private SQLiteDatabase db;
    Context context;

    public LessonDAO(Context c){
        this.context = c;
    }

    public void insert(Lesson lesson){
        mDBH = new DBHelper(context, "spdatabase.db", null, 1);
        db = mDBH.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        // Задайте значения для каждой строки.
        newValues.put(DBHelper.LESSON_COLUMN, lesson.getName());
        newValues.put(DBHelper.THEME_COLUMN, lesson.getTheme());
        newValues.put(DBHelper.TEXT_COLUMN, lesson.getText());
        newValues.put(DBHelper.CLASS_COLUMN, lesson.getClasses());
        // Вставьте строку в вашу базу данных.
        db.insert(DBHelper.DATABASE_TABLE, null, newValues);
    }
}
