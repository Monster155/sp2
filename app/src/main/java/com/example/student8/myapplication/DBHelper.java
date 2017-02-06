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

    private final Context context;

    Enter enter;
    Download dl;
    SQLiteDatabase db;

    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + LESSON_COLUMN
            + " text not null, " + THEME_COLUMN + " text not null, " + TEXT_COLUMN
            + " text not null);";
    private static final String DATABASE_CREATE_FLAG = "CREATE TABLE begin (flag integer);";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        enter = new Enter(context);
        dl = new Download(context, this.db);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
        enter = new Enter(context);
        dl = new Download(context, this.db);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.context = context;
        enter = new Enter(context);
        dl = new Download(context, this.db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        db.execSQL(DATABASE_CREATE_FLAG);
        this.db = db;
        dl.database(db);
        enter.enter(0, db);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);
        // Удаляем старую таблицу
        db.execSQL("DROP TABLE " + DATABASE_TABLE);
        // Удаляем счётчик
        db.execSQL("DROP TABLE begin");
        // Создаём новую таблицу
        onCreate(db);
    }
}

