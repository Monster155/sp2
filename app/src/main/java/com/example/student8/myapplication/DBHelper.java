package com.example.student8.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{
    // имя базы данных
    private static final String DATABASE_NAME = "spdatabase.db";
    // версия базы данных
    private static final int DATABASE_VERSION = 1;
    // имя таблицы
    private static final String DATABASE_TABLE = "uroki";
    // названия столбцов
    public static final String LESSON_COLUMN = "lesson";
    public static final String THEME_COLUMN = "theme";
    public static final String TEXT_COLUMN = "text1";


    private SQLiteDatabase mSqLiteDatabase;
    private DBHelper mDatabaseHelper;

    Dopolnenie dp = new Dopolnenie();

    String lesson, theme, text;

    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + LESSON_COLUMN
            + " text not null, " + THEME_COLUMN + " text not null, " + TEXT_COLUMN
            + " text not null);";


    DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        //создаем метод для заполнения
        enter();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_TABLE);
        // Создаём новую таблицу
        onCreate(db);
    }

    public void enter(){
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        //заполняем таблицу элеметами
        ContentValues values = new ContentValues();
        // Задайте значения для каждого столбца
        values.put(DBHelper.LESSON_COLUMN, lesson);
        values.put(DBHelper.THEME_COLUMN, theme);
        values.put(DBHelper.TEXT_COLUMN, text);
        // Вставляем данные в таблицу
        mSqLiteDatabase.insert("uroki", null, values);
    }
}
