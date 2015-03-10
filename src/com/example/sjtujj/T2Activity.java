package com.example.sjtujj;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class T2Activity extends Activity {
private TextView tv1;
private TextView tv2;
private TextView tv3;
private int type = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2);
		
		tv1 = (TextView)findViewById(R.id.t2_quanbu);
		tv2 = (TextView)findViewById(R.id.t2_shangke);
		tv3 = (TextView)findViewById(R.id.t2_guoqi);
		
		tv1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (type != 1)
				{
					type = 1;
					//TODO ÇÐ»»tab
				}
				//TODO ÐÞ¸ÄÑÕÉ«
			}		
		});
		
	}
}
