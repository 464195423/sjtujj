package com.example.sjtujj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class T2_ksskActivity extends Activity {
private int shichang = 2;
private TextView tv;
private String rid = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_kssk);
		
		rid = getIntent().getExtras().getString("rid");
		//Log.v("rid",rid);
		
		
		tv = (TextView)findViewById(R.id.t2_shoukeshichang);
		
		ImageView iv1 = (ImageView)findViewById(R.id.t2_plus);
		ImageView iv2 = (ImageView)findViewById(R.id.t2_minus);
		
		
		iv1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 边界值判定
				shichang ++;
				tv.setText(String.valueOf(shichang));
			}			
		});
		iv2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (shichang <= 1)
					shichang = 1;
				else
					shichang --;
				tv.setText(String.valueOf(shichang));
			}			
		});		
		
		
        //左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_kssk_up);
        lv_up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
