/*package com.example.student8.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

 // Created by student8 on 16.01.17.

public class Download {

    Context context;

    Download(Context c){
        this.context = c;
    }
    public void download() {

        Enter enter = new Enter(context);

        int f = enter.getFlag();

        if (f == 0) {


        } else {

        }
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

    lesson = "Русский язык";
    theme = "Деепричастие";
    text = context.getApplicationContext().getString(R.string.Deeprichastie);
    enter(db);
    theme = "Причастие";
    text = context.getApplicationContext().getString(R.string.Prichastie);
    enter(db);
    theme = "Пунктуация";
    text = context.getApplicationContext().getString(R.string.Pravopisanie_zapyatyh);
    enter(db);


    lesson = "Татарский язык";
    theme = "Исем фигыль";
    text = context.getApplicationContext().getString(R.string.Isem_figyl);
    enter(db);
    theme = "Аергыч";
    text = context.getApplicationContext().getString(R.string.Aergych);
    enter(db);
    theme = "Исем";
    text = context.getApplicationContext().getString(R.string.Isem);
    enter(db);


    lesson = "Математика";
    theme = "График функции";
    text = context.getApplicationContext().getString(R.string.Grafik_funkcii);
    enter(db);
    theme = "Неравенства";
    text = context.getApplicationContext().getString(R.string.Neravenstva);
    enter(db);
    theme = "Окружность";
    text = context.getApplicationContext().getString(R.string.Okrujnost);
    enter(db);

    lesson = "История";
    theme = "Правление Александра 1";
    text = context.getApplicationContext().getString(R.string.Pravlenie_Aleksandra_I);
    enter(db);
    theme = "1 Мировая Война";
    text = "1 Мировая Война";
    enter(db);
    theme = "Отечественная война 1812 года";
    text = "Отечественная война 1812 года";
    enter(db);

    lesson = "Английский язык";
    theme = "Past Simple";
    text = context.getApplicationContext().getString(R.string.Past_Simple);
    enter(db);
    theme = "Modals";
    text = "Modals";
    enter(db);
    theme = "Conditionals";
    text = "Conditionals";
    enter(db);

    lesson = "Физика";
    theme = "Теплопроводность";
    text = context.getApplicationContext().getString(R.string.Teploprovodnost);
    enter(db);
    theme = "Линзы";
    text = "Линзы";
    enter(db);
    theme = "Электрический ток";
    text = "Электрический ток";
    enter(db);

    lesson = "Химия";
    theme = "Окислители";
    text = context.getApplicationContext().getString(R.string.Okisliteli);
    enter(db);
    theme = "Соли";
    text = "Соли";
    enter(db);
    theme = "Оксиды";
    text = "Оксиды";
    enter(db);

    lesson = "Информатика";
    theme = "Способы ввода и вывода";
    text = context.getApplicationContext().getString(R.string.Sposoby_vvoda_i_vyvoda);
    enter(db);
    theme = "Основные понятия";
    text = "Основные понятия";
    enter(db);
    theme = "Виды переменных";
    text = "Виды переменных";
    enter(db);


}*/
