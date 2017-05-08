package com.example.student8.myapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Urok extends Activity {

	TextView tv, tv2;
	EditText et, et2;
	Spinner sp;
	LinearLayout ll;
	int array, color, b;
	HashMap<String, Integer> pas;
	private DBHelper mDBH;
	private DBClass mDBC;
	private SQLiteDatabase db, dbC;
	int classes;

	String[] choose = new String[123];
	String urok, theme, text;


	public void text() {
		int r = getIntent().getIntExtra("k", 0);


		switch (r) {
		case 1:
			urok = "Русский язык";
			tv.setText("Русский язык");
			ll.setBackgroundResource(R.drawable.russk);
			color = -65536;
			tv2.setTextColor(-16711936);
			break;
		case 2:
			urok = "Татарский язык";
			tv.setText("Татарский язык");
			ll.setBackgroundResource(R.drawable.tatar);
			color = -16711936;
			tv.setTextColor(-1);
			tv2.setTextColor(-30700);
			break;
		case 3:
			urok = "Математика";
			tv.setText("Математика");
			ll.setBackgroundResource(R.drawable.matem);
			color = -16776961;
			tv.setTextColor(-1);
			tv2.setTextColor(-65536);
			break;
		case 4:
			urok = "История";
			tv.setText("История");
			ll.setBackgroundResource(R.drawable.istor);
			color = -16711936;
			tv.setTextColor(2131427383);
			tv2.setTextColor(-65536);
			break;
		case 5:
			urok = "Английский язык";
			tv.setText("Английский язык");
			ll.setBackgroundResource(R.drawable.angli);
			color = -30700;
			tv.setTextColor(-16711936);
			tv2.setTextColor(-65536);
			break;
		case 6:
			urok = "Физика";
			tv.setText("Физика");
			ll.setBackgroundResource(R.drawable.fizik);
			color = -65536;
			tv.setTextColor(-1);
			tv2.setTextColor(-65536);
			break;
		case 7:
			urok = "Химия";
			tv.setText("Химия");
			ll.setBackgroundResource(R.drawable.himik);
			color = -256;
			tv.setTextColor(-1);
			tv2.setTextColor(-65536);
			break;
		case 8:
			urok = "Информатика";
			tv.setText("Информатика");
			ll.setBackgroundResource(R.drawable.infor);
			color = -16776961;
			tv.setTextColor(-1);
			tv2.setTextColor(-65536);
			break;
		default:
			tv.setText("Fatal Error");
			ll.setBackgroundResource(R.drawable.error);
		}
	}

	public void choose2(){
		sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
				((TextView) parent.getChildAt(0)).setTextColor(color);
				((TextView) parent.getChildAt(0)).setTextSize(25);
				sp.setBackgroundColor(R.color.purple);
				String query = "SELECT * FROM uroki WHERE lesson='" + urok + "' AND theme='" + choose[selectedItemPosition] + "' AND class='" + classes + "'";
				String print = "";
				Cursor cursor = db.rawQuery(query, null);
				while (cursor.moveToNext()) {
					print = cursor.getString(cursor
							.getColumnIndex(DBHelper.TEXT_COLUMN));
				}
				theme = choose[selectedItemPosition];
				Log.d("Urok after choose2",print);
				tv2.setText(print);
				cursor.close();
			}
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.urok);

		final ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
		ib.setImageResource(R.drawable.pencil);
		final ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
		ib2.setImageResource(R.drawable.plus);

		mDBH = new DBHelper(this, "spdatabase.db", null, 1);
		db = mDBH.getWritableDatabase();

		mDBC = new DBClass(this, "spclass.db", null, 1);
		dbC = mDBC.getWritableDatabase();

		String query = "SELECT * FROM " + DBClass.DATABASE_TABLE;
		Cursor cursor = dbC.rawQuery(query, null);
		while (cursor.moveToNext()) {
			classes = cursor.getInt(cursor.getColumnIndex(DBClass.CLASS_COLUMN));
		}
		cursor.close();

		//file();
		pas = new HashMap<String, Integer>();

		et = (EditText) findViewById(R.id.editText);
		et.setTextSize(20);
		et.setVisibility(View.INVISIBLE);

		et2 = (EditText) findViewById(R.id.editText2);
		et2.setTextSize(1);
		et2.setVisibility(View.INVISIBLE);

		tv = (TextView) findViewById(R.id.textView1);
		tv.setTextSize(30);

		tv2 = (TextView) findViewById(R.id.textView2);
		tv2.setTextSize(20);

		ll = (LinearLayout) findViewById(R.id.LinearLayout);

		text();

		sp = (Spinner) findViewById(R.id.spinner1);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		int i = 0;
		query = "SELECT * FROM " + DBHelper.DATABASE_TABLE + " WHERE lesson='" + urok + "' AND class='" + classes + "';";
		cursor = db.rawQuery(query, null);
		while (cursor.moveToNext()) {
			choose[i] = cursor.getString(cursor.getColumnIndex(DBHelper.THEME_COLUMN));
			adapter.add(choose[i]);
			i++;
		}
		cursor.close();
		sp.setAdapter(adapter);

		//choose();

		/*ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);*/

		choose2();

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

						sp.setVisibility(View.VISIBLE);

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

					sp.setVisibility(View.INVISIBLE);

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

						Toast toast = Toast.makeText(getApplicationContext(), "Чтобы изменения вступили в силу, \n" + "перезайдите во вкладку.", Toast.LENGTH_SHORT);
						toast.show();

						et2.setText("");
						et2.setVisibility(View.INVISIBLE);
						et2.setTextSize(1);

						et.setText("");
						et.setVisibility(View.INVISIBLE);

						tv2.setVisibility(View.VISIBLE);
						tv2.setTextSize(20);

						sp.setVisibility(View.VISIBLE);

						InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						imm.hideSoftInputFromWindow(ib2.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

						ib.setImageResource(R.drawable.pencil);
						ib2.setImageResource(R.drawable.plus);
					}
				}
			}
		});
	}
}
