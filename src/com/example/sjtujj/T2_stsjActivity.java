package com.example.sjtujj;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class T2_stsjActivity extends Activity {
private String rid = "";
private String time = "2015-03-01 12:00";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_stsj);
		
		/*
		rid = getIntent().getExtras().getString("rid");
		time = getIntent().getExtras().getString("time");
		*/
		
		
		SimpleDateFormat sFormat = new SimpleDateFormat(time);
		
		//sFormat.get2DigitYearStart()
		
		
		//设置时间日期
		EditText et1 = (EditText)findViewById(R.id.t2_stsj_et1);
		et1.setText(time.substring(0, 10));
		
		et1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_stsj_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
