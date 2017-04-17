package com.example.student8.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBScan extends SQLiteOpenHelper{
    // имя базы данных
    public static final String DATABASE_NAME = "spscan.db";
    // версия базы данных
    public static final int DATABASE_VERSION = 1;
    // имя таблицы
    public static final String DATABASE_TABLE = "scan";
    // названия столбцов
    public static final String FLAG_COLUMN = "flag";

    private final Context context;

    Enter enter;
    Download dl;
    static SQLiteDatabase db;

    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + FLAG_COLUMN + " integer not null);";


    public DBScan(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        enter = new Enter(context);
        dl = new Download(context/*, this.db*/);
    }

    public DBScan(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
        enter = new Enter(context);
        dl = new Download(context/*, this.db*/);
    }

    public DBScan(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.context = context;
        enter = new Enter(context);
        dl = new Download(context/*, this.db*/);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        //dl.database(db);
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
}

