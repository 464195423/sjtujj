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
				alert.setTitle("��ʾ");
				alert.setMessage("���Ƿ�ȷ��Ҫ���ܸö���?");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO ������Ӵ˶���
					Toast.makeText(getApplicationContext(), "�ѽӵ��ɹ�", Toast.LENGTH_LONG).show();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"ȡ��", new OnClickListener() {
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
