package com.yousi.net;

public class T3_1net {
private String class_type;
private String class_id;
private String r_id;
private String picture;
private String parentname;
private String discount;
public String getClass_type() {
	return class_type;
}
public void setClass_type(String class_type) {
	this.class_type = class_type;
}
public String getClass_id() {
	return class_id;
}
public void setClass_id(String class_id) {
	this.class_id = class_id;
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
public String getDiscount() {
	return discount;
}
public void setDiscount(String discount) {
	this.discount = discount;
}
public T3_1net(String class_type, String class_id, String r_id, String picture,
		String parentname, String discount) {
	super();
	this.class_type = class_type;
	this.class_id = class_id;
	this.r_id = r_id;
	this.picture = picture;
	this.parentname = parentname;
	this.discount = discount;
}
public T3_1net() {
	super();
}
}
