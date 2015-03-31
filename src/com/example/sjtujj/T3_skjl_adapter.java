package com.example.sjtujj;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class T3_viewHolder{
	public TextView textView1;
	public TextView textView2;
	public TextView textView3;
	public TextView textView4;
}

public class T3_skjl_adapter extends BaseAdapter {
private Context context;
private LayoutInflater layoutInflater;	
private List<T3_skjl_net> list;

	public T3_skjl_adapter(Context context, List<T3_skjl_net> list){
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
		T3_viewHolder holder = null;
		
		if(convertView == null)
		{
			convertView = layoutInflater.inflate(R.layout.t3_skjl_adapter, parent, false);
			holder = new T3_viewHolder(); 
			holder.textView1 = (TextView)convertView.findViewById(R.id.t3_skjl_tv1); 
			holder.textView2 = (TextView)convertView.findViewById(R.id.t3_skjl_tv2); 
			holder.textView3 = (TextView)convertView.findViewById(R.id.t3_skjl_tv3); 
			holder.textView4 = (TextView)convertView.findViewById(R.id.t3_skjl_tv4); 
			convertView.setTag(holder); 
		}
		else
			holder = (T3_viewHolder) convertView.getTag(); 
		
		holder.textView1.setText(list.get(position).getH_id());
		holder.textView2.setText("开始时间："+list.get(position).getH_create_date());
		holder.textView3.setText("结束时间："+list.get(position).getH_end_time());
		holder.textView4.setText(list.get(position).getH_hours()+"小时");
		return convertView;
	}
}
