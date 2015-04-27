package com.yousi.bank;

import java.util.List;

import com.yousi.sjtujj.R;

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
import android.widget.RadioButton;
import android.widget.TextView;

public class ChooseAccountActivity extends Activity {
	private ListView ll_choose_account;
	private ApplyBeginInfo applyBeginInfo;
	private List<AccountInfo> accountInfos;
	private AccountInfo selectedAccount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_account);
		ll_choose_account = (ListView) findViewById(R.id.ll_choose_account);
		

		applyBeginInfo = (ApplyBeginInfo) getIntent().getSerializableExtra(
				"applyBeginInfo");
		accountInfos = applyBeginInfo.getAccount();
		ll_choose_account.setAdapter(new MyAdapter(this));
		ll_choose_account.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				selectedAccount = accountInfos.get(arg2);
				Intent intent = new Intent(ChooseAccountActivity.this,
						ApplyToCashActivity.class);
				intent.putExtra("selectedAccount", selectedAccount);
				setResult(0, intent);
				finish();
			}
		});
		
		//×óÉÏ·µ»Ø¼ü
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.choose_account_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	class MyAdapter extends BaseAdapter {
		private Context context;

		public MyAdapter(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			return accountInfos.size();
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
			View view = LayoutInflater.from(context).inflate(
					R.layout.choose_account_item, arg2, false);

			AccountInfo accountInfo = accountInfos.get(position);

			ImageView iv_account_bank_icon = (ImageView) view
					.findViewById(R.id.iv_account_bank_icon);
			ImageView iv_account_nick = (ImageView) view
					.findViewById(R.id.iv_account_nick);
			TextView tv_account_no = (TextView) view
					.findViewById(R.id.tv_account_no);
			TextView tv_account_name = (TextView) view
					.findViewById(R.id.tv_account_name);
			
			String type = accountInfo.getBanktype();
			tv_account_no.setText(accountInfo.getAccount());
			tv_account_name.setText(accountInfo.getAccount_name());
			iv_account_bank_icon
					.setImageResource(BankName.getBankImageId(type));
			if (accountInfo.getStatus().equals("0")) {
				iv_account_nick.setVisibility(View.GONE);
			}
			return view;
		}
	}
}
