package com.haibei.util.string;

public class StringUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String ArrayToString(String[] paramArray) {

		if (paramArray == null || paramArray.length == 0) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			for (String st : paramArray) {
				sb.append(st);
			}
			return sb.toString();
		}
		
	}
}