package com.yousi.net;

public class Nddxx_net {
private String r_id;
private String createtime;
private String s_sexname;
private String s_gradename;
private String address;
private String coordinate;
private String t_sexname;
private String[] weaksubject;
private Special[] special;
private String people_count;
private String qualification;
private String grade_price;
private String add_price;
private String one_price;
public String getR_id() {
	return r_id;
}
public void setR_id(String r_id) {
	this.r_id = r_id;
}
public String getCreatetime() {
	return createtime;
}
public void setCreatetime(String createtime) {
	this.createtime = createtime;
}
public String getS_sexname() {
	return s_sexname;
}
public void setS_sexname(String s_sexname) {
	this.s_sexname = s_sexname;
}
public String getS_gradename() {
	return s_gradename;
}
public void setS_gradename(String s_gradename) {
	this.s_gradename = s_gradename;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCoordinate() {
	return coordinate;
}
public void setCoordinate(String coordinate) {
	this.coordinate = coordinate;
}
public String getT_sexname() {
	return t_sexname;
}
public void setT_sexname(String t_sexname) {
	this.t_sexname = t_sexname;
}
public String[] getWeaksubject() {
	return weaksubject;
}
public void setWeaksubject(String[] weaksubject) {
	this.weaksubject = weaksubject;
}
public Special[] getSpecial() {
	return special;
}
public void setSpecial(Special[] special) {
	this.special = special;
}
public String getPeople_count() {
	return people_count;
}
public void setPeople_count(String people_count) {
	this.people_count = people_count;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getGrade_price() {
	return grade_price;
}
public void setGrade_price(String grade_price) {
	this.grade_price = grade_price;
}
public String getAdd_price() {
	return add_price;
}
public void setAdd_price(String add_price) {
	this.add_price = add_price;
}
public String getOne_price() {
	return one_price;
}
public void setOne_price(String one_price) {
	this.one_price = one_price;
}
public Nddxx_net(String r_id, String createtime, String s_sexname,
		String s_gradename, String address, String coordinate,
		String t_sexname, String[] weaksubject, Special[] special,
		String people_count, String qualification, String grade_price,
		String add_price, String one_price) {
	super();
	this.r_id = r_id;
	this.createtime = createtime;
	this.s_sexname = s_sexname;
	this.s_gradename = s_gradename;
	this.address = address;
	this.coordinate = coordinate;
	this.t_sexname = t_sexname;
	this.weaksubject = weaksubject;
	this.special = special;
	this.people_count = people_count;
	this.qualification = qualification;
	this.grade_price = grade_price;
	this.add_price = add_price;
	this.one_price = one_price;
}
public Nddxx_net() {
	super();
}

}
