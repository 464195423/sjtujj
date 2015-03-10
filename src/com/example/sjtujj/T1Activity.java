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
		lv.getLoadingLayoutProxy(true, false).setPullLabel("����ˢ��");
		lv.getLoadingLayoutProxy(true, false).setReleaseLabel("�ſ���ˢ��");
		lv.getLoadingLayoutProxy(true, false).setRefreshingLabel("����ˢ��...");
		lv.getLoadingLayoutProxy(false, true).setPullLabel("�������ظ���");
		lv.getLoadingLayoutProxy(false, true).setReleaseLabel("�ſ��Լ���");
		lv.getLoadingLayoutProxy(false, true).setRefreshingLabel("���ڼ���...");
		lv.setOnRefreshListener(this);
		lv.setDividerPadding(10);
		lv.getRefreshableView().setDividerHeight(0);
		
		
		//getDataResource();
        list = new ArrayList<String>();  
        list.add("loonggg");  
        list.add("���Ƕ��ǿ�����");  
        list.add("���Ƕ��ǿ�����");  
        list.add("���Ƕ��ǿ�����");  
        list.add("���Ƕ��ǿ�����");  
        list.add("���Ƕ��ǿ�����");  
        list.add("���Ƕ��ǿ�����");  
        list.add("���Ƕ��ǿ�����");  
        list.add("���Ƕ��ǿ�����");  
        list.add("���Ƕ��ǿ�����");  
        list.add("���Ƕ��ǿ�����");  
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
//    	��������Դ
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
//    	��������Դ
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
   	
//    	����ˢ��
		@Override
    	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
    		//getDataResource();
			lv.onRefreshComplete();
    	}
//    	��������
		@Override
    	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
    		//updateDataResource();
			lv.onRefreshComplete();
    	}
}
