package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;










import com.alibaba.fastjson.JSONObject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class viewHolder1{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public TextView textViewtv1;
	public TextView textViewtv2;	
}

class viewHolder2{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public TextView textViewl5;
	public TextView textViewtv1;
	public TextView textViewtv2;
	public LinearLayout LinearLayoutbt1;
	public LinearLayout LinearLayoutbt0;
}

class viewHolder3{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public TextView textViewl5;
	public TextView textViewtv1;
	public TextView textViewtv2;
	public LinearLayout LinearLayoutbt1;
}

class viewHolder4{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public TextView textViewtv1;
	public TextView textViewtv2;
	public LinearLayout LinearLayoutbt1;
}

class viewHolder5{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public LinearLayout LinearLayoutbt0;
}

class viewHolder6{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
}

class viewHolder7{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public TextView textViewl5;
	public LinearLayout LinearLayoutbt1;
}

class viewHolder8{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public TextView textViewl5;
	public LinearLayout LinearLayoutbt1;
}

public class T2_adapter extends BaseAdapter {
private Context context;
private LayoutInflater layoutInflater;
private List<T2_net> list;
private Send_message sm;
final int TYPE_1 = 1; 
final int TYPE_2 = 2; 
final int TYPE_3 = 3;
final int TYPE_4 = 4; 
final int TYPE_5 = 5; 
final int TYPE_6 = 6;
final int TYPE_7 = 7; 
final int TYPE_8 = 8; 
final int TYPE_9 = 9;
	public T2_adapter(Context context, List<T2_net> list, Send_message sm){
		this.context = context;       
		layoutInflater = LayoutInflater.from(context);        
		this.list = list;
		this.sm = sm;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.list!=null? this.list.size(): 0 ;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if (list.get(position).getStatus().equals("0"))
			return TYPE_1;
		else if (list.get(position).getStatus().equals("1"))
			return TYPE_2;
		else if (list.get(position).getStatus().equals("2") && list.get(position).getHire().equals("0"))
			return TYPE_3;
		else if (list.get(position).getStatus().equals("2") && list.get(position).getHire().equals("1"))
			return TYPE_4;
		else if (list.get(position).getStatus().equals("3"))
			return TYPE_5;
		else if (list.get(position).getStatus().equals("4") && list.get(position).getHire().equals("0"))
			return TYPE_8;
		else if (list.get(position).getStatus().equals("4") && list.get(position).getHire().equals("1"))
			return TYPE_7;
		else if (list.get(position).getStatus().equals("5"))
			return TYPE_6;
		else
			return TYPE_9;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 9;
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
		int type = getItemViewType(position); 
		viewHolder1 holder1 = null;
		viewHolder2 holder2 = null;
		viewHolder3 holder3 = null;
		viewHolder4 holder4 = null;
		viewHolder5 holder5 = null;
		viewHolder6 holder6 = null;
		viewHolder7 holder7 = null;
		viewHolder8 holder8 = null;
		
		if(convertView == null)
		{
			switch(type)
			{
			case TYPE_1:
				convertView = layoutInflater.inflate(R.layout.t2_ntype1, parent, false); 
				holder1 = new viewHolder1(); 
				holder1.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t1_title2); 
				holder1.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t1_l1); 
				holder1.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t1_l2); 
				holder1.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t1_l3); 
				holder1.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t1_l4); 
				holder1.textViewtv1 = (TextView)convertView.findViewById(R.id.t2_t1_bt1); 
				holder1.textViewtv2 = (TextView)convertView.findViewById(R.id.t2_t1_bt2); 
				convertView.setTag(holder1); 
				break;
			case TYPE_2:
				convertView = layoutInflater.inflate(R.layout.t2_ntype2, parent, false); 
				holder2 = new viewHolder2(); 
				holder2.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t2_title2); 
				holder2.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t2_l1); 
				holder2.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t2_l2); 
				holder2.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t2_l3); 
				holder2.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t2_l4); 
				holder2.textViewl5 = (TextView)convertView.findViewById(R.id.t2_t2_l5); 
				holder2.LinearLayoutbt1 = (LinearLayout)convertView.findViewById(R.id.t2_t2_bt1); 
				holder2.LinearLayoutbt0 = (LinearLayout)convertView.findViewById(R.id.t2_t2_bt0); 
				holder2.textViewtv1 = (TextView)convertView.findViewById(R.id.t2_t2_tv1); 
				holder2.textViewtv2 = (TextView)convertView.findViewById(R.id.t2_t2_tv2); 
				convertView.setTag(holder2); 
				break;
			case TYPE_3:
				convertView = layoutInflater.inflate(R.layout.t2_ntype3, parent, false); 
				holder3 = new viewHolder3(); 
				holder3.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t3_title2); 
				holder3.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t3_l1); 
				holder3.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t3_l2); 
				holder3.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t3_l3); 
				holder3.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t3_l4); 
				holder3.textViewl5 = (TextView)convertView.findViewById(R.id.t2_t3_l5); 
				holder3.LinearLayoutbt1 = (LinearLayout)convertView.findViewById(R.id.t2_t3_bt1); 
				holder3.textViewtv1 = (TextView)convertView.findViewById(R.id.t2_t3_tv1); 
				holder3.textViewtv2 = (TextView)convertView.findViewById(R.id.t2_t3_tv2); 
				convertView.setTag(holder3); 
				break;
			case TYPE_4:
				convertView = layoutInflater.inflate(R.layout.t2_ntype4, parent, false); 
				holder4 = new viewHolder4(); 
				holder4.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t4_title2); 
				holder4.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t4_l1); 
				holder4.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t4_l2); 
				holder4.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t4_l3); 
				holder4.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t4_l4); 
				holder4.LinearLayoutbt1 = (LinearLayout)convertView.findViewById(R.id.t2_t4_bt1); 
				holder4.textViewtv1 = (TextView)convertView.findViewById(R.id.t2_t4_tv1); 
				holder4.textViewtv2 = (TextView)convertView.findViewById(R.id.t2_t4_tv2); 
				convertView.setTag(holder4); 
				break;
			case TYPE_5:
				convertView = layoutInflater.inflate(R.layout.t2_ntype5, parent, false); 
				holder5 = new viewHolder5(); 
				holder5.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t5_title2); 
				holder5.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t5_l1); 
				holder5.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t5_l2); 
				holder5.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t5_l3); 
				holder5.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t5_l4); 
				holder5.LinearLayoutbt0 = (LinearLayout)convertView.findViewById(R.id.t2_t5_bt0); 
				convertView.setTag(holder5); 
				break;
			case TYPE_6:
				convertView = layoutInflater.inflate(R.layout.t2_ntype6, parent, false); 
				holder6 = new viewHolder6(); 
				holder6.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t6_title2); 
				holder6.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t6_l1); 
				holder6.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t6_l2); 
				holder6.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t6_l3); 
				holder6.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t6_l4); 
				convertView.setTag(holder6); 
				break;
			case TYPE_7:
				convertView = layoutInflater.inflate(R.layout.t2_ntype7, parent, false); 
				holder7 = new viewHolder7(); 
				holder7.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t7_title2); 
				holder7.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t7_l1); 
				holder7.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t7_l2); 
				holder7.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t7_l3); 
				holder7.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t7_l4); 
				holder7.textViewl5 = (TextView)convertView.findViewById(R.id.t2_t7_l5); 
				holder7.LinearLayoutbt1 = (LinearLayout)convertView.findViewById(R.id.t2_t7_bt1); 
				convertView.setTag(holder7); 
				break;
			case TYPE_8:
				convertView = layoutInflater.inflate(R.layout.t2_ntype8, parent, false); 
				holder8 = new viewHolder8(); 
				holder8.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t8_title2); 
				holder8.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t8_l1); 
				holder8.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t8_l2); 
				holder8.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t8_l3); 
				holder8.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t8_l4); 
				holder8.textViewl5 = (TextView)convertView.findViewById(R.id.t2_t8_l5); 
				holder8.LinearLayoutbt1 = (LinearLayout)convertView.findViewById(R.id.t2_t8_bt1); 
				convertView.setTag(holder8); 
				break;
			}
			
			
		}else{
			switch(type) 
			{ 
			case TYPE_1: 
				holder1 = (viewHolder1) convertView.getTag(); 
				break; 
			case TYPE_2: 
				holder2 = (viewHolder2) convertView.getTag(); 
				break; 
			case TYPE_3: 
				holder3 = (viewHolder3) convertView.getTag(); 
				break;
			case TYPE_4: 
				holder4 = (viewHolder4) convertView.getTag(); 
				break;
			case TYPE_5: 
				holder5 = (viewHolder5) convertView.getTag(); 
				break;
			case TYPE_6: 
				holder6 = (viewHolder6) convertView.getTag(); 
				break; 	
			case TYPE_7: 
				holder7 = (viewHolder7) convertView.getTag(); 
				break;
			case TYPE_8: 
				holder8 = (viewHolder8) convertView.getTag(); 
				break;
				
			}
		}
		
		switch(type) 
		{ 
		case TYPE_1: 
			holder1.textViewt1.setText("D"+list.get(position).getRid()); 
			holder1.textViewl1.setText("学生姓名："+list.get(position).getSname()); 
			holder1.textViewl2.setText("学生年级："+list.get(position).getGradename());
			holder1.textViewl3.setText("辅导科目："+list.get(position).getWeaksubjectname());
			holder1.textViewl4.setText("小时单价："+list.get(position).getOnehourprice()+"元/时");
			//接单与拒绝
			holder1.textViewtv1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					PostData1_1(list.get(position).getRid());
				}
			});
			holder1.textViewtv2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AlertDialog alert = new AlertDialog.Builder(context).create();
					alert.setTitle("注意");
					alert.setMessage("您将要拒绝订单，请确认！");
					alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						//TODO
							PostData1_2(list.get(position).getRid());
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
			});
			break;
		case TYPE_2: 
			holder2.textViewt1.setText("D"+list.get(position).getRid()); 
			holder2.textViewl1.setText("学生姓名："+list.get(position).getSname()); 
			holder2.textViewl2.setText("学生年级："+list.get(position).getGradename());
			holder2.textViewl3.setText("辅导科目："+list.get(position).getWeaksubjectname());
			holder2.textViewl4.setText("小时单价："+list.get(position).getOnehourprice()+"元/时");
			holder2.textViewl5.setText("剩余联系时间：11:59:59");//TODO
			holder2.textViewtv1.setText(list.get(position).getSname()+"家长");
			holder2.textViewtv2.setText("13000000000");//TODO
			holder2.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(context, T2_qdstsjActivity.class);
					Bundle bundle = new Bundle();
					bundle.putCharSequence("rid", list.get(position).getRid());
					intent.putExtras(bundle);
					context.startActivity(intent);
					sm.send_msg();
				}
			});
			holder2.LinearLayoutbt0.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub 
	                //用intent启动拨打电话  
	                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+"13000000000"));  
	                context.startActivity(intent); 
				}
			});
			break;
		case TYPE_3: 
			holder3.textViewt1.setText("D"+list.get(position).getRid()); 
			holder3.textViewl1.setText("学生姓名："+list.get(position).getSname()); 
			holder3.textViewl2.setText("学生年级："+list.get(position).getGradename());
			holder3.textViewl3.setText("辅导科目："+list.get(position).getWeaksubjectname());
			holder3.textViewl4.setText("小时单价："+list.get(position).getOnehourprice()+"元/时");
			holder3.textViewl5.setText("确认试教时间：11:59:59");//TODO
			holder3.textViewtv1.setText(list.get(position).getSname()+"家长");
			holder3.textViewtv2.setText("13000000000");//TODO
			holder3.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AlertDialog alert = new AlertDialog.Builder(context).create();
					alert.setMessage("您将要进行试听授课，请确认！");
					alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						//TODO
							PostData3(list.get(position).getRid());
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
			});
			break;
		case TYPE_4: 
			holder4.textViewt1.setText("D"+list.get(position).getRid()); 
			holder4.textViewl1.setText("学生姓名："+list.get(position).getSname()); 
			holder4.textViewl2.setText("学生年级："+list.get(position).getGradename());
			holder4.textViewl3.setText("辅导科目："+list.get(position).getWeaksubjectname());
			holder4.textViewl4.setText("小时单价："+list.get(position).getOnehourprice()+"元/时");
			holder4.textViewtv1.setText(list.get(position).getSname()+"家长");
			holder4.textViewtv2.setText("13000000000");//TODO
			holder4.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(context, T2_stjsActivity.class);
					Bundle bundle = new Bundle();
					bundle.putCharSequence("rid", list.get(position).getRid());

					intent.putExtras(bundle);
					context.startActivity(intent);	
				}
			});
			break;
		case TYPE_5: 
			holder5.textViewt1.setText("D"+list.get(position).getRid()); 
			holder5.textViewl1.setText("学生姓名："+list.get(position).getSname()); 
			holder5.textViewl2.setText("学生年级："+list.get(position).getGradename());
			holder5.textViewl3.setText("辅导科目："+list.get(position).getWeaksubjectname());
			holder5.textViewl4.setText("小时单价："+list.get(position).getOnehourprice()+"元/时");
			holder5.LinearLayoutbt0.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub 
	                //用intent启动拨打电话  
	                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+"13000000000"));  
	                context.startActivity(intent); 
				}
			});
			break;
		case TYPE_6: 
			holder6.textViewt1.setText("D"+list.get(position).getRid()); 
			holder6.textViewl1.setText("学生姓名："+list.get(position).getSname()); 
			holder6.textViewl2.setText("学生年级："+list.get(position).getGradename());
			holder6.textViewl3.setText("辅导科目："+list.get(position).getWeaksubjectname());
			holder6.textViewl4.setText("小时单价："+list.get(position).getOnehourprice()+"元/时");
			break; 
		case TYPE_7: 
			holder7.textViewt1.setText("D"+list.get(position).getRid()); 
			holder7.textViewl1.setText("学生姓名："+list.get(position).getSname()); 
			holder7.textViewl2.setText("学生年级："+list.get(position).getGradename());
			holder7.textViewl3.setText("辅导科目："+list.get(position).getWeaksubjectname());
			holder7.textViewl4.setText("小时单价："+list.get(position).getOnehourprice()+"元/时");
			holder7.textViewl5.setText("剩余课时包："+list.get(position).getTeach_hours()+"小时");
			holder7.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 转到查看课程
				}
			});
			break; 
		case TYPE_8: 
			holder8.textViewt1.setText("D"+list.get(position).getRid()); 
			holder8.textViewl1.setText("学生姓名："+list.get(position).getSname()); 
			holder8.textViewl2.setText("学生年级："+list.get(position).getGradename());
			holder8.textViewl3.setText("辅导科目："+list.get(position).getWeaksubjectname());
			holder8.textViewl4.setText("小时单价："+list.get(position).getOnehourprice()+"元/时");
			holder8.textViewl5.setText("剩余课时包："+list.get(position).getTeach_hours()+"小时");
			holder8.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 弹窗设置授课时长
				}
			});
			break; 
		}
			
		if (type == TYPE_9)
			return null;
		
		return convertView;
	}

	private void PostData1_1(String rid){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//send message
					sm.send_msg();
				}
				else
					Toast.makeText(context, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.getOrder_path, map, DB.getSessionid(context));		
	}
	
	private void PostData1_2(final String rid){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//send message
					sm.send_msg();
				}
				else
					Toast.makeText(context, jsonObject.getString("desc"), Toast.LENGTH_SHORT).show();
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.removeOrder_path, map, DB.getSessionid(context));		
	}

	private void PostData3(final String rid){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
//				JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//TODO
					Intent intent = new Intent(context, T2_stskzActivity.class);
					Bundle bundle = new Bundle();
					bundle.putCharSequence("rid", rid);

					intent.putExtras(bundle);
					context.startActivity(intent);	
					sm.send_msg();
				}
				else if (code.equals("550")) {
					AlertDialog alert = new AlertDialog.Builder(context).create();
					alert.setMessage(jsonObject.getString("desc"));
					alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						//DONOTING
						}
					});
					alert.show();
				}	

			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.qushouke_path, map, DB.getSessionid(context));
	}
	
}


