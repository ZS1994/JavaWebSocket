package com.zs.bean;

public class Position {
	private long x;
	private long y;
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}
	public Position(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Position() {
		super();
	}
	
}