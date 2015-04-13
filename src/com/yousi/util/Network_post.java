package com.yousi.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import android.util.Pair;

public class Network_post {
	public static String url = "http://172.16.3.141:8802/TeacherCenterInterface";
	
	public static String Network_post(String target, List<Pair<String,String>> pr)
	{
		String result = "";
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
			/*
			String param = "name="
					+ URLEncoder.encode(user.getText().toString(), "utf-8")
					+ "&pwd="
					+ URLEncoder.encode(passwd.getText().toString(), "utf-8");	//连接要提交的数据
					*/
			String param = "";
			for (int i = 0; i < pr.size(); i++)
			{
				if (i == 0)
				{
					param += pr.get(i).first;
					param += "=";
					param += pr.get(i).second;
				}
				else
				{
					param += "&";
					param += pr.get(i).first;
					param += "=";
					param += pr.get(i).second;					
				}
				
			}
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
		return result;
	}
}
