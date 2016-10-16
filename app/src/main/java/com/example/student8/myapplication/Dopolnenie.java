package com.example.student8.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.opengl.ETC1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Dopolnenie extends Activity {

	Button btn;
	EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dopolnenie);
		et = (EditText) findViewById(R.id.editText1);
		btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}
}
