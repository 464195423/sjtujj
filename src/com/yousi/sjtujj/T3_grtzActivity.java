package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class T3_grtzActivity extends Activity {
private String tid = "";
private List<Info_net> Info_netitems;
private Info_adapter adapter;
private ListView lv; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t3_grtz);
		
		tid = DB.getTid(T3_grtzActivity.this);
		
		getData();
		
		//���Ϸ��ؼ�
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t3_grtz_up);
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
				adapter = new Info_adapter(T3_grtzActivity.this, Info_netitems);
				//adapter.notifyDataSetChanged();
				lv = (ListView)findViewById(R.id.t3_grtz_lv);
				lv.setAdapter(adapter);
				
				//���õ���¼�
		        lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						Bundle bundle = new Bundle();
						bundle.putCharSequence("id", Info_netitems.get(position).getId());
						Intent intent = new Intent(T3_grtzActivity.this, T4_xxxqActivity.class);
						intent.putExtras(bundle);
						startActivity(intent);
					}
				});
		        
		        //���ó���ɾ��
		        lv.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, final int position, long id) {
						// TODO Auto-generated method stub
						AlertDialog alert = new AlertDialog.Builder(T3_grtzActivity.this).create();
						alert.setTitle("��ʾ");
						alert.setMessage("�㽫Ҫɾ��������Ϣ����ȷ�ϣ�");
						alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								PostData(Info_netitems.get(position).getId());
								//ˢ���б�
							}
							
						});
						alert.setButton(DialogInterface.BUTTON_NEGATIVE,"ȡ��", new OnClickListener() {
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
		}, MyPath.getNoticeList_path, map, DB.getSessionid(T3_grtzActivity.this));
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
		MyHttpClient.doPost2(T3_grtzActivity.this, new NetRespondPost() {
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
					Toast.makeText(T3_grtzActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.deleteMessage_path, map, DB.getSessionid(T3_grtzActivity.this));		
		
	}
}