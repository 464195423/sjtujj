package com.example.sjtujj;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class T2_ddxxActivity extends FragmentActivity {
	private String rid;
	private DdxxFragment fragment1;
	private FragmentManager fragmentManager;
	private Fragment currentFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t2_ddxx);
		
		rid = getIntent().getExtras().getString("rid");	
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	
        fragment1 = DdxxFragment.newInstance(rid);

        fragmentTransaction.replace(R.id.t2_ddxx_container,fragment1);//将fragment1设置到布局上
        fragmentTransaction.commit();
		
		//左上返回键
		LinearLayout ll_up = (LinearLayout)findViewById(R.id.t2_ddxx_up);
        ll_up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});	
	}

}
