package com.example.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class T4_zxggActivity extends Activity {
private String tid = "";
private List<Info_net> Info_netitems;
private Info_adapter adapter;
private ListView lv; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t4_zxgg);
		
		tid = MyPath.getTid();
		
		getData();
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t4_zxgg_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
	}
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("tid", tid);
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				Info_netitems = parseJsonInfo_netItem(json);
				adapter = new Info_adapter(T4_zxggActivity.this, Info_netitems);
				//adapter.notifyDataSetChanged();
				lv = (ListView)findViewById(R.id.t4_zxgg_lv);
				lv.setAdapter(adapter);
				
				//设置点击事件
		        lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						Bundle bundle = new Bundle();
						bundle.putCharSequence("id", Info_netitems.get(position).getId());
						Intent intent = new Intent(T4_zxggActivity.this, T4_xxxqActivity.class);
						intent.putExtras(bundle);
						startActivity(intent);
					}
				});
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.getAnnouncementList_path, map, MyPath.getSessionid());
	}
	
	public List<Info_net> parseJsonInfo_netItem(String json) {
		List<Info_net> Info_netItems = null;
		JSONObject jsonObject = JSONObject.parseObject(json);
		String code = jsonObject.getString("code");
		if (code.equals("200")) {
			JSONArray dataArray = jsonObject.getJSONArray("data");
			if (dataArray != null) {
				Info_netItems = JSONArray.parseArray(dataArray.toString(),
						Info_net.class);
			}else{
				return null;
			}
		}
		return Info_netItems;
	}	
}
