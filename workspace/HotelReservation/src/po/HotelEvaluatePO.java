package po;

import java.io.Serializable;

public class HotelEvaluatePO implements Serializable{



	private static final long serialVersionUID = -7187002330817151504L;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 酒店名
	 */
	private String hotelname;

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
	
	

	public HotelEvaluatePO(String username,String hotelname, int score, String comment, boolean reserve) {
		this.username=username;
		this.hotelname=hotelname;
		this.score = score;
		this.comment = comment;
		this.reserve=reserve;
	}
	
	public String getUserName(){
		return username;
	}
	
	public String getHotelName(){
		return hotelname;
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