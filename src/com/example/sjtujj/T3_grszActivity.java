package com.example.sjtujj;

import com.example.sjtujj.SwitchButton.OnChangeListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class T3_grszActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t3_grsz);
		
		SwitchButton sb1 = (SwitchButton) findViewById(R.id.t3_grsz_b1);  
        sb1.setOnChangeListener(new OnChangeListener() {  
              
            @Override  
            public void onChange(SwitchButton sb, boolean state) {  
                // TODO Auto-generated method stub  
                Log.d("switchButton", state ? "开":"关");  
                Toast.makeText(T3_grszActivity.this, state ? "开":"关", Toast.LENGTH_SHORT).show();  
            }  
        });		
		SwitchButton sb2 = (SwitchButton) findViewById(R.id.t3_grsz_b2);  
        sb2.setOnChangeListener(new OnChangeListener() {  
              
            @Override  
            public void onChange(SwitchButton sb, boolean state) {  
                // TODO Auto-generated method stub  
                Log.d("switchButton", state ? "开":"关");  
                Toast.makeText(T3_grszActivity.this, state ? "开":"关", Toast.LENGTH_SHORT).show();  
            }  
        });	        
        
        LinearLayout ll3 = (LinearLayout)findViewById(R.id.t3_grsz_l3);
        ll3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T3_grszActivity.this, T3_yjfkActivity.class);
				startActivity(intent);
			}
		});
	}
}
