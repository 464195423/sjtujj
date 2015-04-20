package com.yousi.sjtujj;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.yousi.net.Nddxx2_net;
import com.yousi.net.Special;
import com.yousi.net.T2_ddxx_net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;
import com.yousi.util.String_unite;

/* 订单详情 */
public class Nddxx2Fragment extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "rid";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters

	private String rid;
	private Nddxx2_net Nddxx2_netItems;
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
	public static Nddxx2Fragment newInstance(String param1) {
		Nddxx2Fragment fragment = new Nddxx2Fragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		fragment.setArguments(args);
		return fragment;
	}

	public Nddxx2Fragment() {
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
		return inflater.inflate(R.layout.fragment_nddxx2, container, false);
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
		MyHttpClient.doGet2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					Nddxx2_netItems = JSONObject.parseObject(data1.toString(), Nddxx2_net.class);	
					setData();
				}
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.showOrder_path, map, DB.getSessionid(getActivity()));
	}	
	
	private void setData(){
		TextView l0_tv1 = (TextView)getView().findViewById(R.id.ddxx2_l0_tv1);
		TextView l0_tv2 = (TextView)getView().findViewById(R.id.ddxx2_l0_tv2);
		TextView l0_tv3 = (TextView)getView().findViewById(R.id.ddxx2_l0_tv3);
		TextView l0_tv4 = (TextView)getView().findViewById(R.id.ddxx2_l0_tv4);
		
		TextView l1_tv1 = (TextView)getView().findViewById(R.id.ddxx2_l1_tv1);
		TextView l1_tv2 = (TextView)getView().findViewById(R.id.ddxx2_l1_tv2);
		TextView l1_tv3 = (TextView)getView().findViewById(R.id.ddxx2_l1_tv3);
		TextView l1_tv4 = (TextView)getView().findViewById(R.id.ddxx2_l1_tv4);
		TextView l1_tv5 = (TextView)getView().findViewById(R.id.ddxx2_l1_tv5);
		TextView l1_tv6 = (TextView)getView().findViewById(R.id.ddxx2_l1_tv6);
		
		TextView l2_tv1 = (TextView)getView().findViewById(R.id.ddxx2_l2_tv1);
		TextView l2_tv2 = (TextView)getView().findViewById(R.id.ddxx2_l2_tv2);
		TextView l2_tv3 = (TextView)getView().findViewById(R.id.ddxx2_l2_tv3);
		TextView l2_tv4 = (TextView)getView().findViewById(R.id.ddxx2_l2_tv4);
		TextView l2_tv5 = (TextView)getView().findViewById(R.id.ddxx2_l2_tv5);
		
		TextView l3_tv1 = (TextView)getView().findViewById(R.id.ddxx2_l3_tv1);
		TextView l3_tv2 = (TextView)getView().findViewById(R.id.ddxx2_l3_tv2);
		
		l0_tv1.setText("D" + Nddxx2_netItems.getR_id());
		l0_tv2.setText(Nddxx2_netItems.getOrder_status_info());
		l0_tv3.setText(Nddxx2_netItems.getOrder_status_point());	
		l0_tv4.setText(Nddxx2_netItems.getTime());
		
		l1_tv1.setText(Nddxx2_netItems.getS_name());
		l1_tv2.setText(Nddxx2_netItems.getS_gradename());
		l1_tv3.setText(Nddxx2_netItems.getS_sexname());	
		l1_tv4.setText(Nddxx2_netItems.getS_parentname());
		l1_tv5.setText(Nddxx2_netItems.getPhone());	
		l1_tv6.setText(Html.fromHtml("<font color=#738ffe>"
				+Nddxx2_netItems.getAddress()
				+"</font>"
				+"<font color=#AAAAAA>(点击可查看地图)</font>"));	
		l1_tv6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), MapActivity.class);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("place", Nddxx2_netItems.getAddress());
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});		
		
		l2_tv1.setText(Nddxx2_netItems.getT_sexname());
		l2_tv2.setText(String_unite.unite(Nddxx2_netItems.getWeaksubject(), ", "));
		String str = "";
		Special tmp1[] = Nddxx2_netItems.getSpecial();
		for (int i = 0; i < tmp1.length; i++)
			str += tmp1[i].getName() + " ";
		l2_tv3.setText(str.equals("") ? "无" : str);
		l2_tv4.setText(Nddxx2_netItems.getPeople_count());
		l2_tv5.setText(Nddxx2_netItems.getQualification());
		
		l3_tv1.setText(Nddxx2_netItems.getAdd_price()+"元/时");
		str = "";
		for (int i = 0; i < tmp1.length; i++)
		{
			str += "  ";
			str += tmp1[i].getName();
			str += tmp1[i].getPrice();
			str += "元/时";
		}
	
		l3_tv2.setText(Nddxx2_netItems.getOne_price()+"元/时"+"\n"
				+"("+Nddxx2_netItems.getS_gradename()+":"+Nddxx2_netItems.getGrade_price()+"元/时"
				+(Nddxx2_netItems.getAdd_price().equals("0") ? "" : ("  加价:"+Nddxx2_netItems.getAdd_price()+"元/时"))
				+ str + ")");

	}
	
}
