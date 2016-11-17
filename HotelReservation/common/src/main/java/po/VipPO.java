package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.VipType;

/**
 * vip相关PO
 * @author kevin
 *
 */

public class VipPO implements Serializable{

	private static final long serialVersionUID = -9083060785710237490L;
	
	
	public VipPO(String name, ArrayList<int[][]> levelList,int level, String type,VipType type1) {
		// TODO Auto-generated constructor stub
		this.levelList = levelList;
		this.level = level;
		this.name = name;
		this.type = type1;
	}
	
	/**
	 * 会员姓名
	 */
	String name;
	
	/**
	 * vip种类
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
