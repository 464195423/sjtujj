package com.example.sjtujj;

import java.util.ArrayList;
import java.util.List;
import android.R.color;
import android.R.drawable;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends Activity {

List<View> listViews;
Context context = null;
LocalActivityManager manager = null;
TabHost tabHost = null;
private ViewPager pager = null;
private TextView tvTab1;
private TextView tvTab2;
private TextView tvTab3;
private TextView tvTab4;
private ImageView ivTab1;
private ImageView ivTab2;
private ImageView ivTab3;
private ImageView ivTab4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent intent1 = getIntent();
		Bundle bundle = intent1.getExtras();
		/*
		String demandId = bundle.getString("demandId");
		String group = bundle.getString("group");
		String school = bundle.getString("school");
		String sessionid = bundle.getString("sessionid");
		String tid = bundle.getString("tid");
		String tname = bundle.getString("tname");
		String tpicture = bundle.getString("tpicture");
		*/
			
		context = MainActivity.this;
		
		pager  = (ViewPager) findViewById(R.id.viewpager);
		
		//定放一个放view的list，用于存放viewPager用到的view
		listViews = new ArrayList<View>();
		
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);
		
		Intent i1 = new Intent(context, T1Activity.class);
		//i1.putExtras(bundle);
		listViews.add(getView("A", i1));
		Intent i2 = new Intent(context, T2Activity.class);
		//i2.putExtras(bundle);
		listViews.add(getView("B", i2));
		Intent i3 = new Intent(context, T3Activity.class);
		//i3.putExtras(bundle);
		listViews.add(getView("C", i3));
		Intent i4 = new Intent(context, T4Activity.class);
		//i4.putExtras(bundle);
		listViews.add(getView("D", i4));
	
		tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setup();
		tabHost.setup(manager);
		
		
		//这儿主要是自定义一下tabhost中的tab的样式
		RelativeLayout tabIndicator1 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget, null);  
		tvTab1 = (TextView)tabIndicator1.findViewById(R.id.tv_title);
		tvTab1.setText("家教订单");
		ivTab1 = (ImageView)tabIndicator1.findViewById(R.id.iv_mark);
		ivTab1.setImageResource(R.drawable.icon_tmp);
		
		RelativeLayout tabIndicator2 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget,null);  
		tvTab2 = (TextView)tabIndicator2.findViewById(R.id.tv_title);
		tvTab2.setText("我的订单");
		ivTab2 = (ImageView)tabIndicator2.findViewById(R.id.iv_mark);
		ivTab2.setImageResource(R.drawable.icon_tmp);
		
		RelativeLayout tabIndicator3 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget,null);  
		tvTab3 = (TextView)tabIndicator3.findViewById(R.id.tv_title);
		tvTab3.setText("个人中心");
		ivTab3 = (ImageView)tabIndicator3.findViewById(R.id.iv_mark);
		ivTab3.setImageResource(R.drawable.icon_tmp);
		
		RelativeLayout tabIndicator4 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget,null);  
		tvTab4 = (TextView)tabIndicator4.findViewById(R.id.tv_title);
		tvTab4.setText("家教中心");	
		ivTab4 = (ImageView)tabIndicator4.findViewById(R.id.iv_mark);
		ivTab4.setImageResource(R.drawable.icon_tmp);
		
		//设置选中第一项
		set_select(1);
		
		Intent intent = new Intent(context,EmptyActivity.class);
		//注意这儿Intent中的activity不能是自身 比如“A”对应的是T1Activity，后面intent就new的T3Activity的。
		tabHost.addTab(tabHost.newTabSpec("A").setIndicator(tabIndicator1).setContent(intent));
		tabHost.addTab(tabHost.newTabSpec("B").setIndicator(tabIndicator2).setContent(intent));
		tabHost.addTab(tabHost.newTabSpec("C").setIndicator(tabIndicator3).setContent(intent));
		tabHost.addTab(tabHost.newTabSpec("D").setIndicator(tabIndicator4).setContent(intent));
		
		
		pager .setAdapter(new MyPageAdapter(listViews));
		pager .setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				//当viewPager发生改变时，同时改变tabhost上面的currentTab
				tabHost.setCurrentTab(position);
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		
		
		//点击tabhost中的tab时，要切换下面的viewPager
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
	        @Override
	        public void onTabChanged(String tabId) {
	        	if ("A".equals(tabId)) {
	        		set_select(1);
	                pager.setCurrentItem(0);
	            } 
	            if ("B".equals(tabId)) {            	
	                set_select(2);
	                pager.setCurrentItem(1);
	            } 
	            if ("C".equals(tabId)) {
	                set_select(3);
	                pager.setCurrentItem(2);
	            } 
	            if ("D".equals(tabId)) {
	                set_select(4);
	                pager.setCurrentItem(3);
	            }       
	            pager.refreshDrawableState();
	        }
	    });

	}

	private void set_select(int n){
		Log.v("n=",n+"");
		switch (n){
		case 1:
			tvTab1.setTextColor(0xff59c2e6);
			tvTab2.setTextColor(0xffffffff);
			tvTab3.setTextColor(0xffffffff);
			tvTab4.setTextColor(0xffffffff);
			ivTab1.setColorFilter(0xff59c2e6);
			ivTab2.setColorFilter(0xffffffff);
			ivTab3.setColorFilter(0xffffffff);
			ivTab4.setColorFilter(0xffffffff);
			break;
		case 2:
			tvTab1.setTextColor(0xffffffff);
			tvTab2.setTextColor(0xff59c2e6);
			tvTab3.setTextColor(0xffffffff);
			tvTab4.setTextColor(0xffffffff);
			ivTab1.setColorFilter(0xffffffff);
			ivTab2.setColorFilter(0xff59c2e6);
			ivTab3.setColorFilter(0xffffffff);
			ivTab4.setColorFilter(0xffffffff);
			break;
		case 3:
			tvTab1.setTextColor(0xffffffff);
			tvTab2.setTextColor(0xffffffff);
			tvTab3.setTextColor(0xff59c2e6);
			tvTab4.setTextColor(0xffffffff);
			ivTab1.setColorFilter(0xffffffff);
			ivTab2.setColorFilter(0xffffffff);
			ivTab3.setColorFilter(0xff59c2e6);
			ivTab4.setColorFilter(0xffffffff);
			break;
		case 4:
			tvTab1.setTextColor(0xffffffff);
			tvTab2.setTextColor(0xffffffff);
			tvTab3.setTextColor(0xffffffff);
			tvTab4.setTextColor(0xff59c2e6);
			ivTab1.setColorFilter(0xffffffff);
			ivTab2.setColorFilter(0xffffffff);
			ivTab3.setColorFilter(0xffffffff);
			ivTab4.setColorFilter(0xff59c2e6);
			break;
		}
			
		
	}
	
	private View getView(String id, Intent intent) {
		return manager.startActivity(id, intent).getDecorView();
	}
	
	private class MyPageAdapter extends PagerAdapter {
		
		private List<View> list;
	
		private MyPageAdapter(List<View> list) {
			this.list = list;
		}
	
		@Override
	    public void destroyItem(View view, int position, Object arg2) {
	        ViewPager pViewPager = ((ViewPager) view);
	        pViewPager.removeView(list.get(position));
	    }
	
	    @Override
	    public void finishUpdate(View arg0) {
	    }
	
	    @Override
	    public int getCount() {
	        return list.size();
	    }
	
	    @Override
	    public Object instantiateItem(View view, int position) {
	        ViewPager pViewPager = ((ViewPager) view);
	        pViewPager.addView(list.get(position));
	        return list.get(position);
	    }
	
	    @Override
	    public boolean isViewFromObject(View arg0, Object arg1) {
	        return arg0 == arg1;
	    }
	
	    @Override
	    public void restoreState(Parcelable arg0, ClassLoader arg1) {
	    }
	
	    @Override
	    public Parcelable saveState() {
	        return null;
	    }
	
	    @Override
	    public void startUpdate(View arg0) {
	    }
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK )  
        {  
			AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
			alert.setMessage("您将要退出程序，请确认！");
			alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				//TODO
					//android.os.Process.killProcess(android.os.Process.myPid());
					finish(); 
				}
			});
			alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				//DONOTHING
				}
			});	
			alert.show();
  
        }  
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		//Log.v("main","resume");
		//T2Activity.
		super.onResume();
	}
}