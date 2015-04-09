package com.yousi.net;

public class Login_net {
private String demandId;
private String group;
private String school;
private String tid;
private String tname;
private String tpicture;
public Login_net(String demandId, String group, String school,
		String tid, String tname, String tpicture) {
	super();
	this.demandId = demandId;
	this.group = group;
	this.school = school;
	this.tid = tid;
	this.tname = tname;
	this.tpicture = tpicture;
}
public Login_net() {
	super();
}
public String getDemandId() {
	return demandId;
}
public void setDemandId(String demandId) {
	this.demandId = demandId;
}
public String getGroup() {
	return group;
}
public void setGroup(String group) {
	this.group = group;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}

public String getTid() {
	return tid;
}
public void setTid(String tid) {
	this.tid = tid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getTpicture() {
	return tpicture;
}
public void setTpicture(String tpicture) {
	this.tpicture = tpicture;
}
}
