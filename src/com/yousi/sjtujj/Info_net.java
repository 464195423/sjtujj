package com.yousi.sjtujj;

public class Info_net {
private String id;
private String title;
private String content;
private String status;
private String over;
private String time;
public Info_net() {
	super();
}
public Info_net(String id, String title, String content, String status,
		String over, String time) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.status = status;
	this.over = over;
	this.time = time;
}
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
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getOver() {
	return over;
}
public void setOver(String over) {
	this.over = over;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
}
