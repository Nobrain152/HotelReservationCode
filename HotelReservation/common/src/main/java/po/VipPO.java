package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.VipType;

/**
 * ��Ա��Ϣ
 * @author lenovo
 *
 */
public class VipPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��Ա����
	 */
	String name;
	
	/**
	 * ��Ա����
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
	
	public VipPO(String name,ArrayList<int[][]> levelList,int level,VipType type) {
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
