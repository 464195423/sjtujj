package com.yousi.bank;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.yousi.sjtujj.R;
import com.yousi.sjtujj.T2_nksstActivity;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.MyPath;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AccountManagerActivity extends Activity {
	private AccountInfo info;
	private TextView tv_banktype_name;
	private TextView tv_account_info;
	private ImageView iv_banktype_icon;
	private TextView tv_cancle;
	private TextView tv_del;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_info);
		info = (AccountInfo) getIntent().getSerializableExtra("data");
		initView();
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.account_info_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	private void initView() {
		tv_banktype_name = (TextView) findViewById(R.id.tv_banktype_name);
		tv_account_info = (TextView) findViewById(R.id.tv_account_info);
		iv_banktype_icon = (ImageView) findViewById(R.id.iv_banktype_icon);
		tv_cancle = (TextView) findViewById(R.id.tv_cancle);
		tv_del = (TextView) findViewById(R.id.tv_del);

		tv_banktype_name.setText(BankName.getBankName(info.getBanktype()));
		tv_account_info.setText(info.getAccount() + "  "
				+ info.getAccount_name());
		iv_banktype_icon.setImageResource(BankName.getBankImageId(info
				.getBanktype()));
		
//		取消删除按钮
		tv_cancle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
//		删除按钮
		tv_del.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				PostData();
			}
		});
	}
	
	private void PostData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("bank", info.getBid());
		MyHttpClient.doPost2(AccountManagerActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					Toast.makeText(AccountManagerActivity.this, "删除成功！", Toast.LENGTH_SHORT).show();
					finish();
				}
				else
					Toast.makeText(AccountManagerActivity.this, jsonObject.getString("desc"), Toast.LENGTH_SHORT).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.deleteBankAccount_path, map, DB.getSessionid(AccountManagerActivity.this));
	}
}
