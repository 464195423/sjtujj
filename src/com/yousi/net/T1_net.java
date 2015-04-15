package com.yousi.net;

public class T1_net {
private String r_id;
private String gradename;
private String sexname;
private String qualification;
private String[] weaksubject;
private String address;
private Special[] special;
private String oneprice;
private String addStatus;
public String getR_id() {
	return r_id;
}
public void setR_id(String r_id) {
	this.r_id = r_id;
}
public String getGradename() {
	return gradename;
}
public void setGradename(String gradename) {
	this.gradename = gradename;
}
public String getSexname() {
	return sexname;
}
public void setSexname(String sexname) {
	this.sexname = sexname;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String[] getWeaksubject() {
	return weaksubject;
}
public void setWeaksubject(String[] weaksubject) {
	this.weaksubject = weaksubject;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Special[] getSpecial() {
	return special;
}
public void setSpecial(Special[] special) {
	this.special = special;
}
public String getOneprice() {
	return oneprice;
}
public void setOneprice(String oneprice) {
	this.oneprice = oneprice;
}
public String getAddStatus() {
	return addStatus;
}
public void setAddStatus(String addStatus) {
	this.addStatus = addStatus;
}
public T1_net(String r_id, String gradename, String sexname,
		String qualification, String[] weaksubject, String address,
		Special[] special, String oneprice, String addStatus) {
	super();
	this.r_id = r_id;
	this.gradename = gradename;
	this.sexname = sexname;
	this.qualification = qualification;
	this.weaksubject = weaksubject;
	this.address = address;
	this.special = special;
	this.oneprice = oneprice;
	this.addStatus = addStatus;
}
public T1_net() {
	super();
}
}
