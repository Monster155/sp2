package com.example.student8.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.ResultSet;
import java.sql.Struct;


public class Dopolnenie extends Activity {

	Button btn, btn2;
	EditText etl, ett, etT;
	private DBHelper mDatabaseHelper;
	private SQLiteDatabase mSqLiteDatabase;
	TextView tv;

	Boolean en = false;

	private static ResultSet rs;
	String lesson, theme, text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dopolnenie);

		mDatabaseHelper = new DBHelper(this, "spdatabase.db", null, 1);

		etl = (EditText) findViewById(R.id.editText);
		ett = (EditText) findViewById(R.id.editText1);
		etT = (EditText) findViewById(R.id.editText2);
		btn = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		tv = (TextView) findViewById(R.id.textView3);

		tv.setText(Color.BLACK + " черный " + Color.WHITE + " белый " + Color.BLUE + " синий " + Color.RED + " красный " + Color.GREEN + " зеленый " + Color.YELLOW + " желтый " + Color.GRAY + " gray " + Color.CYAN + " cyan " + Color.MAGENTA + " magenta");
		mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();

		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Берем данные из EditText-ов и добавляем в БД
				lesson = String.valueOf(etl.getText());
				theme = String.valueOf(ett.getText());
				text = String.valueOf(etT.getText());

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
			String les = "", th = "", txt = "";
			Cursor cursor = mSqLiteDatabase.rawQuery(query, null);
			while (cursor.moveToNext()) {
				String lesson = cursor.getString(cursor
						.getColumnIndex(DBHelper.LESSON_COLUMN));
				String theme = cursor.getString(cursor
						.getColumnIndex(DBHelper.THEME_COLUMN));
				String text = cursor.getString(cursor
						.getColumnIndex(DBHelper.TEXT_COLUMN));
				les = les + lesson + " ";
				th = th + theme + " ";
				txt = txt + text + " ";
			}
			etl.setText(" Урок: " + les);
			ett.setText(" Тема: " + th);
			etT.setText(" Текст: " + txt);
			cursor.close();
			}
		});
	}
}
