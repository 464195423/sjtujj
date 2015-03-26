package com.example.sjtujj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
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

import com.example.sjtujj.MyListView.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class T1Activity extends ListActivity implements OnRefreshListener2<ListView>{
private List<String> list;  
private PullToRefreshListView lv;  
private LvAdapter adapter;  
  
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
        
		/*
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
        */
		
		SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.activity_t1_vlist,
                new String[]{"l1","l2","l3","l4"},
                new int[]{R.id.t1_vlist_l1,R.id.t1_vlist_l2,R.id.t1_vlist_l3,R.id.t1_vlist_l4});
        setListAdapter(adapter);
		
    
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

		});
	}
  
	
	private List<Map<String, Object>> getData(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		 
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("l1", "l1_1");
        map.put("l2", "l2_1");
        map.put("l3", "l3_1");
        map.put("l4", "l4_1");
        list.add(map);
 
        map = new HashMap<String, Object>();
        map.put("l1", "l1_2");
        map.put("l2", "l2_2");
        map.put("l3", "l3_2");
        map.put("l4", "l4_2");
        list.add(map);
 
        map = new HashMap<String, Object>();
        map.put("l1", "l1_3");
        map.put("l2", "l2_3");
        map.put("l3", "l3_3");
        map.put("l4", "l4_3");
        list.add(map);
         
        return list;		
		
		
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
