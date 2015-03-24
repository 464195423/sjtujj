package com.example.sjtujj;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class T2_stjsActivity extends Activity {
private String rid = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_stjs);
		
		rid = getIntent().getExtras().getString("rid");
		

		//×óÉÏ·µ»Ø¼ü
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_stjs_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
