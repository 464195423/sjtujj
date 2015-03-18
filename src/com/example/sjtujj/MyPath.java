package com.example.sjtujj;

public class MyPath {
private static String sessionid = "";
public static String getSessionid() {
	return sessionid;
}
public static void setSessionid(String sessionid) {
	MyPath.sessionid = sessionid;
}
public static String url = "http://172.16.3.141:8802/TeacherCenterInterface";
public static String login_path = url + "/teacherlogin";
public static String personal_info_path = url + "/teacherPersonalInformation";
public static String my_demand_path = url + "/teacherMyDemanded";
public static String change_T_S_path = url + "/changeTeacherSearch";
public static String T2_path = url + "/teacherMyDemanded";
}
