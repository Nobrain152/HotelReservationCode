package vo;


/**
 * �Ƶ�����
 * @author lenovo
 *
 */
public class HotelEvaluateVO {

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
	
	/**
	 * ����ID
	 */
	private String orderID;

	public HotelEvaluateVO(String username,String hotelname, int score, String comment, boolean reserve, String orderID) {
		this.username=username;
		this.hotelname=hotelname;
		this.score = score;
		this.comment = comment;
		this.reserve=reserve;
		this.orderID = orderID;
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

	public boolean getIsReserved(){
		return reserve;
	}
	
	public String getOrderID() {
		return orderID;
	}
	
}	