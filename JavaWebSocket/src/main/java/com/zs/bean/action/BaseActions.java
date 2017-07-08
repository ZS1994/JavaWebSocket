package com.zs.bean.action;

/**2017-7-8
 * 一些基本动作
 * @author 张顺
 */
public interface BaseActions {

	public static String UP="UP";
	public static String DOWN="DOWN";
	public static String LEFT="LEFT";
	public static String RIGHT="RIGHT";
	
	public String move(String direction);
	
}
