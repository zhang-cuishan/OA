package com.shizongger.oa.util;

/**
 * 常用的方法
 * @author shizongger
 * @date 2017/03/31
 */
public class Common {

	/**
	 * 判断字符串是否为空
	 * @param str 字符串
	 * @return 是否为空
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isChecked() {
		System.out.println("++++++++++++++++++++++++++++++++++");
		
		return true;
	}
}
