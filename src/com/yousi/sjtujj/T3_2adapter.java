package com.yousi.sjtujj;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.yousi.net.Classlist;
import com.yousi.net.T3_2net;
import com.yousi.util.DB;
import com.yousi.util.LoadImage;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.Visibility;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class T3_2viewHolder1{
	public LinearLayout ll;
	public TextView textView1;
}

class T3_2viewHolder2{
	public TextView textViewTitle1;
	public TextView textViewTitle2;
	public ImageView imageView1;
	public TextView textViewtvl;
	public TextView textViewstart;
	public TextView textViewend;
	public TextView textViewtv1;
	public TextView textViewtv2;
	public ImageView imageView2;
	
}

public class T3_2adapter extends BaseExpandableListAdapter{
private Context context;	
private List<T3_2net> list;
private LayoutInflater layoutInflater;		

	public T3_2adapter(Context context, List<T3_2net> T3_2netItems) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = T3_2netItems;
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return list.get(groupPosition).getClasslist() == null ? 0 : list.get(groupPosition).getClasslist().length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return list.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return list.get(groupPosition).getClasslist() == null ? null : list.get(groupPosition).getClasslist()[childPosition];
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
		T3_2viewHolder1 holder = null;
		
		if(convertView == null)
		{
			convertView = layoutInflater.inflate(R.layout.t3_list, parent, false);
			holder = new T3_2viewHolder1(); 
			holder.textView1 = (TextView)convertView.findViewById(R.id.t3_list_tv); 
			holder.ll = (LinearLayout)convertView.findViewById(R.id.t3_list_ll);

			convertView.setTag(holder); 
		}
		else
			holder = (T3_2viewHolder1) convertView.getTag(); 
		
		if (groupPosition != 0){
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); 
			lp.setMargins(0, 10, 0, 0);
			holder.ll.setLayoutParams(lp);
		}
		holder.textView1.setText("订单号："+list.get(groupPosition).getR_id());
        
        return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		T3_2viewHolder2 holder = null;
	
		if(convertView == null)
		{
			convertView = layoutInflater.inflate(R.layout.t3_classlist, parent, false);
			holder = new T3_2viewHolder2(); 
			holder.textViewTitle1 = (TextView)convertView.findViewById(R.id.t3_classlist_title1); 
			holder.textViewTitle2 = (TextView)convertView.findViewById(R.id.t3_classlist_title2);
			holder.imageView1 = (ImageView)convertView.findViewById(R.id.t3_classlist_iv1);
			holder.textViewtvl = (TextView)convertView.findViewById(R.id.t3_classlist_tvl);
			holder.textViewstart = (TextView)convertView.findViewById(R.id.t3_classlist_start);
			holder.textViewend = (TextView)convertView.findViewById(R.id.t3_classlist_end);
			holder.textViewtv1 = (TextView)convertView.findViewById(R.id.t3_classlist_tv1);
			holder.textViewtv2 = (TextView)convertView.findViewById(R.id.t3_classlist_tv2);
			holder.imageView2 = (ImageView)convertView.findViewById(R.id.t3_classlist_iv2);
			convertView.setTag(holder); 
		}
		else
			holder = (T3_2viewHolder2) convertView.getTag(); 
        
		holder.textViewTitle1.setText(list.get(groupPosition).getClasslist()[childPosition].getH_status().equals("0") ? "常规授课" : "试听授课");
		holder.textViewTitle2.setText("课程号："+list.get(groupPosition).getClasslist()[childPosition].getH_id());
		if (!list.get(groupPosition).getPicture().equals(""))
			LoadImage.setImageView(context, list.get(groupPosition).getPicture(), holder.imageView1);
		holder.textViewtvl.setText(list.get(groupPosition).getParentname());
		holder.textViewstart.setText(list.get(groupPosition).getClasslist()[childPosition].getH_create_date());
		holder.textViewend.setText(list.get(groupPosition).getClasslist()[childPosition].getH_end_time());
		holder.textViewtv1.setText(list.get(groupPosition).getClasslist()[childPosition].getH_hours()+"小时");
		
		if (list.get(groupPosition).getClasslist()[childPosition].getA_status() == null){
			holder.textViewtv2.setText("等待评价");
			holder.textViewtv2.setBackgroundDrawable(null);
			holder.textViewtv2.setTextColor(0xff646464);
		}
		else{
			holder.textViewtv2.setText("查看评价");
			holder.textViewtv2.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.t3_button));
			holder.textViewtv2.setTextColor(0xff36a5df);
		}
		
		if (isLastChild)
			holder.imageView2.setVisibility(View.GONE);
		else
			holder.imageView2.setVisibility(View.VISIBLE);
		
        return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
