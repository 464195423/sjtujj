package com.yousi.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.yousi.sjtujj.R;
import com.yousi.sjtujj.T2_xgsksjActivity;
import com.yousi.util.DB;
import com.yousi.util.MyHttpClient;
import com.yousi.util.NetRespondPost;
import com.yousi.util.NewMyPath;

import android.app.Activity;
import android.content.Intent;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ApplyToCashActivity extends Activity {
	private RelativeLayout rl_account_type;
	private TextView tv_account_gold;
	private TextView tv_account_name;
	private ImageView iv_account_bank_icon;

	private ApplyBeginInfo applyBeginInfo;
	private AccountInfo accountInfo;
	
	private TextView tv_account_no;
	private EditText et_txje;
	private EditText et_yzm;
	private TextView tv_click_get;
	private TextView tv_tijiao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shenqingtixian);
		applyBeginInfo = new ApplyBeginInfo();
		applyBeginInfo.setGold("2895");
		List<AccountInfo> temp  = new ArrayList<AccountInfo>();
		AccountInfo t1AccountInfo = new AccountInfo("43","423423","34234","alipay","0");
		AccountInfo t2AccountInfo = new AccountInfo("48","hah","sdfsd","alipay","1");
		temp.add(t1AccountInfo);
		temp.add(t2AccountInfo);
		applyBeginInfo.setAccount(temp);
		
		tv_account_gold = (TextView) findViewById(R.id.tv_account_gold);
		tv_account_name = (TextView) findViewById(R.id.tv_account_name);
		tv_account_no = (TextView) findViewById(R.id.tv_account_no);
		iv_account_bank_icon = (ImageView) findViewById(R.id.iv_account_bank_icon);
		et_txje = (EditText)findViewById(R.id.et_txje);
		et_yzm = (EditText)findViewById(R.id.et_yzm);
		tv_click_get = (TextView) findViewById(R.id.tv_click_get);
		tv_tijiao = (TextView) findViewById(R.id.tv_tijiao);
		
		rl_account_type = (RelativeLayout) findViewById(R.id.rl_account_type);
		rl_account_type.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ApplyToCashActivity.this,
						ChooseAccountActivity.class);
				intent.putExtra("applyBeginInfo", applyBeginInfo);
				startActivityForResult(intent, 0);
			}
		});
		
		//点击获取短信验证码
		tv_click_get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				PostData1();
			}
		});
		//点击提交，进入下一步		
		tv_tijiao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String gold = et_txje.getText().toString().trim();
				String yzm = et_yzm.getText().toString().trim();
				PostData2(gold, yzm);
			}
		});
		
		accountInfo = filterAccount(applyBeginInfo.getAccount());
		setViewContent();
		
		//左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.shengqingtixian_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null) {
			accountInfo.setStatus("0");
			AccountInfo temp = (AccountInfo) data.getSerializableExtra("selectedAccount");
			if (temp != null) {
				accountInfo = findAccountById(applyBeginInfo.getAccount(), temp.getBid());
				accountInfo.setStatus("1");
				setViewContent();
			}
		}
	}
	
	private void setViewContent() {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");   
		double d = Double.parseDouble(applyBeginInfo.getGold());
		
		tv_account_gold.setText("账户余额：" + df.format(d) + "元");
		tv_account_name.setText(accountInfo.getAccount_name());
		tv_account_no.setText(accountInfo.getAccount());
		iv_account_bank_icon.setImageResource(BankName
				.getBankImageId(accountInfo.getBanktype()));
	}

	private AccountInfo filterAccount(List<AccountInfo> accountInfos) {
		for (int i = 0; i < accountInfos.size(); i++) {
			if (accountInfos.get(i).getStatus().equals("1")) {
				return accountInfos.get(i);
			}
		}
		return null;
	}
	
	private AccountInfo findAccountById(List<AccountInfo> accountInfos,String id){
		for (int i = 0; i < accountInfos.size(); i++) {
			if (accountInfos.get(i).getBid().equals(id)) {
				return accountInfos.get(i);
			}
		}
		return null;
	}

	private void PostData1(){
		HashMap<String, String> map = new HashMap<String, String>();
		MyHttpClient.doPost2(ApplyToCashActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					Toast.makeText(ApplyToCashActivity.this, "验证码已发送！", Toast.LENGTH_LONG).show();
				}
				else
					Toast.makeText(ApplyToCashActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.getCashVerify_path, map, DB.getSessionid(ApplyToCashActivity.this));	
	}
	
	private void PostData2(String gold, String yzm){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("account", accountInfo.getBid());
		map.put("amount", gold);
		map.put("verify", yzm);
		MyHttpClient.doPost2(ApplyToCashActivity.this, new NetRespondPost() {
			@Override
			public void netWorkOk(String json) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				String code = jsonObject.getString("code");
				if (code.equals("200")) {
					Toast.makeText(ApplyToCashActivity.this, "提现成功!", Toast.LENGTH_LONG).show();
					finish();
				}
				else
					Toast.makeText(ApplyToCashActivity.this, jsonObject.getString("desc"), Toast.LENGTH_LONG).show();
			}
			@Override
			public void netWorkError() {
			}
		}, NewMyPath.getMoney_path, map, DB.getSessionid(ApplyToCashActivity.this));	
	}
}
