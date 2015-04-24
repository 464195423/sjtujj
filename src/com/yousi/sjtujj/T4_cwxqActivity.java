package com.yousi.sjtujj;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class T4_cwxqActivity extends Activity {
private String gold;
private String desc;
private String time;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t4_cwxq);
		
		gold = getIntent().getExtras().getString("gold");
		desc = getIntent().getExtras().getString("desc");
		time = getIntent().getExtras().getString("time");
		
		TextView tv1 = (TextView)findViewById(R.id.t4_cwxq_desc);
		tv1.setText(desc);
		TextView tv2 = (TextView)findViewById(R.id.t4_cwxq_gold);
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");  
		double d = Double.parseDouble(gold);
		tv2.setText("½ð¶î£º£¤"+df.format(d));
		TextView tv3 = (TextView)findViewById(R.id.t4_cwxq_time);
		tv3.setText(time);
		
		//×óÉÏ·µ»Ø¼ü
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t4_cwxq_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
