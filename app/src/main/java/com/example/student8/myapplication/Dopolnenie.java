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

		et = (EditText) findViewById(R.id.editText1);
		btn = (Button) findViewById(R.id.button1);

		mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();

        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Cursor cursor = mSqLiteDatabase.query("uroki", new String[]{DBHelper.LESSON_COLUMN,
								DBHelper.THEME_COLUMN, DBHelper.ID_COLUMN},
						null, null,
						null, null, null);

				cursor.moveToFirst();

				String lesson = cursor.getString(cursor.getColumnIndex(DBHelper.LESSON_COLUMN));
				String theme = cursor.getString(cursor.getColumnIndex(DBHelper.THEME_COLUMN));
				int id = cursor.getInt(cursor.getColumnIndex(DBHelper.ID_COLUMN));

				et.setText("Урок: " + lesson + ". Тема: " + theme + ". Id урока: " +
						id);

				// не забываем закрывать курсор
				cursor.close();
			}
		});
	}
}
