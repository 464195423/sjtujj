package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.util.DB;
import com.yousi.util.MyPath;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class T2_nksstActivity extends FragmentActivity {
private String rid = "";
private String time = "";
private NddxxFragment fragment1;
private FragmentManager fragmentManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_nksst);
		
		rid = getIntent().getExtras().getString("rid");
		
		//获取时间
		getData();
		
		//去授课按钮
		Button bt1 = (Button)findViewById(R.id.t2_nksst_bt1);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_nksstActivity.this).create();
				alert.setMessage("您将要进行试听授课，请确认！");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO
						PostData();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//DONOTHING
					}
				});	
				alert.show();
			}
		});
		
		//修改时间与放弃试教
        Button bt2 = (Button)findViewById(R.id.t2_nksst_bt2);
        //Button bt3 = (Button)findViewById(R.id.t2_nksst_bt3);//TODO
        
        bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_nksstActivity.this, T2_stsjActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				bundle.putCharSequence("time", time);
				intent.putExtras(bundle);
				startActivity(intent);	
				finish();
			}
		});
		
		//fragment
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	
        fragment1 = NddxxFragment.newInstance(rid);
        fragmentTransaction.replace(R.id.t2_nksst_container,fragment1);//将fragment1设置到布局上
        fragmentTransaction.commit();
		
	    //左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_nksst_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	private void PostData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//TODO，跳转到授课页面
					finish();
				}
				else if (code.equals("550")) {
					AlertDialog alert = new AlertDialog.Builder(T2_nksstActivity.this).create();
					alert.setMessage(jsonObject.getString("desc"));
					alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						//DONOTING
						}
					});
					alert.show();
				}	

			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.qushouke_path, map, DB.getSessionid(T2_nksstActivity.this));
	}
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(T2_nksstActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					time = data1.getString("listen_time");
				}
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.getListenTime_path, map, DB.getSessionid(T2_nksstActivity.this));
	}
}
