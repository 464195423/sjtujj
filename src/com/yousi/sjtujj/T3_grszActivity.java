package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.sjtujj.SwitchButton.OnChangeListener;

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
private String is_search_show = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t3_grsz);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		tid = bundle.getString("tid");
		is_search_show = bundle.getString("is_search_show");
		
		//个人设置
		SwitchButton sb1 = (SwitchButton) findViewById(R.id.t3_grsz_b1);  
        sb1.setOnChangeListener(new OnChangeListener() {  
              
            @Override  
            public void onChange(SwitchButton sb, boolean state) {  
                // TODO Auto-generated method stub  
            	HashMap<String, String> map = new HashMap<String, String>();
        		map.put("searchShow", state ? "1":"2");
        		map.put("tid", tid);
        		MyHttpClient.doPost2(null, new NetRespondPost() {
        			@Override
        			public void netWorkOk(String json) {
        				JSONObject jsonObject = JSONObject.parseObject(json);
//        				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
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
        		}, MyPath.change_T_S_path, map, DB.getSessionid(T3_grszActivity.this));
                //Log.d("switchButton", state ? "开":"关");  
                //Toast.makeText(T3_grszActivity.this, state ? "开":"关", Toast.LENGTH_SHORT).show();  
            }  
        });		
        
		if (is_search_show.equals("2"))
			sb1.onClick(null);
		
			
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
}
