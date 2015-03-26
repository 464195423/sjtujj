package com.example.sjtujj;

public class MyPath {
private static String sessionid = "";
private static String tid = "";
private static String group = "";
private static String school = "";

public static String getSessionid() {
	return sessionid;
}

public static void setSessionid(String sessionid) {
	MyPath.sessionid = sessionid;
}

public static String getTid() {
	return tid;
}

public static void setTid(String tid) {
	MyPath.tid = tid;
}

public static String getGroup() {
	return group;
}

public static void setGroup(String group) {
	MyPath.group = group;
}

public static String getSchool() {
	return school;
}

public static void setSchool(String school) {
	MyPath.school = school;
}

public static String url = "http://172.16.3.141:8802/TeacherCenterInterface";
public static String login_path = url + "/teacherlogin";
public static String personal_info_path = url + "/teacherPersonalInformation";
public static String my_demand_path = url + "/teacherMyDemanded";
public static String change_T_S_path = url + "/changeTeacherSearch";
public static String T2_path = url + "/teacherMyDemanded";
public static String T3_getTeachHours = url + "/getTeachHours";
public static String ddxx_path = url + "/offlineOrderShow";
public static String qushouke_path = url + "/beginToTeach";

/*rid*/
public static String quxiaoshouke_path = url + "/removeTeach";

/*rid,hours*/
public static String updateTeachHours_path = url + "/updateTeachHours";

/*rid*/
public static String getListenTime_path = url + "/getListenTime";

/*rid,listentime*/
public static String updateListentime_path = url + "/updateListentime";

/*rid*/
public static String getOrder_path = url + "/getOrder";

/*rid*/
public static String removeOrder_path = url + "/removeOrder";

/*rid,listentime*/
public static String confirmTeach_path = url + "/confirmTeach";

/*rid,safe_code,[hours]*/
public static String finishedTeach_path = url + "/finishedTeach";

/*rid*/
public static String singleOrderShow_path = url + "/singleOrderShow";

/*tid*/
public static String getNoticeList_path = url + "/getNoticeList";

/*tid*/
public static String getAnnouncementList_path = url + "/getAnnouncementList";
}
