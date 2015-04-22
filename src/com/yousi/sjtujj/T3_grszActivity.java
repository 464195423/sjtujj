package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;
import com.yousi.util.SwitchButton;
import com.yousi.util.SwitchButton.OnChangeListener;

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
import android.widget.Toast;

public class T3_grszActivity extends Activity {
private String tid = "";
private boolean state1 = true;		//true开启, false关闭
private boolean state2 = true;		//true开启, false关闭
private ImageView sb1;
private ImageView sb2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t3_grsz);
		
		sb1 = (ImageView) findViewById(R.id.t3_grsz_b1); 
		sb2 = (ImageView) findViewById(R.id.t3_grsz_b2); 
		//获取家教状态设置
		getData();
		
		//家教状态设置
        sb1.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				state1 = ! state1;
				sb1.setBackgroundResource(state1 ? R.drawable.switchon : R.drawable.switchoff);
				HashMap<String, String> map = new HashMap<String, String>();
        		map.put("searchShow", state1 ? "1":"2");
        		MyHttpClient.doPost2(null, new NetRespondPost() {
        			@Override
        			public void netWorkOk(String json) {
        				JSONObject jsonObject = JSONObject.parseObject(json);
        				String code = jsonObject.getString("code");
        				if (code.equals("200")) {
        					//do nothing
        				}
        				else
        					Toast.makeText(T3_grszActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
        			}
        			@Override
        			public void netWorkError() {
        			}
        		}, NewMyPath.changeTeacherSearch_path, map, DB.getSessionid(T3_grszActivity.this));
			}
		});
              

        //TODO
        sb2.setBackgroundResource(state2 ? R.drawable.switchon : R.drawable.switchoff);
        sb2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				state2 = ! state2;
				sb2.setBackgroundResource(state2 ? R.drawable.switchon : R.drawable.switchoff);
			}

        });	        
        
       
        //左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t3_grsz_up);
        lv_up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
	}
	
	private void getData() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		MyHttpClient.doGet2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				Log.v("json", json);
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					String tmp = data1.getString("searchStatus");
					if (tmp.equals("1"))
						state1 = true;
					else
						state1 = false;
					sb1.setBackgroundResource(state1 ? R.drawable.switchon : R.drawable.switchoff);
				}
				else
					Toast.makeText(T3_grszActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.personalSet_path, map, DB.getSessionid(T3_grszActivity.this));
	}
}
