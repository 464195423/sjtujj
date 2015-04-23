package com.yousi.net;

public class T4_cw_net {
private String id;
private String member;
private String gold;
private String desc;
private String create_time;
private String status;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getMember() {
	return member;
}
public void setMember(String member) {
	this.member = member;
}
public String getGold() {
	return gold;
}
public void setGold(String gold) {
	this.gold = gold;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getCreate_time() {
	return create_time;
}
public void setCreate_time(String create_time) {
	this.create_time = create_time;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public T4_cw_net(String id, String member, String gold, String desc,
		String create_time, String status) {
	super();
	this.id = id;
	this.member = member;
	this.gold = gold;
	this.desc = desc;
	this.create_time = create_time;
	this.status = status;
}
public T4_cw_net() {
	super();
}

}
