package com.yousi.net;

public class Xxxq_net {
private String type;
private String title;
private String content;
private String time;
public Xxxq_net(String type, String title, String content, String time) {
	super();
	this.type = type;
	this.title = title;
	this.content = content;
	this.time = time;
}

public Xxxq_net() {
	super();
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
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

}
