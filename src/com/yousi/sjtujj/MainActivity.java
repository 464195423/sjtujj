package com.yousi.sjtujj;

import java.util.ArrayList;
import java.util.Date;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yousi.util.Switch_pager;

public class MainActivity extends FragmentActivity {

private ArrayList<Fragment> fragmentList;  
private Context context = null;
private ViewPager pager = null;
private TextView tvTab1;
private TextView tvTab2;
private TextView tvTab3;
private TextView tvTab4;
private ImageView ivTab1;
private ImageView ivTab2;
private ImageView ivTab3;
private ImageView ivTab4;
private Fragment firstFragment;  
private Fragment secondFragment;  
private Fragment thirdFragment;   
private Fragment fourthFragment;   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		T2_adapter.setCallback(sp);
		T2_nskzActivity.setCallback(sp);
		T2_nstskzActivity.setCallback(sp);
		
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
		
		//Jpush
        //JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        //JPushInterface.init(this);     		// 初始化 JPush
		
		context = MainActivity.this;
		
		pager  = (ViewPager) findViewById(R.id.viewpager);
		
		Date date = new Date();

		
		//这儿主要是自定义一下tabhost中的tab的样式
		tvTab1 = (TextView)findViewById(R.id.tv_title1);
		ivTab1 = (ImageView)findViewById(R.id.iv_mark1);

		tvTab2 = (TextView)findViewById(R.id.tv_title2);
		ivTab2 = (ImageView)findViewById(R.id.iv_mark2);
		
		tvTab3 = (TextView)findViewById(R.id.tv_title3);
		ivTab3 = (ImageView)findViewById(R.id.iv_mark3);

		tvTab4 = (TextView)findViewById(R.id.tv_title4);	
		ivTab4 = (ImageView)findViewById(R.id.iv_mark4);

		
		//设置选中第一项
		set_select(0);
		
		
		
		
		fragmentList = new ArrayList<Fragment>();  
        firstFragment= new T1Fragment();  
        secondFragment = new T2Fragment();  
        thirdFragment = new T3nFragment();   
        fourthFragment = new T4nFragment();   
        fragmentList.add(firstFragment);  
        fragmentList.add(secondFragment);  
        fragmentList.add(thirdFragment);  
        fragmentList.add(fourthFragment); 
		
		
		pager .setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
		pager.setCurrentItem(0);
		pager .setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				//当viewPager发生改变时，同时改变tabhost上面的currentTab
				set_select(position);
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		

		//设置点击标签切换
		LinearLayout ll1 = (LinearLayout)findViewById(R.id.main_ll1);
		ll1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				set_select(0);
				pager.setCurrentItem(0);
			}
		});

		LinearLayout ll2 = (LinearLayout)findViewById(R.id.main_ll2);
		ll2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				set_select(1);
				pager.setCurrentItem(1);
			}
		});
		
		LinearLayout ll3 = (LinearLayout)findViewById(R.id.main_ll3);
		ll3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				set_select(2);
				pager.setCurrentItem(2);
			}
		});
		
		LinearLayout ll4 = (LinearLayout)findViewById(R.id.main_ll4);
		ll4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				set_select(3);
				pager.setCurrentItem(3);
			}
		});
	}

	
	
	private void set_select(int n){
		switch (n){
		case 0:
			tvTab1.setTextColor(0xff36a5df);
			tvTab2.setTextColor(0xff999999);
			tvTab3.setTextColor(0xff999999);
			tvTab4.setTextColor(0xff999999);
			ivTab1.setImageResource(R.drawable.demand_icon);
			ivTab2.setImageResource(R.drawable.order_icon2);
			ivTab3.setImageResource(R.drawable.couse_icon2);
			ivTab4.setImageResource(R.drawable.person_icon2);
			break;
		case 1:
			tvTab1.setTextColor(0xff999999);
			tvTab2.setTextColor(0xff36a5df);
			tvTab3.setTextColor(0xff999999);
			tvTab4.setTextColor(0xff999999);
			ivTab1.setImageResource(R.drawable.demand_icon2);
			ivTab2.setImageResource(R.drawable.order_icon);
			ivTab3.setImageResource(R.drawable.couse_icon2);
			ivTab4.setImageResource(R.drawable.person_icon2);
			break;
		case 2:
			tvTab1.setTextColor(0xff999999);
			tvTab2.setTextColor(0xff999999);
			tvTab3.setTextColor(0xff36a5df);
			tvTab4.setTextColor(0xff999999);
			ivTab1.setImageResource(R.drawable.demand_icon2);
			ivTab2.setImageResource(R.drawable.order_icon2);
			ivTab3.setImageResource(R.drawable.couse_icon);
			ivTab4.setImageResource(R.drawable.person_icon2);
			break;
		case 3:
			tvTab1.setTextColor(0xff999999);
			tvTab2.setTextColor(0xff999999);
			tvTab3.setTextColor(0xff999999);
			tvTab4.setTextColor(0xff36a5df);
			ivTab1.setImageResource(R.drawable.demand_icon2);
			ivTab2.setImageResource(R.drawable.order_icon2);
			ivTab3.setImageResource(R.drawable.couse_icon2);
			ivTab4.setImageResource(R.drawable.person_icon);
			break;
		}
			
		
	}
	
	Switch_pager sp = new Switch_pager() {

		@Override
		public void switch_pager(int n) {
			// TODO Auto-generated method stub
			set_select(n);	
			pager.setCurrentItem(n);
		}
	};
	
	
	//PageAdapter
	public class MyFragmentPagerAdapter extends FragmentPagerAdapter{  
	    ArrayList<Fragment> list;  
	    public MyFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> list) {  
	        super(fm);  
	        this.list = list;           
	    }  
	      
	    @Override  
	    public int getCount() {  
	        return list.size();  
	    }  
	      
	    @Override  
	    public Fragment getItem(int arg0) {  
	        return list.get(arg0);  
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

}