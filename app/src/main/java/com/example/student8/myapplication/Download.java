package com.example.student8.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Download {

    LessonDAO dao;
    Context context;

    private DBScan mDBS;
    private DBClass mDBC;
    private SQLiteDatabase dbS, dbC;

    Download(Context c){
        this.context = c;
    }



    public void download() {

        mDBS = new DBScan(context, "spscan.db", null, 1);
        dbS = mDBS.getWritableDatabase();

        mDBC = new DBClass(context, "spclass.db", null, 1);
        dbC = mDBC.getWritableDatabase();

        dao = new LessonDAO(context);
        Lesson l = new Lesson();

        Enter enter = new Enter(context);
        int count = 0;

        String query = "SELECT * FROM " + DBScan.DATABASE_TABLE;
        Cursor cursor = dbS.rawQuery(query, null);
        while (cursor.moveToNext()) {
            count = cursor.getInt(cursor.getColumnIndex(DBScan.FLAG_COLUMN));
        }
        cursor.close();

        if (count == 1) {

            l.setName("Русский язык");
            l.setTheme("Деепричастие");
            l.setText("Деепричастие — самостоятельная часть речи или особая форма глагола в русском языке, обозначающая добавочное действие при основном действии. Эта часть речи соединяет в себе признаки глагола (вид, залог, переходность и возвратность) и наречия (неизменяемость, синтаксическая роль обстоятельства). Отвечает на вопросы: что делая? что сделав?");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Русский язык");
            l.setTheme("Причастие");
            l.setText("Причастие — особая форма глагола, которая обозначает признак предмета по действию и отвечает на вопросы прилагательного. Обладает свойствами как глагола (образована с помощью его корня), так и имени прилагательного (образована с помощью его окончания). Глагольные признаки причастия — это категория вида, залога, а также особенная предикативная форма времени.");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Русский язык");
            l.setTheme("Пунктуация");
            l.setText("Пунктуация (лат. punctuatio — от лат. punctum — точка) — система знаков препинания в письменности какого-либо языка, сами правила их постановки в письменной речи, а также раздел грамматики, изучающий эти правила.");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Татарский язык");
            l.setTheme("Исем фигыль");
            l.setText("Исем фигыль");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Татарский язык");
            l.setTheme("Аергыч");
            l.setText("Аергыч");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Татарский язык");
            l.setTheme("Исем");
            l.setText("Исем");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Математика");
            l.setTheme("График функции");
            l.setText("График функции — это геометрическое место точек плоскости, абсциссы (x) и ординаты (y) которых связаны указанной функцией.");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Математика");
            l.setTheme("Неравенства");
            l.setText("Неравенства");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Математика");
            l.setTheme("Окружность");
            l.setText("Окружность");
            l.setClasses(9);
            dao.insert(l);

            l.setName("История");
            l.setTheme("Правление Александра 1");
            l.setText("Правление Александра 1");
            l.setClasses(9);
            dao.insert(l);

            l.setName("История");
            l.setTheme("1 Мировая Война");
            l.setText("1 Мировая Война");
            l.setClasses(9);
            dao.insert(l);

            l.setName("История");
            l.setTheme("Отечественная война 1812 года");
            l.setText("Отечественная война 1812 года");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Английский язык");
            l.setTheme("Past Simple");
            l.setText("Past Simple");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Английский язык");
            l.setTheme("Modals");
            l.setText("Modals");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Английский язык");
            l.setTheme("Conditionals");
            l.setText("Conditionals");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Физика");
            l.setTheme("Теплопроводность");
            l.setText("Теплопроводность");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Физика");
            l.setTheme("Линзы");
            l.setText("Линзы");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Физика");
            l.setTheme("Электрический ток");
            l.setText("Электрический ток");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Химия");
            l.setTheme("Окислители");
            l.setText("Окислители");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Химия");
            l.setTheme("Соли");
            l.setText("Соли");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Химия");
            l.setTheme("Оксиды");
            l.setText("Оксиды");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Информатика");
            l.setTheme("Способы ввода и вывода");
            l.setText("Ввод-вывод в информатике — взаимодействие между обработчиком информации (например, компьютер) и внешним миром, который может представлять как человек, так и любая другая система обработки информации. Ввод — сигнал или данные, полученные системой, а вывод — сигнал или данные, посланные ею (или из неё). Термин также может использоваться как обозначение (или дополнение к обозначению) определенного действия: «выполнять ввод-вывод» означает выполнение операций ввода или вывода. Устройства ввода-вывода используются человеком (или другой системой) для взаимодействия с компьютером.");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Информатика");
            l.setTheme("Основные понятия");
            l.setText("Основные понятия");
            l.setClasses(9);
            dao.insert(l);

            l.setName("Информатика");
            l.setTheme("Виды переменных");
            l.setText("Виды переменных");
            l.setClasses(9);
            dao.insert(l);

            enter.enter(2);


            // Создайте новую строку со значениями для вставки.
            ContentValues newValues = new ContentValues();
            // Задайте значения для каждой строки.
            newValues.put("class", 9);
            // Вставьте строку в вашу базу данных.
            dbC.insert("class", null, newValues);

        } else {
           /* l.setName("Русский язык");
            l.setTheme("Деепричастие");
            l.setText("Косяк");
            dao.insert(l);*/
        }
    }

    //public void database(SQLiteDatabase db){ this.db = db; }

    /*public void enter(SQLiteDatabase db){
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
    enter(db);*/

}


