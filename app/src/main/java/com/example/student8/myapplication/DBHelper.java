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

    SQLiteDatabase db;
    private DBHelper mDBH;

    public String lesson, theme, text;

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
        enter(db);
      /*  theme = "Причастие";
        text = context.getApplicationContext().getString(R.string.Prichastie);
        enter(db);
        theme = "Пунктуация";
        text = context.getApplicationContext().getString(R.string.Pravopisanie_zapyatyh);
        enter(db);*/


        lesson = "Татарский язык";
        theme = "Исем фигыль";
        text = context.getApplicationContext().getString(R.string.Isem_figyl);
        enter(db);
      /*  theme = "Аергыч";
        text = context.getApplicationContext().getString(R.string.Aergych);
        enter(db);
        theme = "Исем";
        text = context.getApplicationContext().getString(R.string.Isem);
        enter(db);*/


        lesson = "Математика";
        theme = "График функции";
        text = context.getApplicationContext().getString(R.string.Grafik_funkcii);
        enter(db);
    /*    theme = "Неравенства";
        text = context.getApplicationContext().getString(R.string.Neravenstva);
        enter(db);
        theme = "Окружность";
        text = context.getApplicationContext().getString(R.string.Okrujnost);
        enter(db);*/

        lesson = "История";
        theme = "Правление Александра 1";
        text = context.getApplicationContext().getString(R.string.Pravlenie_Aleksandra_I);
        enter(db);

        lesson = "Английский язык";
        theme = "Past Simple";
        text = context.getApplicationContext().getString(R.string.Past_Simple);
        enter(db);

        lesson = "Физика";
        theme = "Теплопроводность";
        text = context.getApplicationContext().getString(R.string.Teploprovodnost);
        enter(db);

        lesson = "Химия";
        theme = "Окислители";
        text = context.getApplicationContext().getString(R.string.Okisliteli);
        enter(db);

        lesson = "Информатика";
        theme = "Способы ввода и вывода";
        text = context.getApplicationContext().getString(R.string.Sposoby_vvoda_i_vyvoda);
        enter(db);
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

    public void enter(SQLiteDatabase db){
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

