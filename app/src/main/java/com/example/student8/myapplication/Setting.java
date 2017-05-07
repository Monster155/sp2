package com.example.student8.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Setting extends Activity {

    Button btn, btn2;
    private DBHelper mDBH;
    private DBClass mDBC;
    private SQLiteDatabase db, dbC;
    Download dl;
    Context context;
    Enter enter;
    TextView tv;
    int classes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btn = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        tv = (TextView) findViewById(R.id.textView);

        mDBH = new DBHelper(this, "spdatabase.db", null, 1);
        db = mDBH.getWritableDatabase();

        mDBC = new DBClass(this, "spclass.db", null, 1);
        dbC = mDBC.getWritableDatabase();

        String query = "SELECT * FROM " + DBClass.DATABASE_TABLE;
        Cursor cursor = dbC.rawQuery(query, null);
        while (cursor.moveToNext()) {
            classes = cursor.getInt(cursor.getColumnIndex(DBClass.CLASS_COLUMN));
        }
        tv.setText("Cейчас выбран класс №" + classes);
        cursor.close();

       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Setting.this);
                builder.setTitle("Вы точно хотите вернуть таблицу к начальному виду?")
                        .setNegativeButton("Нет",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                }
                        )
                        .setPositiveButton("Да",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        db.delete("uroki", null, null);
                                        enter = new Enter(context);
                                        enter.enter(1);
                                        dl = new Download(context);
                                        dl.download();                                    }
                                }
                        );
                AlertDialog alert = builder.create();
                alert.show();
            }
        });*/

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Setting.this);
                builder.setTitle("Выберети класс")
                        .setItems(R.array.classes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position of the selected item
                                which++;
                                tv.setText("Cейчас выбран класс №" + which);
                                dbC.delete("class", null, null);
                                // Создайте новую строку со значениями для вставки.
                                ContentValues newValues = new ContentValues();
                                // Задайте значения для каждой строки.
                                newValues.put("class", which);
                                // Вставьте строку в вашу базу данных.
                                dbC.insert("class", null, newValues);
                                which--;
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}

