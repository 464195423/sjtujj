package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yousi.net.Info_net;
import com.yousi.util.DB;
import com.yousi.util.MyPath;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class T4_zxggActivity extends Activity {
private String tid = "";
private List<Info_net> Info_netitems;
private Info_adapter adapter;
private ListView lv; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t4_zxgg);
		
		tid = DB.getTid(T4_zxggActivity.this);
		
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
		        
		        //设置长按删除
		        lv.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, final int position, long id) {
						// TODO Auto-generated method stub
						AlertDialog alert = new AlertDialog.Builder(T4_zxggActivity.this).create();
						alert.setTitle("提示");
						alert.setMessage("你将要删除此条消息，请确认！");
						alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								PostData(Info_netitems.get(position).getId());
								//刷新列表
							}
							
						});
						alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
							//do nothing
							}
						});				
						alert.show();
						
						return false;
					}
				});
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.getAnnouncementList_path, map, DB.getSessionid(T4_zxggActivity.this));
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
	
	private void PostData(String id){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		MyHttpClient.doPost2(T4_zxggActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
					getData();
					adapter.notifyDataSetChanged();
				}
				else
					Toast.makeText(T4_zxggActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.deleteMessage_path, map, DB.getSessionid(T4_zxggActivity.this));		
		
	}
}
