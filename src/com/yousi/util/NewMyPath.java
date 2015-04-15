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

}
