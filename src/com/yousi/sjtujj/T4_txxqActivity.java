package com.yousi.sjtujj;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.net.T2_ddxx_net;
import com.yousi.net.T4_txxq_net;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class T4_txxqActivity extends Activity {
private String id;
private T4_txxq_net T4_txxq_netItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_t4_txxq);
		
		id = getIntent().getExtras().getString("id");
		
		//��ȡ����
		getData();
		
		
		//���Ϸ��ؼ�
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.t4_txxq_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	
	
	private void getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		MyHttpClient.doGet2(null, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					JSONObject data1 = jsonObject.getJSONObject("data");
					T4_txxq_netItems = JSONObject.parseObject(data1.toString(), T4_txxq_net.class);	
					setData();
				}
				else
					Toast.makeText(T4_txxqActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.applyinfo_path, map, DB.getSessionid(T4_txxqActivity.this));
	}
	
	private void setData(){
		TextView dh = (TextView)findViewById(R.id.tv_txdh_dh);
		dh.setText(T4_txxq_netItems.getId());
		TextView amount = (TextView)findViewById(R.id.tv_txdh_amount);
		amount.setText("���ֽ���" + T4_txxq_netItems.getAmount());
		TextView hint = (TextView)findViewById(R.id.t4_txxq_hint);
		ImageView iv = (ImageView)findViewById(R.id.t4_txxq_iv);
		//TextView tv1_1 = (TextView)findViewById(R.id.t4_txxq_tv1_1);
		TextView tv1_2 = (TextView)findViewById(R.id.t4_txxq_tv1_2);
		TextView tv2_1 = (TextView)findViewById(R.id.t4_txxq_tv2_1);
		TextView tv2_2 = (TextView)findViewById(R.id.t4_txxq_tv2_2);
		TextView tv3_1 = (TextView)findViewById(R.id.t4_txxq_tv3_1);
		TextView tv3_2 = (TextView)findViewById(R.id.t4_txxq_tv3_2);
		String st = T4_txxq_netItems.getStatus();
		
		tv1_2.setText(T4_txxq_netItems.getCreate_time());
		switch (st){
			case "0":
				hint.setText("�������ڽ��С�");
				iv.setImageResource(R.drawable.step1);
				tv2_1.setText("�ȴ���˼����");
				tv2_1.setTextColor(0xffcccccc);
				tv2_2.setText("Ԥ��"+T4_txxq_netItems.getAudit_time()+"ǰ");
				tv2_2.setTextColor(0xffcccccc);
				tv3_1.setText("�ȴ�֧��ƽ̨����");
				tv3_1.setTextColor(0xffcccccc);
				tv3_2.setText("Ԥ��"+T4_txxq_netItems.getSuccess_time()+"ǰ");
				tv3_2.setTextColor(0xffcccccc);
				break;
			case "1":
				hint.setText("�������ڽ��С�");
				iv.setImageResource(R.drawable.step2);
				tv2_1.setText("��˼�������");
				tv2_1.setTextColor(0xff36a5df);
				tv2_2.setText(T4_txxq_netItems.getAudit_time());
				tv2_2.setTextColor(0xff646464);
				tv3_1.setText("�ȴ�֧��ƽ̨����");
				tv3_1.setTextColor(0xffcccccc);
				tv3_2.setText("Ԥ��"+T4_txxq_netItems.getSuccess_time()+"ǰ");
				tv3_2.setTextColor(0xffcccccc);
				break;
			case "2":
				hint.setText("��������ɣ�");
				iv.setImageResource(R.drawable.step3);
				tv2_1.setText("��˼�������");
				tv2_1.setTextColor(0xff36a5df);
				tv2_2.setText(T4_txxq_netItems.getAudit_time());
				tv2_2.setTextColor(0xff646464);
				tv3_1.setText("֧��ƽ̨�������");
				tv3_1.setTextColor(0xff36a5df);
				tv3_2.setText(T4_txxq_netItems.getSuccess_time());
				tv3_2.setTextColor(0xff646464);
				break;
			case "3":
				hint.setText("���ֱ�����");
				iv.setImageResource(R.drawable.step3);
				tv2_1.setText("��˼�������");
				tv2_1.setTextColor(0xff36a5df);
				tv2_2.setText(T4_txxq_netItems.getAudit_time());
				tv2_2.setTextColor(0xff646464);
				tv3_1.setText("֧��ƽ̨�������");
				tv3_1.setTextColor(0xff36a5df);
				tv3_2.setText(T4_txxq_netItems.getSuccess_time());
				tv3_2.setTextColor(0xff646464);
				break;
			default:
				hint.setText("ϵͳ����δ֪״̬");
		}
		
		
		
		
	}
}
