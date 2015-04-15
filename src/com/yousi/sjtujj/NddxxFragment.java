package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.net.Nddxx_net;
import com.yousi.net.Special;
import com.yousi.net.T2_ddxx_net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

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

/* 家教需求详情*/
public class NddxxFragment extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "rid";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters

	private String rid;
	private Nddxx_net Nddxx_netItems;

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
					Nddxx_netItems = JSONObject.parseObject(data1.toString(), Nddxx_net.class);	
					setData();
				}
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.orderShow_path, map, DB.getSessionid(getActivity()));
	}	
	
	private void setData(){		
		TextView l0_tv1 = (TextView)getView().findViewById(R.id.ddxx_l0_tv1);
		TextView l0_tv2 = (TextView)getView().findViewById(R.id.ddxx_l0_tv2);
	
		TextView l1_tv1 = (TextView)getView().findViewById(R.id.ddxx_l1_tv1);
		TextView l1_tv2 = (TextView)getView().findViewById(R.id.ddxx_l1_tv2);
		TextView l1_tv3 = (TextView)getView().findViewById(R.id.ddxx_l1_tv3);

		TextView l2_tv1 = (TextView)getView().findViewById(R.id.ddxx_l2_tv1);
		TextView l2_tv2 = (TextView)getView().findViewById(R.id.ddxx_l2_tv2);
		TextView l2_tv3 = (TextView)getView().findViewById(R.id.ddxx_l2_tv3);
		TextView l2_tv4 = (TextView)getView().findViewById(R.id.ddxx_l2_tv4);
		TextView l2_tv5 = (TextView)getView().findViewById(R.id.ddxx_l2_tv5);
		
		TextView l3_tv1 = (TextView)getView().findViewById(R.id.ddxx_l3_tv1);
		TextView l3_tv2 = (TextView)getView().findViewById(R.id.ddxx_l3_tv2);
		
		String str = "";
		l0_tv1.setText(Nddxx_netItems.getR_id());
		l0_tv2.setText(Nddxx_netItems.getCreatetime());
		l1_tv1.setText(Nddxx_netItems.getS_gradename());
		l1_tv2.setText(Nddxx_netItems.getS_sexname());
		l1_tv3.setText(Html.fromHtml("<font color=#738ffe>"
				+Nddxx_netItems.getAddress()
				+"</font>"
				+"<font color=#AAAAAA>(点击可查看地图)</font>"));

		l1_tv3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), MapActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("place", Nddxx_netItems.getAddress());
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		l2_tv1.setText(Nddxx_netItems.getT_sexname());
		str = "";
		String tmp[] = Nddxx_netItems.getWeaksubject();
		for (int i = 0; i < tmp.length; i++)
			str += tmp[i] + " ";
		l2_tv2.setText(str);
		
		str = "";
		Special tmp1[] = Nddxx_netItems.getSpecial();
		for (int i = 0; i < tmp1.length; i++)
			str += tmp1[i].getName() + " ";
		l2_tv3.setText(str.equals("") ? "无" : str);
		
		l2_tv4.setText(Nddxx_netItems.getPeople_count());
		l2_tv5.setText(Nddxx_netItems.getQualification());
		
		l3_tv1.setText(Nddxx_netItems.getAdd_price()+"元/时");
		str = "";
		for (int i = 0; i < tmp1.length; i++)
		{
			str += "  ";
			str += tmp1[i].getName();
			str += tmp1[i].getPrice();
			str += "元/时";
		}
	
		l3_tv2.setText(Nddxx_netItems.getOne_price()+"元/时"+"\n"
				+"("+Nddxx_netItems.getS_gradename()+":"+Nddxx_netItems.getGrade_price()+"元/时"
				+(Nddxx_netItems.getAdd_price().equals("0") ? "" : ("  加价:"+Nddxx_netItems.getAdd_price()+"元/时"))
				+ str + ")");
		
	}
	
}
