package com.zs.bean;

import java.util.List;

import com.zs.bean.action.BaseActions;
import com.zs.tools.BaseTools;

/**2017-7-8
 * 半人马
 * @author 张顺
 */
public class Centaur extends Unit implements BaseActions{

	public Centaur() {
		super("半人马", 100, 20, 10, 3, 3, UnitType.HEAVY,0,0);
	}


	//得到现在的情况
	public String getNow() {
		return BaseTools.gson.toJson(this);
	}


	@Override
	public Position move(Position position) {
		List<Position> list=getMoveArea();
		for (Position posi : list) {
			if (posi.equals(position)) {
				setX(position.getX());
				setY(position.getY());
				break;
			}
		}
		return new Position(getX(), getY());
	}
	
}
