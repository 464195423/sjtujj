package com.example.sjtujj;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

public class T2_ddxqActivity extends FragmentActivity {
private String rid;
private DdxxFragment fragment1;
private FragmentManager fragmentManager;
private Fragment currentFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
		rid = "16";		
        fragment1 = DdxxFragment.newInstance(rid);
//        Bundle data = new Bundle();
        //data.putString("rid", rid);
//        fragment1.setArguments(data);//通过Bundle向Activity中传递值
        fragmentTransaction.replace(R.id.t2_ddxq_container,fragment1);//将fragment1设置到布局上
        fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.commitAllowingStateLoss();
        fragmentTransaction.commit();
		/*
		rid = getIntent().getExtras().getString("rid");		
		Bundle data = new Bundle();
        data.putString("rid", rid);
        DdxxFragment fg =(com.example.sjtujj.DdxxFragment)getSupportFragmentManager().findFragmentById(R.id.ddxq_fragment);
        fg.setArguments(data);
        */
		
	}
}
