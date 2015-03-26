package com.example.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T2_stjsActivity extends Activity {
private String rid = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_stjs);
		
		rid = getIntent().getExtras().getString("rid");
		
		//确认完成
		Button bt = (Button)findViewById(R.id.t2_stjs_bt);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PostData();
			}
		});
		
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_stjs_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	private void PostData(){
		EditText et = (EditText)findViewById(R.id.t2_stjs_et);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("safe_code",et.getText().toString());
		MyHttpClient.doPost2(T2_stjsActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					Intent intent = new Intent(T2_stjsActivity.this, T2_stwcendActivity.class);
					Bundle bundle = new Bundle();
					bundle.putCharSequence("rid", rid);

					intent.putExtras(bundle);
					startActivity(intent);	
				}
				else
					Toast.makeText(T2_stjsActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.finishedTeach_path, map, MyPath.getSessionid());
	}
}
