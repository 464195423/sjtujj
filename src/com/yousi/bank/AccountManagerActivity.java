package com.yousi.bank;

import com.yousi.sjtujj.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

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
				
			}
		});
	}
}
