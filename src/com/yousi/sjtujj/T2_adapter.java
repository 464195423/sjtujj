package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.yousi.expired.T2_stskzActivity;
import com.yousi.net.Order_net;
import com.yousi.net.T2_net;
import com.yousi.util.DB;
import com.yousi.util.LoadImage;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;
import com.yousi.util.Send_message;
import com.yousi.util.String_unite;
import com.yousi.util.Switch_pager;

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
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.NumberPicker.OnValueChangeListener;

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
	public ImageView ImageView;
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
	public ImageView ImageView;
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
	public ImageView ImageView;
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
	public ImageView ImageView;
	public TextView textViewtv1;
	public TextView textViewtv2;	
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
	public ImageView ImageView;
	public TextView textViewtv1;
	public TextView textViewtv2;
}

class viewHolder8{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public TextView textViewl5;
	public LinearLayout LinearLayoutbt1;
	public ImageView ImageView;
	public TextView textViewtv1;
	public TextView textViewtv2;
}

class viewHolder9{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public LinearLayout LinearLayoutbt1;
}

class viewHolder10{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public TextView textViewl5;
	public LinearLayout LinearLayoutbt1;
	public ImageView ImageView;
	public TextView textViewtv1;
	public TextView textViewtv2;
}

class viewHolder11{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
	public TextView textViewl5;
}

public class T2_adapter extends BaseAdapter {
private Context context;
private LayoutInflater layoutInflater;
private List<Order_net> list;
private Send_message sm;	//如果需要改变状态则调用此
final int TYPE_1 = 1; 
final int TYPE_2 = 2; 
final int TYPE_3 = 3;
final int TYPE_4 = 4; 
final int TYPE_5 = 5; 
final int TYPE_6 = 6;
final int TYPE_7 = 7; 
final int TYPE_8 = 8; 
final int TYPE_9 = 9;
final int TYPE_10 = 10;
final int TYPE_11 = 11;
final int TYPE_12 = 12;
	public T2_adapter(Context context, List<Order_net> list, Send_message sm){
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
		if (list.get(position).getOrder_status().equals("7"))
			return TYPE_1;
		else if (list.get(position).getOrder_status().equals("1"))
			return TYPE_2;
		else if (list.get(position).getOrder_status().equals("2"))
			return TYPE_3;
		else if (list.get(position).getOrder_status().equals("3"))
			return TYPE_4;
		else if (list.get(position).getOrder_status().equals("4"))
			return TYPE_5;
		else if (list.get(position).getOrder_status().equals("10"))
			return TYPE_6;
		else if (list.get(position).getOrder_status().equals("6"))
			return TYPE_7;
		else if (list.get(position).getOrder_status().equals("5"))
			return TYPE_8;
		else if (list.get(position).getOrder_status().equals("8"))
			return TYPE_9;
		else if (list.get(position).getOrder_status().equals("9"))
			return TYPE_10;
		else if (list.get(position).getOrder_status().equals("11"))
			return TYPE_11;
		else
			return TYPE_12;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 12;
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
		viewHolder9 holder9 = null;
		viewHolder10 holder10 = null;
		viewHolder11 holder11 = null;
		
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
				holder2.ImageView = (ImageView)convertView.findViewById(R.id.t2_t2_iv); 
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
				holder3.ImageView = (ImageView)convertView.findViewById(R.id.t2_t3_iv); 
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
				holder4.ImageView = (ImageView)convertView.findViewById(R.id.t2_t4_iv);
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
				holder5.ImageView = (ImageView)convertView.findViewById(R.id.t2_t5_iv); 
				holder5.textViewtv1 = (TextView)convertView.findViewById(R.id.t2_t5_tv1); 
				holder5.textViewtv2 = (TextView)convertView.findViewById(R.id.t2_t5_tv2); 
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
				holder7.ImageView = (ImageView)convertView.findViewById(R.id.t2_t7_iv); 
				holder7.textViewtv1 = (TextView)convertView.findViewById(R.id.t2_t7_tv1); 
				holder7.textViewtv2 = (TextView)convertView.findViewById(R.id.t2_t7_tv2); 
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
				holder8.ImageView = (ImageView)convertView.findViewById(R.id.t2_t8_iv); 
				holder8.textViewtv1 = (TextView)convertView.findViewById(R.id.t2_t8_tv1); 
				holder8.textViewtv2 = (TextView)convertView.findViewById(R.id.t2_t8_tv2); 
				convertView.setTag(holder8); 
				break;
			case TYPE_9:
				convertView = layoutInflater.inflate(R.layout.t2_ntype9, parent, false); 
				holder9 = new viewHolder9(); 
				holder9.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t9_title2); 
				holder9.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t9_l1); 
				holder9.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t9_l2); 
				holder9.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t9_l3); 
				holder9.LinearLayoutbt1 = (LinearLayout)convertView.findViewById(R.id.t2_t9_bt1); 
				convertView.setTag(holder9); 
				break;
			case TYPE_10:
				convertView = layoutInflater.inflate(R.layout.t2_ntype10, parent, false); 
				holder10 = new viewHolder10(); 
				holder10.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t10_title2); 
				holder10.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t10_l1); 
				holder10.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t10_l2); 
				holder10.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t10_l3); 
				holder10.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t10_l4); 
				holder10.textViewl5 = (TextView)convertView.findViewById(R.id.t2_t10_l5); 
				holder10.LinearLayoutbt1 = (LinearLayout)convertView.findViewById(R.id.t2_t10_bt1); 
				holder10.ImageView = (ImageView)convertView.findViewById(R.id.t2_t10_iv); 
				holder10.textViewtv1 = (TextView)convertView.findViewById(R.id.t2_t10_tv1); 
				holder10.textViewtv2 = (TextView)convertView.findViewById(R.id.t2_t10_tv2); 
				convertView.setTag(holder10); 
				break;
			case TYPE_11:
				convertView = layoutInflater.inflate(R.layout.t2_ntype11, parent, false); 
				holder11 = new viewHolder11(); 
				holder11.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t11_title2); 
				holder11.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t11_l1); 
				holder11.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t11_l2); 
				holder11.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t11_l3); 
				holder11.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t11_l4); 
				holder11.textViewl5 = (TextView)convertView.findViewById(R.id.t2_t11_l5); 
				convertView.setTag(holder11); 
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
			case TYPE_9: 
				holder9 = (viewHolder9) convertView.getTag(); 
				break;
			case TYPE_10: 
				holder10 = (viewHolder10) convertView.getTag(); 
				break;
			case TYPE_11: 
				holder11 = (viewHolder11) convertView.getTag(); 
				break;
			}
		}
		
		switch(type) 
		{ 
		case TYPE_1: 
			holder1.textViewt1.setText("D"+list.get(position).getR_id()); 
			holder1.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder1.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder1.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder1.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			//接单与拒绝
			holder1.textViewtv1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					PostData1_1(list.get(position).getR_id());
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
							PostData1_2(list.get(position).getR_id());
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
			holder2.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder2.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder2.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder2.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder2.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			holder2.textViewl5.setText("剩余联系时间：11:59:59");//TODO
			if (!list.get(position).getPicture().equals(""))
			LoadImage.setImageView(context, list.get(position).getPicture(), holder2.ImageView);
			holder2.textViewtv1.setText(list.get(position).getParentname());
			holder2.textViewtv2.setText(list.get(position).getPhone());
			holder2.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(context, T2_qdstsjActivity.class);
					Bundle bundle = new Bundle();
					bundle.putCharSequence("rid", list.get(position).getR_id());
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
	                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+list.get(position).getPhone()));  
	                context.startActivity(intent); 
				}
			});
			break;
		case TYPE_3: 
			holder3.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder3.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder3.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder3.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder3.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			holder3.textViewl5.setText("确认试教时间：2015-1-1 10:00:00");//TODO
			if (!list.get(position).getPicture().equals(""))
			LoadImage.setImageView(context, list.get(position).getPicture(), holder3.ImageView);
			holder3.textViewtv1.setText(list.get(position).getParentname());
			holder3.textViewtv2.setText(list.get(position).getPhone());
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
							PostData3(list.get(position).getR_id());
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
			holder4.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder4.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder4.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder4.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder4.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			holder4.textViewtv1.setText(list.get(position).getParentname());
			holder4.textViewtv2.setText(list.get(position).getPhone());
			if (!list.get(position).getPicture().equals(""))
			LoadImage.setImageView(context, list.get(position).getPicture(), holder4.ImageView);
			holder4.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (mSwitch != null)
						mSwitch.switch_pager(2);
				}
			});
			break;
		case TYPE_5: 
			holder5.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder5.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder5.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder5.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder5.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			if (!list.get(position).getPicture().equals(""))
			LoadImage.setImageView(context, list.get(position).getPicture(), holder5.ImageView);
			holder5.textViewtv1.setText(list.get(position).getParentname());
			holder5.textViewtv2.setText(list.get(position).getPhone());
			holder5.LinearLayoutbt0.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub 
	                //用intent启动拨打电话  
	                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+list.get(position).getPhone()));  
	                context.startActivity(intent); 
				}
			});
			break;
		case TYPE_6: 
			holder6.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder6.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder6.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder6.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder6.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			break; 
		case TYPE_7: 
			holder7.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder7.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder7.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder7.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder7.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			holder7.textViewl5.setText("剩余课时包："+list.get(position).getDiscount()+"小时");
			if (!list.get(position).getPicture().equals(""))
			LoadImage.setImageView(context, list.get(position).getPicture(), holder7.ImageView);
			holder7.textViewtv1.setText(list.get(position).getParentname());
			holder7.textViewtv2.setText(list.get(position).getPhone());
			holder7.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (mSwitch != null)
						mSwitch.switch_pager(2);
				}
			});
			break; 
		case TYPE_8: 
			holder8.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder8.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder8.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder8.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder8.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			holder8.textViewl5.setText("剩余课时包："+list.get(position).getDiscount()+"小时");
			if (!list.get(position).getPicture().equals(""))
			LoadImage.setImageView(context, list.get(position).getPicture(), holder8.ImageView);
			holder8.textViewtv1.setText(list.get(position).getParentname());
			holder8.textViewtv2.setText(list.get(position).getPhone());
			holder8.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
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
							PostData8(list.get(position).getR_id(),hour[0]);
						}
					});
					dlg.show();
				}
			});
			break; 
		case TYPE_9: 
			holder9.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder9.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder9.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder9.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder9.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			holder9.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 放弃等待
				}
			});
			break; 
		case TYPE_10: 
			holder10.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder10.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder10.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder10.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder10.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			holder10.textViewl5.setText("剩余课时包："+list.get(position).getDiscount()+"小时");
			if (!list.get(position).getPicture().equals(""))
			LoadImage.setImageView(context, list.get(position).getPicture(), holder10.ImageView);
			holder10.textViewtv1.setText(list.get(position).getParentname());
			holder10.textViewtv2.setText(list.get(position).getPhone());
			holder10.LinearLayoutbt1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 设置撤销放弃					
					AlertDialog alert = new AlertDialog.Builder(context).create();
					alert.setMessage("您将要进行试听授课，请确认！");
					alert.setButton(DialogInterface.BUTTON_POSITIVE,"确认", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						//TODO
							PostData10(list.get(position).getR_id());
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
		case TYPE_11: 
			holder11.textViewt1.setText("订单号：  D"+list.get(position).getR_id()); 
			holder11.textViewl1.setText("学生姓名："+list.get(position).getName()); 
			holder11.textViewl2.setText("学生年级："+list.get(position).getGrade());
			holder11.textViewl3.setText("辅导科目："+String_unite.unite(list.get(position).getWeaksubject(),"、"));
			holder11.textViewl4.setText("小时单价："+list.get(position).getOneprice()+"元/时");
			holder11.textViewl5.setText("失效原因："+list.get(position).getInfo());
			break; 
		}
		
		
		if (type == TYPE_12 )
		{
			//error
			TextView tv = new TextView(context);
			tv.setText("error");
			return tv;
		}
		return convertView;
	}

	/* 接单 */
	private void PostData1_1(String rid){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
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
		}, NewMyPath.getOrder_path, map, DB.getSessionid(context));		
	}
	
	/* 拒绝 */
	private void PostData1_2(final String rid){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
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
		}, NewMyPath.refuseOrder_path, map, DB.getSessionid(context));		
	}

	/* 去试教 */
	private void PostData3(final String rid){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					//TODO
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
		}, NewMyPath.beginToTeach_path, map, DB.getSessionid(context));
	}

	
	/* 去授课 */
	private void PostData8(final String rid, final int hour){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		map.put("hour", String.valueOf(hour));
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
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
		}, NewMyPath.beginToTeach_path, map, DB.getSessionid(context));		
	}	
	
	/* 撤销放弃 */
	private void PostData10(String rid){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		MyHttpClient.doPost2(context, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
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
		}, NewMyPath.revokeOrder_path, map, DB.getSessionid(context));		
	}	
	
	private static Switch_pager mSwitch=null;
	public static void setCallback(Switch_pager callback){
		if (callback != null)
			mSwitch = callback;
	}
}


