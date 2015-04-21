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
import com.yousi.net.Order_net;
import com.yousi.net.T2_net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;
import com.yousi.util.Send_message;
import com.yousi.util.Switch_pager;

public class T2Fragment extends Fragment implements OnRefreshListener2<ListView>{
private TextView tv1;
private TextView tv2;
private int type = 1;
private PullToRefreshListView lv1; 
private PullToRefreshListView lv2; 
private List<Order_net> Order_net_Items1;
private List<Order_net> Order_net_Items2;
private T2_adapter adapter1 = null;
private T2_adapter adapter2 = null;
private static boolean flag = true;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	        Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_t2, container, false);
			
	
		tv1 = (TextView)rootView.findViewById(R.id.t2_tv1);
		tv2 = (TextView)rootView.findViewById(R.id.t2_tv2);

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
					bundle.putCharSequence("rid", Order_net_Items1.get(position).getR_id());
					bundle.putCharSequence("phone", Order_net_Items1.get(position).getPhone());
					break;
				case 2:
					bundle.putCharSequence("rid", Order_net_Items2.get(position).getR_id());
					bundle.putCharSequence("phone", Order_net_Items2.get(position).getPhone());
					break;
				}
				
				switch (typea){
				case 1:
					intent = new Intent(getActivity(), T2_nddxqActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 2:
					intent = new Intent(getActivity(), T2_nyjddActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 3:
					intent = new Intent(getActivity(), T2_nksstActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 4:
					intent = new Intent(getActivity(), T2_nstskzActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 5:
					intent = new Intent(getActivity(), T2_nstwcActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 6:
					break;
				case 7:
					intent = new Intent(getActivity(), T2_nskzActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 8:
					intent = new Intent(getActivity(), T2_nksskActivity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 9:
					intent = new Intent(getActivity(), T2_nt9Activity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 10:
					intent = new Intent(getActivity(), T2_nt10Activity.class);
					intent.putExtras(bundle);
					//startActivity(intent);
					startActivityForResult(intent, 0);
					break;
				case 11:
				case 12:
					break;
					
				}
				
			}
		};
		
		lv1.setOnItemClickListener(listener);
		lv2.setOnItemClickListener(listener);
		
		if (adapter1 != null)
			lv1.setAdapter(adapter1);
		if (adapter2 != null)
			lv2.setAdapter(adapter2);

	
		if (flag){
			getDataResource("valid");
			flag = false;
		}
			
		show(type);	
		return rootView; 
	}

	Send_message sm = new Send_message() {
		
		@Override
		public void send_msg() {
			// TODO Auto-generated method stub
			getDataResource();
		}
	};
	
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		List<Order_net> Order_net_Items = null;
		switch (type){
		case 1:
			Order_net_Items = Order_net_Items1;
			break;
		case 2:
			Order_net_Items = Order_net_Items2;
			break;
		}
		
		if (Order_net_Items.get(position).getOrder_status().equals("7"))
			return 1;
		else if (Order_net_Items.get(position).getOrder_status().equals("1"))
			return 2;
		else if (Order_net_Items.get(position).getOrder_status().equals("2"))
			return 3;
		else if (Order_net_Items.get(position).getOrder_status().equals("3"))
			return 4;
		else if (Order_net_Items.get(position).getOrder_status().equals("4"))
			return 5;
		else if (Order_net_Items.get(position).getOrder_status().equals("10"))
			return 6;
		else if (Order_net_Items.get(position).getOrder_status().equals("6"))
			return 7;
		else if (Order_net_Items.get(position).getOrder_status().equals("5"))
			return 8;
		else if (Order_net_Items.get(position).getOrder_status().equals("8"))
			return 9;
		else if (Order_net_Items.get(position).getOrder_status().equals("9"))
			return 10;
		else if (Order_net_Items.get(position).getOrder_status().equals("11"))
			return 11;
		else
			return 12;
	}
	
	
	private void getDataResource(){
		switch (type){
    	case 1:
    		getDataResource("valid");
    		break;
    	case 2:
    		getDataResource("invalid");
    		break;
    	}
	}
	
	
	
	private void getDataResource(final String status){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("type", status);
		MyHttpClient.doGet2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				if (status.equals("valid")){
					Order_net_Items1 = parseJsonOrder_netItem(json);
					adapter1 = new T2_adapter(getActivity(), Order_net_Items1, sm);	
					lv1.setAdapter(adapter1);
					adapter1.notifyDataSetChanged();
				}
				else if (status.equals("invalid")){
					Order_net_Items2 = parseJsonOrder_netItem(json);
					adapter2 = new T2_adapter(getActivity(), Order_net_Items2, sm);	
					lv2.setAdapter(adapter2);
					adapter2.notifyDataSetChanged();
				}
				
				show(status);
				
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.order_path, map, DB.getSessionid(getActivity()));
	}

	private void updateDataResource(){
		HashMap<String, String> map = new HashMap<String, String>();
		final String status = ((type == 1) ? "valid" : "invalid");
		map.put("type", status);
		MyHttpClient.doGet2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				if (status.equals("valid")){
					Order_net_Items1 = parseJsonOrder_netItem(json);
					adapter1.notifyDataSetChanged();
				}
				else if (status.equals("invalid")){
					Order_net_Items2 = parseJsonOrder_netItem(json);
					adapter2.notifyDataSetChanged();
				}
				show(status);
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.order_path, map, DB.getSessionid(getActivity()));
	}	
	
	private void show(int n){
		switch (n){
		case 1:
			show("valid");
			break;
		case 2:
			show("invalid");
			break;
		}
	}
	
	
	private void show(String status){
		if (status.equals("valid")){
			if (lv1.getRefreshableView().getAdapter() == null)
				getDataResource(status);
			lv1.setVisibility(View.VISIBLE);
			lv2.setVisibility(View.GONE);
			lv1.onRefreshComplete();	
		}
		else if (status.equals("invalid")){
			if (lv2.getRefreshableView().getAdapter() == null)
				getDataResource(status);
			lv2.setVisibility(View.VISIBLE);
			lv1.setVisibility(View.GONE);
			lv2.onRefreshComplete();		
		}
	}
	
	public List<Order_net> parseJsonOrder_netItem(String json) {
		List<Order_net> Order_net_Items = null;
		JSONObject jsonObject = JSONObject.parseObject(json);
		String code = jsonObject.getString("code");
		if (code.equals("200")) {
			JSONArray dataArray = jsonObject.getJSONArray("data");
			if (dataArray != null) {
				Order_net_Items = JSONArray.parseArray(dataArray.toString(),
						Order_net.class);
			}else{
				return null;
			}
		}
		return Order_net_Items;
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
		//Log.v("T2","return");
		updateDataResource();
	}

	
}
