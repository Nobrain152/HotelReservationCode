package vo;

public class LevelSystemVO {
	
	/**
	 * �ȼ�
	 */
	int levels;
	
	/**
	 * ��Ӧ�ȼ�����Ҫ������ֵ
	 */
	int credits;
	
	public LevelSystemVO() {}
	
	public LevelSystemVO(int levels, int credits) {
		this.levels = levels;
		this.credits = credits;
	}
	
	public int getLevels() {
		return levels;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setLevels(int levels) {
		this.levels = levels;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
}
