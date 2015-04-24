package com.yousi.bank;

import java.util.HashMap;
import java.util.Map;

import com.yousi.sjtujj.R;
import com.yousi.util.MyHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddAccountActivity extends Activity {
	private EditText et_account_no;
	private EditText et_account_name;
	private EditText et_account_city;
	private EditText et_account_bank;
	private TextView tv_account_add;

	private String banktype = "alipay";// 银行代码
	private String account_no;// 银行账号
	private String account_name;// 开户人
	private String account_city;// 开户城市
	private String account_brance;// 开户支行
	private RelativeLayout relativeLayout1;
	private ImageView iv_khh_icon;
	private RelativeLayout relativeLayout4;
	private RelativeLayout relativeLayout5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_account);
		init();
	}
	
	private void init(){
		relativeLayout1 = (RelativeLayout) findViewById(R.id.relativeLayout1);
		relativeLayout4 = (RelativeLayout) findViewById(R.id.relativeLayout4);
		relativeLayout5 = (RelativeLayout) findViewById(R.id.relativeLayout5);
		et_account_no = (EditText) findViewById(R.id.et_account_no);
		et_account_name = (EditText) findViewById(R.id.et_account_name);
		et_account_city = (EditText) findViewById(R.id.et_account_city);
		et_account_bank = (EditText) findViewById(R.id.et_account_bank);
		tv_account_add = (TextView) findViewById(R.id.tv_account_add);
		iv_khh_icon = (ImageView) findViewById(R.id.iv_khh_icon);
		
		
		relativeLayout1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AddAccountActivity.this,
						ChooseBankActivity.class);
				startActivityForResult(intent, 0);
			}
		});

		// 添加账户的按钮点击事件
		tv_account_add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				setAccountInfo();
				// 如果数据输入完整，则将信息上传到服务器，否者提示用户补全数据
				if (!account_no.equals("") && !account_name.equals("")) {
					
					if (!banktype.equals("alipay")) {
						if (account_city.equals("") || account_brance.equals("")) {
							Toast.makeText(AddAccountActivity.this,
									"你输入的信息不全，请补全后再添加！", Toast.LENGTH_LONG).show();
							return;
						}
					}
					// 将需要上传的数据装入map中
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("banktype", banktype);
					map.put("account_no", account_no);
					map.put("account_name", account_name);
					if (!banktype.equals("alipay")) {
						map.put("account_city", account_city);
						map.put("account_brance", account_brance);
					}
//					MyHttpClient.doPost2(AddAccountActivity.this,
//							new NetRespondPost() {
//								@Override
//								public void netWorkOk(String json) {
//
//								}
//
//								@Override
//								public void netWorkError() {
//
//								}
//							}, " path   addBankAccount", map, "SessionID");
				} else {
					Toast.makeText(AddAccountActivity.this,
							"你输入的信息不全，请补全后再添加！", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	
	// 将输入框中的数据设置到参数中
	private void setAccountInfo() {
		account_no = et_account_no.getText().toString();
		account_name = et_account_name.getText().toString();
		account_city = et_account_city.getText().toString();
		account_brance = et_account_bank.getText().toString();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 0 && resultCode == 0) {
			String type = data.getStringExtra("type");
			banktype = type;
			iv_khh_icon.setImageResource(BankName.getBankImageId(type));
			if (!type.equals("alipay")) {
				relativeLayout4.setVisibility(View.VISIBLE);
				relativeLayout5.setVisibility(View.VISIBLE);
			} else {
				relativeLayout4.setVisibility(View.GONE);
				relativeLayout5.setVisibility(View.GONE);
			}
		}
	}
}
