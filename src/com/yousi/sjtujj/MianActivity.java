package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yousi.net.ApplyRecord;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MianActivity extends Activity {
	private ListView ll_tixian;
	private List<ApplyRecord> datas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);

		ll_tixian = (ListView) findViewById(R.id.ll_tixian);
		
		GetData();
		
		
	}
		
	
	public List<ApplyRecord> paserJson(String json){
		List<ApplyRecord> applyRecords = null;
		JSONObject object = JSONObject.parseObject(json);
		String code = object.getString("code");
		if (code.equals("200")) {
			JSONArray data = object.getJSONArray("data");
			applyRecords = JSONArray.parseArray(data.toString(), ApplyRecord.class);
		}
		return applyRecords;
	}
	
	
	private void GetData(){
		HashMap<String, String> map = new HashMap<String, String>();
		MyHttpClient.doGet2(this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				datas = paserJson(json);
				ll_tixian.setAdapter(new MyAdapter(MianActivity.this,datas));
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.applylist_path, map, DB.getSessionid(this));		
	}
}

class MyAdapter extends BaseAdapter {
	private Context context;
	private List<ApplyRecord> datas;

	public MyAdapter(Context context, List<ApplyRecord> datas) {
		this.context = context;
		this.datas = datas;
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ApplyRecord record = datas.get(position);
		MyHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.ll_item_tx, arg2, false);
			holder = new MyHolder();
			holder.tv_txdh_dh = (TextView) convertView
					.findViewById(R.id.tv_txdh_dh);
			holder.tv_txdh_time = (TextView) convertView
					.findViewById(R.id.tv_txdh_time);
			holder.tv_txje = (TextView) convertView.findViewById(R.id.tv_txje);
			holder.tv_txzh_acc = (TextView) convertView
					.findViewById(R.id.tv_txzh_acc);
			holder.tv_txzh_name = (TextView) convertView
					.findViewById(R.id.tv_txzh_name);
			holder.iv_txzh_icon = (ImageView) convertView
					.findViewById(R.id.iv_txzh_icon);
			convertView.setTag(holder);
		} else {
			holder = (MyHolder) convertView.getTag();
		}
		holder.tv_txdh_dh.setText(record.getId());
		holder.tv_txdh_time.setText(record.getTime());
		holder.tv_txje.setText(record.getAmount());
		holder.tv_txzh_acc.setText(record.getAccount());
		holder.tv_txzh_name.setText(record.getName());
		String bankName = record.getBankname();
		int resourceId;
		if (bankName != null)
		
			switch (bankName) {
			case "Ö§¸¶±¦":
				resourceId = R.drawable.ic_launcher;
				break;
	
			default:
				resourceId = R.drawable.ic_launcher;
				break;
			}
		else
			resourceId = R.drawable.ic_launcher;
		holder.iv_txzh_icon.setImageResource(resourceId);;
		return convertView;
	}

	class MyHolder {
		private TextView tv_txdh_dh;
		private TextView tv_txdh_time;
		private TextView tv_txje;
		private TextView tv_txzh_acc;
		private TextView tv_txzh_name;
		private ImageView iv_txzh_icon;
	}
}