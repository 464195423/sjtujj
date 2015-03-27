package com.example.sjtujj;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class T4Activity extends Activity {
private ImageView iv1;
private ImageView iv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t4);

		iv1 = (ImageView)findViewById(R.id.iv1);
		iv1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(T4Activity.this, T4_zxggActivity.class);
				startActivity(intent);
			}
			
		});
		
		iv2 = (ImageView)findViewById(R.id.iv2);
		iv2.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T4Activity.this).create();
				alert.setTitle("��ʾ��Ϣ");
				alert.setMessage("���ܿ�����");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				alert.show();
			}
			
		});
	}
}
