package com.example.student8.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends android.app.ListActivity {

    private DBHelper mDBH;
    private SQLiteDatabase db;
    String choose[] = new String [123], urok;
    int r, classes;

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        text();

        mDBH = new DBHelper(this, "spdatabase.db", null, 1);
        db = mDBH.getWritableDatabase();

        //choose[0] = urok + "\n" + classes + " класс";

        int i = 1;
        String query = "SELECT * FROM " + DBHelper.DATABASE_TABLE + " WHERE lesson='" + urok + "' AND class='" + classes + "';";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            choose[i] = cursor.getString(cursor.getColumnIndex(DBHelper.THEME_COLUMN));
            i++;
        }
        cursor.close();

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, choose);
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String theme = l.getItemAtPosition(position).toString();

        Intent intent = new Intent(ListActivity.this, Urok.class);
        intent.putExtra(theme, classes);
        startActivity(intent);
    }

    public void text() {
        r = getIntent().getIntExtra("k", 0);

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