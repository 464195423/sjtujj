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
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("demandId", Login_netItems.getDemandId());
				bundle.putCharSequence("group", Login_netItems.getGroup());
				bundle.putCharSequence("school", Login_netItems.getSchool());
				bundle.putCharSequence("sessionid", Login_netItems.getSessionid());
				bundle.putCharSequence("tid", Login_netItems.getTid());
				bundle.putCharSequence("tname", Login_netItems.getTname());
				bundle.putCharSequence("tpicture", Login_netItems.getTpicture());
				intent.putExtras(bundle);
				startActivity(intent);
				super.handleMessage(msg);
			}
		};
	}

	
	@SuppressWarnings("null")
	public void login(){
		/*
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
			String param = "name="
					+ URLEncoder.encode(user.getText().toString(), "utf-8")
					+ "&pwd="
					+ URLEncoder.encode(passwd.getText().toString(), "utf-8");	//连接要提交的数据
			//String param = "name="+user.toString()+"&pwd"+passwd.toString();
							
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

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		String target = Network_post.url + "/teacherlogin";
		List<Pair<String, String>> lp = new ArrayList<Pair<String, String>>();
		lp.add(new Pair<String, String>("name",user.getText().toString()));
		lp.add(new Pair<String, String>("pwd",passwd.getText().toString()));
		result = Network_post.Network_post(target, lp);
		
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
