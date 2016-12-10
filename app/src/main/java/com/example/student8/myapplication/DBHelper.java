package com.example.student8.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper{
    // имя базы данных
    public static final String DATABASE_NAME = "spdatabase.db";
    // версия базы данных
    public static final int DATABASE_VERSION = 1;
    // имя таблицы
    public static final String DATABASE_TABLE = "uroki";
    // названия столбцов
    public static final String LESSON_COLUMN = "lesson";
    public static final String THEME_COLUMN = "theme";
    public static final String TEXT_COLUMN = "text1";

    Context context;

    private DBHelper mDBH = new DBHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    private SQLiteDatabase db = mDBH.getWritableDatabase();

    String lesson, theme, text;

    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + LESSON_COLUMN
            + " text not null, " + THEME_COLUMN + " text not null, " + TEXT_COLUMN
            + " text not null);";

    DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        lesson = "Русский язык";
        theme = "Деепричастие";
        text = context.getApplicationContext().getString(R.string.Deeprichastie);
        enter();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);
        // Удаляем старую таблицу
        db.execSQL("DROP TABLE " + DATABASE_TABLE);
        // Создаём новую таблицу
        onCreate(db);
    }

    public void enter(){
        // Создайте новую строку со значениями для вставки.
        ContentValues newValues = new ContentValues();
        // Задайте значения для каждой строки.
        newValues.put(LESSON_COLUMN, lesson);
        newValues.put(THEME_COLUMN, theme);
        newValues.put(TEXT_COLUMN, text);
        // Вставьте строку в вашу базу данных.
        db.insert(DATABASE_TABLE, null, newValues);
    }
}
