package com.yousi.sjtujj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class T4Fragment extends Fragment {
private ImageView iv1;
private ImageView iv2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	        Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_t4, container, false);

		iv1 = (ImageView)rootView.findViewById(R.id.iv1);
		iv1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), T4_zxggActivity.class);
				startActivity(intent);
			}
			
		});
		
		iv2 = (ImageView)rootView.findViewById(R.id.iv2);
		iv2.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(getActivity()).create();
				alert.setTitle("提示消息");
				alert.setMessage("功能开发中");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				alert.show();
			}
			
		});
		
		return rootView;
	}

}
