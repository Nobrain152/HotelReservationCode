package businesslogic.util;

public class EvaluationMsg {
	/**
	 * 评分
	 */
	private int score;

	/**
	 * 评论
	 */
	private String comment;
	
	/**
	 * 是否预定过
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
