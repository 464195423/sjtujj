package com.example.sjtujj;

import java.util.List;
import java.util.Map;

import android.content.Context;
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

class viewHolder6{
	public TextView textViewt1;
	public TextView textViewt2;
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
		viewHolder6 holder6 = null;
		
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
			case TYPE_6:
				convertView = layoutInflater.inflate(R.layout.t2_type6, parent, false); 
				holder6 = new viewHolder6(); 
				holder6.textViewt1 = (TextView)convertView.findViewById(R.id.t2_t6_title1); 
				holder6.textViewt2 = (TextView)convertView.findViewById(R.id.t2_t6_title2); 
				convertView.setTag(holder1); 				
			
			}
			
			
		}else{
			switch(type) 
			{ 
			case TYPE_1: 
				holder1 = (viewHolder1) convertView.getTag(); 
				break; 
			case TYPE_6: 
				holder6 = (viewHolder6) convertView.getTag(); 
				break; 	
			
			}
		}
		
		switch(type) 
		{ 
		case TYPE_1: 
			holder1.textViewt1.setText("D"+list.get(position).getRid()+" 预约单"); 
			break;
		case TYPE_6: 
			holder6.textViewt1.setText("D"+list.get(position).getRid()+" 未雇佣");
			holder6.textViewt2.setText("学生 : "+list.get(position).getSname());
			break; 
		}
			
			
		return convertView;
	}

	

}


