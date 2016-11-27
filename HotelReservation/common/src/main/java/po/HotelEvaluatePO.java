package po;

import java.io.Serializable;

/**
 * �Ƶ�����
 * @author gyf
 *
 */
public class HotelEvaluatePO implements Serializable{

	
	private static final long serialVersionUID = 1L;

	/**
	 * �û�ID
	 */
	private String userID;
	
	/**
	 * �Ƶ�ID
	 */
	private String hotelID;

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
	
	/**
	 * ����ID
	 */
	private String orderID;

	public HotelEvaluatePO(String userID,String hotelID, int score, String comment, boolean reserve, String orderID) {
		this.userID = userID;
		this.hotelID = hotelID;
		this.score = score;
		this.comment = comment;
		this.reserve = reserve;
		this.orderID = orderID;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public String getHotelID(){
		return hotelID;
	}

	public int getScore() {
		return score;
	}

	public String getComment() {
		return comment;
	}

	public boolean getIsReserved(){
		return reserve;
	}
	
	public String getOrderID() {
		return orderID;
	}
	
}	