package com.yousi.net;

public class T4_net {
private String picture;
private String hours;
private String gold;
private String totalgold;
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public String getHours() {
	return hours;
}
public void setHours(String hours) {
	this.hours = hours;
}
public String getGold() {
	return gold;
}
public void setGold(String gold) {
	this.gold = gold;
}
public String getTotalgold() {
	return totalgold;
}
public void setTotalgold(String totalgold) {
	this.totalgold = totalgold;
}
public T4_net(String picture, String hours, String gold, String totalgold) {
	super();
	this.picture = picture;
	this.hours = hours;
	this.gold = gold;
	this.totalgold = totalgold;
}
public T4_net() {
	super();
}
}
