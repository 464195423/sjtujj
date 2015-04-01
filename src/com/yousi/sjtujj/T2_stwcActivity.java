package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T2_stwcActivity extends Activity {
private String rid;
private T2_ddxx_net T2_ddxx_netItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_stwc);
		
		rid = getIntent().getExtras().getString("rid");
		

		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_stwc_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
        //设置电话
        getData();
		
	}
	
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		//map.put("pwd", passwd.getText().toString());
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					T2_ddxx_netItems = JSONObject.parseObject(data1.toString(), T2_ddxx_net.class);	
					setData();
				}
				else
					Toast.makeText(T2_stwcActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.ddxx_path, map, DB.getSessionid(T2_stwcActivity.this));
	}
	
	private void setData(){
		TextView tv = (TextView)findViewById(R.id.t2_stwc_phone);
		tv.setText("家长电话："+T2_ddxx_netItems.getPhone());
		SpannableStringBuilder builder = new SpannableStringBuilder(tv.getText().toString());
		ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.BLACK);  
		ForegroundColorSpan whiteSpan = new ForegroundColorSpan(Color.GREEN); 
		builder.setSpan(redSpan, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);  
		builder.setSpan(whiteSpan, 5, tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); 
		tv.setText(builder); 
		
	}
}
