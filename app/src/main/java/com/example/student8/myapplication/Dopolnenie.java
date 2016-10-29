package com.example.student8.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.sql.ResultSet;


public class Dopolnenie extends Activity {

	Button btn, btn2;
	EditText et;
	private DBHelper mDatabaseHelper;
	private SQLiteDatabase mSqLiteDatabase;

	private static ResultSet rs;
	String query, lesson, theme, text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dopolnenie);

		mDatabaseHelper = new DBHelper(this, "spdatabase.db", null, 1);

		et = (EditText) findViewById(R.id.editText1);
		btn = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);

		mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();

		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//берем данные из EditText-ов и добавляем в БД
				lesson = String.valueOf(et.getText());
				//
				ContentValues values = new ContentValues();
				// Задайте значения для каждого столбца
				values.put(DBHelper.LESSON_COLUMN, lesson);
				values.put(DBHelper.THEME_COLUMN, theme);
				values.put(DBHelper.TEXT_COLUMN, text);
				// Вставляем данные в таблицу
				mSqLiteDatabase.insert("uroki", null, values);
			}
		});

		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			String query = "SELECT * FROM uroki";
			String les = "", th = "";
			Cursor cursor = mSqLiteDatabase.rawQuery(query, null);
			while (cursor.moveToNext()) {
				String lesson = cursor.getString(cursor
						.getColumnIndex(DBHelper.LESSON_COLUMN));
				String theme = cursor.getString(cursor
						.getColumnIndex(DBHelper.THEME_COLUMN));
				les = les + lesson + " ";
				th = th + theme + " ";
			}
			et.setText(" Урок: " + les + " \n Тема: " + th);
			cursor.close();
			}
		});
	}
}
