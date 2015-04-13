package com.yousi.sjtujj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.yousi.net.T1_demand_net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;

public class T1Fragment extends Fragment implements OnRefreshListener2<ListView>{
private List<String> list;  
private PullToRefreshListView lv;  
private T1_adapter adapter;  
private List<T1_demand_net> T1_demand_netItems;  
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_t1, container, false);

		Spinner sp1 = (Spinner)rootView.findViewById(R.id.t1_sp1);
		Spinner sp2 = (Spinner)rootView.findViewById(R.id.t1_sp2);
		Spinner sp3 = (Spinner)rootView.findViewById(R.id.t1_sp3);
		Spinner sp4 = (Spinner)rootView.findViewById(R.id.t1_sp4);
		
		List<String> ls1 = new ArrayList<String>();
		ls1.add("aaa");
		ls1.add("bbb");
		
		sp1.setAdapter(new T1_sp_adapter(getActivity(), ls1));
		sp2.setAdapter(new T1_sp_adapter(getActivity(), ls1));
		sp3.setAdapter(new T1_sp_adapter(getActivity(), ls1));
		sp4.setAdapter(new T1_sp_adapter(getActivity(), ls1));
		
        lv = (PullToRefreshListView)rootView.findViewById(R.id.t1_lv);  
  
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
				Intent intent = new Intent(getActivity(), T1_ddxxActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("rid", T1_demand_netItems.get(position).getR_id());
				intent.putExtras(bundle);
				//startActivity(intent);
				startActivityForResult(intent, 0);
			}

		});
        
        TextView tv = (TextView)rootView.findViewById(R.id.t1_tv);
        lv.setEmptyView(tv);
        
        if (adapter != null)
        	lv.setAdapter(adapter);
        else
        	getDataResource();

		return rootView; 
	}
  
	

//    	加载数据源
    	private void getDataResource(){
    		HashMap<String, String> map = new HashMap<String, String>();
    		map.put("id", "1");
    		map.put("grade", "0");
    		map.put("subject", "0");
    		map.put("order", "0");
    		MyHttpClient.doPost2(getActivity(), new NetRespondPost() {
    			@Override
    			public void netWorkOk(String json) {
    				T1_demand_netItems = parseJsonT1_demand_netItem(json);
    				adapter = new T1_adapter(getActivity(), T1_demand_netItems);
    				//adapter.notifyDataSetChanged();
    				lv.setAdapter(adapter);
    				adapter.notifyDataSetChanged();
    				lv.onRefreshComplete();
    			}
    			@Override
    			public void netWorkError() {
    			}
    		}, MyPath.demand_path, map, DB.getSessionid(getActivity()));
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
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
			Log.v("T1","return");
			getDataResource();
		}


}