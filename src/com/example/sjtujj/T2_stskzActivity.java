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
import android.widget.Toast;

public class T2_stskzActivity extends Activity {
private String rid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_stskz);
		
		rid = getIntent().getExtras().getString("rid");
		
		//���Ϸ��ؼ�
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_stskz_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        //ȡ���ڿκ��ڿν�����ť
        Button bt1 = (Button)findViewById(R.id.t2_stskz_bt1);
        Button bt2 = (Button)findViewById(R.id.t2_stskz_bt2);
        
        bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_stskzActivity.this).create();
				alert.setMessage("ȡ���ڿ�ǰ����ҳ����й�ͨ��ϵ������ȡ���ҽ��ʸ�");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						quxiaoshouke();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"ȡ��", new OnClickListener() {
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
				Intent intent = new Intent(T2_stskzActivity.this, T2_stjsActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);

				intent.putExtras(bundle);
				startActivity(intent);				
			}
		});
        
        //���������Ͷ�������
        TextView tv1 = (TextView)findViewById(R.id.t2_stskz_tv1);
        TextView tv2 = (TextView)findViewById(R.id.t2_stskz_tv2);
        
        tv1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_stskzActivity.this).create();
				alert.setTitle("��ʾ��Ϣ");
				alert.setMessage("����Ȩ��������������ҳ���ͨ���ɼҳ�������վ��̨��������");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//do_nothing
					}
				});
				alert.show();
			}
		});
        
        tv2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_stskzActivity.this, T2_ddxxActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				intent.putExtras(bundle);
				startActivity(intent);	
			}
		});
	}
	
	private void quxiaoshouke(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(T2_stskzActivity.this, new NetRespondPost() {
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
					Toast.makeText(T2_stskzActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.quxiaoshouke_path, map, MyPath.getSessionid());		
		
	}
}
