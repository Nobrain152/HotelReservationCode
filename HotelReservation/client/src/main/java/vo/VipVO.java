package vo;

import java.util.ArrayList;

import util.VipType;

/**
 * 会员信息
 * @author lenovo
 *
 */
public class VipVO {
	
	/**
	 * 会员姓名
	 */
	String name;
	
	/**
	 * 会员种类
	 */
	VipType type;
	
	/**
	 * 会员的等级与所需要积分的对应关系
	 */
	ArrayList<int[][]> levelList;
	
	/**
	 * 会员当前的等级
	 */
	int level;
	
	public VipVO(String name,ArrayList<int[][]> levelList,int level,VipType type) {
		this.levelList = levelList;
		this.level = level;
		this.name = name;
		this.type = type;
	}
	
	public ArrayList<int[][]> getLevelList() {
		return levelList;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public VipType getType() {
		return type;
	}
	
}
