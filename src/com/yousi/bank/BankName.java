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
			name = "֧����";
			break;
		case "BOCB2C":
			name = "�й�����";
			break;
		case "ICBCB2C":
			name = "�й���������";
			break;
		case "CMB":
			name = "��������";
			break;
		case "CCB":
			name = "�й���������";
			break;
		case "ABC":
			name = "�й�ũҵ����";
			break;
		case "SPDB":
			name = "�Ϻ��ֶ���չ��";
			break;
		case "CIB":
			name = "��ҵ����";
			break;
		case "GDB":
			name = "�㷢����";
			break;
		case "FDB":
			name = "��������";
			break;
		case "CITIC":
			name = "��������";
			break;
		case "HZCBB2C":
			name = "��������";
			break;
		case "SHBANK":
			name = "�Ϻ�����";
			break;
		case "NBBANK":
			name = "��������";
			break;
		case "SPABANK":
			name = "ƽ������";
			break;
		case "POSTGC":
			name = "�й�����������";
			break;
		case "CMB-DEB":
			name = "��������-���ÿ�";
			break;
		case "CCB-DEB":
			name = "�й���������-���ÿ�";
			break;
		case "ICBC-DE":
			name = "�й���������-���ÿ�";
			break;
		case "COMM-DE":
			name = "��ͨ����-���ÿ�";
			break;
		case "GDB-DEB":
			name = "�㷢����-���ÿ�";
			break;
		case "BOC-DEB":
			name = "�й�����-���ÿ�";
			break;
		case "CEB-DEB":
			name = "�й��������-���ÿ�";
			break;
		case "SPDB-DE":
			name = "�Ϻ��ֶ���չ����-���ÿ�";
			break;
		case "PSBC-DE":
			name = "�й���������-���ÿ�";
			break;
		case "BJBANK":
			name = "��������";
			break;
		case "SHRCB":
			name = "�Ϻ�ũ������";
			break;
		case "WZCBB2C":
			name = "��������";
			break;
		case "COMM":
			name = "��ͨ����";
			break;
		case "CMBC":
			name = "�й���������";
			break;
		case "BJRCB":
			name = "����ũ����ҵ��";
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
