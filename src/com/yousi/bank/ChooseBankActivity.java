package  com.yousi.bank;

import java.util.ArrayList;
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
import android.widget.ListView;
import android.widget.TextView;

public class ChooseBankActivity extends Activity {
	private ListView ll_choose_bank;
	private ArrayList<String> bankNames;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choosebank);
		ll_choose_bank = (ListView) findViewById(R.id.ll_choose_bank);
		bankNames = BankName.getAllBankName();
		ll_choose_bank.setAdapter(new MyAdapter3(this,bankNames));
		
		ll_choose_bank.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Intent intent  = new Intent(ChooseBankActivity.this,AddAccountActivity.class);
				intent.putExtra("type", bankNames.get(position));
				setResult(0, intent);
				finish();
			}
		});
	}
}

class MyAdapter3 extends BaseAdapter {
	private Context context;
	private List<String> bankTypes;
	public MyAdapter3(Context context,List<String> bankTypes) {
		this.context = context;
		this.bankTypes = bankTypes;
	}

	@Override
	public int getCount() {
		return bankTypes.size();
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
	public View getView(int position, View arg1, ViewGroup arg2) {
		String type = bankTypes.get(position);
		View view = LayoutInflater.from(context).inflate(
				R.layout.lv_choose_bank, arg2, false);
		TextView tv_banktype_name = (TextView) view.findViewById(R.id.tv_banktype_name);
		ImageView iv_banktype_icon = (ImageView) view.findViewById(R.id.iv_banktype_icon);
		tv_banktype_name.setText(BankName.getBankName(type));
		iv_banktype_icon.setImageResource(BankName.getBankImageId(type));
		return view;
	}
}