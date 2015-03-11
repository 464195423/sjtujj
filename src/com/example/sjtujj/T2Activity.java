package com.example.sjtujj;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
					tv1.setTextColor(getResources().getColor(R.color.select));
					tv1.setBackgroundColor(getResources().getColor(R.color.background2));
					tv2.setTextColor(getResources().getColor(R.color.unselect));
					tv2.setBackgroundColor(getResources().getColor(R.color.background3));		
					tv3.setTextColor(getResources().getColor(R.color.unselect));
					tv3.setBackgroundColor(getResources().getColor(R.color.background3));	
					
					//TODO network
				}
			}		
		});
		tv2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (type != 2)
				{				
					type = 2;
					tv2.setTextColor(getResources().getColor(R.color.select));
					tv2.setBackgroundColor(getResources().getColor(R.color.background2));
					tv1.setTextColor(getResources().getColor(R.color.unselect));
					tv1.setBackgroundColor(getResources().getColor(R.color.background3));		
					tv3.setTextColor(getResources().getColor(R.color.unselect));
					tv3.setBackgroundColor(getResources().getColor(R.color.background3));	
					
					//TODO network
				}
			}		
		});	
		tv3.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (type != 3)
				{				
					type = 3;
					tv3.setTextColor(getResources().getColor(R.color.select));
					tv3.setBackgroundColor(getResources().getColor(R.color.background2));
					tv2.setTextColor(getResources().getColor(R.color.unselect));
					tv2.setBackgroundColor(getResources().getColor(R.color.background3));		
					tv1.setTextColor(getResources().getColor(R.color.unselect));
					tv1.setBackgroundColor(getResources().getColor(R.color.background3));	
					
					//TODO network
				}			
			}		
		});
		
		
		
	}
}
