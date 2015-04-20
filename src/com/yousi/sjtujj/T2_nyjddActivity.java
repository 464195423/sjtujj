package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.net.T2_ddxx_net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
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

public class T2_nyjddActivity extends FragmentActivity {
private String rid;
private String phone;
private Nddxx2Fragment fragment1;
private FragmentManager fragmentManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_nyjdd);
		
		rid = getIntent().getExtras().getString("rid");	
		phone = getIntent().getExtras().getString("phone");	
		
		//fragment
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	
        fragment1 = Nddxx2Fragment.newInstance(rid);
        fragmentTransaction.replace(R.id.t2_nyjdd_container,fragment1);//��fragment1���õ�������
        fragmentTransaction.commit();
        
        //���Ϸ��ؼ�
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_nyjdd_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        //ȷ���Խ�ʱ�䡢��������
        Button bt1 = (Button)findViewById(R.id.t2_nyjdd_bt1);
        Button bt2 = (Button)findViewById(R.id.t2_nyjdd_bt2);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_nyjddActivity.this, T2_qdstsjActivity.class);
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
				AlertDialog alert = new AlertDialog.Builder(T2_nyjddActivity.this).create();
				alert.setTitle("ע��");
				alert.setMessage("����Ҫ�ܾ���������ȷ�ϣ�");
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
		
		//���õ绰
       setData();
	}
	
	private void PostData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(T2_nyjddActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
					finish();
				}
				else
					Toast.makeText(T2_nyjddActivity.this, jsonObject.getString("desc"), Toast.LENGTH_SHORT).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.removeOrder_path, map, DB.getSessionid(T2_nyjddActivity.this));		
	}
	

	private void setData(){
		Button bt3 = (Button)findViewById(R.id.t2_nyjdd_bt3);
		bt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//��intent��������绰  
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + phone));  
                startActivity(intent); 	
			}
		});
	}
}
