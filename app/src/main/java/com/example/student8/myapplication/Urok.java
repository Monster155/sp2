package com.example.student8.myapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Urok extends Activity {

	TextView tv, tv2;
	Spinner sp;
	LinearLayout ll;
	int array, color;
	HashMap<String, Integer> pas;
	private DBHelper mDBH;
	private SQLiteDatabase db;
	public int classes = 9;

	String[] choose;
	String urok;

	/*public void choose(){
	    pas.put("Деепричастие", R.string.Deeprichastie);
	    pas.put("Причастие", R.string.Prichastie);
	    pas.put("Правописание запятых", R.string.Pravopisanie_zapyatyh);
	    pas.put("Исем фигыль", R.string.Isem_figyl);
		pas.put("Аергыч", R.string.Aergych);
		pas.put("Исем", R.string.Isem);
		pas.put("График функции", R.string.Grafik_funkcii);
		pas.put("Неравенства", R.string.Neravenstva);
		pas.put("Окружность", R.string.Okrujnost);
		pas.put("Правление Александра I", R.string.Pravlenie_Aleksandra_I);
		pas.put("1 Мировая Война", R.string.I_Mirovaya_Voina);
		pas.put("Отечественная война 1812 года", R.string.Otechestvennaya_voina_1812_goda);
		pas.put("Past Simple", R.string.Past_Simple);
		pas.put("Modals", R.string.Modals);
		pas.put("Conditionals", R.string.Conditionals);
		pas.put("Теплопроводность", R.string.Teploprovodnost);
		pas.put("Линзы", R.string.Linzy);
		pas.put("Электрический ток", R.string.Elektricheskii_tok);
		pas.put("Окислители", R.string.Okisliteli);
		pas.put("Соли", R.string.Soli);
		pas.put("Оксиды", R.string.Oksidy);
		pas.put("Способы ввода и вывода", R.string.Sposoby_vvoda_i_vyvoda);
		pas.put("Основные понятия", R.string.Osnovnye_ponyatiya);
		pas.put("Виды переменных", R.string.Vidy_peremennyh);
	}*/

	public void text() {
		int r = getIntent().getIntExtra("k", 0);


		switch (r) {
		case 1:
			urok = "Русский язык";
			choose  = getResources().getStringArray(R.array.russk);
			tv.setText("Русский язык");
			ll.setBackgroundResource(R.drawable.russk);
			array = R.array.russk;
			color = -65536;
			tv2.setTextColor(-16711936);
			break;
		case 2:
			urok = "Татарский язык";
			choose  = getResources().getStringArray(R.array.tatar);
			tv.setText("Татарский язык");
			ll.setBackgroundResource(R.drawable.tatar);
			array = R.array.tatar;
			color = -16711936;
			tv.setTextColor(-1);
			tv2.setTextColor(-30700);
			break;
		case 3:
			urok = "Математика";
			choose  = getResources().getStringArray(R.array.matem);
			tv.setText("Математика");
			ll.setBackgroundResource(R.drawable.matem);
			array = R.array.matem;
			color = -16776961;
			tv.setTextColor(-1);
			tv2.setTextColor(-65536);
			break;
		case 4:
			urok = "История";
			choose  = getResources().getStringArray(R.array.istor);
			tv.setText("История");
			ll.setBackgroundResource(R.drawable.istor);
			array = R.array.istor;
			color = -16711936;
			tv.setTextColor(2131427383);
			tv2.setTextColor(-65536);
			break;
		case 5:
			urok = "Английский язык";
			choose  = getResources().getStringArray(R.array.angli);
			tv.setText("Английский язык");
			ll.setBackgroundResource(R.drawable.angli);
			array = R.array.angli;
			color = -30700;
			tv.setTextColor(-16711936);
			tv2.setTextColor(-65536);
			break;
		case 6:
			urok = "Физика";
			choose  = getResources().getStringArray(R.array.fizik);
			tv.setText("Физика");
			ll.setBackgroundResource(R.drawable.fizik);
			array = R.array.fizik;
			color = -65536;
			tv.setTextColor(-1);
			tv2.setTextColor(-65536);
			break;
		case 7:
			urok = "Химия";
			choose  = getResources().getStringArray(R.array.himik);
			tv.setText("Химия");
			ll.setBackgroundResource(R.drawable.himik);
			array = R.array.himik;
			color = -256;
			tv.setTextColor(-1);
			tv2.setTextColor(-65536);
			break;
		case 8:
			urok = "Информатика";
			choose  = getResources().getStringArray(R.array.infor);
			tv.setText("Информатика");
			ll.setBackgroundResource(R.drawable.infor);
			array = R.array.infor;
			color = -16776961;
			tv.setTextColor(-1);
			tv2.setTextColor(-65536);
			break;
		default:
			tv.setText("Fatal Error");
			ll.setBackgroundResource(R.drawable.error);
		}
	}

	/*public void file() {
		try {
			Scanner sc = new Scanner(
					new File("/home/student/Рабочий стол/text"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public void choose2(){
		sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
				((TextView) parent.getChildAt(0)).setTextColor(color);
				((TextView) parent.getChildAt(0)).setTextSize(25);
				sp.setBackgroundColor(R.color.purple);
				String query = "SELECT * FROM uroki WHERE lesson='" + urok + "' AND theme='" + choose[selectedItemPosition] + "'";
				String print = "";
				Cursor cursor = db.rawQuery(query, null);
				while (cursor.moveToNext()) {
					String text = cursor.getString(cursor
							.getColumnIndex(DBHelper.TEXT_COLUMN));
					print = text + "\n" + "\n";
				}
				Log.d("Urok after choose2",print);
				tv2.setText(print);
				//tv2.setText(query);
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

		mDBH = new DBHelper(this, "spdatabase.db", null, 1);
		db = mDBH.getWritableDatabase();

		//file();
		pas = new HashMap<String, Integer>();
		tv = (TextView) findViewById(R.id.textView1);
		tv.setTextSize(30);
		tv2 = (TextView) findViewById(R.id.textView2);
		tv2.setTextSize(20);
		ll = (LinearLayout) findViewById(R.id.LinearLayout);
		text();

		//choose();

		sp = (Spinner) findViewById(R.id.spinner1);

		ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		choose2();

		/*sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
					View itemSelected, int selectedItemPosition, long selectedId) {

				if(pas.get(choose[selectedItemPosition]) == null){
					tv2.setText("Жди дороботки");
				} else{
					int id = pas.get(choose[selectedItemPosition]);
					tv2.setText(id);
				}
			}
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});*/
	}
}
