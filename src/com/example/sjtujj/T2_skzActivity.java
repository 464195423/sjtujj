package com.example.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class T2_skzActivity extends Activity {
private String rid = "";
private T2_t7_getTeachHours_net T2_t7_getTeachHours_netItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_skz);
		
		rid = getIntent().getExtras().getString("rid");
		
		//��ȡteachhours
		getData();
		
		//���Ϸ��ؼ�
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_skz_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
        
        //ȡ���ڿκ��ڿν�����ť
        Button bt1 = (Button)findViewById(R.id.t2_skz_bt1);
        Button bt2 = (Button)findViewById(R.id.t2_skz_bt2);
        
        bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_skzActivity.this).create();
				alert.setMessage("ȡ���ڿ�ǰ����ҳ����й�ͨ��ϵ������ȡ���ҽ��ʸ�");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"ȡ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO	
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
        
        //�޸��ڿ�ʱ���Ͷ�������
        TextView tv1 = (TextView)findViewById(R.id.t2_skz_tv1);
        TextView tv2 = (TextView)findViewById(R.id.t2_skz_tv2);
        
        tv2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_skzActivity.this, T2_ddxqActivity.class);
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
					tv.setText("����Ҫ����"+T2_t7_getTeachHours_netItems.getHours()+"Сʱ���ڿ�");
				}
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.T3_getTeachHours, map, MyPath.getSessionid());
	}	
	
	
}
