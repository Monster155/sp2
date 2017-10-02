package com.example.student8.myapplication;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TimeTable extends Activity{

    Spinner sp[][] = new Spinner[6][8];
    String choose, tt[];
    int array, temp, numOfLes = 48;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);

        names();
        choose = "Я не даун, a Сеня даун";

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 8; j++){
                spiner(sp[i][j]);
            }
        }


    }

    //поиск id переменных
    private void names() {
        tt = new String[numOfLes];
        for(int i = 0; i < numOfLes; i++){
            tt[i] = i + "";
        }
        numOfLes = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 8; j++){
                temp = getResources().getIdentifier(tt[numOfLes], "id", getPackageName());
                numOfLes++;
                sp[i][j] = (Spinner) findViewById(temp);
            }
        }
    }

    //заполнение spinner
    private void spiner(Spinner spin) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add(choose);
        spin.setAdapter(adapter);
    }
}
