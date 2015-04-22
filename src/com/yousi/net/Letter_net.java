package com.yousi.net;

public class Letter_net {
private String id;
private String title;
private String type;
private String time;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public Letter_net(String id, String title, String type, String time) {
	super();
	this.id = id;
	this.title = title;
	this.type = type;
	this.time = time;
}
public Letter_net() {
	super();
}
}
