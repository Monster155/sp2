package com.example.student8.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Urok extends Activity {

    int b = 1, classes, r;
    String text, urok, theme, text2;
    TextView tv, tv2;
    EditText et, et2;
    private DBHelper mDBH;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.urok);

        text();

        final ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setImageResource(R.drawable.pencil);
        final ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
        ib2.setImageResource(R.drawable.plus);

        mDBH = new DBHelper(this, "spdatabase.db", null, 1);
        db = mDBH.getWritableDatabase();

        et = (EditText) findViewById(R.id.editText);
        et.setTextSize(20);
        et.setVisibility(View.INVISIBLE);

        et2 = (EditText) findViewById(R.id.editText2);
        et2.setTextSize(1);
        et2.setVisibility(View.INVISIBLE);

        tv = (TextView) findViewById(R.id.textView1);
        tv.setTextSize(30);
        tv.setText(urok + "\n"+ classes + " класс");

        tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setTextSize(20);

        String query = "SELECT * FROM " + DBHelper.DATABASE_TABLE + " WHERE lesson='" + urok + "' AND class='" + classes + "' AND theme='" + theme + "';";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            text2 = cursor.getString(cursor.getColumnIndex(DBHelper.TEXT_COLUMN));
            tv2.setText(text2);
        }
        cursor.close();

        b = 1;

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b == 1){
                    b = 2;
                    text = (String) tv2.getText();
                    tv2.setText("");
                    tv2.setTextSize(1);
                    et.setText(text);
                    et.setVisibility(View.VISIBLE);
                    ib.setImageResource(R.drawable.error);
                    ib2.setImageResource(R.drawable.check);
                }
                else {
                    if(b == 2){
                        b = 1;
                        tv2.setText(text);
                        et.setText("");
                        et.setVisibility(View.INVISIBLE);
                        tv2.setTextSize(20);

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(ib2.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                        ib.setImageResource(R.drawable.pencil);
                        ib2.setImageResource(R.drawable.plus);
                    }
                    if(b == 3){
                        b = 1;
                        et2.setText("");
                        et2.setVisibility(View.INVISIBLE);
                        et2.setTextSize(1);

                        et.setText("");
                        et.setVisibility(View.INVISIBLE);

                        tv2.setVisibility(View.VISIBLE);
                        tv2.setTextSize(20);

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(ib2.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                        ib.setImageResource(R.drawable.pencil);
                        ib2.setImageResource(R.drawable.plus);
                    }
                }
            }
        });

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b == 1){
                    b = 3;
                    et2.setText("");
                    et2.setVisibility(View.VISIBLE);
                    et2.setTextSize(20);

                    et.setText("");
                    et.setVisibility(View.VISIBLE);

                    tv2.setVisibility(View.INVISIBLE);
                    tv2.setTextSize(1);

                    ib.setImageResource(R.drawable.error);
                    ib2.setImageResource(R.drawable.check);
                }
                else{
                    if(b == 2){
                        b = 1;
                        text = String.valueOf(et.getText());
                        tv2.setText(text);
                        et.setText("");
                        et.setVisibility(View.INVISIBLE);
                        tv2.setTextSize(20);

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(ib2.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                        // Обновление данных БД
                        ContentValues updateValues = new ContentValues();
                        updateValues.put(mDBH.TEXT_COLUMN, text);
                        db.update(mDBH.DATABASE_TABLE, updateValues, "lesson='" + urok + "' AND theme='" + theme + "';", null);

                        ib.setImageResource(R.drawable.pencil);
                        ib2.setImageResource(R.drawable.plus);
                    }
                    if(b == 3){
                        b = 1;

                        String t1, t2;
                        t1 = String.valueOf(et2.getText());
                        t2 = String.valueOf(et.getText());

                        // Создайте новую строку в БД
                        ContentValues newValues = new ContentValues();
                        newValues.put(mDBH.TEXT_COLUMN, t2);
                        newValues.put(mDBH.THEME_COLUMN, t1);
                        newValues.put(mDBH.LESSON_COLUMN, urok);
                        newValues.put(mDBH.CLASS_COLUMN, classes);
                        db.insert(mDBH.DATABASE_TABLE, null, newValues);

                        et2.setText("");
                        et2.setVisibility(View.INVISIBLE);
                        et2.setTextSize(1);

                        et.setText("");
                        et.setVisibility(View.INVISIBLE);

                        tv2.setVisibility(View.VISIBLE);
                        tv2.setTextSize(20);

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(ib2.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                        ib.setImageResource(R.drawable.pencil);
                        ib2.setImageResource(R.drawable.plus);
                    }
                }
            }
        });
    }

    public void text() {
        r = getIntent().getIntExtra("k", 0);
        theme = getIntent().getStringExtra("k");

        if(r % 10 == 2 || r % 10 == 1){
            classes = r % 10 + 9;
        } else{
            classes = r % 10;
        }

        switch (r / 10) {
            case 1:
                urok = "Русский язык";
                break;
            case 2:
                urok = "Татарский язык";
                break;
            case 3:
                urok = "Математика";
                break;
            case 4:
                urok = "История";
                break;
            case 5:
                urok = "Английский язык";
                break;
            case 6:
                urok = "Физика";
                break;
            case 7:
                urok = "Химия";
                break;
            case 8:
                urok = "Информатика";
                break;
        }
    }
}