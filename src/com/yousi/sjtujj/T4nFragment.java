package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.net.T4_net;
import com.yousi.util.DB;
import com.yousi.util.LoadImage;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T4nFragment extends Fragment {
private static T4_net T4_net_Items;	
private View rootView;
private static boolean flag = true;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	        Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_nt4, container, false);

		
		if (flag){
			flag = false;
		}
		else{
			ImageView iv = (ImageView)rootView.findViewById(R.id.t4_pic);
			LoadImage.setImageView(getActivity(), T4_net_Items.getPicture(), iv);
		}
		
		GetData();
		
		return rootView;
	}
	
	private void GetData(){
		HashMap<String, String> map = new HashMap<String, String>();
		MyHttpClient.doGet2(getActivity(), new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					T4_net_Items = JSONObject.parseObject(data1.toString(), T4_net.class);
					SetData();
				}
				else
					Toast.makeText(getActivity(), jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.personalCenter_path, map, DB.getSessionid(getActivity()));		
	}
	
	private void SetData(){
		ImageView iv = (ImageView)rootView.findViewById(R.id.t4_pic);
		LoadImage.setImageView(getActivity(), T4_net_Items.getPicture(), iv);
		
		TextView tv1 = (TextView)rootView.findViewById(R.id.t4_col1);
		TextView tv2 = (TextView)rootView.findViewById(R.id.t4_col2);
		TextView tv3 = (TextView)rootView.findViewById(R.id.t4_col3);
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");   
		double d1 = Double.parseDouble(T4_net_Items.getTotalgold());
		double d2 = Double.parseDouble(T4_net_Items.getGold());
		tv1.setText(T4_net_Items.getHours()+"小时");
		tv2.setText(df.format(d1)+"元");
		tv3.setText(df.format(d2)+"元");
		
		RelativeLayout rl1 = (RelativeLayout)rootView.findViewById(R.id.t4_rl1);
		RelativeLayout rl2 = (RelativeLayout)rootView.findViewById(R.id.t4_rl2);
		RelativeLayout rl3 = (RelativeLayout)rootView.findViewById(R.id.t4_rl3);
		
		RelativeLayout rl4_1 = (RelativeLayout)rootView.findViewById(R.id.t4_rl4_1);
		RelativeLayout rl4_2 = (RelativeLayout)rootView.findViewById(R.id.t4_rl4_2);
		
		RelativeLayout rl5 = (RelativeLayout)rootView.findViewById(R.id.t4_rl5);
		RelativeLayout rl6 = (RelativeLayout)rootView.findViewById(R.id.t4_rl6);
		
		rl1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), T3_grtzActivity.class);
				startActivity(intent);
			}
		});
		
		rl2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), T3_grszActivity.class);
				Bundle bundle = new Bundle();
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		rl3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			}
		});

		rl4_1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), T4_cwActivity.class);
				startActivity(intent);
			}
		});	
		
		rl4_2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), T4_txActivity.class);
				startActivity(intent);
			}
		});	
		
		rl5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), T3_yjfkActivity.class);
				startActivity(intent);
			}
		});
		
		rl6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(getActivity()).create();
				alert.setTitle("注意");
				alert.setMessage("你将要注销登录，请确认！");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						PostData();
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
	
	//退出登录
	private void PostData(){
		HashMap<String, String> map = new HashMap<String, String>();
		MyHttpClient.doPost2(getActivity(), new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					Intent intent = new Intent(getActivity(), LoginActivity.class);
					startActivity(intent);
					getActivity().finish();
				}
				else
					Toast.makeText(getActivity(), jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.quit_path, map, DB.getSessionid(getActivity()));		
	}
}
