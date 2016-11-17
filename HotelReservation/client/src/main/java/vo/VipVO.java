package vo;

import java.util.ArrayList;

import util.VipType;

public class VipVO {
	
	/**
	 * ��Ա����
	 */
	String name;
	
	/**
	 * vip����
	 */
	VipType type;
	
	/**
	 * ��Ա�ĵȼ�������Ҫ���ֵĶ�Ӧ��ϵ
	 */
	ArrayList<int[][]> levelList;
	
	/**
	 * ��Ա��ǰ�ĵȼ�
	 */
	int level;
	
	
	
	public VipVO(String name,ArrayList<int[][]> levelList,int level,VipType type) {
		// TODO Auto-generated constructor stub
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
