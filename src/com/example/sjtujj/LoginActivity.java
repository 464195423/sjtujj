package com.example.sjtujj;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
private EditText user;
private EditText passwd;
private String result="";
private Handler handler;
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
				// login
				new Thread(new Runnable(){
					public void run(){
						login();
						Message m = handler.obtainMessage();
						handler.sendMessage(m);
					}
				}).start();
			}
			
		});
		
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				parseJsonlogin_net(result);					
				Log.v("DemandId",Login_netItems.getDemandId());
				Log.v("group",Login_netItems.getGroup());
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("demandId", Login_netItems.getDemandId());
				bundle.putString("group", Login_netItems.getGroup());
				bundle.putString("school", Login_netItems.getSchool());
				bundle.putString("sessionid", Login_netItems.getSessionid());
				bundle.putString("tid", Login_netItems.getTid());
				bundle.putString("tname", Login_netItems.getTname());
				bundle.putString("tpicture", Login_netItems.getTpicture());
				startActivity(intent);
				finish();
				super.handleMessage(msg);
			}
		};
	}

	
	public void login(){
		String target = "http://172.16.3.141:8802/TeacherCenterInterface/teacherlogin";
		URL url;
		try {
			url = new URL(target);
			HttpURLConnection urlConn = (HttpURLConnection) url
					.openConnection(); // ����һ��HTTP����
			urlConn.setRequestMethod("POST"); // ָ��ʹ��POST����ʽ
			urlConn.setDoInput(true); // ��������д������
			urlConn.setDoOutput(true); // �������ж�ȡ����
			urlConn.setUseCaches(false); // ��ֹ����
			urlConn.setInstanceFollowRedirects(true);	//�Զ�ִ��HTTP�ض���
			//urlConn.setRequestProperty("Content-Type",
			//		"application/x-www-form-urlencoded"); // ������������
			DataOutputStream out = new DataOutputStream(
					urlConn.getOutputStream()); // ��ȡ�����
			String param = "name="
					+ URLEncoder.encode(user.getText().toString(), "utf-8")
					+ "&pwd="
					+ URLEncoder.encode(passwd.getText().toString(), "utf-8");	//����Ҫ�ύ������
			//String param = "name="+user.toString()+"&pwd"+passwd.toString();
							
			out.writeBytes(param);//��Ҫ���ݵ�����д�����������
			out.flush();	//�������
			out.close();	//�ر����������
			// �ж��Ƿ���Ӧ�ɹ�
			if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStreamReader in = new InputStreamReader(
						urlConn.getInputStream()); // ��ö�ȡ������
				BufferedReader buffer = new BufferedReader(in); // ��ȡ����������
				String inputLine = null;
				while ((inputLine = buffer.readLine()) != null) {
					result += inputLine + "\n";
				}
				in.close();	//�ر��ַ�������
			}	
			urlConn.disconnect();	//�Ͽ�����

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static Login_net parseJsonlogin_net(String json) {
		Login_netItems = null;
		JSONObject jsonObject = JSONObject.parseObject(json);
//		JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
		String code = jsonObject.getString("code");
		if (code.equals("200")) {
			/*
			JSONArray dataArray = jsonObject.getJSONArray("data");
			Log.v("a","a");
			if (dataArray != null) {
				Login_netItems = JSONArray.parseArray(dataArray.toString(),
						Login_net.class);
			}else{
				return null;
			}
			*/
			JSONObject data1 = jsonObject.getJSONObject("data");
			Login_netItems = JSONObject.parseObject(data1.toString(), Login_net.class);		
		}
		return Login_netItems;
	}	
	
}
