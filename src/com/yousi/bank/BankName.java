package  com.yousi.bank;

import java.util.ArrayList;

import com.yousi.sjtujj.R;

public class BankName {
	public static ArrayList<String> getAllBankName(){
		ArrayList<String> bankNames = new ArrayList<String>();
		bankNames.add("alipay");
		bankNames.add("BOCB2C");
		bankNames.add("ICBCB2C");
		bankNames.add("CMB");
		bankNames.add("CCB");
		bankNames.add("ABC");
		bankNames.add("SPDB");
		bankNames.add("CIB");
		bankNames.add("GDB");
		bankNames.add("FDB");
		bankNames.add("CITIC");
		bankNames.add("HZCBB2C");
		bankNames.add("SHBANK");
		bankNames.add("NBBANK");
		bankNames.add("SPABANK");
		bankNames.add("POSTGC");
		bankNames.add("CMB-DEB");
		bankNames.add("CCB-DEB");
		bankNames.add("ICBC-DE");
		bankNames.add("COMM-DE");
		bankNames.add("GDB-DEB");
		bankNames.add("BOC-DEB");
		bankNames.add("CEB-DEB");
		bankNames.add("SPDB-DE");
		bankNames.add("PSBC-DE");
		bankNames.add("BJBANK");
		bankNames.add("SHRCB");
		bankNames.add("WZCBB2C");
		bankNames.add("COMM");
		bankNames.add("CMBC");
		bankNames.add("BJRCB");
		return bankNames;
	}
	
	public static String getBankName(String key) {
		String name = null;
		switch (key) {
		case "alipay":
			name = "支付宝";
			break;
		case "BOCB2C":
			name = "中国银行";
			break;
		case "ICBCB2C":
			name = "中国工商银行";
			break;
		case "CMB":
			name = "招商银行";
			break;
		case "CCB":
			name = "中国建设银行";
			break;
		case "ABC":
			name = "中国农业银行";
			break;
		case "SPDB":
			name = "上海浦东发展银";
			break;
		case "CIB":
			name = "兴业银行";
			break;
		case "GDB":
			name = "广发银行";
			break;
		case "FDB":
			name = "富滇银行";
			break;
		case "CITIC":
			name = "中信银行";
			break;
		case "HZCBB2C":
			name = "杭州银行";
			break;
		case "SHBANK":
			name = "上海银行";
			break;
		case "NBBANK":
			name = "宁波银行";
			break;
		case "SPABANK":
			name = "平安银行";
			break;
		case "POSTGC":
			name = "中国邮政储蓄银";
			break;
		case "CMB-DEB":
			name = "招商银行-信用卡";
			break;
		case "CCB-DEB":
			name = "中国建设银行-信用卡";
			break;
		case "ICBC-DE":
			name = "中国工商银行-信用卡";
			break;
		case "COMM-DE":
			name = "交通银行-信用卡";
			break;
		case "GDB-DEB":
			name = "广发银行-信用卡";
			break;
		case "BOC-DEB":
			name = "中国银行-信用卡";
			break;
		case "CEB-DEB":
			name = "中国光大银行-信用卡";
			break;
		case "SPDB-DE":
			name = "上海浦东发展银行-信用卡";
			break;
		case "PSBC-DE":
			name = "中国邮政储蓄-信用卡";
			break;
		case "BJBANK":
			name = "北京银行";
			break;
		case "SHRCB":
			name = "上海农商银行";
			break;
		case "WZCBB2C":
			name = "温州银行";
			break;
		case "COMM":
			name = "交通银行";
			break;
		case "CMBC":
			name = "中国民生银行";
			break;
		case "BJRCB":
			name = "北京农村商业银";
			break;

		default:
			break;
		}
		return name;
	}

	public static int getBankImageId(String key) {
		int id = 0;
		switch (key) {
		case "alipay":
			id = R.drawable.alipay;
			break;
		case "BOCB2C":
			id = R.drawable.bocb2c;
			break;
		case "ICBCB2C":
			id = R.drawable.icbcb2c;
			break;
		case "CMB":
			id = R.drawable.cmb;
			break;
		case "CCB":
			id = R.drawable.ccb;
			break;
		case "ABC":
			id = R.drawable.abc;
			break;
		case "SPDB":
			id = R.drawable.spdb;
			break;
		case "CIB":
			id = R.drawable.cib;
			break;
		case "GDB":
			id = R.drawable.gdb;
			break;
		case "FDB":
			id = R.drawable.fdb;
			break;
		case "CITIC":
			id = R.drawable.citic;
			break;
		case "HZCBB2C":
			id = R.drawable.hzcbb2c;
			break;
		case "SHBANK":
			id = R.drawable.shbank;
			break;
		case "NBBANK":
			id = R.drawable.nbbank;
			break;
		case "SPABANK":
			id = R.drawable.spabank;
			break;
		case "POSTGC":
			id = R.drawable.postgc;
			break;
		case "CMB-DEB":
			id = R.drawable.cmb_deb;
			break;
		case "CCB-DEB":
			id = R.drawable.ccb_deb;
			break;
		case "ICBC-DE":
			id = R.drawable.icbc_de;
			break;
		case "COMM-DE":
			id = R.drawable.comm_de;
			break;
		case "GDB-DEB":
			id = R.drawable.gdb_deb;
			break;
		case "BOC-DEB":
			id = R.drawable.boc_deb;
			break;
		case "CEB-DEB":
			id = R.drawable.ceb_deb;
			break;
		case "SPDB-DE":
			id = R.drawable.spdb_de;
			break;
		case "PSBC-DE":
			id = R.drawable.psbc_de;
			break;
		case "BJBANK":
			id = R.drawable.bjbank;
			break;
		case "SHRCB":
			id = R.drawable.shrcb;
			break;
		case "WZCBB2C":
			id = R.drawable.wzcbb2c;
			break;
		case "COMM":
			id = R.drawable.comm;
			break;
		case "CMBC":
			id = R.drawable.cmbc;
			break;
		case "BJRCB":
			id = R.drawable.bjrcb;
			break;
		default:
			break;
		}
		return id;
	}
}
