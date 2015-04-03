package com.yousi.sjtujj;

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
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;

public class T2Fragment extends Fragment implements OnRefreshListener2<ListView>{
private TextView tv1;
private TextView tv2;
private TextView tv3;
private int type = 1;
private PullToRefreshListView lv1; 
private PullToRefreshListView lv2; 
private PullToRefreshListView lv3; 
private List<T2_net> T2_net_Items1;
private List<T2_net> T2_net_Items2;
private List<T2_net> T2_net_Items3;
private T2_adapter adapter1 = null;
private T2_adapter adapter2 = null;
private T2_adapter adapter3 = null;
private static boolean flag = true;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	        Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_t2, container, false);
			
		tv1 = (TextView)rootView.findViewById(R.id.t2_quanbu);
		tv2 = (TextView)rootView.findViewById(R.id.t2_shangke);
		tv3 = (TextView)rootView.findViewById(R.id.t2_guoqi);

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
		tv3.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (type != 3)
				{				
					type = 3;
				
					if (adapter3 == null)
						getDataResource();
					show(type);
				}			
			}		
		});
		
		lv1 = (PullToRefreshListView)rootView.findViewById(R.id.t2_lv1);  
		  
        lv1.setMode(Mode.PULL_DOWN_TO_REFRESH);
		lv1.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
		lv1.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
		lv1.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
		lv1.setOnRefreshListener(this);
		lv1.setDividerPadding(10);
		lv1.getRefreshableView().setDividerHeight(0);

		lv2 = (PullToRefreshListView)rootView.findViewById(R.id.t2_lv2);  
		  
        lv2.setMode(Mode.PULL_DOWN_TO_REFRESH);
		lv2.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
		lv2.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
		lv2.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
		lv2.setOnRefreshListener(this);
		lv2.setDividerPadding(10);
		lv2.getRefreshableView().setDividerHeight(0);
		
		lv3 = (PullToRefreshListView)rootView.findViewById(R.id.t2_lv3);  
		  
        lv3.setMode(Mode.PULL_DOWN_TO_REFRESH);
		lv3.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
		lv3.getLoadingLayoutProxy(true, false).setReleaseLabel("放开以刷新");
		lv3.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
		lv3.setOnRefreshListener(this);
		lv3.setDividerPadding(10);
		lv3.getRefreshableView().setDividerHeight(0);

		final AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				position--;
				int typea = getItemViewType(position);
				Intent intent = null;
				Bundle bundle = new Bundle();
				
				switch (type){
				case 1:
					bundle.putCharSequence("rid", T2_net_Items1.get(position).getRid());
					break;
				case 2:
					bundle.putCharSequence("rid", T2_net_Items2.get(position).getRid());
					break;
				case 3:
					bundle.putCharSequence("rid", T2_net_Items3.get(position).getRid());
					break;
				}
				
				switch (typea){
				case 1:
					intent = new Intent(getActivity(), T2_ddxqActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 2:
					intent = new Intent(getActivity(), T2_yjddActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 3:
					intent = new Intent(getActivity(), T2_ksstActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 4:
					intent = new Intent(getActivity(), T2_stskzActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 5:
					intent = new Intent(getActivity(), T2_stwcActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 6:
					break;
				case 7:
					intent = new Intent(getActivity(), T2_skzActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 8:
					intent = new Intent(getActivity(), T2_ksskActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 9:
					break;
					
				}
				
			}
		};
		
		lv1.setOnItemClickListener(listener);
		lv2.setOnItemClickListener(listener);
		lv3.setOnItemClickListener(listener);
		
		if (adapter1 != null)
			lv1.setAdapter(adapter1);
		if (adapter2 != null)
			lv2.setAdapter(adapter2);
		if (adapter3 != null)
			lv3.setAdapter(adapter3);

	
		if (flag){
			getDataResource("0");
			flag = false;
		}
			
		switch (type) {
		case (1):
			show(1);
			break;
		case (2):
			show(2);
			break;
		case (3):
			show(3);
			break;
		}
		
		return rootView; 
	}

	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		List<T2_net> T2_net_Items = null;
		switch (type){
		case 1:
			T2_net_Items = T2_net_Items1;
			break;
		case 2:
			T2_net_Items = T2_net_Items2;
			break;
		case 3:
			T2_net_Items = T2_net_Items3;
			break;
		}
		
		if (T2_net_Items.get(position).getStatus().equals("0"))
			return 1;
		else if (T2_net_Items.get(position).getStatus().equals("1"))
			return 2;
		else if (T2_net_Items.get(position).getStatus().equals("2") && T2_net_Items.get(position).getHire().equals("0"))
			return 3;
		else if (T2_net_Items.get(position).getStatus().equals("2") && T2_net_Items.get(position).getHire().equals("1"))
			return 4;
		else if (T2_net_Items.get(position).getStatus().equals("3"))
			return 5;
		else if (T2_net_Items.get(position).getStatus().equals("4") && T2_net_Items.get(position).getHire().equals("0"))
			return 8;
		else if (T2_net_Items.get(position).getStatus().equals("4") && T2_net_Items.get(position).getHire().equals("1"))
			return 7;
		else if (T2_net_Items.get(position).getStatus().equals("5"))
			return 6;
		else
			return 9;
	}
	
	
	private void getDataResource(){
		switch (type){
    	case 1:
    		getDataResource("0");
    		break;
    	case 2:
    		getDataResource("onclass");
    		break;
    	case 3:
    		getDataResource("close");
    		break;
    	}
	}
	
	
	
	private void getDataResource(final String status){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("status", status);
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				if (status.equals("0")){
					T2_net_Items1 = parseJsonT2_netItem(json);
					adapter1 = new T2_adapter(getActivity(), T2_net_Items1);	
					lv1.setAdapter(adapter1);
					adapter1.notifyDataSetChanged();
				}
				else if (status.equals("onclass")){
					T2_net_Items2 = parseJsonT2_netItem(json);
					adapter2 = new T2_adapter(getActivity(), T2_net_Items2);	
					lv2.setAdapter(adapter2);
					adapter2.notifyDataSetChanged();
				}
				else if (status.equals("close")){
					T2_net_Items3 = parseJsonT2_netItem(json);
					adapter3 = new T2_adapter(getActivity(), T2_net_Items3);	
					lv3.setAdapter(adapter3);
					adapter3.notifyDataSetChanged();
				}
				
				show(status);
				
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.my_demand_path, map, DB.getSessionid(getActivity()));
	}

	private void show(int n){
		switch (n){
		case 1:
			show("0");
			break;
		case 2:
			show("onclass");
			break;
		case 3:
			show("close");
			break;
		}
	}
	
	
	private void show(String status){
		if (status.equals("0")){
			if (lv1.getRefreshableView().getAdapter() == null)
				getDataResource(status);
			lv1.setVisibility(View.VISIBLE);
			lv2.setVisibility(View.GONE);
			lv3.setVisibility(View.GONE);
			lv1.onRefreshComplete();
			tv1.setTextColor(getResources().getColor(R.color.select));
			tv1.setBackgroundColor(getResources().getColor(R.color.background2));
			tv2.setTextColor(getResources().getColor(R.color.unselect));
			tv2.setBackgroundColor(getResources().getColor(R.color.background1));		
			tv3.setTextColor(getResources().getColor(R.color.unselect));
			tv3.setBackgroundColor(getResources().getColor(R.color.background1));
		}
		else if (status.equals("onclass")){
			if (lv2.getRefreshableView().getAdapter() == null)
				getDataResource(status);
			lv2.setVisibility(View.VISIBLE);
			lv1.setVisibility(View.GONE);
			lv3.setVisibility(View.GONE);
			lv2.onRefreshComplete();
			tv2.setTextColor(getResources().getColor(R.color.select));
			tv2.setBackgroundColor(getResources().getColor(R.color.background2));
			tv1.setTextColor(getResources().getColor(R.color.unselect));
			tv1.setBackgroundColor(getResources().getColor(R.color.background1));		
			tv3.setTextColor(getResources().getColor(R.color.unselect));
			tv3.setBackgroundColor(getResources().getColor(R.color.background1));	
		}
		else if (status.equals("close")){
			if (lv3.getRefreshableView().getAdapter() == null)
				getDataResource(status);
			lv3.setVisibility(View.VISIBLE);
			lv2.setVisibility(View.GONE);
			lv1.setVisibility(View.GONE);
			lv3.onRefreshComplete();
			tv3.setTextColor(getResources().getColor(R.color.select));
			tv3.setBackgroundColor(getResources().getColor(R.color.background2));
			tv2.setTextColor(getResources().getColor(R.color.unselect));
			tv2.setBackgroundColor(getResources().getColor(R.color.background1));		
			tv1.setTextColor(getResources().getColor(R.color.unselect));
			tv1.setBackgroundColor(getResources().getColor(R.color.background1));
		}		
		
	}
	
	public List<T2_net> parseJsonT2_netItem(String json) {
		List<T2_net> T2_net_Items = null;
		JSONObject jsonObject = JSONObject.parseObject(json);
		String code = jsonObject.getString("code");
		if (code.equals("200")) {
			JSONArray dataArray = jsonObject.getJSONArray("data");
			if (dataArray != null) {
				T2_net_Items = JSONArray.parseArray(dataArray.toString(),
						T2_net.class);
			}else{
				return null;
			}
		}
		return T2_net_Items;
	}	
	
	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		getDataResource();
	}

	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		//lv.onRefreshComplete();
		
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.v("T2","return");
		getDataResource();
	}
	
}
