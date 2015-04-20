package com.yousi.net;

public class Classlist {
private String h_id;
private String h_hours;
private String h_create_date;
private String h_end_time;
private String a_status;
private String h_status;
public Classlist() {
	super();
}
public Classlist(String h_id, String h_hours, String h_create_date,
		String h_end_time, String a_status, String h_status) {
	super();
	this.h_id = h_id;
	this.h_hours = h_hours;
	this.h_create_date = h_create_date;
	this.h_end_time = h_end_time;
	this.a_status = a_status;
	this.h_status = h_status;
}
public String getH_status() {
	return h_status;
}
public void setH_status(String h_status) {
	this.h_status = h_status;
}
public String getH_id() {
	return h_id;
}
public void setH_id(String h_id) {
	this.h_id = h_id;
}
public String getH_hours() {
	return h_hours;
}
public void setH_hours(String h_hours) {
	this.h_hours = h_hours;
}
public String getH_create_date() {
	return h_create_date;
}
public void setH_create_date(String h_create_date) {
	this.h_create_date = h_create_date;
}
public String getH_end_time() {
	return h_end_time;
}
public void setH_end_time(String h_end_time) {
	this.h_end_time = h_end_time;
}
public String getA_status() {
	return a_status;
}
public void setA_status(String a_status) {
	this.a_status = a_status;
}
}
