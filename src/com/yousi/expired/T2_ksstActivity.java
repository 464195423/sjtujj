package com.yousi.expired;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.sjtujj.R;
import com.yousi.sjtujj.T2_ddxxActivity;
import com.yousi.sjtujj.T2_stsjActivity;
import com.yousi.sjtujj.R.id;
import com.yousi.sjtujj.R.layout;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class T2_ksstActivity extends Activity {
private TextView tv;
private String rid = "";
private String time = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_ksst);
		
		rid = getIntent().getExtras().getString("rid");
		
		//获取时间
		getData();
		
		//去授课按钮
		Button bt = (Button)findViewById(R.id.t2_ksst_qushouke);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_ksstActivity.this).create();
				alert.setMessage("您将要进行试听授课，请确认！");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO
						postData();
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

		//修改时间与订单详情
        TextView tv1 = (TextView)findViewById(R.id.t2_ksst_tv1);
        TextView tv2 = (TextView)findViewById(R.id.t2_ksst_tv2);
        
        tv1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_ksstActivity.this, T2_stsjActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				bundle.putCharSequence("time", time);
				intent.putExtras(bundle);
				startActivity(intent);	
				finish();
			}
		});
        
        tv2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_ksstActivity.this, T2_ddxxActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				intent.putExtras(bundle);
				startActivity(intent);	
			}
		});
		
      //左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_ksst_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}
	
	
	
	private void postData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//TODO
					Intent intent = new Intent(T2_ksstActivity.this, T2_stskzActivity.class);
					Bundle bundle = new Bundle();
					bundle.putCharSequence("rid", rid);

					intent.putExtras(bundle);
					startActivity(intent);	
					finish();
				}
				else if (code.equals("550")) {
					AlertDialog alert = new AlertDialog.Builder(T2_ksstActivity.this).create();
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
		}, MyPath.qushouke_path, map, DB.getSessionid(T2_ksstActivity.this));
	}
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(T2_ksstActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					TextView tv = (TextView)findViewById(R.id.t2_ksst_tv);
					tv.setText("约定授课时间："+data1.getString("listen_time"));
					time = data1.getString("listen_time");
				}
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.getListenTime_path, map, DB.getSessionid(T2_ksstActivity.this));
	}
}

