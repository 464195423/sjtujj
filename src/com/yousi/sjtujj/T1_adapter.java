package com.yousi.sjtujj;

import java.util.List;







import com.yousi.net.Special;
import com.yousi.net.T1_demand_net;
import com.yousi.net.T1_net;

import android.content.Context;
import android.opengl.Visibility;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


class T1_viewHolder{
	public TextView textView1;
	public TextView textView2;
	public TextView textView3;
	public TextView textView5;
	public TextView textView6;
	public TextView textView7;
	public TextView textView8;
	public TextView textView9;
	
}

public class T1_adapter extends BaseAdapter {
private Context context;
private LayoutInflater layoutInflater;	
private List<T1_net> list;

	public T1_adapter(Context context, List<T1_net> list){
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
			holder.textView1 = (TextView)convertView.findViewById(R.id.t1_title); 
			holder.textView2 = (TextView)convertView.findViewById(R.id.t1_tv1); 
			holder.textView3 = (TextView)convertView.findViewById(R.id.t1_tv2); 
			holder.textView5 = (TextView)convertView.findViewById(R.id.t1_xq1); 
			holder.textView6 = (TextView)convertView.findViewById(R.id.t1_xq2); 
			holder.textView7 = (TextView)convertView.findViewById(R.id.t1_xq3); 
			holder.textView8 = (TextView)convertView.findViewById(R.id.t1_xq4); 
			holder.textView9 = (TextView)convertView.findViewById(R.id.t1_price);  
			convertView.setTag(holder); 
		}
		else
			holder = (T1_viewHolder) convertView.getTag(); 
		
		
		String str = "";
		for (int i = 0; i < list.get(position).getWeaksubject().length; i++)
			str += list.get(position).getWeaksubject()[i] + " ";
		holder.textView1.setText(list.get(position).getGradename()+ "  " + list.get(position).getSexname() + "  " +
				str);
		holder.textView2.setText(list.get(position).getAddress());
		holder.textView3.setText(list.get(position).getQualification());
		
		holder.textView5.setVisibility(View.GONE);
		holder.textView6.setVisibility(View.GONE);
		holder.textView7.setVisibility(View.GONE);
		
		Special tmp[] = list.get(position).getSpecial();
		for (int i = 0; i < tmp.length; i++){
			if (tmp[i].getName().equals("¾ºÈü¸¨µ¼"))
				holder.textView5.setVisibility(View.VISIBLE);
			if (tmp[i].getName().equals("ÍâÓïÊÚ¿Î"))
				holder.textView6.setVisibility(View.VISIBLE);
			if (tmp[i].getName().equals("ÍâÓï½Ì²ÄººÓïÊÚ¿Î"))
				holder.textView7.setVisibility(View.VISIBLE);
		}
		
		holder.textView8.setVisibility(View.GONE);
		if (!list.get(position).getAddStatus().equals("0"))
			holder.textView8.setVisibility(View.VISIBLE);
		
		holder.textView9.setText("£¤"+list.get(position).getOneprice()+"Ôª/Ê±");
		return convertView;
	}

}
