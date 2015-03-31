package com.example.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class T2_skjlActivity extends Activity {
private ListView lv;  
private T3_skjl_adapter adapter;  
private List<T3_skjl_net> T3_skjl_netItems;  
private String rid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_skjl);
		
		rid = getIntent().getExtras().getString("rid");	
		//rid = "156";
		
		lv = (ListView)findViewById(R.id.t2_skjl_lv);
		TextView tv = (TextView)findViewById(R.id.t2_skjl_tv);
        lv.setEmptyView(tv);
        
		getDataResource();
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t2_skjl_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	
//	加载数据源
	private void getDataResource(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				//Log.v("json",json);
				T3_skjl_netItems = parseJsonT3_skjl_netItem(json);
				adapter = new T3_skjl_adapter(T2_skjlActivity.this, T3_skjl_netItems);
				//adapter.notifyDataSetChanged();
				lv.setAdapter(adapter);
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.teacherReseaseHireList_path, map, MyPath.getSessionid());
	}

	public List<T3_skjl_net> parseJsonT3_skjl_netItem(String json) {
		List<T3_skjl_net> T3_skjl_netItems = null;
		JSONObject jsonObject = JSONObject.parseObject(json);
		String code = jsonObject.getString("code");
		if (code.equals("200")) {
			JSONArray dataArray = jsonObject.getJSONArray("data");
			if (dataArray != null) {
				T3_skjl_netItems = JSONArray.parseArray(dataArray.toString(),
						T3_skjl_net.class);
			}else{
				return null;
			}
		}
		return T3_skjl_netItems;
	}
}
