package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.yousi.net.Letter_net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class T3_grtzActivity extends Activity implements OnRefreshListener2<ListView> {
private List<Letter_net> Letter_netitems;
private Info_adapter adapter;
private PullToRefreshListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t3_grtz);

		lv = (PullToRefreshListView)findViewById(R.id.t3_grtz_lv);
		
        lv.setMode(Mode.BOTH);
		lv.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
		lv.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
		lv.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
		lv.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载更多");
		lv.getLoadingLayoutProxy(false, true).setReleaseLabel("放开以加载");
		lv.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
		lv.setOnRefreshListener(this);
		lv.setDividerPadding(10);
		lv.getRefreshableView().setDividerHeight(1);
	
		//设置点击事件
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				position--;
				Bundle bundle = new Bundle();
				bundle.putCharSequence("id", Letter_netitems.get(position).getId());
				Intent intent = new Intent(T3_grtzActivity.this, T4_xxxqActivity.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t3_grtz_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

        TextView tv = new TextView(T3_grtzActivity.this);
        tv.setText("暂无消息");
        lv.setEmptyView(tv);
        
        //获取数据
		getData();
	}
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		MyHttpClient.doGet2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				Letter_netitems = parseJsonLetter_netItem(json);
				adapter = new Info_adapter(T3_grtzActivity.this, Letter_netitems);
				//adapter.notifyDataSetChanged();
				lv.setAdapter(adapter);
				lv.onRefreshComplete();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.personalLetters_path, map, DB.getSessionid(T3_grtzActivity.this));
	}

	private void updateData1(){
		HashMap<String, String> map = new HashMap<String, String>();
		if (!Letter_netitems.isEmpty())
			map.put("after", Letter_netitems.get(0).getId());
		MyHttpClient.doGet2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				List<Letter_net> tmp = parseJsonLetter_netItem(json);
				if (tmp != null)
					Letter_netitems.addAll(0, tmp);
				adapter.notifyDataSetChanged();  
				lv.onRefreshComplete();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.personalLetters_path, map, DB.getSessionid(T3_grtzActivity.this));
	}	
	
	private void updateData2(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("before", Letter_netitems.get(Letter_netitems.size()-1).getId());
		MyHttpClient.doGet2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				List<Letter_net> tmp = parseJsonLetter_netItem(json);
				if (tmp != null)
					Letter_netitems.addAll(tmp);
				adapter.notifyDataSetChanged();
				lv.onRefreshComplete();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.personalLetters_path, map, DB.getSessionid(T3_grtzActivity.this));
	}	
	
	public List<Letter_net> parseJsonLetter_netItem(String json) {
		List<Letter_net> Letter_netItems = null;
		JSONObject jsonObject = JSONObject.parseObject(json);
		String code = jsonObject.getString("code");
		if (code.equals("200")) {
			JSONArray dataArray = jsonObject.getJSONArray("data");
			if (dataArray != null) {
				Letter_netItems = JSONArray.parseArray(dataArray.toString(),
						Letter_net.class);
			}else{
				return null;
			}
		}
		return Letter_netItems;
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
