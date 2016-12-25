package vo;


import util.RoomState;
import util.RoomType;

/**
 * ������Ϣ
 * @author �ܳ�
 *
 */
public class RoomInfoVO {

	/**
	 * ����״̬
	 */
	private RoomState state;
	
	/**
	 * �����
	 */
	private String roomID;

	/**
	 * ��������
	 */
	private RoomType type;
	
	/**
	 * �۸�
	 */
	private double price;
	
	
	
	/**
	 * ���������ľƵ�ID
	 */
	private String hotelid;
	
	public RoomInfoVO() {}

	public RoomInfoVO(RoomState state, RoomType type, String roomID, double price,String hotelid ) {
		this.state = state;
		this.type = type;
		this.roomID= roomID;
		this.price= price;
		this.hotelid=hotelid;
	}

	public RoomState getState() {
		return state;
	}

	public RoomType getType() {
		return type;
	}
	
	public String getNumber() {
		return roomID;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getRoomID() {
		return roomID;
	}
	
	public String getHotelid(){
		return hotelid;
	}
	
	public void setState(RoomState s){
		state=s;
	}
}	