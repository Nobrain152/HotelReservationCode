package po;

import java.io.Serializable;

public class HotelEvaluatePO implements Serializable{



	private static final long serialVersionUID = -7187002330817151504L;
	
	/**
	 * �û���
	 */
	private String username;
	
	/**
	 * �Ƶ���
	 */
	private String hotelname;

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