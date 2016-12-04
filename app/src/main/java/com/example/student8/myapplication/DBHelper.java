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

    SQLiteDatabase db;
    private DBHelper mDBH;

    HashMap<String, Integer> pas;
    int array;

    String lesson, theme, text;

    Dopolnenie dp = new Dopolnenie();

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
        lesson = "Математика";
        theme = "Синус";

   //     array = R.array.matem;
   //     pas = new HashMap<String, Integer>();
   //     ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, array,
   //             android.R.layout.simple_spinner_item);
   //     String[] choose = getResources().getStringArray(array);
   //     text = pas.get(choose[selectedItemPosition]);
   //     choose();

        // Создайте новую строку со значениями для вставки.
        ContentValues newValues = new ContentValues();
        // Задайте значения для каждой строки.
        newValues.put(LESSON_COLUMN, lesson);
        newValues.put(THEME_COLUMN, theme);
        newValues.put(TEXT_COLUMN, text);
        // Вставьте строку в вашу базу данных.
        db.insert(DATABASE_TABLE, null, newValues);
    }

 /*   public void choose(){
        pas.put("Деепричастие", R.string.Deeprichastie);
        pas.put("Причастие", R.string.Prichastie);
        pas.put("Правописание запятых", R.string.Pravopisanie_zapyatyh);
        pas.put("Исем фигыль", R.string.Isem_figyl);
        pas.put("Аергыч", R.string.Aergych);
        pas.put("Исем", R.string.Isem);
        pas.put("График функции", R.string.Grafik_funkcii);
        pas.put("Неравенства", R.string.Neravenstva);
        pas.put("Окружность", R.string.Okrujnost);
        pas.put("Правление Александра I", R.string.Pravlenie_Aleksandra_I);
        pas.put("1 Мировая Война", R.string.I_Mirovaya_Voina);
        pas.put("Отечественная война 1812 года", R.string.Otechestvennaya_voina_1812_goda);
        pas.put("Past Simple", R.string.Past_Simple);
        pas.put("Modals", R.string.Modals);
        pas.put("Conditionals", R.string.Conditionals);
        pas.put("Теплопроводность", R.string.Teploprovodnost);
        pas.put("Линзы", R.string.Linzy);
        pas.put("Электрический ток", R.string.Elektricheskii_tok);
        pas.put("Окислители", R.string.Okisliteli);
        pas.put("Соли", R.string.Soli);
        pas.put("Оксиды", R.string.Oksidy);
        pas.put("Способы ввода и вывода", R.string.Sposoby_vvoda_i_vyvoda);
        pas.put("Основные понятия", R.string.Osnovnye_ponyatiya);
        pas.put("Виды переменных", R.string.Vidy_peremennyh);
    }*/
}
