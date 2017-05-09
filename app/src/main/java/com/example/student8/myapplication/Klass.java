package com.example.student8.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Klass extends Activity {

    Button b11, b10, b9, b8, b7, b6, b5;
    TextView tv;
    String urok;
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.klass);
        b11 = (Button) findViewById(R.id.button11);
        b10 = (Button) findViewById(R.id.button10);
        b9 = (Button) findViewById(R.id.button9);
        b8 = (Button) findViewById(R.id.button8);
        b7 = (Button) findViewById(R.id.button7);
        b6 = (Button) findViewById(R.id.button6);
        b5 = (Button) findViewById(R.id.button5);
        tv = (TextView) findViewById(R.id.textView4);

        text();
        tv.setText(urok);
        tv.setTextSize(20);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Klass.this, ListActivity.class);
                intent.putExtra("k", (r * 10 + 5));
                startActivity(intent);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Klass.this, ListActivity.class);
                intent.putExtra("k", (r * 10 + 6));
                startActivity(intent);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Klass.this, ListActivity.class);
                intent.putExtra("k", (r * 10 + 7));
                startActivity(intent);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Klass.this, ListActivity.class);
                intent.putExtra("k", (r * 10 + 8));
                startActivity(intent);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Klass.this, ListActivity.class);
                intent.putExtra("k", (r * 10 + 9));
                startActivity(intent);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Klass.this, ListActivity.class);
                intent.putExtra("k", (r * 10 + 1));
                startActivity(intent);
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Klass.this, ListActivity.class);
                intent.putExtra("k", (r * 10 + 2));
                startActivity(intent);
            }
        });
    }

    public void text() {
        r = getIntent().getIntExtra("k", 0);

        switch (r) {
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
                b5.setVisibility(View.INVISIBLE);
                b6.setVisibility(View.INVISIBLE);
                break;
            case 7:
                urok = "Химия";
                b5.setVisibility(View.INVISIBLE);
                b6.setVisibility(View.INVISIBLE);
                b7.setVisibility(View.INVISIBLE);
                break;
            case 8:
                urok = "Информатика";
                b5.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
