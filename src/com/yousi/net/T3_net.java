package com.yousi.net;

public class T3_net {
private String name;
private String picture;
private String gold;
private String totalGold;
private String totalTeachHours;
private String is_search_show;
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
public String getGold() {
	return gold;
}
public void setGold(String gold) {
	this.gold = gold;
}
public String getTotalGold() {
	return totalGold;
}
public void setTotalGold(String totalGold) {
	this.totalGold = totalGold;
}
public String getTotalTeachHours() {
	return totalTeachHours;
}
public void setTotalTeachHours(String totalTeachHours) {
	this.totalTeachHours = totalTeachHours;
}
public String getIs_search_show() {
	return is_search_show;
}
public void setIs_search_show(String is_search_show) {
	this.is_search_show = is_search_show;
}
public T3_net(String name, String picture, String gold, String totalGold,
		String totalTeachHours, String is_search_show) {
	super();
	this.name = name;
	this.picture = picture;
	this.gold = gold;
	this.totalGold = totalGold;
	this.totalTeachHours = totalTeachHours;
	this.is_search_show = is_search_show;
}
public T3_net() {
	super();
}
}
