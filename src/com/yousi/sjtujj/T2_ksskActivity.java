package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.util.DB;
import com.yousi.util.MyPath;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T2_ksskActivity extends Activity {
private int shichang = 2;
private TextView tv;
private String rid = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_kssk);
		
		rid = getIntent().getExtras().getString("rid");
		//Log.v("rid",rid);
		
		//ȥ�ڿΰ�ť
		Button bt = (Button)findViewById(R.id.t2_kssk_qushouke);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_ksskActivity.this).create();
				alert.setMessage("����Ҫ����ȥ�ڿΣ���ȷ�ϣ�");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//TODO
						getData();
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
		
		
		
		//�����ڿ�ʱ��
		tv = (TextView)findViewById(R.id.t2_shoukeshichang);
		
		ImageView iv1 = (ImageView)findViewById(R.id.t2_plus);
		ImageView iv2 = (ImageView)findViewById(R.id.t2_minus);
		
		
		iv1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO �߽�ֵ�ж�
				shichang ++;
				tv.setText(String.valueOf(shichang));
			}			
		});
		iv2.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				if (shichang <= 1)
					shichang = 1;
				else
					shichang --;
				tv.setText(String.valueOf(shichang));
			}			
		});		
		
		//��ֹ�����붩������
        TextView tv1 = (TextView)findViewById(R.id.t2_kssk_tv1);
        TextView tv2 = (TextView)findViewById(R.id.t2_kssk_tv2);
        
        tv1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_ksskActivity.this).create();
				alert.setTitle("��ʾ��Ϣ");
				alert.setMessage("����Ȩ��������������ҳ���ͨ���ɼҳ�������վ��̨��������");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//do_nothing
					}
				});
				alert.show();
			}
		});
        
        tv2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_ksskActivity.this, T2_ddxxActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				intent.putExtras(bundle);
				startActivity(intent);	
			}
		});
		
		
		
        //���Ϸ��ؼ�
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_kssk_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        //�����ڿμ�¼
        LinearLayout lv_up_right = (LinearLayout)findViewById(R.id.t2_kssk_up_right);
        lv_up_right.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(T2_ksskActivity.this, T2_skjlActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", rid);
				intent.putExtras(bundle);
				startActivity(intent);	
			}
		});
	}
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("hours", Integer.toString(shichang));
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//TODO
					Intent intent = new Intent(T2_ksskActivity.this, T2_skzActivity.class);
					Bundle bundle = new Bundle();
					bundle.putCharSequence("rid", rid);

					intent.putExtras(bundle);
					startActivity(intent);	
					finish();
				}
				else if (code.equals("550")) {
					AlertDialog alert = new AlertDialog.Builder(T2_ksskActivity.this).create();
					alert.setMessage(jsonObject.getString("desc"));
					alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						//DONOTING
						}
					});
					alert.show();
				}	

			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.qushouke_path, map, DB.getSessionid(T2_ksskActivity.this));
	}
}
