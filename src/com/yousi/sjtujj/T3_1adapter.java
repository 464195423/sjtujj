package com.yousi.sjtujj;

import java.util.List;

import com.yousi.net.T2_net;
import com.yousi.util.Send_message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

class viewHolder3_1_1{
	public TextView textViewt1;
	public ImageView imageview1;
	public TextView textViewtvl;
	public TextView textViewtv1;
	public TextView textViewtv2;
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
private List<String> list;

	public T3_1adapter(Context context, List<String> list){
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
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		int type = 0;
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
				holder1.textViewbt1 = (TextView)convertView.findViewById(R.id.t3_1t1_bt1); 
				holder1.textViewbt2 = (TextView)convertView.findViewById(R.id.t3_1t1_bt2); 
				holder1.textViewbt3 = (TextView)convertView.findViewById(R.id.t3_1t1_bt3); 
				convertView.setTag(holder1); 
				break;
			case 1:
				/*
				convertView = layoutInflater.inflate(R.layout.t3_1ntype2, parent, false); 
				holder2 = new viewHolder2(); 

				convertView.setTag(holder2); 
				*/
				;
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
			;//TODO,SET
			break; 
		case 1: 
			;//TODO,SET
			break; 
		}
		
				
		return convertView;
	}

}
