package com.yousi.net;

public class ApplyRecord {
	private String id;
	private String time;
	private String amount;
	private String name;
	private String account;
	private String banktype;

	public ApplyRecord() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}


	public ApplyRecord(String id, String time, String amount, String name,
			String account, String banktype) {
		super();
		this.id = id;
		this.time = time;
		this.amount = amount;
		this.name = name;
		this.account = account;
		this.banktype = banktype;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String getBanktype() {
		return banktype;
	}


	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}

}
