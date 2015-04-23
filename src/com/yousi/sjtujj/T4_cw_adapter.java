package com.yousi.sjtujj;

import java.util.List;

import com.yousi.net.T4_cw_net;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.text.TextUtils;

class MyHolder{
	public TextView tv1;
	public TextView tv2;
	public TextView tv3;
	public boolean isClicked;
}

public class T4_cw_adapter extends BaseAdapter{
private Context context;
private List<T4_cw_net> list;
private LayoutInflater layoutInflater;
private MyHolder holder;

	public T4_cw_adapter(Context context, List<T4_cw_net> list) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
		layoutInflater = LayoutInflater.from(context);   
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		holder = null;
		
		if(convertView == null)
		{
			convertView = layoutInflater.inflate(R.layout.t4_cw_list, parent, false);
			holder = new MyHolder(); 
			holder.tv1 = (TextView) convertView.findViewById(R.id.t4_cw_tv1);
			holder.tv2 = (TextView) convertView.findViewById(R.id.t4_cw_tv2);
			holder.tv3 = (TextView) convertView.findViewById(R.id.t4_cw_tv3);
			convertView.setTag(holder);
		}
		else
			holder = (MyHolder) convertView.getTag(); 
		
		holder.tv1.setText(list.get(position).getCreate_time());
		holder.tv2.setText(list.get(position).getDesc());
		holder.tv3.setText((list.get(position).getStatus().equals("1") ? "+" : "-") + list.get(position).getGold());
		holder.tv3.setTextColor(list.get(position).getStatus().equals("1") ? 0xff57caa0 : 0xffef6767 );
		
		//设置点击事件
		holder.isClicked = false;
		holder.tv2.setSingleLine();
		holder.tv2.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
		
		convertView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v("===","======");
				
				holder.isClicked = ! holder.isClicked;
				if (holder.isClicked){
					holder.tv2.setMaxLines(10);
				}
				else{
					holder.tv2.setSingleLine();
					holder.tv2.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
				}
			}
		});
			
		return convertView;
	}
}
