package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T2_xgsksjActivity extends Activity {
private int shichang = 0;
private TextView tv;
private String rid = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_xgsksj);
		
		rid = getIntent().getExtras().getString("rid");
		shichang = Integer.parseInt(getIntent().getExtras().getString("hours"));
		
		
		//设置授课时长
		tv = (TextView)findViewById(R.id.t2_xgsksj_shoukeshichang);
		
		tv.setText(String.valueOf(shichang));
		
		ImageView iv1 = (ImageView)findViewById(R.id.t2_xgsksj_plus);
		ImageView iv2 = (ImageView)findViewById(R.id.t2_xgsksj_minus);
		
		
		iv1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 边界值判定
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
		
		//确定
		Button bt = (Button)findViewById(R.id.t2_xgsksj_queding);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(T2_xgsksjActivity.this).create();
				alert.setTitle("注意");
				alert.setMessage("确保你修改授课时间前已联系过家长！");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						xiugai();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//do_nothing
					}
				});	
				alert.show();
			}
		});
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_xgsksj_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	private void xiugai(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("hours", String.valueOf(shichang));
		MyHttpClient.doPost2(T2_xgsksjActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
					finish();
				}
				else
					Toast.makeText(T2_xgsksjActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.updateTeachHours_path, map, DB.getSessionid(T2_xgsksjActivity.this));	
	}
}
