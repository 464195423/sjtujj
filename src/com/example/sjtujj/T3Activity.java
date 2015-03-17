package com.example.sjtujj;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class T3Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t3);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();

		//Log.v("tpicture",bundle.getString("tpicture"));
		
		//处理加载用户头像
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ImageView pic = (ImageView)findViewById(R.id.t3_pic);
				try {
					URL picUrl = new URL(getIntent().getExtras().getString("tpicture"));
					Bitmap pngBM = BitmapFactory.decodeStream(picUrl.openStream());
					pic.setImageBitmap(pngBM);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		});
		thread.start();
		
		TextView username = (TextView)findViewById(R.id.t3_username);
		username.setText(bundle.getString("tname"));
		
		
		ImageView iv1 = (ImageView)findViewById(R.id.t3_iv1);
		ImageView iv2 = (ImageView)findViewById(R.id.t3_iv2);
		ImageView iv3 = (ImageView)findViewById(R.id.t3_iv3);
		ImageView iv4 = (ImageView)findViewById(R.id.t3_iv4);
		ImageView iv5 = (ImageView)findViewById(R.id.t3_iv5);
		
		iv2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T3Activity.this).create();
				alert.setTitle("提示消息");
				alert.setMessage("功能开发中,请暂时使用网站提现");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				alert.show();				
			}
		});

		iv3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T3Activity.this, T3_grszActivity.class);
				startActivity(intent);
			}
		});		
		
		
		iv4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T3Activity.this).create();
				alert.setTitle("注意");
				alert.setMessage("你将要注销登录，请确认！");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(T3Activity.this, LoginActivity.class);
					startActivity(intent);
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
