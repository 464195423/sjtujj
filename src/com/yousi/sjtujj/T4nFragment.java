package com.yousi.sjtujj;

import com.alibaba.fastjson.JSONObject;
import com.yousi.net.T3_net;
import com.yousi.util.DB;
import com.yousi.util.LoadImage;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T4nFragment extends Fragment {
private static T3_net T3_net_Items;	
private View rootView;
private String tid;
private static boolean flag = true;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	        Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_nt4, container, false);

		tid = DB.getTid(getActivity());
		
		
		if (flag){
			flag = false;
		}
		else{
			ImageView iv = (ImageView)rootView.findViewById(R.id.t4_pic);
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
	}
	
	private void SetData(){
		ImageView iv = (ImageView)rootView.findViewById(R.id.t4_pic);
		LoadImage.setImageView(getActivity(), T3_net_Items.getPicture(), iv);
		
		TextView tv1 = (TextView)rootView.findViewById(R.id.t4_col1);
		TextView tv2 = (TextView)rootView.findViewById(R.id.t4_col2);
		TextView tv3 = (TextView)rootView.findViewById(R.id.t4_col3);
		tv1.setText(T3_net_Items.getTotalTeachHours()+"小时");
		tv2.setText(T3_net_Items.getTotalGold()+"元");
		tv3.setText(T3_net_Items.getGold()+"元");
		
		RelativeLayout rl1 = (RelativeLayout)rootView.findViewById(R.id.t4_rl1);
		RelativeLayout rl2 = (RelativeLayout)rootView.findViewById(R.id.t4_rl2);
		RelativeLayout rl3 = (RelativeLayout)rootView.findViewById(R.id.t4_rl3);
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
				bundle.putCharSequence("tid", tid);
				bundle.putCharSequence("is_search_show", T3_net_Items.getIs_search_show());
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
