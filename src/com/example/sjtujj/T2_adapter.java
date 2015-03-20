package com.example.sjtujj;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class viewHolder1{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
}

class viewHolder2{
	public TextView textViewt1;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
}

class viewHolder3{
	public TextView textViewt1;
	public TextView textViewt2;
}

class viewHolder4{
	public TextView textViewt1;
	public TextView textViewt2;
}

class viewHolder5{
	public TextView textViewt1;
	public TextView textViewt2;
}

class viewHolder6{
	public TextView textViewt1;
	public TextView textViewt2;
}

class viewHolder7{
	public TextView textViewt1;
	public TextView textViewt2;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
}

class viewHolder8{
	public TextView textViewt1;
	public TextView textViewt2;
	public TextView textViewl1;
	public TextView textViewl2;
	public TextView textViewl3;
	public TextView textViewl4;
}

public class T2_adapter extends BaseAdapter {
private Context context;
private LayoutInflater layoutInflater;
private List<T2_net> list;
final int TYPE_1 = 1; 
final int TYPE_2 = 2; 
final int TYPE_3 = 3;
final int TYPE_4 = 4; 
final int TYPE_5 = 5; 
final int TYPE_6 = 6;
final int TYPE_7 = 7; 
final int TYPE_8 = 8; 
final int TYPE_9 = 9;
	public T2_adapter(Context context, List<T2_net> list){
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
	public View getView(int position, View convertView, ViewGroup parent) {
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
				convertView = layoutInflater.inflate(R.layout.t2_type1, parent, false); 
				holder1 = new viewHolder1(); 
				holder1.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t1_title1); 
				holder1.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t1_l1); 
				holder1.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t1_l2); 
				holder1.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t1_l3); 
				holder1.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t1_l4); 
				convertView.setTag(holder1); 
				break;
			case TYPE_2:
				convertView = layoutInflater.inflate(R.layout.t2_type2, parent, false); 
				holder2 = new viewHolder2(); 
				holder2.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t2_title1); 
				holder2.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t2_l1); 
				holder2.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t2_l2); 
				holder2.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t2_l3); 
				holder2.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t2_l4); 
				convertView.setTag(holder2); 
				break;
			case TYPE_3:
				convertView = layoutInflater.inflate(R.layout.t2_type3, parent, false); 
				holder3 = new viewHolder3(); 
				holder3.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t3_title1); 
				holder3.textViewt2 = (TextView)convertView.findViewById(R.id.t2_t3_title2); 
				convertView.setTag(holder3); 
				break;
			case TYPE_4:
				convertView = layoutInflater.inflate(R.layout.t2_type4, parent, false); 
				holder4 = new viewHolder4(); 
				holder4.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t4_title1); 
				holder4.textViewt2 = (TextView)convertView.findViewById(R.id.t2_t4_title2); 
				convertView.setTag(holder4); 
				break;
			case TYPE_5:
				convertView = layoutInflater.inflate(R.layout.t2_type5, parent, false); 
				holder5 = new viewHolder5(); 
				holder5.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t5_title1); 
				holder5.textViewt2 = (TextView)convertView.findViewById(R.id.t2_t5_title2); 
				convertView.setTag(holder5); 
				break;
			case TYPE_6:
				convertView = layoutInflater.inflate(R.layout.t2_type6, parent, false); 
				holder6 = new viewHolder6(); 
				holder6.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t6_title1); 
				holder6.textViewt2 = (TextView)convertView.findViewById(R.id.t2_t6_title2); 
				convertView.setTag(holder6); 
				break;
			case TYPE_7:
				convertView = layoutInflater.inflate(R.layout.t2_type7, parent, false); 
				holder7 = new viewHolder7(); 
				holder7.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t7_title1); 
				holder7.textViewt2 = (TextView)convertView.findViewById(R.id.t2_t7_title2); 
				holder7.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t7_l1); 
				holder7.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t7_l2); 
				holder7.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t7_l3); 
				convertView.setTag(holder7); 
				break;
			case TYPE_8:
				convertView = layoutInflater.inflate(R.layout.t2_type8, parent, false); 
				holder8 = new viewHolder8(); 
				holder8.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t8_title1); 
				holder8.textViewt2 = (TextView)convertView.findViewById(R.id.t2_t8_title2); 
				holder8.textViewl1 = (TextView)convertView.findViewById(R.id.t2_t8_l1); 
				holder8.textViewl2 = (TextView)convertView.findViewById(R.id.t2_t8_l2); 
				holder8.textViewl3 = (TextView)convertView.findViewById(R.id.t2_t8_l3); 
				holder8.textViewl4 = (TextView)convertView.findViewById(R.id.t2_t8_l4); 
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
			holder1.textViewt1.setText("D"+list.get(position).getRid()+" 预约单"); 
			holder1.textViewl1.setText(list.get(position).getGradename()+" "+list.get(position).getSexname()
					+" "+list.get(position).getWeaksubjectname()); 
			holder1.textViewl2.setText(list.get(position).getAddress());
			holder1.textViewl3.setText(list.get(position).getQualification());
			holder1.textViewl4.setText(list.get(position).getOnehourprice()+"元/小时");
			break;
		case TYPE_2: 
			holder2.textViewt1.setText("D"+list.get(position).getRid()+" 已接单，未联系"); 
			holder2.textViewl1.setText(list.get(position).getGradename()+" "+list.get(position).getSexname()
					+" "+list.get(position).getWeaksubjectname()); 
			holder2.textViewl2.setText(list.get(position).getAddress());
			holder2.textViewl3.setText(list.get(position).getQualification());
			holder2.textViewl4.setText(list.get(position).getOnehourprice()+"元/小时");
			break;
		case TYPE_3: 
			holder3.textViewt1.setText("D"+list.get(position).getRid()+" 已联系，未试听");
			holder3.textViewt2.setText("学生 : "+list.get(position).getSname());
			break;
		case TYPE_4: 
			holder4.textViewt1.setText("D"+list.get(position).getRid()+" 已联系，试听中");
			holder4.textViewt2.setText("学生 : "+list.get(position).getSname());
			break;
		case TYPE_5: 
			holder5.textViewt1.setText("D"+list.get(position).getRid()+" 已试听完成");
			holder5.textViewt2.setText("学生 : "+list.get(position).getSname());
			break;
		case TYPE_6: 
			holder6.textViewt1.setText("D"+list.get(position).getRid()+" 未雇佣");
			holder6.textViewt2.setText("学生 : "+list.get(position).getSname());
			break; 
		case TYPE_7: 
			holder7.textViewt1.setText("D"+list.get(position).getRid()+" 授课进行中");
			holder7.textViewt2.setText("学生 : "+list.get(position).getSname());
			holder7.textViewl1.setText("小时单价 ： "+list.get(position).getOnehourprice()+"元");
			holder7.textViewl2.setText("已授时长 ： "+list.get(position).getTeach_hours()+"小时");
			holder7.textViewl3.setText("剩余有效课时包 ： "+list.get(position).getDiscount_hours()+"小时");
			break; 
		case TYPE_8: 
			holder8.textViewt1.setText("D"+list.get(position).getRid()+" 授课单");
			holder8.textViewt2.setText("学生 : "+list.get(position).getSname());
			holder8.textViewl1.setText("小时单价 ： "+list.get(position).getOnehourprice()+"元");
			holder8.textViewl2.setText("已授时长 ： "+list.get(position).getTeach_hours()+"小时");
			holder8.textViewl3.setText("剩余有效课时包 ： "+list.get(position).getDiscount_hours()+"小时");
			if (Integer.parseInt(list.get(position).getDiscount_hours()) < 2)
				holder8.textViewl4.setVisibility(0);
			break; 
		}
			
		if (type == TYPE_9)
			return null;
		
		return convertView;
	}

	

}


