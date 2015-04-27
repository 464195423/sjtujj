package com.yousi.sjtujj;

import com.yousi.util.Switch_pager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class T2_nstskzActivity extends FragmentActivity {
private String rid = "";
private Nddxx2Fragment fragment1;
private FragmentManager fragmentManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_nstskz);
		
		rid = getIntent().getExtras().getString("rid");
		
		//fragment
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	
		fragment1 = Nddxx2Fragment.newInstance(rid);
		fragmentTransaction.replace(R.id.t2_nstskz_container,fragment1);//将fragment1设置到布局上
		fragmentTransaction.commit();
				
		//左上返回键
		LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_nstskz_up);
		lv_up.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		//确认结课
		Button bt1 = (Button)findViewById(R.id.t2_nstskz_bt1);
		bt1.setOnClickListener(new View.OnClickListener() {
							
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//跳转页面
				if (mSwitch != null)
					mSwitch.switch_pager(2);
				finish();
			}
		});
		
		//取消试教
		Button bt2 = (Button)findViewById(R.id.t2_nstskz_bt1);
		
		
	}
	
	private static Switch_pager mSwitch=null;
	public static void setCallback(Switch_pager callback){
		if (callback != null)
			mSwitch = callback;
	}
}
