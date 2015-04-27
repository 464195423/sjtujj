package com.yousi.util;

public class String_unite {
public static String unite(String[] str, char c){
	if (str.length == 0)
		return "";
	String tmp = "";
	for (int i = 0; i < str.length; i++)
		tmp += str[i] + c;
	tmp = tmp.substring(0, tmp.length() - 1);	
	return tmp;
}

public static String unite(String[] str, String c){
	if (str.length == 0)
		return "";
	String tmp = "";
	for (int i = 0; i < str.length; i++)
		tmp += str[i] + c;
	tmp = tmp.substring(0, tmp.length() - c.length());	
	return tmp;
}
}
