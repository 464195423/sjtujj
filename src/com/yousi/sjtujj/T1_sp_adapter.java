package com.yousi.sjtujj;

import java.util.List;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class T1_sp_adapter extends BaseAdapter {
private Context context;
private List<String> list;
	public T1_sp_adapter(Context context, List<String> ls) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = ls;
		
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
		TextView view = new TextView(context);
		
		
		view.setText(list.get(position));
		view.setTextSize(20);
		view.setGravity(Gravity.CENTER);
		
		return view;
	}

}
