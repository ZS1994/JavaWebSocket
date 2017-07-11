package com.zs.bean;

import java.util.HashMap;

/**
 * 客户端发送过来的数据封装
 * @author it023
 *
 */
public class Accept {

	private String code;
	private String id;
	private HashMap<String, String> data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public HashMap<String, String> getData() {
		return data;
	}
	public void setData(HashMap<String, String> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Accept [code=" + code + ", id=" + id + ", data=" + data + "]";
	}
	
}
