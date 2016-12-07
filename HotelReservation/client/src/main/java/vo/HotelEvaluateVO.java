package vo;


/**
 * �Ƶ�����
 * @author gyf
 *
 */
public class HotelEvaluateVO {

	/**
	 * �û�ID
	 */
	private String userID;
	
	/**
	 * �Ƶ�ID
	 */
	private String hotelID;

	/**
	 * ����1-10
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
	
	public HotelEvaluateVO() {}

	public HotelEvaluateVO(String userID,String hotelID, int score, String comment, boolean reserve, String orderID) {
		this.userID=userID;
		this.hotelID=hotelID;
		this.score = score;
		this.comment = comment;
		this.reserve=reserve;
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