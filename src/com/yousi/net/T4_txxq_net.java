package com.yousi.net;

public class T4_txxq_net {
private String id;
private String amount;
private String name;
private String account;
private String bankname;
private String info;
private String status;
private String create_time;
private String audit_time;
private String success_time;
public T4_txxq_net() {
	super();
}
public T4_txxq_net(String id, String amount, String name, String account,
		String bankname, String info, String status, String create_time,
		String audit_time, String success_time) {
	super();
	this.id = id;
	this.amount = amount;
	this.name = name;
	this.account = account;
	this.bankname = bankname;
	this.info = info;
	this.status = status;
	this.create_time = create_time;
	this.audit_time = audit_time;
	this.success_time = success_time;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCreate_time() {
	return create_time;
}
public void setCreate_time(String create_time) {
	this.create_time = create_time;
}
public String getAudit_time() {
	return audit_time;
}
public void setAudit_time(String audit_time) {
	this.audit_time = audit_time;
}
public String getSuccess_time() {
	return success_time;
}
public void setSuccess_time(String success_time) {
	this.success_time = success_time;
}
}
