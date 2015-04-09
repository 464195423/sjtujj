package com.yousi.sjtujj;

import java.util.List;



import com.yousi.net.Info_net;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class viewHolder{
	public TextView textView1;
	public TextView textView2;
	public TextView textView3;
}

public class Info_adapter extends BaseAdapter {
private Context context;
private LayoutInflater layoutInflater;	
private List<Info_net> list;

	public Info_adapter(Context context, List<Info_net> list){
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
		viewHolder holder = null;
		
		
		
		if(convertView == null)
		{
			convertView = layoutInflater.inflate(R.layout.info_type, parent, false);
			holder = new viewHolder(); 
			holder.textView1 = (TextView)convertView.findViewById(R.id.info_tv1); 
			holder.textView2 = (TextView)convertView.findViewById(R.id.info_tv2); 
			holder.textView3 = (TextView)convertView.findViewById(R.id.info_tv3); 
			convertView.setTag(holder); 
		}
		else
			holder = (viewHolder) convertView.getTag(); 
		
		holder.textView1.setText(list.get(position).getTitle());
		if (list.get(position).getTitle().equals(""))
			holder.textView1.setVisibility(View.GONE);
		holder.textView2.setText(list.get(position).getContent());
		holder.textView3.setText(list.get(position).getTime());
		return convertView;
	}

}
