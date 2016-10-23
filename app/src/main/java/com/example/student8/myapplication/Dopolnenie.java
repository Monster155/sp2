package com.example.student8.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.sql.ResultSet;


public class Dopolnenie extends Activity {

	Button btn;
	EditText et;
	private DBHelper mDatabaseHelper;
	private SQLiteDatabase mSqLiteDatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dopolnenie);

		mDatabaseHelper = new DBHelper(this, "spdatabase.db", null, 1);

		et = (EditText) findViewById(R.id.editText1);
		btn = (Button) findViewById(R.id.button1);

		mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		// Задайте значения для каждого столбца
		values.put(DBHelper.LESSON_COLUMN, "Математика");
		values.put(DBHelper.LESSON_COLUMN, "Физика");
		values.put(DBHelper.THEME_COLUMN, "Сложение");
		values.put(DBHelper.TEXT_COLUMN, "x + z = ответ");
		// Вставляем данные в таблицу
		mSqLiteDatabase.insert("uroki", null, values);

        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Cursor cursor = mSqLiteDatabase.query("uroki", new String[]{DBHelper.LESSON_COLUMN,
								DBHelper.THEME_COLUMN, DBHelper.TEXT_COLUMN},
						null, null,
						null, null, null);

				cursor.moveToFirst();

				String lesson = cursor.getString(cursor.getColumnIndex(DBHelper.LESSON_COLUMN));
				String theme = cursor.getString(cursor.getColumnIndex(DBHelper.THEME_COLUMN));
				String text = cursor.getString(cursor.getColumnIndex(DBHelper.TEXT_COLUMN));

				et.setText(" Урок: " + lesson + " \n" + " Или " + /*lesson2[0] + */ "\n Тема: " + theme + "\n " +
						text);

				// не забываем закрывать курсор
				cursor.close();
			}
		});
	}
}
