package com.example.student8.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.opengl.ETC1;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


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
		SQLiteDatabase sdb;
		sdb = mDatabaseHelper.getReadableDatabase();

		et = (EditText) findViewById(R.id.editText1);
		btn = (Button) findViewById(R.id.button1);
		mDatabaseHelper = new DBHelper(this, "mydatabase.db", null, 1);

		mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		// Задайте значения для каждого столбца
		values.put(DBHelper.CAT_NAME_COLUMN, "Рыжик");
		values.put(DBHelper.PHONE_COLUMN, "4954553443");
		values.put(DBHelper.AGE_COLUMN, "5");
		// Вставляем данные в таблицу
		mSqLiteDatabase.insert("cats", null, values);

        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Cursor cursor = mSqLiteDatabase.query("cats", new String[]{DBHelper.CAT_NAME_COLUMN,
								DBHelper.PHONE_COLUMN, DBHelper.AGE_COLUMN},
						null, null,
						null, null, null);

				cursor.moveToFirst();

				String catName = cursor.getString(cursor.getColumnIndex(DBHelper.CAT_NAME_COLUMN));
				long phoneNumber = cursor.getLong(cursor.getColumnIndex(DBHelper.PHONE_COLUMN));
				int age = cursor.getInt(cursor.getColumnIndex(DBHelper.AGE_COLUMN));

				et.setText("Кот " + catName + " имеет телефон " + phoneNumber + " и ему " +
						age + " лет");

				// не забываем закрывать курсор
				cursor.close();
			}
		});
	}
}
