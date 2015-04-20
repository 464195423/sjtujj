package com.yousi.sjtujj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.yousi.expired.T2_yjddActivity;
import com.yousi.net.T1_net;
import com.yousi.net.T2_net;
import com.yousi.net.T3_1net;
import com.yousi.net.T3_2net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class T3nFragment extends Fragment implements OnRefreshListener2<ListView>, OnRefreshListener<ExpandableListView>{
private TextView tv1;
private TextView tv2;
private int type = 1;
private PullToRefreshListView lv1; 
private PullToRefreshExpandableListView lv2; 
private List<T3_1net> T3_1net_Items1;
private List<T3_2net> T3_2net_Items2;
private T3_1adapter adapter1 = null;
private T3_2adapter adapter2 = null;
private static boolean flag = true;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_nt3, container, false);
		
		tv1 = (TextView)rootView.findViewById(R.id.t3_tv1);
		tv2 = (TextView)rootView.findViewById(R.id.t3_tv2);

		tv1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (type != 1)
				{				
					type = 1;

					if (adapter1 == null)
						getDataResource();
					show(type);
				}
			}		
		});
		tv2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (type != 2)
				{				
					type = 2;
					
					if (adapter2 == null)
						getDataResource();
					show(type);
				}
			}		
		});	
		
		lv1 = (PullToRefreshListView)rootView.findViewById(R.id.t3_lv1);  
		  
        lv1.setMode(Mode.PULL_DOWN_TO_REFRESH);
		lv1.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
		lv1.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
		lv1.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
		lv1.setOnRefreshListener(this);
		lv1.setDividerPadding(10);
		lv1.getRefreshableView().setDividerHeight(0);

		lv2 = (PullToRefreshExpandableListView)rootView.findViewById(R.id.t3_lv2);  
        lv2.setMode(Mode.PULL_DOWN_TO_REFRESH);
		lv2.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
		lv2.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
		lv2.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
		lv2.setOnRefreshListener(this);
		lv2.setDividerPadding(10);
		lv2.getRefreshableView().setDividerHeight(0);
				
		if (adapter1 != null)
			lv1.setAdapter(adapter1);
		if (adapter2 != null)
			lv2.getRefreshableView().setAdapter(adapter2);

	
		if (flag){
			getDataResource("wait");
			flag = false;
		}
		
		show(type);
		return rootView;
	}
	
	
	//getDataResourse
	private void getDataResource(){
		switch (type){
    	case 1:
    		getDataResource("wait");
    		break;
    	case 2:
    		getDataResource("list");
    		break;
    	}
	}
	
	
	
	private void getDataResource(final String status){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("type", status);
		MyHttpClient.doGet2(getActivity(), new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					if (status.equals("wait")){
						T3_1net_Items1 = parseJsonT3_1netItem(json);
	    				adapter1 = new T3_1adapter(getActivity(), T3_1net_Items1);
	    				lv1.setAdapter(adapter1);
	    				lv1.onRefreshComplete();
					}
					else{
						T3_2net_Items2 = parseJsonT3_2netItem(json);
	    				adapter2 = new T3_2adapter(getActivity(), T3_2net_Items2);
	    				lv2.getRefreshableView().setAdapter(adapter2);
	    				if (lv2.getRefreshableView().getCount() != 0)
	    					lv2.getRefreshableView().expandGroup(0);
	    				lv2.onRefreshComplete();
					}
				}
				else
					Toast.makeText(getActivity(), jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.course_path, map, DB.getSessionid(getActivity()));		
	}
	
	public List<T3_1net> parseJsonT3_1netItem(String json) {
		List<T3_1net> T3_1netItems = null;
		JSONObject jsonObject = JSONObject.parseObject(json);
		String code = jsonObject.getString("code");
		if (code.equals("200")) {
			JSONArray dataArray = jsonObject.getJSONArray("data");
			if (dataArray != null) {
				T3_1netItems = JSONArray.parseArray(dataArray.toString(),
						T3_1net.class);
			}else{
				return null;
			}
		}
		return T3_1netItems;
	}	

	public List<T3_2net> parseJsonT3_2netItem(String json) {
		List<T3_2net> T3_2netItems = null;
		JSONObject jsonObject = JSONObject.parseObject(json);
		String code = jsonObject.getString("code");
		if (code.equals("200")) {
			JSONArray dataArray = jsonObject.getJSONArray("data");
			if (dataArray != null) {
				T3_2netItems = JSONArray.parseArray(dataArray.toString(),
						T3_2net.class);
			}else{
				return null;
			}
		}
		return T3_2netItems;
	}
	
	//show
	private void show(int n){
		switch (n){
		case 1:
			show("wait");
			break;
		case 2:
			show("list");
			break;
		}
	}
	
	
	private void show(String status){
		if (status.equals("wait")){
			if (lv1.getRefreshableView().getAdapter() == null)
				getDataResource(status);
			lv1.setVisibility(View.VISIBLE);
			lv2.setVisibility(View.GONE);
			lv1.onRefreshComplete();	
		}
		else if (status.equals("list")){
			if (lv2.getRefreshableView().getAdapter() == null)
				getDataResource(status);
			lv2.setVisibility(View.VISIBLE);
			lv1.setVisibility(View.GONE);
			lv2.onRefreshComplete();		
		}
	}


	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		getDataResource();
	}


	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
		// TODO Auto-generated method stub
		
	}
}
