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
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T2_nstwcActivity extends FragmentActivity {
private String rid = "";
private String phone = "";
private Nddxx2Fragment fragment1;
private FragmentManager fragmentManager;
private T2_ddxx_net T2_ddxx_netItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_nstwc);
		
		rid = getIntent().getExtras().getString("rid");
		phone = getIntent().getExtras().getString("phone");
		
		//设置电话
        setData();
		
		//fragment
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	
		fragment1 = Nddxx2Fragment.newInstance(rid);
		fragmentTransaction.replace(R.id.t2_nstwc_container,fragment1);//将fragment1设置到布局上
		fragmentTransaction.commit();
				
		//左上返回键
		LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_nstwc_up);
		lv_up.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	private void setData(){
		Button bt1 = (Button)findViewById(R.id.t2_nstwc_bt1);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//用intent启动拨打电话  
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + phone));  
                startActivity(intent); 	
			}
		});
	}
}
