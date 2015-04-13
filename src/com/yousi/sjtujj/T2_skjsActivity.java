package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T2_skjsActivity extends Activity {
private String rid;
private String teachhours;
private int shichang = 0;
private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_skjs);
		
		rid = getIntent().getExtras().getString("rid");
		teachhours = getIntent().getExtras().getString("teachhours");
		
		tv = (TextView)findViewById(R.id.t2_skjs_shoukeshichang);
		tv.setText(teachhours);
		
		shichang = Integer.parseInt(teachhours);
		
		//设置授课时长按钮
		ImageView iv1 = (ImageView)findViewById(R.id.t2_skjs_plus);
		ImageView iv2 = (ImageView)findViewById(R.id.t2_skjs_minus);
		
		
		iv1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 边界值判定
				if (shichang >= Integer.parseInt(teachhours))
					shichang = Integer.parseInt(teachhours);
				else
					shichang ++;
				tv.setText(String.valueOf(shichang));
			}			
		});
		iv2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (shichang <= 1)
					shichang = 1;
				else
					shichang --;
				tv.setText(String.valueOf(shichang));
			}			
		});			
		
		//确认完成
		Button bt = (Button)findViewById(R.id.t2_skjs_bt);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PostData();
			}
		});
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_skjs_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}
	
	private void PostData(){
		EditText et = (EditText)findViewById(R.id.t2_skjs_et);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("hours", String.valueOf(shichang));
		map.put("safe_code", et.getText().toString());
		
		MyHttpClient.doPost2(T2_skjsActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				Log.v("json", json);
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					
					Intent intent = new Intent(T2_skjsActivity.this, T2_skwcendActivity.class);
					Bundle bundle = new Bundle();
					bundle.putCharSequence("rid", rid);
					bundle.putCharSequence("hours", String.valueOf(shichang));
					
					intent.putExtras(bundle);					
					startActivity(intent);	
				}
				else
					Toast.makeText(T2_skjsActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.finishedTeach_path, map, DB.getSessionid(T2_skjsActivity.this));
	}
}
