package po;

import java.io.Serializable;
import java.util.ArrayList;

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
	 * �����Ѿ���Ԥ����ʱ���
	 */
	private ArrayList<String> OrderedTime;
	
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
		OrderedTime=new ArrayList<String>();
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
	
	public  ArrayList<String> getOrderedTime(){
		return OrderedTime;
	}
	
	public void setRoomState(RoomState roomState) {
		this.state = roomState;
	}
	
	

}	