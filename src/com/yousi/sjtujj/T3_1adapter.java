package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.yousi.expired.T2_skzActivity;
import com.yousi.net.T2_net;
import com.yousi.net.T3_1net;
import com.yousi.util.CustomImageView;
import com.yousi.util.DB;
import com.yousi.util.LoadImage;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;
import com.yousi.util.Send_message;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.NumberPicker.OnValueChangeListener;

class viewHolder3_1_1{
	public TextView textViewt1;
	public ImageView imageview1;
	public TextView textViewtvl;
	public TextView textViewtv1;
	public TextView textViewtv2;
	public TextView textViewwarning;
	public TextView textViewbt1;
	public TextView textViewbt2;
	public TextView textViewbt3;
}

class viewHolder3_1_2{
	public TextView textViewt1;
	public ImageView imageview1;
	public TextView textViewtvl;
	public TextView textViewtv1;
	public TextView textViewbt1;
	public TextView textViewbt2;
}


public class T3_1adapter extends BaseAdapter{
private Context context;
private LayoutInflater layoutInflater;
private List<T3_1net> list;

	public T3_1adapter(Context context, List<T3_1net> list){
		this.context = context;       
		layoutInflater = LayoutInflater.from(context);        
		this.list = list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.list!=null? this.list.size(): 0 ;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		int type = Integer.parseInt(list.get(position).getClass_type());
		viewHolder3_1_1 holder1 = null;
		viewHolder3_1_2 holder2 = null;
		if(convertView == null)
		{
			switch(type)
			{
			case 0:
				convertView = layoutInflater.inflate(R.layout.t3_1ntype1, parent, false); 
				holder1 = new viewHolder3_1_1(); 
				holder1.textViewt1 = (TextView)convertView.findViewById(R.id.t3_1t1_title2); 
				holder1.imageview1 = (ImageView)convertView.findViewById(R.id.t3_1t1_iv1);
				holder1.textViewtvl = (TextView)convertView.findViewById(R.id.t3_1t1_tvl); 
				holder1.textViewtv1 = (TextView)convertView.findViewById(R.id.t3_1t1_tv1); 
				holder1.textViewtv2 = (TextView)convertView.findViewById(R.id.t3_1t1_tv2); 
				holder1.textViewwarning = (TextView)convertView.findViewById(R.id.t3_1t1_warning); 
				holder1.textViewbt1 = (TextView)convertView.findViewById(R.id.t3_1t1_bt1); 
				holder1.textViewbt2 = (TextView)convertView.findViewById(R.id.t3_1t1_bt2); 
				holder1.textViewbt3 = (TextView)convertView.findViewById(R.id.t3_1t1_bt3); 
				convertView.setTag(holder1); 
				break;
			case 1:
				convertView = layoutInflater.inflate(R.layout.t3_1ntype2, parent, false); 
				holder2 = new viewHolder3_1_2(); 
				holder2.textViewt1 = (TextView)convertView.findViewById(R.id.t3_1t2_title2); 
				holder2.imageview1 = (ImageView)convertView.findViewById(R.id.t3_1t2_iv1);
				holder2.textViewtvl = (TextView)convertView.findViewById(R.id.t3_1t2_tvl); 
				holder2.textViewtv1 = (TextView)convertView.findViewById(R.id.t3_1t2_tv1); 
				holder2.textViewbt1 = (TextView)convertView.findViewById(R.id.t3_1t2_bt1); 
				holder2.textViewbt2 = (TextView)convertView.findViewById(R.id.t3_1t2_bt2); 
				convertView.setTag(holder2); 
				break;
			}
		}
		else{
			switch(type) 
			{ 
			case 0: 
				holder1 = (viewHolder3_1_1) convertView.getTag(); 
				break; 
			case 1: 
				holder2 = (viewHolder3_1_2) convertView.getTag(); 
				break; 
			}
		}
		
		switch(type) 
		{ 
		case 0: 
			holder1.textViewt1.setText("课程号："+list.get(position).getClass_id());
			if (!list.get(position).getPicture().equals(""))
				LoadImage.setImageView(context, list.get(position).getPicture(), holder1.imageview1);
			holder1.textViewtvl.setText(list.get(position).getParentname());
			
			holder1.textViewtv1.setText("授课时长："+list.get(position).getHours()+"小时");
			holder1.textViewtv2.setText("剩余课时包："+list.get(position).getDiscount()+"小时");
			int tmp = Integer.parseInt(list.get(position).getDiscount());
			holder1.textViewwarning.setVisibility(tmp <= 2 ? View.VISIBLE : View.GONE);
			
			//button
			holder1.textViewbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					final int hour[] = new int[1];
					hour[0] = 2;
					LayoutInflater layoutInflater = LayoutInflater.from(context); 
					View convertView = layoutInflater.inflate(R.layout.number_picker, null, false); 
					
					
					AlertDialog dlg = new AlertDialog.Builder(context).create();
				
					NumberPicker np = (NumberPicker) convertView.findViewById(R.id.np_np);
					np.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
					np.setMinValue(1);
					np.setMaxValue(24);
					np.setValue(2);
					np.setOnValueChangedListener(new OnValueChangeListener(){

						@Override
						public void onValueChange(NumberPicker picker, int oldVal,
								int newVal) {
							// TODO Auto-generated method stub
							hour[0] = newVal;
						}
						
					});
					dlg.setView(convertView);
					dlg.setTitle("请选择授课时长");
					dlg.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							//DONOTING
						}
					});
					dlg.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							//beginToTeach rid hour
							PostData2(list.get(position).getR_id(),String.valueOf(hour[0]));
						}
					});
					dlg.show();
				}
			});
			
			holder1.textViewbt2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub	
					AlertDialog alert = new AlertDialog.Builder(context).create();
					alert.setMessage("取消授课前请与家长进行沟通联系，否则取消家教资格");
					alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							PostData1(list.get(position).getR_id());
						}
					});
					alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						//do_nothing
						}
					});	
					alert.show();
				}
			});
			
			holder1.textViewbt3.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LayoutInflater layoutInflater = LayoutInflater.from(context); 
					View convertView = layoutInflater.inflate(R.layout.finishedteach, null, false); 
					
					AlertDialog dlg = new AlertDialog.Builder(context).create();

					TextView tv = (TextView) convertView.findViewById(R.id.finishedteach_tv);
					tv.setText("授课时长："+list.get(position).getHours()+"小时");
					final EditText et = (EditText) convertView.findViewById(R.id.finishedteach_et);
					
					dlg.setView(convertView);
					dlg.setTitle("确认结课");
					dlg.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							//DONOTING
						}
					});
					dlg.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							//beginToTeach rid hour
							PostData3(list.get(position).getR_id(),list.get(position).getHours(),et.getText().toString());
						}
					});
					dlg.show();
				}
				
			});
			
			break; 
		case 1: 
			holder2.textViewt1.setText("课程号："+list.get(position).getClass_id());
			if (!list.get(position).getPicture().equals(""))
				LoadImage.setImageView(context, list.get(position).getPicture(), holder2.imageview1);
			holder2.textViewtvl.setText(list.get(position).getParentname());
			holder2.textViewtv1.setText("试听时长："+list.get(position).getHours()+"小时");
			
			
			holder2.textViewbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub	
					AlertDialog alert = new AlertDialog.Builder(context).create();
					alert.setMessage("取消授课前请与家长进行沟通联系，否则取消家教资格");
					alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							PostData1(list.get(position).getR_id());
						}
					});
					alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						//do_nothing
						}
					});	
					alert.show();
				}
			});
			
			holder2.textViewbt2.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LayoutInflater layoutInflater = LayoutInflater.from(context); 
					View convertView = layoutInflater.inflate(R.layout.finishedteach, null, false); 
					
					AlertDialog dlg = new AlertDialog.Builder(context).create();

					TextView tv = (TextView) convertView.findViewById(R.id.finishedteach_tv);
					tv.setText("授课时长：2小时");
					final EditText et = (EditText) convertView.findViewById(R.id.finishedteach_et);
					
					dlg.setView(convertView);
					dlg.setTitle("确认结课");
					dlg.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							//DONOTING
						}
					});
					dlg.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							//beginToTeach rid hour
							PostData3(list.get(position).getR_id(), et.getText().toString());
						}
					});
					dlg.show();
				}
				
			});
			break; 
		}
		
				
		return convertView;
	}

	//取消授课
	private void PostData1(String rid){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
				}
				else
					Toast.makeText(context, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.removeTeach_path, map, DB.getSessionid(context));		
		
	}
	
	//修改授课时间
	private void PostData2(String rid, String hours){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("hours", hours);
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
				}
				else
					Toast.makeText(context, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.updateTeachHours_path, map, DB.getSessionid(context));		
		
	}
	
	//结束上课
	private void PostData3(String rid, String hours, String safe_code){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("hours", hours);
		map.put("safe_code", safe_code);
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
					Toast.makeText(context, "结课成功", Toast.LENGTH_LONG).show();
				}
				else
					Toast.makeText(context, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.finishedTeach_path, map, DB.getSessionid(context));		
		
	}
	
	//结束上课
	private void PostData3(String rid, String safe_code){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("safe_code", safe_code);
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//end this activity
					Toast.makeText(context, "结课成功", Toast.LENGTH_LONG).show();
				}
				else
					Toast.makeText(context, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.finishedTeach_path, map, DB.getSessionid(context));		
		
	}
}
