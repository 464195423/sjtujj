package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class T3_yjfkActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t3_yjfk);
		
		//意见反馈（未完成）
		Button bt = (Button)findViewById(R.id.t3_yjfk_submit);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//finish();
				PostData();
			}
		});
		
		//左上返回键
		LinearLayout ll_up = (LinearLayout)findViewById(R.id.t3_yjfk_up);
        ll_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});		
	}
	
	private void PostData(){
		EditText et = (EditText)findViewById(R.id.t3_yjfk_et);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("member", DB.getTid(T3_yjfkActivity.this));
		map.put("type", "teacher");
		map.put("content", et.getText().toString());
		MyHttpClient.doPost2(T3_yjfkActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
					AlertDialog alert = new AlertDialog.Builder(T3_yjfkActivity.this).create();
					alert.setTitle("提示");
					alert.setMessage("意见反馈成功，将返回上一级页面");
					alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							finish();
						}
					});
					alert.show();
				}
				else
					Toast.makeText(T3_yjfkActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.makeUserFeedback_path, map, DB.getSessionid(T3_yjfkActivity.this));		
	}
}
