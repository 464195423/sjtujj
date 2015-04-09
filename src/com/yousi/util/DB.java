package com.yousi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class DB {
	public static String getSessionid(Context content) {
		SharedPreferences share = content.getSharedPreferences("sjtujj",Context.MODE_WORLD_READABLE);
		String str=share.getString("sessionid","");
		return str;
	}
	public static String getTid(Context content) {
		SharedPreferences share = content.getSharedPreferences("sjtujj",Context.MODE_WORLD_READABLE);
		String str=share.getString("tid","");
		return str;
	}
	public static String getGroup(Context content) {
		SharedPreferences share = content.getSharedPreferences("sjtujj",Context.MODE_WORLD_READABLE);
		String str=share.getString("group","");
		return str;
	}
	public static String getSchool(Context content) {
		SharedPreferences share = content.getSharedPreferences("sjtujj",Context.MODE_WORLD_READABLE);
		String str=share.getString("school","");
		return str;
	}
	public static void setSessionid(Context content, String sessionid) {
		SharedPreferences share = content.getSharedPreferences("sjtujj",Context.MODE_PRIVATE);
		Editor editor = share.edit();//获取编辑器
		editor.putString("sessionid", sessionid);
		editor.commit();
	}
	public static void setTid(Context content, String tid) {
		SharedPreferences share = content.getSharedPreferences("sjtujj",Context.MODE_PRIVATE);
		Editor editor = share.edit();//获取编辑器
		editor.putString("tid", tid);
		editor.commit();
	}
	public static void setGroup(Context content, String group) {
		SharedPreferences share = content.getSharedPreferences("sjtujj",Context.MODE_PRIVATE);
		Editor editor = share.edit();//获取编辑器
		editor.putString("group", group);
		editor.commit();
	}
	public static void setSchool(Context content, String school) {
		SharedPreferences share = content.getSharedPreferences("sjtujj",Context.MODE_PRIVATE);
		Editor editor = share.edit();//获取编辑器
		editor.putString("school", school);
		editor.commit();
	}
}
