package com.yousi.sjtujj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.yousi.net.T3_net;
import com.yousi.util.DB;
import com.yousi.util.LoadImage;
import com.yousi.util.MyPath;

public class T3Fragment extends Fragment {
private static T3_net T3_net_Items;
private String tid;
private View rootView;
private static boolean flag = true;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	        Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_t3, container, false);


		tid = DB.getTid(getActivity());
		
		if (flag){
			flag = false;
		}
		else{
			ImageView iv = (ImageView)rootView.findViewById(R.id.t3_pic);
			LoadImage.setImageView(getActivity(), T3_net_Items.getPicture(), iv);
		}
		
		GetData();	
		
		return rootView;
		
	}
	
	private void GetData(){
		MyHttpClient.postJson(MyPath.personal_info_path, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				//Log.v("json",json);
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					T3_net_Items = JSONObject.parseObject(data1.toString(), T3_net.class);
					SetData();
				}
				else
					Toast.makeText(getActivity(), jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, DB.getSessionid(getActivity()));

		/* 
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("startus", "0");
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				Log.v("json",json);
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.my_demand_path, map, MyPath.getSessionid());
		*/
	}

	private void SetData(){
		TextView tv1 = (TextView)rootView.findViewById(R.id.t3_col1);
		TextView tv2 = (TextView)rootView.findViewById(R.id.t3_col2);
		TextView tv3 = (TextView)rootView.findViewById(R.id.t3_col3);
		tv1.setText(T3_net_Items.getTotalTeachHours());
		tv2.setText(T3_net_Items.getTotalGold());
		tv3.setText(T3_net_Items.getGold());
		TextView username = (TextView)rootView.findViewById(R.id.t3_username);
		username.setText(T3_net_Items.getName());
		ImageView iv = (ImageView)rootView.findViewById(R.id.t3_pic);
		LoadImage.setImageView(getActivity(), T3_net_Items.getPicture(), iv);
		
		ImageView iv1 = (ImageView)rootView.findViewById(R.id.t3_iv1);
		ImageView iv2 = (ImageView)rootView.findViewById(R.id.t3_iv2);
		ImageView iv3 = (ImageView)rootView.findViewById(R.id.t3_iv3);
		ImageView iv4 = (ImageView)rootView.findViewById(R.id.t3_iv4);
		ImageView iv5 = (ImageView)rootView.findViewById(R.id.t3_iv5);

		iv1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), T3_grtzActivity.class);
				startActivity(intent);
			}
		});		
		
		iv2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(getActivity()).create();
				alert.setTitle("提示消息");
				alert.setMessage("功能开发中,请暂时使用网站提现");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				alert.show();				
			}
		});

		iv3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), T3_grszActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("tid", tid);
				bundle.putCharSequence("is_search_show", T3_net_Items.getIs_search_show());
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});		
		
		
		iv4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(getActivity()).create();
				alert.setTitle("注意");
				alert.setMessage("你将要注销登录，请确认！");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(getActivity(), LoginActivity.class);
					startActivity(intent);
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					//do nothing
					}
				});				
				alert.show();				
			}
		});	
	}
	
}
