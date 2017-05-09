package com.example.student8.myapplication;

import android.app.*;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	Button r, t, m, is, a, f, h, in;
	ImageButton set;
	private DBScan mDBS;
	private DBHelper mDBH;
	private SQLiteDatabase dbS, db;
	Enter enter;
	Download dl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
		ib.setImageResource(R.drawable.settings);

		mDBS = new DBScan(this, "spscan.db", null, 1);
		dbS = mDBS.getWritableDatabase();
		dbS.close();
		mDBH = new DBHelper(this, "spdatabase.db", null, 1);
		db = mDBH.getWritableDatabase();
		dl = new Download(this);
		dl.download();
		r = (Button) findViewById(R.id.buttonR);
		t = (Button) findViewById(R.id.buttonT);
		m = (Button) findViewById(R.id.buttonM);
		is = (Button) findViewById(R.id.buttonIs);
		a = (Button) findViewById(R.id.buttonA);
		f = (Button) findViewById(R.id.buttonF);
		h = (Button) findViewById(R.id.buttonH);
		set = (ImageButton) findViewById(R.id.imageButton);
		in = (Button) findViewById(R.id.buttonIn);

		r.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Klass.class);
				intent.putExtra("k", 1);
				startActivity(intent);
			}
		});

		t.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Klass.class);
				intent.putExtra("k", 2);
				startActivity(intent);
			}
		});

		m.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Klass.class);
				intent.putExtra("k", 3);
				startActivity(intent);
			}
		});

		is.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Klass.class);
				intent.putExtra("k", 4);
				startActivity(intent);
			}
		});

		a.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Klass.class);
				intent.putExtra("k", 5);
				startActivity(intent);
			}
		});

		f.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Klass.class);
				intent.putExtra("k", 6);
				startActivity(intent);
			}
		});

		h.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Klass.class);
				intent.putExtra("k", 7);
				startActivity(intent);
			}
		});

		in.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Klass.class);
				intent.putExtra("k", 8);
				startActivity(intent);
			}
		});

		set.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Setting.class);
				startActivity(intent);
			}
		});
	}

}
