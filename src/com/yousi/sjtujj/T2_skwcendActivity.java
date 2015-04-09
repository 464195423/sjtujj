package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.util.DB;
import com.yousi.util.MyPath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class T2_skwcendActivity extends Activity {
private String rid = "";
private String hours1;
private String hours2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_skwcend);
		
		rid = getIntent().getExtras().getString("rid");
		hours1 = getIntent().getExtras().getString("hours");
		
		//设置文字
		TextView tv = (TextView)findViewById(R.id.t2_skwcend_tv);
		tv.setText("恭喜您完成订单D"+rid+"的授课！");
		
		getData();
		
		
		//返回按钮
		Button bt = (Button)findViewById(R.id.t2_skwcend_bt);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_skwcendActivity.this, MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
			}
		});
	}
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		
		MyHttpClient.doPost2(T2_skwcendActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				Log.v("json", json);
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					
					hours2 = data1.getString("discount");
					TextView tv = (TextView)findViewById(R.id.t2_skwcend_info);
					tv.setText("1，本次授课时长："+hours1+"小时\n2，还剩授课时长："+hours2+"小时");
				}
				else
					Toast.makeText(T2_skwcendActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.singleOrderShow_path, map, DB.getSessionid(T2_skwcendActivity.this));
	}
}
