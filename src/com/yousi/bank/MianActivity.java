package com.yousi.bank;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.yousi.sjtujj.R;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MianActivity extends Activity {
	private ListView ll_zhgl;
	private ApplyBeginInfo applyBeginInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		ll_zhgl = (ListView) findViewById(R.id.ll_zhgl);

		//获取数据
		GetData();

		//添加银行
		TextView tv = (TextView)findViewById(R.id.main2_add);
		tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MianActivity.this,
						AddAccountActivity.class);
				startActivity(intent);
			}
		});

		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.main2_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	private void GetData(){
		HashMap<String, String> map = new HashMap<String, String>();
		MyHttpClient.doGet2(MianActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				JSONObject data = jsonObject.getJSONObject("data");
				if (code.equals("200")) {
					applyBeginInfo = JSONObject.parseObject(data.toString(), ApplyBeginInfo.class);
					ll_zhgl.setAdapter(new MyAdapter2(MianActivity.this, applyBeginInfo.getAccount()));
					ll_zhgl.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
								long arg3) {
							Intent intent = new Intent(MianActivity.this,
									AccountManagerActivity.class);
							intent.putExtra("data", applyBeginInfo.getAccount().get(arg2));
							startActivity(intent);
						}
					});
				}
				else
					Toast.makeText(MianActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.applyBegin_path, map, DB.getSessionid(this));		
	}
	
}

class MyAdapter2 extends BaseAdapter {
	private Context context;
	private List<AccountInfo> datas;

	public MyAdapter2(Context context, List<AccountInfo> datas) {
		this.context = context;
		this.datas = datas;
	}

	@Override
	public int getCount() {
		return datas == null ? 0 : datas.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		AccountInfo info = datas.get(position);
		MyHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.ll_item_zhgl, arg2, false);
			holder = new MyHolder();
			holder.tv_banktype_name = (TextView) convertView
					.findViewById(R.id.tv_banktype_name);
			holder.tv_account_info = (TextView) convertView
					.findViewById(R.id.tv_account_info);
			holder.iv_banktype_icon = (ImageView) convertView
					.findViewById(R.id.iv_banktype_icon);
			convertView.setTag(holder);
		} else {
			holder = (MyHolder) convertView.getTag();
		}
		String type = info.getBanktype();
//		设置银行名字
		holder.tv_banktype_name.setText(BankName.getBankName(type));
		holder.tv_account_info.setText(info.getAccount() + "  "
				+ info.getAccount_name());
//		设置银行图标
		holder.iv_banktype_icon.setImageResource(BankName.getBankImageId(type));
		return convertView;
	}

	class MyHolder {
		private TextView tv_banktype_name;
		private TextView tv_account_info;
		private ImageView iv_banktype_icon;
	}

}