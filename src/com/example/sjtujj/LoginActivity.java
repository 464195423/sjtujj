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
					.openConnection(); // 创建一个HTTP连接
			urlConn.setRequestMethod("POST"); // 指定使用POST请求方式
			urlConn.setDoInput(true); // 向连接中写入数据
			urlConn.setDoOutput(true); // 从连接中读取数据
			urlConn.setUseCaches(false); // 禁止缓存
			urlConn.setInstanceFollowRedirects(true);	//自动执行HTTP重定向
			//urlConn.setRequestProperty("Content-Type",
			//		"application/x-www-form-urlencoded"); // 设置内容类型
			DataOutputStream out = new DataOutputStream(
					urlConn.getOutputStream()); // 获取输出流
			//String param = "name="
			//		+ URLEncoder.encode(user.toString(), "utf-8")
			//		+ "&pwd="
			//		+ URLEncoder.encode(passwd.toString(), "utf-8");	//连接要提交的数据
			String param = "name="+user.toString()+"&pwd"+passwd.toString();
						

			out.writeBytes(param);//将要传递的数据写入数据输出流
			out.flush();	//输出缓存
			out.close();	//关闭数据输出流
			// 判断是否响应成功
			if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStreamReader in = new InputStreamReader(
						urlConn.getInputStream()); // 获得读取的内容
				BufferedReader buffer = new BufferedReader(in); // 获取输入流对象
				String inputLine = null;
				while ((inputLine = buffer.readLine()) != null) {
					result += inputLine + "\n";
				}
				in.close();	//关闭字符输入流
			}
			urlConn.disconnect();	//断开连接
			Log.v("result = ", result);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
