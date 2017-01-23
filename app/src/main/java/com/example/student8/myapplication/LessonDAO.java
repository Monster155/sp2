package com.example.student8.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by student8 on 16.01.17.
 */

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
        // Вставьте строку в вашу базу данных.
        db.insert(DBHelper.DATABASE_TABLE, null, newValues);
    }

    public Lesson get(int id){
        Lesson lesson = new Lesson();
        return lesson;
    }

    public void delete(int id){

    }

    public void update(Lesson lesson){

    }


}
