package com.yousi.bank;

import java.util.List;

public class ApplyBeginInfo {
	private String gold;
	private List<AccountInfo> account;
	public ApplyBeginInfo() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public ApplyBeginInfo(String gold, List<AccountInfo> account) {
		super();
		this.gold = gold;
		this.account = account;
	}
	public String getGold() {
		return gold;
	}
	public void setGold(String gold) {
		this.gold = gold;
	}
	public List<AccountInfo> getAccount() {
		return account;
	}
	public void setAccount(List<AccountInfo> account) {
		this.account = account;
	}
}
