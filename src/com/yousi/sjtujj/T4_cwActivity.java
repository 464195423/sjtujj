package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.yousi.net.T4_cw_net;
import com.yousi.net.T4_cw_net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class T4_cwActivity extends Activity implements OnRefreshListener2<ListView> {
private List<T4_cw_net> T4_cw_netitems;
private T4_cw_adapter adapter;
private PullToRefreshListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t4_cw);
		
		lv = (PullToRefreshListView)findViewById(R.id.t4_cw_lv);
		
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
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t4_cw_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

        
        //获取数据
		getData();
		
	}
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		MyHttpClient.doGet2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				T4_cw_netitems = parseJsonT4_cw_netItem(json);
				adapter = new T4_cw_adapter(T4_cwActivity.this, T4_cw_netitems);
				//adapter.notifyDataSetChanged();
				lv.setAdapter(adapter);
				lv.onRefreshComplete();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.financial_path, map, DB.getSessionid(T4_cwActivity.this));
	}
	
	public List<T4_cw_net> parseJsonT4_cw_netItem(String json) {
		List<T4_cw_net> T4_cw_netItems = null;
		JSONObject jsonObject = JSONObject.parseObject(json);
		String code = jsonObject.getString("code");
		if (code.equals("200")) {
			JSONArray dataArray = jsonObject.getJSONArray("data");
			if (dataArray != null) {
				T4_cw_netItems = JSONArray.parseArray(dataArray.toString(),
						T4_cw_net.class);
			}else{
				return null;
			}
		}
		return T4_cw_netItems;
	}
	
	
	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		
	}

}
