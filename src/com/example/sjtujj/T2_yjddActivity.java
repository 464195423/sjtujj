package com.example.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

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
import android.widget.Toast;

public class T2_yjddActivity extends FragmentActivity {
private String rid;
private T2_ddxx_net T2_ddxx_netItems;
private DdxxFragment fragment1;
private FragmentManager fragmentManager;
private Fragment currentFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_yjdd);
		
		rid = getIntent().getExtras().getString("rid");	
		
		//fragment
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	
        fragment1 = DdxxFragment.newInstance(rid);
        fragmentTransaction.replace(R.id.t2_yjdd_container,fragment1);//将fragment1设置到布局上
        fragmentTransaction.commit();
        
        //家长电话
        getData();
        
        
        //接单与拒绝
        Button bt1 = (Button)findViewById(R.id.t2_yjdd_bt1);
        Button bt2 = (Button)findViewById(R.id.t2_yjdd_bt2);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_yjddActivity.this, T2_qdstsjActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});
  
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_yjddActivity.this).create();
				alert.setTitle("注意");
				alert.setMessage("您将要拒绝订单，请确认！");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO
						PostData2();
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
        
        
        
        //左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_yjdd_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		//map.put("pwd", passwd.getText().toString());
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					T2_ddxx_netItems = JSONObject.parseObject(data1.toString(), T2_ddxx_net.class);	
					//Log.v("data1",data1.get("additional_price").toString());
					setData();
				}
				else
					Toast.makeText(T2_yjddActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.ddxx_path, map, MyPath.getSessionid());
	}
	
	private void PostData2(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(T2_yjddActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
					finish();
				}
				else
					Toast.makeText(T2_yjddActivity.this, jsonObject.getString("desc"), Toast.LENGTH_SHORT).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.removeOrder_path, map, MyPath.getSessionid());		
	}
	
	private void setData(){
		TextView tv1 = (TextView)findViewById(R.id.t2_yjdd_tv1);
		TextView tv2 = (TextView)findViewById(R.id.t2_yjdd_tv2);
		tv1.setText(T2_ddxx_netItems.getParentname());
		tv2.setText(T2_ddxx_netItems.getPhone());
		
	}
}
