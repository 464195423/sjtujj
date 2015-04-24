package com.yousi.bank;

public class ApplyRecord {
	private String id;
	private String time;
	private String amount;
	private String name;
	private String account;
	private String bankname;

	public ApplyRecord() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ApplyRecord(String id, String time, String amount, String name,
			String account, String bankname) {
		super();
		this.id = id;
		this.time = time;
		this.amount = amount;
		this.name = name;
		this.account = account;
		this.bankname = bankname;
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

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
}
