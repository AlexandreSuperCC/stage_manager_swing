package com.ycaocc.util;

public class StringUtil {

	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str) { //having only &nbsp regards as empty
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("".equals(null));//false
		System.out.println("".equals("   "));//false
		System.out.println("".equals("   ".trim()));
		System.out.println(isNotEmpty("  "));//false
	}
}
