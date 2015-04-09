package com.yousi.sjtujj;

import java.util.List;



import com.yousi.net.T1_demand_net;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


class T1_viewHolder{
	public TextView textView1;
	public TextView textView2;
	public TextView textView3;
	public TextView textView4;
}

public class T1_adapter extends BaseAdapter {
private Context context;
private LayoutInflater layoutInflater;	
private List<T1_demand_net> list;

	public T1_adapter(Context context, List<T1_demand_net> list){
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
		T1_viewHolder holder = null;
		
		
		
		if(convertView == null)
		{
			convertView = layoutInflater.inflate(R.layout.t1_adapter, parent, false);
			holder = new T1_viewHolder(); 
			holder.textView1 = (TextView)convertView.findViewById(R.id.t1_tv1); 
			holder.textView2 = (TextView)convertView.findViewById(R.id.t1_tv2); 
			holder.textView3 = (TextView)convertView.findViewById(R.id.t1_tv3); 
			holder.textView4 = (TextView)convertView.findViewById(R.id.t1_tv4); 
			convertView.setTag(holder); 
		}
		else
			holder = (T1_viewHolder) convertView.getTag(); 
		
		holder.textView1.setText(list.get(position).getGradename()+ "  " + list.get(position).getSexname() + "  " +
				list.get(position).getR_weaksubjectname());
		holder.textView2.setText(list.get(position).getAddress());
		holder.textView3.setText(list.get(position).getR_teacher_qualification());
		holder.textView4.setText(list.get(position).getHalf_price()+"Ԫ/ʱ");
		return convertView;
	}

}
