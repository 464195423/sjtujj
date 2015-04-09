package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.expired.T2_yjddActivity;
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
import android.widget.Toast;

public class T1_ddxxActivity extends FragmentActivity {
private String rid;
private DdxxFragment fragment1;
private FragmentManager fragmentManager;
private Fragment currentFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t1_ddxx);
		
		rid = getIntent().getExtras().getString("rid");	
		
		//fragment
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	
        fragment1 = DdxxFragment.newInstance(rid);
        fragmentTransaction.replace(R.id.t1_ddxx_container,fragment1);//将fragment1设置到布局上
        fragmentTransaction.commit();
        
        
        //接单
        Button bt = (Button)findViewById(R.id.t1_ddxx_bt);
  
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T1_ddxxActivity.this).create();
				alert.setTitle("提示");
				alert.setMessage("您是否确定要接受该订单？");
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
        
        //左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t1_ddxx_up);
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
		MyHttpClient.doPost2(T1_ddxxActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
					//finish();
					Toast.makeText(T1_ddxxActivity.this, "已接单成功！", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(T1_ddxxActivity.this, T2_yjddActivity.class);
					Bundle bundle = new Bundle();
					bundle.putCharSequence("rid", rid);
					intent.putExtras(bundle);
					startActivity(intent);
					finish();
				}
				else
					Toast.makeText(T1_ddxxActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.getOrder_path, map, DB.getSessionid(T1_ddxxActivity.this));		
	}
}
