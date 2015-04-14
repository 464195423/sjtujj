package com.yousi.sjtujj;

import java.util.ArrayList;
import java.util.List;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.yousi.net.T2_net;

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

public class T3nFragment extends Fragment implements OnRefreshListener2<ListView>, OnRefreshListener<ExpandableListView>{
private TextView tv1;
private TextView tv2;
private int type = 1;
private PullToRefreshListView lv1; 
private PullToRefreshExpandableListView lv2; 
private List<String> T3_1net_Items1;
private List<String> T3_1net_Items2;
private T2_adapter adapter1 = null;
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
		
		final AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				position--;
				Intent intent = null;
				Bundle bundle = new Bundle();
				
			}
		};
		
		lv1.setOnItemClickListener(listener);
		
		if (adapter1 != null)
			lv1.setAdapter(adapter1);
		if (adapter2 != null)
			lv2.getRefreshableView().setAdapter(adapter2);

	
		if (flag){
			getDataResource("0");
			flag = false;
		}
			
		show(type);
		return rootView;
	}
	
	
	//getDataResourse
	private void getDataResource(){
		switch (type){
    	case 1:
    		getDataResource("0");
    		break;
    	case 2:
    		getDataResource("close");
    		break;
    	}
	}
	
	
	
	private void getDataResource(final String status){
		List<String> listtype = new ArrayList<String>();
		listtype.add("line1");
		listtype.add("line2");
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> tmp1 = new ArrayList<String>();
		tmp1.add("content1");
		tmp1.add("content2");
		List<String> tmp2 = new ArrayList<String>();
		tmp2.add("content3");
		tmp2.add("content4");
		list.add(tmp1);
		list.add(tmp2);
		adapter2 = new T3_2adapter(getActivity(),listtype,list);
		lv2.getRefreshableView().setAdapter(adapter2);
	}
	
	//show
	private void show(int n){
		switch (n){
		case 1:
			show("0");
			break;
		case 2:
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
			lv1.onRefreshComplete();	
		}
		else if (status.equals("close")){
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
