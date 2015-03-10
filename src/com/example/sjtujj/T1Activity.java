package com.example.sjtujj;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.sjtujj.MyListView.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class T1Activity extends Activity implements OnRefreshListener2<ListView>{
private List<String> list;  
private PullToRefreshListView lv;  
private LvAdapter adapter;  
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t1);
        lv = (PullToRefreshListView)findViewById(R.id.lv);  
  
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
		
		
		//getDataResource();
        list = new ArrayList<String>();  
        list.add("loonggg");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        adapter = new LvAdapter(list, this);  
        lv.setAdapter(adapter);  
        
    
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

		});
	}
  
/*
//    	加载数据源
    	private void getDataResource(){
    		MyHttpClient.getJson(MyPath.QUESTIONLISTPATH, new NetRespondPost() {
    			@Override
    			public void netWorkOk(String json) {
    				questionItems = FastJsonParser.parseJsonQuestionItem(json);
    				adapter = new QuestionListAdapter(getActivity(), questionItems);
    				mPullRefreshListView.setAdapter(adapter);
    				mPullRefreshListView.onRefreshComplete();
    			}
    			@Override
    			public void netWorkError() {
    			}
    		}, SessionID);
    	}
*/
	
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
    		//getDataResource();
			lv.onRefreshComplete();
    	}
//    	上拉加载
		@Override
    	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
    		//updateDataResource();
			lv.onRefreshComplete();
    	}
}
