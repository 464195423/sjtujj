package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class T4_txActivity extends Activity implements OnRefreshListener2<ListView>{
private PullToRefreshListView ll_tixian;
private MyAdapter adapter;
private List<ApplyRecord> datas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t4_tx);

		ll_tixian = (PullToRefreshListView) findViewById(R.id.ll_tixian);
		
		ll_tixian.setMode(Mode.BOTH);
		ll_tixian.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
		ll_tixian.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
		ll_tixian.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
		ll_tixian.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载更多");
		ll_tixian.getLoadingLayoutProxy(false, true).setReleaseLabel("放开以加载");
		ll_tixian.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
		ll_tixian.setOnRefreshListener(this);
		
		GetData();
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t4_tx_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
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
				adapter = new MyAdapter(T4_txActivity.this,datas);
				ll_tixian.setAdapter(adapter);
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.applylist_path, map, DB.getSessionid(this));		
	}

	private void updateData1(){
		HashMap<String, String> map = new HashMap<String, String>();
		if (!datas.isEmpty())
			map.put("after", datas.get(0).getId());
		MyHttpClient.doGet2(this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				List<ApplyRecord> tmp = paserJson(json);
				if (tmp != null)
					datas.addAll(0, tmp);
				adapter.notifyDataSetChanged();
				ll_tixian.onRefreshComplete();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.applylist_path, map, DB.getSessionid(this));		
	}
	
	private void updateData2(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("before", datas.get(datas.size()-1).getId());
		MyHttpClient.doGet2(this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				List<ApplyRecord> tmp = paserJson(json);
				if (tmp != null)
					datas.addAll(tmp);
				adapter.notifyDataSetChanged();
				ll_tixian.onRefreshComplete();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.applylist_path, map, DB.getSessionid(this));		
	}

	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		updateData1();
	}


	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		updateData2();
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
		return datas == null ? 0 : datas.size();
	}

	@Override
	public Object getItem(int arg0) {
		return datas.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
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
		
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");   
		double d1 = Double.parseDouble(record.getAmount());
		holder.tv_txje.setText(df.format(d1));
		
		holder.tv_txzh_acc.setText(record.getAccount());
		holder.tv_txzh_name.setText(record.getName());
		String bankName = record.getBankname();
		int resourceId;
		if (bankName != null)
		
			switch (bankName) {
			case "支付宝":
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