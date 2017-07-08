package com.zs.bean;

import com.zs.bean.action.BaseActions;
import com.zs.tools.BaseTools;

/**2017-7-8
 * 半人马
 * @author 张顺
 */
public class Centaur extends Unit implements BaseActions{

	public Centaur() {
		super("半人马", 100, 20, 10, 3, 5, UnitType.HEAVY,0,0);
	}

	public String move(String direction) {
		switch (direction) {
		case BaseActions.UP:
			moveUp();
			break;
		case BaseActions.DOWN:
			moveDown();
			break;
		case BaseActions.LEFT:
			moveLeft();
			break;
		case BaseActions.RIGHT:
			moveRight();
			break;
		default:
			break;
		}
		return null;
	}

	//得到现在的情况
	public String getNow() {
		return BaseTools.gson.toJson(this);
	}
	
}
