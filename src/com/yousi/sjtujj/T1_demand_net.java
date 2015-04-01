package com.yousi.sjtujj;

public class T1_demand_net {
private String r_id;
private String gradename;
private String sexname;
private String r_teacher_qualification;
private String r_weaksubjectname;
private String address;
private String additional_subject;
private String half_price;
private String add_price;
private String is_any_people;
private String special_show;
public T1_demand_net() {
	super();
}
public T1_demand_net(String r_id, String gradename, String sexname,
		String r_teacher_qualification, String r_weaksubjectname,
		String address, String additional_subject, String half_price,
		String add_price, String is_any_people, String special_show) {
	super();
	this.r_id = r_id;
	this.gradename = gradename;
	this.sexname = sexname;
	this.r_teacher_qualification = r_teacher_qualification;
	this.r_weaksubjectname = r_weaksubjectname;
	this.address = address;
	this.additional_subject = additional_subject;
	this.half_price = half_price;
	this.add_price = add_price;
	this.is_any_people = is_any_people;
	this.special_show = special_show;
}
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
public String getR_teacher_qualification() {
	return r_teacher_qualification;
}
public void setR_teacher_qualification(String r_teacher_qualification) {
	this.r_teacher_qualification = r_teacher_qualification;
}
public String getR_weaksubjectname() {
	return r_weaksubjectname;
}
public void setR_weaksubjectname(String r_weaksubjectname) {
	this.r_weaksubjectname = r_weaksubjectname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAdditional_subject() {
	return additional_subject;
}
public void setAdditional_subject(String additional_subject) {
	this.additional_subject = additional_subject;
}
public String getHalf_price() {
	return half_price;
}
public void setHalf_price(String half_price) {
	this.half_price = half_price;
}
public String getAdd_price() {
	return add_price;
}
public void setAdd_price(String add_price) {
	this.add_price = add_price;
}
public String getIs_any_people() {
	return is_any_people;
}
public void setIs_any_people(String is_any_people) {
	this.is_any_people = is_any_people;
}
public String getSpecial_show() {
	return special_show;
}
public void setSpecial_show(String special_show) {
	this.special_show = special_show;
}
}
