package com.example.sjtujj;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
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
private String result;
private Handler handler;
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
				if (result != null) {
					Log.v("result = ", result);
				}
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
			//String param = "name="
			//		+ URLEncoder.encode(user.toString(), "utf-8")
			//		+ "&pwd="
			//		+ URLEncoder.encode(passwd.toString(), "utf-8");	//����Ҫ�ύ������
			String param = "name="+user.toString()+"&pwd"+passwd.toString();
						

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
			Log.v("result = ", result);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
