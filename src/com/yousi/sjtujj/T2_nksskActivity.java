package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;
import com.yousi.util.Switch_pager;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;
import android.widget.NumberPicker.OnValueChangeListener;

public class T2_nksskActivity extends FragmentActivity {
private String rid = "";
private Nddxx2Fragment fragment1;
private FragmentManager fragmentManager;
private int hour = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_nkssk);
		
		rid = getIntent().getExtras().getString("rid");
		
		//fragment
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	
		fragment1 = Nddxx2Fragment.newInstance(rid);
		fragmentTransaction.replace(R.id.t2_nkssk_container,fragment1);//将fragment1设置到布局上
		fragmentTransaction.commit();
				
		//左上返回键
		LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_nkssk_up);
		lv_up.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		//去授课
		Button bt1 = (Button)findViewById(R.id.t2_nkssk_bt1);
		bt1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				LayoutInflater layoutInflater = LayoutInflater.from(T2_nksskActivity.this); 
				View convertView = layoutInflater.inflate(R.layout.number_picker, null, false); 
				
				
				AlertDialog dlg = new AlertDialog.Builder(T2_nksskActivity.this).create();
			
				NumberPicker np = (NumberPicker) convertView.findViewById(R.id.np_np);
				np.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
				np.setMinValue(1);
				np.setMaxValue(24);
				np.setValue(2);
				np.setOnValueChangedListener(new OnValueChangeListener(){

					@Override
					public void onValueChange(NumberPicker picker, int oldVal,
							int newVal) {
						// TODO Auto-generated method stub
						hour = newVal;
					}
					
				});
				dlg.setView(convertView);
				dlg.setTitle("请选择授课时长");
				dlg.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						//DONOTING
					}
				});
				dlg.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						//beginToTeach rid hour
						PostData();
					}
				});
				dlg.show();
				
				
			}
		});
		
		//申请放弃
		Button bt2 = (Button)findViewById(R.id.t2_nkssk_bt2);
		bt2.setOnClickListener(new View.OnClickListener() {
							
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_nksskActivity.this).create();
				alert.setTitle("注意");
				alert.setMessage("您将要申请放弃订单，请确认！");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO
						PostData1();
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
	}

	private void PostData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("hour", String.valueOf(hour));
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					mSwitch.switch_pager(2);
					finish();
				}
				else if (code.equals("550")) {
					AlertDialog alert = new AlertDialog.Builder(T2_nksskActivity.this).create();
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
		}, NewMyPath.beginToTeach_path, map, DB.getSessionid(T2_nksskActivity.this));
	}

	/* 申请放弃 */
	private void PostData1(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(T2_nksskActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					finish();
				}
				else
					Toast.makeText(T2_nksskActivity.this, jsonObject.getString("desc"), Toast.LENGTH_SHORT).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.removeOrder_path, map, DB.getSessionid(T2_nksskActivity.this));		
	}	
	
	
	private static Switch_pager mSwitch=null;
	public static void setCallback(Switch_pager callback){
		if (callback != null)
			mSwitch = callback;
	}
}
