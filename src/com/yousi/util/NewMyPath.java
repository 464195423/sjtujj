package com.yousi.util;

public class NewMyPath {
private static String url = "http://172.16.3.141:8804/TeacherCenterInterface/";

/*name, pwd*/
public static String login_path = url + "login";

/*[before, after, grade, subject, order]*/
public static String demand_path = url + "demand";

/*rid*/
public static String orderShow_path = url + "orderShow";

/*rid*/
public static String getOrder_path = url + "getOrder";

/*type*/
public static String order_path = url + "order";

/*rid*/
public static String removeOrder_path = url + "removeOrder";

/*rid*/
public static String refuseOrder_path = url + "refuseOrder";

/*rid, listentime*/
public static String confirmTeach_path = url + "confirmTeach";

/*rid, hour*/
public static String beginToTeach_path = url + "beginToTeach";

/*rid*/
public static String giveupOrder_path = url + "giveupOrder";

/*type*/
public static String course_path = url + "course";

/*rid*/
public static String showOrder_path = url + "showOrder";

/*rid*/
public static String removeTeach_path = url + "removeTeach";

/*rid, hours*/
public static String updateTeachHours_path = url + "updateTeachHours";

/*rid*/
public static String revokeOrder_path = url + "revokeOrder";

/*rid, [hours], safe_code*/
public static String finishedTeach_path = url + "finishedTeach";

/*null*/
public static String personalCenter_path = url + "personalCenter";

/*content*/
public static String makeUserFeedback_path = url + "makeUserFeedback";

/*null*/
public static String quit_path = url + "quit";

/*before, after*/
public static String personalLetters_path = url + "personalLetters";

/*id*/
public static String personalLettersInfo_path = url + "personalLettersInfo";

/*null*/
public static String personalSet_path = url + "personalSet";

/*searchShow*/
public static String changeTeacherSearch_path = url + "changeTeacherSearch";

/*null*/
public static String applyinfo_path = url + "applyinfo";

/*id*/
public static String applylist_path = url + "applylist";
}
