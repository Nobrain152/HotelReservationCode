package businesslogic.util;

public class EvaluationMsg {
	/**
	 * ����
	 */
	private int score;

	/**
	 * ����
	 */
	private String comment;
	
	/**
	 * �Ƿ�Ԥ����
	 */
	private boolean reserve;
	
	

	public EvaluationMsg(int score, String comment, boolean reserve) {
		super();
		this.score = score;
		this.comment = comment;
		this.reserve=reserve;
	}

	public int getScore() {
		return score;
	}

	public String getComment() {
		return comment;
	}

	public boolean isReserved(){
		return reserve;
	}
}
