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
			/*
			String param = "name="
					+ URLEncoder.encode(user.getText().toString(), "utf-8")
					+ "&pwd="
					+ URLEncoder.encode(passwd.getText().toString(), "utf-8");	//����Ҫ�ύ������
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
		return result;
	}
}
