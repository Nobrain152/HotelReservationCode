package po;

import java.io.Serializable;

public class LevelSystemPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ȼ�
	 */
	int[] levels;
	
	/**
	 * ��Ӧ�ȼ�����Ҫ������ֵ
	 */
	int[] credits;
	
	public LevelSystemPO(int[] levels, int[] credits) {
		this.levels = levels;
		this.credits = credits;
	}
	
	public int[] getLevels() {
		return levels;
	}
	
	public int[] getCredits() {
		return credits;
	}
	
	public void setLevels(int[] levels) {
		this.levels = levels;
	}
	
	public void setCredits(int[] credits) {
		this.credits = credits;
	}

}
