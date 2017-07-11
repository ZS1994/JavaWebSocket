package com.zs.actor;

import java.util.ArrayList;
import java.util.List;

/**
 * 2017-7-8
 * 该类是所有单位的基类
 * @author 张顺
 */
public class Unit {

	private String name;//名字
	private long hp;//血量
	private long mp;//蓝量
	private long damage;//攻击
	private long defenses;//防御
	private long move;//移动量
	private String type;//类型
	private long x;//x坐标位置，
	private long y;//x坐标位置，
	
	
	
	public void moveUp(){
		y=y+move;
	}
	public void moveDown(){
		y=y-move;
	}
	public void moveLeft(){
		x=x-move;
	}
	public void moveRight(){
		x=x+move;
	}
	public List<Position> getMoveArea(){
		long xmax=x+move;
		long xmin=x-move;
		long ymax=y+move;
		long ymin=y-move;
		List<Position> list=new ArrayList<>();
		for (long i = ymin; i <= ymax; i++) {
			for (long j = xmin; j <= xmax; j++) {
				long juli=Math.abs(i-y)+Math.abs(j-x); 
				if (juli<=move) {
					list.add(new Position(j, i));
				}
			}
		}
		return list;
	}
	public Position getNowPosition(){
		return new Position(x, y);
	}
	//------------------------
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getHp() {
		return hp;
	}
	public void setHp(long hp) {
		this.hp = hp;
	}
	public long getMp() {
		return mp;
	}
	public void setMp(long mp) {
		this.mp = mp;
	}
	public long getDamage() {
		return damage;
	}
	public void setDamage(long damage) {
		this.damage = damage;
	}
	public long getDefenses() {
		return defenses;
	}
	public void setDefenses(long defenses) {
		this.defenses = defenses;
	}
	public long getMove() {
		return move;
	}
	public void setMove(long move) {
		this.move = move;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Unit() {
		super();
	}
	

	public Unit(String name, long hp, long mp, long damage, long defenses, long move, String type, long x, long y) {
		super();
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.damage = damage;
		this.defenses = defenses;
		this.move = move;
		this.type = type;
		this.x = x;
		this.y = y;
	}


	public static class UnitType{
		public static String HEAVY="heavy";
		public static String EEDIUM="medium";
		public static String LIGHT="light";
	}
	
}
