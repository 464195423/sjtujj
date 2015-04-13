package com.yousi.sjtujj;

import java.util.List;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class T3_2adapter extends BaseExpandableListAdapter{
private Context context;	
private List<String> listtype;	
private List<String>[] list; 

	public T3_2adapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return listtype.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return list[groupPosition].size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return listtype.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return list[groupPosition].get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LinearLayout ll = new LinearLayout(
                context);
        ll.setOrientation(0);
        TextView textView = new TextView(context);
				
        textView.setText(listtype.get(groupPosition));
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        ll.addView(textView);
        
        return ll;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LinearLayout ll = new LinearLayout(
                context);
        ll.setOrientation(0);
        TextView textView = new TextView(context);
				
        textView.setText(list[groupPosition].get(childPosition));
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        ll.addView(textView);
        
        return ll;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
