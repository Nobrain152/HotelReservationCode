package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.VipType;

/**
 * vip���PO
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
