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
		
		//��������û�ͷ��
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
				alert.setTitle("��ʾ��Ϣ");
				alert.setMessage("���ܿ�����,����ʱʹ����վ����");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {

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
				alert.setTitle("ע��");
				alert.setMessage("�㽫Ҫע����¼����ȷ�ϣ�");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(T3Activity.this, LoginActivity.class);
					startActivity(intent);
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
