package com.example.sjtujj;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class T2_skjsActivity extends Activity {
private String rid;
private String teachhours;
private int shichang = 0;
private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_skjs);
		
		rid = getIntent().getExtras().getString("rid");
		teachhours = getIntent().getExtras().getString("teachhours");
		
		tv = (TextView)findViewById(R.id.t2_skjs_shoukeshichang);
		tv.setText(teachhours);
		
		shichang = Integer.parseInt(teachhours);
		
		//设置授课时长按钮
		ImageView iv1 = (ImageView)findViewById(R.id.t2_skjs_plus);
		ImageView iv2 = (ImageView)findViewById(R.id.t2_skjs_minus);
		
		
		iv1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 边界值判定
				if (shichang >= Integer.parseInt(teachhours))
					shichang = Integer.parseInt(teachhours);
				else
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
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_skjs_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}
}
