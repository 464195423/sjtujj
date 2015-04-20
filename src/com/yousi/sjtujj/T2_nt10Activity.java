package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.widget.Toast;

public class T2_nt10Activity extends FragmentActivity {
private String rid;
private Nddxx2Fragment fragment1;
private FragmentManager fragmentManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_nt10);
		
		rid = getIntent().getExtras().getString("rid");	
		
		//fragment
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	
        fragment1 = Nddxx2Fragment.newInstance(rid);
        fragmentTransaction.replace(R.id.t2_nt10_container,fragment1);//��fragment1���õ�������
        fragmentTransaction.commit();
        
        //���Ϸ��ؼ�
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_nt10_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        //ȷ���Խ�ʱ�䡢��������
        Button bt1 = (Button)findViewById(R.id.t2_nt10_bt1);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_nt10Activity.this).create();
				alert.setTitle("ע��");
				alert.setMessage("����Ҫ����������������ȷ�ϣ�");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO
						PostData();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"ȡ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//DONOTHING
					}
				});	
				alert.show();
			}
		});
	}
	
	/* �������� */
	private void PostData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(T2_nt10Activity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					finish();
				}
				else
					Toast.makeText(T2_nt10Activity.this, jsonObject.getString("desc"), Toast.LENGTH_SHORT).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.revokeOrder_path, map, DB.getSessionid(T2_nt10Activity.this));		
	}	
}
