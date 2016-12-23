package po;

import java.io.Serializable;


import util.RoomState;
import util.RoomType;

/**
 * ������Ϣ
 * @author �ܳ�
 *
 */
public class RoomInfoPO implements Serializable{

	
	private static final long serialVersionUID = 1L;

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
	
	public RoomInfoPO() {}

	public RoomInfoPO(RoomState state, RoomType type, String roomID, double price ,String hotelid) {
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
	
	public String getHotelid(){
		return hotelid;
	}
	
	public String getRoomID() {
		return roomID;
	}
	
	
	public void setRoomState(RoomState roomState) {
		this.state = roomState;
	}
	
	

}	