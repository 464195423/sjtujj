package com.yousi.net;

public class Order_net {
private String order_status;
private String r_id;
private String name;
private String picture;
private String parentname;
private String phone;
private String grade;
private String[] weaksubject;
private String oneprice;
private String servertime;
private String endtime;
private String listentime;
private String discount;
private String info;
public String getOrder_status() {
	return order_status;
}
public void setOrder_status(String order_status) {
	this.order_status = order_status;
}
public String getR_id() {
	return r_id;
}
public void setR_id(String r_id) {
	this.r_id = r_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String[] getWeaksubject() {
	return weaksubject;
}
public void setWeaksubject(String[] weaksubject) {
	this.weaksubject = weaksubject;
}
public String getOneprice() {
	return oneprice;
}
public void setOneprice(String oneprice) {
	this.oneprice = oneprice;
}
public String getServertime() {
	return servertime;
}
public void setServertime(String servertime) {
	this.servertime = servertime;
}
public String getEndtime() {
	return endtime;
}
public void setEndtime(String endtime) {
	this.endtime = endtime;
}
public String getListentime() {
	return listentime;
}
public void setListentime(String listentime) {
	this.listentime = listentime;
}
public String getDiscount() {
	return discount;
}
public void setDiscount(String discount) {
	this.discount = discount;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public Order_net() {
	super();
}
public Order_net(String order_status, String r_id, String name, String picture,
		String parentname, String phone, String grade, String[] weaksubject,
		String oneprice, String servertime, String endtime, String listentime,
		String discount, String info) {
	super();
	this.order_status = order_status;
	this.r_id = r_id;
	this.name = name;
	this.picture = picture;
	this.parentname = parentname;
	this.phone = phone;
	this.grade = grade;
	this.weaksubject = weaksubject;
	this.oneprice = oneprice;
	this.servertime = servertime;
	this.endtime = endtime;
	this.listentime = listentime;
	this.discount = discount;
	this.info = info;
}
}
