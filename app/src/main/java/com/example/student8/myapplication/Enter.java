package com.example.student8.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by student8 on 16.01.17.
 */

public class Enter {
    int ff;

    Context context;
    public Enter(Context c){
        this.context = c;
    }

    void enter(int f, SQLiteDatabase db){
        // Создайте новую строку со значениями для вставки.
        ContentValues newValues = new ContentValues();
        // Задайте значения для каждой строки.
        newValues.put("flag", f);
        ff = f;
        // Вставьте строку в вашу базу данных.
        db.insert("begin", null, newValues);
    }
    int getFlag(){
        return ff;
    }
}
