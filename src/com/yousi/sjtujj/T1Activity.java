package com.yousi.sjtujj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yousi.net.T1_demand_net;
import com.yousi.sjtujj.MyListView.OnRefreshListener;
import com.yousi.util.DB;
import com.yousi.util.MyPath;

public class T1Activity extends ListActivity implements OnRefreshListener2<ListView>{
private List<String> list;  
private PullToRefreshListView lv;  
private T1_adapter adapter;  
private List<T1_demand_net> T1_demand_netItems;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t1);

		Bundle bundle = getIntent().getExtras();
		/*
		String demandId = bundle.getString("demandId");
		String group = bundle.getString("group");
		String school = bundle.getString("school");
		String tid = bundle.getString("tid");
		String tname = bundle.getString("tname");
		String tpicture = bundle.getString("tpicture");
		Log.v("school",school);
		*/
		
        lv = (PullToRefreshListView)findViewById(R.id.t1_lv);  
  
        lv.setMode(Mode.BOTH);
		lv.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
		lv.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
		lv.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
		lv.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载更多");
		lv.getLoadingLayoutProxy(false, true).setReleaseLabel("放开以加载");
		lv.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
		lv.setOnRefreshListener(this);
		lv.setDividerPadding(10);
		lv.getRefreshableView().setDividerHeight(0);
		
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				position--;
				Intent intent = new Intent(T1Activity.this, T1_ddxxActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", T1_demand_netItems.get(position).getR_id());
				intent.putExtras(bundle);
				startActivity(intent);
			}

		});
        
        TextView tv = (TextView)findViewById(R.id.t1_tv);
        lv.setEmptyView(tv);
        
		getDataResource();
	}
  
	

//    	加载数据源
    	private void getDataResource(){
    		HashMap<String, String> map = new HashMap<String, String>();
    		map.put("id", "1");
    		map.put("grade", "0");
    		map.put("subject", "0");
    		map.put("order", "0");
    		MyHttpClient.doPost2(null, new NetRespondPost() {
    			@Override
    			public void netWorkOk(String json) {
    				T1_demand_netItems = parseJsonT1_demand_netItem(json);
    				adapter = new T1_adapter(T1Activity.this, T1_demand_netItems);
    				//adapter.notifyDataSetChanged();
    				lv.setAdapter(adapter);
    				lv.onRefreshComplete();
    			}
    			@Override
    			public void netWorkError() {
    			}
    		}, MyPath.demand_path, map, DB.getSessionid(T1Activity.this));
    	}

    	public List<T1_demand_net> parseJsonT1_demand_netItem(String json) {
    		List<T1_demand_net> T1_demand_netItems = null;
    		JSONObject jsonObject = JSONObject.parseObject(json);
    		String code = jsonObject.getString("code");
    		if (code.equals("200")) {
    			JSONArray dataArray = jsonObject.getJSONArray("data");
    			if (dataArray != null) {
    				T1_demand_netItems = JSONArray.parseArray(dataArray.toString(),
    						T1_demand_net.class);
    			}else{
    				return null;
    			}
    		}
    		return T1_demand_netItems;
    	}	
/*
//    	更新数据源
    	private void updateDataResource(){
    		MyHttpClient.getJson(MyPath.QUESTIONLISTPATH, new NetRespondPost() {
    			@Override
    			public void netWorkOk(String json) {
    				questionItems = FastJsonParser.parseJsonQuestionItem(json);
    				adapter.notifyDataSetChanged();
    				mPullRefreshListView.onRefreshComplete();

    			}
    			
    			@Override
    			public void netWorkError() {
    			}
    		}, SessionID);
    	}
*/	
   	
//    	下拉刷新
		@Override
    	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
    		getDataResource();
    	}
//    	上拉加载
		@Override
    	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
    		//updateDataResource();
			lv.onRefreshComplete();
    	}



		@Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			Log.v("T1","resume");
		}

		@Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			Log.v("T1","pause");
		}
}
