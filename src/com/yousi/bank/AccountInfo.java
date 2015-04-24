package com.yousi.bank;

import java.io.Serializable;


public class AccountInfo implements Serializable{
	private String bid;
	private String account;
	private String account_name;
	private String banktype;
	private String status;
	public AccountInfo() {
		super();
	}
	public AccountInfo(String bid, String account, String account_name,
			String banktype, String status) {
		super();
		this.bid = bid;
		this.account = account;
		this.account_name = account_name;
		this.banktype = banktype;
		this.status = status;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getBanktype() {
		return banktype;
	}
	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
