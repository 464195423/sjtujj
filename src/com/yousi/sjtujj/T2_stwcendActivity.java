package com.yousi.sjtujj;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class T2_stwcendActivity extends Activity {
private String rid = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_stwcend);
		
		rid = getIntent().getExtras().getString("rid");
		
		TextView tv = (TextView)findViewById(R.id.t2_stwcend_tv);
		tv.setText("恭喜您完成订单D"+rid+"的试听！");
		
		//返回按钮
		Button bt = (Button)findViewById(R.id.t2_stwcend_bt);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_stwcendActivity.this, MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
			}
		});
		
	}
}
