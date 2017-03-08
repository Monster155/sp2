package com.example.student8.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends Activity {

    Button btn, btn2;
    private DBHelper mDBH;
    private SQLiteDatabase db;
    Download dl;
    Context context;
    Enter enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btn = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        mDBH = new DBHelper(this, "spdatabase.db", null, 1);
        db = mDBH.getWritableDatabase();

        btn.setOnClickListener(new View.OnClickListener() {
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
                        .setNegativeButton("Да",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        db.execSQL("DROP TABLE uroki");
                                        db.execSQL(mDBH.DATABASE_CREATE_SCRIPT);
                                        enter.enter(1);
                                        dl = new Download(context, DBScan.db);
                                        dl.download();                                    }
                                }
                        );
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}

