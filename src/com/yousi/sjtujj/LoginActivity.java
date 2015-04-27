package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.net.Login_net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
private EditText user;
private EditText passwd;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		user = (EditText)findViewById(R.id.reg_usrname);
		passwd = (EditText)findViewById(R.id.reg_passwd);
		
		user.setText("13941707965");
		passwd.setText("123456");
		
		
		Button login = (Button)findViewById(R.id.reg_login);
		login.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				login();
			}		
		});
		
	}

	private void login(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", user.getText().toString());
		map.put("pwd", passwd.getText().toString());
		MyHttpClient.doPost1(LoginActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);

					startActivity(intent);
					finish();
				}
				else
					Toast.makeText(LoginActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.login_path, map);
	}	
	
}
