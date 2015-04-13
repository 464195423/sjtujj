package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass. Use the {@link DdxxFragment#newInstance}
 * factory method to create an instance of this fragment.
 *
 */
public class NddxxFragment extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "rid";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters

	private String rid;
	private T2_ddxx_net T2_ddxx_netItems;
	private String add_price;
	
	
	/**
	 * Use this factory method to create a new instance of this fragment using
	 * the provided parameters.
	 *
	 * @param param1
	 *            Parameter 1.
	 * @param param2
	 *            Parameter 2.
	 * @return A new instance of fragment DdxxFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static NddxxFragment newInstance(String param1) {
		NddxxFragment fragment = new NddxxFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		fragment.setArguments(args);
		return fragment;
	}

	public NddxxFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			rid = getArguments().getString(ARG_PARAM1);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		getData();
		return inflater.inflate(R.layout.fragment_nddxx, container, false);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		//map.put("pwd", passwd.getText().toString());
		MyHttpClient.doPost2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					T2_ddxx_netItems = JSONObject.parseObject(data1.toString(), T2_ddxx_net.class);	
					//Log.v("data1",data1.get("additional_price").toString());
					if (data1.get("additional_price") == null)
						add_price = null;
					else
						add_price = data1.get("additional_price").toString();
					setData();
				}
			}
			@Override
			public void netWorkError() {
			}
		}, MyPath.ddxx_path, map, DB.getSessionid(getActivity()));
	}	
	
	private void setData(){
		TextView l1_tv1 = (TextView)getView().findViewById(R.id.ddxx_l1_tv1);
		TextView l1_tv2 = (TextView)getView().findViewById(R.id.ddxx_l1_tv2);
		TextView l1_tv3 = (TextView)getView().findViewById(R.id.ddxx_l1_tv3);
		TextView l1_tv4 = (TextView)getView().findViewById(R.id.ddxx_l1_tv4);
		TextView l1_tv5 = (TextView)getView().findViewById(R.id.ddxx_l1_tv5);
		TextView l1_tv6 = (TextView)getView().findViewById(R.id.ddxx_l1_tv6);
		
		TextView l2_tv1 = (TextView)getView().findViewById(R.id.ddxx_l2_tv1);
		TextView l2_tv2 = (TextView)getView().findViewById(R.id.ddxx_l2_tv2);
		TextView l2_tv3 = (TextView)getView().findViewById(R.id.ddxx_l2_tv3);
		TextView l2_tv4 = (TextView)getView().findViewById(R.id.ddxx_l2_tv4);
		TextView l2_tv5 = (TextView)getView().findViewById(R.id.ddxx_l2_tv5);
		
		TextView l3_tv1 = (TextView)getView().findViewById(R.id.ddxx_l3_tv1);
		TextView l3_tv2 = (TextView)getView().findViewById(R.id.ddxx_l3_tv2);
		TextView l3_tv3 = (TextView)getView().findViewById(R.id.ddxx_l3_tv3);
		
		//l1_tv1.setText(T2_ddxx_netItems.get);//TODO
		l1_tv2.setText(T2_ddxx_netItems.getS_gradename());
		l1_tv3.setText(T2_ddxx_netItems.getS_sexname());
		l1_tv4.setText(T2_ddxx_netItems.getParentname());
		l1_tv5.setText(T2_ddxx_netItems.getPhone());
		l1_tv6.setText(Html.fromHtml("<font color=#738ffe>"
				+T2_ddxx_netItems.getAddress()
				+"</font>"
				+"<font color=#AAAAAA>(����ɲ鿴��ͼ)</font>"));
		l1_tv6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), MapActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("place", T2_ddxx_netItems.getAddress());
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		//l2_tv1.setText(T2_ddxx_netItems.get);//TODO
		l2_tv2.setText(T2_ddxx_netItems.getR_weaksubjectname());
		if (!T2_ddxx_netItems.getAdditional_subject().equals(""))
			l2_tv3.setText(T2_ddxx_netItems.getAdditional_subject());
		if (!T2_ddxx_netItems.getPeople_count().equals("1"))
			l2_tv4.setText(T2_ddxx_netItems.getPeople_count()+"��");
		//l2_tv5.setText(T2_ddxx_netItems.get);//TODO
		
		l3_tv1.setText(T2_ddxx_netItems.getAdd_price()+"Ԫ/ʱ");
		String str = "";
		if (add_price != null)
		{
			JSONObject data2 = JSONObject.parseObject(add_price);
			if (data2.get("�����ڿ�") != null)
				str += "  �����ڿ�:"+data2.get("�����ڿ�").toString()+"Ԫ/ʱ";
			if (data2.get("����̲ĺ����ڿ�") != null)
				str += "  ����̲ĺ����ڿ�:"+data2.get("����̲ĺ����ڿ�").toString()+"Ԫ/ʱ";
			if (data2.get("��������") != null)
				str += "  ��������:"+data2.get("��������").toString()+"Ԫ/ʱ";
		}
		l3_tv2.setText(T2_ddxx_netItems.getHalf_price()+"Ԫ/ʱ"+"\n"
				+"("+T2_ddxx_netItems.getS_gradename()+":"+T2_ddxx_netItems.getGrade_price()+"Ԫ/ʱ"
				+(T2_ddxx_netItems.getAdd_price().equals("0") ? "" : ("  �Ӽ�:"+T2_ddxx_netItems.getAdd_price()+"Ԫ/ʱ"))
				+ str + ")");
		l3_tv3.setText(T2_ddxx_netItems.getPay_status());
		
//		tv1.setText(T2_ddxx_netItems.getS_gradename());
//		tv2.setText(T2_ddxx_netItems.getS_sexname());
//		tv3.setText(T2_ddxx_netItems.getR_weaksubjectname());
//		tv4.setText(Html.fromHtml("<font color=#66ccff>"
//						+T2_ddxx_netItems.getAddress()
//						+"</font>"
//						+"<font color=#AAAAAA>(����ɲ鿴��ͼ)</font>"));
//		
//		tv4.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(getActivity(), MapActivity.class);
//				Bundle bundle = new Bundle();
//				bundle.putCharSequence("place", T2_ddxx_netItems.getAddress());
//				intent.putExtras(bundle);
//				startActivity(intent);
//			}
//		});
//		
//		
//		tv5.setText(T2_ddxx_netItems.getT_sexname());
//		if (!T2_ddxx_netItems.getAdditional_subject().equals(""))
//			tv6.setText(T2_ddxx_netItems.getAdditional_subject());
//		if (!T2_ddxx_netItems.getPeople_count().equals("1"))
//			tv7.setText(T2_ddxx_netItems.getPeople_count()+"��");
//		tv8.setText(T2_ddxx_netItems.getTeacher_qualification());
//		
//		boolean t = false;
//		String str = "";
//		if (add_price == null)
//		{
//			t = false;
//			//Log.v("addprice","null");
//		}
//		else
//		{
//			/*
//			//Log.v("debug",T2_ddxx_netItems.getAdditional_price().debug());
//			//Log.v("addprice","not null");
//			if (T2_ddxx_netItems.getAdditional_price().get�����ڿ�() != null){
//				str += "�����ڿ�("+T2_ddxx_netItems.getAdditional_price().get�����ڿ�()+"Ԫ/ʱ) ";
//				//Log.v("addprice","�����ڿ�");
//				t = true;
//			}
//			if (T2_ddxx_netItems.getAdditional_price().get��������() != null){
//				str += "��������("+T2_ddxx_netItems.getAdditional_price().get��������()+"Ԫ/ʱ) ";
//				//Log.v("addprice","��������");
//				t = true;
//			}
//			if (T2_ddxx_netItems.getAdditional_price().get����̲ĺ����ڿ�() != null){
//				str += "����̲ĺ����ڿ�("+T2_ddxx_netItems.getAdditional_price().get����̲ĺ����ڿ�()+"Ԫ/ʱ) ";
//				//Log.v("addprice","����̲ĺ����ڿ�");
//				t = true;
//			}
//			
//			*/
//			JSONObject data2 = JSONObject.parseObject(add_price);
//			/*
//			T2_ddxx_tsxq_net T2_ddxx_tsxq_netItems = JSONObject.parseObject(data2.toString(), T2_ddxx_tsxq_net.class);	
//			//Log.v("data1",data1.get("additional_price").toString());
//			//add_price = data2.get("additional_price").toString();
//			Log.v("�����ڿ�","+"+T2_ddxx_tsxq_netItems.get�����ڿ�());
//			Log.v("����̲ĺ����ڿ�","+"+T2_ddxx_tsxq_netItems.get����̲ĺ����ڿ�());
//			Log.v("��������","+"+T2_ddxx_tsxq_netItems.get��������());
//			
//			Log.v("data","+"+data2.toString());
//			//Log.v("�����ڿ�","+"+data2.get("�����ڿ�").toString());
//			//Log.v("����̲ĺ����ڿ�","+"+data2.get("����̲ĺ����ڿ�").toString());
//			Log.v("��������","+"+data2.get("��������").toString());
//			*/
//			t = true;
//			if (data2.get("�����ڿ�") != null)
//				str += "�����ڿ�("+data2.get("�����ڿ�").toString()+"Ԫ/ʱ) ";
//			if (data2.get("����̲ĺ����ڿ�") != null)
//				str += "����̲ĺ����ڿ�("+data2.get("����̲ĺ����ڿ�").toString()+"Ԫ/ʱ) ";
//			if (data2.get("��������") != null)
//				str += "��������("+data2.get("��������").toString()+"Ԫ/ʱ) ";
//		}
//		if (t)
//			tv9.setText(str);
//		if (!T2_ddxx_netItems.getAdd_price().equals("0"))
//		tv10.setText(T2_ddxx_netItems.getAdd_price()+"Ԫ");
//		tv11.setText(T2_ddxx_netItems.getHalf_price()+"Ԫ/ʱ");
//		tv12.setText(T2_ddxx_netItems.getPay_status());
		

	}
	
}
