package com.yousi.net;

public class T3_2net {
private String r_id;
private String picture;
private String parentname;
private Classlist[] classlist;
public T3_2net() {
	super();
}
public T3_2net(String r_id, String picture, String parentname,
		Classlist[] classlist) {
	super();
	this.r_id = r_id;
	this.picture = picture;
	this.parentname = parentname;
	this.classlist = classlist;
}
public String getR_id() {
	return r_id;
}
public void setR_id(String r_id) {
	this.r_id = r_id;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public String getParentname() {
	return parentname;
}
public void setParentname(String parentname) {
	this.parentname = parentname;
}
public Classlist[] getClasslist() {
	return classlist;
}
public void setClasslist(Classlist[] classlist) {
	this.classlist = classlist;
}
}
