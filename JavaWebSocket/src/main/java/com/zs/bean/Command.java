package com.zs.bean;

/**
 * 张顺，2017-7-11
 * 命令类，作为scoket返回消息体的封装
 * @author it023
 *
 */
public class Command {

	public static String MOVE="move";
	public static String MOVEAREA="movearea";
	public static String NOW_POSITION="nowPosition";
	
	public static String TEXT="/text";//文本
	
	
	private String code;//命令吗
	private Object data;//数据
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public Command(String code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}
	public Command() {
		super();
	}
	
	
	
}
