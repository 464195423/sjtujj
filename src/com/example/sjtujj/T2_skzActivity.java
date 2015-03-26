package com.example.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T2_skzActivity extends Activity {
private String rid = "";
private T2_t7_getTeachHours_net T2_t7_getTeachHours_netItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_skz);
		
		rid = getIntent().getExtras().getString("rid");
		
		//获取teachhours
		getData();
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_skz_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
        
        //取消授课和授课结束按钮
        Button bt1 = (Button)findViewById(R.id.t2_skz_bt1);
        Button bt2 = (Button)findViewById(R.id.t2_skz_bt2);
        
        bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_skzActivity.this).create();
				alert.setMessage("取消授课前请与家长进行沟通联系，否则取消家教资格");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						quxiaoshouke();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//do_nothing
					}
				});	
				alert.show();
			}
		});
        
        bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_skzActivity.this, T2_skjsActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				bundle.putCharSequence("teachhours", T2_t7_getTeachHours_netItems.getHours());

				intent.putExtras(bundle);
				startActivity(intent);				
			}
		});
        
        //修改授课时长和订单详情
        TextView tv1 = (TextView)findViewById(R.id.t2_skz_tv1);
        TextView tv2 = (TextView)findViewById(R.id.t2_skz_tv2);
        
        tv1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_skzActivity.this, T2_xgsksjActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				bundle.putCharSequence("hours", T2_t7_getTeachHours_netItems.getHours());
				intent.putExtras(bundle);
				startActivity(intent);	
				finish();
			}
		});
        
        tv2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_skzActivity.this, T2_ddxxActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				intent.putExtras(bundle);
				startActivity(intent);	
			}
		});
        
	}
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(T2_skzActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					T2_t7_getTeachHours_netItems = JSONObject.parseObject(data1.toString(), T2_t7_getTeachHours_net.class);	
					TextView tv = (TextView)findViewById(R.id.t2_skz_teachhours);
					tv.setText("您将要进行"+T2_t7_getTeachHours_netItems.getHours()+"小时的授课");
				}
				else
					Toast.makeText(T2_skzActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.T3_getTeachHours, map, MyPath.getSessionid());
	}	
	
	private void quxiaoshouke(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(T2_skzActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
					finish();
				}
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.quxiaoshouke_path, map, MyPath.getSessionid());		
		
	}
}
