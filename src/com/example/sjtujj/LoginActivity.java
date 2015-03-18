package com.example.sjtujj;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
private EditText user;
private EditText passwd;
private static Login_net Login_netItems;
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
		MyHttpClient.doPost1(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					Login_netItems = JSONObject.parseObject(data1.toString(), Login_net.class);		
				}
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("demandId", Login_netItems.getDemandId());
				bundle.putCharSequence("group", Login_netItems.getGroup());
				bundle.putCharSequence("school", Login_netItems.getSchool());
				//bundle.putCharSequence("sessionid", Login_netItems.getSessionid());
				bundle.putCharSequence("tid", Login_netItems.getTid());
				bundle.putCharSequence("tname", Login_netItems.getTname());
				bundle.putCharSequence("tpicture", Login_netItems.getTpicture());
				//Log.v("sessionid",Login_netItems.getSessionid());
				intent.putExtras(bundle);
				startActivity(intent);
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.login_path, map);
	}	
}
