package com.example.sjtujj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DdxxActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ddxx);	
		
		Button bt = (Button)findViewById(R.id.ddxx_jieshou);
		bt.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(DdxxActivity.this).create();
				alert.setTitle("提示");
				alert.setMessage("您是否确定要接受该订单?");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO 处理添加此订单
					Toast.makeText(getApplicationContext(), "已接单成功", Toast.LENGTH_LONG).show();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//do nothing
					}
				});	
				alert.show();
			}
			
		});			
		
	}
}
