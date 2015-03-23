package com.example.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
		
		//去授课按钮
		Button bt = (Button)findViewById(R.id.t2_kssk_qushouke);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		//设置授课时长
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
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("hours", Integer.toString(shichang));
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//TODO
				}

			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.qushouke_path, map, MyPath.getSessionid());
	}
}
