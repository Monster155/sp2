package com.example.student8.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;


public class Enter extends Activity {

    Context context;
    //private DBScan mDBS;
    //private SQLiteDatabase dbS;

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;
    public static int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // Запоминаем данные
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mSettings.contains(APP_PREFERENCES_COUNTER)) {
            // Получаем число из настроек
            mCounter = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
        }
    }

    public Enter(Context c){
        this.context = c;
    }

    /*void enter(int f){
        mDBS = new DBScan(context, "spscan.db", null, 1);
        dbS = mDBS.getWritableDatabase();
        // Создайте новую строку со значениями для вставки.
        ContentValues newValues = new ContentValues();
        // Задайте значения для каждой строки.
        newValues.put("flag", f);
        // Вставьте строку в вашу базу данных.
        dbS.insert("scan", null, newValues);
    }*/
}
