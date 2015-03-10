package com.example.sjtujj;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sjtujj.MyListView.OnRefreshListener;

public class T1Activity extends Activity {
    private List<String> list;  
    private MyListView lv;  
    private LvAdapter adapter;  
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t1);
        lv = (MyListView)findViewById(R.id.lv);  
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
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        list.add("我们都是开发者");  
        adapter = new LvAdapter(list, this);  
        lv.setAdapter(adapter);  
  
        lv.setonRefreshListener(new OnRefreshListener() {  
  
            @Override  
            public void onRefresh() {  
                new AsyncTask<Void, Void, Void>() {  
                    protected Void doInBackground(Void... params) {  
                        try {  
                            Thread.sleep(1000);  
                        } catch (Exception e) {  
                            e.printStackTrace();  
                        }  
                        list.add("刷新后添加的内容");  
                        return null;  
                    }  
  
                    @Override  
                    protected void onPostExecute(Void result) {  
                        adapter.notifyDataSetChanged();  
                        lv.onRefreshComplete();  
                    }  
                }.execute(null, null, null);  
            }  
        });  
    } 

}
