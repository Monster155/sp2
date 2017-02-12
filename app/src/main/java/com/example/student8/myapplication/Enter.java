package com.example.student8.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Enter {

    private DBHelper mDBH;
    private SQLiteDatabase db;
    LessonDAO dao;

    Context context;
    public Enter(Context c){
        this.context = c;
    }

    void enter(){

        dao = new LessonDAO(context);
        Lesson l = new Lesson();

        l.setName("Русский язык");
        l.setTheme("Деепричастие");
        l.setText("Деепричастие — самостоятельная часть речи или особая форма глагола в русском языке, обозначающая добавочное действие при основном действии. Эта часть речи соединяет в себе признаки глагола (вид, залог, переходность и возвратность) и наречия (неизменяемость, синтаксическая роль обстоятельства). Отвечает на вопросы: что делая? что сделав?");
        dao.insert(l);

        l.setName("Русский язык");
        l.setTheme("Причастие");
        l.setText("Причастие — особая форма глагола, которая обозначает признак предмета по действию и отвечает на вопросы прилагательного. Обладает свойствами как глагола (образована с помощью его корня), так и имени прилагательного (образована с помощью его окончания). Глагольные признаки причастия — это категория вида, залога, а также особенная предикативная форма времени.");
        dao.insert(l);

        l.setName("Русский язык");
        l.setTheme("Пунктуация");
        l.setText("Пунктуация (лат. punctuatio — от лат. punctum — точка) — система знаков препинания в письменности какого-либо языка, сами правила их постановки в письменной речи, а также раздел грамматики, изучающий эти правила.");
        dao.insert(l);

        l.setName("Татарский язык");
        l.setTheme("Исем фигыль");
        l.setText("Исем фигыль");
        dao.insert(l);

        l.setName("Татарский язык");
        l.setTheme("Аергыч");
        l.setText("Аергыч");
        dao.insert(l);

        l.setName("Татарский язык");
        l.setTheme("Исем");
        l.setText("Исем");
        dao.insert(l);

        l.setName("Математика");
        l.setTheme("График функции");
        l.setText("График функции — это геометрическое место точек плоскости, абсциссы (x) и ординаты (y) которых связаны указанной функцией.");
        dao.insert(l);

        l.setName("Математика");
        l.setTheme("Неравенства");
        l.setText("Неравенства");
        dao.insert(l);

        l.setName("Математика");
        l.setTheme("Окружность");
        l.setText("Окружность");
        dao.insert(l);

        l.setName("История");
        l.setTheme("Правление Александра 1");
        l.setText("Правление Александра 1");
        dao.insert(l);

        l.setName("История");
        l.setTheme("1 Мировая Война");
        l.setText("1 Мировая Война");
        dao.insert(l);

        l.setName("История");
        l.setTheme("Отечественная война 1812 года");
        l.setText("Отечественная война 1812 года");
        dao.insert(l);

        l.setName("Английский язык");
        l.setTheme("Past Simple");
        l.setText("Past Simple");
        dao.insert(l);

        l.setName("Английский язык");
        l.setTheme("Modals");
        l.setText("Modals");
        dao.insert(l);

        l.setName("Английский язык");
        l.setTheme("Conditionals");
        l.setText("Conditionals");
        dao.insert(l);

        l.setName("Физика");
        l.setTheme("Теплопроводность");
        l.setText("Теплопроводность");
        dao.insert(l);

        l.setName("Физика");
        l.setTheme("Линзы");
        l.setText("Линзы");
        dao.insert(l);

        l.setName("Физика");
        l.setTheme("Электрический ток");
        l.setText("Электрический ток");
        dao.insert(l);

        l.setName("Химия");
        l.setTheme("Окислители");
        l.setText("Окислители");
        dao.insert(l);

        l.setName("Химия");
        l.setTheme("Соли");
        l.setText("Соли");
        dao.insert(l);

        l.setName("Химия");
        l.setTheme("Оксиды");
        l.setText("Оксиды");
        dao.insert(l);

        l.setName("Информатика");
        l.setTheme("Способы ввода и вывода");
        l.setText("Ввод-вывод в информатике — взаимодействие между обработчиком информации (например, компьютер) и внешним миром, который может представлять как человек, так и любая другая система обработки информации. Ввод — сигнал или данные, полученные системой, а вывод — сигнал или данные, посланные ею (или из неё). Термин также может использоваться как обозначение (или дополнение к обозначению) определенного действия: «выполнять ввод-вывод» означает выполнение операций ввода или вывода. Устройства ввода-вывода используются человеком (или другой системой) для взаимодействия с компьютером.");
        dao.insert(l);

        l.setName("Информатика");
        l.setTheme("Основные понятия");
        l.setText("Основные понятия");
        dao.insert(l);

        l.setName("Информатика");
        l.setTheme("Виды переменных");
        l.setText("");
        dao.insert(l);

    }
}
