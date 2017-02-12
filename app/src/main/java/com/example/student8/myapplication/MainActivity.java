package com.example.student8.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button r, t, m, is, a, f, h, in, dop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		r = (Button) findViewById(R.id.buttonR);
		t = (Button) findViewById(R.id.buttonT);
		m = (Button) findViewById(R.id.buttonM);
		is = (Button) findViewById(R.id.buttonIs);
		a = (Button) findViewById(R.id.buttonA);
		f = (Button) findViewById(R.id.buttonF);
		h = (Button) findViewById(R.id.buttonH);
		in = (Button) findViewById(R.id.buttonIn);
		dop = (Button) findViewById(R.id.button1);

		r.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Urok.class);
				intent.putExtra("k", 1);
				startActivity(intent);
			}
		});

		t.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Urok.class);
				intent.putExtra("k", 2);
				startActivity(intent);
			}
		});

		m.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Urok.class);
				intent.putExtra("k", 3);
				startActivity(intent);
			}
		});

		is.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Urok.class);
				intent.putExtra("k", 4);
				startActivity(intent);
			}
		});

		a.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Urok.class);
				intent.putExtra("k", 5);
				startActivity(intent);
			}
		});

		f.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Urok.class);
				intent.putExtra("k", 6);
				startActivity(intent);
			}
		});

		h.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Urok.class);
				intent.putExtra("k", 7);
				startActivity(intent);
			}
		});

		in.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Urok.class);
				intent.putExtra("k", 8);
				startActivity(intent);
			}
		});
		
		dop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Dopolnenie.class);
				startActivity(intent);
			}
		});
	}


}
